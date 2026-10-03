package org.example.core;

public class Adopter {
    private Long id;
    private String fullName;
    private String phone;
    private String mail;

    public Adopter() {}

    public Adopter(String fullName, String phone, String mail){
        this.fullName = fullName;
        this.phone = phone;
        this.mail = mail;
    }

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}
    public String getFullName(){return fullName;}
    public void setFullName(String fullName){this.fullName = fullName;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}
    public String getMail(){return mail;}
    public void setMail(String mail){this.mail = mail;}


    @Override
    public String toString() {
        return String.format("[%d], %s, тел: %s, email: %s",
                id, fullName, phone, mail);

    }
}
