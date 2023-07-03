package com.duan.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.http_utils;


@WebServlet(urlPatterns= {"/api_bang_nguoidung"})
public class bang_nguoidung_api extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private bang_nguoidung_interface_service i_nguoidung_sv;
   
    public bang_nguoidung_api() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		bang_nguoidung_model nguoidung =http_utils.of(request.getReader()).toModel(bang_nguoidung_model.class);
		nguoidung=i_nguoidung_sv.themnguoidung_service(nguoidung);
		mapper.writeValue(response.getOutputStream(), nguoidung);
		
		
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		bang_nguoidung_model nguoidung =http_utils.of(request.getReader()).toModel(bang_nguoidung_model.class);
		nguoidung=i_nguoidung_sv.capnhatnguoidung_service(nguoidung);
		mapper.writeValue(response.getOutputStream(), nguoidung);
		
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		bang_nguoidung_model nguoidung =http_utils.of(request.getReader()).toModel(bang_nguoidung_model.class);
		i_nguoidung_sv.xoanguoidung_service(nguoidung.getMaNguoiDungs());
		mapper.writeValue(response.getOutputStream(), "{}");
		
	}
	private void themvacapnhat()
	{
		
	}

}
