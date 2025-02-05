package BusinessLogic;

import java.time.LocalDate;


public class ConfiguracionClase {
    private LocalDate fechaInicio;
    private int semanasDuracion;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getSemanasDuracion() {
        return semanasDuracion;
    }

    public void setSemanasDuracion(int semanasDuracion) {
        this.semanasDuracion = semanasDuracion;
    }

    public ConfiguracionClase(LocalDate fechaInicio, int semanasDuracion) {
        this.fechaInicio = fechaInicio;
        this.semanasDuracion = semanasDuracion;
    }

}



