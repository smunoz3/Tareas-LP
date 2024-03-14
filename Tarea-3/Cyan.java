public class Cyan extends Pikinim{
    public Cyan(int cantidad){
    super(1, 1, cantidad);
    }

    @Override
    public void multiplicar(int cantidad) {
        /*
        Entradas:
        cantidad Tipo int

        Funcionamiento:
        Llama a setCantidad aumentado la cantidad de pikinim
        segun cantidad*3 

        Salida:
        Nada
        */
        setCantidad(getCantidad()+cantidad*3);
    }
}