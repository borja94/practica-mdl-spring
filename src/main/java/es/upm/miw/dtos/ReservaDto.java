package es.upm.miw.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ReservaDto {

    private String id;

    private String nombreHotel;

    private String nombreUsuario;
    
    private Date fecha;
    
    private Date fechaSalida;

    private String hora;

    private String horaSalida;

    public ReservaDto() {

    }

    public ReservaDto(String nombreHotel, String nombreUsuario,  Date fecha,  Date fechaSalida,String Hora, String HoraSalida) {
        super();
        this.nombreHotel = nombreHotel;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.fechaSalida = fechaSalida;
        this.hora = Hora;
        this.horaSalida = HoraSalida;
    }
    
    
    public ReservaDto(String id , String nombreHotel, String nombreUsuario,Date fecha,  Date fechaSalida,String Hora, String HoraSalida) {
        super();
        this.nombreHotel = nombreHotel;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.fechaSalida = fechaSalida;
        this.hora = Hora;
        this.horaSalida = HoraSalida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombreHotel == null) ? 0 : nombreHotel.hashCode());
        result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReservaDto other = (ReservaDto) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombreHotel == null) {
            if (other.nombreHotel != null)
                return false;
        } else if (!nombreHotel.equals(other.nombreHotel))
            return false;
        if (nombreUsuario == null) {
            if (other.nombreUsuario != null)
                return false;
        } else if (!nombreUsuario.equals(other.nombreUsuario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ReservaDto [id=" + id + ", nombreHotel=" + nombreHotel + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + ", hora="
                + hora + "]";
    }

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

}
