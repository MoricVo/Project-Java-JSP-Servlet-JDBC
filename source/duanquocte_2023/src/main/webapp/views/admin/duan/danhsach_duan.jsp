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
                 <h5 class="card-header">Danh sách toàn bộ dự án
					
					</h5>
               <form action="<c:url value='/admin_loc_duan_theodonvitructhuoc?action=loc_duan_theodonvitructhuoc'/>" method="post">
					  <div class="card-body">
                              <div class="row gx-3 gy-2 align-items-center">
                                 
                    <div class="col-md-5">
                    
                      <label class="form-label" for="selectTypeOpt">Chọn đơn vị trực thuộc cần xem</label>
                     	<select name="maDonViTrucThuoc" id="input_donvitructhuoc"
									class="form-select" required>
									<option value="0" selected>Chọn đơn vị</option>
									<c:forEach var="item" items="${donvitructhuocs}">

										<option value="${item.maDonViTrucThuoc}">${item.tenDonViTrucThuoc}</option>
									</c:forEach>
								</select> 
                    </div>
                    
                
                             <div class="col-md-7" style="">
						  <label class="form-label" for="showToastPlacement">&nbsp;</label>
						  <div class="d-flex flex-row">
						      <button  style="float:right;margin-left:10px;" class="btn btn-info " type="submit">Tìm</button>
						     
						    
		                     <a  style="margin-left:10px;" href='<c:url value="/admin_quanly_duan?action=danhsach_duan&page=1&maxPageItem=40&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>' class="btn btn-info">Làm mới dữ liệu</a>
	                         
	                             <a onclick="tableToExcel()" href="javascript:void(0);" style="margin-left:10px;" type="button" class="btn btn-primary "><i class='bx bxs-download'></i> Xuất file Excel</a>
					
						    
						  </div>
						</div>
                          
                    
                  </div>
                 
           
                  </div>
                  </form>
                <form action="<c:url value='/admin_timkiem_duan?action=timkiem_duan_post'/>" method="post">
					  <div class="card-body">
                              <div class="row gx-3 gy-2 align-items-center">
                                  <span style="color:#CC0000"><span >*</span>Nhập tên dự án mà bạn muốn tìm! </span>
                    <div class="col-md-4">
                     <input class="form-control me-2" type="search" name="tenDuAn_TiengViet" placeholder="Bạn muốn tìm dự án nào" aria-label="Search" />
                      
                      
                    </div>
                     <div class="col-md-5">
                    <button class="btn btn-outline-primary" type="submit">Tìm</button>
                    
	
                      </div>    
              
                          
                  </div>
                 
           
                  </div>
                  </form>
                <div class="table-responsive text-nowrap">
                <form action="<c:url value='/admin_quanly_duan?action=danhsach_duan'/>" id="form_submit" method="get">
                  <table class="table">
                    <thead class="table-dark">
                                               
                      <tr>            
                                        <th class="text-white">STT</th>
                                        <th class="post_chuduan text-white">Chủ dự án</th>
                                        <th class="post_thuockhoa text-white">Thuộc khoa</th>
										<th class="post_thuocdanhmuc text-white">Danh mục</th>
								     	<th class="post_tenduan_tiengviet text-white">Tên dự án(TV)</th>
										<th class="post_tenduan_tienganh text-white">Tên dự án(TA)</th>
									 
									    <th class="post_muctieuduan text-white">Mục tiêu dự án</th>
									    <th class="post_noidungthuchien text-white">Nội dung thực hiện</th>
									    <th class="post_thietbitaitro text-white">Thiết bị được tài trợ</th>
									    <th class="post_thoigianthuchien text-white">Thời gian thực hiện</th>
									    <th class="post_thoigianbatdau text-white">Thời gian bắt đầu</th>
									    <th class="post_thoigianketthuc text-white">Thời gian kết thúc</th>
									    <th class="ppost_tongvon_thuchien text-white">Tổng vốn</th>
									    <th class="ppost_vontaitro text-white">Vốn tài trợ</th>
									    <th class="ppost_vonvay text-white">Vốn vay</th>
									    <th class="ppost_vonkhac text-white">Vốn khác</th>
									    <th class="ppost_vondoiung text-white">Vốn đối ứng</th>
									    <th class="post_kinhphiduannamroi text-white">Kinh phí dự án năm trước</th>
										<th class="post_nhataitro text-white">Nhà tài trợ</th>
										<th class="post_loaivientro text-white">Loại viện trợ</th>
										<th class="post_coquanpheduyet text-white">Cơ quan phê duyệt</th>
										<th class="post_doitacthuchien text-white">Đối tác thực hiện</th>
										<th class="post_tiendothuchien text-white">Tiến độ thực hiện</th>
										<th class="post_phantramtiendo text-white">Ước lượng % tiến độ</th>
										<th class="post_tuychon text-white" >Tùy chọn</th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                    <%
                      int i=0;
                    %>
                    	<c:forEach var="item" items="${duan.danhsach}" >
                      <tr>
                    
                        <td ><%=i++ %></td>
                        <td class="post_chuduan"><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Mr ${item.nguoidung.tenNguoiDung}</strong></td>
                                        <td class="post_thuockhoa">${item.donvitructhuoc.tenDonViTrucThuoc}</td>	
                                        <td class="post_thuocdanhmuc">${item.danhmuc.tenDanhMuc}</td>	
                                        <td class="post_tenduan_tiengviet" style="white-space: pre-wrap;">${item.tenDuAn_TiengViet}</td>
										<td class="post_tenduan_tienganh" style="white-space: pre-wrap;">${item.tenDuAn_TiengAnh}</td>
										
										<td class="post_muctieuduan" style="white-space: pre-wrap;">${item.mucTieuDuAn}</td>
										<td class="post_noidungthuchien" style="white-space: pre-wrap;">${item.noiDungThucHien}</td>
										<td class="post_thietbitaitro" style="white-space: pre-wrap;">${item.thietBiTaiTro}</td>
										<td class="post_thoigianthuchien">${item.thoiGianThucHien}</td>
										<td class="post_thoigianbatdau">${item.thoiGianBatDau}</td>
										<td class="post_thoigianketthuc">${item.thoiGianKetThuc}</td>
									   <td class="post_tongvon_thuchien" id="input_tongvonthuchien" data-value="${item.tongVonThucHien}" data-unit="${item.donViTienTe_TongVonThucHien}" data-row-id="input_tongvonthuchien_i">${item.tongVonThucHien} ${item.donViTienTe_TongVonThucHien}</td>
             						    <td class="post_vontaitro" id="input_vontaitro" data-value="${item.vonTaiTro}" data-unit="${item.donViTienTe_VonTaiTro}" data-row-id="input_vontaitro_i">${item.vonTaiTro} ${item.donViTienTe_VonTaiTro}</td>	
             						    <td  class="post_vonvay" id="input_vonvay" data-value="${item.vonVay}" data-unit="${item.donViTienTe_VonVay}" data-row-id="input_vonvay_i">${item.vonVay} ${item.donViTienTe_VonVay}</td>	
             						    <td class="post_vonkhac" id="input_vonkhac" data-value="${item.vonKhac}" data-unit="${item.donViTienTe_VonKhac}" data-row-id="input_vonkhac_i">${item.vonKhac} ${item.donViTienTe_VonKhac}</td>	
             						    <td class="post_vondoiung" id="input_vondoiung" data-value="${item.vonDoiUng}" data-unit="${item.donViTienTe_VonDoiUng}" data-row-id="input_vondoiung_i">${item.vonDoiUng} ${item.donViTienTe_VonDoiUng}</td>	
             						    <td class="post_kinhphiduannamroi">${item.kinhPhiNamTruoc}</td>	
										<td class="post_nhataitro">${item.nhataitro.tenNhaTaiTro}</td>
										<td class="post_loaivientro">${item.loaivientro.tenLoaiVienTro}</td>
										<td class="post_coquanpheduyet">${item.coquanpheduyet.tenCoQuanPheDuyet}</td>
										<td class="post_doitacthuchien">${item.doitacthuchien.tenDoiTacThucHien}</td>
										<td class="post_tiendothuchien" style="white-space: pre-wrap;">${item.tienDoThucHien}</td>
										<td class="post_phantramtiendo">${item.phanTramTienDoThucHien}</td>
                        <td class="post_tuychon">
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
                               
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:forEach>
      
                    </tbody>
                    		
                  </table>
                  <input type="hidden" value="" id="action" name="action"/>
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="" id="sapxeptheochieu" name="sapxeptheochieu"/>
                    </form>
							
                  
                </div>
                
              </div>
              	 <div class="demo-inline-spacing">
                        <!-- Basic Pagination -->
                        <nav aria-label="Page navigation">
                          <ul class="pagination"  id="pagination">
                	

								</ul>
								</nav>
								</div>
						    
                 </div>
              </div>
           
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script src="<c:url value='/template/twb/table2excel.js' />"></script>
    <script src="<c:url value='/template/twb/script.js' />"></script>
    <script>
window.onload = function() {
	  var inputElements = document.querySelectorAll('.post_tongvon_thuchien, .post_vontaitro, .post_vonvay, .post_vonkhac, .post_vondoiung');

	  for (var i = 0; i < inputElements.length; i++) {
	    var input = inputElements[i];
	    var valueFromData = parseFloat(input.getAttribute("data-value"));
	    var unitFromData = input.getAttribute("data-unit");

	    var formattedValue = valueFromData.toLocaleString() + " " + unitFromData;

	    input.innerHTML = formattedValue;
	  }
	};
</script>
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
			var limit=40;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('danhsach_duan');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('madonvitructhuoc');
								$('#sapxeptheochieu').val('desc');
								$('#form_submit').submit();
								}
							
						}
					});
				});
	</script>
</body>
</html>

