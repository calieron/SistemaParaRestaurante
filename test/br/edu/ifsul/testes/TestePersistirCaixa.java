package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Caixa;
import br.edu.ifsul.modelo.Comanda;
import br.edu.ifsul.modelo.Fornecedor;
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
public class TestePersistirCaixa {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCaixa() {
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
            Caixa c = new Caixa();
            c.setEntrada(10.0);
            c.setSaida(3.0);
            c.setFechamento(7.0);
            c.setPessoa(em.find(Pessoa.class, 1));
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
    
}
