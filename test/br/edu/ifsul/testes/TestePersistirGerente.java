package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Comanda;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.Gerente;
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
public class TestePersistirGerente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirGerente() {
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
            Gerente g = new Gerente();
            g.setApelido("bundao");
            g.setSenha("12345678");
            em.getTransaction().begin();
            em.persist(g);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
    
}
