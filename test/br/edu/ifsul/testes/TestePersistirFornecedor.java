package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Fornecedor;
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
public class TestePersistirFornecedor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFornecedor() {
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
            Fornecedor f = new Fornecedor();
            f.setCnpj("92802784019450");
            f.setNome("Outro");
            f.setEndereco("rua fffbs");
            f.setTelefone("54 90557766");
            f.setCidade("Passo Largo");
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
    
}
