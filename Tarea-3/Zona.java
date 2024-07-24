public class Zona{
    protected boolean completada;

    public boolean getCompletada() {
        /*
        Entradas:
        Nada

        Funcionamiento:
        Retorna la variable completada
        
        Salida:
        completada Tipo int
        */
        return completada;
    }

    public void setCompletada(boolean completada) {
        /*
        Entradas:
        completada Tipo int

        Funcionamiento:
        Asigna el parametro completada a completada de la clase

        Salida:
        Nada
        */
        this.completada = completada;
    }

    public Zona(boolean completada){
        /*
        Entradas:
        completada Tipo bolean
        cantidad Tipo int
        scanner Tipo Scanner

        Funcionamiento:
        Es el constructor de Zona,
        asigna valor a completada

        Salida:
        Nada
        */
        this.completada = completada;
    }
    
    public void interactuar(Pikinim cyan,Pikinim Magenta, Pikinim Amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Comprueba si la zona esta completada, si esta completada
        imprime por pantalla un mensaje indicandolo

        Salida:
        Nada
        */
        if (getCompletada()){
            System.out.println("No queda nada que hacer aqu");
        }
    }
}