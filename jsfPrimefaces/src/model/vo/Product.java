// package model.vo;
//
// import java.io.Serializable;
// import javax.persistence.*;
// import java.util.List;
//
//
/// **
// * The persistent class for the product database table.
// *
// */
// @Entity
// @NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
// public class Product implements Serializable {
// private static final long serialVersionUID = 1L;
//
// @Id
// private int id;
//
// private String name;
//
// private float val;
//
// //bi-directional many-to-one association to Iten
// @OneToMany(mappedBy="product")
// private List<Iten> itens;
//
// public Product() {
// }
//
// public int getId() {
// return this.id;
// }
//
// public void setId(int id) {
// this.id = id;
// }
//
// public String getName() {
// return this.name;
// }
//
// public void setName(String name) {
// this.name = name;
// }
//
// public float getVal() {
// return this.val;
// }
//
// public void setVal(float val) {
// this.val = val;
// }
//
// public List<Iten> getItens() {
// return this.itens;
// }
//
// public void setItens(List<Iten> itens) {
// this.itens = itens;
// }
//
// public Iten addIten(Iten iten) {
// getItens().add(iten);
// iten.setProduct(this);
//
// return iten;
// }
//
// public Iten removeIten(Iten iten) {
// getItens().remove(iten);
// iten.setProduct(null);
//
// return iten;
// }
//
// }