<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/static/css/login.css">
</head>
<body>
	<header class="top">
		<img alt="초록색 상자 안 N" src="/static/img/naverReservation.png">
	</header>
	<div class="check-email">
		<span>비회원 예약확인</span>
		<form id="login" action="/login" method="post"
			onsubmit="return check.checkEmail()">
			<div class="input-container">
				<input id="email" type="text" placeholder="예약자 이메일 입력" required
					name="email">
			</div>
			<c:if test='${not empty error }'>
				<div class="error">존재하지 않는 email입니다.</div>
			</c:if>
			<button type="submit">내 예약 확인</button>
		</form>
	</div>
	<footer>
		<a href="#">↑TOP</a> 네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과
		고나련한 의무와 책임은 각 회원에게 있습니다.<br> <br> <span class="font-black">(주)네이버
			사업자정보 ∨</span><br>
		<br> 이용약관 | <span class="bold">개인정보처리방침</span> | 네이버 예약 고객센터 <br>
		<br> @ Naver Corp.
	</footer>
	짠 로그인 페이지
	<script type="text/javascript" src="/static/js/login.js"></script>
</body>
</html>