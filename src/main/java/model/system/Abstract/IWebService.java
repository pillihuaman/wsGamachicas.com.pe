package model.system.Abstract;

import java.util.List;

import org.springframework.stereotype.Service;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Producto;
public interface  IWebService 
{
 List<Producto> listaProductos();
 List<ListImagenByIdProductModelAndView> ListImagenByIdProduct(Producto pro);
}

