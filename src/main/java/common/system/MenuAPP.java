package common.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Groupparameter;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Menu;
import domain.System.BusinessEntity.Base.ParentMenu;
import domain.System.BusinessEntity.Base.Producto;

public class MenuAPP {
	private Menu menu;
	RestTemplate restTemplate = new RestTemplate();

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<ParentMenu> ListaMenuSistema() {
		List<ParentMenu> listParentMenu= null;
		AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
		String UrlParrent = "";
		try {
			UrlParrent = AppPropertiesConfig.getPropValues("urlImagenAPI");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = UrlParrent + "/sid?id=";

		// Call to ApiMenu
		Groupparameter Groupparameter = new Groupparameter();
		Groupparameter.setIdGroupparameter(1);
		ResponseEntity<ParentMenu[]> ParentMenu = restTemplate.postForEntity(Url() + "parentmenuList", new ParentMenu(),
				ParentMenu[].class);
		// end call
		listParentMenu= Arrays.asList( ParentMenu.getBody());
		return  listParentMenu;

	}
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


}
