package common.system.ViewModel;

import java.io.Serializable;
import java.util.List;

import domain.System.BusinessEntity.Base.Producto;

public class ModelEntities implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	private  List<Producto> listaProducto ;
	

}
