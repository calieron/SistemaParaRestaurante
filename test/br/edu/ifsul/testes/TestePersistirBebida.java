package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Bebida;
import br.edu.ifsul.modelo.Bufe;
import br.edu.ifsul.modelo.Comanda;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Gerente;
import java.util.Calendar;
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
public class TestePersistirBebida {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirBebida() {
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
            Bebida b = new Bebida();
            b.setCod_bebida("12345678");
            b.setLote("1423498798");
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
    
}
