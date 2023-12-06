package ObjectsDays;

public class NumeroTransformado {
    private long valorEntrada;
    long valorsalida;

    long extension;
    public NumeroTransformado(long vE,long vS,long ext)
    {
        this.valorEntrada=vE;
        this.valorsalida=vS;
        this.extension=ext;
    }

    public long obtenerValorSalida(long num)
    {
        long valorReal=0;
        long variable = num-valorEntrada;
        long max= valorEntrada+extension;
        long min =valorEntrada;
        if(num<max && num>=min)
        {
            valorReal=valorsalida+variable;
        }
        return valorReal;
    }
    public void mostrar()
    {
        System.out.println(this.valorEntrada +" "+ this.valorsalida +" "+ this.extension);
    }
}
