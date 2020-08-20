package common.system.model.response;



public class AuthenticationResponse  extends domain.System.BusinessEntity.Base.Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getId() {
		return id;
	}
	public String getToken() {
		return token;
	}
	public int getIdSystem() {
		return idSystem;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}
	private int id;
	private String token;
	private int idSystem;
}
