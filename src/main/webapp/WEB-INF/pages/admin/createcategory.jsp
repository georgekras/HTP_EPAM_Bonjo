<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.createCategory.">
	<fmt:message key="header" var="headerLoc" />
	<fmt:message key="categoryName" var="categoryNameLoc" />
	<fmt:message key="createCategoryButton" var="createCategoryButtonLoc" />
</fmt:bundle>
<fmt:bundle basename="localization.msg"
	prefix="msg.message.createCategory.">
	<fmt:message key="createCategoryError" var="createCategoryErrorLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>${headerLoc}</h2>
		</div>
		<br>
		<form id="createcategoryForm" class="form-horizontal"
			action="bonjo?command=createcategory" method="post">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">${categoryNameLoc}</label>
					<div class="col-md-4">
						<input id="name" name="category_name" type="text" placeholder=""
							class="form-control input-md">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-outline-primary">${createCategoryButtonLoc}</button>
					</div>
				</div>

			</fieldset>
		</form>

		<c:if test="${not empty requestScope.createCategoryError}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${createCategoryErrorLoc}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/createcategory.validate.js"></script>
<%@ include file="/WEB-INF/include/footer.jsp"%>