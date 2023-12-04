package days;
import ObjectsDays.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Day3 {
    LinkedList<String> lines = new LinkedList<String>();
    HashMap<Integer,LinkedList<Numero>> matrizNumeros = new HashMap<Integer,LinkedList<Numero>>();
    HashMap<Integer,LinkedList<Integer>> matrizCaracteres = new HashMap<Integer,LinkedList<Integer>>();
    LinkedList<Integer> numerosASumar = new LinkedList<Integer>();

    LinkedList<Integer> numerosEngranajes = new LinkedList<Integer>();


    public void loadLine() throws IOException
    {
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new FileReader("src\\InputDay3.txt"));
            String line;
            while((line=in.readLine())!=null)
            {
                lines.add(line);
            }

        }
        finally
        {
            if(in!=null)
            {
                in.close();
            }
        }
    }

    public void loadNumbers()
    {
        for(String line: lines)
        {
            LinkedList<Numero> numbers = new LinkedList<Numero>();
            for(int i= 0; i<line.length();i++)
            {

                if (Character.isDigit(line.charAt(i)))
                {
                    int inicioNumero =i;
                    while (i < line.length() && (Character.isDigit(line.charAt(i)))) {
                        i++;
                    }
                    int finNumero = i;
                    String aux =line.substring(inicioNumero,finNumero);
                    int numero = Integer.parseInt(aux);
                    numbers.add(new Numero(numero,inicioNumero,finNumero-1));
                }
            }


            matrizNumeros.put(lines.indexOf(line), numbers);
        }
    }

    public void loadCharacters()
    {
        for(String line: lines)
        {
            LinkedList<Integer> characters = new LinkedList<Integer>();
            for(int i= 0; i<line.length();i++)
            {

                if (!Character.isLetterOrDigit(line.charAt(i)) && line.charAt(i)!='.')
                {
                    int indexCharacter =i;
                    characters.add(indexCharacter);
                }
            }

            matrizCaracteres.put(lines.indexOf(line), characters);
        }

    }

    public void obtenerNumerosValidos()
    {
        for(int i=1; i<matrizCaracteres.size()-1;i++)
        {
            for(int caracter: matrizCaracteres.get(i))
            {
                for(int j=-1; j<=1;j++)
                {
                    int k= i+j;
                    for(Numero n : matrizNumeros.get(k))
                    {
                        if (caracter-1== (n.getIndexLastNumber()) || caracter+1== (n.getIndexFirstNumber()) || ((caracter<=(n.getIndexLastNumber())) &&(caracter>=(n.getIndexFirstNumber()))))
                        {
                            //System.out.println(n.getNum());|
                            numerosASumar.add(n.getNum());

                        }
                    }


                }
            }

        }
    }
    public void sumarPiezas()
    {
        int result =0;
        for(Integer numerosValidos: numerosASumar)
        {
            result = result+numerosValidos;
        }
        System.out.println(result);
    }



    public void valoresEngranajesNoValidos()
    {
        for(int i=1; i<matrizCaracteres.size()-1;i++)
        {
            for(int caracter: matrizCaracteres.get(i))
            {
                int engranaje=1;
                int flag=0;
                for(int j=-1; j<=1;j++)
                {

                    int k= i+j;
                    for(Numero n : matrizNumeros.get(k))
                    {
                        if (caracter-1== (n.getIndexLastNumber()) || caracter+1== (n.getIndexFirstNumber()) || ((caracter<=(n.getIndexLastNumber())) &&(caracter>=(n.getIndexFirstNumber()))))
                        {
                            engranaje = engranaje*n.getNum();
                            flag=flag+1;
                        }
                    }


                }
                if(flag==2)
                {
                    numerosEngranajes.add(engranaje);
                }
            }

        }
    }

    public void sumarEngranajes()
    {
        int result =0;
        for(Integer numerosValidos: numerosEngranajes)
        {
            result = result+numerosValidos;
        }
        System.out.println(result);
    }

}
