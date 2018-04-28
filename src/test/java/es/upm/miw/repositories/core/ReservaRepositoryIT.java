package es.upm.miw.repositories.core;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.documents.core.Reserva;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaRepositoryIT {
    
    @Autowired
    private ReservaRepository reservarepo;
    
    @Before
    public void before() {
        Reserva reserva = new Reserva("SANTOS","JUAN",new Date(), "10:20");
        this.reservarepo.save(reserva);
    }
    
    @Test
    public void FindByTest() {
        assertEquals("SANTOS",this.reservarepo.findByNombreHotel("SANTOS").getNombreHotel());
        assertEquals(true,this.reservarepo.findByNombreUsuario("JUAN").size()>0);
    }

}
