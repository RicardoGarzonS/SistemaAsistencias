package BusinessLogic.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

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

     // Maybe tengo que cambiar y no poder idMateria sino el nombre y luego sacar de la tabla el id, revisarlo
    public int asistenciasMateriaEspecifica (int idUsuario,int idMateria) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(aBl.contarAsistenciasMateriaEspecifica(idUsuario, fechaActual, idMateria));
        return aBl.contarAsistenciasMateriaEspecifica(idUsuario, fechaActual, idMateria);
    }

    /***
     * 
     * @param idUsuario id del usuario, maybe se deba cambiar al correo o al codigo unico
     * @return el total de asistencias de todas las materias inscritas por el estudiante, aun no contemplo la posibilidad de que existan justificantes
     * @throws Exception
     */
    public String [] asistenciasTotalMaterias (Integer idUsuario) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.contarAsistenciasTotalMaterias(idUsuario, fechaActual)));
        return aBl.contarAsistenciasTotalMaterias(idUsuario, fechaActual);

    }

}