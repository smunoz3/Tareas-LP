public class Muralla extends Zona{
    public int vida;
    
    public int getVida() {
        /*
        Entradas:
        Nada
        Funcionamiento:
        Retorna la variable vida
        Salida:
        vida Tipo int
        */
        return vida;
    }

    public void setVida(int vida){
        /*
        Entradas:
        vida Tipo int

        Funcionamiento:
        Asigna el parametro vida a vida de la clase

        Salida:
        Nada
        */
        this.vida = vida;
    }

    public Muralla(boolean completada, int vida){
        /*
        Entradas:
        completada Tipo bolean
        vida Tipo int

        Funcionamiento:
        Es el constructor de Muralla, llama al constructor de Zona 
        y le asigna valores a vida

        Salida:
        Nada
        */
        super(completada);
        this.vida = vida;
    }

    @Override
    public void interactuar(Pikinim cyan,Pikinim magenta, Pikinim amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Comprueba si la zona esta completada, si no lo llama a la funcion tryromper 
        y si esta retorna true llama a setCompletada para colocar la zona como completada
        si tryromper retorna false muestra el daño que hiciste y la vida que le queda a la muralla
        si la zona esta completada se imprime un mensaje indicandolo

        Salida:
        Nada
        */
        if (!getCompletada()){
            int vidaActual = getVida();
            if (TryRomper(cyan, magenta, amarillo)){
                setCompletada(true);
            }
            if (getCompletada()){
                System.out.println("Rompiste la muralla\n");
            }
            else{
                System.out.println("A la muralla le hiciste: "+(vidaActual - getVida())+" de daño");
                System.out.println("A la muralla le queda: "+getVida()+" de vida\n");
            }
        }
        else{
            System.out.println("No queda nada que hacer aqui\n");
        }
    }

    public boolean TryRomper(Pikinim cyan,Pikinim magenta, Pikinim amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Le resta la suma de los ataques de los pikinim a la vida de la muralla 
        luego comprueba si la vida llego a 0 o menos

        Salida:
        true si vida es 0 o menos, false si vida es mayor a 0
        */
        setVida(getVida() - (cyan.getCantidad() * cyan.getAtaque())- (magenta.getCantidad() * magenta.getAtaque())- (amarillo.getCantidad() * amarillo.getAtaque()));
        if (getVida() <= 0){
            return true;
        }
        else{
            return false;
        }
    }
}