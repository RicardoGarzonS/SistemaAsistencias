package BusinessLogic.Entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;

import BusinessLogic.AsistenciaBL;
import DataAccess.DTO.AsistenciaDTO;

public class Lector {

    AsistenciaBL aBL = new AsistenciaBL();

    // protected int lecturaTarjeta (){

    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("(No se si borrarlo) Ingrese la tarjeta");
    //     String stringTarjeta = sc.nextLine();
    //     int retorno = Integer.parseInt(stringTarjeta);
    //     sc.close();
    //     return retorno;
    // }

    public KeyListener obtenerKeyListenerEntrada(JTextField lecturaTxt, AsistenciaDTO entity) {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Aquí no haces nada
            }

            @Override
            public void keyPressed(KeyEvent e){
                // Detectamos si la tecla presionada es "Enter"
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Obtener el texto del JTextField
                    Integer tarjeta = Integer.parseInt(lecturaTxt.getText());
                    // Llama al método para procesar la tarjeta
                    try {
                        procesarTarjetaEntrada(tarjeta, entity);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } 
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Aquí no haces nada
            }
        };
    }

    private void procesarTarjetaEntrada(Integer tarjeta, AsistenciaDTO entity) throws Exception{
        // Aquí puedes hacer lo que necesites con la tarjeta, como actualizar la base de datos
        System.out.println("Tarjeta leída: " + tarjeta);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String fechaActual = formatter.format(now);
        aBL.updateHoraEntrada(entity, fechaActual, aBL.getIdAsistenciaByIdUsuarioYFecha(tarjeta, fechaActual));
    }


    public KeyListener obtenerKeyListenerSalida(JTextField lecturaTxt, AsistenciaDTO entity) {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Aquí no haces nada
            }

            @Override
            public void keyPressed(KeyEvent e){
                // Detectamos si la tecla presionada es "Enter"
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Obtener el texto del JTextField
                    Integer tarjeta = Integer.parseInt(lecturaTxt.getText());
                    // Llama al método para procesar la tarjeta
                    try {
                        procesarTarjetaSalida(tarjeta, entity);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } 
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Aquí no haces nada
            }
        };
    }

    private void procesarTarjetaSalida(Integer tarjeta, AsistenciaDTO entity) throws Exception{
        // Aquí puedes hacer lo que necesites con la tarjeta, como actualizar la base de datos
        System.out.println("Tarjeta leída: " + tarjeta);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String fechaActual = formatter.format(now);
        aBL.updateHoraSalida(entity, fechaActual, aBL.getIdAsistenciaByIdUsuarioYFecha(tarjeta, fechaActual));
    }
}
