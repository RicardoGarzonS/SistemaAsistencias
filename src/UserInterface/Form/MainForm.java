package UserInterface.Form;

import DataAccess.DTO.UsuarioDTO;

public class MainForm {
    LogInForm lg;
    StudentForm sf;
    TeacherForm tf;
    AdminForm af;

    LectorEntradaForm lf;
    LectorSalidaForm ls;

    public MainForm(){
        mostrarLogin();
        //LectorEntradaForm lf = new LectorEntradaForm("Lector Entrada", this);
        //LectorSalidaForm ls = new LectorSalidaForm("Lector Salida", this);
    }

    public void mostrarLogin(){
        sf = null;
        tf = null;
        af = null;
        lf = null;
        ls = null;
        lg = new LogInForm("Sistema de Asistencia", this);
    }

    public void mostrarEstudiante(UsuarioDTO us){
        lg = null;
        tf = null;
        af = null;
        lf = null;
        ls = null;
        sf = new StudentForm(us, this);
    }

    public void mostrarProfesor(UsuarioDTO us){
        lg = null;
        sf = null;
        af = null;
        lf = null;
        ls = null;
        tf = new TeacherForm(us, this);
    }

    public void mostrarAdmin(UsuarioDTO us){
        lg = null;
        sf = null;
        tf = null;
        lf = null;
        ls = null;
        af = new AdminForm(us, this);
    }
    public void mostrarLector(){
        sf = null;
        tf = null;
        af = null;
        lg = null;
        lf = new LectorEntradaForm("Lector Entrada", this);
        ls = new LectorSalidaForm("Lector Salida", this);
    }
}
