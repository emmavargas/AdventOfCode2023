package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

public class Day1 {


    LinkedList<String> lines = new LinkedList<String>();
    LinkedList<Integer> lineNumber = new LinkedList<Integer>();

    public void loadToList() throws IOException
    {
        BufferedReader in = null;
        try
        {
            String line;
            in = new BufferedReader(new FileReader("src/InputDay1.txt"));
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

    /**
     * 
     */
    public void loadOfNumber()
    {
        LinkedList<String> numbers = new LinkedList<String>(Arrays.asList(
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        ));

        for(String line: lines)
        {
            int number;

            TreeMap<Integer, Integer> intNumbers = new TreeMap<Integer, Integer>();

            for(int i=0; i<line.length();i++)
            {
                int z = Character.getNumericValue(line.charAt(i));

                if(z>0 && z<10) {
                    intNumbers.put(i, z);
                }
            }

            for(String numberStr: numbers) {
                if (line.indexOf(numberStr) != -1) {
                    intNumbers.put(line.indexOf(numberStr), numbers.indexOf(numberStr));
                    intNumbers.put(line.lastIndexOf(numberStr), numbers.indexOf(numberStr));
                }
            }

            int minResult = intNumbers.firstEntry().getValue();
            int maxResult = intNumbers.lastEntry().getValue();

            number = (minResult*10)+maxResult;
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
