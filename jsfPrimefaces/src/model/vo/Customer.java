/*
 * package model.vo;
 * 
 * import java.io.Serializable; import javax.persistence.*; import
 * java.sql.Timestamp; import java.util.List;
 * 
 * 
 *//**
	 * The persistent class for the customer database table.
	 * 
	 *//*
		 * @Entity
		 * 
		 * @NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c") public
		 * class Customer implements Serializable { private static final long
		 * serialVersionUID = 1L;
		 * 
		 * @Id private int id;
		 * 
		 * private String address;
		 * 
		 * private Timestamp dataCustomer;
		 * 
		 * private String login;
		 * 
		 * private String name;
		 * 
		 * private String passwd;
		 * 
		 * private String phone;
		 * 
		 * //bi-directional many-to-one association to Order
		 * 
		 * @OneToMany(mappedBy="customer") private List<Order> orders;
		 * 
		 * public Customer() { }
		 * 
		 * public int getId() { return this.id; }
		 * 
		 * public void setId(int id) { this.id = id; }
		 * 
		 * public String getAddress() { return this.address; }
		 * 
		 * public void setAddress(String address) { this.address = address; }
		 * 
		 * public Timestamp getDataCustomer() { return this.dataCustomer; }
		 * 
		 * public void setDataCustomer(Timestamp dataCustomer) { this.dataCustomer =
		 * dataCustomer; }
		 * 
		 * public String getLogin() { return this.login; }
		 * 
		 * public void setLogin(String login) { this.login = login; }
		 * 
		 * public String getName() { return this.name; }
		 * 
		 * public void setName(String name) { this.name = name; }
		 * 
		 * public String getPasswd() { return this.passwd; }
		 * 
		 * public void setPasswd(String passwd) { this.passwd = passwd; }
		 * 
		 * public String getPhone() { return this.phone; }
		 * 
		 * public void setPhone(String phone) { this.phone = phone; }
		 * 
		 * public List<Order> getOrders() { return this.orders; }
		 * 
		 * public void setOrders(List<Order> orders) { this.orders = orders; }
		 * 
		 * public Order addOrder(Order order) { getOrders().add(order);
		 * order.setCustomer(this);
		 * 
		 * return order; }
		 * 
		 * public Order removeOrder(Order order) { getOrders().remove(order);
		 * order.setCustomer(null);
		 * 
		 * return order; }
		 * 
		 * }
		 */