package common.system.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import domain.System.BusinessEntity.ViewProductBE;
import domain.System.BusinessEntity.Base.Stock;
import model.system.repository.stockClothes;
@RestController
public class StockController {
	
    @RequestMapping(value = "/registerStock", method = RequestMethod.GET)
 	  public ModelAndView registerStock( ModelMap mod) {
   	 try
	 {
   	   stockClothes stockClothes= new stockClothes();
		   mod.addAttribute("ListProduct", stockClothes.ListClothesLine());

	 }
	 catch (Exception e) {
		  throw e;
		// TODO: handle exception
	}
 	 return new ModelAndView("registerStock", "command", new Stock());  
     }
    

}
