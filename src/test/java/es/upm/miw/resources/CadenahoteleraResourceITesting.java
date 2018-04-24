package es.upm.miw.resources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.dtos.CadenahoteleraDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class CadenahoteleraResourceITesting {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Autowired
    private RestService restService;
    
    @Test
    public void CreateTest() {
        CadenahoteleraDto cadenaDto = new CadenahoteleraDto("Nueva cadena hotelera");
        restService.loginAdmin().restBuilder().path(CadenahoteleraResource.CADENAH).body(cadenaDto).post().build();
    }
}
