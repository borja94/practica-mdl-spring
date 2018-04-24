package es.upm.miw.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.controllers.CadenahoteleraController;
import es.upm.miw.dtos.CadenahoteleraDto;
import es.upm.miw.resources.exceptions.CadenahoteleraAlreadyExistException;
import es.upm.miw.resources.exceptions.CadenahoteleraNotExistException;

@RestController
@RequestMapping(CadenahoteleraResource.CADENAH)
public class CadenahoteleraResource {

    public static final String CADENAH = "/cadena";

    public static final String NOMBRECADENA = "/{nombrecadena}";

    public static final String ID = "/{id}";

    @Autowired
    private CadenahoteleraController cadenaHoteleraController;

    public CadenahoteleraResource() {

    }

    @PostMapping
    public void postCadenaHotelera(@RequestBody CadenahoteleraDto cadenaHoteleraDTO) throws CadenahoteleraAlreadyExistException {
        this.cadenaHoteleraController.createCadenaHotelera(cadenaHoteleraDTO);
    }

    @RequestMapping(value = NOMBRECADENA, method = RequestMethod.GET)
    public CadenahoteleraDto getCadenaHoteleraByNombre(@PathVariable String nombre) throws CadenahoteleraNotExistException {
        return this.cadenaHoteleraController.getCadenahotelera(nombre);
    }
    
    @DeleteMapping(value=NOMBRECADENA)
    public void deleteCadenaHoteleta(@PathVariable CadenahoteleraDto cadenaHoteleraDTO) {
        this.cadenaHoteleraController.deleteCadenaHotelera(cadenaHoteleraDTO);
    }
    
    @GetMapping
    public List<CadenahoteleraDto> getAll(){
        return this.cadenaHoteleraController.getAll();
    }

}
