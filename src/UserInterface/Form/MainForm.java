package UserInterface.Form;

import DataAccess.DTO.UsuarioDTO;

public class MainForm {
    LogInForm lg;
    StudentForm sf;
    TeacherForm tf;
    AdminForm af;

    public MainForm(){
        mostrarLogin();
        LectorEntradaForm lf = new LectorEntradaForm("Lector Entrada", this);
        LectorSalidaForm ls = new LectorSalidaForm("Lector Salida", this);
    }

    public void mostrarLogin(){
        sf = null;
        tf = null;
        af = null;
        lg = new LogInForm("Sistema de Asistencia", this);
    }

    public void mostrarEstudiante(UsuarioDTO us){
        lg = null;
        tf = null;
        af = null;
        sf = new StudentForm(us, this);
    }

    public void mostrarProfesor(UsuarioDTO us){
        lg = null;
        sf = null;
        af = null;
        tf = new TeacherForm(us, this);
    }

    public void mostrarAdmin(UsuarioDTO us){
        lg = null;
        sf = null;
        tf = null;
        af = new AdminForm(us, this);
    }
}
