/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsb_frai;

import java.util.Date;

/**
 *
 * @author esellin
 */
public class Utilisateur {
    /**
     * Identifiant de l'utilisateur.
     */
    private String Id;
    
    /**
     * Nom de l'utilisateur.
     */
    private String nom;
    
    /**
     * Prénom de l'utilisateur.
     */
    private String prenom;
    
    /**
     * Login de l'utilisateur.
     */
    private String login;
    
    /**
     * Mot de passe de l'utilisateur.
     */
    private String password;
    
    /**
     * Adresse de l'utilisateur.
     */
    private String adresse;
    
    /**
     * Code postal de l'utilisateur.
     */
    private String cp;
    
    /**
     * Ville de l'utilisateur.
     */
    private String ville;
    
    /**
     * Date d'embauche de l'utilisateur.
     */
    private Date dateEmbauche;
    
    /**
     * Statut de l'utilisateur.
     */
    private int status;

    /**
     * Constructeur de la classe Utilisateur.
     * 
     * @param id Identifiant de l'utilisateur.
     * @param nom Nom de l'utilisateur.
     * @param prenom Prénom de l'utilisateur.
     * @param login Login de l'utilisateur.
     * @param password Mot de passe de l'utilisateur.
     * @param adresse Adresse de l'utilisateur.
     * @param cp Code postal de l'utilisateur.
     * @param ville Ville de l'utilisateur.
     * @param dateEmbauche Date d'embauche de l'utilisateur.
     * @param status Statut de l'utilisateur.
     */
    public Utilisateur(String id,String nom, String prenom, String login, String password, String adresse, String cp, String ville, Date dateEmbauche,int status) {
        this.Id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.dateEmbauche = dateEmbauche;
        this.status = status;
    }

    /**
     * Retourne l'identifiant de l'utilisateur.
     * 
     * @return L'identifiant de l'utilisateur.
     */
    public String getId() {
        return Id;
    }

    /**
     * Retourne le nom de l'utilisateur.
     * 
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de l'utilisateur.
     * 
     * @return Le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le login de l'utilisateur.
     * 
     * @return Le login de l'utilisateur.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Retourne le mot de passe de l'utilisateur.
     * 
     * @return Le mot de passe de l'utilisateur.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Retourne le statut de l'utilisateur.
     * 
     * @return Le statut de l'utilisateur.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Retourne l'adresse de l'utilisateur.
     * 
     * @return L'adresse de l'utilisateur.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Retourne le code postal de l'utilisateur.
     * 
     * @return Le code postal de l'utilisateur.
     */
    public String getCp() {
        return cp;
    }

    /**
     * Retourne la ville de l'utilisateur.
     * 
     * @return La ville de l'utilisateur.
     */
    public String getVille() {
        return ville;
    }

    /**
     * Retourne la date d'embauche de l'utilisateur.
     * 
     * @return La date d'embauche de l'utilisateur.
     */
    public Date getDateEmbauche() {
        return dateEmbauche;
    }
    
    /**
     * Définit l'identifiant de l'utilisateur.
     * 
     * @param Id Le nouvel identifiant de l'utilisateur.
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * Définit le nom de l'utilisateur.
     * 
     * @param nom Le nouveau nom de l'utilisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le prénom de l'utilisateur.
     * 
     * @param prenom Le nouveau prénom de l'utilisateur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Définit le login de l'utilisateur.
     * 
     * @param login Le nouveau login de l'utilisateur.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Définit le mot de passe de l'utilisateur.
     * 
     * @param password Le nouveau mot de passe de l'utilisateur.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Définit l'adresse de l'utilisateur.
     * 
     * @param adresse La nouvelle adresse de l'utilisateur.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Définit le code postal de l'utilisateur.
     * 
     * @param cp Le nouveau code postal de l'utilisateur.
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Définit la ville de l'utilisateur.
     * 
     * @param ville La nouvelle ville de l'utilisateur.
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Définit la date d'embauche de l'utilisateur.
     * 
     * @param dateEmbauche La nouvelle date d'embauche de l'utilisateur.
     */
    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
    /**
     * Définit le statut de l'utilisateur.
     * 
     * @param status Le nouveau statut de l'utilisateur.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Retourne un tableau d'objets contenant les informations de l'utilisateur.
     * 
     * @return Un tableau d'objets contenant les informations de l'utilisateur.
     */
    public Object[] toArray(){
        Object[] tab = new Object[]{this.Id,this.nom,this.prenom,this.login,this.password,this.adresse,this.cp,this.ville,this.dateEmbauche,this.status};
        return tab;
    }
    
    /**
     * Retourne une représentation textuelle de l'utilisateur.
     * 
     * @return Une représentation textuelle de l'utilisateur.
     */
    @Override
    public String toString() {
        return "Utilisateur{" + "login=" + login + ", password=" + password + '}';
    }
    
}
