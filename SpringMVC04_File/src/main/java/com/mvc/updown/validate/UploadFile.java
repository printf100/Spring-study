package com.mvc.updown.validate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	private String name;
	private String desc;
	private MultipartFile mpfile;	// 파일에 대한 정보(파일 이름, 크기등)와 파일 관련 메서드(ex. 파일 저장)를 제공

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MultipartFile getMpfile() {
		return mpfile;
	}

	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}
}
