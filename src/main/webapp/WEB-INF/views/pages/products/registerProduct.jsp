<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="container">
		<form:form method="POST" action="/registerProductpost"
			enctype="multipart/form-data" class="form-inline">
			<fieldset>

				<!-- Username -->
				<label class="control-label" for="username">Linea de Ropa:</label>
				<div class="controls">
					<select name="Clothingline.idclothingline" class="form-control">
						<option value="-1">Selecionar..</option>
						<c:forEach items="${ListClothesLine}" var="item">
							<option value="<c:out value="${item.idclothingline}" />"><c:out
									value="${ item.name}" /></option>
						</c:forEach>
					</select>
				</div>

				<br>
				<div class="control-group">
					<label for="positionweb">Nombre del producto:</label>
					<form:input path="detalleProducto.description" placeholder="Nombre del producto"
						class="form-control" />

					<label for="positionweb">Posicion WEB:</label>
					<form:input path="Imagen.positionweb" placeholder="Posicion WEB"
						class="form-control" />

					<label for="CantidadViews">Cantidad Vistas:</label>
					<form:input path="Imagen.countViews" placeholder="Cantidad Vistas"
						class="form-control" />
				</div>
				<br>
				<div class="form-group">
					<label for="email">Precio al mayor:</label>
					<form:input path="Price.preciomayor" placeholder="Precio la mayor"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="email">Precio al menor:</label>
					<form:input path="Price.preciomenor" placeholder="Precio la menor"
						class="form-control" />
				</div>
				<div class="control-group">
					<label class="control-label">Descripción</label>
					<div class="controls">
						<form:textarea path="Imagen.description"
							placeholder="Dreve descripcion de la imagen caracteristicas "
							class="form-control" />
					</div>
				</div>
			</fieldset>
			<br>
			<div class="control-group">
				<label class="control-label">Foto Lateral izquierdo</label>
				<div class="controls">
					<input class="form-control" type="file" name="files">
				</div>
			</div>
			<br>
			<div class="form-group">
				<button class="btn btn-primary" type="submit">Guardar</button>
			</div>
		</form:form>
	</div>

	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" id="home-tab"
			data-toggle="tab" href="#home" role="tab" aria-controls="home"
			aria-selected="true">Home</a></li>
		<li class="nav-item"><a class="nav-link" id="profile-tab"
			data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
			aria-selected="false">Profile</a></li>
		<li class="nav-item"><a class="nav-link" id="contact-tab"
			data-toggle="tab" href="#contact" role="tab" aria-controls="contact"
			aria-selected="false">Contact</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="home" role="tabpanel"
			aria-labelledby="home-tab">.rwerwerew..</div>
		<div class="tab-pane fade" id="profile" role="tabpanel"
			aria-labelledby="profile-tab">...</div>
		<div class="tab-pane fade" id="contact" role="tabpanel"
			aria-labelledby="contact-tab">...</div>
	</div>


</body>
</html>