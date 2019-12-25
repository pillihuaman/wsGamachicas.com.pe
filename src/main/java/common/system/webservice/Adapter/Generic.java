package common.system.webservice.Adapter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.Base.Producto;

public class Generic<T> {
	

	private T t;
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	 
	public String getTClass(T t) {
		if (t instanceof Producto )
		{
		   return Producto.class.getName();
		}

		return  "";
	}
	
public T CallWebServiceApi(T request ,String urlApiCatalogRute,String MethodType )
{
	 String uri = "http://localhost:8080/WebService/"+urlApiCatalogRute;
	 RestTemplate restTemplate = new RestTemplate();
		 //String uri="http://localhost:8080/WebService/ListaProducto";
	 if (request instanceof  ModelEntities  && MethodType == "GET" )
		{
		 ModelEntities ModelEntities= new ModelEntities();
		 ResponseEntity<ModelEntities> response =restTemplate.getForEntity(
				 uri,
				 ModelEntities.class);
		 ModelEntities = response.getBody();
          return (T)ModelEntities; 
		 
		}
	 if (request instanceof  ListImagenByIdProductModelAndView && MethodType == "POST"  )
		{
	
		    Producto prod = new Producto();
		    prod.setIdProducto(1);
		    prod.setNombre("Nombre");
		    ListImagenByIdProductModelAndView response = new ListImagenByIdProductModelAndView();
		    ResponseEntity<ListImagenByIdProductModelAndView> result = restTemplate.postForEntity(uri, prod, ListImagenByIdProductModelAndView.class);
		    response=result.getBody();
		   return (T) response;
		}
	 
	 return request;
}

}

