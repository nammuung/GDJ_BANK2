<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" name="productNum" value="${productDTO.productNum}">
<table>
<c:forEach items="${list}" var="dto">
	<tr>
		<td>
			<div class="form-check">
				<input class="form-check-input checks" type="checkbox"
					value="${dto.productNum}">
			</div>
		</td>
		<td>${dto.productNum}</td>
		<td>${dto.userName}</td>
		<td>${dto.replyContent}</td>

	</tr>
</c:forEach>
</table>

<div>
<%-- <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
<h3>${i}</h3>
</c:forEach> --%>

<button id="more" data-replyList-pae>더보기(${pager.page}/${pager.totalPage})</button>

</div>