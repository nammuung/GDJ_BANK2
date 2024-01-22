

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Personal - Start Bootstrap Theme</title>
<!-- 사용전 경로를 꼭 수정 하세요 -->

<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="/resources/assets/favicon.ico" />
<!-- Custom Google font-->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@100;200;300;400;500;600;700;800;900&amp;display=swap"
	rel="stylesheet" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<!-- 사용전 경로를 꼭 수정 하세요 -->

		<nav class="navbar navbar-expand-lg navbar-light bg-white py-3">
			<div class="container px-5">
				<a class="navbar-brand" href="index.html"><span
					class="fw-bolder text-primary">Start Bootstrap</span></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
						<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/product/list">Product</a></li>
						<li class="nav-item"><a class="nav-link" href="/notice/list">Notice</a></li>
						<li class="nav-item"><a class="nav-link" href="/qna/list">QnA</a></li>
					</ul>
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
						<li class="nav-item"><a class="nav-link" href="/member/login">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="/member/join">Join</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="row gx-5 justify-content-center">
			<div class="col-lg-11 col-xl-9 col-xxl-8">
				<form action="./update" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="userName" class="form-label">USER_ID</label> <input
							type="text" value="${memeber.userName}" disabled
							class="form-control" id="userName" name="userName">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">USER_PASSWORD</label> <input
							type="password" value="${member.password}" class="form-control"
							id="password" name="password">
					</div>

					<div class="mb-3">
						<label for="name" class="form-label">USER_NAME</label> <input
							type="text" value="${member.name}" class="form-control" id="name"
							name="name">
					</div>

					<div class="mb-3">
						<label for="phone" class="form-label">USER_PHONE</label> <input
							type="text" value="${member.phone}" class="form-control"
							id="phone" name="phone">
					</div>

					<div class="mb-3">
						<label for="email" class="form-label">USER_EMAIL</label> <input
							type="text" value="${member.email}" class="form-control"
							id="email" name="email">
					</div>

					<div class="mb-3">
						<label for="address" class="form-label">USER_Address</label> <input
							type="text" value="${member.address}" class="form-control"
							id="address" name="address">
					</div>
					<div class="mb-3">
						<label for="avatar" class="form-label">USER_AVATAR</label> <input
							type="file" class="form-control" id="avatar" name="avatar">
					</div>

					<button type="submit" class="btn btn-primary">update</button>
				</form>
			</div>
		</div>
	</main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정 하세요 -->

	<footer class="bg-white py-4 mt-auto">
		<div class="container px-5">
			<div
				class="row align-items-center justify-content-between flex-column flex-sm-row">
				<div class="col-auto">
					<div class="small m-0">Copyright &copy; Your Website 2023</div>
				</div>
				<div class="col-auto">
					<a class="small" href="#!">Privacy</a> <span class="mx-1">&middot;</span>
					<a class="small" href="#!">Terms</a> <span class="mx-1">&middot;</span>
					<a class="small" href="#!">Contact</a>
				</div>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>

</body>
</html>
