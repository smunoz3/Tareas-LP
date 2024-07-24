public class Amarillo extends Pikinim{
    public Amarillo(int cantidad){
    super(1, 3, cantidad);
    }

    @Override
    public void multiplicar(int cantidad){
        /*
        Entradas:
        cantidad Tipo int

        Funcionamiento:
        Llama a setCantidad aumentado la cantidad de pikinim
        segun cantidad*ataque 

        Salida:
        Nada
        */
        setCantidad(getCantidad()+cantidad*getAtaque());
    }
}