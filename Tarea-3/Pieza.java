public class Pieza extends Zona implements ILevantar{
    private int peso;

    public int getPeso() {
        /*
        Entradas:
        Nada

        Funcionamiento:
        Retorna la variable peso
        
        Salida:
        peso Tipo int
        */
        return peso;
    }

    public void setPeso(int peso){
        /*
        Entradas:
        peso Tipo int

        Funcionamiento:
        Asigna el parametro peso a peso de la clase

        Salida:
        Nada
        */
        this.peso = peso;
    }

    public Pieza(boolean completada,int peso){
        /*
        Entradas:
        completada Tipo bolean
        peso Tipo int

        Funcionamiento:
        Es el constructor de Pieza, llama al constructor de Zona 
        y le asigna valores a peso

        Salida:
        Nada
        */
        super(completada);
        this.peso = peso;
    }

    @Override
    public void interactuar(Pikinim cyan,Pikinim Magenta, Pikinim Amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Comprueba si la zona esta completada, si no lo esta llama a levantar
        si la zona esta completada se imprime un mensaje indicandolo

        Salida:
        Nada
        */
        if(!getCompletada()){
            Levantar(cyan, Magenta, Amarillo);
        }
        else{
            System.out.println("No hay nada que podamos hacer\n");
        }
    }
    @Override
    public void Levantar(Pikinim cyan,Pikinim magenta,Pikinim amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Comprueba si la capacidad de los pikinim es al menos el peso del enemigo 
        si es asi marca la zona como completada
        
        Salida:
        Nada
        */
        int sumCyan = cyan.getCantidad()*cyan.getCapacidad();
        int sumAmarillo = amarillo.getCantidad()*amarillo.getCapacidad();
        int sumMagenta = magenta.getCantidad()*magenta.getCapacidad();
        if (getPeso()<=(sumCyan+sumAmarillo+sumMagenta)){
            setCompletada(true);
            System.out.println("Levantaste la pieza\n");
        }
        else{
            System.out.println("No pudiste levantar la pieza\n");
        }
    }
}