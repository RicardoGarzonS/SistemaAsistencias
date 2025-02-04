package DataAccess.DTO;

public class RolDTO {
    private String IdRol;
    private String Nombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModificacion;

    public RolDTO() {}
    public RolDTO(String idRol, String nombre, String estado, String fechaCreacion, String fechaModificacion) {
        IdRol = idRol;
        Nombre = nombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModificacion = fechaModificacion;
    }
    public String getIdRol() {
        return IdRol;
    }
    public void setIdRol(String idRol) {
        IdRol = idRol;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
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
        + "\n IdRol              :" + getIdRol()
        + "\n Nombre             :" + getNombre()
        + "\n Estado             :" + getEstado()    
        + "\n FechaCreacion      :" + getFechaCreacion()    
        + "\n FechaModificacion  :" + getFechaModificacion()    
        ;
    }
}
