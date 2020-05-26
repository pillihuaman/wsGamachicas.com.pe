CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetAllStockByIdImgen`( idimagen int(11))
BEGIN
select im.idimagen,im.DESCRIPTION,im.name,pro.IdProduct,pro.Name,sto.idstock,pre.preciomayor,
 pre.preciomenor
 from gamachicas.imagen im
  inner join gamachicas.product pro on pro.idimagen=im.Idimagen
  inner join gamachicas.stock sto on sto.IdProducto=pro.IdProduct
  inner join gamachicas.price  pre on pre.idproducto=pro.idproduct
   where sto.status=1 and im.STATUS=1 and im.idimagen=idimagen;   
END