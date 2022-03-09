package com.example.demo.user;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class User{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String fname;
    private String lname;
    private String club;

    public User(){

    }

    public User(Long id, String fname, String lname, String club) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.club = club;
    }

    public User(String fname, String lname, String club) {
        this.fname = fname;
        this.lname = lname;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "user{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", club='" + club + '\'' +
                '}';
    }
}

