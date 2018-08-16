<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<br>
<div class="container">
	<div class="page-header">
		<h2>All ads</h2>
	</div>

	<br> <b>
		<div class="row">
			<div class="col-md-2">Title</div>
			<div class="col-md-2">Category</div>
			<div class="col-md-3">Small Description</div>
			<div class="col-md-4">Description</div>
			<div class="col-md-1">Price</div>
		</div>
	</b> <br>

	<c:forEach items="${ads}" var="ad">
		<div class="row">
			<div class="col-md-2">${ad.title}</div>
			<div class="col-md-2">
				<c:forEach items="${categories}" var="category">
					<c:if test="${category.id==ad.category_ID}">
                        ${category.name}
                    </c:if>
				</c:forEach>
			</div>
			<div class="col-md-3">${ad.smallDesc}</div>
			<div class="col-md-4">${ad.description}</div>
			<div class="col-md-1">${ad.price}$</div>
		</div>
		<br>
	</c:forEach>
</div>
<%@ include file="/include/end-html.jsp"%>