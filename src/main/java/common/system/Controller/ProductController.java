package common.system.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import common.system.AppPropertiesConfig;
import common.system.MenuAPP;
import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.UsersResponse;
import common.system.webservice.Adapter.Generic;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewProductBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothing;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.ListDetailproduct;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Product;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import domain.System.BusinessEntity.Base.Users;
import model.system.repository.ImagenRepository;
import model.system.repository.stockClothes;
import common.system.webservice.Adapter.HelpService;
@RestController
public class ProductController {
	@Autowired
	HelpService helpService;
  RestTemplate restTemplate = new RestTemplate();
 private  MenuAPP MenuAPP= new MenuAPP();
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
	@RequestMapping(value = "/RegisterProduct", method = RequestMethod.GET)
	public ModelAndView registerProduct(ModelMap mod) {
		stockClothes stockClothes = new stockClothes();
		//mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		return new ModelAndView("registerProduct", "command", new ViewProductBE());
	}

	@RequestMapping(value = "/RegisterProductpost", method = RequestMethod.POST)
	public String registerProductpost(@ModelAttribute("command") ViewProductBE ViewProductBE,
			@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) throws IOException {
		int idiamgen = 0;
		int idiamgendetail = 0;
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[0];
			// String description = descriptions[i];

			byte[] bytes = file.getBytes();

			if (file.isEmpty()) {
				redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
				return "redirect:uploadStatus";
			}

			if (file.isEmpty()) {
				redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
				return "redirect:uploadStatus";
			}

			try {

				if (i == 0) {
					ImagenRepository insert = new ImagenRepository();
					Imagen img = new Imagen();
					Product pro = new Product();
					Price pr = new Price();
					img.setImagendata(bytes);
					pro.setName((ViewProductBE.getProduct().getName()));
					pro.setDescription(ViewProductBE.getProduct().getDescription());
					img.setCountViews(ViewProductBE.getImagen().getCountViews());
					img.setPositionWeb(ViewProductBE.getImagen().getPositionWeb());
					pr.setHigherPrice(ViewProductBE.getPrice().getHigherPrice());
					pr.setSmallerPrice(ViewProductBE.getPrice().getSmallerPrice());
					HomeViewModel home = new HomeViewModel();
					home.setImagen(img);
					home.setPrice(pr);
					home.setProduct(pro);
					Generic<HomeViewModel,HomeViewModelResponse> generic= new Generic<HomeViewModel,HomeViewModelResponse>();
					HomeViewModelResponse response = new HomeViewModelResponse();
					generic.CallWebServiceApi(home, response, "POST",  helpService.getDomainAPICore()+"/WebServiceProduct/HomeProductIns");
					response=generic.getRs();
					//idiamgen = insert.InsertProduct(crud);
				}
				if (idiamgen != 0) {
					if (i > 0) {
						// if( file.isEmpty())
						// {
						ViewStockBE detalleimagen = new ViewStockBE();
						Detailimagen det = new Detailimagen();
						ImagenRepository insertdet = new ImagenRepository();
						MultipartFile filees = files[i];
						byte[] bytess = filees.getBytes();
						det.setIdimagen(idiamgen);
						det.setVista(i);
						det.setDescripcion("Imagen numero " + i);
						det.setImagendata(bytess);
						detalleimagen.setDetailimagen(det);
						try {
							idiamgendetail = insertdet.InsertDetalleImagen(detalleimagen);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// Insertamos detalle de la imagen
						// }
					}

				}

				// zph

				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded '" + file.getOriginalFilename() + "'");

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "uploadStatus";

	}

	@RequestMapping(value = "/ProductoDetalle", method = RequestMethod.GET)
	public ModelAndView ProductoDetalle(ModelMap mod) {
		AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
		String UrlParrent = "";
		try {
			UrlParrent = AppPropertiesConfig.getPropValues("urlImagenAPI");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebService
	
		mod.addAttribute("listaimagenes", UrlParrent);
		mod.addAttribute("resultMenu",MenuAPP.ListaMenuSistema());
				//+"/WebService"+"/DetailProductIns");
		ResponseEntity<Producto[]> result = restTemplate.postForEntity(Url()+"ListProduct", new Producto(), Producto[].class);
		mod.addAttribute("ListProduct",  result.getBody());
		Detailproduct detalleProducto= new Detailproduct();
		return new ModelAndView("ProductoDetalle", "command",   detalleProducto);
	}
	@PostMapping("/ProductoDetalleIns")
	public String saveBooks(@ModelAttribute Detailproduct[] Detailproduct, Model model) {
		 int s=0+1;
		  s=s+1;
//	    bookService.saveAll(form.getBooks());
//
//	    model.addAttribute("books", bookService.findAll());
	    return null;
	}
	
//	@RequestMapping(value = "/ProductoDetalleIns", method = RequestMethod.POST)
//	public ListDetailproduct ProductoDetalleIns(@ModelAttribute("lstDetailproduct") ListDetailproduct lstDetailproduct, RedirectAttributes redirectAttributes) throws IOException {
////		try {
//			
//		//return new ModelAndView("ProductoDetalle", "command", detalleProducto);
//		
//			int a=0;
//			a=a+1;
//
//		return null;
//
//	}
}
