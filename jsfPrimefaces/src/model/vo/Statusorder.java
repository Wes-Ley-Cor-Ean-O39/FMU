// package model.vo;
//
// import java.io.Serializable;
// import javax.persistence.*;
// import java.util.List;
//
//
/// **
// * The persistent class for the statusorder database table.
// *
// */
// @Entity
// @NamedQuery(name="Statusorder.findAll", query="SELECT s FROM Statusorder s")
// public class Statusorder implements Serializable {
// private static final long serialVersionUID = 1L;
//
// @Id
// private int id;
//
// private String descrioption;
//
// //bi-directional many-to-one association to Order
// @OneToMany(mappedBy="statusorder")
// private List<Order> orders;
//
// public Statusorder() {
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
// public String getDescrioption() {
// return this.descrioption;
// }
//
// public void setDescrioption(String descrioption) {
// this.descrioption = descrioption;
// }
//
// public List<Order> getOrders() {
// return this.orders;
// }
//
// public void setOrders(List<Order> orders) {
// this.orders = orders;
// }
//
// public Order addOrder(Order order) {
// getOrders().add(order);
// order.setStatusorder(this);
//
// return order;
// }
//
// public Order removeOrder(Order order) {
// getOrders().remove(order);
// order.setStatusorder(null);
//
// return order;
// }
//
// }