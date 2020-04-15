package common.system.webservice.Adapter;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.system.AppPropertiesConfig;
import common.system.Help.GenericList;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;

public class Generic<S,T> {
	

	private T t;




	public S getS() {
		return s;
	}

	public void setS(S s) {
		this.s = s;
	}

	private S s;
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

public T CallWebServiceApi(S request ,T reponsew ,String MethodType,String urlApiCatalogRute    )
{
	 String uri = "http://localhost:8080/WebService/"+urlApiCatalogRute;
	 RestTemplate restTemplate = new RestTemplate();
		 //String uri="http://localhost:8080/WebService/ListaProducto";
	 if (request instanceof  Producto  && MethodType == "GET")
		{
		 ModelEntities ModelEntities= new ModelEntities();
		 ResponseEntity<ModelEntities> response =restTemplate.getForEntity(
				 uri,
				 ModelEntities.class);
		 ModelEntities = response.getBody();
          return (T)ModelEntities; 
		 
		}
	 if (request instanceof  Producto && reponsew instanceof  Producto  &&  MethodType == "POST"  )
		{
	
		    
		 Producto response = new Producto();
		    ResponseEntity<Producto> result = restTemplate.postForEntity(uri, request, Producto.class);
		    response=result.getBody();
		   return (T) response;
		}
	 if (request instanceof  Producto && MethodType == "POST"   )
		{
	
		    
		 Detailproduct[] response ;
		 
		    ResponseEntity<Detailproduct[]> result = restTemplate.postForEntity(uri, request, Detailproduct[].class);
		    response=result.getBody();
		   return (T) response;
		}
	 if (request instanceof  Imagen && reponsew instanceof  Imagen  &&  MethodType == "POST"  )
		{
	
		    
		    Imagen response = new Imagen();
		    ResponseEntity<Imagen> result = restTemplate.postForEntity(uri, request, Imagen.class);
		    response=result.getBody();
		   return (T) response;
		}

	 if (request instanceof  Imagen &&  reponsew instanceof  HomeViewModel   &&  MethodType == "POST"    )
		{
	
		    
		 HomeViewModel response = new HomeViewModel();
		    ResponseEntity<HomeViewModel> result = restTemplate.postForEntity(uri, request, HomeViewModel.class);
		    response=result.getBody();
		   return (T) response;
		}
	 
	 if (request instanceof  Imagen   && MethodType == "POST")
		{

		 ResponseEntity<HomeViewModel[]> response =restTemplate.postForEntity(
				 uri,request,
				 HomeViewModel[].class);
		 //ModelEntities = ;
		  
       return   (T) response.getBody(); 
		 
		} 
	 boolean s= Detailproduct.class.isInstance(request.getClass());
	 if (request instanceof  Producto    &&   MethodType == "POST")
		{
		 //GenericList<reponsew>  instanceof 
		 ResponseEntity<HomeViewModel[]> response =restTemplate.postForEntity(
				 uri,request,
				 HomeViewModel[].class);
		 //ModelEntities = ;
		  
       return   (T) response.getBody(); 
		 
		}
	
	 
	 return null;
}



}

