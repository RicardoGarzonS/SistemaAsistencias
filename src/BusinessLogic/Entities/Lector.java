package BusinessLogic.Entities;

import java.util.Scanner;

public class Lector {

    protected int lecturaTarjeta (){

        Scanner sc = new Scanner(System.in);
        System.out.println("(No se si borrarlo) Ingrese la tarjeta");
        String stringTarjeta = sc.nextLine();
        int retorno = Integer.parseInt(stringTarjeta);
        sc.close();
        return retorno;
    }

    

    
}
