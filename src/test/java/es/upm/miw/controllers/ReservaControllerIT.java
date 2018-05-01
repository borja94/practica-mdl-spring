package es.upm.miw.controllers;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.dtos.ReservaDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaControllerIT {
    
    @Autowired
    private ReservaController reservaController;
    

    @Test
    public void FunctionsTest() {
        ReservaDto reservaDto = new ReservaDto("MIRAMAR","JULIAN",new Date() , new Date() ,"23:00", "00:00");
        this.reservaController.CreateReserva(reservaDto);
        assertEquals(true,this.reservaController.getAllReservasFromNombreUsuario(reservaDto).size()>0);        
        
    }
    
    

}
