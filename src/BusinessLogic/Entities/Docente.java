package BusinessLogic.Entities;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import BusinessLogic.AsistenciaBL;
import BusinessLogic.InscripcionBL;

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

    public String [] asistenciasTotalEstudiantes (String nombreMateria) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.contarAsistenciasEstudiantesPorMateria(nombreMateria, fechaActual)));
        return aBl.contarAsistenciasEstudiantesPorMateria(nombreMateria, fechaActual);
    }

    public String [][] tablaConteoAsistenciasTotalEYMProfesor (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.tablaConteoAsistenciasTotalEYMProfesor(idDocente, fechaActual)));
        return aBl.tablaConteoAsistenciasTotalEYMProfesor(idDocente, fechaActual);
    }

    public String [][] tablaConteoTipoAsistenciasDME (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.tablaConteoTipoAsistenciasDME(idDocente, fechaActual)));
        return aBl.tablaConteoTipoAsistenciasDME(idDocente, fechaActual);
    }

    public String [][] totalAsistenciasTotalMateriasD (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        return aBl.tablaAsistenciasTotalMateriasD(idDocente, fechaActual);
    }

    public String [][] totalAsistenciasTipoD (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        return aBl.tablaConteoTipoAsistenciasD(idDocente, fechaActual);
    }

    public String [][] tablaHorarioD (Integer idDocente) throws Exception {
        InscripcionBL iBl = new InscripcionBL();
        return iBl.getHorario(idDocente);
    }

}
