package DataAccess.DTO;

public class MateriaDTO {
    private String IdMateria;   
    private String Nombre;  
    private String Estado;  
    private String FechaCreacion;   
    private String FechaModificacion;

    public MateriaDTO() {}
    public MateriaDTO(String IdMateria, String Nombre, String Estado, String FechaCreacion, String FechaModificacion) {
        this.IdMateria = IdMateria;
        this.Nombre = Nombre;
        this.Estado = Estado;    
        this.FechaCreacion = FechaCreacion;
        this.FechaModificacion = FechaModificacion;
    }

    public String getIdMateria() {
        return IdMateria;
    }
    public void setIdMateria(String idMateria) {
        IdMateria = idMateria;
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
    public String toString(){
        return getClass().getName()
        + " \n IdMateria:         " + getIdMateria()
        + " \n Nombre:            " + getNombre()
        + " \n Estado:            " + getEstado()
        + " \n FechaCreacion:     " + getFechaCreacion()        
        + " \n FechaModificacion: " + getFechaModificacion()        
        ;
    }
}
