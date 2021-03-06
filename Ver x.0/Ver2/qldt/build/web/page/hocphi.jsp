<%-- 
    Document   : hocphi
    Created on : Nov 5, 2018, 3:41:58 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Lịch thi</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/index.css">
	<link rel="stylesheet" href="./css/tkb.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<header class="blog-header py-3">
			<div class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1">
					<a class="text-muted" href="#">Subscribe</a>
				</div>
				<div class="col-4 text-center">
					<a class="blog-header-logo text-dark" href="index.html">PTIT</a>
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center">
					<a class="text-muted" href="#">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
					</a>
					<a class="btn btn-sm btn-outline-secondary" href="login.html">Đăng nhập</a>
				</div>
			</div>
		</header>

		<!-- navbar -->
		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between">
				<a class="p-2 text-muted" href="index.html">Trang chủ</a>
				<a class="p-2 text-muted" href="tkb.html">Xem TKB</a>
				<a class="p-2 text-muted" href="lichthi.html">Xem lịch thi</a>
				<a class="p-2 text-muted" href="Diem.html">Xem điểm</a>
				<a class="p-2 text-muted" href="hocphi.html">Học phí</a>
				<a class="p-2 text-muted" href="tailieu.html">Đề thi</a>
				<a class="p-2 text-muted" href="bikip.html">Bí kíp qua môn</a>
				<a class="p-2 text-muted" href="suaTT.html">Sửa TT cá nhân</a>
				<a class="p-2 text-muted" href="lienhe.html">Liên hệ</a>
			</nav>
		</div>
		<!-- end navbar -->
			<div class="jumbotron">
				<h2 class="dark">Lịch Thi</h2>
				<div class="this-week">
					<h5>Kỳ 1 năm 4</h5>
				</div>

				<table class="table table-bordered mt-2 mb-0">
					<thead class="thead-dark">
						<tr>
							<th>STT</th>
							<th>Mã môn</th>
							<th>Tên môn</th>
							<th>Số tín chỉ</th>
							<th>Tiền nộp</th>
						</tr>
						<tbody>
							<tr>
								<td>1</td>
								<td>INT1434</td>
								<td>Lập trình web</td>
								<td>3</td>
								<td><strong>1200000 đ</strong></td>
							</tr>
							<tr>
								<td>2</td>
								<td>INT1433</td>
								<td>Lập trình mạng</td>
								<td>3</td>
								<td><strong>1200000 đ</strong></td>
							</tr>
							<tr>
								<td>Tổng cộng</td>
								<td colspan="4"><strong>2400000 đ</strong></td>
							</tr>
						</tbody>
					</thead>
				</table>
			</div>
		</div>
		
	</div>
	<footer class="blog-footer">
		<p>Trang web xây dựng cho <a href="tacgia.html">Sinh viên PTIT </a> bởi <a href="#"> Sinh viên PTIT</a>.</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>
</body>
</html>
