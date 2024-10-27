package fr.usbm.jee.colissimo.operationBeans;

import fr.usbm.jee.colissimo.entities.Coli;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;


@DataSourceDefinition (
        name = "java:app/env/jdbc/MyDataSource",
        className = "org.postgresql.ds.PGPoolingDataSource",
        user = "admin",
        password = "admin",
        serverName = "localhost",
        portNumber = 5432,
        databaseName = "banque"
)






@Stateless
@Remote
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
        TypedQuery<Coli> rq = em.createQuery("SELECT * FROM coli", Coli.class);
        return rq.getResultList();
    }

}
