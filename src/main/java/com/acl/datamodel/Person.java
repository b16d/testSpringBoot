package com.acl.datamodel;

import java.util.Objects;

public class Person {
    private String nom;

    private String prenom;

    private int age;

    private String lieuDeNaissance;

    public Person(String nom, String prenom, int age, String lieuDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.lieuDeNaissance = lieuDeNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(nom, person.nom) &&
                Objects.equals(prenom, person.prenom) &&
                Objects.equals(lieuDeNaissance, person.lieuDeNaissance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nom, prenom, age, lieuDeNaissance);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", lieuDeNaissance='" + lieuDeNaissance + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }
}
