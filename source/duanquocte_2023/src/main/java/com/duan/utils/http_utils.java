package com.duan.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import org.codehaus.jackson.map.ObjectMapper;


public class http_utils  {
	private String value;
	public http_utils(String value)
	{
		this.value=value;
	}
	public <T> T toModel(Class<T>tClass)
	{
		try
		{
			return new ObjectMapper().readValue(value, tClass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public static http_utils of (BufferedReader reader)
	{
		StringBuffer JSON =new StringBuffer();
		try
		{
			
			String line;
			while((line=reader.readLine())!= null)
			{
				JSON.append(line);
			}
			
		}
		catch(IOException e)
		{
			System.out.print(e.getMessage());
		}		
		return new http_utils(JSON.toString());
	}

	
}
