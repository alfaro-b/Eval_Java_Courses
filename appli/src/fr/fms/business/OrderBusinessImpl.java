package fr.fms.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.fms.dao.BuyerDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderItemDao;
import fr.fms.entities.Buyer;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;



/** Implementation de la couche métier pour la gestion des commandes.
 * Orchestre les DAO CustomerDao, BuyerDao, orderItemDao et OrderDao.
 */
public class OrderBusinessImpl implements  OrderBusiness {

	// =========================
    // ATTRIBUTS
    // =========================

	private final CustomerDao customerDao;
	private final BuyerDao buyerDao;
	private final OrderItemDao orderItemDao;
	private final OrderDao orderDao;
	private Connection connection;
	
	
    // =========================
    // CONSTRUCTEUR
    // =========================
	
	public OrderBusinessImpl(CustomerDao customerDao, BuyerDao buyerDao, OrderItemDao orderItemDao, OrderDao orderDao) {
		this.customerDao = customerDao;
		this.buyerDao = buyerDao;
		this.orderItemDao = orderItemDao;
		this.orderDao = orderDao;
		this.connection = this.initConnection();
	}
	

	// =========================
    // MÉTHODES
    // =========================
	
	/** Crée la connexion à la base de données.
	 * @return connexion à la base de données.
	 */
	private Connection initConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(ClassNotFoundException e) {
    			e.printStackTrace();
        }
		
		String url = "jdbc:mariadb://localhost:3306/courses_sales_v2";
		String login = "courses_user";
		String password = "MotDePasseUser";
		
		try {
			return DriverManager.getConnection(url,login,password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/** Enregistre un acheteur ( création d'un compte)
	 * @param buyer acheteur
	 */
	@Override
	public void registerBuyer(Buyer buyer) {
		buyerDao.save(buyer, connection);
	}
	
	/** Gère la connexion d'un acheteur : récupère l'acheteur par son login et vérifie son password
	 * @param login identifiant de connexion de l'acheteur
	 * @param password mot de passe de l'acheteur
	 * @return acheteur connecté ou null si les identifiants sont incorrects
	 */
	@Override
	public Buyer connectBuyer(String login, String password) {
		Buyer buyer = buyerDao.findByLogin(login, connection);
		
		if (buyer != null && buyer.getPassword().equals(password)) {
			return buyer;
		}
		return null;
	}


	/** Enregistre un client
	 * @param customer client à enregistrer
	 */
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer, connection);
	}

	/** Enregistre une commande
	 * @param order commande à enregistrer
	 */
	@Override
	public void saveOrder(Order order) {
		// Enregistre d'abord la commande afin de récupérer son identifiant généré
		orderDao.save(order, connection);
		
		// Associe ensuite chaque ligne à la commande créée puis l'enregistre en base
		for (OrderItem orderItem : order.getOrderItems()) {
			orderItem.setOrder(order);
			orderItemDao.save(orderItem, connection);
		}
		
	}

	/** Ferme la connexion à la base de données.
	 *
	 */
	@Override
    public void closeConnection() {
		try {
			this.connection.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}



}
