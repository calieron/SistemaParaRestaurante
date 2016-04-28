package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Comanda;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.NotaID;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Vinicius
 */
public class TestePersistirNotaID {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirNotaID() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("SistemaParaRestaurantePU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            NotaID n = new NotaID();
            n.setNumeroNota(2005);
            n.setPessoa(em.find(Pessoa.class, 1));
            em.getTransaction().begin();
            em.persist(n);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
    
}
