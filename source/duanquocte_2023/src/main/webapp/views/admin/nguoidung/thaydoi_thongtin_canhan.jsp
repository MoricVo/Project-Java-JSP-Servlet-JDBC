<%@page import="com.duan.model.bang_nguoidung_model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	 <%
		Object obj = session.getAttribute("nguoiDung");
		bang_nguoidung_model nguoiDung = null;
		if (obj!=null)
			nguoiDung = (bang_nguoidung_model)obj;		
			if(nguoiDung==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
			}
			
			else 
			
			{
				
  %>
	<%
	
	String hoNguoiDung= nguoiDung.getHoNguoiDung();
	String tenNguoiDung=nguoiDung.getTenNguoiDung();
	String sdt=nguoiDung.getSdt();
	String diaChi=nguoiDung.getDiaChi();
	String gmail=nguoiDung.getGmail();
	String anhDaiDien=nguoiDung.getAnhDaiDien();
	
	%>
	    <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Cập nhật thông tin cá nhân /</span>Thông tin</h4>

              <div class="row">
                <div class="col-md-12">
                  <ul class="nav nav-pills flex-column flex-md-row mb-3">
                    <li class="nav-item">
                      <a class="nav-link active" href="javascript:void(0);"><i class="bx bx-user me-1"></i>Thông tin cá nhân</a>
                    </li>
                    <li class="nav-item" style="margin-left:10px;">
                    
                       <button
                          type="button"
                          class="nav-link active" 
                          data-bs-toggle="modal"
                          data-bs-target="#modalCenter"
                        >
                       <i class='bx bx-dialpad-alt'></i>
                         Thay đổi mật khẩu
                        </button>
                    </li>
                    
                  </ul>
                  <div class="card mb-4">
                    <h5 class="card-header">Chi tiết thông tin cá nhân</h5>
                    <!-- Account -->
                       <form id="formAccountSettings" action=" <c:url value='/admin_thaydoithongtin?action=capnhat_anh'/> " method="post" enctype="multipart/form-data" >
                    <div class="card-body">
                      <div class="d-flex align-items-start align-items-sm-center gap-4">
                       
                        <img
                        src="${pageContext.request.contextPath}/avatar_user/<%=anhDaiDien%>  "onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';"
                          alt="user-avatar"
                          class="d-block rounded"
                        name="anhDaiDien"
                          height="100"
                          width="100"
                          id="uploadedAvatar"
                        />
                        <div class="button-wrapper">
                          <label for="upload" class="btn btn-primary me-2 mb-4" tabindex="0">
                            <span class="d-none d-sm-block">Chọn ảnh đại diện</span>
                            <i class="bx bx-upload d-block d-sm-none"></i>
                            <input
                              type="file"
                              id="upload"
                              hidden
                              name="anhDaiDien"  
                              class="account-file-input"
                             
                            
                            />
                          </label>
                          <button  type="submit" class="btn btn-outline-success account-image-reset mb-4">
                            <i class="bx bx-reset d-block d-sm-none"></i>
                            <span class="d-none d-sm-block">Nhấn để lưu</span>
                          </button>

                          <p class="text-muted mb-0">Phù hợp JPG, GIF or PNG.Độ phân giải tối đa 800K</p>
                        </div>
                      </div>
                      
                    </div>
                    </form>
                    <hr class="my-0" />
                     <form id="formAccountSettings" action=" <c:url value='/admin_thaydoithongtin?action=capnhat_thongtin'/> " method="post"  >
                    <div class="card-body">
                        <div class="row">
                          <div class="mb-3 col-md-6">
                            <label for="firstName" class="form-label">Họ của bạn</label>
                            <input
                              class="form-control"
                              type="text"
                              id="hoNguoiDung"
							 name="hoNguoiDung"
							 value="<%=hoNguoiDung%>"
                              autofocus
                            />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="lastName" class="form-label">Tên của bạn</label>
                            <input class="form-control" type="text" id="tenNguoiDung"
													name="tenNguoiDung"  value="<%=tenNguoiDung%>" />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="email" class="form-label">E-mail</label>
                            <input
                              class="form-control"
                              type="text"
                              id="gmail"  value="<%=gmail%>"
													name="gmail"
                              placeholder="john.doe@example.com"
                              readonly
                            />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label class="form-label" for="phoneNumber">Số điện thoại</label>
                            <div class="input-group input-group-merge">
                              <span class="input-group-text">VN (+84)</span>
                              <input
                                type="text"
                                id="sdt"  value="<%=sdt%>"
													name="sdt"
                                class="form-control"
                                placeholder="202 555 0111"
                              />
                            </div>
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="address" class="form-label">Địa chỉ</label>
                            <input type="text" class="form-control" id="diaChi"  value="<%=diaChi%>"
													name="diaChi" placeholder="Address" />
                          </div>
                        
                          	</div>
                          	   <button type="submit"  class="btn btn-success ">Lưu thông tin</button>
                      
                    </div>
                    </form>
                    <!-- /Account -->
                  </div>
                  
                  
                </div>
              </div>
            </div>
            
            <!-- / Content -->
                   <!-- Modal -->
                   <form
			action="<c:url value='/admin_capnhat_matkhau?action=capnhat_matkhau'/>"
			id="form_submit" method="post">
                        <div class="modal fade" id="modalCenter" tabindex="-1" aria-hidden="true">
                          <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="modalCenterTitle">Thay đổi mật khẩu cá nhân!</h5>
                                <button
                                  type="button"
                                  class="btn-close"
                                  data-bs-dismiss="modal"
                                  aria-label="Close"
                                ></button>
                              </div>
                              <div class="modal-body">
                                <div class="row">
                                  <div class="col mb-3">
                                    <label for="nameWithTitle" class="form-label">Mật khẩu hiện tại</label>
                                    <input
                                      type="password"
                                      id="matKhauHienTai"
                                      name="matKhauHienTai"
                                      class="form-control"
                                      placeholder="Nhập mật khẩu hiện tại"
                                    />
                                  </div>
                             
                                </div>
                                <div class="row">
                                       <div class="col mb-3">
                                    <label for="nameWithTitle" class="form-label">Mật khẩu mới</label>
                                    <input
                                      type="password"
                                      id="matKhauMoi"
                                      name="matKhauMoi"
                                      class="form-control"
                                      placeholder="Nhập mật khẩu mới"
                                    />
                                  </div>
                                  
                                </div>
                                <div class="row">
                                    <div class="col mb-3">
                                    <label for="nameWithTitle" class="form-label">Xác nhận mật khẩu mới</label>
                                    <input
                                     type="password"
                                     id="matKhauNhapLai"
                                     name="matKhauNhapLai"
                                      id="nameWithTitle"
                                      class="form-control"
                                      placeholder="Nhập lại mật khẩu"
                                    />
                                  </div>
                                </div>
                      
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                  Close
                                </button>
                                <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
                              </div>
                            </div>
                          </div>
                        </div>
                        </form>
         
            <!-- / Footer -->

            <div class="content-backdrop fade"></div>
          </div>
	

	
	
			<%} %>
</body>
</html>