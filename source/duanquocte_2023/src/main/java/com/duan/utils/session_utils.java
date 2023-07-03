package com.duan.utils;

import javax.servlet.http.HttpServletRequest;

public class session_utils {
	 private static session_utils session_utils = null;

	    public static session_utils getInstance() {
	        if (session_utils == null) {
	            session_utils = new session_utils();
	        }
	        return session_utils;
	    }

	    public void putValue(HttpServletRequest request, String key, Object value) {
	        request.getSession().setAttribute(key, value);
	    }

	    public Object getValue(HttpServletRequest request, String key) {
	        return request.getSession().getAttribute(key);
	    }

	    public void removeValue(HttpServletRequest request, String key) {
	        request.getSession().removeAttribute(key);
	    }
}
