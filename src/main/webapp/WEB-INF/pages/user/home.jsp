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
	<div class="pagination">
		<ul class="pagination">
			<c:if test="${currentPage > 1}">
				<li class="page-item"><a class="page-link"
					href="bonjo?command=home&currentPage=${currentPage-1}">Previous</a>
				</li>
			</c:if>

			<c:forEach begin="1" end="${countPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<li class="page-item active"><a class="page-link"> ${i} <span
								class="sr-only">(current)</span>
						</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="bonjo?command=home&currentPage=${i}">${i}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage < countPages}">
				<li class="page-item"><a class="page-link"
					href="bonjo?command=home&currentPage=${currentPage+1}">Next</a>
				</li>
			</c:if>
		</ul>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>