<%-- 
    Document   : suaTT
    Created on : Nov 5, 2018, 3:46:00 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Update Thông tin</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/index.css">
	<link rel="stylesheet" href="./css/suaTT.css">
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
				<a class="p-2 text-muted" href="suaTT.jsp">Sửa TT cá nhân</a>
				<a class="p-2 text-muted" href="lienhe.html">Liên hệ</a>
			</nav>
		</div>
		<!-- end navbar -->

		<div class="jumbotron">
			<div class="row">
				<div class="col-md-4 order-md-2 mb-4">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Thông tin hiện tại</span>
					</h4>
					<ul class="list-group mb-3">
						<li class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">First Name</h6>
							</div>
							<span class="text-muted">Nguyễn Thành</span>
						</li>
						<li class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">Last Name</h6>
							</div>
							<span class="text-muted">Long</span>
						</li>
						<li class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">MSV</h6>
							</div>
							<span class="text-muted">B15DCCN100</span>
						</li>
						<li class="list-group-item d-flex justify-content-between bg-light">
							<div class="text">
								<h6 class="my-0">Class</h6>
							</div>
							<span class="text">D15CNPM05</span>
						</li>
						<li class="list-group-item d-flex justify-content-between bg-light">
							<div class="text">
								<h6 class="my-0">Email</h6>
							</div>
							<span class="text">Longdz@gmail.com</span>
						</li>
					</ul>
				</div>
				<div class="col-md-8 order-md-1">
					<h2 class="mb-3">Cập nhật thông tin</h2>
					<form class="needs-validation" novalidate>
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="firstName">First name</label>
								<input type="text" class="form-control" id="firstName" placeholder="" value="" required>
								<div class="invalid-feedback">
									Valid first name is required.
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="lastName">Last name</label>
								<input type="text" class="form-control" id="lastName" placeholder="" value="" required>
								<div class="invalid-feedback">
									Valid last name is required.
								</div>
							</div>
						</div>

						<div class="mb-3">
							<label for="username">Username</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">@</span>
								</div>
								<input type="text" class="form-control" id="username" placeholder="Username" required>
								<div class="invalid-feedback" style="width: 100%;">
									Your username is required.
								</div>
							</div>
						</div>

						<div class="mb-3">
							<label for="email">Email <span class="text-muted">(Optional)</span></label>
							<input type="email" class="form-control" id="email" placeholder="you@example.com">
							<div class="invalid-feedback">
								Please enter a valid email address for shipping updates.
							</div>
						</div>

						<div class="mb-3">
							<label for="class">Class</label>
							<input type="text" class="form-control" id="class" placeholder="1234 Main St" required>
							<div class="invalid-feedback">
								Please enter your class.
							</div>
						</div>

						<hr class="mb-4">

						<button class="btn btn-outline-primary" type="submit">Update</button>
						<button class="btn btn-outline-primary" type="submit">Hủy</button>
					</form>
				</div>
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
