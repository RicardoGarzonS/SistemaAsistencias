package BusinessLogic.Entities;

import BusinessLogic.UsuarioBL;

public class Login {
    
    // sujeto a cambios cunado se implemente en la interfaz grafica
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
