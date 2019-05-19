package domain.System.BusinessEntity.BusinessLogic;



import java.awt.Image;
import java.math.BigInteger;
import java.util.List;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import repository.System.DataAccess.MySql.ImagenDa;


public class ImagenBL {
	  public static  BigInteger registerImagen(CrudImagenBE CrudImagenBE) 
	    { 
	        return ImagenDa.registerImagen(CrudImagenBE);
	    }
	  
	  public static  BigInteger tesinsert(CrudImagenBE CrudImagenBE) 
	    { 
	        return ImagenDa.registerImagen(CrudImagenBE);
	    }
	  public static  List<Imagen> listImagen() 
	    { 
	        return ImagenDa.list();
	    }
	  public static  List<Detailimagen>  ListaDetalleImagenXID(int idimagen)
	    { 
	        return ImagenDa.ListaDetalleImagenXID(idimagen);
	    }
	  public static  List<Imagen> listImagenXID(int idimagen) 
	    { 
	        return ImagenDa.list();
	    }
	  public static  BigInteger RegisterDetailImagen(ViewStockBE ViewStockBE) 
	    { 
	        return ImagenDa.RegisterDetailImagen(ViewStockBE);
	    }

}
