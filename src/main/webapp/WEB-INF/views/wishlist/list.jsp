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
<title>Personal - Start Bootstrap Theme</title>
<!-- 사용전 경로를 꼭 수정 하세요 -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<!-- 사용전 경로를 꼭 수정 하세요 -->
		<c:import url="../temps/header.jsp"></c:import>

		<div class="container px-5 my-5">
			<div class="text-center mb-5">
				<h1 class="display-5 fw-bolder mb-0">
					<span class="text-gradient d-inline">Product List</span>
				</h1>
			</div>
			<!--  -->

			<div>
				<form class="row g-3">
					<div class="col-auto">
						<!-- select -->
						<select name="searchFind" class="form-select"
							aria-label="Default select example">
							<option value="searchFind1">productName</option>
							<option value="searchFind2">productContents</option>
							<option value="searchFind3">productJumsu</option>
						</select>
					</div>

					<div class="col-auto">
						<!-- search -->
						<label for="search" class="visually-hidden">Search</label> <input
							type="text" name="search" class="form-control" id="search">
					</div>
					<div class="col-auto">
						<button type="submit" class="btn btn-primary mb-3">검색</button>
					</div>
				</form>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th><div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="checkAll"> <label class="form-check-label"
									for="checkAll"> 전체선택 </label>
							</div></th>
						<th>상품번호</th>
						<th>상품명</th>
						<th>이자율</th>
						<th>평점</th>
					</tr>
				</thead>
				<tbody id="ajaxList">
					<form id="deleteform">
						<!-- ajax로 from자체를 넘기는 역할 -->
						<c:forEach items="${requestScope.list}" var="dto">
							<tr>
								<td>
									<div class="form-check">
										<input class="form-check-input checks" type="checkbox"
											name="productNum" id="checks"
											value="${pageScope.dto.productNum}">
									</div>
								</td>
								<td>${pageScope.dto.productNum}</td>
								<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
								<td>${pageScope.dto.productRate}</td>
								<td>${pageScope.dto.productJumsu}</td>
							</tr>
						</c:forEach>
					</form>
				</tbody>

			</table>
			<div>
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${!pager.start}">
							<li class="page-item"><a class="page-link"
								href="./list?page=${pager.startNum-1}&search=${pager.search}&searchFind=${pager.searchFind}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
							var="i">
							<li class="page-item"><a class="page-link"
								href="./list?page=${i}">${i}</a></li>
						</c:forEach>

						<!-- false일때만 보여지게 (true는 없어지게하는거임) -->
						<c:if test="${!pager.last}">
							<li class="page-item"><a class="page-link"
								href="./list?page=${pager.lastNum+1}&search=${pager.search}&searchFind=${pager.searchFind}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>

					</ul>
				</nav>
			</div>

			<!--  -->
			<div>
				<a href="add" class="btn btn-danger">상품등록</a>
			</div>
		</div>
		<div class="container">
			<button id="del">삭제</button>
			<button id="add">가입</button>
		</div>


	</main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정 하세요 -->
	<script src="../resources/js/wish/listcheck.js"></script>
	<c:import url="../temps/footer.jsp"></c:import>

</body>
</html>
