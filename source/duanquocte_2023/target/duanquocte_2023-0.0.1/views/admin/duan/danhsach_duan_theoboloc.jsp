<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Danh sách dự án</title>
</head>
<body>

       <!-- Bootstrap Table with Header - Dark -->
       <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <div class="card">
                <h5 class="card-header">Lọc dự án
                 
                 </h5>
                        <form action="<c:url value='/admin_loc_duan_theoquynam?action=loc_duan_theoquynam_post'/>" id="form_submit" method="post">
                 <div class="card-body">
                  <div class="row gx-3 gy-2 align-items-center">
                    <div class="col-md-2">
                      <label class="form-label" for="selectTypeOpt">Chọn quý</label>
                      <select id="selectTypeOpt" name="thuocQuy" class="form-select color-dropdown"  required>
                        <option value="1" selected>1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                     
                      </select>
                    </div>
                    <div class="col-md-2">
                      <label class="form-label" for="selectPlacement">Chọn năm</label>
                      <select class="form-select placement-dropdown" id="selectYear" name="thuocNam" required>
                       
                      </select>
                    </div>
                    <div class="col-md-5" style="">
						  <label class="form-label" for="showToastPlacement">&nbsp;</label>
						  <div class="d-flex flex-row">
						    <button id="showToastPlacement" style="submit" class="btn btn-primary">Lọc danh sách</button>
						    <button  id="showToastPlacement" class="btn btn-success ms-2">Xuất file excel</button>
						    
						  </div>
						</div>
						                  
                    
                  </div>
                            <input type="hidden" value="loc_duan_theoquynam" id="action" name="action"/>
							<input type="hidden" value="1" id="page" name="page"/>
							<input type="hidden" value="900" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="tenduan_tiengviet" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="desc" id="sapxeptheochieu" name="sapxeptheochieu"/>
                </div>
                </form>
                <div class="card-body">
                  <div class="row gx-3 gy-2 align-items-center">
                    <div class="col-md-4">
                        <form class="d-flex" action="<c:url value='/admin_timkiem_duan?action=timkiem_duan_post'/>" id="form_submit" method="post">
                      <input class="form-control me-2" type="search" name="tenDuAn_TiengViet" placeholder="Search" aria-label="Search" />
                      <button class="btn btn-outline-primary" type="submit">Search</button>
                    </form>
                    </div>
                    </div>
                    </div>
                
                <div class="table-responsive text-nowrap">
                <form action="<c:url value='/admin_loc_duan_theoquynam?action=loc_duan_theoquynam_post'/>" id="form_submit" method="post">
                  <table class="table">
                    <thead class="table-dark">
                      <tr>
                                        <th>Chủ dự án</th>
								     	<th>Tên dự án(TV)</th>
										<th>Tên dự án(TA)</th>
									    <th>Thời gian thực hiện</th>
									    <th>Tổng vốn</th>
									    <th>Thuộc khoa</th>
										<th>Danh mục</th>
										<th>Nhà tài trợ</th>
										<th>Loại viện trợ</th>
										<th>Cơ quan phê duyệt</th>
										<th>Đối tác thực hiện</th>
										<th>Tùy chọn</th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                    	<c:forEach var="item" items="${duan.danhsach}" >
                      <tr>
                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.nguoidung.tenNguoiDung}</strong></td>
                                         
                                        <td>${item.tenDuAn_TiengViet}</td>
										<td>${item.tenDuAn_TiengAnh}</td>
										<td>${item.thoiGianThucHien}</td>
										<td>${item.tongVonThucHien}</td>
                                        <td>${item.donvitructhuoc.tenDonViTrucThuoc}</td>	
                                        <td>${item.danhmuc.tenDanhMuc}</td>									
										<td>${item.nhataitro.tenNhaTaiTro}</td>
										<td>${item.loaivientro.tenLoaiVienTro}</td>
										<td>${item.coquanpheduyet.tenCoQuanPheDuyet}</td>
										<td>${item.doitacthuchien.tenDoiTacThucHien}</td>
                        <td>
                          <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                              <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item"href='<c:url value="/admin_chitiet_duan?maDuAn=${item.maDuAn}&action=chitiet_duan"/>'
                                ><i class='bx bxs-detail'></i> Xem chi tiết dự án</a
                              >
                              <a class="dropdown-item" href='<c:url value="/admin_sua_duan?maDuAn=${item.maDuAn}&action=sua_duan"/>'
                                ><i class="bx bx-edit-alt me-1"></i>Cập nhật</a
                              >
                              <a class="dropdown-item" href="javascript:void(0);"
                                ><i class="bx bx-trash me-1"></i> Ẩn dự án này</a
                              >
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:forEach>
      
                    </tbody>
                    		
                  </table>
                  <input type="hidden" value="loc_duan_theoquynam" id="action" name="action"/>
							<input type="hidden" value="1" id="page" name="page"/>
							<input type="hidden" value="4" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="tenduan_tiengviet" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="desc" id="sapxeptheochieu" name="sapxeptheochieu"/>
                    </form>
							
                  
                </div>
                
              </div>
              	<ul class="pagination-sm" id="pagination">

								</ul>
						    
                 </div>
              </div>
           
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <script type="text/javascript">
   const selectYear = document.getElementById("selectYear");
   const currentYear = new Date().getFullYear();

   for (let i = currentYear; i >= 1990; i--) {
     const option = document.createElement("option");
     option.text = i;
     option.value = i;
     selectYear.add(option);
   }
   
   </script>
	<script >
			var totalPages=${duan.totalPage};
			var currentPage=${duan.page};
			var limit=10;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('loc_duan_theoquynam');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('tenduan_tiengviet');
								$('#sapxeptheochieu').val('desc');
								$('#form_submit').submit();
								}
							
						}
					});
				});
	</script>
</body>
</html>
<%-- <div class="main-content">
<form action="<c:url value='/admin_quanly_duan'/>" id="form_submit" method="get">
	<div class="content-wrapper">
		<div class="page-header">
			<h3 class="page-title">Danh sách người dùng</h3>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Danh sách</a></li>
					<li class="breadcrumb-item active" aria-current="page">Thêm người dùng</li>
				</ol>
			</nav>
		</div>
		<div class="row">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Bảng 1 	<button style="float:right" class="btn btn-primary ">Xuất file Excel</button> </h4>
						<p class="card-description">
							Dữ liệu được cập nhật từ ngày
							<code>2/2/2023</code>
						</p>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
								
										<th>Chủ dự án</th>
								     	<th>Tên dự án(TV)</th>
										<th>Tên dự án(TA)</th>
									    <th>Thời gian thực hiện</th>
									    <th>Tổng vốn</th>
									    <th>Thuộc khoa</th>
										<th>Danh mục</th>
										<th>Nhà tài trợ</th>
										<th>Loại viện trợ</th>
										<th>Cơ quan phê duyệt</th>
										<th>Đối tác thực hiện</th>
										
									</tr>
								</thead>
								<tbody>
								<% int a=0; %>
								<c:forEach var="item" items="${duan.danhsach}" >
								<tr>
								       
							        	<td style="color:yellow;">${item.nguoidung.tenNguoiDung}</td> 
								        <td>${item.tenDuAn_TiengViet}</td>
										<td>${item.tenDuAn_TiengAnh}</td>
										<td>${item.thoiGianThucHien}</td>
										<td>${item.tongVonThucHien}</td>
                                        <td>${item.donvitructhuoc.tenDonViTrucThuoc}</td>	
                                        <td>${item.danhmuc.tenDanhMuc}</td>									
										<td>${item.nhataitro.tenNhaTaiTro}</td>
										<td>${item.loaivientro.tenLoaiVienTro}</td>
										<td>${item.coquanpheduyet.tenCoQuanPheDuyet}</td>
										<td>${item.doitacthuchien.tenDoiTacThucHien}</td>
								</tr>
								</c:forEach>
								
								</tbody>
							</table>
							<nav aria-label="Page navigation">
								<ul class="pagination-sm" id="pagination">

								</ul>
							</nav>
						
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="" id="sapxeptheochieu" name="sapxeptheochieu"/>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</form>
</div> --%>
