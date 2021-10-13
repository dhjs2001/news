<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>리뷰 작성</title>
<link rel="stylesheet" type="text/css"
	href="/static/css/writeReview.css">
</head>
<body>
	<div class="top">
		<span onclick="window.history.back()">←</span>
		<div class="title">${description }</div>
	</div>
	<form action="/writeReview" method="POST" enctype="multipart/form-data" onsubmit="return false">
		<div class="review">
			<span>별점과 이용경험을 남겨주세요.</span>
			<div class="rank">
				<div class="stars-container">
					<img class="star" alt="별" src="/getImage/img/grayStar.png"> <img
						class="star" alt="별" src="/getImage/img/grayStar.png"> <img
						class="star" alt="별" src="/getImage/img/grayStar.png"> <img
						class="star" alt="별" src="/getImage/img/grayStar.png"> <img
						class="star" alt="별" src="/getImage/img/grayStar.png"> <span
						class="score">0</span> <input id = "score" type="hidden" name="score" value="0">
				</div>

				<div class="review-input">
					<textarea id="review-content" name="comment" minlength="5" maxlength="400"
						placeholder="· 실 사용자의 리뷰는 상품명의 더 나은 서비스 제공과 다른 사용자들의 선택에 큰 도움이 됩니다.
· 소중한 리뷰에 대한 감사로 네이버페이 포인트 500원을 적립해드립니다.
  (단, 리뷰 포인트는 ID 당 1일 최대 5건까지 지급됩니다.)"></textarea>
					<div class="picture">
						<label for="picture-input">사진 추가</label>
						<input id="picture-input"
							type="file" multiple style="display: none">
						<div class="text-limit">
							<span>0</span>/400 (최소 5자이상)
						</div>
					</div>
					<div class="img-container"></div>
				</div>
			</div>
		</div>
		<input type="hidden" name="productId" value="${productId }">
		<input type="hidden" name="reservationId" value="${reservationId }">
		<button id="submit" type="submit">리뷰 등록</button>
		
	</form>
	<footer>
		<span>↑TOP</span><br> <br> <span>네이버(주)는 통신판매의 당사자가
			아니며,상품의정보, 거래조건, 이용 및 환불 등과 관련된 의무와 책임은 각 회원에게 있습니다.</span><br> <br>
		<span>@NAVER Corp.</span>
	</footer>
	
	
	<script type="text/javascript" src="/static/js/writeReview.js"></script>
		
</body>
</html>