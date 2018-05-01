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

import es.upm.miw.controllers.ReservaController;
import es.upm.miw.dtos.ReservaDto;

@RestController
@RequestMapping(ReservaResource.RESERVA)
public class ReservaResource {

    public static final String RESERVA = "/reserva";

    public static final String ID = "/{id}";

    public static final String NOMBREHOTEL = "/{nombrehotel}";

    public static final String NOMBREUSUARIO = "/{nombreusuario}";

    public static final String ID_HABITACION = "/{idHabitacion}";

    public static final String HABITACION = "/habitacion";

    @Autowired
    private ReservaController reservaController;

    public ReservaResource() {

    }
    
    @GetMapping
    public List<ReservaDto> getAllReservas(){
        return this.reservaController.getAll();
    }

    @GetMapping (value = HABITACION+ID_HABITACION)
    public List<ReservaDto> getReservasByIdHabitacion (@PathVariable String idHabitacion) {
        return this.reservaController.getAllReservasByIdHabitacion(idHabitacion);
    }
    
    @PostMapping
    public void CreateReserva(@RequestBody ReservaDto reservaDto){
        this.reservaController.CreateReserva(reservaDto);        
    }
    
    @RequestMapping(value = NOMBREHOTEL, method = RequestMethod.GET)
    public List<ReservaDto> GetReservaByNombreHotel(@RequestBody ReservaDto reservaDto){
        return this.reservaController.getAllReservasFronNombreHotel(reservaDto);
    }
    
    @RequestMapping(value = NOMBREUSUARIO, method = RequestMethod.GET)
    public List<ReservaDto> GetReservaByNombreUsuaario(@RequestBody ReservaDto reservaDto){
        return this.reservaController.getAllReservasFromNombreUsuario(reservaDto);
    }
    
    @DeleteMapping
    public void DeleteReserva(@RequestBody ReservaDto reservaDto) {
        this.reservaController.deleteReserva(reservaDto);
    }
    
    @RequestMapping(value = ID, method = RequestMethod.GET)
    public ReservaDto getReservaById(@PathVariable String id) {
        return this.reservaController.getReservaById(id);
    }

}
