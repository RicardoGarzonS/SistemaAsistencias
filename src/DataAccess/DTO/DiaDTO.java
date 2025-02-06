package DataAccess.DTO;

public class DiaDTO {
    private String IdDia;
    private String Nombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModificacion;

    public DiaDTO() {}

    public DiaDTO(String Nombre) {
        this.Nombre = Nombre;
    }

    public DiaDTO(String Nombre, String FechaModifica) {
        this.Nombre = Nombre;
        this.FechaModificacion = FechaModifica;
    }
    public DiaDTO(String IdDia, String Nombre, String Estado, String FechaCreacion, String FechaModificacion) {
        this.IdDia = IdDia;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.FechaCreacion = FechaCreacion;    
        this.FechaModificacion = FechaModificacion; 
    }

    public String getIdDia() {
        return IdDia;
    }
    public void setIdDia(String idDia) {
        IdDia = idDia;
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
        + " \n IdDia:              " + getIdDia()
        + " \n Nombre:             " + getNombre()
        + " \n Estado:             " + getEstado()
        + " \n FechaCreacion:      " + getFechaCreacion()    
        + " \n FechaModificacion:  " + getFechaModificacion()
        ;
    }

}
