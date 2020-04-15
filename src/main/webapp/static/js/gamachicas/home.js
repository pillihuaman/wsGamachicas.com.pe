$(".custom-file-input").on("change", function() {
 var fileName = $(this).val().split("\\").pop();
 $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

function CargarPOPUP(imagen) {
 debugger;
 var obj = '{"idProducto":' + imagen + '}'
 var url = document.getElementById("urldomain").value;
 var urlDetallaImagen = document.getElementById("UrlAPP").value+"/DetallaImagen?id="+imagen;
 var urlMostrarImagenPopUp = url +"/sid?id="+imagen;
 var urlHomeViewModelSelByIdDroducto =  url + "/WebService/HomeViewModelSelByIdDroducto";
$("#detalleImagenid").attr("href", urlDetallaImagen);
 // var obj = '{'+'"idProducto" : 1' +'}'
 $.ajax({
  type: "POST",
  contentType: "application/json; charset=utf-8",
  url:urlHomeViewModelSelByIdDroducto,
  // headers: {
  // 'Access-Control-Allow-Origin': '*',
  // 'Content-Type':'application/json' stringify
  // },
  data: JSON.stringify({
   'idProducto': imagen
  }),
  dataType: 'json',
  cache: false,
  success: function(data) {
   debugger;
   $("#idNombre").text(data.producto.nombre);
   $("#idDescripcion").text(data.producto.descripcion);
   $("#precioMenor").text(data.price.preciomenor + ' /s.');
   $("#precioMayor").text(data.price.preciomayor + ' /s.');
   document.getElementById("imagenpopup").src = urlMostrarImagenPopUp;

  },
  error: function(e) {

   var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + e.responseText +
    "&lt;/pre&gt;";
   $('#feedback').html(json);
   alert(e);
   console.log("ERROR : ", e);
   $("#btn-search").prop("disabled", false);

  }
 });

}

