package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Reserva;

import es.upm.miw.dtos.ReservaDto;
import es.upm.miw.repositories.core.ReservaRepository;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservarepo;

    public ReservaController() {

    }
    
    public List<ReservaDto> getAll(){
        List<Reserva> reservaList = this.reservarepo.findAll();
        List<ReservaDto> reservaDtoList = new ArrayList<ReservaDto>();
        for (Reserva reserva : reservaList) {            
            ReservaDto reservaDtoAux = new ReservaDto(reserva.getId(),reserva.getNombreHotel(),
                    reserva.getNombreUsuario(),reserva.getFecha(),reserva.getHora());
            reservaDtoList.add(reservaDtoAux);            
        }
        return reservaDtoList;
    }

    public void CreateReserva(ReservaDto reservaDto) {
        Reserva reserva = new Reserva(reservaDto.getNombreHotel(), reservaDto.getNombreUsuario(), reservaDto.getFecha(),
                reservaDto.getHora());
        this.reservarepo.save(reserva);
    }

    public ReservaDto getReservaById(String id) {
        Reserva reserva = this.reservarepo.findById(id);
        ReservaDto reservDto = new ReservaDto(reserva.getId(), reserva.getNombreHotel(), reserva.getNombreUsuario(), reserva.getFecha(),
                reserva.getHora());
        return reservDto;
    }

    public void modifyReserva(ReservaDto reservaDto) {
        Reserva reserva = new Reserva(reservaDto.getId(), reservaDto.getNombreHotel(), reservaDto.getNombreUsuario(), reservaDto.getFecha(),
                reservaDto.getHora());
        this.reservarepo.save(reserva);
    }

    public void deleteReserva(ReservaDto reservaDto) {
        Reserva reserva = new Reserva(reservaDto.getId(), reservaDto.getNombreHotel(), reservaDto.getNombreUsuario(), reservaDto.getFecha(),
                reservaDto.getHora());
        this.reservarepo.delete(reserva);

    }

    public List<ReservaDto> getAllReservasFromNombreUsuario(ReservaDto reservaDto) {
        List<Reserva> reservaList = this.reservarepo.findAll();
        List<ReservaDto> reservaDtoList = new ArrayList<ReservaDto>();
        for (Reserva reserva : reservaList) {
            if (reserva.getNombreUsuario().equals(reservaDto.getNombreUsuario())) {
                ReservaDto reservaDtoAux = new ReservaDto(reserva.getId(),reserva.getNombreHotel(),
                        reserva.getNombreUsuario(),reserva.getFecha(),reserva.getHora());
                reservaDtoList.add(reservaDtoAux);
            }
        }
        return reservaDtoList;

    }

    public List<ReservaDto> getAllReservasFronNombreHotel(ReservaDto reservaDto) {
        List<Reserva> reservaList = this.reservarepo.findAll();
        List<ReservaDto> reservaDtoList = new ArrayList<ReservaDto>();
        for (Reserva reserva : reservaList) {
            if (reserva.getNombreHotel().equals(reservaDto.getNombreHotel())) {
                ReservaDto reservaDtoAux = new ReservaDto(reserva.getId(),reserva.getNombreHotel(),
                        reserva.getNombreUsuario(),reserva.getFecha(),reserva.getHora());
                reservaDtoList.add(reservaDtoAux);
            }
        }
        return reservaDtoList;
    }

}
