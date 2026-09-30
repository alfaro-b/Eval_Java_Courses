package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.fms.entities.Customer;

/** Implémentation du DAO permettant d'accéder aux données des clients.
 * Cette classe contient les opérations CRUD définies dans Dao<Customer>.
 */
public class CustomerDaoImpl implements CustomerDao{

	/** Recherche un client par son identifiant.
	 *
	 * @param id identifiant du client
	 * @param connection connexion à la base de données
	 * @return client correspondant ou null si il n'existe pas
	 */
	@Override
	public Customer findById(int id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Récupère tous les clients présents dans la base de données.
	 *
	 * @param connection connexion à la base de données
	 * @return liste de tous les clients
	 */
	@Override
	public List<Customer> findAll(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Enregistre un nouveau client dans la base de données.
	 *
	 * @param customer client à enregistrer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void save(Customer customer, Connection connection) {
	    String sql = "INSERT INTO customer (last_name, first_name, email, address, phone) "
	               + "VALUES (?, ?, ?, ?, ?)";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, customer.getLastName());
	        ps.setString(2, customer.getFirstName());
	        ps.setString(3, customer.getEmail());
	        ps.setString(4, customer.getAddress());
	        ps.setString(5, customer.getPhone());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/** Met à jour un client existant.
	 *
	 * @param obj client contenant les nouvelles informations
	 * @param connection connexion à la base de données
	 */
	@Override
	public void update(Customer obj, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Supprime un client à partir de son identifiant.
	 *
	 * @param id identifiant du client à supprimer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void delete(int id, Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
