package domain.System.BusinessEntity.BusinessLogic;



import java.awt.Image;
import java.util.List;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.Base.Imagen;
import repository.System.DataAccess.MySql.ImagenDa;


public class ImagenBL {
	  public static  int registerImagen(CrudImagenBE CrudImagenBE) 
	    { 
	        return ImagenDa.registerImagen(CrudImagenBE);
	    }
	  public static  int tesinsert(CrudImagenBE CrudImagenBE) 
	    { 
	        return ImagenDa.registerImagen(CrudImagenBE);
	    }
	  public static  List<Imagen> listImagen() 
	    { 
	        return ImagenDa.list();
	    }


}
