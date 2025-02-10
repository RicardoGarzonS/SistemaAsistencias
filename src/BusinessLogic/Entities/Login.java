package BusinessLogic.Entities;

import BusinessLogic.UsuarioBL;

public class Login {
    
    /***
     * 
     * @param correo es el correo del usaurio, lo usamos debido a que es unico
     * @param clave clave registrada para el usaurio
     * @return retorna el id correspondiente al usuario
     * @throws Exception
     */
    public int loginCuenta(String correo, String clave) throws Exception {
        UsuarioBL usuarioBL = new UsuarioBL();
        String correoUsuario = usuarioBL.getCorreoUsuario(correo);
        String claveUsuario = usuarioBL.getClaveUsuario(clave);
        
        if (correo.equals(correoUsuario) && clave.equals(claveUsuario)) {
            Integer idUsuario = usuarioBL.getIdUsuarioPorCorreo(correo);
            System.out.println("Sirve" + idUsuario);
            return idUsuario;
        } else {
            System.out.println("correoUsuario no sirve");
            return -1;
        }
    }
}
