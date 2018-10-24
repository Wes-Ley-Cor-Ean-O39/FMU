// package model.vo;
//
// import java.io.Serializable;
// import javax.persistence.*;
// import java.sql.Timestamp;
// import java.util.List;
//
//
/// **
// * The persistent class for the order database table.
// *
// */
// @Entity
// @NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
// public class Order implements Serializable {
// private static final long serialVersionUID = 1L;
//
// @Id
// private int id;
//
// private Timestamp orderDate;
//
// private float total;
//
// //bi-directional many-to-one association to Iten
// @OneToMany(mappedBy="order")
// private List<Iten> itens;
//
// //bi-directional many-to-one association to Customer
// @ManyToOne
// @JoinColumn(name="idCustomer")
// private Customer customer;
//
// //bi-directional many-to-one association to Statusorder
// @ManyToOne
// @JoinColumn(name="idStatus")
// private Statusorder statusorder;
//
// public Order() {
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
// public Timestamp getOrderDate() {
// return this.orderDate;
// }
//
// public void setOrderDate(Timestamp orderDate) {
// this.orderDate = orderDate;
// }
//
// public float getTotal() {
// return this.total;
// }
//
// public void setTotal(float total) {
// this.total = total;
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
// iten.setOrder(this);
//
// return iten;
// }
//
// public Iten removeIten(Iten iten) {
// getItens().remove(iten);
// iten.setOrder(null);
//
// return iten;
// }
//
// public Customer getCustomer() {
// return this.customer;
// }
//
// public void setCustomer(Customer customer) {
// this.customer = customer;
// }
//
// public Statusorder getStatusorder() {
// return this.statusorder;
// }
//
// public void setStatusorder(Statusorder statusorder) {
// this.statusorder = statusorder;
// }
//
// }