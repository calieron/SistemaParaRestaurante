package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Bufe;
import br.edu.ifsul.modelo.Comanda;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Gerente;
import br.edu.ifsul.modelo.Prato;
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
public class TestePersistirPrato {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPrato() {
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
            Prato p = new Prato();
            p.setCod_prato("123456789");
            p.setCozinheiro("56");
            p.setAlimento("strogonoff");
            p.setData(Calendar.getInstance());
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
    
}
