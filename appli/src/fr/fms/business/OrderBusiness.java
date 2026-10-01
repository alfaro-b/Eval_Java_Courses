package fr.fms.business;

import fr.fms.entities.Buyer;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;


/** Interface métier pour la gestion des commandes.
 * Définit les fonctionnalités accessibles depuis la couche applications.
 */
public interface OrderBusiness {

    /** Enregistre un acheteur (création d'un compte)
     * @param buyer acheteur
     */
    void registerBuyer(Buyer buyer);
    
    /** Connecte un acheteur à partir de son login et mot de passe.
     * @param login identifiant de connexion de l'acheteur
     * @param password mot de passe de l'acheteur
     * @return l'acheteur
     */
    public Buyer connectBuyer(String login, String password);

    
    /** Enregistre un client
     * @param customer le client
     */
    void saveCustomer(Customer customer);

    
    /** Enregistre une commande
     * @param order commande
     */
    void saveOrder(Order order);

    
    /** Ferme la connexion à la base de données
     * 
     */
    void closeConnection();
    
}
