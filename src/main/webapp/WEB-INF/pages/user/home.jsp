<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="page-header">
		<h2>All ads</h2>
	</div>

	<br>

	<div class="container">
		<div class="row">
			<c:forEach items="${ads_list}" var="ad">
				<div class=" col-md-4">
					<div class="card text-white bg-primary mb-3"
						style="max-width: 20rem;">
						<div class="card-header">
							<c:forEach items="${categories_list}" var="category">
								<c:if test="${category.ID==ad.category_ID}">
                        ${category.name}
                    </c:if>
							</c:forEach>
						</div>
						<div class="card-body">
							<a href="/ad_project/view_ad_action=<c:out value="${ad.ID}"/>"
								style="color: white;">
								<h4 class="card-title">${ad.title}</h4>
							</a>
							<p class="card-text">${ad.smallDesc}</p>
						</div>
					</div>
					<br>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>