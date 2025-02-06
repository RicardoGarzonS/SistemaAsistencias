package BusinessLogic.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


import BusinessLogic.AsistenciaBL;

public class Docente {
    /***
     * 
     * @param correoEstudiante el correo del estudiante
     * @param nombreMateria el nombre de la materia (Maybe esto la jalamos con un textBox o un comboBox de la GUI)
     * @return retorna el numero de asistencias, aun no contemplo la posibilidad de que existan justificantes
     * @throws Exception
     */
    public int asistenciasEstudianteEspecifico (String correoEstudiante, String nombreMateria) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(aBl.contarAsistenciasEstudianteEspecifico(correoEstudiante, fechaActual, nombreMateria));
        return aBl.contarAsistenciasEstudianteEspecifico(correoEstudiante, fechaActual, nombreMateria);
        
    }

}
