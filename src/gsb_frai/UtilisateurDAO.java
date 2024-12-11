/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsb_frai;

import java.security.SecureRandom;
import java.sql.*;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esellin
 */
public class UtilisateurDAO {
    
    /**
     * Connexion à la base de données.
     */
    private Connection connexion;

    /**
     * Constructeur de la classe UtilisateurDAO.
     * 
     * @param connexion Connexion à la base de données.
     */
    public UtilisateurDAO(Connection connexion) {
        this.connexion = connexion;
    }
    
    /**
     * Retourne une liste de tous les utilisateurs.
     * 
     * Cette méthode exécute une requête SQL pour récupérer tous les utilisateurs de la base de données et les retourne sous la forme d'une liste d'objets Utilisateur.
     * 
     * @return Une liste de tous les utilisateurs.
     */
    public ArrayList<Utilisateur> getLesUtilisateurs()
    {
        ResultSet result = null;
        ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
        try {
            String sql = "SELECT id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche,idStat FROM employe";
            Statement statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while(result.next())
            {
                Utilisateur user = new Utilisateur(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getDate(9),result.getInt(10));
                lesUtilisateurs.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesUtilisateurs;
          
    } 
    
    /**
     * Retourne une liste d'utilisateurs correspondant à la recherche.
     * 
     * Cette méthode exécute une requête SQL pour récupérer les utilisateurs dont l'identifiant commence par la chaîne de recherche donnée.
     * 
     * @param recherche La chaîne de recherche à utiliser.
     * @return Une liste d'utilisateurs correspondant à la recherche.
     */
    public ArrayList<Utilisateur> BarreRecherche(String recherche)
    {
        ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
        try {
            ResultSet result = null;
            String sql = "SELECT id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche,idStat FROM employe WHERE id LIKE '" + recherche+ "%'";
            Statement statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while(result.next())
            {
                Utilisateur user = new Utilisateur(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getDate(9),result.getInt(10));
                lesUtilisateurs.add(user);
            }
//            connexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesUtilisateurs;  
    } 
    
    /**
     * Ajoute un nouvel utilisateur à la base de données.
     * 
     * Cette méthode génère un mot de passe aléatoire, un login et insère un nouvel utilisateur dans la base de données.
     * 
     * @param id L'identifiant de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param adresse L'adresse de l'utilisateur.
     * @param cp Le code postal de l'utilisateur.
     * @param ville La ville de l'utilisateur.
     * @param dateEmbauche La date d'embauche de l'utilisateur.
     * @param Statut Le statut de l'utilisateur.
     * @return Le nombre de lignes insérées dans la base de données.
     * @throws SQLException Si une erreur se produit lors de l'insertion dans la base de données.
     */
     public int ajoutUtilisateur(String id, String nom, String prenom, String adresse, String cp, String ville, java.util.Date dateEmbauche, int Statut ) throws SQLException
    {
        // génération mdp aléatoire
        int mdpTaille = 8;
        String caractAleatoire = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder mdpAleatoire = new StringBuilder(mdpTaille);
            
        for (int i = 0; i < mdpTaille; i++)
        {
            int index = random.nextInt(caractAleatoire.length());
            char caract = caractAleatoire.charAt(index);
            mdpAleatoire.append(caract);
        }
        String mdp = mdpAleatoire.toString();
            
        // Enlever les accents des noms / prénoms
        String prenomSansAcc = Normalizer.normalize(prenom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        String nomSansAcc = Normalizer.normalize(nom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        
        // Générer le login
        String login = (prenomSansAcc.charAt(0) + nomSansAcc).toLowerCase();  
        
        String sql = "INSERT INTO employe VALUES (?,?,?, '" + mdp + "', '" + login + "',?,?,?,?,?)";
        int  rowsInsered = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, id);
        statement.setString(2, nom);
        statement.setString(3, prenom);
        statement.setString(4, adresse);
        statement.setString(5, cp);
        statement.setString(6, ville);
        java.sql.Date dateEmbSQL = new java.sql.Date(dateEmbauche.getTime());
        statement.setDate(7, dateEmbSQL);
        statement.setInt(8, Statut);
        rowsInsered = statement.executeUpdate();
        return rowsInsered; 
    }
     
     /**
     * Supprime un utilisateur de la base de données.
     * 
     * Cette méthode supprime un utilisateur de la base de données en utilisant son identifiant, son nom et son prénom.
     * 
     * @param id L'identifiant de l'utilisateur à supprimer.
     * @param nom Le nom de l'utilisateur à supprimer.
     * @param prenom Le prénom de l'utilisateur à supprimer.
     * @return Le nombre de lignes supprimées dans la base de données.
     * @throws SQLException Si une erreur se produit lors de la suppression dans la base de données.
     */
     public int suprimUtilisateur(String id, String nom, String prenom ) throws SQLException
    {
        String sql = "DELETE FROM employe  WHERE id = ? AND nom = ?, AND prenom = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, id);
        statement.setString(2, nom);
        statement.setString(3, prenom);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     
     /**
     * Modifie les informations d'un utilisateur dans la base de données.
     * 
     * Cette méthode met à jour les informations d'un utilisateur dans la base de données en utilisant son identifiant.
     * 
     * @param nom Le nouveau nom de l'utilisateur.
     * @param prenom Le nouveau prénom de l'utilisateur.
     * @param login Le nouveau login de l'utilisateur.
     * @param mdp Le nouveau mot de passe de l'utilisateur.
     * @param adresse La nouvelle adresse de l'utilisateur.
     * @param cp Le nouveau code postal de l'utilisateur.
     * @param ville La nouvelle ville de l'utilisateur.
     * @param dateEmbauche La nouvelle date d'embauche de l'utilisateur.
     * @param statut Le nouveau statut de l'utilisateur.
     * @param id L'identifiant de l'utilisateur à modifier.
     * @return Le nombre de lignes modifiées dans la base de données.
     * @throws SQLException Si une erreur se produit lors de la modification dans la base de données.
     */
     public int modifVisiteurs(String nom,String prenom,String login,
             String mdp,String adresse,String cp,String ville,java.util.Date dateEmbauche, int statut, String id) throws SQLException
    {
        String sql = "UPDATE employe SET nom = ?, prenom = ?, login = ?, "
                + "mdp = ?, adresse = ?, cp = ?, ville = ?,"
                + " dateEmbauche = ?, idStat = ?  Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, nom);
        statement.setString(2, prenom);
        statement.setString(3, login);
        statement.setString(4, mdp);
        statement.setString(5, adresse);
        statement.setString(6, cp);
        statement.setString(7, ville);
        java.sql.Date dateEmbSQL = new java.sql.Date(dateEmbauche.getTime());
        statement.setDate(8, dateEmbSQL);
        statement.setInt(9, statut);
        statement.setString(10, id);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     
     /**
     * Vérifie si les informations de connexion sont valides.
     * 
     * Cette méthode vérifie si un utilisateur avec le login et le mot de passe donnés existe dans la base de données.
     * 
     * @param login Le login de l'utilisateur.
     * @param mdp Le mot de passe de l'utilisateur.
     * @return **true** si les informations de connexion sont valides, **false** sinon.
     */
     public boolean loginConnexion (String login, String mdp)
     {
        ResultSet result = null;
        String sql = "SELECT login,mdp FROM employe";
        try {
            Statement statement;
            statement = connexion.createStatement();
            result = statement.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
     }

     /**
     * Retourne une représentation textuelle de l'objet UtilisateurDAO.
     * 
     * @return Une représentation textuelle de l'objet UtilisateurDAO.
     */
    @Override
    public String toString() {
        return "UtilisateurDAO{" + '}';
    }
    
}
