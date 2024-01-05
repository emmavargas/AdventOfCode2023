package ObjectsDays;

import java.util.*;

public class ManoCartas {
    private String cartas;
    String cartaModificada;
    Map<Character,Character> listaMoficiada= new HashMap<>();
    String puntaje;
    int rango;

    public ManoCartas(String c , String p)
    {
        listaMoficiada.put('A','a');
        listaMoficiada.put('K','b');
        listaMoficiada.put('Q','c');
        listaMoficiada.put('J','d');
        listaMoficiada.put('T','e');
        listaMoficiada.put('9','f');
        listaMoficiada.put('8','g');
        listaMoficiada.put('7','h');
        listaMoficiada.put('6','i');
        listaMoficiada.put('5','j');
        listaMoficiada.put('4','k');
        listaMoficiada.put('3','l');
        listaMoficiada.put('2','m');
        this.cartas = c;
        this.puntaje = p;
        char[] keyCartas = cartas.toCharArray();
        for(int indiceKey =0 ; indiceKey< keyCartas.length; indiceKey++)
        {
            keyCartas[indiceKey]= listaMoficiada.get(keyCartas[indiceKey]);
        }
        String cartaMod = new String(keyCartas);
        this.cartaModificada = cartaMod;

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
     public String getCartaModificada()
     {
         return this.cartaModificada;
     }
     public long puntajeReal()
     {
         long resultado = this.rango * Long.parseLong(this.puntaje);
         return resultado;
     }

}
