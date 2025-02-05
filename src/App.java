import BusinessLogic.Entities.Login;

public class App {    
    public static void main(String[] args) throws Exception {
        
        Login login = new Login();
        
        login.loginCuenta("correojuan", "1234");
    
    }
}