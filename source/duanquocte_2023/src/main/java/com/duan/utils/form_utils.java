package com.duan.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;



public class form_utils {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T>tClass1,HttpServletRequest request)
	{
		T object =null;
		try {
			object=tClass1.newInstance();
			BeanUtils.populate(object,request.getParameterMap());
		} catch (InstantiationException |IllegalAccessException |InvocationTargetException e) {
		System.out.print(e.getMessage());
		} 
		return object;
		
	}
}
