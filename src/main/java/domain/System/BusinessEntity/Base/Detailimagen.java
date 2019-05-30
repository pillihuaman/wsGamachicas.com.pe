package domain.System.BusinessEntity.Base;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detailimagen database table.
 * 
 */
@Entity
@NamedQuery(name="Detailimagen.findAll", query="SELECT d FROM Detailimagen d")
public class Detailimagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDetailImagen;

	private Timestamp createdate;

	private String descripcion;

	private BigInteger idimagen;

	@Lob
	private byte[] imagendata;

	@Column(name="STATUS")
	private Object status;
	//private byte status;

	private Timestamp updatedate;

	private String url;

	private int vista;

	public Detailimagen() {
	}

	public int getIdDetailImagen() {
		return this.idDetailImagen;
	}

	public void setIdDetailImagen(int idDetailImagen) {
		this.idDetailImagen = idDetailImagen;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigInteger getIdimagen() {
		return this.idimagen;
	}

	public void setIdimagen(BigInteger idimagen) {
		this.idimagen = idimagen;
	}

	public byte[] getImagendata() {
		return this.imagendata;
	}

	public void setImagendata(byte[] imagendata) {
		this.imagendata = imagendata;
	}

	public Object getStatus() {
		return this.status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVista() {
		return this.vista;
	}

	public void setVista(int vista) {
		this.vista = vista;
	}

}