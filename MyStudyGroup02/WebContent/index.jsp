<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!--
	Horizons by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->

<html>
	<head>
		<title>I am God</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="Javascript/Board/boardMove.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body class="homepage">

		<!-- Header -->
			<div id="header">
				<div class="container">
						
					<!-- Logo -->
						<h1><a href="BoardServlet?command=body" id="logo">Catch Me If You Can</a></h1>
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="BoardServlet?command=body">홈</a></li>
								<li>
									<a href="">드롭다운</a>
									<ul>
										<li><a href="#">홍민이의</a></li>
										<li><a href="#">개발일기</a></li>
										<li><a href="#">not yet</a></li>
										<li>
											<a href="">조금 더 기다려주세요</a>
											<ul>
												<li><a href="#">아직 시기가 안좋아요</a></li>
												<li><a href="#">Phasellus consequat</a></li>
												<li><a href="#">Magna phasellus</a></li>
												<li><a href="#">Etiam dolore nisl</a></li>
												<li><a href="#">Veroeros feugiat</a></li>
											</ul>
										</li>
										<li><a href="#">Veroeros feugiat</a></li>
									</ul>
								</li>
								<li><a href="#">개발중</a></li>
								<li><a href="#">개발중</a></li>
								<li><a href="BoardServlet?command=board_list">게시판</a></li>
							</ul>
						</nav>


					<!-- Banner -->
						<div id="banner">
							<div class="container">
								<section>
									<header class="major">
										<h2>김홍민 혼자 프로젝트</h2>
										
									</header>
									<a href="#" class="button alt">Sign Up</a>
								</section>			
							</div>
						</div>

				</div>
				
			</div>
			
			<!-- 회원 정보 표시!!! -->
			<div style="width:100%; height:25px;background:red; text-align:right; ">
				<c:choose>
					<c:when test="${loginUser eq null }">
						<a href="index.jsp?mode=Member/Login">로그인</a>
						<a href="#">회원가입</a>
						<a href="Idfind.do">ID찾기</a>
						<a href="pwfind.do">비밀번호 찾기</a>
					</c:when>
					
					<c:when test="${loginUser ne null }">
						<img src="" alt="이미지 고민중" style="width:30px;height:25px;">
						<p style="display:inline-block;">[${loginUser.m_id }] 님 안녕하세요.</p>
						<a href="memberUpdate.do">마이 페이지</a>
						<a href="logout.do">로그아웃</a>
					</c:when>
				</c:choose>
			</div>
			
			
			

		<!-- Featured -->
			<!-- <div class="wrapper style2">
				<section class="container">
					<header class="major">
						<h2>Nulla luctus eleifend</h2>
						<span class="byline">Mauris vulputate dolor sit amet nibh</span>
					</header>
					<div class="row no-collapse-1">
						<section class="4u">
							<a href="#" class="image feature"><img src="images/pic02.jpg" alt=""></a>
							<p>Nam in massa. Sed vel tellus. Curabitur sem urna, consequat vel, suscipit in, mattis placerat.</p>
						</section>
						<section class="4u">
							<a href="#" class="image feature"><img src="images/pic03.jpg" alt=""></a>
							<p>Donec ornare neque ac sem. Mauris aliquet. Aliquam sem leo, vulputate sed, convallis. Donec magna.</p>
						</section>
						<section class="4u">
							<a href="#" class="image feature"><img src="images/pic04.jpg" alt=""></a>
							<p>Curabitur sem urna, consequat vel, suscipit convallis sem leo, mattis placerat, nulla. Sed ac leo.</p>
						</section>
	
					</div>
				</section>
			</div> -->

		<!-- Main -->
			<div id="main" class="wrapper style1">
				<section class="container" >
					<!-- <header class="major">
						<h2>Nulla luctus eleifend</h2>
						<span class="byline">Mauris vulputate dolor sit amet nibh</span>
					</header> -->
					
					
					<div class="row"  >
					
						<!-- Content -->
						
							<div class="6u" style="width:100%">
								<section>
									<ul class="style">
										<c:if test="${param.mode eq null }">
											<script type="text/javascript">
												location.href="BoardServlet?command=body";
											</script>	
										</c:if>
										
										
										<c:if test="${param.mode != null }">
											<jsp:include page="${param.mode}.jsp" flush="false"/>	
										</c:if>
									</ul>
								</section>
							</div>
							<!-- <div class="6u">
								<section>
									<ul class="style">
										<li>
											<span class="fa fa-cogs"></span>
											<h3>Integer ultrices</h3>
											<span>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra vulputate enim.</span>
										</li>
										<li>
											<span class="fa fa-leaf"></span>
											<h3>Aliquam luctus</h3>
											<span>Pellentesque viverra vulputate enim. Aliquam erat volutpat. Maecenas condimentum enim tincidunt risus accumsan.</span>
										</li>
									</ul>
								</section>
							</div> -->

					</div>
				</section>
			</div>

		<!-- Footer -->
			<div id="footer">
				<div class="container">

					<!-- Lists -->
						<div class="row">
							<div class="8u">
								<section>
									<header class="major">
										<h2>Donec dictum metus</h2>
										<span class="byline">Quisque semper augue mattis wisi maecenas ligula</span>
									</header>
									<div class="row">
										<section class="6u">
											<ul class="default">
												<li><a href="#">Pellentesque elit non gravida blandit.</a></li>
												<li><a href="#">Lorem ipsum dolor consectetuer elit.</a></li>
												<li><a href="#">Phasellus nibh pellentesque congue.</a></li>
												<li><a href="#">Cras vitae metus aliquam  pharetra.</a></li>
											</ul>
										</section>
										<section class="6u">
											<ul class="default">
												<li><a href="#">Pellentesque elit non gravida blandit.</a></li>
												<li><a href="#">Lorem ipsum dolor consectetuer elit.</a></li>
												<li><a href="#">Phasellus nibh pellentesque congue.</a></li>
												<li><a href="#">Cras vitae metus aliquam  pharetra.</a></li>
											</ul>
										</section>
									</div>
								</section>
							</div>
							<div class="4u">
								<section>
									<header class="major">
										<h2>Donec dictum metus</h2>
										<span class="byline">Mattis wisi maecenas ligula</span>
									</header>
									<ul class="contact">
										<li>
											<span class="address">Address</span>
											<span>1234 Somewhere Road #4285 <br />Nashville, TN 00000</span>
										</li>
										<li>
											<span class="mail">Mail</span>
											<span><a href="#">someone@untitled.tld</a></span>
										</li>
										<li>
											<span class="phone">Phone</span>
											<span>(000) 000-0000</span>
										</li>
									</ul>	
								</section>
							</div>
						</div>

					<!-- Copyright -->
						<div class="copyright">
							Design: <a href="http://templated.co">TEMPLATED</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
						</div>

				</div>
			</div>

	</body>
</html>