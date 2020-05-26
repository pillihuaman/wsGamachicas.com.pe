package common.system.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.core.JsonProcessingException;

import common.system.AppPropertiesConfig;
import common.system.MenuAPP;
import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.UsersResponse;
import common.system.webservice.Adapter.Generic;
import common.system.webservice.Adapter.HelpService;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.Groupparameter;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Menu;
import domain.System.BusinessEntity.Base.Parameter;
import domain.System.BusinessEntity.Base.ParentMenu;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Users;
import model.system.repository.WebService;
import model.system.repository.stockClothes;
//import model.system.repository.stockClothes;
import repository.System.DataAccess.MySql.ImagenDa;

@Controller
public class WelcomeController extends MenuAPP {
	@Autowired
	HelpService helpService;
	RestTemplate restTemplate = new RestTemplate();
	List<ParentMenu> ParentMenulst = null;
	@RequestMapping("/")
	public ModelAndView welcome(Model mod) throws JsonProcessingException {
//		Generic<Users,UsersResponse> generic= new Generic<Users,UsersResponse>();
//		UsersResponse response = new UsersResponse();
//		Users user= new  Users();
//		generic.CallWebServiceApi(user, response, "POST",  helpService.getDomainAPICore()+"/userService/userSelByMail");
//		response=generic.getRs();
//		ListaProducto();
		List<HomeViewModel> lstImagenTop = new ArrayList<HomeViewModel>();
//		// Call to Api
		Integer count =20;//Cantidad de productos a devolver
		Generic<Integer,HomeViewModelResponse> generic= new Generic<Integer,HomeViewModelResponse>();
		HomeViewModelResponse response = new HomeViewModelResponse();
		generic.CallWebServiceApi(count, response, "POST",  helpService.getDomainAPICore()+"/WebServiceImagen/ListImagenByTop");
		response=generic.getRs();
////		// end call
		for (HomeViewModel objhome : response.getListHomeViewModel()) {
			objhome.getImagen().setUrl( helpService.getDomainAPICore() +"/WebServiceImagen/GetPicture?id="+objhome.getImagen().getIdImagen());
			lstImagenTop.add(objhome);
		}

//		// Call to ApiMenu
//		Groupparameter Groupparameter = new Groupparameter();
//		Groupparameter.setIdGroupparameter(1);
//		ResponseEntity<ParentMenu[]> ParentMenu = restTemplate.postForEntity(Url() + "parentmenuList", new ParentMenu(),
//				ParentMenu[].class);
//		// end call
//
//		// Call to parameter
//		Parameter parameter = new Parameter();
//		parameter.setName("API_URL"); // Call to API URL
//		ResponseEntity<Parameter[]> Parameterlist = restTemplate.postForEntity(Url() + "Parametersel", parameter,
//				Parameter[].class);
//		APIURl = Parameterlist.getBody();
//		// end call
//
//		// Call to parameter
//		Parameter apparameter = new Parameter();
//		apparameter.setName("APP_URL"); // Call to API URL
//		ResponseEntity<Parameter[]> Apparameterlist = restTemplate.postForEntity(Url() + "Parametersel", apparameter,
//				Parameter[].class);
//		APPURl = Apparameterlist.getBody();
//		// end call
//		ParentMenulst = new ArrayList<>();
//		for (ParentMenu sParentMenu : ParentMenu.getBody()) {
//			if (sParentMenu.getPath().contains("/")) {
//				String urlhome=APIURl[0].getValue()+"/"+sParentMenu.getPath();
//				sParentMenu.setPath(urlhome);
//				ParentMenulst.add(sParentMenu);
//			} else {
//				String urlhome=APPURl[0].getValue()+sParentMenu.getPath();
//				sParentMenu.setPath(urlhome);
//				ParentMenulst.add(sParentMenu);
//			}
//		}
		mod.addAttribute("DomainAPICore", helpService.getDomainAPICore());
		mod.addAttribute("DomainAPPGamachicas", helpService.getDomainAPPGamachicas());
		mod.addAttribute("lstImagenTop", lstImagenTop);
//		mod.addAttribute("UrlAPP", UrlAPP());
//		mod.addAttribute("resultMenu", ParentMenulst);
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