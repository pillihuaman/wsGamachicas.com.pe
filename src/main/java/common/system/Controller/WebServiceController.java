package common.system.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import common.system.ViewModel.ModelEntities;
import common.system.webservice.Adapter.Generic;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Producto;
import model.system.Abstract.IWebService;
import model.system.repository.WebService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebService")
public class WebServiceController
{
	//parte del repositorio
	//@Autowired
	//private IWebService pro;

 @GetMapping("/ListaProducto")
 public ModelEntities ListaProducto()
 {
	 Generic<Producto,ModelEntities> t= new Generic<Producto,ModelEntities>();

	 ModelEntities response =  new ModelEntities();
	 Producto request= new Producto();
	 response=t.CallWebServiceApi(request, response ,"ListaProducto","GET" );
	return response;
 }
 @PostMapping("/GuardarProductos")
 public List<Producto> GuardarProductos(@RequestBody Producto pro)
 {
	 WebService WebService = new WebService();
	return WebService.listaProductos();
 }
 
 @RequestMapping(value = "/ProductoSel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody Producto  ProductoSel(@RequestBody Producto pro) {
  Generic<Producto ,Producto> t= new Generic<Producto,Producto>();
  Producto pro1 = null;
  pro1=   t.CallWebServiceApi(pro, new Producto(),"POST","ProductoSel");
	return pro1;
 }
 
// @RequestMapping(value  = "/ProductoSel",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
// public Producto ProductoSel(@RequestBody Producto pro ,HttpServletRequest peticion)
// {
//	 WebService WebService = new WebService();
//	 Generic<Producto ,Producto> t= new Generic<Producto,Producto>();
//	 Producto pro1 = null;
//	 pro1=   t.CallWebServiceApi(pro, new Producto(),"POST","ProductoSel");
//	return pro1;
// }  
 //Methot return entity 
// @PostMapping("/ListImagenByIdProduct")
// public List<Producto> ListImagenByIdProduct(@RequestBody Producto pro)
// {
//	 Generic<ListImagenByIdProductModelAndView,Producto> t= new Generic< ListImagenByIdProductModelAndView,Producto>();
//	 ListImagenByIdProductModelAndView pro1 =  new ListImagenByIdProductModelAndView();
//	 pro1=   t.CallWebServiceApi( new Producto(),pro1 ,"ListImagenByIdProduct","POST");
//	 WebService WebService = new WebService();
//	return WebService.listaProductos();
// }
}
