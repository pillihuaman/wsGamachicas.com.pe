CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ListDetImagenByIdProduct`( IdProducto int(11))
BEGIN
select  deti.IdDetailImagen, im.idimagen,im.DESCRIPTION,im.name,pro.IdProduct,pro.Name as NombreProducto,pre.preciomayor,
 pre.preciomenor,im.countViews
 from gamachicas.imagen im
  inner join gamachicas.product pro on pro.idimagen=im.Idimagen
  /*inner join gamachicas.stock sto on sto.IdProducto=pro.IdProducto*/
  inner join gamachicas.price  pre on pre.idproducto=pro.idproduct
  inner join gamachicas.detailimagen deti on im.idimagen=deti.idimagen
   where  pro.IdProduct=IdProducto;
END