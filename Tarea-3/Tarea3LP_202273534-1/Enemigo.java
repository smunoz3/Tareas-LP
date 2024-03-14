import java.util.Scanner;

public class Enemigo extends Zona implements ILevantar{
    private int vida;
    private int peso;
    private int ataque;
    private Scanner scanner;

    public int getVida(){
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
    public int getPeso(){
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
    public int getAtaque(){
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
    public void setPeso(int peso){
        /*
        Entradas:
        peso Tipo int

        Funcionamiento:
        asigna el parametro peso a peso de la clase

        Salida:
        Nada
        */
        this.peso = peso;
    }
    public void setAtaque(int ataque){
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

    public Enemigo(boolean completada,int vida,int peso,int ataque, Scanner scanner){
        /*
        Entradas:
        completada Tipo bolean
        vida Tipo int
        peso Tipo int
        ataque Tipo int
        scanner Tipo Scanner

        Funcionamiento:
        Es el constructor de Enemigo, llama al constructor de Zona 
        y le asigna valores a vida, peso, ataque y a scanner

        Salida:
        Nada
        */
        super(completada);
        this.vida = vida;
        this.peso = peso;
        this.ataque = ataque;
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
        Comprueba si la zona esta completada, si no lo llama a la funcion pelear
        si la zona esta completada se imprime un mensaje indicandolo

        Salida:
        Nada
        */
        if(!getCompletada()){
            System.out.println("Peleas contra un enemigo");
            Pelear(cyan, magenta, amarillo);
        }
        else{
            System.out.println("No queda nada que hacer aqui\n");
        }
    }

    public boolean Pelear(Pikinim cyan,Pikinim magenta, Pikinim amarillo){
        /*
        Entradas:
        cyan Tipo Piknim
        magenta Tipo Piknim
        amarillo Tipo Piknim

        Funcionamiento:
        Le resta el ataque de todos los pikinim a la vida del enemigo, luego el enemigo ataca a los pikinim
        si el enemigo fue derrotado se llama a la funcion levantar y marca la zona como completada 
        si no lo derrota se indica por pantalla

        Salida:
        true si lo derrota, false si no lo derrota
        */
        int cyanAtaque = cyan.getCantidad() * cyan.getAtaque();
        int magentaAtaque = magenta.getCantidad() * magenta.getAtaque();
        int amarilloAtaque = amarillo.getCantidad() * amarillo.getAtaque();
        int pikinimCaidos;
        setVida((getVida()-cyanAtaque-magentaAtaque-amarilloAtaque));

        System.out.println("Le hiciste: "+(cyanAtaque+magentaAtaque+amarilloAtaque)+" de daño");

        while(true){
            double random = Math.random();
            int piknimAfectado = (int) (random * 3) + 1;
            if ((piknimAfectado == 1)&&(cyan.getCantidad()!=0)){
                pikinimCaidos = (cyan.getCantidad()>getAtaque())? getAtaque():cyan.getCantidad();
                System.out.println("Pikinims caidos en combate: "+pikinimCaidos+" cyan");
                if(cyan.getCantidad()-getAtaque() <0){
                    cyan.setCantidad(0);
                    break;
                }
                else{
                    cyan.setCantidad(cyan.getCantidad()-getAtaque());
                    break;
                }
            }
            else if ((piknimAfectado == 2)&&(magenta.getCantidad()!=0)){
                System.out.println("Pikinims caidos en combate: "+getAtaque()+" magenta");
                if(magenta.getCantidad()-getAtaque() <0){
                    magenta.setCantidad(0);
                    break;
                }
                else{
                    magenta.setCantidad(magenta.getCantidad()-getAtaque());
                    break;
                }
            }
            else if ((piknimAfectado == 3)&&(amarillo.getCantidad()!=0)){
                System.out.println("Pikinims caidos en combate: "+getAtaque()+" amarillo");
                if(amarillo.getCantidad()-getAtaque() <0){
                    amarillo.setCantidad(0);
                    break;
                }
                else{
                    amarillo.setCantidad(amarillo.getCantidad()-getAtaque());
                    break;
                }
            }
            else if ((cyan.getCantidad()<=0)&&(magenta.getCantidad()<=0)&&(amarillo.getCantidad()<=0)){
                break;
            }
        }
        if (getVida()<=0){
            System.out.println("Derrotaste al enemigo\n");
            setVida(0);
            Levantar(cyan, magenta, amarillo);
            setCompletada(true);
            return true;
        }
        else{
            System.out.println("El enemigo sigue con vida");
            System.out.println("Le queda: "+getVida()+" de vida\n");
            return false;
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
        Comprueba si la capacidad de los pikinim es al menos el peso del enemigo si es asi le pregunta al usuario
        que pikinim quiere multiplicar y se llama a multiplicar del pikinim elegido
        
        Salida:
        Nada
        */
        int cyanFuerza = cyan.getCantidad() * cyan.getCapacidad();
        int magentaFuerza = magenta.getCantidad() * magenta.getCapacidad();
        int amarilloFuerza = amarillo.getCantidad() * amarillo.getCapacidad();

        if (getPeso()<=(cyanFuerza+magentaFuerza+amarilloFuerza)){
            System.out.print("Qué color de pikinim desea que se multiplique? (cantidad a multiplicar: "+getPeso()+")\n");
            System.out.print("1.Cyan  2.Magenta  3.Amarillo\n");
            int color = scanner.nextInt();

            if (color ==1){
                cyan.multiplicar(getPeso());
            }
            else if (color ==2){
                magenta.multiplicar(getPeso());
            }
            else if (color ==3){
                amarillo.multiplicar(getPeso());
            }
        }
    }
}