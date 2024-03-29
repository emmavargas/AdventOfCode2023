import days.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int dato;
        Scanner ingresar = new Scanner(System.in);
        System.out.println("Ingrese dia: ");
        //dato = ingresar.nextInt();
        dato=10;
        switch (dato) {
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
            case 4:
                Day4 test4 = new Day4();
                test4.cargarLineas();
                test4.cargaListaTarjetas();
                test4.cargarPuntajes();
                test4.cargarCoincidencias();
                break;
            case 5:
                Day5 test5 = new Day5();
                test5.cargaDatos();
                test5.cargarCondiciones();
                test5.valorMenor();
                test5.valorFinalMinimos();
                test5.valorMinmo();
                test5.parte2Numeros();
                break;
            case 6:
                Day6 test6 = new Day6();
                test6.resolverDiaParte1();
                test6.resolverDiaParte2();
                break;
            case 7:
                Day7 test7=new Day7();
                test7.resolverParte1();
                test7.resolverParte2();
                break;
            case 8:
                Day8 test8= new Day8();
                test8.resolverParte1();
                test8.resolverParte2();
                break;
            case 9:
                Day9 test9= new Day9();
                test9.resolverParte1();
                test9.resolverParte2();
                break;
            case 10:
                Day10 test10= new Day10();
                test10.resolverParte1();
                break;
            default:
                System.out.println("No existe el dia.");
        }
        ingresar.close();
    }
}