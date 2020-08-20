package domain.System.BusinessEntity.Base;

import java.io.Serializable;

public class HomeViewModel implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public Imagen getImagen() {
		return Imagen;
	}

	public Price getPrice() {
		return Price;
	}

	public Detailimagen getDetailimagen() {
		return Detailimagen;
	}

	public void setImagen(Imagen imagen) {
		Imagen = imagen;
	}

	public void setPrice(Price price) {
		Price = price;
	}

	public void setDetailimagen(Detailimagen detailimagen) {
		Detailimagen = detailimagen;
	}

	private Imagen Imagen;

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	private Product Product;
	private Price Price;
	private Detailimagen Detailimagen;

}
