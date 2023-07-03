<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Danh sách dự án</title>

</head>
<body>
 <form action="<c:url value='/admin_laytoanboduan_theokhoa_dangtrienkhai?action=capnhat_trangthai_them'/>" id="form_submit" method="post">
       <!-- Bootstrap Table with Header - Dark -->
       <div class="content-wrapper">
            <!-- Content -->
           
            <div class="container-xxl flex-grow-1 container-p-y">
              <div class="card">
             
                 			<div class="mb-6">
                 				<h5 class="card-header">Danh sách các hồ sơ dự án được yêu cầu báo cáo!</h5>
									<div class="col-xl-12">
										<div class="card mb-8">
											
											<!-- Checkboxes and Radios -->
											
				
											 
						                      	<div class="card-body">
						                      
												<div class="row gy-3">
												
													<div class="col-md">
													
														<small class="text-light fw-semibold">Các đơn vị đã và chưa báo cáo</small>
															<%int dem=1; %>
															 <c:forEach var="khoa" items="${donvitructhuocs}">
												    <c:set var="count" value="0" />
												    <c:forEach var="item" items="${duan.danhsach}">
												        <c:if test="${khoa.maDonViTrucThuoc == item.maDonViTrucThuoc}">
												            <c:set var="count" value="${count+1}" />
												        </c:if>
												    </c:forEach>
												    <c:if test="${count == 0}">
												    
												    <div class="form-check mt-3">
												        <label class="form-check-label" for="defaultCheck1"><%=dem++%>.${khoa.tenDonViTrucThuoc} chưa báo cáo <span class="text-danger"><i class='bx bx-task-x'></i></span> </label>
												        </div>
												        
												    </c:if>
												    <c:if test="${count >= 1}">
												    <div class="form-check mt-3">
												       <label class="form-check-label" for="defaultCheck1"><%=dem++%>.${khoa.tenDonViTrucThuoc} đã báo cáo <span class="text-success"> <i class='bx bx-task'></i> (số lượng dự án: ${count})</span>  </label>
												       
												        </div>
												    </c:if>
												</c:forEach>
															<!-- <label class="form-check-label" for="defaultCheck1">
																1.Khoa công nghệ thông tin </label> -->
														</div>
								                    
													</div>
										
											
										
												</div>
												<div class="divider divider-primary">
						                        <div class="divider-text">Thông tin các đơn vị đã và chưa báo cáo</div>
						                      </div>
												
												
																			<div class="card-body">
								                         <h5 class="card-header">Chọn thông tin cần xem</h5>
												<div class="row gy-3">
													<div class="col-md">
														<small class="text-light fw-semibold">Mục 1</small>
															<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="maDuAn"  name="columns"  id="chk_chuduan" />
															<label class="form-check-label" for="defaultCheck1">
																Chủ dự án </label>
														</div>
								                        <div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="tenDuAn_TiengViet" name="columns" id="chk_thuockhoa" checked />
															<label class="form-check-label" for="defaultCheck1">
																Đơn vị trực thuộc </label>
														</div>
															<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="danhMuc" name="columns" id="chk_thuocdanhmuc" />
															<label class="form-check-label" for="defaultCheck1">
																Danh mục </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="tenDuAn_TiengViet" name="columns" id="chk_tenduan_tiengviet" checked />
															<label class="form-check-label" for="defaultCheck1">
																Tên dự án(TV) </label>
														</div>
																<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="tenDuAn_TiengAnh" name="columns" id="chk_tenduan_tienganh" checked  />
															<label class="form-check-label" for="defaultCheck1">
																Tên dự án(TA) </label>
														</div>
													
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="Đơn vị trực thuộc" name="checkbox3"
																id="chk_thoigianthuchien" /> <label class="form-check-label"
																for="defaultCheck1"> Thời gian thực hiện </label>
														</div>
														
														
													</div>
													<div class="col-md">
														<small class="text-light fw-semibold">Mục 2</small>
											
							
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_tongvon_thuchien" /> <label class="form-check-label"
																for="defaultCheck1"> Tổng vốn thực hiện </label>
														</div>
									
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_vontaitro" /> <label class="form-check-label"
																for="defaultCheck1"> Vốn tài trợ </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_vonvay" /> <label class="form-check-label"
																for="defaultCheck1"> Vốn vay </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_vonkhac" /> <label class="form-check-label"
																for="defaultCheck1"> Vốn khác </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_vondoiung" /> <label class="form-check-label"
																for="defaultCheck1"> Vốn đối ứng </label>
														</div>
                                                         <div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_kinhphiduannamroi" /> <label class="form-check-label"
																for="defaultCheck1"> Kinh phí dự án năm rồi </label>
														</div>
													</div>
													<div class="col-md">
														<small class="text-light fw-semibold">Mục 3</small>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_nhataitro" /> <label class="form-check-label"
																for="defaultCheck1"> Nhà tài trợ </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_loaivientro" /> <label class="form-check-label"
																for="defaultCheck1"> Loại viện trợ </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_coquanpheduyet" /> <label class="form-check-label"
																for="defaultCheck1"> Cơ quan phê duyệt </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_doitacthuchien" /> <label class="form-check-label"
																for="defaultCheck1"> Đối tác thực hiện </label>
														</div>
															<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_tiendothuchien" /> <label class="form-check-label"
																for="defaultCheck1"> Tiến độ thực hiện</label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_phantramtiendo" /> <label class="form-check-label"
																for="defaultCheck1"> Ước lượng % tiến độ</label>
														</div>
															
													</div>
													<div class="col-md">
														<small class="text-light fw-semibold">Mục 4</small>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_thanhvienthamgia" /> <label class="form-check-label"
																for="defaultCheck1"> Thành viên tham gia </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_muctieuduan" /> <label class="form-check-label"
																for="defaultCheck1"> Mục tiêu dự án </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_noidungthuchien" /> <label class="form-check-label"
																for="defaultCheck1"> Nội dung thực hiện </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_thietbitaitro" /> <label class="form-check-label"
																for="defaultCheck1"> Thiết bị tài trợ </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="Thời gian bắt đầu" name="checkbox3"
																id="chk_thoigianbatdau" /> <label class="form-check-label"
																for="defaultCheck1"> Thời gian bắt đầu </label>
														</div>
														<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox"
																value="Thời gian kết thúc" name="checkbox3"
																id="chk_thoigianketthuc" /> <label class="form-check-label"
																for="defaultCheck1"> Thời gian kết thúc </label>
														</div>
															<div class="form-check mt-3">
															<input class="form-check-input" type="checkbox" value=""
																id="chk_tuychon" checked /> <label class="form-check-label text-success"
																for="defaultCheck1"> Mở tùy chọn</label>
														</div>
															
															

													</div>
												</div>
												
												
											</div>
												
												
											</div>
										
											<hr class="m-0" />
											<!-- Inline Checkboxes -->

										</div>

										<!-- Switches -->


										<!-- Range -->

									</div>

								</div>
								<h5 class="card-header">Danh sách hồ sơ dự án đã báo cáo
								   
                                     <a onclick="tableToExcel()" href="javascript:void(0);" style="float:right;margin-left:10px;" type="button" class="btn btn-primary "><i class='bx bxs-download'></i> Xuất file Excel</a>
                
                 </h5>
               
                  
                    <div class="card">
                <div class="table-responsive text-nowrap">
                  <table class="table"  id="myTable">
                    <thead class="table-dark">
                                       
                      <tr >    
                      
                                <th class="text-white">Chọn</th>
                                        <th class="text-white">STT</th>
                                        <th class="post_chuduan text-white">Chủ dự án</th>
                                        <th class="post_thuockhoa text-white">Đơn vị trực thuộc</th>
										<th class="post_thuocdanhmuc text-white">Danh mục</th>
								     	<th class="post_tenduan_tiengviet text-white">Tên dự án(TV)</th>
										<th class="post_tenduan_tienganh text-white">Tên dự án(TA)</th>
									    <th class="post_thanhvienthamgia text-white">Thành viên tham gia</th>
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
                      int i=1;
                    %>
                    	<c:forEach var="item" items="${duan.danhsach}" >
                      <tr>
                       <td>   <input class="form-check-input" type="checkbox" name="maDonViTrucThuoc" id="maDonViTrucThuoc" value="${item.maDuAn}||${item.nguoidung.tenNguoiDung}||${item.donvitructhuoc.tenDonViTrucThuoc}||${item.danhmuc.tenDanhMuc}||${item.nhataitro.tenNhaTaiTro}||${item.loaivientro.tenLoaiVienTro}||${item.coquanpheduyet.tenCoQuanPheDuyet}||${item.doitacthuchien.tenDoiTacThucHien}||${item.tenDuAn_TiengViet}||${item.tenDuAn_TiengAnh}||${item.thanhVienThamGia}||${item.mucTieuDuAn}||${item.noiDungThucHien}||${item.thietBiTaiTro}||${item.kinhPhiNamTruoc}||${item.tongVonThucHien}||${item.vonTaiTro}||${item.vonVay}||${item.vonKhac}||${item.vonDoiUng}||${item.donvitiente.tenDonViTienTe}||${item.thoiGianThucHien}||${item.thoiGianBatDau}||${item.thoiGianKetThuc}||${item.tienDoThucHien}||${item.phanTramTienDoThucHien}||${item.donViTienTe_VonTaiTro}||${item.donViTienTe_VonVay}||${item.donViTienTe_VonKhac}||${item.donViTienTe_VonDoiUng}||${item.donViTienTe_TongVonThucHien}" onchange="disableSelect()"></td>
                        <td ><%=i++ %></td>
                        <td class="post_chuduan"><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Mr ${item.nguoidung.tenNguoiDung}</strong></td>
                                        <td class="post_thuockhoa">${item.donvitructhuoc.tenDonViTrucThuoc}</td>	
                                        <td class="post_thuocdanhmuc">${item.danhmuc.tenDanhMuc}</td>	
                                        <td class="post_tenduan_tiengviet" style="white-space: pre-wrap;">${item.tenDuAn_TiengViet}</td>
										<td class="post_tenduan_tienganh" style="white-space: pre-wrap;">${item.tenDuAn_TiengAnh}</td>
										<td class="post_thanhvienthamgia" style="white-space: pre-wrap;">${item.thanhVienThamGia}</td>
										<td class="post_muctieuduan" style="white-space: pre-wrap;">${item.mucTieuDuAn}</td>
										<td class="post_noidungthuchien" style="white-space: pre-wrap;">${item.noiDungThucHien}</td>
										<td class="post_thietbitaitro" style="white-space: pre-wrap;">${item.thietBiTaiTro}</td>
										<td class="post_thoigianthuchien">${item.thoiGianThucHien}</td>
										<td class="post_thoigianbatdau">${item.thoiGianBatDau}</td>
										<td class="post_thoigianketthuc">${item.thoiGianKetThuc}</td>
										<td class="post_tongvon_thuchien" id="input_tongvonthuchien" data-value="${item.tongVonThucHien}" data-unit="${item.donViTienTe_TongVonThucHien}" data-row-id="input_tongvonthuchien_i">${item.tongVonThucHien} ${item.donViTienTe_TongVonThucHien}</td>
             						    <td class="post_vontaitro" id="input_vontaitro" data-value="${item.vonTaiTro}" data-unit="${item.donViTienTe_VonTaiTro}" data-row-id="input_vontaitro_i">${item.vonTaiTro} ${item.donViTienTe_VonTaiTro}</td>	
             						    <td class="post_vonvay" id="input_vonvay" data-value="${item.vonVay}" data-unit="${item.donViTienTe_VonVay}" data-row-id="input_vonvay_i">${item.vonVay} ${item.donViTienTe_VonVay}</td>	
             						    <td class="post_vonkhac" id="input_vonkhac" data-value="${item.vonKhac}" data-unit="${item.donViTienTe_VonKhac}" data-row-id="input_vonkhac_i">${item.vonKhac} ${item.donViTienTe_VonKhac}</td>	
             						    <td class="post_vondoiung" id="input_vondoiung" data-value="${item.vonDoiUng}" data-unit="${item.donViTienTe_VonDoiUng}" data-row-id="input_vondoiung_i">${item.vonDoiUng} ${item.donViTienTe_VonDoiUng}</td>	
             						    <td class="post_kinhphiduannamroi">${item.kinhPhiNamTruoc}</td>	
										<td class="post_nhataitro">${item.nhataitro.tenNhaTaiTro}</td>
										<td class="post_loaivientro">${item.loaivientro.tenLoaiVienTro}</td>
										<td class="post_coquanpheduyet">${item.coquanpheduyet.tenCoQuanPheDuyet}</td>
										<td class="post_doitacthuchien">${item.doitacthuchien.tenDoiTacThucHien}</td>
										<td class="post_tiendothuchien"  style="white-space: pre-wrap;">${item.tienDoThucHien}</td>
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
                                <a class="dropdown-item" href='<c:url value="/admin_capnhat_trangthai_them?maDuAn=${item.maDuAn}&action=capnhat_trangthai_them0"/>'
														onclick="return confirm('Bạn có chắc loại dự án này không?');"><i class='bx bx-up-arrow'></i> Loại bỏ dự án này</a
                              >
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:forEach>
      
                    </tbody>
                    		
                  </table>
               
							
                   
                </div>
                </div>
                  <div class="card-body">
                              <div class="row gx-3 gy-2 align-items-center">
                                <!--   <span style="color:#CC0000"><span >*</span>Bạn cần chọn các dự án mong muốn trước khi chọn quý và năm! </span> -->
                    <div class="col-md-2">
                    
                      <label class="form-label" for="selectTypeOpt">Chọn quý</label>
                      <select id="selectTypeOpt" name="thuocQuy" class="form-select color-dropdown" disabled  required onchange="updateCheckboxValue()">
                        <option value="1" >1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                     
                      </select>
                    </div>
                    <div class="col-md-2">
                      <label class="form-label" for="selectPlacement">Chọn năm</label>
                      <select class="form-select placement-dropdown" id="selectYear" name="thuocNam" disabled required onchange="updateCheckboxValue()">
                       
                      </select>
                    </div>
                
                             <div class="col-md-5" style="">
						  <label class="form-label" for="showToastPlacement">&nbsp;</label>
						  <div class="d-flex flex-row">
						
					    <button  class="btn btn-primary"  type="submit" onclick="return validateForm()">Lưu thông tin </button>
						    
						  </div>
						</div>
                          
                    
                  </div>
                 
           
                  </div>
                
              
                
              </div>
              
              <!-- 	<ul class="pagination-sm" id="pagination">

								</ul> -->
						  
                 </div>
                 
             
      </form>        
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
    function disableSelect() {
    	  var checkboxes = document.getElementsByName("maDonViTrucThuoc");
    	  var select = document.getElementById("selectTypeOpt");
    	  var select1 = document.getElementById("selectYear");
    	  for (var i = 0; i < checkboxes.length; i++) {
    	    if (checkboxes[i].checked) {
    	      select.disabled = false;
    	      select1.disabled = false;
    	      return;
    	    }
    	  }
    	  select.disabled = true;
    	  select1.disabled = true;
    	}
    	
    </script>
    <script type="text/javascript">
    function validateForm() {
    	  var quy = document.getElementById("selectTypeOpt").value;
    	  var nam = document.getElementById("selectYear").value;
    	  var checkboxes = document.getElementsByName("maDonViTrucThuoc");
    	  var input = document.getElementById("maDonViTrucThuoc");

    	  for (var i = 0; i < checkboxes.length; i++) {
    	    if (checkboxes[i].checked) {
    	      // Lấy giá trị từ input và kiểm tra độ dài
    	      var currentValue = checkboxes[i].value.split("||");
    	      var inputValue = input.value;
    	      if ( currentValue[31] !== quy || currentValue[32] !== nam) {
  	    	    alert("Vui lòng chọn quý và năm trước khi lưu!");
  	    	    return false;
  	    	  }

    	      return true; // Nếu có ít nhất một ô checkbox được chọn và input đủ 4 ký tự|| cho phép submit form
    	    }
    	  }

    	  alert("Vui lòng chọn ít nhất một ô checkbox.");
    	  return false; // Nếu không có ô checkbox nào được chọn, ngăn cản việc submit form
    	}
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
    
<script>
function updateCheckboxValue() {
	  var quy = document.getElementById("selectTypeOpt").value;
	  var nam = document.getElementById("selectYear").value;
	  var checkboxes = document.getElementsByName("maDonViTrucThuoc");

	  for (var i = 0; i < checkboxes.length; i++) {
	    if (checkboxes[i].checked) { // Chỉ cập nhật giá trị cho những ô checkbox được chọn
	      var currentValue = checkboxes[i].value.split("||");
	      checkboxes[i].value = currentValue[0] + "||" + currentValue[1] + "||" + currentValue[2] + "||" + currentValue[3] + "||" + currentValue[4] + "||" + currentValue[5] + "||" + currentValue[6] + "||" +
	      currentValue[7] + "||" + currentValue[8] + "||" + currentValue[9] + "||" + currentValue[10] + "||" + currentValue[11] + "||" + currentValue[12] + "||" + currentValue[13] + "||" + 
	      currentValue[14] + "||" + currentValue[15] + "||" + currentValue[16] + "||" + currentValue[17] + "||" + currentValue[18] + "||" + currentValue[19] + "||" + currentValue[20] + "||" + 
	      currentValue[21] + "||" + currentValue[22] + "||" + currentValue[23] + "||" + currentValue[24] + "||"  + currentValue[25]+ "||"  + currentValue[26]+ "||"  + currentValue[27]+ "||"  + currentValue[28]+ "||"  + currentValue[29]+ "||"  + currentValue[30] + "||" +  quy + "||" + nam;
	    }
	    else if(!checkboxes[i].checked)
	    	{
	    	 var currentValue = checkboxes[i].value.split("||");
		      checkboxes[i].value = [];
	    	}
	  }
	}
</script>
    <script>
	    $(document).ready(function() {
	    // Ẩn trường mã bài viết, tên bài viết và nội dung
	    $(".post_chuduan").hide();
	   /*  $(".post_thuockhoa").hide(); */
	    $(".post_thuocdanhmuc").hide();
	  
	    $(".post_thanhvienthamgia").hide();
	    $(".post_muctieuduan").hide();
	    $(".post_noidungthuchien").hide();
	    $(".post_thietbitaitro").hide();
	    $(".post_thoigianthuchien").hide();
	    $(".post_thoigianbatdau").hide();
	    $(".post_thoigianketthuc").hide();
	    $(".post_tongvon_thuchien").hide();
	    $(".post_vontaitro").hide();
	    $(".post_vonvay").hide();
	    $(".post_vonkhac").hide();
	    $(".post_vondoiung").hide();
        /////////////////////////////////////
	    $(".ppost_tongvon_thuchien").hide();
	    $(".ppost_vontaitro").hide();
	    $(".ppost_vonvay").hide();
	    $(".ppost_vonkhac").hide();
	    $(".ppost_vondoiung").hide();
	    ////////////////////////////////
	    $(".post_kinhphiduannamroi").hide();
	    $(".post_nhataitro").hide();
	    $(".post_loaivientro").hide();
	    $(".post_coquanpheduyet").hide();
	    $(".post_doitacthuchien").hide();
	    $(".post_tiendothuchien").hide();
	    $(".post_phantramtiendo").hide();
	  
	  
	    
	    
	    // Bắt sự kiện khi checkbox được chọn hoặc bỏ chọn
	    $("input[type='checkbox']").on('change', function() {
	    	
	      if ($("#chk_chuduan").is(":checked")) {
	        $(".post_chuduan").show();
	      } else {
	        $(".post_chuduan").hide();
	      }
	      if ($("#chk_thuockhoa").is(":checked")) {
		        $(".post_thuockhoa").show();
		      } else {
		        $(".post_thuockhoa").hide();
		      }
	      if ($("#chk_thuocdanhmuc").is(":checked")) {
		        $(".post_thuocdanhmuc").show();
		      } else {
		        $(".post_thuocdanhmuc").hide();
		      }
	      if ($("#chk_thanhvienthamgia").is(":checked")) {
		        $(".post_thanhvienthamgia").show();
		      } else {
		        $(".post_thanhvienthamgia").hide();
		      }
	      if ($("#chk_muctieuduan").is(":checked")) {
		        $(".post_muctieuduan").show();
		      } else {
		        $(".post_muctieuduan").hide();
		      }
	      if ($("#chk_noidungthuchien").is(":checked")) {
		        $(".post_noidungthuchien").show();
		      } else {
		        $(".post_noidungthuchien").hide();
		      }
	      if ($("#chk_thietbitaitro").is(":checked")) {
		        $(".post_thietbitaitro").show();
		      } else {
		        $(".post_thietbitaitro").hide();
		      }
	      if ($("#chk_tenduan_tiengviet").is(":checked",true)) {
	        $(".post_tenduan_tiengviet").show();
	      } else {
	        $(".post_tenduan_tiengviet ").hide();
	      }
	      
	      if ($("#chk_tenduan_tienganh").is(":checked")) {
	        $(".post_tenduan_tienganh").show();
	      } else {
	        $(".post_tenduan_tienganh").hide();
	      }
	      if ($("#chk_thoigianthuchien").is(":checked")) {
		        $(".post_thoigianthuchien").show();
		      } else {
		        $(".post_thoigianthuchien").hide();
		      }
	      if ($("#chk_thoigianbatdau").is(":checked")) {
		        $(".post_thoigianbatdau").show();
		      } else {
		        $(".post_thoigianbatdau").hide();
		      }
	      if ($("#chk_thoigianketthuc").is(":checked")) {
		        $(".post_thoigianketthuc").show();
		      } else {
		        $(".post_thoigianketthuc").hide();
		      }
	      if ($("#chk_tongvon_thuchien").is(":checked")) {
		        $(".post_tongvon_thuchien").show();
		        $(".ppost_tongvon_thuchien").show();
		      } else {
		        $(".post_tongvon_thuchien").hide();
		        $(".ppost_tongvon_thuchien").hide();
		      }
	      if ($("#chk_vontaitro").is(":checked")) {
		        $(".post_vontaitro").show();
		        $(".ppost_vontaitro").show();
		      } else {
		        $(".post_vontaitro").hide();
		        $(".ppost_vontaitro").hide();
		      }
	      if ($("#chk_vonvay").is(":checked")) {
		        $(".post_vonvay").show();
		        $(".ppost_vonvay").show();
		      } else {
		        $(".post_vonvay").hide();
		        $(".ppost_vonvay").hide();
		      }
	      if ($("#chk_vonkhac").is(":checked")) {
		        $(".post_vonkhac").show();
		        $(".ppost_vonkhac").show();
		      } else {
		        $(".post_vonkhac").hide();
		        $(".ppost_vonkhac").hide();
		      }
	      if ($("#chk_vondoiung").is(":checked")) {
		        $(".post_vondoiung").show();
		        $(".ppost_vondoiung").show();
		      } else {
		        $(".post_vondoiung").hide();
		        $(".ppost_vondoiung").hide();
		      }
	      if ($("#chk_kinhphiduannamroi").is(":checked")) {
		        $(".post_kinhphiduannamroi").show();
		      } else {
		        $(".post_kinhphiduannamroi").hide();
		      }
	      if ($("#chk_nhataitro").is(":checked")) {
		        $(".post_nhataitro").show();
		      } else {
		        $(".post_nhataitro").hide();
		      }
	      if ($("#chk_loaivientro").is(":checked")) {
		        $(".post_loaivientro").show();
		      } else {
		        $(".post_loaivientro").hide();
		      }
	      if ($("#chk_coquanpheduyet").is(":checked")) {
		        $(".post_coquanpheduyet").show();
		      } else {
		        $(".post_coquanpheduyet").hide();
		      }
	      if ($("#chk_doitacthuchien").is(":checked")) {
		        $(".post_doitacthuchien").show();
		      } else {
		        $(".post_doitacthuchien").hide();
		      }
	      if ($("#chk_tiendothuchien").is(":checked")) {
		        $(".post_tiendothuchien").show();
		      } else {
		        $(".post_tiendothuchien").hide();
		      }
	      if ($("#chk_phantramtiendo").is(":checked")) {
		        $(".post_phantramtiendo").show();
		      } else {
		        $(".post_phantramtiendo").hide();
		      }
	      if ($("#chk_tuychon").is(":checked")) {
		        $(".post_tuychon").show();
		      } else {
		        $(".post_tuychon").hide();
		      }
	    });
	    });
	  
	  
</script>
	
</body>
</html>
























