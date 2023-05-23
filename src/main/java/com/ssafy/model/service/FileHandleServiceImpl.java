package com.ssafy.model.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//package com.ssafy.model.service;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//
@Service
public class FileHandleServiceImpl implements FileHandleService {

	@Override
	public String saveFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
//
//	private AmazonS3 amazonS3;
//
//	@Autowired
//	private Environment env;
//
//	@Override
//	public String saveFile(MultipartFile multipartFile) throws IOException {
//		String originalFilename = System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename();
//
//		ObjectMetadata metadata = new ObjectMetadata();
//		metadata.setContentLength(multipartFile.getSize());
//		metadata.setContentType(multipartFile.getContentType());
//		amazonS3.putObject(new PutObjectRequest(env.getProperty("AWS_BUCKET_NAME"), originalFilename,
//				multipartFile.getInputStream(), metadata).withCannedAcl(CannedAccessControlList.PublicRead));
//		return amazonS3.getUrl(env.getProperty("AWS_BUCKET_NAME"), originalFilename).toString();
//	}
//
//}
