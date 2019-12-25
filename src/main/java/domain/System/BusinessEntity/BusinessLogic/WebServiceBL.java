package domain.System.BusinessEntity.BusinessLogic;

import java.util.List;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import domain.System.BusinessEntity.Base.Producto;
import repository.System.DataAccess.MySql.WebServiceDA;

public class WebServiceBL {
	  public static   List<Producto> listaProductos() 
	    { 
         return WebServiceDA.listaProductos();
	    }
	  public static    List<ListImagenByIdProductModelAndView> ListImagenByIdProduct(Producto pro)
	    { 
       return WebServiceDA.ListImagenByIdProduct(pro);
	    }
	  
	  
}
