package common.system.Controller;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import domain.System.BusinessEntity.Base.Detailimagen;
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
	    public ResponseEntity<byte[]> getImage(@RequestParam("id") int idimagen) throws IOException {
	    	System.out.println("ID is " + idimagen);
	    	ClassPathResource imgFile = new ClassPathResource("image/ropa.jpeg");
	        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
	        ImagenDa obj = new ImagenDa();
	        List<Imagen>  imf  =  null;
	        //byte[] bytes= null;
 	       //getimg
	       imf= obj.getimg(idimagen);
	        for (Imagen imagen : imf) {
	         bytes=imagen.getImagendata(); 
			}
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(bytes);
	    }
	 


	    
		@RequestMapping(value = "/addImagen", method = RequestMethod.POST)
		   public String singleFileUpload(@ModelAttribute("command")ViewStockBE ViewStockBE,@RequestParam("files") MultipartFile[]  files,
                   RedirectAttributes redirectAttributes) throws IOException {
			BigInteger idiamgen=null;
			BigInteger idiamgendetail=null;
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

		        	if(i==0)
		        	{
		            // Get the file and save it somewhere
		           // byte[] bytes = file.getBytes();
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
		        	 idiamgen=insert.registerImagen(crud);
		        	}
		        	 if(idiamgen!= null)
		        		 {
		        		 if(i>=0)
		        		 { 
		        			 //if( file.isEmpty())
		        			 //{
		        			ViewStockBE detalleimagen = new ViewStockBE();
		        		    Detailimagen  det = new Detailimagen();
		        		    ImagenRepository insertdet= new ImagenRepository();
		        		    MultipartFile filees = files[i];
	        			    byte[] bytess = filees.getBytes();
		        		    det.setIdimagen(idiamgen);
		        		    det.setVista(i);
		        		    det.setDescripcion("Imagen numero "+i);
		        		    det.setImagendata(bytess);
		        		    detalleimagen.setDetailimagen(det);
		        		    idiamgendetail=insertdet.insertDetailImagen(detalleimagen);
		        			 //Insertamos detalle de la imagen  
		        		 //}
		        		 }
		        		 
		        		 }		 
		        	 
		        	//zph

		            redirectAttributes.addFlashAttribute("message",
		                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

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
	    
	    @RequestMapping(value = "/DetallaImagen", method = RequestMethod.GET)
		   public ModelAndView DetallaImagen(@RequestParam("id") int idimagen, ModelMap mod) {
	    	int idimagent=idimagen;
	    	
	    	  String url ="http://localhost:8083/sid?id=";
			  List<Detailimagen> imf  = null;
			 List<String> lsturlimagen= new ArrayList<String>();
			 ImagenRepository obj = new ImagenRepository();
	           stockClothes stockClothes= new stockClothes();
				   mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
				   mod.addAttribute("Mensaje", "Registra informacion basica");
				   // model atribute para que retorne una lista de imagenes
				   imf= obj.ListaDetalleImagenXID(idimagent);
				   
				   for (Detailimagen imagen : imf) {
					   Integer s= imagen.getIdDetailImagen();
					   lsturlimagen.add(url+s);
				}
				   mod.addAttribute("listaimagenes",lsturlimagen);
				   ViewStockBE mdod = new ViewStockBE();
				   Clothingline ob = new Clothingline();
				   Imagen img = new Imagen();
				   mdod.setClothingline(ob);
				   mdod.setImagen(img);
	        byte[] bytes= null;
	        for (Detailimagen imagen : imf) {
	         bytes=imagen.getImagendata(); 
			}
	    	 return new ModelAndView("DetallaImagen", "command", new ViewStockBE());
	    }
    	   
}
