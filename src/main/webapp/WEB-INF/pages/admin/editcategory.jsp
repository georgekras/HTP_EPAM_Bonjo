<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.editCategory.">
	<fmt:message key="categoryName" var="categoryNameLoc" />
	<fmt:message key="updateCategoryButton" var="updateCategoryButtonLoc" />
	<fmt:message key="deleteCategoryButton" var="deleteCategoryButtonLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<div class="row">
			<div class=col-md-8>
				<h4>${categoryNameLoc}</h4>
			</div>
		</div>
	</div>
	<br>
	<div class="container">
		<c:forEach items="${categories}" var="category">
			<form id="editcategoryForm" class="form-horizontal"
				action="bonjo?command=editcategory" method=post>
				<div class="row">
					<div class=col-md-1>
						<input id="id" class="form-control input-md" type="hidden"
							name="category_id" value="${category.id}" />
					</div>
					<div class=col-md-6>
						<input id="name" class="form-control input-md"
							name="category_name" value="${category.name}" />
					</div>
					<div class=col-md-2>
						<button id="Update" value="Update" name="Update"
							class="btn btn-success">${updateCategoryButtonLoc}</button>
					</div>

					<div class=col-md-2>
						<button id="Delete" value="Delete" name="Delete"
							class="btn btn-danger">${deleteCategoryButtonLoc}</button>
					</div>
				</div>
			</form>
			<br>
		</c:forEach>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/editcategory.validation.js"></script>
<%@ include file="/include/end-html.jsp"%>