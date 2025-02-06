package DataAccess.DTO;

public class InscripcionDTO {
private String IdInscripcion    ;
private String IdUsuario        ;
private String IdClase          ;
private String IdLector         ;
private String Año              ;
private String Estado           ;
private String FechaCreacion    ;
private String FechaModificacion;

public InscripcionDTO() {}

public InscripcionDTO(String idUsuario, String idClase, String idLector, String año) {
    this.IdUsuario = idUsuario;
    this.IdClase = idClase;
    this.IdLector = idLector;
    this.Año = año;
}

public InscripcionDTO(String IdUsuario, String IdClase, String IdLector, String Año,String FechaModificacion) {
    this.IdUsuario = IdUsuario;
    this.IdClase = IdClase;
    this.IdLector = IdLector;
    this.Año = Año;
    this.FechaModificacion = FechaModificacion;
}


public InscripcionDTO(String IdInscripcion, String IdUsuario, String IdClase, String IdLector, String Año, String Estado, String FechaCreacion, String FechaModificacion) {
    this.IdInscripcion = IdInscripcion;
    this.IdUsuario = IdUsuario;
    this.IdClase = IdClase;
    this.IdLector = IdLector;
    this.Año = Año;
    this.Estado = Estado;
    this.FechaCreacion = FechaCreacion;
    this.FechaModificacion = FechaModificacion;
    
}

public String getIdInscripcion() {
    return IdInscripcion;
}

public void setIdInscripcion(String idInscripcion) {
    IdInscripcion = idInscripcion;
}

public String getIdUsuario() {
    return IdUsuario;
}

public void setIdUsuario(String idUsuario) {
    IdUsuario = idUsuario;
}

public String getIdClase() {
    return IdClase;
}

public void setIdClase(String idClase) {
    IdClase = idClase;
}

public String getIdLector() {
    return IdLector;
}

public void setIdLector(String idLector) {
    IdLector = idLector;
}

public String getAño() {
    return Año;
}

public void setAño(String año) {
    Año = año;
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
    public String toString(){
        return getClass().getName()
        + "\n IdInscripcion    : " + getIdInscripcion    ()
        + "\n IdUsuario        : " + getIdUsuario        ()
        + "\n IdClase          : " + getIdClase          ()
        + "\n IdLector         : " + getIdLector         ()
        + "\n Año              : " + getAño              ()
        + "\n Estado           : " + getEstado           ()
        + "\n FechaCreacion    : " + getFechaCreacion    ()
        + "\n FechaModificacion: " + getFechaModificacion()
        ;   
    }


}
