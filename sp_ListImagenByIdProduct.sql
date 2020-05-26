use Gamachicas;
DELIMITER $$
DROP PROCEDURE IF EXISTS gamachicas.sp_ListImagenByIdProduct $$
CREATE PROCEDURE sp_ListImagenByIdProduct
( IN idProduct int(11))
BEGIN
SELECT im.idImagen ,
       im.Description,
	   im.CountViews,
       pro.idProduct,
       pro.name ,
	   pre.HigherPrice,
       pre.SmallerPrice
FROM   gamachicas.imagen im
       INNER JOIN gamachicas.product pro
     
     ON pro.idImagen = im.IdImagen
		INNER JOIN gamachicas.price pre
               ON pre.IdProduct = pro.idProduct
               where pro.idProduct=idProduct;
/*SELECT im.idImagen ,
       im.Description,
	   im.CountViews,
       pro.idProduct,
       pro.name ,
       pre.HigherPrice,
       pre.SmallerPrice
FROM   gamachicas.imagen im
       INNER JOIN gamachicas.product pro
               ON pro.idImagen = im.IdImagen
       INNER JOIN gamachicas.price pre
               ON pre.IdProduct = pro.idProduct
ORDER  BY im.CountViews DESC
LIMIT  20; */
 END$$
DELIMITER ;
