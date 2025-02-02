package Framework;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionLogger extends Exception {
    final String logPath = "src/Framework/Log.txt";

    public ExceptionLogger(String e, String clase, String metodo) {
        try {
            FileWriter logger = new FileWriter(logPath, true);
            logger.append("\n[ERROR EN Sistema de Asistencias para el LOG] " + clase +"."+ metodo +" : "+ e );
            logger.close();
        } catch (IOException error) {}
    }

    @Override 
    public String getMessage(){
        return "NO sea sapo..";
    }    
}
