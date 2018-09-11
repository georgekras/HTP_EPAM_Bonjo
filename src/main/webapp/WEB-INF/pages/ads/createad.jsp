<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.createAd.">
	<fmt:message key="header" var="headerLoc" />
	<fmt:message key="adTitle" var="titleLoc" />
	<fmt:message key="adCategory" var="categoryLoc" />
	<fmt:message key="adSmallDesc" var="smallDescLoc" />
	<fmt:message key="adDescription" var="descriptionLoc" />
	<fmt:message key="adPrice" var="priceLoc" />
	<fmt:message key="createAdButton" var="createAdButtonLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>${headerLoc}</h2>
		</div>
		<br>
		<form id="createadForm" class="form-horizontal"
			action="bonjo?command=createad" method="post">
			<fieldset>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="title">${titleLoc}</label>
					<div class="col-md-4">
						<input id="title" name="ad_title" type="text" placeholder=""
							class="form-control input-md" value="test">
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="category_ID">${categoryLoc}</label>
					<div class="col-md-4">
						<select id="name" name="ad_category_id" class="form-control">
							<c:forEach items="${categories}" var="category">
								<option value="${category.id}" role=${category.id
									}
									${category.id==ad.category_ID?"selected":""}>
									${category.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="smallDesc">${smallDescLoc}</label>
					<div class="col-md-4">
						<input id="smallDesc" name="ad_smalldesc" type="text"
							placeholder="" class="form-control input-md" value="test">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="description">${descriptionLoc}</label>
					<div class="col-md-4">
						<textarea id="description" name="ad_description" type="text"
							placeholder="" class="form-control input-md">test</textarea>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price">${priceLoc}</label>
					<div class="col-md-2">
						<input id="price" name="ad_price" type="text" placeholder=""
							class="form-control input-md" value="333">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-outline-primary">${createAdButtonLoc}</button>
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
<script src="assets/js/createad.validation.js"></script>
<%@ include file="/include/end-html.jsp"%>