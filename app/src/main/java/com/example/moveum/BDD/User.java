package com.example.moveum.BDD;

public class User {
    private String prenom;
    private String nom;
    private String identity;
    private String mdp;
    private String age;
    private String mail;

    public User(String prenom, String nom, String identity, String mdp, String age, String mail){
        super();

        this.prenom = prenom;
        this.nom = nom;
        this.identity = identity;
        this.mdp = mdp;
        this.age = age;
        this.mail = mail;
    }




    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }


    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }


    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
