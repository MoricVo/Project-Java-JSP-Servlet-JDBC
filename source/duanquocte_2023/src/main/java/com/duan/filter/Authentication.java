package com.duan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.System_Constant;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.session_utils;

public class Authentication implements Filter {
    private ServletContext context;
	

	@Override
	public void doFilter(ServletRequest servlet_request, ServletResponse servlet_response, FilterChain filter_chain)
			throws IOException, ServletException {
		  HttpServletRequest request = (HttpServletRequest) servlet_request;
	        HttpServletResponse response = (HttpServletResponse) servlet_response;
	        String url = request.getRequestURI();
	        if(url.startsWith(request.getContextPath()+"/admin")) {
	            bang_nguoidung_model nguoidung = (bang_nguoidung_model) session_utils.getInstance().getValue(request,"USERMODEL");
	            if (nguoidung != null) {
	                if (nguoidung.getQuyenHan().equals(System_Constant.ADMIN)&&nguoidung.getTrangThaiXacThuc().equals(true)||nguoidung.getQuyenHan().equals(System_Constant.USER)&&nguoidung.getTrangThaiXacThuc().equals(true)||nguoidung.getQuyenHan().equals(System_Constant.MANAGER)&&nguoidung.getTrangThaiXacThuc().equals(true)) {
	                	filter_chain.doFilter(servlet_request, servlet_response);
	                } 
	               /* if(nguoidung.getTrangThaiXacThuc().equals(true)||nguoidung.getQuyenHan().equals(System_Constant.USER))
	                {
	                	if(url.startsWith(request.getContextPath()+"/admin_laytoanbodanhsach_duan_dangtrienkhai?action=danhsach_duan_dangtrienkhai"))
	                	{
	                		 response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
	                	}
	                }*/
	            } else {
	            	 response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
	            }
	        } else {
	        	filter_chain.doFilter(servlet_request, servlet_response);
	        }
		
	}

	@Override
	public void init(FilterConfig filter_config) throws ServletException {
		this.context = filter_config.getServletContext();
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
