<%@ page language="java" pageEncoding="UTF-8"%>
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
			<h2>Create AD</h2>
		</div>
		<br>
		<form class="form-horizontal" action="create_ad_action" method="post">
			<fieldset>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Title">Title</label>
					<div class="col-md-4">
						<input id="Title" name="ad_title" type="text" placeholder=""
							class="form-control input-md" required="" value="test">
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
									${category.ID==ad.category_ID?"selected":""}>
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
							value="test">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Description">Description</label>
					<div class="col-md-4">
						<textarea id="Description" name="ad_description" type="text"
							maxlength="100" placeholder="" class="form-control input-md"
							required="">test</textarea>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Price">Price</label>
					<div class="col-md-2">
						<input id="Price" name="ad_price" type="text" placeholder=""
							class="form-control input-md" value="333">
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
<%@ include file="/include/end-html.jsp"%>