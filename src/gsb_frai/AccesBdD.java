/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsb_frai;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author esellin
 */
public class AccesBdD {
    
    /**
     * URL de la base de données.
     */
    private final String dbURL="jdbc:mysql://localhost:3306/gsb_frais";
    /**
     * Nom d'utilisateur de la base de données.
     */
    private final String userName = "root";
    /**
     * Mot de passe de la base de données.
     */
    private final String password = "";
    /**
     * Connexion à la base de données.
     */
    private Connection connexion;
    
    /**
     * Constructeur de la classe AccesBdD.
     * Établit la connexion à la base de données.
     */
    public AccesBdD()
    {
        try {
            this.connexion = DriverManager.getConnection(dbURL,userName,password);
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return La connexion à la base de données.
     */
    public Connection getConnexion()
    {
        return this.connexion;
    }
}
