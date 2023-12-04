import days.*;
import ObjectsDays.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        int dato;
        Scanner ingresar = new Scanner(System.in);

        System.out.println("Ingrese dia: ");
        dato = ingresar.nextInt();
        switch(dato)
        {
            case 1:
                Day1 test1 = new Day1();
                test1.loadToList();
                test1.loadOfNumber();
                System.out.println(test1.result());
                break;
            case 2:
                Day2 test2 = new Day2();
                test2.loadData();
                test2.cantidadJuegos();
                break;
            case 3:
                Day3 test3 = new Day3();
                test3.loadLine();
                test3.loadNumbers();
                test3.loadCharacters();
                test3.obtenerNumerosValidos();
                test3.sumarPiezas();
                test3.valoresEngranajesNoValidos();
                test3.sumarEngranajes();
                break;
            default:
                System.out.println("No existe el dia.");
        }
    }
}