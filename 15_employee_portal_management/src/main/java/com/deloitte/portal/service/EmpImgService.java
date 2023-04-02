package com.deloitte.portal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.portal.model.EmpImg;

public interface EmpImgService {

	EmpImg uploadImg(MultipartFile file);

	byte[] getImg(int id);
}
