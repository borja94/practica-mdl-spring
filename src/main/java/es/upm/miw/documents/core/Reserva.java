package es.upm.miw.documents.core;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reserva {
    @Id
    private String id;

    @Indexed
    private String nombreHotel;

    @Indexed
    private String nombreUsuario;

    @Indexed
    private Date fecha;
    
    private Date fechaSalida;

    private String hora;

    private String horaSalida;

    private String idHabitacion;
    
    public Reserva() {
        
    }
    
    public Reserva(String id ,String nombreHotel , String nombreUsuario , Date fecha ,Date fechaSalida ,  String Hora, String horaSalida) {
        super();
        this.id = id;
        this.nombreHotel = nombreHotel;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.fechaSalida = fechaSalida;
        this.hora = Hora;
        this.horaSalida = horaSalida;
    }
    
    
    public Reserva(String nombreHotel , String nombreUsuario , Date fecha , Date fechaSalida ,  String Hora, String horaSalida, String idHabitacion) {
        super();
        this.nombreHotel = nombreHotel;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.fechaSalida = fechaSalida;
        this.hora = Hora;
        this.horaSalida = horaSalida;
        this.idHabitacion = idHabitacion;
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

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
        result = prime * result + ((horaSalida == null) ? 0 : horaSalida.hashCode());
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
        Reserva other = (Reserva) obj;
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
        return "Reserva [id=" + id + ", nombreHotel=" + nombreHotel + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + ", hora="
                + hora + ",fecha salida = "  + fechaSalida + ", hora salida=" + horaSalida + ", id_habitacion= "+ idHabitacion +" ]";
    }

}
