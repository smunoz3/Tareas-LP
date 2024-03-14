abstract public class Pikinim {
    private int ataque;
    private int capacidad;
    private int cantidad;

    public int getAtaque() {
        /*
        Entradas:
        Nada

        Funcionamiento:
        Retorna la variable ataque
        
        Salida:
        ataque Tipo int
        */
        return ataque;
    }
    public int getCapacidad() {
        /*
        Entradas:
        Nada

        Funcionamiento:
        Retorna la variable capacidad
        
        Salida:
        capacidad Tipo int
        */
        return capacidad;
    }
    public int getCantidad() {
        /*
        Entradas:
        Nada

        Funcionamiento:
        Retorna la variable cantidad
        
        Salida:
        cantidad Tipo int
        */
        return cantidad;
    }

    public void setAtaque(int ataque) {
        /*
        Entradas:
        ataque Tipo int

        Funcionamiento:
        Asigna el parametro ataque a ataque de la clase

        Salida:
        Nada
        */
        this.ataque = ataque;
    }
    public void setCapacidad(int capacidad) {
        /*
        Entradas:
        capacidad Tipo int

        Funcionamiento:
        Asigna el parametro capacidad a capacidad de la clase

        Salida:
        Nada
        */
        this.capacidad = capacidad;
    }
    public void setCantidad(int cantidad) {
        /*
        Entradas:
        cantidad Tipo int

        Funcionamiento:
        Asigna el parametro cantidad a cantidad de la clase

        Salida:
        Nada
        */
        this.cantidad = cantidad;
    }

    public Pikinim(int atk, int cap, int cant) {
        /*
        Entradas:
        atk Tipo int
        cap Tipo int
        cant Tipo int

        Funcionamiento:
        Es el constructor de Pikinim, 
        asigna valor a ataque, capacidad y cantidad

        Salida:
        Nada
        */
        this.ataque = atk;
        this.capacidad = cap;
        this.cantidad = cant;
    }

    public void disminuir(int cantidad){
        /*
        Entradas:
        cantidad Tipo int

        Funcionamiento:
        Le resta cantidad a la cantidad actual del Pikinim

        Salida:
        Nada
        */
        int cant = getCantidad();
        setCantidad(cant-cantidad);
    }

    public abstract void multiplicar(int cantidad);
    /*
        Entradas:
        cantidad Tipo int

        Funcionamiento:
        Funcion tipo abstract

        Salida:
        Nada
        */
}