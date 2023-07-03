<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

   <div class="masthead-content text-white">
                <div class="container-fluid px-4 px-lg-0">
                    <h1 class="fst-italic lh-1 mb-4">Phòng Quan hệ đối ngoại</h1>
                    <p class="mb-5">Chào mừng bạn đến với hệ thống quản lý dự án quốc tế thuộc trường đại học An Giang!</p>
                    <p class="mb-5">Vui lòng nhấn tiếp tục để truy cập.</p>
                    <!-- * * * * * * * * * * * * * * *-->
                    <!-- * * SB Forms Contact Form * *-->
                    <!-- * * * * * * * * * * * * * * *-->
                    <!-- This form is pre-integrated with SB Forms.-->
                    <!-- To make this form functional, sign up at-->
                    <!-- https://startbootstrap.com/solution/contact-forms-->
                    <!-- to get an API token!-->
                 
                        <!-- Email address input-->
                        <div class="row input-group-newsletter">
                          
                          <div class="col-auto">
							  <a href='<c:url value="/dang-nhap?action=login"/>' type="button" class="btn btn-primary" id="submitButton" style="width:300px;height:50px; line-height: 40px; text-align: center;font-weight:600;">
							    Nhấn để tiếp tục!
							  </a>
							</div>
                        </div>
                        <div class="invalid-feedback mt-2" data-sb-feedback="email:required">An email is required.</div>
                        <div class="invalid-feedback mt-2" data-sb-feedback="email:email">Email is not valid.</div>
                        <!-- Submit success message-->
                        <!---->
                        <!-- This is what your users will see when the form-->
                        <!-- has successfully submitted-->
                    
                   
                </div>
            </div>
<%-- <head>
<style type="text/css">
h1 {
	font-weight: 900;
	margin-bottom: 20px
}

img {
position: absolute;
  top: 0;
  left: 0;
}

.img-container {
	display: flex;
	justify-content: space-between;
}

.newline {
	position: absolute;
	bottom: 0;
	right: 0;
	
}
.misc-wrapper {
  margin-top: 50px;
}
</style>

</head>
<img width="100" height="80" style="border-radius: 50%;"
								class="d-inline-block" alt=""
								src="https://static.vnuhcm.edu.vn/images/0%20Phong%204T/2019/Thang%205/LOGO%202%20VIEN.png">
							<img width="80" height="80" style="border-radius: 50%;"
								class="d-inline-block" alt=""
								src="https://inkythuatso.com/uploads/images/2021/12/logo-truong-dai-hoc-an-giang-inkythuatso-01-22-14-03-31.jpg">
   <div class="misc-wrapper">
        <h2 class="mb-6 mx-6">WELCOME!HỆ THỐNG QUẢN LÝ DỰ ÁN QUỐC TẾ
							THUỘC PHÒNG QUAN HỆ ĐỐI NGOẠI.</h2>
        <p class="mb-4 mx-2">Vui lòng nhấn phía bên dưới để tiếp tục đăng nhập vào hệ thống</p>
        <a  href='<c:url value="/dang-nhap?action=login"/>' class="btn btn-primary">Nhấn để tiếp tục</a>
    
      </div>

 --%>