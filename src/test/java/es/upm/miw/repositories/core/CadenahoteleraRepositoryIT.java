package es.upm.miw.repositories.core;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.documents.core.Cadenahotelera;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadenahoteleraRepositoryIT {


    @Autowired
    private CadenahoteleraRepository cadenahotelerarepository;
    @Before
    public void before() {
        Cadenahotelera cadenahotelera = new Cadenahotelera("cadenahotelera1");
        Cadenahotelera cadenahotelera2 = new Cadenahotelera("cadenahotelera2");
        this.cadenahotelerarepository.save(cadenahotelera);
        this.cadenahotelerarepository.save(cadenahotelera2);
    }

    @Test
    public void test1() {
        
        assertEquals("cadenahotelera1",this.cadenahotelerarepository.findByNombre("cadenahotelera1").getNombre());
        assertEquals("cadenahotelera2",this.cadenahotelerarepository.findByNombre("cadenahotelera2").getNombre());

    }

}
