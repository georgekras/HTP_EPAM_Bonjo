<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>Create Category</h2>
		</div>
		<br>
		<form id="createcategoryForm" class="form-horizontal" action="bonjo?command=createcategory"
			method="post">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Category
						Name</label>
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
							class="btn btn-outline-primary">Submit</button>
					</div>
				</div>

			</fieldset>
		</form>

		<c:if test="${msg!=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msg}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/createcategory.validation.js"></script>
<%@ include file="/include/end-html.jsp"%>