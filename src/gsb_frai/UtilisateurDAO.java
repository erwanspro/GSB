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
            String sql = "SELECT * FROM visiteur";
            Statement statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while(result.next())
            {
                Utilisateur user = new Utilisateur(result.getString(4),result.getString(5));
                lesUtilisateurs.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesUtilisateurs;
          
    } 
     public int ajoutUtilisateur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, Date dateEmbauche ) throws SQLException
    {
        String sql = "INSERT INTO visiteur (id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche)"
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
        String sql = "DELETE FROM visiteur  WHERE id = ? AND nom = ?, AND prenom = ?";
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
        String sql = "UPDATE visiteur SET nom = ? Where id = ?";
        int  rowsDeleted = 0;
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(2, id);
        statement.setString(1, nom);
        rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
               
    }
    
}
