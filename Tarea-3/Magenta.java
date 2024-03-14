public class Magenta extends Pikinim{
    public Magenta(int cantidad){
    super(2, 1, cantidad);
    }

    @Override
    public void multiplicar(int cantidad){
        /*
        Entradas:
        cantidad Tipo int

        Funcionamiento:
        Llama a setCantidad aumentado la cantidad de pikinim
        segun cantidad*1.5 redondeado hacia arriba

        Salida:
        Nada
        */
        setCantidad(getCantidad()+(int)Math.ceil(cantidad*1.5));
    }
}