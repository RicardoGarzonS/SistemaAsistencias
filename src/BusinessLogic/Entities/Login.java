package BusinessLogic.Entities;

import BusinessLogic.UsuarioBL;

public class Login {
    
    // sujeto a cambios cunado se implemente en la interfaz grafica
    public boolean loginCuenta(String correo, String clave) throws Exception {
        UsuarioBL usuarioBL = new UsuarioBL();
        String nombreUsuario = usuarioBL.getCorreoUsuario(correo);
        String claveUsuario = usuarioBL.getClaveUsuario(clave);
        
        if (correo.equals(nombreUsuario) && clave.equals(claveUsuario)) {
            System.out.println("Sirve");
            return true;
        } else {
            System.out.println("No sirve");
            return false;
        }
    }
}
