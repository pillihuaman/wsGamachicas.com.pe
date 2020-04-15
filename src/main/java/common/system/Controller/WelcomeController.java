package common.system.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import common.system.AppPropertiesConfig;

import common.system.ViewModel.ListProductViewModel;
import common.system.ViewModel.ModelEntities;
import common.system.webservice.Adapter.Generic;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;
import model.system.repository.WebService;
import model.system.repository.stockClothes;
//import model.system.repository.stockClothes;
import repository.System.DataAccess.MySql.ImagenDa;

@Controller
public class WelcomeController {
	RestTemplate restTemplate = new RestTemplate();
	// inject via application.properties
	// @Value("${welcome.message:test}")
	// private String message = "Hello World";
	public String Url()
	{
		AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
		 try {
			return AppPropertiesConfig.getPropValues("urlImagenAPI")+"/"+"WebService/";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String UrlAPP()
	{
		AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
		 try {
			return AppPropertiesConfig.getPropValues("urlImagenAPP");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/")
	public ModelAndView welcome(Model mod) {
		AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
		String UrlParrent = "";
		try {
			UrlParrent = AppPropertiesConfig.getPropValues("urlImagenAPI");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = UrlParrent + "/sid?id=";
		ListaProducto();
		List<HomeViewModel> lsturlimagen = new ArrayList<HomeViewModel>();
		// Call to Api
		ResponseEntity<HomeViewModel[]> result = restTemplate.postForEntity(Url()+"ListImagenByIdProduct", new Producto(), HomeViewModel[].class);
		// end call

		//mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		//mod.addAttribute("Mensaje", "Registra informacion basica");
		// model atribute para que retorne una lista de imagenes
		//imf = obj.list();
//		pro1.getListImagenByIdProduct();
	
		for (HomeViewModel objhome :  result.getBody()) {
			objhome.getImagen().setUrl((url + objhome.getImagen().getIdimagen()));
			lsturlimagen.add(objhome);
		}
		mod.addAttribute("urlDomain", UrlParrent);
		mod.addAttribute("listaimagenes", lsturlimagen);
		mod.addAttribute("UrlAPP", UrlAPP());
		//ViewStockBE mdod = new ViewStockBE();
		//Clothingline ob = new Clothingline();
		//Imagen img = new Imagen();
		//mdod.setClothingline(ob);
		//mdod.setImagen(img);

		// byte[] ViewStockBE bytes =
		// StreamUtils.copyToByteArray(imgFile.getInputStream());

		//byte[] bytes = null;
		//for (Imagen imagen : imf) {
			//bytes = imagen.getImagendata();
		//}
		return new ModelAndView("home", "command", new ViewStockBE());
	}

	private void ListaProducto() {
		{
			try {

				final String uri = "http://localhost:8080/WebService/ListaProducto";

				RestTemplate restTemplate = new RestTemplate();
				Producto result = restTemplate.getForObject(uri, Producto.class);
				System.out.println(result);

			} catch (Exception e) {
				throw e;
				// TODO: handle exception
			}
		}

	}

}