package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Cadenahotelera;
import es.upm.miw.dtos.CadenahoteleraDto;
import es.upm.miw.repositories.core.CadenahoteleraRepository;
@Controller
public class CadenahoteleraController {
    
    @Autowired
    private CadenahoteleraRepository cadenahotelerarepository;
    
    public CadenahoteleraController() {
        
    }
    
    public void createCadenaHotelera(CadenahoteleraDto cadenahoteleraDto) {
        Cadenahotelera cadenahotelera = new Cadenahotelera(cadenahoteleraDto.getNombre());
        this.cadenahotelerarepository.save(cadenahotelera);
    }
    
    public void deleteCadenaHotelera(CadenahoteleraDto cadenahoteleraDto) {
        Cadenahotelera cadenahotelera =this.getCadenahoteleraDocument(cadenahoteleraDto.getNombre());
        this.cadenahotelerarepository.delete(cadenahotelera);
        
    }
    
    public Cadenahotelera getCadenahoteleraDocument(String nombre) {
        return this.cadenahotelerarepository.findByNombre(nombre);
    }
    
    public CadenahoteleraDto getCadenahotelera(String nombre) {
        Cadenahotelera cadenahotelera = this.getCadenahoteleraDocument(nombre);
        CadenahoteleraDto cadenaHoteleraDto = new CadenahoteleraDto(cadenahotelera.getId(),cadenahotelera.getNombre());
        return cadenaHoteleraDto;
    }
    
    public List<CadenahoteleraDto> getAll(){
        List<Cadenahotelera> cadenaHoteleraList = this.cadenahotelerarepository.findAll();
        List<CadenahoteleraDto> cadenaHoteleraDtoList = new ArrayList<CadenahoteleraDto>();
        for (Cadenahotelera cadena : cadenaHoteleraList) {
            CadenahoteleraDto cadenaHoteleraDto = new CadenahoteleraDto(cadena.getId(), cadena.getNombre());
            cadenaHoteleraDtoList.add(cadenaHoteleraDto);
        }
        return cadenaHoteleraDtoList;
    }

}
