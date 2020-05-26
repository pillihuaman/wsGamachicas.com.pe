package common.system.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import common.system.AppPropertiesConfig;
import common.system.MenuAPP;
import common.system.webservice.Adapter.Generic;
import domain.System.*;
import domain.System.BusinessEntity.ViewProductBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.BusinessLogic.ImagenBL;
import model.system.repository.ImagenRepository;
import model.system.repository.stockClothes;
import repository.System.DataAccess.MySql.ImagenDa;

@RestController
public class ImagenEntityController {
	 private  MenuAPP MenuAPP= new MenuAPP();
	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "C://Users//zarmir//Documents//";

	@RequestMapping(value = "/sid", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage(@RequestParam("id") int idimagen) throws IOException {
		System.out.println("ID is " + idimagen);
		ClassPathResource imgFile = new ClassPathResource("image/ropa.jpeg");
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		ImagenDa obj = new ImagenDa();
		List<Imagen> imf = null;
		// byte[] bytes= null;
		// getimg
		imf = obj.getimg(idimagen);
		for (Imagen imagen : imf) {
			bytes = imagen.getImagendata();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

	@RequestMapping(value = "/siddetalle", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImagedetalle(@RequestParam("id") int iddetalleimagen) throws IOException {
		System.out.println("ID is " + iddetalleimagen);
		ClassPathResource imgFile = new ClassPathResource("image/ropa.jpeg");
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		ImagenBL obj = new ImagenBL();
		List<Detailimagen> imf = null;
		// byte[] bytes= null;
		// getimg
		imf = obj.lstIDdetalle(iddetalleimagen);
		for (Detailimagen imagen : imf) {
			bytes = imagen.getImagendata();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

	@RequestMapping(value = "/addImagen", method = RequestMethod.POST)
	public String singleFileUpload(@ModelAttribute("command") ViewStockBE ViewStockBE,
			@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) throws IOException {
		int idiamgen = 1;
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

				if (i >= 0) {
					 if( !  files[i].isEmpty())
					 {
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

	@RequestMapping(value = "/addImagenDetail", method = RequestMethod.POST)
	public String addImagenDetail(@ModelAttribute("command") ViewStockBE ViewStockBE,
			@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) throws IOException {
		int idiamgen = 1;
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

				if (i >= 0) {
					// if( file.isEmpty())
					// {
					ViewStockBE detalleimagen = new ViewStockBE();
					Detailimagen det = new Detailimagen();
					ImagenRepository insertdet = new ImagenRepository();
					MultipartFile filees = files[i];
					byte[] bytess = filees.getBytes();
					if (bytess.length > 0) {
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
					}
					// Insertamos detalle de la imagen
					// }
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

	@RequestMapping(value = "/RegisterImagen", method = RequestMethod.GET)
	public ModelAndView upload(ModelMap mod) {
		stockClothes stockClothes = new stockClothes();
		// mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		mod.addAttribute("ListClothes", stockClothes.ListClothes());
		mod.addAttribute("Mensaje", "Registra informacion basica");
		ViewStockBE mdod = new ViewStockBE();
		Clothingline ob = new Clothingline();
		Imagen img = new Imagen();
		mdod.setClothingline(ob);
		mdod.setImagen(img);
		return new ModelAndView("RegisterImagen", "command", new ViewStockBE());
	}

//	@RequestMapping(value = "/DetallaImagen", method = RequestMethod.GET)
//	public ModelAndView DetallaImagen(@RequestParam("id") int IdImagen, ModelMap mod) {
//		AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
//		String UrlParrent = "";
//		try {
//			UrlParrent = AppPropertiesConfig.getPropValues("urlImagenAPI");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String url = UrlParrent + "/siddetalle?id=";
//		List<String> lsturlimagen = new ArrayList<String>();
//		// Call to imagen entity
//		Generic<Imagen, Imagen> Imagenservice = new Generic<Imagen, Imagen>();
//		Imagen responseimg = new Imagen();
//		Imagen requestimg = new Imagen();
//		requestimg.setIdimagen(IdImagen);
//		responseimg = Imagenservice.CallWebServiceApi(requestimg, responseimg, "POST", "ImagenSel");
//		// end call
//	
//
////		// Call to Api
//		Generic<Imagen, HomeViewModel[]> test = new Generic<Imagen, HomeViewModel[]>();
//		HomeViewModel[] HomeViewModel = null;
//		Imagen prod = new Imagen();
//		prod.setIdimagen(responseimg.getIdimagen());
//		HomeViewModel = test.CallWebServiceApi(prod, HomeViewModel, "POST", "ListDetImagenByIdImagen");
//		// end call
//
//		HomeViewModel model = new HomeViewModel();
//		for (HomeViewModel p : HomeViewModel) {
//			lsturlimagen.add(url + p.getDetailimagen().getIdDetailImagen());
//		}
//		// Call to Api
//		Generic<Producto, Detailproduct[]> objDetailProduct = new Generic<Producto, Detailproduct[]>();
//		Detailproduct[] Detailproduct = null;
//		Producto produc = new Producto();
//		produc.setIdProducto(HomeViewModel[0].getProducto().getIdProducto());
//		Detailproduct = objDetailProduct.CallWebServiceApi(produc, Detailproduct, "POST", "ListDetailProductByIdProduct");
//		// end call
//		
//	
//		mod.addAttribute("listaimagenes", lsturlimagen);
//		mod.addAttribute("DetalleProducto", HomeViewModel[0]);
//		mod.addAttribute("ListDetailProduct", Detailproduct);
//		mod.addAttribute("resultMenu",MenuAPP.ListaMenuSistema());
////	
//		return new ModelAndView("DetallaImagen", "command", model);
//	}

	@RequestMapping(value = "/registerdetalleProduct", method = RequestMethod.GET)
	public ModelAndView registerProduct(ModelMap mod) {
		stockClothes stockClothes = new stockClothes();
		mod.addAttribute("ListClothes", stockClothes.ListClothes());
		// mod.addAttribute("Mensaje", "Registra informacion basica");
		// ViewStockBE mdod = new ViewStockBE();
		// Clothingline ob = new Clothingline();
		// Imagen img = new Imagen();
		// mdod.setClothingline(ob);
		// mdod.setImagen(img);
		return new ModelAndView("registerdetalleProduct", "command", new ViewProductBE());
	}
}
