package com.poly.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
	
	@Autowired
	HttpServletRequest request;
	
	//doc chuoi gia tri cua tham so
	//@param name ten cua tham so
	//@param defaultValue gia tri mac dinh
	//@return gia tri tham so hoac gia tri mac dinh neu khong ton tai
	
	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;
	}
	
	//doc so nguyen gia tri cua tham so
	//@param name ten tham so
	//@param defaultvalue gia tri mac dinh
	//@return gia tri tham so hoac gia tri mac dinh neu khong ton tai
	
	public int getInt(String name, int defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Integer.parseInt(value);
	}
		
		
	//doc so thuc gia tri cua tham so
	//@param name ten tham so
	//@param defaultvalue gia tri mac dinh
	//@return gia tri tham so hoac gia tri mac dinh neu khong ton tai
					
	public double getDouble(String name, double defaultvalue) {
		String value = getString(name, String.valueOf(defaultvalue));
		return Double.parseDouble(value);
	}
	
	//doc so nguyen gia tri cua tham so
		//@param name ten tham so
		//@param defaultvalue gia tri mac dinh
		//@return gia tri tham so hoac gia tri mac dinh neu khong ton tai
		
		public boolean getBoolean(String name, boolean defaultValue) {
			String value = getString(name, String.valueOf(defaultValue));
			return Boolean.parseBoolean(value);
					}
			
			
		//doc gia tri thoi gian cua tham so
		//@param name ten tham so
		//@param defaultvalue gia tri mac dinh
		//@return gia tri tham so hoac gia tri mac dinh neu khong ton tai
						
		public Date getDate(String name, String pattern) {
			String value = getString(name, "");
			try {
				return new SimpleDateFormat(pattern).parse(value);
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		
		}
		
				//luu file upload vao thu muc
				//@param file chua file upload tu client
				//@param path duong dan tinh tu webroot
				//@return doi tuong chua file da lu hoac null neu khong cos file upload
				//@throws runtimeException loi luu file
		
		public File save(MultipartFile file, String path) {
			if (!file.isEmpty()) {
				File dir = new File(request.getServletContext().getRealPath(path));
				if(!dir.exists()) {
					dir.mkdirs();
				}
				try {
					File savedFile = new File(dir, file.getOriginalFilename());
					file.transferTo(savedFile);
					return savedFile;
				} catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException(e);
				}
			}
				return null;
			
		}
	

}
