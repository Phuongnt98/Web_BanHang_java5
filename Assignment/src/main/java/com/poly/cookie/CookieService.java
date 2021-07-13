package com.poly.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
@Service
public class CookieService {
	
	public static Cookie add(String name, String value, int hours, HttpServletResponse resp) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours*60*60);
		cookie.setPath("/");
		resp.addCookie(cookie);
		return cookie;
	}
	
	public static String get(String name, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies) { 
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				} 
			}
		}
		return "";
	}
	
}
