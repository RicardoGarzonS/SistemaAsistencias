package DataAccess.DTO;

public class UsuarioDTO {

    private String IdUsuario          ;
    private String IdRol              ;
    private String IdTarjeta          ;
    private String NombreUsuario      ;
    private String Clave              ;
    private String Cedula             ;
    private String CorreoInstitucional;
    private String Estado             ;
    private String FechaCreacion      ;
    private String FechaModificacion  ;

    public UsuarioDTO(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public UsuarioDTO() {}

    public UsuarioDTO(String nombreUsuario, String cedula) {
        this.NombreUsuario = nombreUsuario;
        this.Cedula = cedula;
    }

    public UsuarioDTO(String idUsuario, String idRol, String idTarjeta, String nombreUsuario, String clave,
            String cedula, String correoInstitucional, String estado, String fechaCreacion, String fechaModificacion) {
        this.IdUsuario = idUsuario;
        this.IdRol = idRol;
        this.IdTarjeta = idTarjeta;
        this.NombreUsuario = nombreUsuario;
        this.Clave = clave;
        this.Cedula = cedula;
        this.CorreoInstitucional = correoInstitucional;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

        
    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getIdRol() {
        return IdRol;
    }

    public void setIdRol(String idRol) {
        IdRol = idRol;
    }

    public String getIdTarjeta() {
        return IdTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        IdTarjeta = idTarjeta;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getCorreoInstitucional() {
        return CorreoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        CorreoInstitucional = correoInstitucional;
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
        + "\n IdUsuario          : " + getIdUsuario          ()
        + "\n IdRol              : " + getIdRol              ()
        + "\n IdTarjeta          : " + getIdTarjeta          ()
        + "\n NombreUsuario      : " + getNombreUsuario      ()
        + "\n Clave              : " + getClave              ()
        + "\n Cedula             : " + getCedula             ()
        + "\n CorreoInstitucional: " + getCorreoInstitucional()
        + "\n Estado             : " + getEstado             ()
        + "\n FechaCreacion      : " + getFechaCreacion      ()
        + "\n FechaModificacion  : " + getFechaModificacion  ()
        ;  
    }
}