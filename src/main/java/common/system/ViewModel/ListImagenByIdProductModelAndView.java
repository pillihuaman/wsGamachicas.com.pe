package common.system.ViewModel;

import java.util.List;

import domain.System.BusinessEntity.Base.*;

public class ListImagenByIdProductModelAndView {
	
	 public List<HomeViewModel> getListImagenByIdProduct() {
		return listImagenByIdProduct;
	}

	public void setListImagenByIdProduct(List<HomeViewModel> listImagenByIdProduct) {
		this.listImagenByIdProduct = listImagenByIdProduct;
	}

	private List<HomeViewModel> listImagenByIdProduct ;
	public List<Imagen> getLstimagen() {
		return lstimagen;
	}

	public void setLstimagen(List<Imagen> lstimagen) {
		this.lstimagen = lstimagen;
	}

	private List<Imagen> lstimagen ;
	
	
}


