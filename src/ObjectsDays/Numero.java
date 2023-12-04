package ObjectsDays;

public class Numero {
    private int num;
    private int indexFirstNumber;
    private int indexLastNumber;

    public Numero(int num1, int indexFirstNum1, int indexLastNum1)
    {
        this.num = num1;
        this.indexFirstNumber = indexFirstNum1;
        this.indexLastNumber = indexLastNum1;
    }
    public int getNum()
    {
        return this.num;
    }
    public int getIndexFirstNumber()
    {
        return this.indexFirstNumber;
    }
    public int getIndexLastNumber()
    {
        return this.indexLastNumber;
    }
}