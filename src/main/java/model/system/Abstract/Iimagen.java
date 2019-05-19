package model.system.Abstract;

import java.math.BigInteger;
import java.util.List;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import repository.System.DataAccess.MySql.ImagenDa;

public interface Iimagen {

	BigInteger registerImagen (CrudImagenBE CrudImagenBE);
	int tesinsert (CrudImagenBE CrudImagenBE);
	List<Imagen> listaImagen ();
	List<Detailimagen>  ListaDetalleImagenXID(int idimagen); 
	BigInteger insertDetailImagen (ViewStockBE ViewStockBE);
	  
}
