/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsb_frai;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esellin
 */
public class UtilisateurDAO {
    
    private Connection connexion;

    public UtilisateurDAO(Connection connexion) {
        this.connexion = connexion;
    }
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
    
     public int ajoutUtilisateur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, Date dateEmbauche ) throws SQLException
    {
        String sql = "INSERT INTO employe (id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche)"
                + "VALUES (?,?,?,?,?)";
        int  rowsInsered = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, id);
        statement.setString(2, nom);
        statement.setString(3, prenom);
        statement.setString(4, login);
        statement.setString(5, mdp);
        statement.setString(6, adresse);
        statement.setString(7, cp);
        statement.setString(8, ville);
        statement.setDate(9, dateEmbauche);
        rowsInsered = statement.executeUpdate();
        return rowsInsered; 
    }
     
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
     public int modifNom(String id, String nom) throws SQLException
    {
        String sql = "UPDATE employe SET nom = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, nom);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifPrenom(String id, String prenom) throws SQLException
    {
        String sql = "UPDATE employe SET prenom = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, prenom);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifLogin(String id, String login) throws SQLException
    {
        String sql = "UPDATE employe SET login = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, login);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifPassword(String id, String mdp) throws SQLException
    {
        String sql = "UPDATE employe SET mdp = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, mdp);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifAdresse(String id, String adresse) throws SQLException
    {
        String sql = "UPDATE employe SET adresse = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, adresse);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifCp(String id, String cp) throws SQLException
    {
        String sql = "UPDATE employe SET cp = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, cp);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifVille(String id, String ville) throws SQLException
    {
        String sql = "UPDATE employe SET ville = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, ville);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
     public int modifDateEmbauche(String id, String dateEmbauche) throws SQLException
    {
        String sql = "UPDATE employe SET dateEmbauche = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, dateEmbauche);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
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

    @Override
    public String toString() {
        return "UtilisateurDAO{" + '}';
    }
    
}
