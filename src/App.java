// import BusinessLogic.Entities.Login;

import BusinessLogic.Entities.Estudiante;

public class App {    
    public static void main(String[] args) throws Exception {
    

        // Login lg = new Login();
        // lg.loginCuenta("juan@epn.edu.ec", "1234");

        Estudiante estudiante = new Estudiante();
        estudiante.asistenciasRegistradasEspecifico(1, 1);


    }
}