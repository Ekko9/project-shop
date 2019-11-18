package com.user.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

	public static Cookie findCookie(Cookie[] cookies, String str) {
		if(cookies==null){//如果这个网站从来没有被当前用户特定的浏览器访问过 返回null
			return null;
		} else{
			//通过循环对比 找到 key为 str
			for (Cookie cookie : cookies) {
				
				if(str.equals(cookie.getName())){
					
					return cookie ;  //遍历到了我们需要的cookie返回去
				}
				
			}
			
			return null;  
		}
	
	}

}
