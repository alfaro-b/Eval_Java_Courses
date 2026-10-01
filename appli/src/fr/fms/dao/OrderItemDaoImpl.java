package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.fms.entities.OrderItem;

/** Implémentation du DAO permettant d'accéder aux données des ligne de commandes.
 * Cette classe contient les opérations CRUD définies dans Dao<OrderItem>.
 */
public class OrderItemDaoImpl implements OrderItemDao{

	/** Recherche une ligne de commande par son identifiant.
	 *
	 * @param id identifiant de la ligne commande
	 * @param connection connexion à la base de données
	 * @return commande correspondante ou null si elle n'existe pas
	 */
	@Override
	public OrderItem findById(int id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Récupère toutes les lignes de commandes présentes dans la base de données.
	 *
	 * @param connection connexion à la base de données
	 * @return liste de toutes les lignes de commandes
	 */
	@Override
	public List<OrderItem> findAll(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Enregistre une nouvelle ligne de commande dans la base de données.
	 *
	 * @param orderItem ligne de commande à enregistrer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void save(OrderItem orderItem, Connection connection) {
	    String sql = "INSERT INTO orderItem (quantity, price, id_course, id_order) "
	               + "VALUES (?, ?, ?, ?)";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	    	ps.setInt(1, orderItem.getQuantity());
	        ps.setDouble(2, orderItem.getPrice());
	        ps.setInt(2, orderItem.getCourse().getIdCourse());
	        ps.setInt(3, orderItem.getOrder().getIdOrder());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/** Met à jour une ligne de commande existante.
	 *
	 * @param obj ligne de commande contenant les nouvelles informations
	 * @param connection connexion à la base de données
	 */
	@Override
	public void update(OrderItem obj, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Supprime une ligne de commande à partir de son identifiant.
	 *
	 * @param id identifiant de la ligne de commande à supprimer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void delete(int id, Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
