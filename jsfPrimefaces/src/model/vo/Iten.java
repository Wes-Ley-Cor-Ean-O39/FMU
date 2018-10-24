/*package model.vo;

import java.io.Serializable;
import javax.persistence.*;


*//**
 * The persistent class for the itens database table.
 * 
 *//*
@Entity
@Table(name="itens")
@NamedQuery(name="Iten.findAll", query="SELECT i FROM Iten i")
public class Iten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float qtd;

	private float total;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="idOrder")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	public Iten() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getQtd() {
		return this.qtd;
	}

	public void setQtd(float qtd) {
		this.qtd = qtd;
	}

	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}*/