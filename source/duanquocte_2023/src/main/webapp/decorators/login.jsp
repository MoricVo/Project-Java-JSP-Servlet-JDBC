<%@ page language="java" contentType="text/html; charset=UTF-8"
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
         <link rel="shortcut icon" href="${pageContext.request.contextPath}/template/intro_template/assets/img/logo.png" type="image/x-icon">
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

    <!-- Page CSS -->
    <!-- Page -->
    <link rel="stylesheet" href="<c:url value='/template/ad_template_new/assets/vendor/css/pages/page-auth.css'/>"/>
    <!-- Helpers -->
   	
		<script
			src="<c:url value='/template/ad_template_new/assets/vendor/js/helpers.js'/>"></script>
		<script src="<c:url value='/template/ad_template_new/assets/js/config.js'/>"></script>
  </head>

  <body>
    <!-- Content -->

    <div class="container-xxl">
      <div class="authentication-wrapper authentication-basic container-p-y">
        <div class="authentication-inner">
          <!-- Register -->
            <dec:body></dec:body>
          <!-- /Register -->
        </div>
        
      </div>
      
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







<%-- <html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
     <link rel="stylesheet" href="<c:url value='/template/ad_template/assets/vendors/mdi/css/materialdesignicons.min.css' />" />

     <link rel="stylesheet" href="<c:url value='/template/ad_template/assets/vendors/css/vendor.bundle.base.css' />" />
    
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
     <link rel="stylesheet" href="<c:url value='/template/ad_template/assets/css/style.css' />" />
    
   
    <!-- End layout styles -->
        <link rel="stylesheet" href="<c:url value='/template/ad_template/assets/images/favicon.png' />" />

  </head>
  <body>
        <dec:body></dec:body>
    <!-- container-scroller -->
    <!-- plugins:js -->
         <script src="<c:url value='/template/ad_template/assets/vendors/js/vendor.bundle.base.js' />"></script>

    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
     <script src="<c:url value='/template/ad_template/assets/js/off-canvas.js' />"></script>
     <script src="<c:url value='/template/ad_template/assets/js/hoverable-collapse.js' />"></script>
    <script src="<c:url value='/template/ad_template/assets/js/misc.js' />"></script>
    <script src="<c:url value='/template/ad_template/assets/js/settings.js' />"></script>
   <script src="<c:url value='/template/ad_template/assets/js/todolist.js' />"></script>
   
    <!-- endinject -->
  </body>
</html> --%>