package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
            boolean flag=false;
            int max=0;
            int min = 0;
            int maxIndex=-1;
            int minIndex=-1;
            int number;

            for(int i=0; i<line.length();i++)
            {
                int z = Character.getNumericValue(line.charAt(i));

                if(z>0 && z<10) {
                    if(!flag) {
                        max = z;
                        min = z;
                        maxIndex=i;
                        minIndex=i;
                        flag=true;
                    } else {
                        max=z;
                        maxIndex = i;
                    }
                }
            }

            boolean flagStr=false;
            int maxStr = 0;
            int minStr = 0;
            int maxIndexStr=-1;
            int minIndexStr=-1;

            for(String numberStr: numbers) {
                if (line.indexOf(numberStr) != -1) {
                    if (!flagStr) {
                        maxStr = numbers.indexOf(numberStr);
                        minStr = numbers.indexOf(numberStr);
                        minIndexStr = line.indexOf(numberStr);
                        maxIndexStr = line.lastIndexOf(numberStr);
                        flagStr=true;
                    } else {
                        if(line.indexOf(numberStr) < minIndexStr) {
                            minStr = numbers.indexOf(numberStr);
                            minIndexStr = line.indexOf(numberStr);
                        }

                        if(line.lastIndexOf(numberStr) > maxIndexStr) {
                            maxStr = numbers.indexOf(numberStr);
                            maxIndexStr = line.lastIndexOf(numberStr);
                        }
                    }
                }
            }

            int minResult = 0;
            int maxResult = 0;
            
            if(minIndex != -1 && minIndexStr == -1) {
                minResult = min;
            } else if (minIndex == -1 && minIndexStr != -1) {
                minResult = minStr;
            } else {
                minResult = (minIndex < minIndexStr) ?  min : minStr;
            }

            if(maxIndex != -1 && maxIndexStr == -1) {
                maxResult = max;
            } else if (maxIndex == -1 && maxIndexStr != -1) {
                maxResult = maxStr;
            } else {
                maxResult = (maxIndex > maxIndexStr) ?  max : maxStr;
            }

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
