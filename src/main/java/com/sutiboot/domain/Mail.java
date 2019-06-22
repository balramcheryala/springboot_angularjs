package com.sutiboot.domain;

/**
 * @author Ayyappan
 *
 */
public class Mail {

	private String to = null;
	private String subject = null;
	private String text = null;

	public final String getTo() {
		return to;
	}

	public final String getSubject() {
		return subject;
	}

	public final String getText() {
		return text;
	}

	public void setTo(final String to) {
		this.to = to;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public void setText(final String text) {
		this.text = text;
	}
}
