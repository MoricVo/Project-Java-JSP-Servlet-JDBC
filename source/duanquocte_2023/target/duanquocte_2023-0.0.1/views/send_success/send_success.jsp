<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="container-xxl container-p-y">
      <div class="misc-wrapper">
        <h2 class="mb-2 mx-2">Đã gửi email thành công!</h2>
        <a href='<c:url value="/admin"/>'  class="btn btn-primary">Trở lại trang chủ</a>
        <div class="mt-3">
          <img
           src='<c:url value="/template/ad_template_new/assets/img/illustrations/send_email.jpg" />'
            alt="send_email"
            width="500"
            class="img-fluid"
            data-app-dark-img="illustrations/send_email.jpg"
            data-app-light-img="illustrations/send_email.jpg"
          />
        </div>
      </div>
    </div>
    <!-- /Error -->

</body>
</html>