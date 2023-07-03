<%@page import="com.duan.database.nguoidungDAO"%>
<%@page import="com.duan.database.duanDAO"%>
<%@page import="com.duan.model.bang_nguoidung_model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
  <% nguoidungDAO nguoidung=new nguoidungDAO();
  duanDAO duan=new duanDAO();
  
  Object obj = session.getAttribute("nguoiDung");
  
	bang_nguoidung_model nguoiDung = null;
	if (obj != null)
		nguoiDung = (bang_nguoidung_model) obj;
	int maNguoiDung = nguoiDung.getMaNguoiDung();
  %>
  <head>
  <style type="text/css">
  .title {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

@media screen and (max-width: 576px) {
  .title {
    font-size: 0;
  }
  .title::after {
    content: "PQHDN";
    font-size: 16px;
  }
}
  
  </style>
  </head>
 <nav 
            class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
            id="layout-navbar"
          >
           <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
              <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                <i class="bx bx-menu bx-sm"></i>
              </a>
            </div>
             <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
              <div class="navbar-nav align-items-center col-12 ">
                <div class="nav-item d-flex align-items-center col-12">
            <div class="avatar " style="margin-right:15px;">
                      <img  src="data:image/png;base64,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" alt class="w-px-40 h-auto rounded-circle" />
                    </div>
                             <div class="avatar " style="margin-right:12px;">
                      <img  src="https://inkythuatso.com/uploads/images/2021/12/logo-truong-dai-hoc-an-giang-inkythuatso-01-22-14-03-31.jpg" />
                       
                    </div>
                      <h3 class="title"     style="font-weight:700;color:black;padding-top:10px;">PHÒNG QUAN HỆ ĐỐI NGOẠI,HỆ THỐNG QUẢN LÝ DỰ ÁN QUỐC TẾ</h3>
        
           </div>
           </div>
           </div>
          </nav>


 <nav
            class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
            id="layout-navbar"
          >
            

            <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
              <!-- Search -->
              <div style="padding-top:15px;" class="nav-item lh-1 me-3">
             
                    <c:if test="${not empty successMessage_doimkthanhcong}">
					<div style="height:50px;"  class="alert alert-success alert-dismissible" role="alert">
						${successMessage_doimkthanhcong}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				 <c:if test="${not empty successMessage1}">
					<div style="height:50px;"  class="alert alert-success alert-dismissible" role="alert">
						${successMessage1}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				
				<c:if test="${not empty dangerMessage_doimatkhau_mkkhongchinhxac}">
					<div style="height:50px;"  class="alert alert-danger alert-dismissible" role="alert">
						${dangerMessage_doimatkhau_mkkhongchinhxac}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
					<c:if test="${not empty dangerMessage_doimatkhau_mkkhongkhop}">
					<div style="height:50px;"  class="alert alert-danger alert-dismissible" role="alert">
						${dangerMessage_doimatkhau_mkkhongkhop}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				<c:if test="${not empty dangerMessage_quatrinh_doimatkhau_khongthanhcong}">
					<div style="height:50px;"  class="alert alert-danger alert-dismissible" role="alert">
						${dangerMessage_quatrinh_doimatkhau_khongthanhcong}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				
              
              </div>
           
              <!-- /Search -->
               <c:if test="${not empty USERMODEL }">
              <ul class="navbar-nav flex-row align-items-center ms-auto">
               <c:if test="${USERMODEL.quyenHan eq 'manager'}">
              <li class="nav-item lh-1 me-5">
                 <div class="navbar-nav align-items-center">
                <div class="nav-item d-flex align-items-center">
                  Quản trị:${USERMODEL.donvitructhuoc.tenDonViTrucThuoc}
                </div>
              </div>
              
              </li>
              </c:if>
                <li  class="nav-item lh-1 me-3"> 
                           
                                       <div class="btn-group" role="group" aria-label="First group">
                                            <c:if test="${USERMODEL.quyenHan eq 'user'}">
                              <a type="button" href='<c:url value="/admin_them_duan?action=them_duan"/>'  class="btn btn-outline-primary">
                                 <i class='tf-icons bx bx-plus-circle'></i>
                                <span class="d-none d-md-inline-block">   Thêm dự án mới </span>
                              </a>
                                <a    class="btn btn-outline-primary"
                                   href="javascript:void(0);"
                                
			                          type="button"
			                          data-bs-toggle="offcanvas"
			                          data-bs-target="#offcanvasEnd2"
			                          aria-controls="offcanvasEnd2"
                                >
                              
                             <i class='bx bxs-bell'></i>
                         
                              <span class="d-none d-md-inline-block">  Nhắc nhở</span>
                         
                                <% if(duan.count_duan_conhoatdong(maNguoiDung)>0)
                          {
                        	 %>
                                <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20"><%= duan.count_duan_conhoatdong(maNguoiDung) %></span>
                               <%}  %>
                              
                               
                              </a>
                              </c:if>
                                
                                 <c:if test="${USERMODEL.quyenHan eq 'manager' || USERMODEL.quyenHan eq 'admin'}">
                              <a  href='<c:url value="/admin_send_gmail?action=send_gmail"/>' class="btn btn-outline-primary ">
                              
                            <i class='tf-icons bx bx-mail-send '></i>
                               <span class="d-none d-md-inline-block">  Gửi thông báo đến email </span>
                              </a>
                              </c:if>
                                <c:if test="${USERMODEL.quyenHan eq 'admin'}">
                                <a    class="btn btn-outline-primary"
                                   href="javascript:void(0);"
                                
			                          type="button"
			                          data-bs-toggle="offcanvas"
			                          data-bs-target="#offcanvasEnd"
			                          aria-controls="offcanvasEnd"
                                >
                              
                             <i class='bx bxs-bell'></i>
                         
                              <span class="d-none d-md-inline-block">    Kích hoạt tài khoản </span>
                                      <% if(nguoidung.count_account_notveryfy()>0)
                          {
                        	 %>
                                <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20"><%= nguoidung.count_account_notveryfy() %></span>
                               <%}  %>
                               
                              </a>
                           </c:if>
                            </div>
                         
                          </li>
                <!-- Place this tag where you want the button to render. -->
               <%--  <li class="nav-item lh-1 me-3">  <a  style="margin-right:10px;" type="button" href='<c:url value="/admin_them_duan?action=them_duan"/>' class="btn btn-success">+Tạo dự án mới</a></li>
             
               <li class="nav-item lh-1 me-3">  <a href='<c:url value="/admin_send_gmail?action=send_gmail"/>' type="button" class="btn btn-danger">Gửi thông báo đến Gmail </a> </li> --%>
                <!-- User -->
               
                <li class="nav-item navbar-dropdown dropdown-user dropdown">
                  <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                      <img src="${pageContext.request.contextPath}/avatar_user/${USERMODEL.anhDaiDien}" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt class="w-px-40 h-auto rounded-circle" />
                    </div>
                  </a>
                  <ul class="dropdown-menu dropdown-menu-end">
               
                    <li>
                      <a class="dropdown-item" href="#">
                        <div class="d-flex">
                          <div class="flex-shrink-0 me-3">
                            <div class="avatar avatar-online">
                              <img src="${pageContext.request.contextPath}/avatar_user/${USERMODEL.anhDaiDien}"  onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';"   alt class="w-px-40 h-auto rounded-circle" />
                            </div>
                          </div>
                          <div class="flex-grow-1">
                            <span class="fw-semibold d-block">${USERMODEL.tenNguoiDung}</span>
                            <small class="text-muted">${USERMODEL.bangchucvu.tenchucvu}</small>
                          </div>
                        </div>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href='<c:url value="/admin_thaydoithongtin"/>'>
                        <i class="bx bx-user me-2"></i>
                        <span class="align-middle">Thông tin cá nhân</span>
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="javascript:void(0);">
                        <i class="bx bx-cog me-2"></i>
                        <span class="align-middle">Cài đặt</span>
                      </a>
                    </li>
               
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a href='<c:url value="/thoat?action=logout"/>' class="dropdown-item" >
                        <i class="bx bx-power-off me-2"></i>
                        <span  class="align-middle">Đăng xuất</span>
                      </a>
                    </li>
                   
                  </ul>
                 
                </li>
                
                <!--/ User -->
              </ul>
                </c:if>
            </div>
          </nav>



                            <div
                          class="offcanvas offcanvas-end"
                          tabindex="-1"
                          id="offcanvasEnd"
                          aria-labelledby="offcanvasEndLabel"
                        >
                          <div class="offcanvas-header">
                            <h5 id="offcanvasEndLabel" class="offcanvas-title">Thông báo về tài khoản người dùng!</h5>
                            <button
                              type="button"
                              class="btn-close text-reset"
                              data-bs-dismiss="offcanvas"
                              aria-label="Close"
                            ></button>
                          </div>
                          <% if(nguoidung.count_account_notveryfy()>0)
                          {
                        	 %>
                          <div class="offcanvas-body my-auto mx-0 flex-grow-0">
                            <p class="text-center">
                             Hệ thống ghi nhận rằng đã có <span style="color:red;"> <%= nguoidung.count_account_notveryfy() %></span> tài khoản người dùng chưa được cấp quyền truy cập!Bạn có muốn tiếp tục xử lý không?
                            </p>
                            <a type="button" href='<c:url value="/admin_danhsach_nguoidung_dangbikhoa?action=danhsach_nguoidung_dangbikhoa&page=1&maxPageItem=20&sapxeptheothuoctinh=quyenhan&sapxeptheochieu=asc"/>' class="btn btn-primary mb-2 d-grid w-100">Tiếp tục</a>
                            <button
                              type="button"
                              class="btn btn-outline-secondary d-grid w-100"
                              data-bs-dismiss="offcanvas"
                            >
                              Để sau
                            </button>
                          </div>
                          <% } else { %>
                           <div class="offcanvas-body my-auto mx-0 flex-grow-0">
                            <p class="text-center">
                           Không có thông báo nào!
                            </p>
                            
                          </div>
                          
                          <% } %>
                        </div>
                        
                  <!--       //===================================== -->
                    <div
                          class="offcanvas offcanvas-end"
                          tabindex="-1"
                          id="offcanvasEnd2"
                          aria-labelledby="offcanvasEndLabel"
                        >
                          <div class="offcanvas-header">
                            <h5 id="offcanvasEndLabel" class="offcanvas-title">Thông báo về những dự án còn hoạt động!</h5>
                            <button
                              type="button"
                              class="btn-close text-reset"
                              data-bs-dismiss="offcanvas"
                              aria-label="Close"
                            ></button>
                          </div>
                          <% if(duan.count_duan_conhoatdong(maNguoiDung)>0)
                          {
                        	 %>
                          <div class="offcanvas-body my-auto mx-0 flex-grow-0">
                            <p class="text-center">
                             Hệ thống kiểm tra và ghi nhận rằng
                            </p>
                             <div class="card mb-4">
			                    <ul class="list-group list-group-flush">
			                      <li class="list-group-item">Tổng số dự án còn hoạt động:<span class="text-success"><%= duan.count_duan_conhoatdong(maNguoiDung) %> dự án</span></li>
			                      <li class="list-group-item">Trạng thái đã báo cáo:<span class="text-primary"><%= duan.count_duan_conhoatdong_dabaocao(maNguoiDung) %> dự án</span></li>
			                      <li class="list-group-item">Trạng thái chưa báo cáo:<span class="text-info"><%= duan.count_duan_conhoatdong_chuabaocao(maNguoiDung) %> dự án</span></li>
			                    </ul>
			                  </div>
			                  <p class="text-center">
                             Bạn có muốn kiểm tra không ?
                            </p>
                            <a type="button" href='<c:url value="/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=40&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>' class="btn btn-primary mb-2 d-grid w-100">Tiếp tục</a>
                            <button
                              type="button"
                              class="btn btn-outline-secondary d-grid w-100"
                              data-bs-dismiss="offcanvas"
                            >
                              Để sau
                            </button>
                          </div>
                          <% } else { %>
                           <div class="offcanvas-body my-auto mx-0 flex-grow-0">
                            <p class="text-center">
                           Không có thông báo nào!
                            </p>
                            
                          </div>
                          
                          <% } %>
                        </div>
                  
