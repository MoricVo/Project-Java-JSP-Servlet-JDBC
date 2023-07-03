<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
       <link rel="shortcut icon" href="${pageContext.request.contextPath}/template/intro_template/assets/img/logo.png" type="image/x-icon">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Phòng quan hệ đối ngoại</title>
        
          
         <link rel="stylesheet" type="image/x-icon"
			href="<c:url value='/template/intro_template/assets/favicon.ico'/>" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link rel="preconnect" href="https://fonts.gstatic.com" />
        <link href="https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&amp;display=swap" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&amp;display=swap" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
      
        
         <link rel="stylesheet" type="text/css"
			href="<c:url value='/template/intro_template/css/styles.css'/>"  />
			  
			<style type="text/css">
			
			.logo-wrapper {
			 position: absolute;
                top: 0;
                left: 0;
			}
			</style>
    </head>
    <body>



        <!-- Background Video-->
       
        <video class="bg-video" playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop"><source src="${pageContext.request.contextPath}/template/intro_template/assets/mp4/MyVideo.mp4" type="video/mp4" /></video>
        <!-- Masthead-->
        <div class="masthead">
            <div class="logo-wrapper" >
            <img width="340" style="padding-top:20px;"
								class="d-inline-block" alt=""
								src="https://www.agu.edu.vn/assets/frontend/images/logo_vi.png">
						<!-- 	<img width="100" height="80" style="border-radius: 50%;"
								class="d-inline-block" alt=""
								src="https://inkythuatso.com/uploads/images/2021/12/logo-truong-dai-hoc-an-giang-inkythuatso-01-22-14-03-31.jpg"> -->
            </div>
            <dec:body></dec:body>
        </div>
        <!-- Social Icons-->
        <!-- For more icon options, visit https://fontawesome.com/icons?d=gallery&p=2&s=brands-->
        <div class="social-icons">
            <div class="d-flex flex-row flex-lg-column justify-content-center align-items-center h-100 mt-3 mt-lg-0">
                <a class="btn btn-dark m-3" href="https://exro.agu.edu.vn/"><i class="fa-solid fa-globe"></i></a>
                 <a class="btn btn-dark m-3" href="https://www.agu.edu.vn/vi"><i class="fa-solid fa-building"></i></a>
                <a class="btn btn-dark m-3" href="#!"><i class="fab fa-facebook-f"></i></a>
               
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
    
        <script
		src="<c:url value='/template/intro_template/js/scripts.js'/>"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
 -->
<!-- beautify ignore:start -->
<html
  lang="en"
  class="light-style customizer-hide"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="../assets/"
  data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Đăng nhập vào hệ thống</title>
   
    <meta name="description" content="" />

    <!-- Favicon -->
   <link rel="stylesheet" type="text/css"
			href="<c:url value='/template/ad_template_new/assets/img/favicon/favicon.ico'/>" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
   <link rel="stylesheet" type="text/css"
			href="<c:url value='/template/ad_template_new/assets/vendor/fonts/boxicons.css'/>" />

    <!-- Core CSS -->
   	<link rel="stylesheet" type="text/css"
			href="<c:url value='/template/ad_template_new/assets/vendor/css/core.css'/>" class="template-customizer-core-css" />
		<link rel="stylesheet" type="text/css"
			href="<c:url value='/template/ad_template_new/assets/vendor/css/theme-default.css'/>" class="template-customizer-theme-css" />
		<link rel="stylesheet" type="text/css"
			href="<c:url value='/template/ad_template_new/assets/css/demo.css'/>" />

    <!-- Vendors CSS -->
   <link rel="stylesheet" type="text/css"
			href="<c:url value='/template/ad_template_new/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css'/>" />
    <link rel="stylesheet" href="<c:url value='/template/ad_template_new/assets/vendor/css/pages/page-misc.css'/>" />
    <!-- Page CSS -->
    <!-- Page -->
    <link rel="stylesheet" href="<c:url value='/template/ad_template_new/assets/vendor/css/pages/page-auth.css'/>"/>
    <!-- Helpers -->
		<script
			src="<c:url value='/template/ad_template_new/assets/vendor/js/helpers.js'/>"></script>
		<script src="<c:url value='/template/ad_template_new/assets/js/config.js'/>"></script>
	<style type="text/css">
			
			 body {
		  height: 100%;
		  <c:url value="/template/ad_template_new/img_intro/poster.png" var="imageUrl" />
		 background-image:url('${imageUrl}');
		  background-repeat: no-repeat;
		  background-position: center bottom;
		  background-size: cover;
		}
		
		/* Để phân nửa trên của thẻ body là màu nền */
		body::before {
		  content: "";
		  position: absolute;
		  top: 0;
		  left: 0;
		  width: 100%;
		  height: 50%;
		 background: linear-gradient(135deg,#bc4e9c, #f80759);
		  z-index: -1;
		}
	</style>
  </head>
  
  <body>
    <!-- Content -->

     <!--Under Maintenance -->
    <div class="container-xxl container-p-y">
      <dec:body></dec:body>
    </div>
     
                <footer class="footer bg-light">
                  <div
                    class="container-fluid d-flex flex-md-row flex-column justify-content-between align-items-md-center gap-1 container-p-x py-3"
                  >
                    <div>
                      <a
                        href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/landing/"
                        target="_blank"
                        class="footer-text fw-bolder"
                        >Phòng quan hệ đối ngoại</a
                      >
                      ©
                    </div>
                    <div>
                      <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">Địa chỉ</a>
                      <a href="javascript:void(0)" class="footer-link me-4">Hổ trợ</a>
                      <a href="javascript:void(0)" class="footer-link me-4">Liên hệ</a>
                      <a  href='<c:url value="/dang-ky-taikhoan-quantri?action=dangky_taikhoan_quantri'"/>' class="footer-link">Đăng ký tài khoản quản trị</a>
                    </div>
                  </div>
                </footer>
    <!-- / Content -->



    <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
   <script
		src="<c:url value='/template/ad_template_new/assets/vendor/libs/jquery/jquery.js'/>"></script>
	<script
		src="<c:url value='/template/ad_template_new/assets/vendor/libs/popper/popper.js'/>"></script>
	<script
		src="<c:url value='/template/ad_template_new/assets/vendor/js/bootstrap.js'/>"></script>
	<script
		src="<c:url value='/template/ad_template_new/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js'/>"></script>

  <script src="<c:url value='/template/ad_template_new/assets/vendor/js/menu.js'/>"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->

    <!-- Main JS -->
   <script src="<c:url value='/template/ad_template_new/assets/js/main.js'/>"></script>

    <!-- Page JS -->

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
  </body>
</html>


 --%>