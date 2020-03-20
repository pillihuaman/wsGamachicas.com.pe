<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group row">
	<div class="col-sm-2">
		<c:forEach items="${listaimagenes}" var="item" varStatus="myIndex">

			<div class="">

				<img id="img${myIndex.index}" name="img${myIndex.index}"
					onclick="MostrarImagen(this.id)" width="160PX" height="160PX"
					src="<c:url value="${item}"/>" alt="" class="pro-image-front">
			</div>
		</c:forEach>
	</div>
	<div class="col-sm-6">
		<div id="myresultdo" class="img-zoom-result myresultdo imgmain center"></div>
	</div>

	<div class="col-sm-3">
	 <div class="text-success" > <h3>${DetalleProducto.name}</h3></div>
		<ul class="list-unstyled spaced">

		
			<li>
				<div class="rating inline" style="cursor: pointer;">

					<i data-alt="1" class="star-off-png" title="bad"> </i>&nbsp;<i
						data-alt="2" class="star-off-png" title="Malo"> </i>&nbsp;<i
						data-alt="3" class="star-off-png" title="Regular"> </i>&nbsp;<i
						data-alt="4" class="star-off-png" title="Bueno"> </i>&nbsp;<i
						data-alt="5" class="star-off-png" title="Excelente"> </i><input
						name="score" type="hidden">
				</div>
			</li>

			<li><i class="ace-icon fa fa-check bigger-110 green"></i> Precio
				al mayor : <span class="badge badge-danger">${DetalleProducto.preciomayor}
					s/.</span></li>
			<li><i class="ace-icon fa fa-check bigger-110 green"></i> Precio
				al menor : <span class="badge badge-danger">${DetalleProducto.preciomenor}
					s/.</span></li>

		</ul>
	</div>
</div>

<div class="col-sm-12 widget-container-col ui-sortable"
	id="widget-container-col-12">
	<div class="widget-box ui-sortable-handle" id="widget-box-10">
		<div class="widget-header widget-header-small">
			<h5 class="widget-title smaller">Detalle</h5>

			<div class="widget-toolbar no-border">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#home">Información</a>
					</li>

					<!--<li>
																<a data-toggle="tab" href="#profile">Profile</a>
															</li>-->

					<!-- <li>
																<a data-toggle="tab" href="#info">Info</a>
															</li> -->
				</ul>
			</div>
		</div>

		<div class="widget-body">
			<div class="widget-main padding-6">
				<div class="tab-content">
					<div id="home" class="tab-pane in active">
						<h1>Caferenas.</h1>
						<div class="hr hr32 hr-dotted"></div>
						<h3>Caracteristicas basicas.</h3>
						<ul class="list-unstyled">
							<li><i class="ace-icon fa fa-caret-right blue"></i>
								Tela:Piel de durazno</li>

							<li><i class="ace-icon fa fa-caret-right blue"></i> peso:12
							</li>

							<li><i class="ace-icon fa fa-caret-right blue"></i>
								color:variado</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

