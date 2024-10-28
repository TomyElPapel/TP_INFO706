package fr.usbm.jee.colissimo.operationBeans;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.entities.Progress;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;




@Stateless
public class ColiOperation {

    @PersistenceContext(unitName="colissimo")
    private EntityManager em;

    public ColiOperation() {
        super();
    }


    public Coli create(float weight, float value, String origin, String destination) {
        Coli coli = new Coli(destination, origin, weight, value);
        em.persist(coli);
        return coli;
    }

    public List<Coli> findAll() {
        TypedQuery<Coli> rq = em.createQuery("SELECT e FROM Coli e", Coli.class);
        return rq.getResultList();
    }

    public Coli updateProgress(Coli coli, Progress progress) {
        if (progress == null) {
            return coli;
        }

        Progress previousProgress = coli.getCurrentProgress();

        if (previousProgress != null) {
            coli.getPreviousProgress().add(previousProgress);
        }

        coli.setCurrentProgress(progress);
        em.merge(coli);
        return coli;
    }

    public Coli findById(int id) {
       Coli coli = em.find(Coli.class, id);
       return coli;
    }
}
