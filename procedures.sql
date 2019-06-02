use Gamachicas;
DELIMITER $$
DROP PROCEDURE IF EXISTS gamachicas.sp_InsertImagen $$
CREATE PROCEDURE gamachicas.sp_InsertImagen
 (
     IN NAME VARCHAR(200),
     IN idclothing INT(11) ,
     IN idposition INT(11) ,
     IN positionweb INT(11) ,
     IN countViews INT(11) ,
     IN imagendata longblob,
     IN url  VARCHAR(200),
     IN  DESCRIPTION  VARCHAR(200),
     IN  idclothingline INT(11) ,
     out idimagen INT(11)

 )   
 BEGIN
 INSERT INTO gamachicas.imagen
(
name,
idclothing,
idposition,
positionweb,
countViews,
imagendata,
url,
DESCRIPTION,
STATUS,
createdate ,
updatedate,
idclothingline
)
VALUES
(
name,
idclothing,
idposition,
positionweb,
countViews,
imagendata,
url,
DESCRIPTION,
1,
sysdate(),
sysdate(),
idclothingline
);
-- SET idimagen = LAST_INSERT_ID();
  select  max( idimagen) as idimagen  from gamachicas.imagen;
 END$$
DELIMITER ;









use Gamachicas;
DELIMITER $$
DROP PROCEDURE IF EXISTS gamachicas.sp_InsertDetalleImagen $$
CREATE PROCEDURE gamachicas.sp_InsertDetalleImagen
 (

     IN idimagen INT(11) ,
	 IN Descripcion  VARCHAR(200),
     IN vista INT(11) ,
     IN positionweb INT(11) ,
     IN imagendata longblob,
     out IdDetailImagen INT(11)

 )   
 BEGIN
INSERT INTO gamachicas.detailimagen
(
idimagen,
Descripcion,
vista,
imagendata,
url,
createdate,
updatedate,
status)
VALUES
(
idimagen,Descripcion,vista,imagendata,null,sysdate(),sysdate(),1
);

 SET IdDetailImagen = LAST_INSERT_ID();
  select IdDetailImagen;
 END$$
DELIMITER ;






