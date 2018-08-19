<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/begin-html.jsp"%>

<script type="text/javascript" 
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js">
</script>

<script type="text/javascript">

    $(document).ready( function () {

	maxLength = $("textarea#Description").attr("maxlength");
        $("textarea#Description").after("<div><span id='remainingLengthTempId'>" 
                  + maxLength + "</span> symbols remaining.</div>");
		
        $("textarea#Description").bind("keyup change", function(){checkMaxLength(this.id,  maxLength); } )

    });

    function checkMaxLength(textareaID, maxLength){
	
        currentLengthInTextarea = $("#"+textareaID).val().length;
        $(remainingLengthTempId).text(parseInt(maxLength) - parseInt(currentLengthInTextarea));
        
		if (currentLengthInTextarea > (maxLength)) { 
			
			$("textarea#Description").val($("textarea#Description").val().slice(0, maxLength));
			$(remainingLengthTempId).text(0);
			
		}
    }
</script>

<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>Edit ad ${user_ad.title}</h2>
		</div>

		<br>
		<div class="container">
			<form class="form-horizontal"
				action="edit_ad_action=${user_ad.ID}/edit" method=post>
				<fieldset>
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Title">Title</label>
						<div class="col-md-4">
							<input id="Title" name="ad_title" type="text" placeholder=""
								class="form-control input-md" required=""
								value="${user_ad.title}">
						</div>
					</div>

					<!-- Select Basic -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="category_ID">Category</label>
						<div class="col-md-4">
							<select id="name" name="ad_category_id" class="form-control">
								<c:forEach items="${categories_list}" var="category">
									<option value="${category.ID}" role=${category.ID
									}
										${category.ID==user_ad.category_ID?"selected":""}>
										${category.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="SmallDesc">Small
							Description</label>
						<div class="col-md-4">
							<input id="SmallDesc" name="ad_smalldesc" type="text"
								placeholder="" class="form-control input-md" required=""
								value="${user_ad.smallDesc}">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Description">Description</label>
						<div class="col-md-4">
							<textarea id="Description" name="ad_description" type="text"
								maxlength="100" placeholder="" class="form-control input-md"
								required="">${user_ad.description}</textarea>
						
						</div>
					</div>


					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Price">Price $</label>
						<div class="col-md-2">
							<input id="Price" name="ad_price" type="text" placeholder=""
								class="form-control input-md" value="${user_ad.price}">
						</div>
					</div>

					<div class="row">
						<!-- Button -->
						<div class="form-group" align="center">
							<label class="col-md-6 control-label" for="Update"></label>
							<div class="col-md-6">
								<button id="Update" value="Update" name="Update"
									class="btn btn-success">Update</button>
							</div>
						</div>

						<!-- Button -->
						<div class="form-group" align="center">
							<label class="col-md-6 control-label" for="Delete"></label>
							<div class="col-md-6">
								<button id="Delete" value="Delete" name="Delete"
									class="btn btn-danger">Delete</button>
							</div>
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
</div>

<%@ include file="/include/end-html.jsp"%>