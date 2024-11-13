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
    
    private final String dbURL="jdbc:mysql://localhost:3306/gsb_frais_structure";
    private final String userName = "root";
    private final String password = "";
    private Connection connexion;
    
    public AccesBdD()
    {
        try {
            this.connexion = DriverManager.getConnection(dbURL,userName,password);
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnexion()
    {
        return this.connexion;
    }
}
