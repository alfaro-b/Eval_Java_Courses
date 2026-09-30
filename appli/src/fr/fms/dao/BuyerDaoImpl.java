package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.fms.entities.Buyer;

/** Implémentation du DAO permettant d'accéder aux données des acheteurs.
 * Cette classe contient les opérations CRUD définies dans Dao<Buyer>
 * ainsi que les recherches spécifiques définies dans BuyerDao.
 */
public class BuyerDaoImpl implements BuyerDao{

	/** Recherche un acheteur par son identifiant.
	 *
	 * @param id identifiant de l'acheteur
	 * @param connection connexion à la base de données
	 * @return acheteur correspondant ou null si il n'existe pas
	 */
	@Override
	public Buyer findById(int id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Récupère tous les acheteurs présents dans la base de données.
	 *
	 * @param connection connexion à la base de données
	 * @return liste de tous les acheteurs
	 */
	@Override
	public List<Buyer> findAll(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Enregistre un nouvel acheteur dans la base de données.
	 *
	 * @param buyer acheteur à enregistrer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void save(Buyer buyer, Connection connection) {
	    String sql = "INSERT INTO buyer (name, login, password) "
	               + "VALUES (?, ?, ?)";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, buyer.getName());
	        ps.setString(2, buyer.getLogin());
	        ps.setString(3, buyer.getPassword());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/** Met à jour un acheteur existant.
	 *
	 * @param obj acheteur contenant les nouvelles informations
	 * @param connection connexion à la base de données
	 */
	@Override
	public void update(Buyer obj, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Supprime un acheteur à partir de son identifiant.
	 *
	 * @param id identifiant de l'acheteur à supprimer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void delete(int id, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	
	/** Recherche un acheteur par son login(identifiant de connexion).
	 * @param login identifiant de connexion
	 * @param connection connexion à la base de données
	 */
	@Override
	public Buyer findByLogin(String login, Connection connection) {
		Buyer buyer = null;
		
		String sql = "SELECT id_buyer, name, login, password "
	               + "FROM buyer "
	               + "WHERE login = ? ";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, login);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                buyer = new Buyer(
	                    rs.getInt("id_buyer"),
	                    rs.getString("name"),
	                    rs.getString("login"),
	                    rs.getString("password")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return buyer;
	}

}
