<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Product Detail</title>
<!-- 사용전 경로를 꼭 수정 하세요 -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<!-- 사용전 경로를 꼭 수정 하세요 -->
		<c:import url="../temps/header.jsp"></c:import>
		<section class="py-5">
			<div class="container px-5 mb-5">
				<div class="text-center mb-5">
					<h1 class="display-5 fw-bolder mb-0">
						<span class="text-gradient d-inline">Prodcut Detail</span>
					</h1>
				</div>
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-11 col-xl-9 col-xxl-8">

						<!--project-->
						<div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
							<div class="card-body p-0">
								<div class="d-flex align-items-center">
									<div class="p-5">
										<div>
											<h3>${productDTO.productNum}</h3>
											<div>${productDTO.productNum}</div>
											<div>${productDTO.productName}</div>
											<div>${productDTO.productContents}</div>
											<div>${productDTO.productRate}</div>
											<div>${productDTO.productJumsu}</div>

											<div>
												<h2>FILE</h2>
											</div>
											<div>
												<c:forEach items="${productDTO.productFileDTOs}" var="f">
													<a href="/resources/upload/product/${f.fileName}">${f.oriName}</a>
												</c:forEach>

											</div>

										</div>
									</div>
								</div>
							</div>
							<div>
								<button class="btn btn-light" id="up"
									data-product-num="${productDTO.productNum}">수정</button>
								<button class="btn btn-light" id="del">삭제</button>
								<c:if test="${member ne null}">
									<button class="btn btn-light" id="create">상품가입</button>
									<button class="btn btn-light" id="wishList">관심상품</button>
								</c:if>
								<form id="frm" action="./update" method="get">
									<input type="hidden" name="productNum"
										value="${productDTO.productNum}">
								</form>
							</div>
						</div>
					</div>

				<div class="my-3" >
				<table>
					<thead>
						<tr>
							<th>Content</th>
							<th>Writer</th>
							<th>Date</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<!-- username을 미리 받음  html뿌릴때 비교하기 위해서-->
					<tbody id="replyList" data-user="${member.userName}">



					</tbody>
				</table>
				<div>
					<button id="more" data-replyList-page="1" data-replyList-totalPage="1">더보기</button>
				</div>

				</div>




					<div class="my-3">
						<form id="replyForm">
						<input type="hidden" name="productNum" value="${productDTO.productNum}">
							<div class="mb-3">
								<textarea class="form-control" id="replyContents rows="3" name="replyContent"></textarea>
									<div class="mb-3">
										<select class="form-select" name="replyJumsu" aria-label="Default select example">
  										<option value="5">5점</option>
  										<option value="4">4점</option>
  										<option value="3">3점</option>
  										<option value="2">2점</option>
  										<option value="1">1점</option>
										</select>
									</div>
										<div>
											<button type="button" class="btn btn-primary" id="replyAdd">댓글달기</button>
										</div>
							</div>
						</form>
					</div>
		</section>

	</main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정 하세요 -->
	<script src="../resources/js/productDetail.js"></script>
	<c:import url="../temps/footer.jsp"></c:import>


</body>
</html>
