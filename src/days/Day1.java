package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day1 {


    LinkedList<String> lines = new LinkedList<String>();
    LinkedList<Integer> lineNumber = new LinkedList<Integer>();

    public void loadToList() throws IOException
    {
        BufferedReader in = null;
        try
        {
            String line;
            in = new BufferedReader(new FileReader("src\\InputDay1.txt"));
            while((line=in.readLine())!=null)
            {
                lines.add(line);
            }
        }
        finally {
            if(in!=null)
            {
                in.close();
            }
        }
    }

    public void loadOfNumber()
    {
        LinkedList<String> numbers = new LinkedList<String>();
        numbers.add("zero");
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");
        numbers.add("six");
        numbers.add("seven");
        numbers.add("eight");
        numbers.add("nine");

        for(String e: lines)
        {
            int floag =0;
            int max=0;
            int min = 0;
            int maxIndex=0;
            int minIndex=0;
            int number;

            for(int i=0; i<e.length();i++)
            {
                int z = Character.getNumericValue(e.charAt(i));
                for( int j = 0; j<10; j++)
                {
                    if(j==z)
                    {
                        if(floag==0)
                        {
                            max = j;
                            min = j;
                            maxIndex=i;
                            minIndex=i;
                            floag =1;
                        }
                        else {
                            max =j;
                            maxIndex = i;
                        }
                    }
                }
            }

            for(String f: numbers) {
                if (e.indexOf(f) != -1) {
                    if (floag == 0) {
                        max = numbers.indexOf(f);
                        min = numbers.indexOf(f);
                        minIndex = e.indexOf(f);
                        maxIndex = e.lastIndexOf(f);
                        floag = 1;
                    } else {
                        if (e.indexOf(f) < minIndex) {
                            min = numbers.indexOf(f);
                            minIndex = e.indexOf(f);
                            if(e.lastIndexOf(f) > maxIndex) {
                                max = numbers.indexOf(f);
                                maxIndex = e.lastIndexOf(f);
                            }
                        }
                        else if (e.lastIndexOf(f) > maxIndex) {
                            max = numbers.indexOf(f);
                            maxIndex = e.lastIndexOf(f);
                        }
                    }
                }
            }
            number = (min*10)+max;
            lineNumber.add(number);
        }
    }

    public int result()
    {
        int total=0;
        for(Integer e: lineNumber)
        {
            total= total +e;
        }
        return total;
    }

}
