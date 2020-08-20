package common.system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ProductoResponse;
import common.system.webservice.Adapter.Generic;
import common.system.webservice.Adapter.HelpService;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Product;
import model.system.repository.WebService;


@RestController
@CrossOrigin
@RequestMapping("GamachicasService")
public class WebServiceProductController {
	@Autowired
	HelpService helpService;
//	@PostMapping("/SaveProduct")
//	public ProductoResponse SaveProduct(@RequestBody Product pro) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.SaveProduct(pro);
//	}

	@PostMapping("/ListProduct")
	public ProductoResponse ListProduct(@RequestBody String keySearch) {

		Generic<String, ProductoResponse> generic = new Generic<String, ProductoResponse>();
		ProductoResponse response = new ProductoResponse();
		String key="key";
		try {
			generic.CallWebServiceApi(keySearch, response, "POST",
					helpService.getDomainAPICore() + "/WebServiceProduct/ListProduct");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	@PostMapping("/getlist")
	public List<Product> getlist(@RequestBody String keySearch) {

		Generic<String, ProductoResponse> generic = new Generic<String, ProductoResponse>();
		ProductoResponse response = new ProductoResponse();
		String key="key";
		try {
			generic.CallWebServiceApi(keySearch, response, "POST",
					helpService.getDomainAPICore() + "/WebServiceProduct/ListProduct");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.getListProduct();
	}

//	@PostMapping(path = "/HomeProductIns", consumes = "application/json", produces = "application/json")
//	public HomeViewModelResponse HomeProductIns(@RequestBody HomeViewModel homeViewModel) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.HomeProductIns(homeViewModel);
//	}

//	@PostMapping(path = "/ListDetImagenByIdProduct", consumes = "application/json", produces = "application/json")
//	public List<HomeViewModel> ListDetImagenByIdProduct(@RequestBody Product pro) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.ListDetImagenByIdProduct(pro);
//	}
//
//	@PostMapping(path = "/ProductoSel", consumes = "application/json", produces = "application/json")
//	public ProductoResponse ProductoSel(@RequestBody Product pro) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.ProductoSel(pro);
//	}
//
//	@PostMapping(path = "/HomeViewModelSelByIdDroducto", consumes = "application/json", produces = "application/json")
//	public HomeViewModel HomeViewModelSelByIdDroducto(@RequestBody Product pro) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.HomeViewModelSelByIdDroducto(pro);
//	}
//
//	@PostMapping(path = "/DetailProductIns", consumes = "application/json", produces = "application/json")
//	public boolean DetailProductIns(@RequestBody Detailproduct pro) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.DetailProductIns(pro);
//	}
//
//	@PostMapping(path = "/ListDetailProductByIdProduct", consumes = "application/json", produces = "application/json")
//	public List<Detailproduct> ListDetailProductByIdProduct(@RequestBody Detailproduct pro) {
//		ProductRepository WebService = new ProductRepository();
//		return WebService.ListDetailProductByIdProduct(pro);
//	}

}
