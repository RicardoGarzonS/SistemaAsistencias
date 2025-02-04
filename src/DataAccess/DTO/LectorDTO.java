package DataAccess.DTO;

public class LectorDTO {
    private String IdLector;
    private String CodigoAula;
    private String Estado;
    private String FechaCreacion;
    private String FechaModificacion;

    public LectorDTO() {}
    public LectorDTO(String IdLector, String CodigoAula, String Estado, String FechaCreacion, String FechaModificacion) {
        this.IdLector = IdLector;
        this.CodigoAula = CodigoAula;
        this.Estado = Estado;    
        this.FechaCreacion = FechaCreacion;
        this.FechaModificacion = FechaModificacion;
    }

    public String getIdLector() {
        return IdLector;
    }
    public void setIdLector(String idLector) {
        IdLector = idLector;
    }
    public String getCodigoAula() {
        return CodigoAula;
    }
    public void setCodigoAula(String codigoAula) {
        CodigoAula = codigoAula;
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
        + "\n IdLector:          " + getIdLector() 
        + "\n CodigoAula:        " + getCodigoAula()
        + "\n Estado:            " + getEstado()
        + "\n FechaCreacion:     " + getFechaCreacion()
        + "\n FechaModificacion: " + getFechaModificacion()
        ;
    }
    
}
