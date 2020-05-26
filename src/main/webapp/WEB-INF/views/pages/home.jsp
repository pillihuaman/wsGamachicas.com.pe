<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wrapper">
	<div class="container">
		<div class="row karl-new-arrivals">
			<input id="urldomain" type="hidden" value="${DomainAPICore}">
			<input id="UrlAPP" type="hidden" value="${DomainAPPGamachicas}">
			<c:forEach items="${lstImagenTop}" var="item">
				<div
					class="col-12 col-sm-6 col-md-4 single_gallery_item women wow fadeInUpBig"
					data-wow-delay="0.2s">
					<!-- Product Image -->
					<div class="product-img">


						<img src="<c:url value="${item.getImagen().url}"/>" alt=""
							class="pro-image-front" width="181" height="360"> <img
							src="${item.getImagen().url}" alt="" class="pro-image-back"
							width="181" height="300">

						<div class="product-quicview imgpopup">
							<input type="hidden" class="hidproducto"> <a href="#"
								data-toggle="modal" data-target="#exampleModal"
								class="modalpopup"
								onclick="CargarPOPUP(${item.getImagen().idImagen});"> <i
								class="ace-icon glyphicon glyphicon-plus"></i>
							</a>
							<!-- Button trigger modal -->
						</div>
					</div>
					<!-- Product Description -->
					<div class="product-description">
						<h4 class="product-price">${item.getPrice().higherPrice}/s. 
						Por Unidad   ${item.getPrice().smallerPrice}/s.</h4>
						<p>${item.getProduct().name}</p>

						<!-- Add to Cart -->
						<a href="#" class="add-to-cart-btn">AGREGAR A LA BOLSA</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<!-- <h5 class="modal-title" id="exampleModalLabel">DESCCRIPCIÒN</h5>-->
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="quickview_body">
					<div class="container">
						<div class="row">
							<div class="col-2 col-lg-2">
								<div class="quickview_pro_img">
									<img id="imagenpopup" alt="" width="181" height="300">
								</div>
							</div>
							<div class="col-2 col-lg-2">
								<div class="">
									<h4 class="title">
										<span id="idNombre"></span>
									</h4>
									<div class="top_seller_product_rating mb-15">
										<i class="fa fa-star" aria-hidden="true"></i> <i
											class="fa fa-star" aria-hidden="true"></i> <i
											class="fa fa-star" aria-hidden="true"></i> <i
											class="fa fa-star" aria-hidden="true"></i> <i
											class="fa fa-star" aria-hidden="true"></i>
									</div>

									<span id="idDescripcion"></span>
									<h5>
										<a href="<c:url value="/DetallaImagen?id=1"/>"
											id="detalleImagenid"
											class="label label-lg label-purple arrowed">Ver Detalle</a>
									</h5>
								</div>
							</div>
							<!-- Add to Cart Form -->
							<!-- <form class="cart" method="post">
									<div class="quantity">
										<span class="qty-minus"
											onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
											class="fa fa-minus" aria-hidden="true"></i></span> <input
											type="number" class="qty-text" id="qty" step="1" min="1"
											max="12" name="quantity" value="1"> <span
											class="qty-plus"
											onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
											class="fa fa-plus" aria-hidden="true"></i></span>
									</div>
									<button type="submit" name="addtocart" value="5"
										class="cart-submit">AGREGAR A LA BOLSA</button>
									 Wishlist -->
							<!-- <div class="modal_pro_wishlist">
										<a href="wishlist.html" target="_blank"><i
											class="ti-heart"></i></a>
									</div>
									<!-- Compare -->
							<!--<div class="modal_pro_compare">
										<a href="compare.html" target="_blank"><i
											class="ti-stats-up"></i></a>
									</div>
								</form>

								<!-- <div class="share_wf mt-30">
									<p>Share With Friend</p>
									<div class="_icon">
										<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-google-plus"
											aria-hidden="true"></i></a>
									</div>
								</div> -->

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



