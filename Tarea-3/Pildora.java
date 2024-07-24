import java.util.Scanner;

public class Pildora extends Zona{
    private int cantidad;
    private Scanner scanner;

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

    public void setCantidad(int cantidad){
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

    public Pildora(boolean completada, int cantidad, Scanner scanner){
        /*
        Entradas:
        completada Tipo bolean
        cantidad Tipo int
        scanner Tipo Scanner

        Funcionamiento:
        Es el constructor de Pildora, llama al constructor de Zona 
        y le asigna valores a cantidad y a scanner

        Salida:
        Nada
        */
        super(completada);
        this.cantidad = cantidad;
        this.scanner = scanner;
    }

    @Override
    public void interactuar(Pikinim cyan,Pikinim magenta, Pikinim amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Comprueba si la zona esta completada, si no lo esta pregunta al usuario el color del Pikinim que quiera multiplicar
        y se llama a multiplicar del color que elija el usuario para despues marcar la zona como completada
        si la zona esta completada se imprime un mensaje indicandolo

        Salida:
        Nada
        */
        if (!getCompletada()){
            System.out.print("Qué color de pikinim desea que se multiplique? (cantidad a multiplicar: "+getCantidad()+")\n");
            System.out.print("1.Cyan  2.Magenta  3.Amarillo\n");
            int color = scanner.nextInt();

            if (color ==1){
                cyan.multiplicar(getCantidad());
            }
            else if (color ==2){
                magenta.multiplicar(getCantidad());
            }
            else if (color ==3){
                amarillo.multiplicar(getCantidad());
            }
            setCompletada(true);
        }
        else{
            System.out.println("No queda nada que hacer aqui\n");
        }
    }
}