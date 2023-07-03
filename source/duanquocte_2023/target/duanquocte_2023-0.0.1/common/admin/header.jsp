<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${not empty USERMODEL }">
	<aside id="layout-menu"
		class="layout-menu menu-vertical menu bg-menu-theme">

		<div class="app-brand demo">
			<a href='<c:url value="/admin"/>' class="app-brand-link"> <span
				class="app-brand-logo demo"> <svg width="25"
						viewBox="0 0 25 42" version="1.1"
						xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink">
                  <defs>
                    <path
							d="M13.7918663,0.358365126 L3.39788168,7.44174259 C0.566865006,9.69408886 -0.379795268,12.4788597 0.557900856,15.7960551 C0.68998853,16.2305145 1.09562888,17.7872135 3.12357076,19.2293357 C3.8146334,19.7207684 5.32369333,20.3834223 7.65075054,21.2172976 L7.59773219,21.2525164 L2.63468769,24.5493413 C0.445452254,26.3002124 0.0884951797,28.5083815 1.56381646,31.1738486 C2.83770406,32.8170431 5.20850219,33.2640127 7.09180128,32.5391577 C8.347334,32.0559211 11.4559176,30.0011079 16.4175519,26.3747182 C18.0338572,24.4997857 18.6973423,22.4544883 18.4080071,20.2388261 C17.963753,17.5346866 16.1776345,15.5799961 13.0496516,14.3747546 L10.9194936,13.4715819 L18.6192054,7.984237 L13.7918663,0.358365126 Z"
							id="path-1"></path>
                    <path
							d="M5.47320593,6.00457225 C4.05321814,8.216144 4.36334763,10.0722806 6.40359441,11.5729822 C8.61520715,12.571656 10.0999176,13.2171421 10.8577257,13.5094407 L15.5088241,14.433041 L18.6192054,7.984237 C15.5364148,3.11535317 13.9273018,0.573395879 13.7918663,0.358365126 C13.5790555,0.511491653 10.8061687,2.3935607 5.47320593,6.00457225 Z"
							id="path-3"></path>
                    <path
							d="M7.50063644,21.2294429 L12.3234468,23.3159332 C14.1688022,24.7579751 14.397098,26.4880487 13.008334,28.506154 C11.6195701,30.5242593 10.3099883,31.790241 9.07958868,32.3040991 C5.78142938,33.4346997 4.13234973,34 4.13234973,34 C4.13234973,34 2.75489982,33.0538207 2.37032616e-14,31.1614621 C-0.55822714,27.8186216 -0.55822714,26.0572515 -4.05231404e-15,25.8773518 C0.83734071,25.6075023 2.77988457,22.8248993 3.3049379,22.52991 C3.65497346,22.3332504 5.05353963,21.8997614 7.50063644,21.2294429 Z"
							id="path-4"></path>
                    <path
							d="M20.6,7.13333333 L25.6,13.8 C26.2627417,14.6836556 26.0836556,15.9372583 25.2,16.6 C24.8538077,16.8596443 24.4327404,17 24,17 L14,17 C12.8954305,17 12,16.1045695 12,15 C12,14.5672596 12.1403557,14.1461923 12.4,13.8 L17.4,7.13333333 C18.0627417,6.24967773 19.3163444,6.07059163 20.2,6.73333333 C20.3516113,6.84704183 20.4862915,6.981722 20.6,7.13333333 Z"
							id="path-5"></path>
                  </defs>
                  <g id="g-app-brand" stroke="none" stroke-width="1"
							fill="none" fill-rule="evenodd">
                    <g id="Brand-Logo"
							transform="translate(-27.000000, -15.000000)">
                      <g id="Icon"
							transform="translate(27.000000, 15.000000)">
                        <g id="Mask"
							transform="translate(0.000000, 8.000000)">
                          <mask id="mask-2" fill="white">
                            <use xlink:href="#path-1"></use>
                          </mask>
                          <use fill="#696cff" xlink:href="#path-1"></use>
                          <g id="Path-3" mask="url(#mask-2)">
                            <use fill="#696cff" xlink:href="#path-3"></use>
                            <use fill-opacity="0.2" fill="#FFFFFF"
							xlink:href="#path-3"></use>
                          </g>
                          <g id="Path-4" mask="url(#mask-2)">
                            <use fill="#696cff" xlink:href="#path-4"></use>
                            <use fill-opacity="0.2" fill="#FFFFFF"
							xlink:href="#path-4"></use>
                          </g>
                        </g>
                        <g id="Triangle"
							transform="translate(19.000000, 11.000000) rotate(-300.000000) translate(-19.000000, -11.000000) ">
                          <use fill="#696cff" xlink:href="#path-5"></use>
                          <use fill-opacity="0.2" fill="#FFFFFF"
							xlink:href="#path-5"></use>
                        </g>
                      </g>
                    </g>
                  </g>
                </svg>
			</span> <span style="font-size: 25px; font-weight: 20px;"
				class="app-brand-text  fw-bolder ms-2">Phòng QHDN</span>
			</a> <a href="javascript:void(0);"
				class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
				<i class="bx bx-chevron-left bx-sm align-middle"></i>
			</a>
		</div>

		<div class="menu-inner-shadow"></div>

		<ul class="menu-inner py-1">
			<!-- Dashboard -->
			<li class="menu-item active"><a href='<c:url value="/admin"/>'
				class="menu-link"> <i
					class="menu-icon tf-icons bx bx-home-circle"></i>
					<div data-i18n="Analytics">Trang chủ</div>
			</a></li>

			<!-- Layouts -->

			<c:if test="${USERMODEL.quyenHan eq 'admin'}">
				<li class="menu-header small text-uppercase"><span
					class="menu-header-text">Tính năng quản trị viên</span></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_laytoanbodanhsach_duan_dangtrienkhai?action=danhsach_duan_dangtrienkhai"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-check text-success'></i>
						<div data-i18n="Basic">Xem danh sách dự án đã gửi từ các đơn vị</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanlyduan_dabaocao?action=danhsach_duan_dabaocao&page=1&maxPageItem=40&sapxeptheothuoctinh=thuocnam&sapxeptheochieu=desc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Dự án đã báo cáo</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanlyduan_ketthuc?action=danhsach_duan_ketthuc&page=1&maxPageItem=40&sapxeptheothuoctinh=madonvitructhuoc&sapxeptheochieu=desc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Dự án đã kết thúc</div>
				</a></li>
			
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_duan?action=danhsach_duan&page=1&maxPageItem=40&sapxeptheothuoctinh=madonvitructhuoc&sapxeptheochieu=desc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Quản lý toàn bộ dự án</div>
				</a></li>
				<%--   <li class="menu-item">
              <a href='<c:url value="/admin_loc_duan_theoquynam?action=loc_duan_theoquynam&page=1&maxPageItem=10&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>' class="menu-link">
                <i style="color:#404040;" class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">Lọc dữ liệu dự án</div>
              </a>
            </li> --%>
				<%-- <li class="menu-item">
              <a href='<c:url value="/admin_quanly_duan?page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>' class="menu-link">
                <i style="color:#5589F0;" class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">Dự án đã ẩn</div>
              </a>
            </li> --%>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_nguoidung?action=danhsach_nguoidung&page=1&maxPageItem=40&sapxeptheothuoctinh=quyenhan&sapxeptheochieu=asc"/>'
					class="menu-link"> <i
						class='menu-icon bx bxs-user-detail text-warning  '></i>
						<div data-i18n="Basic">Quản lý người dùng</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_danhsach_nguoidung_dangbikhoa?action=danhsach_nguoidung_dangbikhoa"/>'
					class="menu-link"> <i
						class='menu-icon bx bxs-lock-alt text-warning'></i>
						<div data-i18n="Basic">Danh sách tài khoản chưa kích hoạt</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_thaydoithongtin"/>' class="menu-link">
						<i class=' menu-icon bx bx-user-pin text-warning'></i>
						<div data-i18n="Basic">Thông tin cá nhân</div>
				</a></li>
			</c:if>
			<!-- Components -->
			<c:if test="${USERMODEL.quyenHan eq 'manager'}">
				<li class="menu-header small text-uppercase"><span
					class="menu-header-text">Tính năng đơn vị thực hiện</span></li>
				<!-- Cards -->
				<li class="menu-item"><a
					href='<c:url value="/admin_laytoanboduan_theokhoa_dangtrienkhai?action=danhsach_duan_dangtrienkhai_cuakhoa"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-check text-success'></i>
						<div data-i18n="Basic">Dự án sắp báo cáo</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_laytoanboduan_theokhoa?action=danhsach_duan_cuakhoa&page=1&maxPageItem=40&sapxeptheothuoctinh=manguoidung&sapxeptheochieu=desc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Dự án dự án của đơn vị</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_nguoidung_khoa?action=danhsach_nguoidung_khoa&page=1&maxPageItem=40&sapxeptheothuoctinh=quyenhan&sapxeptheochieu=asc"/>'
					class="menu-link"> <i
						class='menu-icon bx bxs-user-detail text-warning  '></i>
						<div data-i18n="Basic">Thành viên trong đơn vị</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_thaydoithongtin"/>' class="menu-link">
						<i class=' menu-icon bx bx-user-pin text-warning'></i>
						<div data-i18n="Basic">Thông tin cá nhân</div>
				</a></li>
				<li class="menu-header small text-uppercase"><span
					class="menu-header-text">Đăng xuất</span></li>

				<li class="menu-item"><a
					href='<c:url value="/thoat?action=logout"/>' class="menu-link">

						<i class='menu-icon bx bx-log-in-circle text-secondary'></i>
						<div data-i18n="Basic">Đăng xuất</div>
				</a></li>
			</c:if>
			<!-- Components -->
			<c:if test="${USERMODEL.quyenHan eq 'user'}">
				<li class="menu-header small text-uppercase"><span
					class="menu-header-text">Tính năng người dùng</span></li>
				<!-- Cards -->
				<%--  <li class="menu-item">
              <a href='<c:url value="/admin_them_duan?action=them_duan"/>' class="menu-link">
                
                <i class='menu-icon bx bx-plus-circle text-info'></i>
                <div data-i18n="Basic">Thêm dự án mới</div>
              </a>
            </li> --%>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=40&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Dự án của tôi</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_danhsach_duan_dabaocao_theonguoidung?action=danhsach_duan_dabaocao_theonguoidung&page=1&maxPageItem=40&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Tra cứu dự án đã báo cáo trước đây</div>
				</a></li>
				<li class="menu-item"><a class="menu-link"
					href='<c:url value="/admin_quanly_thanhvien_cuatoi?action=danhsach_thanhvien_cuatoi&page=1&maxPageItem=40&sapxeptheothuoctinh=maduan&sapxeptheochieu=desc"/>'>
						<i class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Thành viên đang tham gia</div>
				</a></li>
				<li class="menu-item"><a class="menu-link"
					href='<c:url value="/admin_quanly_duanthamgia_cuatoi?action=danhsach_duan_dathamgia&page=1&maxPageItem=40&sapxeptheothuoctinh=maduan&sapxeptheochieu=desc"/>'>
						<i class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Dự án đã tham gia</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_lichsucapnhat?action=danhsach_lichsucapnhat&page=1&maxPageItem=40&sapxeptheothuoctinh=ngaycapnhat&sapxeptheochieu=asc"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-ul text-primary'></i>
						<div data-i18n="Basic">Lịch sử cập nhật dự án</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_them_file_dinhkem?action=them_file_dinhkem"/>'
					class="menu-link"> <i
						class='menu-icon bx bx-list-plus text-infor'></i>
						<div data-i18n="Basic">Thêm file đính kèm cho dự án</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_thaydoithongtin"/>' class="menu-link">
						<i class=' menu-icon bx bx-user-pin text-warning'></i>
						<div data-i18n="Basic">Thông tin cá nhân</div>
				</a></li>
				<li class="menu-item"><a type="button" class="menu-link"
					data-bs-toggle="popover" data-bs-offset="0,14"
					data-bs-placement="right" data-bs-html="true"
					data-bs-content="<p>Tính năng này đang trong quá trình xây dựng!.</p> <div class='d-flex justify-content-between'></div>"
					title="Thông báo!"> <i
						class=' menu-icon bx bxs-bar-chart-alt-2 text-success'></i>
						<div data-i18n="Basic">Thống kê dự án đã báo cáo trong năm</div>
				</a></li>
				<li class="menu-header small text-uppercase"><span
					class="menu-header-text">Đăng xuất</span></li>

				<li class="menu-item"><a
					href='<c:url value="/thoat?action=logout"/>' class="menu-link">

						<i class='menu-icon bx bx-log-in-circle text-secondary'></i>
						<div data-i18n="Basic">Đăng xuất</div>
				</a></li>

			</c:if>
			<c:if test="${USERMODEL.quyenHan eq 'admin' }">
				<!-- Components -->
				<li class="menu-header small text-uppercase"><span
					class="menu-header-text">Mục liên quan</span></li>
				<!-- Cards -->
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_chucvu?action=danhsach_chucvu&page=1&maxPageItem=20&sapxeptheothuoctinh=tenchucvu&sapxeptheochieu=desc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary "></i>
						<div data-i18n="Basic">Chức vụ người dùng</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_coquanpheduyet?action=danhsach_coquanpheduyet&page=1&maxPageItem=20&sapxeptheothuoctinh=macoquanpheduyet&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Cơ quan phê duyệt</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_danhmuc?action=danhsach_danhmuc&page=1&maxPageItem=20&sapxeptheothuoctinh=madanhmuc&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Danh mục dự án</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_doitacthuchien?action=danhsach_doitacthuchien&page=1&maxPageItem=20&sapxeptheothuoctinh=madoitac&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Đối tác thực hiện</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_donvitiente?action=danhsach_donvitiente&page=1&maxPageItem=20&sapxeptheothuoctinh=madonvitiente&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Đơn vị tiền tệ</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_donvitructhuoc?action=danhsach_donvitructhuoc&page=1&maxPageItem=20&sapxeptheothuoctinh=madonvitructhuoc&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Đơn vị trực thuộc</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_loaivientro?action=danhsach_loaivientro&page=1&maxPageItem=20&sapxeptheothuoctinh=maloaivientro&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Loại viện trợ</div>
				</a></li>
				<li class="menu-item"><a
					href='<c:url value="/admin_quanly_nhataitro?action=danhsach_nhataitro&page=1&maxPageItem=20&sapxeptheothuoctinh=manhataitro&sapxeptheochieu=asc"/>'
					class="menu-link"> <i 
						class="menu-icon tf-icons bx bx-collection text-primary"></i>
						<div data-i18n="Basic">Nhà tài trợ</div>
				</a></li>
			</c:if>


		</ul>
	</aside>
</c:if>

























