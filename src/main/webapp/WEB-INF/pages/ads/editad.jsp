<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>Edit ad ${user_ad.title}</h2>
		</div>

		<br>
		<form id="editadForm" class="form-horizontal"
			action="bonjo?command=editad&adId=${user_ad.id}" method=post>
			<fieldset>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="title">Title</label>
					<div class="col-md-4">
						<input id="title" name="ad_title" type="text" placeholder=""
							class="form-control input-md" value="${user_ad.title}">
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="category_ID">Category</label>
					<div class="col-md-4">
						<select id="name" name="ad_category_id" class="form-control">
							<c:forEach items="${categories}" var="category">
								<option value="${category.id}" role=${category.id
									}
									${category.id==user_ad.category_ID?"selected":""}>
									${category.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="smallDesc">Small
						Description</label>
					<div class="col-md-4">
						<input id="smallDesc" name="ad_smalldesc" type="text"
							placeholder="" class="form-control input-md"
							value="${user_ad.smallDesc}">
					</div>
				</div>

				<!-- Text area-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="description">Description</label>
					<div class="col-md-4">
						<textarea id="description" name="ad_description" type="text"
							placeholder="" class="form-control input-md">${user_ad.description}</textarea>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price">Price $</label>
					<div class="col-md-2">
						<input id="price" name="ad_price" type="text" placeholder=""
							class="form-control input-md" value="${user_ad.price}">
					</div>
				</div>

				<div class="row col-md-3">
					<!-- Button -->
					<div class="form-group">
						<label class="col-md-6 control-label" for="Update"></label>
							<button id="Update" value="Update" name="Update"
								class="btn btn-success">Update</button>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-6 control-label" for="Delete"></label>
							<button id="Delete" value="Delete" name="Delete"
								class="btn btn-danger">Delete</button>
					</div>
				</div>
			</fieldset>
		</form>

		<c:if test="${msg!=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msg}"></c:out>
			</div>
		</c:if>
		<br>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/editad.validation.js"></script>
<%@ include file="/include/end-html.jsp"%>