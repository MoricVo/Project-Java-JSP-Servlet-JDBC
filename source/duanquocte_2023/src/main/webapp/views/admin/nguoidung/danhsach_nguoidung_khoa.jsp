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
                <h5 class="card-header">Danh sách người dùng thuộc khoa
              
                </h5>
             
                  <form action="<c:url value='/admin_quanly_nguoidung_khoa?action=danhsach_nguoidung_khoa'/>" id="form_submit" method="get">
                <div class="table-responsive text-nowrap">
                  <table class="table">
                    <thead class="table-dark">
                      <tr>
                         <th class="text-white">STT</th>
                                        <th class="text-white">Mã người dùng</th>
									    <th class="text-white">Chức vụ</th>
									    <th class="text-white">Thuộc khoa</th>
										<th class="text-white">Họ người dùng</th>
										<th class="text-white">Tên người dùng</th>
										<th class="text-white">SDT</th>
										<th class="text-white">Gmail</th>
									
										
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                      <%
                      int i=1;
                    %>
                    	<c:forEach var="item" items="${nguoidung.danhsach}" >
                      <tr>
                       <td ><%=i++ %></td>
                                        <td >USERID##${item.maNguoiDung}</td>
										<td>${item.bangchucvu.tenchucvu}</td>
										<td>${item.donvitructhuoc.tenDonViTrucThuoc}</td>
										<td>${item.hoNguoiDung}</td>
										<td>
										<img src="${pageContext.request.contextPath}/avatar_user/${item.anhDaiDien}" style="width: 30px; height: 30px;" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt="Avatar" class="rounded-circle" />
										${item.tenNguoiDung}</td>
										<td>${item.sdt}</td>
										<td>${item.gmail}</td>
									
									
                        
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
                      </form>
                
                
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
        
 <script src="<c:url value='/template/twb/table2excel.js' />"></script>
 <script src="<c:url value='/template/twb/script.js' />"></script>
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script >
	/* var totalPages=${nguoidung.totalPage};
	var currentPage=${nguoidung.page}; */
			var totalPages=${nguoidung.totalPage};
			var currentPage=${nguoidung.page};
			var limit=40;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('danhsach_nguoidung_khoa');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('quyenhan');
								$('#sapxeptheochieu').val('asc');
								$('#form_submit').submit();
								
								}
							
						}
					});
				});
	</script>
</body>
</html>

