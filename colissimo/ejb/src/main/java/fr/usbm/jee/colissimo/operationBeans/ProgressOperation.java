package fr.usbm.jee.colissimo.operationBeans;

import fr.usbm.jee.colissimo.entities.Progress;
import fr.usbm.jee.colissimo.entities.Status;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProgressOperation {
    

    @PersistenceContext(unitName="colissimo")
    private EntityManager em;

    public ProgressOperation() {
        super();
    }

    public Progress create(String lat, String lon, String location, Status status) {
        Progress progress = new Progress(lat, lon, location, status);
        em.persist(progress);
        return progress;
    }
}
