<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Danh sách dự án</title>
</head>
<body>
<form action="<c:url value='/admin_laytoanboduan_theokhoa?action=danhsach_duan_cuakhoa'/>" id="form_submit" method="get">
       <!-- Bootstrap Table with Header - Dark -->
       <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <div class="card">
                <h5 class="card-header">
                Danh sách dự án của khoa
             <a onclick="tableToExcel()" href="javascript:void(0);" style="margin-left:10px;float:right;" type="button" class="btn btn-info "><i class='bx bxs-download'></i> Xuất file Excel</a>
                     
               </h5>
                <div class="table-responsive text-nowrap">
                  <table class="table">
                    <thead class="table-dark">
                      <tr>
                       <th class="text-white">STT</th>
                                        <th class="text-white">Chủ dự án</th>
								     	<th class="text-white">Tên dự án(TV)</th>
										<th class="text-white">Tên dự án(TA)</th>
									    <th class="text-white">Thời gian thực hiện</th>
									    <th class="text-white">Tổng vốn</th>
									    <th class="text-white">Thuộc khoa</th>
										<th class="text-white">Danh mục</th>
										<th class="text-white">Nhà tài trợ</th>
										<th class="text-white">Loại viện trợ</th>
										<th class="text-white">Cơ quan phê duyệt</th>
										<th class="text-white">Đối tác thực hiện</th>
										<th class="text-white">Tùy chọn</th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                       <%
                      int i=1;
                    %>
                    	<c:forEach var="item" items="${duan.danhsach}" >
                      <tr>
                         <td ><%=i++ %></td>
                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.nguoidung.tenNguoiDung}</strong></td>
                      
                                        <td style="white-space: pre-wrap;">${item.tenDuAn_TiengViet}</td>
										<td style="white-space: pre-wrap;">${item.tenDuAn_TiengAnh}</td>
										<td>${item.thoiGianThucHien}</td>
										<td class="post_tongvon_thuchien" id="input_tongvonthuchien" data-value="${item.tongVonThucHien}" data-unit="${item.donViTienTe_TongVonThucHien}" data-row-id="input_tongvonthuchien_i">${item.tongVonThucHien} ${item.donViTienTe_TongVonThucHien}</td>
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
                        
                            
                             
                             
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:forEach>
      
                    </tbody>
                    		
                  </table>
                 
							
                  
                </div>
                	
						    <input type="hidden" value="" id="action" name="action"/>
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="" id="sapxeptheochieu" name="sapxeptheochieu"/>
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
              </form>
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="<c:url value='/template/twb/table2excel.js' />"></script>
    <script src="<c:url value='/template/twb/script.js' />"></script>
       <script>
window.onload = function() {
	  var inputElements = document.querySelectorAll('.post_tongvon_thuchien');

	  for (var i = 0; i < inputElements.length; i++) {
	    var input = inputElements[i];
	    var valueFromData = parseFloat(input.getAttribute("data-value"));
	    var unitFromData = input.getAttribute("data-unit");

	    var formattedValue = valueFromData.toLocaleString() + " " + unitFromData;

	    input.innerHTML = formattedValue;
	  }
	};
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
								$('#action').val('danhsach_duan_cuakhoa');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('manguoidung');
								$('#sapxeptheochieu').val('desc');
								$('#form_submit').submit();
								}
							
						}
					});
				});
	</script>
</body>
</html>