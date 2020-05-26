<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header" id="home">
	<div class="container">
		<ul>
			<li><a href="#" data-toggle="modal" data-target="#myModal"><i
					class="fa fa-unlock-alt" aria-hidden="true"></i>Ingresar</a></li>
			<li><a href="#" data-toggle="modal" data-target="#myModal2"><i
					class="fa fa-pencil-square-o" aria-hidden="true"></i>Salir</a></li>
			<li><i class="fa fa-phone" aria-hidden="true"></i> Telefono :+51
				933418411</li>
			<li><i class="fa fa-envelope-o" aria-hidden="true"></i> <a
				href="mailto:pillihuamanhz@gmail.com">pillihuamanhz@gmail.com</a></li>
		</ul>
	</div>
</div>
<div class="header-bot">
	<div class="header-bot_inner_wthreeinfo_header_mid">
		<div class="col-md-4 header-middle">
			<form action="#" method="post">
				<input type="search" name="search" placeholder="Search here..."
					required=""> <input type="submit" value=" ">
				<div class="clearfix"></div>
			</form>
		</div>
		<div class="col-md-5 logo_agile">
			<h1>
				<a href="${UrlAPP}"><span>G</span>amachicas <i
					class="ace-icon fa fa-shopping-bag" style="color: pink"></i> </a>
			</h1>
		</div>
		<div class="col-md-3 agileits-social top_content">
			<ul class="social-nav model-3d-0 footer-social w3_agile_social">
				<li class="share">Compartenos en:</li>
				<li>
					<div class="fb-page"
						data-href="https://www.facebook.com/GamaChicas/"
						data-tabs="timeline" data-width="12" data-height="12"
						data-small-header="false" data-adapt-container-width="true"
						data-hide-cover="false" data-show-facepile="true">
						<blockquote cite="https://www.facebook.com/GamaChicas/"
							class="fb-xfbml-parse-ignore">
							<a href="https://www.facebook.com/GamaChicas/">Fashion
								Gamachicas.com Mayoristas de Gamarra</a>
						</blockquote>
					</div>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="ban-top">
	<div class="container">
		<div class="top_nav_left">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse menu--shylock"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav menu__list">
					
							 	<c:forEach items="${resultMenu}" var="item">
						<li class="dropdown menu__item">
						<a href="${item.path}" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${item.name}<span class="caret"></span></a>
							<ul class="dropdown-menu multi-column columns-3">
								<div class="agile_inner_drop_nav_info">
									<div class="col-sm-6 multi-gd-img1 multi-gd-text ">
										<a href="mens.html"><img src="/resources/images/top2.jpg" alt=" "/></a>
									</div>
								</div>
							</ul>
					</li> 
						 </c:forEach>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="top_nav_right">
			<div class="wthreecartaits wthreecartaits2 cart cart box_1">
				<form action="#" method="post" class="last">
					<input type="hidden" name="cmd" value="_cart"> <input
						type="hidden" name="display" value="1">
					<button class="w3view-cart" type="submit" name="submit" value="">
						<i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
					</button>
				</form>

			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //banner-top -->
<!-- Modal1 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body modal-body-sub_agile">
				<div class="col-md-8 modal_body_left modal_body_left1">
					<h3 class="agileinfo_sign">
						Sign In <span>Now</span>
					</h3>
					<form action="#" method="post">
						<div class="styled-input agile-styled-input-top">
							<input type="text" name="Name" required=""> <label>Name</label>
							<span></span>
						</div>
						<div class="styled-input">
							<input type="email" name="Email" required=""> <label>Email</label>
							<span></span>
						</div>
						<input type="submit" value="Sign In">
					</form>
					<ul
						class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
						<li><a href="#" class="facebook">
								<div class="front">
									<i class="fa fa-facebook" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-facebook" aria-hidden="true"></i>
								</div>
						</a></li>
						<li><a href="#" class="twitter">
								<div class="front">
									<i class="fa fa-twitter" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-twitter" aria-hidden="true"></i>
								</div>
						</a></li>
						<li><a href="#" class="instagram">
								<div class="front">
									<i class="fa fa-instagram" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-instagram" aria-hidden="true"></i>
								</div>
						</a></li>
						<li><a href="#" class="pinterest">
								<div class="front">
									<i class="fa fa-linkedin" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-linkedin" aria-hidden="true"></i>
								</div>
						</a></li>
					</ul>
					<div class="clearfix"></div>
					<p>
						<a href="#" data-toggle="modal" data-target="#myModal2">
							Don't have an account?</a>
					</p>

				</div>
				<div class="col-md-4 modal_body_right modal_body_right1">
					<img src="/resources/images/log_pic.jpg" alt=" " />
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- //Modal content-->
	</div>
</div>
<!-- //Modal1 -->
<!-- Modal2 -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body modal-body-sub_agile">
				<div class="col-md-8 modal_body_left modal_body_left1">
					<h3 class="agileinfo_sign">
						Sign Up <span>Now</span>
					</h3>
					<form action="#" method="post">
						<div class="styled-input agile-styled-input-top">
							<input type="text" name="Name" required=""> <label>Name</label>
							<span></span>
						</div>
						<div class="styled-input">
							<input type="email" name="Email" required=""> <label>Email</label>
							<span></span>
						</div>
						<div class="styled-input">
							<input type="password" name="password" required=""> <label>Password</label>
							<span></span>
						</div>
						<div class="styled-input">
							<input type="password" name="Confirm Password" required="">
							<label>Confirm Password</label> <span></span>
						</div>
						<input type="submit" value="Sign Up">
					</form>
					<ul
						class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
						<li><a href="#" class="facebook">
								<div class="front">
									<i class="fa fa-facebook" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-facebook" aria-hidden="true"></i>
								</div>
						</a></li>
						<li><a href="#" class="twitter">
								<div class="front">
									<i class="fa fa-twitter" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-twitter" aria-hidden="true"></i>
								</div>
						</a></li>
						<li><a href="#" class="instagram">
								<div class="front">
									<i class="fa fa-instagram" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-instagram" aria-hidden="true"></i>
								</div>
						</a></li>
						<li><a href="#" class="pinterest">
								<div class="front">
									<i class="fa fa-linkedin" aria-hidden="true"></i>
								</div>
								<div class="back">
									<i class="fa fa-linkedin" aria-hidden="true"></i>
								</div>
						</a></li>
					</ul>
					<div class="clearfix"></div>
					<p>
						<a href="#">By clicking register, I agree to your terms</a>
					</p>

				</div>
				<div class="col-md-4 modal_body_right modal_body_right1">
					<img src="/resources/images/log_pic.jpg" alt=" " />
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- //Modal content-->
	</div>
</div>
<!-- //Modal2 -->

<!-- banner -->
<div id="myCarousel2" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1" class=""></li>
		<li data-target="#myCarousel" data-slide-to="2" class=""></li>
		<li data-target="#myCarousel" data-slide-to="3" class=""></li>
		<li data-target="#myCarousel" data-slide-to="4" class=""></li>
	</ol>
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<div class="container">
				<div class="carousel-caption">
					<h3>
						The Biggest <span>Sale</span>
					</h3>
					<p>Special for today</p>
					<a class="hvr-outline-out button2" href="mens.html">Comprar </a>
				</div>
			</div>
		</div>
		<div class="item item2">
			<div class="container">
				<div class="carousel-caption">
					<h3>
						Summer <span>Collection</span>
					</h3>
					<p>Nuevo modelos</p>
					<a class="hvr-outline-out button2" href="mens.html">Shop Now </a>
				</div>
			</div>
		</div>
		<div class="item item3">
			<div class="container">
				<div class="carousel-caption">
					<h3>
						The Biggest <span>Sale</span>
					</h3>
					<p>Special for today</p>
					<a class="hvr-outline-out button2" href="mens.html">Shop Now </a>
				</div>
			</div>
		</div>
		<div class="item item4">
			<div class="container">
				<div class="carousel-caption">
					<h3>
						Summer <span>Collection</span>
					</h3>
					<p>New Arrivals On Sale</p>
					<a class="hvr-outline-out button2" href="mens.html">Shop Now </a>
				</div>
			</div>
		</div>
		<div class="item item5">
			<div class="container">
				<div class="carousel-caption">
					<h3>
						The Biggest <span>Sale</span>
					</h3>
					<p>Special for today</p>
					<a class="hvr-outline-out button2" href="mens.html">Shop Now </a>
				</div>
			</div>
		</div>
	</div>
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
	<!-- The Modal -->
</div>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous"
	src="https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v6.0"></script>