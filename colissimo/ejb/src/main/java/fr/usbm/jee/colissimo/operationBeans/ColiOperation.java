package fr.usbm.jee.colissimo.operationBeans;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.entities.Progress;
import fr.usbm.jee.colissimo.entities.Status;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;




@Stateless
public class ColiOperation {

    @EJB
    private ProgressOperation progressEJB;

    @PersistenceContext(unitName="colissimo")
    private EntityManager em;

    public ColiOperation() {
        super();
    }


    public Coli create(float weight, float value, String origin, String destination, String latitude, String lontitude) {
        Coli coli = new Coli(destination, origin, weight, value);

        Progress progress = new Progress(latitude, lontitude, destination, Status.Registered);

        coli.setCurrentProgress(progress);

        em.persist(progress);
        em.persist(coli);
        return coli;
    }

    public List<Coli> findAll() {
        TypedQuery<Coli> rq = em.createQuery("SELECT e FROM Coli e", Coli.class);
        return rq.getResultList();
    }

    public void updateProgress(Coli coli, Progress progress) {
        if (progress == null) {
            return;
        }

        Progress previousProgress = coli.getCurrentProgress();

        if (previousProgress != null) {
            coli.getPreviousProgress().add(previousProgress);
            previousProgress.setColi(coli);
            em.merge(previousProgress);
        }

        coli.setCurrentProgress(progress);

        em.merge(progress);
        em.merge(coli);
    }

    public Coli findById(int id) {
       Coli coli = em.find(Coli.class, id);
       return coli;
    }
}
