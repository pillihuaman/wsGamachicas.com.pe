package common.system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import common.system.webservice.Adapter.Generic;
import domain.System.BusinessEntity.Base.Producto;
import model.system.Abstract.IWebService;
import model.system.repository.WebService;


@RestController
@RequestMapping("WebService")
public class WebServiceController
{
	//parte del repositorio
	//@Autowired
	//private IWebService pro;
 @GetMapping("/ListaProducto")
 public ModelEntities ListaProducto()
 {
	 Generic<ModelEntities> t= new Generic<ModelEntities>();
	 ModelEntities pro =  new ModelEntities();
	 pro=  (ModelEntities) t.CallWebServiceApi(pro, "ListaProducto","GET");
	return pro;
 }
 @PostMapping("/GuardarProductos")
 public List<Producto> GuardarProductos(@RequestBody Producto pro)
 {
	 WebService WebService = new WebService();
	return WebService.listaProductos();
 }
 //Methot return entity 
 @PostMapping("/ListImagenByIdProduct")
 public List<Producto> ListImagenByIdProduct(@RequestBody Producto pro)
 {
	 Generic<ListImagenByIdProductModelAndView> t= new Generic<ListImagenByIdProductModelAndView>();
	 ListImagenByIdProductModelAndView pro1 =  new ListImagenByIdProductModelAndView();
	 pro1=   t.CallWebServiceApi(pro1, "ListImagenByIdProduct","POST");

	 
	 WebService WebService = new WebService();
	return WebService.listaProductos();
 }
}
