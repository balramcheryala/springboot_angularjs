package com.sutiboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.sutiboot.domain.Mail;
import com.sutiboot.domain.Person;
import com.sutiboot.service.EmailService;
import com.sutiboot.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    
    @Autowired
    private EmailService emailService;


    @GetMapping(value = {"/","index"})
    public ModelAndView index(Model model){
        System.out.println(personService.findAll());
        model.addAttribute("persons", personService.findAll());
        return new ModelAndView("index");
    }

    @GetMapping(value = "create")
    public String create(){
        return "create";
    }

    @PostMapping(value = "save")
    public String save(@RequestBody Person person){
        personService.save(person);
        return "success";
    }

    @GetMapping(value = "edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("person",personService.findById(id));
        return "edit";
    }
    
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id, Model model){
    	personService.delete(id);
    	model.addAttribute("msg","Deleted Successfully");
        return "redirect:/";
    }
    @PostMapping(value = "update")
    public String update(@RequestBody Person person){
        personService.save(person);
        return "redirect:/";
    }
    
    /**
	 * @param mail
	 * @param attachFiles
	 * @return
	 * @throws MessagingException
	 */
	@PostMapping(value = "sendmail")
	public ModelAndView testingPurpose(@ModelAttribute Mail mail, final @RequestParam MultipartFile[] attachFiles, Model model){
		try {
			if(attachFiles != null) {
				emailService.sendMail(mail, attachFiles);
			}else {
				emailService.sendMail(mail);
			}
			model.addAttribute("msgstatus","Mail Sent Scuccessfully");
		} catch (Exception ex) {
			return new ModelAndView("redirect:/#/mail");
		}
		return new ModelAndView("redirect:/#/mail");
	}
	
	/**
	 * @param message
	 * @return
	 */
	public ModelAndView uiResponseEntity(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("$MSG_TYPE", "JAVA_MAIL_NOTIFICATION");
		map.put("$MSG", message);
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		return new ModelAndView(jsonView, map);
	}
	

 }
