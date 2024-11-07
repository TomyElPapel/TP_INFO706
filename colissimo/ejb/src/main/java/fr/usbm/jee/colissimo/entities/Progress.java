package fr.usbm.jee.colissimo.entities;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
public class Progress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="coli_id")
    private Coli coli;

    private String latitude;
    private String longitude;
    private String location;
    private Status status;

    @Version
    private long version;

    public Progress() {
        super();
    }

    public Progress(String latitude, String longitude, String location, Status status) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.status = status;
        this.coli = null;
    }



    ///////////// GETTER SETTER ///////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Coli getColi() {
        return coli;
    }

    public void setColi(Coli coli) {
        this.coli = coli;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }    
}