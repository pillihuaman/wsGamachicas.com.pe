package common.system.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;
//import model.system.repository.stockClothes;

@Controller
public class WelcomeController {

	// inject via application.properties
	//@Value("${welcome.message:test}")
	//private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		//model.put("message", this.message);
		return "home";
	}
	   @RequestMapping(value = "/RegisterImagen", method = RequestMethod.GET)
	   public ModelAndView student( ModelMap mod) {
		   //stockClothes stockClothes= new stockClothes();
		   //mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		   //mod.addAttribute("Mensaje", "Registra informacion basica");
		   //ViewStockBE mdod = new ViewStockBE();
		   //Clothingline ob = new Clothingline();
		   //Imagen img = new Imagen();
		   //mdod.setClothingline(ob);
		   //mdod.setImagen(img);
		   
		   return new ModelAndView("RegisterImagen", "command", new ViewStockBE());
		   
	   }

}