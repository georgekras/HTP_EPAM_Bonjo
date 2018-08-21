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
			<c:forEach items="${ads}" var="ad">
				<div class=" col-md-4">
					<div class="card text-white bg-primary mb-3"
						style="max-width: 20rem;">
						<div class="card-header">
							<c:forEach items="${categories}" var="category">
								<c:if test="${category.id==ad.category_ID}">
                        ${category.name}
                    </c:if>
							</c:forEach>
						</div>
						<div class="card-body">
							<a href="bonjo?command=viewad&adId=<c:out value="${ad.id}"/>"
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
	<div id="pagination">

		<c:url value="/main_action" var="prev">
			<c:param name="page" value="${page-1}" />
		</c:url>
		<c:if test="${page > 1}">
			<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
		</c:if>

		<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${page == i.index}">
					<span>${i.index}</span>
				</c:when>
				<c:otherwise>
					<c:url value="/main_action" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/main_action" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>