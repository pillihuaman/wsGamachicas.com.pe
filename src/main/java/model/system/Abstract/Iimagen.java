package model.system.Abstract;

import java.util.List;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.Base.Imagen;

public interface Iimagen {

	int registerImagen (CrudImagenBE CrudImagenBE);
	int tesinsert (CrudImagenBE CrudImagenBE);
	List<Imagen> listaImagen ();
}
