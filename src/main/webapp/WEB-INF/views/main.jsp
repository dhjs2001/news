<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>네이버 예약 서비스 메인 페이지</title>
<link rel="stylesheet" type="text/css" href="/static/css/main.css">
</head>
<body>
	<header>
		<!-- GNB -->
		<div id="gnb">
			<div class=gnb-image-container>
				<img class="gnb-image" alt="예약이미지"
					src="/static/img/spr_bi.c753b938cfe0481b000adab9b84a1f8c.png">
			</div>
			<div class="email-box">
				<a href="/login"> <c:choose>
						<c:when test="${not empty requestScope.email}">
						${email }
						</c:when>
						<c:otherwise>예매확인</c:otherwise>
					</c:choose>
				</a>
			</div>
		</div>

		<!-- 프로모션 영역 -->
		<div class="promotion">
			<div class="promotion-container animation">
				<c:forEach items="${promotionInfo }" var="item">
					<div class="promotion-item">
						<img alt="프로모션 이미지" src="/static/img/${item.fileName }"> <span
							class="promotion-description">${item.description }</span>
					</div>
				</c:forEach>
			</div>
		</div>


		<!-- 카테고리 영역 -->
		<ul class="category">
			<li class="clicked-list category0">전체리스트</li>
			<li class="category1">전시</li>
			<li class="category2">뮤지컬</li>
			<li class="category3">콘서트</li>
			<li class="category4">클래식</li>
			<li class="category5">연극</li>
		</ul>
		<!-- 총 개수표시 영역 -->
		<div class="total">
			바로 예매 가능한 행사가 <span class="item-length"></span>개 있습니다.
		</div>
	</header>
	<div class="content">
		<!-- 상품 리스트 영역 -->
		<div class="product-list1"></div>
		<div class="product-list2"></div>
	</div>
	<!-- 더보기 영역 -->
	<footer>
		<div class="more">
			<b>더보기</b>
		</div>
		<div class="to-top">
			<a href="#" class="top">↑TOP</a>
		</div>
	</footer>


	<script type="text/x-handlebars-template" id="product-template">
<div class ="product" onclick= "location.href = 'detail/{{{id}}}'" style="cursor:pointer;">
	<div class = "product-img">
		<img alt="product-img" src="/static/img/{{{fileName}}}">
	</div>

	<div class = "product-info">
		<div class = "product-description">
			{{{description}}}
		</div>
		<hr>
		<div class ="product-content">
			{{{content}}}
		</div>
	</div>
</div>
	</script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>
	<script type="text/javascript" src="/static/js/main.js"></script>
</body>
</html>