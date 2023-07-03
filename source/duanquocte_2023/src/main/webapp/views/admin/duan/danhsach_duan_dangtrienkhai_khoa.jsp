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
         
				<h5 class="card-header">Các dự án sắp báo cáo
                
                <a onclick="tableToExcel()" href="javascript:void(0);" style="margin-left:10px;float:right;" type="button" class="btn btn-info "><i class='bx bxs-download'></i> Xuất file Excel</a>
                       
                 </h5>
                 <form action="<c:url value='/admin_laytoanboduan_theokhoa_dangtrienkhai?action=capnhat_trangthai_them3'/>" id="form_submit" method="post">
                 
                <div class="table-responsive text-nowrap">
                  <table class="table"  id="myTable">
                    <thead class="table-dark">
                    
                      <tr>              
                                        <th class="text-white">Chọn</th>
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
                      int i=1;
                    %>
                    	<c:forEach var="item" items="${duan.danhsach}" >
                      <tr>
                      <td><input class="form-check-input" type="checkbox" name="maDonViTrucThuoc" onchange="this.value = this.checked ? '${item.maDuAn},${item.maDonViTrucThuoc}' : ''"></td>
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
             						    <td class="post_vonvay" id="input_vonvay" data-value="${item.vonVay}" data-unit="${item.donViTienTe_VonVay}" data-row-id="input_vonvay_i">${item.vonVay} ${item.donViTienTe_VonVay}</td>	
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
                              <a class="dropdown-item" href='<c:url value="/admin_chitiet_duan?maDuAn=${item.maDuAn}&action=chitiet_duan"/>'
                                ><i class='bx bxs-detail'></i> Xem chi tiết dự án</a
                              >
                           <%--    <a class="dropdown-item" href='<c:url value="/admin_sua_duan?maDuAn=${item.maDuAn}&action=sua_duan"/>'
                                ><i class="bx bx-edit-alt me-1"></i>Cập nhật</a
                              > --%>
                            <a class="dropdown-item" href='<c:url value="/admin_capnhat_trangthai_them?maDuAn=${item.maDuAn}&action=capnhat_trangthai_them0_khoa"/>'
														onclick="return confirm('Bạn có chắc loại dự án này không?');"><i class='bx bx-up-arrow'></i> Loại bỏ dự án này</a
                              >
                          
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:forEach>
      
                    </tbody>
                    		
                  </table>
                 <button style="margin-bottom:10px;margin-left:5px;" class="btn btn-primary" type="submit" onclick="return validateForm()">Gửi danh sách </button>
					
                 
                </div>
                 </form>
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
    function validateForm() {
    	  var checkboxes = document.getElementsByName("maDonViTrucThuoc");
    	  var select = document.getElementById("selectTypeOpt");
    	  var select1 = document.getElementById("selectYear");
    	  var input = document.getElementById("maDonViTrucThuoc");

    	  for (var i = 0; i < checkboxes.length; i++) {
    	    if (checkboxes[i].checked) {
    	      // Lấy giá trị từ input và kiểm tra độ dài
    	      return true; // Nếu có ít nhất một ô checkbox được chọn và input đủ 4 ký tự, cho phép submit form
    	    }
 
    	  }

    	  alert("Vui lòng chọn ít nhất một ô checkbox.");
    	  return false; // Nếu không có ô checkbox nào được chọn, ngăn cản việc submit form
    	}
    </script>
	
</body>
</html>




























