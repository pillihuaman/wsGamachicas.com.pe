use Gamachicas;
DELIMITER $$
DROP PROCEDURE IF EXISTS gamachicas.sp_ListDetImagenByIdImagen $$
CREATE PROCEDURE sp_ListDetImagenByIdImagen
( IN IdImagen int(11))
BEGIN
 select pro.Description, pro.Name ,pro.idProduct,pri.SmallerPrice,pri.HigherPrice,
 im.CountViews,im.PositionWeb,im.idImagen,det.idDetailImagen
 from gamachicas.imagen im
 inner join gamachicas.product  pro  on im.IdImagen=pro.IdImagen
 inner join gamachicas.price pri on pri.IdProduct=pro.IdProduct
 inner join gamachicas.detailimagen det on det.IdImagen=im.IdImagen
  where im.IdImagen=IdImagen ;
 END$$
DELIMITER ;
