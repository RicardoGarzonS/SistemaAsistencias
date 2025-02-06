package DataAccess.DTO;

//Este capaz no iria
public class ClaseDTO {

private String IdClase;
private String IdMateria;
private String IdDia;
private String HoraInicio;
private String HoraFin;
private String Estado;
private String FechaCreacion;
private String FechaModificacion;


public ClaseDTO() {}

public ClaseDTO(String IdMateria, String IdDia, String HoraInicio, String HoraFin) {
    this.IdMateria = IdMateria;
    this.IdDia = IdDia;
    this.HoraInicio = HoraInicio;
    this.HoraFin = HoraFin;
}

public ClaseDTO(String IdClase, String IdMateria, String IdDia, String HoraInicio, String HoraFin, String FechaModifica) {
    this.IdClase = IdClase;
    this.IdMateria = IdMateria;
    this.IdDia = IdDia;
    this.HoraInicio = HoraInicio;
    this.HoraFin = HoraFin;
    this.FechaModificacion = FechaModifica;
}

public ClaseDTO(String IdClase, String IdMateria, String IdDia, String HoraInicio, String HoraFin, String Estado, String FechaCreacion, String FechaModificacion) {
    this.IdClase = IdClase;
    this.IdMateria = IdMateria;
    this.IdDia = IdDia;
    this.HoraInicio = HoraInicio;
    this.HoraFin = HoraFin;
    this.Estado = Estado;
    this.FechaCreacion = FechaCreacion;
    this.FechaModificacion = FechaModificacion; 
}

public String getIdClase() {
    return IdClase;
}

public void setIdClase(String idClase) {
    IdClase = idClase;
}

public String getIdMateria() {
    return IdMateria;
}

public void setIdMateria(String idMateria) {
    IdMateria = idMateria;
}

public String getIdDia() {
    return IdDia;
}

public void setIdDia(String idDia) {
    IdDia = idDia;
}

public String getHoraInicio() {
    return HoraInicio;
}

public void setHoraInicio(String horaInicio) {
    HoraInicio = horaInicio;
}

public String getHoraFin() {
    return HoraFin;
}

public void setHoraFin(String horaFin) {
    HoraFin = horaFin;
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

public String toString(){
    return getClass().getName()
    + "\n IdClase               : "+ getIdClase() 
    + "\n IdMateria             : "+ getIdMateria()
    + "\n IdDia                 : "+ getIdDia() 
    + "\n HoraInicio            : "+ getHoraInicio()  
    + "\n HoraFin               : "+ getHoraFin()   
    + "\n Estado                : "+ getEstado()
    + "\n FechaCreacion         : "+ getFechaCreacion()
    + "\n FechaModificacion     : "+ getFechaModificacion()
   ;   
}

}
