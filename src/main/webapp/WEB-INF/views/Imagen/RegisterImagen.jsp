<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
  <div class="container">
      <form:form method = "POST" action ="/addImagen" enctype="multipart/form-data">
  <fieldset>
    <div id="legend">
      <legend class="">Registrar Informacion de la imagen</legend>
    </div>
    <div class="alert alert-warning" role="alert">
 Solo se puede registrar de 1 a 4 imagenes de un solo producto que representan las vistas de !
 Principal ,atras,Lateral, frontal.
</div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="Nombre">Nombre de la imagen:</label>
      <div class="controls">
      <form:input path = "Imagen.name" placeholder="Nombre de la imagen a guardar" class="form-control"/>
        <p class="help-block">Nombre de la imagen solo letras</p>
      </div>
    </div>
       <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="username">Linea de Ropa:</label>
      <div class="controls">
       <select name="Clothingline.idclothingline"  class="form-control">
    <option value="-1">Selecionar..</option>
    <c:forEach items="${ListClothesLine}" var="item">
    <option value="<c:out value="${item.idclothingline}" />"><c:out value="${ item.name}" /></option>
      </c:forEach>
  </select>
      </div>
    </div>
     <br>
     <div class="control-group">
     <label class="control-label">Vista que representa la Imagen</label>
    <form:textarea path = "Test.idimagen" placeholder="Dreve descripcion de la imagen caracteristicas " class="form-control"/>
    </div>
     <br>
    <div class="control-group">
      <label class="control-label">Posición en la pagina principal</label>
      <div class="controls">
      <input type="number" name="Imagen.positionweb" min="1" max="9000" class="form-control">
      </div>
    </div>
    <br>
    <div class="control-group">
      <label class="control-label">Descripción</label>
      <div class="controls">
  <form:textarea path = "Imagen.description" placeholder="Dreve descripcion de la imagen caracteristicas " class="form-control"/>
      </div>
    </div>
 <br>
  </fieldset>
  
    <div class="control-group">
      <label class="control-label">Foto Principal o Frontal</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
        <br>
        <div class="control-group">
      <label class="control-label">Foto de espalda o Trasero</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
        <br>
        <div class="control-group">
      <label class="control-label">Foto Lateral Derecho</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
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
           

</body>
</html>