package com.deloitte.portal.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.portal.model.EmpImg;
import com.deloitte.portal.repository.EmpImgRepo;

@Service
public class EmpImgServiceImpl implements EmpImgService{
	
	@Autowired
	private EmpImgRepo imgRepo;

	@Override
	public EmpImg uploadImg(MultipartFile file) {
		EmpImg image= new EmpImg();
		InputStream f1= file.getInputStream();
		//FileImageInputStream f1= new FileImageInputStream(file);
		image.setImg_name(file.getName());
		try {
			image.setImg(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgRepo.save(image);
	}

	@Override
	public byte[] getImg(int id) {
		EmpImg image=imgRepo.getImgById(id);
		return image.getImg();
	}

}
