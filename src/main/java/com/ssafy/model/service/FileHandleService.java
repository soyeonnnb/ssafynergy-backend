package com.ssafy.model.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileHandleService {
	public String saveFile(MultipartFile multipartFile) throws IOException;
}
