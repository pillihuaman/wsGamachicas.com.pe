package common.system.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;
import model.system.repository.stockClothes;
//import model.system.repository.stockClothes;
import repository.System.DataAccess.MySql.ImagenDa;

@Controller
public class WelcomeController {

	// inject via application.properties
	//@Value("${welcome.message:test}")
	//private String message = "Hello World";

	@RequestMapping("/")
	public ModelAndView welcome(ModelMap mod) {
		  String url ="http://localhost:8083/sid?id=";
		  List<Imagen> imf  = null;
		 List<String> lsturlimagen= new ArrayList<String>();
		  ImagenDa obj = new ImagenDa();
           stockClothes stockClothes= new stockClothes();
			   mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
			   mod.addAttribute("Mensaje", "Registra informacion basica");
			   // model atribute para que retorne una lista de imagenes
			   imf= obj.list();
			   for (Imagen imagen : imf) {
				   Integer s= imagen.getIdimagen();
				   lsturlimagen.add(url+s);
			}
			   mod.addAttribute("listaimagenes",lsturlimagen);
			   ViewStockBE mdod = new ViewStockBE();
			   Clothingline ob = new Clothingline();
			   Imagen img = new Imagen();
			   mdod.setClothingline(ob);
			   mdod.setImagen(img);
	    	 
		
		// byte[] ViewStockBE  bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
	    
	   
        byte[] bytes= null;
        for (Imagen imagen : imf) {
         bytes=imagen.getImagendata(); 
		}
        return new ModelAndView("home", "command", new ViewStockBE());
	}
	  // @RequestMapping(value = "/RegisterImagen", method = RequestMethod.GET)
	   //public ModelAndView student( ModelMap mod) {
		   //stockClothes stockClothes= new stockClothes();
		   //mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		   //mod.addAttribute("Mensaje", "Registra informacion basica");
		   //ViewStockBE mdod = new ViewStockBE();
		   //Clothingline ob = new Clothingline();
		   //Imagen img = new Imagen();
		   //mdod.setClothingline(ob);
		   //mdod.setImagen(img);
		   
		 //  return new ModelAndView("RegisterImagen", "command", new ViewStockBE());
		   
	   //}

}