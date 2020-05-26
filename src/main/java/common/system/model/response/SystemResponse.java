package common.system.model.response;

import java.util.List;

import domain.System.BusinessEntity.Base.Response;
import domain.System.BusinessEntity.Base.Systems;



public class SystemResponse extends Response {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Systems system;

	public Systems getSystem() {
		return system;
	}

	public List<Systems> getListSystem() {
		return listSystem;
	}

	public void setSystem(Systems system) {
		this.system = system;
	}

	public void setListSystem(List<Systems> listSystem) {
		this.listSystem = listSystem;
	}

	private List<Systems> listSystem;
}
