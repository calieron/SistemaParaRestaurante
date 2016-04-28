package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Comanda;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.Nota;
import br.edu.ifsul.modelo.NotaID;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirNota {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirNota() {
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
            Nota n = new Nota();
            NotaID id = new NotaID();
            id.setNumeroNota(40000);
            id.setPessoa(em.find(Pessoa.class, 1));
            n.setNotaID(id);
            n.setData(Calendar.getInstance());
            n.setQuantidade(30.0);
            n.setValorTotal(500.0);
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
