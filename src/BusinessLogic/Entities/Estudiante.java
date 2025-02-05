package BusinessLogic.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import BusinessLogic.AsistenciaBL;

// import BusinessLogic.ClaseBL;

public class Estudiante {
    
    // public int asistenciasRegistradas (int idMateria) throws Exception {
    //     ClaseBL claseBL = new ClaseBL();
    //     int totalClases = claseBL.countDias(idMateria);
    //     int asistencias = 
    //     // contar asistencias 
    //     return 0;
    // }

    /***
     * 
     * @param idMateria materia a consular
     * @param fechaInscripcion fecha de inscripcion del estudiante a la materia (tabla inscripcion)
     * @return
     */
    public int asistenciasRegistradasEspecifico (int idUsuario,int idMateria) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(aBl.contarAsistenciasEspecifico(idUsuario, fechaActual, idMateria));
        return aBl.contarAsistenciasEspecifico(idUsuario, fechaActual, idMateria);


        // String [] fechaActualSeparada = fechaActual.split("/"); 
        // int [] fechaActualInt = new int[3];

        // fechaActualInt[2] = Integer.parseInt(fechaActualSeparada[2]);    

        // String [] fechaSeparada = fechaInscripcion.split("/");
        // int [] fechaInt = new int[3];
        // fechaInt[2] = Integer.parseInt(fechaSeparada[2]);

        // if (fechaActualInt[2]>=fechaInt[2]) {
            
        // }
    }
}