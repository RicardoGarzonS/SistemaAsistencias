package BusinessLogic.Entities;

import BusinessLogic.UsuarioBL;

public class Login {
    
    // sujeto a cambios cunado se implemente en la interfaz grafica
    public boolean loginCuenta(String correo, String clave) throws Exception {
        UsuarioBL usuarioBL = new UsuarioBL();
        String correoUsuario = usuarioBL.getCorreoUsuario(correo);
        String claveUsuario = usuarioBL.getClaveUsuario(clave);
        
        if (correo.equals(correoUsuario) && clave.equals(claveUsuario)) {
            System.out.println("Sirve");
            return true;
        } else {
            System.out.println("correoUsuario sirve");
            return false;
        }
    }
}
