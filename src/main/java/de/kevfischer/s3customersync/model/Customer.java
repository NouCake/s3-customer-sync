package de.kevfischer.s3customersync.model;

import jakarta.persistence.*;

@Entity @Table(name = "kunde")
public class Customer {

    @Id @GeneratedValue
    @Column(name = "kundenid")
    private int id;

    @Column(name = "vorname")
    private String name;

    @Column(name = "nachname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "strasse")
    private String address;

    @Column(name = "strassenzusatz")
    private String address2;

    @Column(name = "ort")
    private String city;

    @Column(name = "land")
    private String country;

    @Column(name = "plz")
    private String postcode;

    @Column(name = "firmenname")
    private String company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
