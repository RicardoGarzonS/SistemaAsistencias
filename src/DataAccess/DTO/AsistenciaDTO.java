package DataAccess.DTO;

public class AsistenciaDTO {
private String IdAsistencia     ; 
private String IdInscripcion    ; 
private String Fecha            ; 
private String HoraEntrada      ; 
private String HoraSalida       ; 
private String Justificacion    ; 
private String Estado           ; 
private String FechaCreacion    ; 
private String FechaModificacion;

public AsistenciaDTO() {}

public AsistenciaDTO(String idAsistencia, String idInscripcion, String fecha, String horaEntrada, String horaSalida,
        String justificacion, String estado, String fechaCreacion, String fechaModificacion) {
    this.IdAsistencia = idAsistencia;
    this.IdInscripcion = idInscripcion;
    this.Fecha = fecha;
    this.HoraEntrada = horaEntrada;
    this.HoraSalida = horaSalida;
    this.Justificacion = justificacion;
    this.Estado = estado;
    this.FechaCreacion = fechaCreacion;
    this.FechaModificacion = fechaModificacion;
}

public String getIdAsistencia() {
    return IdAsistencia;
}
public void setIdAsistencia(String idAsistencia) {
    IdAsistencia = idAsistencia;
}
public String getIdInscripcion() {
    return IdInscripcion;
}
public void setIdInscripcion(String idInscripcion) {
    IdInscripcion = idInscripcion;
}
public String getFecha() {
    return Fecha;
}
public void setFecha(String fecha) {
    Fecha = fecha;
}
public String getHoraEntrada() {
    return HoraEntrada;
}
public void setHoraEntrada(String horaEntrada) {
    HoraEntrada = horaEntrada;
}
public String getHoraSalida() {
    return HoraSalida;
}
public void setHoraSalida(String horaSalida) {
    HoraSalida = horaSalida;
}
public String getJustificacion() {
    return Justificacion;
}
public void setJustificacion(String justificacion) {
    Justificacion = justificacion;
}
public String getEstado() {
    return Estado;
}
public void setEstado(String estado) {
    Estado = estado;
}
public String getFechaCreacion() {
    return FechaCreacion;
}
public void setFechaCreacion(String fechaCreacion) {
    FechaCreacion = fechaCreacion;
}
public String getFechaModificacion() {
    return FechaModificacion;
}
public void setFechaModificacion(String fechaModificacion) {
    FechaModificacion = fechaModificacion;
}
 
@Override
    public String toString() {
        return getClass().getName()
            + "\n IdAsistencia     : " + getIdAsistencia     ()
            + "\n IdInscripcion    : " + getIdInscripcion    ()
            + "\n Fecha            : " + getFecha            ()
            + "\n HoraEntrada      : " + getHoraEntrada      ()
            + "\n HoraSalida       : " + getHoraSalida       ()
            + "\n Justificacion    : " + getJustificacion    ()
            + "\n Estado           : " + getEstado           ()
            + "\n FechaCreacion    : " + getFechaCreacion    ()
            + "\n FechaModificacion: " + getFechaModificacion()
            ;   
    }
    
}
