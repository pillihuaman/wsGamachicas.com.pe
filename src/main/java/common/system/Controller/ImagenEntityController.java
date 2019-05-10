package common.system.Controller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;
import model.system.repository.ImagenRepository;
import model.system.repository.stockClothes;
import repository.System.DataAccess.MySql.ImagenDa;
@RestController
public class ImagenEntityController {
	  //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://Users//zarmir//Documents//";
	   @RequestMapping(value = "/sid", method = RequestMethod.GET,
	            produces = MediaType.IMAGE_JPEG_VALUE)
	    public ResponseEntity<byte[]> getImage() throws IOException {

	    	ClassPathResource imgFile = new ClassPathResource("image/ropa.jpeg");
	        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
	        ImagenDa obj = new ImagenDa();
 	        List<Imagen> imf  = null;
	        //byte[] bytes= null;
	       imf= obj.list();
	        for (Imagen imagen : imf) {
	         bytes=imagen.getImagendata(); 
			}
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(bytes);
	    }
	 


	    
		@RequestMapping(value = "/addImagen", method = RequestMethod.POST)
		   public String singleFileUpload(@ModelAttribute("command")ViewStockBE ViewStockBE,@RequestParam("file") MultipartFile file,
                   RedirectAttributes redirectAttributes) throws IOException {
			   if (file.isEmpty()) {
		            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		            return "redirect:uploadStatus";
		        }

		        try {

		            // Get the file and save it somewhere
		            byte[] bytes = file.getBytes();
		            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            Files.write(path, bytes);
		            
		            //zph
		        	ViewStockBE objs= new ViewStockBE();
		    		ImagenRepository insert= new ImagenRepository();
		        	stockClothes stockClothes= new stockClothes();
		        	Imagen img = new Imagen();
		        	img.setImagendata(bytes);
		        	img.setCreatedate(ViewStockBE.getImagen().getCreatedate());
		           	img.setCountViews(ViewStockBE.getImagen().getCountViews());
		           	img.setDescription(ViewStockBE.getImagen().getDescription());
		           	img.setIdposition(ViewStockBE.getImagen().getIdposition());
		           	img.setPositionweb(ViewStockBE.getImagen().getPositionweb());
		        	img.setName(ViewStockBE.getImagen().getName());
		        	ViewStockBE.setImagen(img);
		        	
		        	CrudImagenBE crud= new CrudImagenBE();
		        	crud.setClothingline(ViewStockBE.getClothingline());
		        	crud.setImagen(ViewStockBE.getImagen());
		        	crud.setTest(ViewStockBE.getTest());
		        	//int test=insert.tesinsert(crud);
		        	int idiamgen=insert.registerImagen(crud);
		        	stockClothes.getViewStock(objs);
		        	List<Imagen> imf  = null;
		        	imf=  insert.listaImagen();
		        	//zph

		            redirectAttributes.addFlashAttribute("message",
		                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        return "uploadStatus";

		   }
		
		
	    @RequestMapping(value = "/RegisterImagen", method = RequestMethod.GET)
		   public ModelAndView upload( ModelMap mod) {
               stockClothes stockClothes= new stockClothes();
			   mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
			   mod.addAttribute("Mensaje", "Registra informacion basica");
			   ViewStockBE mdod = new ViewStockBE();
			   Clothingline ob = new Clothingline();
			   Imagen img = new Imagen();
			   mdod.setClothingline(ob);
			   mdod.setImagen(img);
	    	 return new ModelAndView("RegisterImagen", "command", new ViewStockBE());
	    }
    	   
}
