package ObjectsDays;

import java.util.*;

public class ManoCartas {
    private String cartas;
    String cartaModificadaParte1;
    String cartaModificadaParte2;
    Map<Character,Character> listaMoficiadaParte1= new HashMap<>();
    Map<Character,Character> listaMoficiadaParte2= new HashMap<>();
    String puntaje;
    int rango;

    public ManoCartas(String c , String p)
    {
        listaMoficiadaParte1.put('A','a');
        listaMoficiadaParte1.put('K','b');
        listaMoficiadaParte1.put('Q','c');
        listaMoficiadaParte1.put('J','d');
        listaMoficiadaParte1.put('T','e');
        listaMoficiadaParte1.put('9','f');
        listaMoficiadaParte1.put('8','g');
        listaMoficiadaParte1.put('7','h');
        listaMoficiadaParte1.put('6','i');
        listaMoficiadaParte1.put('5','j');
        listaMoficiadaParte1.put('4','k');
        listaMoficiadaParte1.put('3','l');
        listaMoficiadaParte1.put('2','m');

        listaMoficiadaParte2.put('A','a');
        listaMoficiadaParte2.put('K','b');
        listaMoficiadaParte2.put('Q','c');
        listaMoficiadaParte2.put('T','d');
        listaMoficiadaParte2.put('9','e');
        listaMoficiadaParte2.put('8','f');
        listaMoficiadaParte2.put('7','g');
        listaMoficiadaParte2.put('6','h');
        listaMoficiadaParte2.put('5','i');
        listaMoficiadaParte2.put('4','j');
        listaMoficiadaParte2.put('3','k');
        listaMoficiadaParte2.put('2','l');
        listaMoficiadaParte2.put('J','m');


        this.cartas = c;
        this.puntaje = p;
        char[] keyCartasParte1 = cartas.toCharArray();
        char[] keyCartasParte2 = cartas.toCharArray();
        for(int indiceKey =0 ; indiceKey< keyCartasParte1.length; indiceKey++)
        {
            keyCartasParte1[indiceKey]= listaMoficiadaParte1.get(keyCartasParte1[indiceKey]);
            keyCartasParte2[indiceKey]= listaMoficiadaParte2.get(keyCartasParte2[indiceKey]);
        }
        String cartaModParte1 = new String(keyCartasParte1);
        String cartaModParte2 = new String(keyCartasParte2);
        this.cartaModificadaParte1 = cartaModParte1;
        this.cartaModificadaParte2 = cartaModParte2;

    }
     public void setRango(int rango)

     {
         this.rango = rango;
     }
     public String getCartas(){
        return this.cartas;
     }
     public String getPuntaje()
     {
         return this.puntaje;
     }
     public int getRango()
     {
         return this.rango;
     }
     public String getCartaModificadaParte1()
     {
         return this.cartaModificadaParte1;
     }
     public String getCartaModificadaParte2()
     {
         return this.cartaModificadaParte2;
     }
     public long puntajeReal()
     {
         long resultado = this.rango * Long.parseLong(this.puntaje);
         return resultado;
     }

}
