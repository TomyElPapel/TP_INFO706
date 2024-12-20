package fr.usbm.jee.colissimo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class Coli implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String destination;
    private String origin;
    private float weight;

    @Column(name = "`value`")
    private float value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_progress_id")
    private Progress currentProgress;

    @OneToMany(mappedBy = "coli", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Progress> previousProgress = new ArrayList<>();

    @Version
    private long version;

    // Constructor
    public Coli() {
        super();
    }

    public Coli(String destination, String origin, float weight, float value) {
        this.destination = destination;
        this.origin = origin;
        this.weight = weight;
        this.value = value;
        this.currentProgress = null;
    }


    /////////////////////// SETTER GETTER ///////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Progress getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(Progress currentProgress) {
        this.currentProgress = currentProgress;
    }

    public List<Progress> getPreviousProgress() {
        return previousProgress;
    }

    public void setPreviousProgress(List<Progress> previousProgress) {
        this.previousProgress = previousProgress;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

