package es.upm.miw.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.dtos.CadenahoteleraDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadenahoteleraControllerIT {
    
    @Autowired
    private CadenahoteleraController cadenaHoteleraController;
    
    @Test
    public void createTest() {
        CadenahoteleraDto cadenahoteleraDto = new CadenahoteleraDto("cadenaHotelera12");
        this.cadenaHoteleraController.createCadenaHotelera(cadenahoteleraDto);
        assertEquals("cadenaHotelera12",this.cadenaHoteleraController.getCadenahotelera("cadenaHotelera12").getNombre());
    }
    
    @Test
    public void getAllTest() {
        assertEquals(true,this.cadenaHoteleraController.getAll().size()>0);
    }
       

}
