package fr.fms.dao;

import java.sql.Connection;

import fr.fms.entities.Buyer;

/** Interface DAO spécifique aux acheteurs.
 * Hérite des opérations CRUD génériques définies dans Dao<Buyer>.
 */
public interface BuyerDao extends Dao<Buyer> {

	/**
	 * Recherche un acheteur par son login.
	 *
	 * @param login identifiant de connexion de l'acheteur
	 * @param connection connexion à la base de données
	 * @return l'acheteur recherché
	 */
    Buyer findByLogin(String login, Connection connection);
}
