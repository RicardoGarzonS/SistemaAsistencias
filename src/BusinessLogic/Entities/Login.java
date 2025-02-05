package BusinessLogic.Entities;

import BusinessLogic.UsuarioBL;

public class Login {
    
    // sujeto a cambios cunado se implemente en la interfaz grafica
    public int loginCuenta(String correo, String clave) throws Exception {
        UsuarioBL usuarioBL = new UsuarioBL();
        String correoUsuario = usuarioBL.getCorreoUsuario(correo);
        String claveUsuario = usuarioBL.getClaveUsuario(clave);
        
        if (correo.equals(correoUsuario) && clave.equals(claveUsuario)) {
            
            Integer rolUsuario = usuarioBL.getRolUsuario(correo);
            System.out.println("Sirve" + rolUsuario);
            return rolUsuario;
        } else {
            System.out.println("correoUsuario sirve");
            return -1;
        }
    }
}
