package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.fms.entities.Order;

/** Implémentation du DAO permettant d'accéder aux données des commandes.
 * Cette classe contient les opérations CRUD définies dans Dao<Order>.
 */
public class OrderDaoImpl implements OrderDao{

	/** Recherche une commande par son identifiant.
	 *
	 * @param id identifiant de la commande
	 * @param connection connexion à la base de données
	 * @return commande correspondante ou null si elle n'existe pas
	 */
	@Override
	public Order findById(int id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Récupère toutes les commandes présentes dans la base de données.
	 *
	 * @param connection connexion à la base de données
	 * @return liste de toutes les commandes
	 */
	@Override
	public List<Order> findAll(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Enregistre une nouvelle commande dans la base de données.
	 *
	 * @param order commande à enregistrer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void save(Order order, Connection connection) {
	    String sql = "INSERT INTO orders (date, id_buyer, id_customer) "
	               + "VALUES (?, ?, ?)";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setDate(1, java.sql.Date.valueOf(order.getDate()));
	        ps.setInt(2, order.getBuyer().getIdBuyer());
	        ps.setInt(3, order.getCustomer().getIdCustomer());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	/** Met à jour une commande existante.
	 *
	 * @param obj commande contenant les nouvelles informations
	 * @param connection connexion à la base de données
	 */
	@Override
	public void update(Order obj, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Supprime une commande à partir de son identifiant.
	 *
	 * @param id identifiant de la commande à supprimer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void delete(int id, Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
