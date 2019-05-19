<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>    
<head>    
    <title>Gamachicas.com</title>    
</head>    
<body>    
    <c:forEach items="${listaimagenes}" var="item">
    
    	<div class="col-md-3 product-men">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img src="<c:url value="${item.url}"/>"  alt="" class="pro-image-front">
										<img src="${item.url}" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
												
										<a href="<c:url value="/DetallaImagen?id=${item.idimagen}"/>" class="link-product-add-cart" ">Ver Detalle</a>
									  
												
												</div>

											</div>
											<span class="product-new-top">New</span>
											
									</div>
									<div class="item-info-product ">
										<h4><a href="single.html">Gabi Full Sleeve Sweatshirt</a></h4>
										<div class="info-product-price">
											<span class="item_price">$45.99</span>
											<del>$69.71</del>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<form action="#" method="post">
																<fieldset>
																	<input type="hidden" name="cmd" value="_cart" />
																	<input type="hidden" name="add" value="1" />
																	<input type="hidden" name="business" value=" " />
																	<input type="hidden" name="item_name" value="Sweatshirt" />
																	<input type="hidden" name="amount" value="30.99" />
																	<input type="hidden" name="discount_amount" value="1.00" />
																	<input type="hidden" name="currency_code" value="USD" />
																	<input type="hidden" name="return" value=" " />
																	<input type="hidden" name="cancel_return" value=" " />
																	<input type="submit" name="submit" value="Pedir" class="button" />
																</fieldset>
															</form>
														</div> 
														</div>
														</div>
														</div>
</c:forEach>
	
</body>    
</html>   