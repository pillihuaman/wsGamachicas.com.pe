package common.system.webservice.Adapter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.system.AppPropertiesConfig;
import common.system.RequestResponse.JwtRequest;
import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.UsersResponse;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Users;

public class Generic<RQ, RS> {

	HelpService helpService= new HelpService();

	public RQ getRq() {
		return rq;
	}

	public void setRq(RQ rq) {
		this.rq = rq;
	}

	public RS getRs() {
		return rs;
	}

	public void setRs(RS rs) {
		this.rs = rs;
	}

	private RQ rq;
	private RS rs;
	RestTemplate restTemplate = new RestTemplate();

	public String TokenKey() {
		JwtRequest jsonRequest = new JwtRequest();
		jsonRequest.setPassword(helpService.getPassword());
		jsonRequest.setUsername(helpService.getUserName());
		ResponseEntity<?> requestJson;
		requestJson = restTemplate.postForEntity(helpService.getDomainAPICore() + "/authenticate",
				jsonRequest, String.class);
		return (String) requestJson.getBody();
	}

	@SuppressWarnings("unchecked")
	public void CallWebServiceApi(RQ request, RS reponsew, String MethodType, String url)
			throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + TokenKey());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(request);
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		if (request instanceof Users && reponsew instanceof UsersResponse && MethodType == "POST") {
			UsersResponse result = restTemplate.postForObject(url, entity, UsersResponse.class);
			;
			setRs((RS) result);
		}
		else if (request instanceof HomeViewModel && reponsew instanceof HomeViewModelResponse && MethodType == "POST") {
			HomeViewModelResponse result = restTemplate.postForObject(url, entity, HomeViewModelResponse.class);
			;
			setRs((RS) result);
		}
		else if (request instanceof Integer && reponsew instanceof HomeViewModelResponse && MethodType == "POST") {
			HomeViewModelResponse result = restTemplate.postForObject(url, entity, HomeViewModelResponse.class);
			;
			setRs((RS) result);
		}
//		if (request instanceof Producto && reponsew instanceof Producto && MethodType == "POST") {
//
//			Producto response = new Producto();
//			ResponseEntity<Producto> result = restTemplate.postForEntity(uri, request, Producto.class);
//			response = result.getBody();
//			return (T) response;
//		}
//		if (request instanceof Producto && MethodType == "POST") {
//
//			Detailproduct[] response;
//
//			ResponseEntity<Detailproduct[]> result = restTemplate.postForEntity(uri, request, Detailproduct[].class);
//			response = result.getBody();
//			return (T) response;
//		}
//		if (request instanceof Imagen && reponsew instanceof Imagen && MethodType == "POST") {
//
//			Imagen response = new Imagen();
//			ResponseEntity<Imagen> result = restTemplate.postForEntity(uri, request, Imagen.class);
//			response = result.getBody();
//			return (T) response;
//		}
//
//		if (request instanceof Imagen && reponsew instanceof HomeViewModel && MethodType == "POST") {
//
//			HomeViewModel response = new HomeViewModel();
//			ResponseEntity<HomeViewModel> result = restTemplate.postForEntity(uri, request, HomeViewModel.class);
//			response = result.getBody();
//			return (T) response;
//		}
//
//		if (request instanceof Imagen && MethodType == "POST") {
//
//			ResponseEntity<HomeViewModel[]> response = restTemplate.postForEntity(uri, request, HomeViewModel[].class);
//			// ModelEntities = ;
//
//			return (T) response.getBody();
//
//		}
//		boolean s = Detailproduct.class.isInstance(request.getClass());
//		if (request instanceof Producto && MethodType == "POST") {
//			// GenericList<reponsew> instanceof
//			ResponseEntity<HomeViewModel[]> response = restTemplate.postForEntity(uri, request, HomeViewModel[].class);
//			// ModelEntities = ;
//
//			return (T) response.getBody();
//
//		}
//
//		return null;
	}

}
