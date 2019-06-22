package com.sutiboot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class FileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileUpload(String filename, byte[] file, String mimeType) {

		this.file = file;
		this.filename = filename;
		this.mimeType = mimeType;
	}

	public FileUpload() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fileNumber;

	@Column
	private String filename;

	@Lob
	private byte[] file;

	@Column
	private String mimeType;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Long getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(Long fileNumber) {
		this.fileNumber = fileNumber;
	}

}