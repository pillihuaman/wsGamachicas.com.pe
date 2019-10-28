<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 

  <div class="container">
      <form:form method = "POST" action ="/addImagenDetail" enctype="multipart/form-data">
  <fieldset>
    <div id="legend">
      <legend class="">Registrar detalle de las imagenes</legend>
    </div>

       <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="username">Ropas</label>
        <!-- Username -->
      <label class="control-label"  for="username">Linea de Ropa:</label>
      <div class="controls">
       <select name="Clothingline.idclothingline"  class="form-control">
    <option value="-1">Selecionar..</option>
    <c:forEach items="${ListClothes}" var="item">
    <option value="<c:out value="${item.idimagen}" />"><c:out value="${ item.name}" /></option>
      </c:forEach>
  </select>
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
      <label class="control-label">Foto numero 1</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
        <br>
        <div class="control-group">
      <label class="control-label">Foto numero 2</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
        <br>
        <div class="control-group">
      <label class="control-label">Foto numero 3</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
          <div class="control-group">
      <label class="control-label">Foto numero 4</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
          <div class="control-group">
      <label class="control-label">Foto numero 5</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
          <div class="control-group">
      <label class="control-label">Foto numero 6</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
          <div class="control-group">
      <label class="control-label">Foto numero 7</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
          <div class="control-group">
      <label class="control-label">Foto numero 8</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
      <div class="control-group">
      <label class="control-label">Foto numero 9</label>
      <div class="controls">
        <input class="form-control" type="file" name="files">
      </div>
    </div>
    <br>
       <div class="control-group">
      <label class="control-label">Foto numero 10</label>
      
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
           

