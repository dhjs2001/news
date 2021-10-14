<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>news</title>
<link rel="stylesheet" href="/static/css/main.css">
</head>
<body>

	<div class="wrap">
		<div class="news-navigator">
			<section class="header">
				<ul>
					<li>전체언론사</li>
					<li>my뉴스</li>
				</ul>
				<div class="btn">
					<div class="left">
						<a href="#">&lt;</a>
					</div>
					<div class="right">
						<a href="#">&gt;</a>
					</div>
				</div>
			</section>
			<section class="mainArea">
				<ul class="newsNavigation"></ul>
				<section class="content">
         <!-- 여기에 template 내용이 들어감 -->
				</section>
			</section>
		</div>
	</div>
	<script src="/static/js/main.js" type="module"></script>
</body>
</html>