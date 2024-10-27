package fr.usbm.jee.colissimo.operationBeans;

import fr.usbm.jee.colissimo.entities.Coli;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Remote;
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


    public Coli create(String name) {
        Coli coli = new Coli(name);
        em.persist(coli);
        return coli;
    }

    public List<Coli> findAll() {
        TypedQuery<Coli> rq = em.createQuery("SELECT e FROM Coli e", Coli.class);
        return rq.getResultList();
    }

    public Coli findById(int id) {
       Coli coli = em.find(Coli.class, id);
       return coli;
    }

}
