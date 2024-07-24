import java.util.Scanner;

public class Juego{
    private int posicion;
    public static Zona[] arregloDeZonas;

    public int getPoicion(){
        /*
        Entradas:
        Nada

        Funcionamiento:
        Retorna la variable posicion
        
        Salida:
        posicion Tipo int
        */
        return posicion;
    }

    public void setPosicion(int posicion){
        /*
        Entradas:
        posicion Tipo int

        Funcionamiento:
        Asigna el parametro posicion a posicion de la clase

        Salida:
        Nada
        */
        this.posicion = posicion;
    }

    public void moverse(int p){ 
        /*
        Entradas:
        p Tipo int

        Funcionamiento:
        Asigna la posicion en p

        Salida:
        Nada
        */
       setPosicion(p);
    }
    
    public static void main(String[] args) {
        int n = 11;
        Zona[] arregloDeZonas = new Zona[n];
        Scanner scanner = new Scanner(System.in);

        arregloDeZonas[0] = new Pieza(false,50);
        arregloDeZonas[1] = new Enemigo(false,130,20,25,scanner);
        arregloDeZonas[2] = new Enemigo(false,50,10,15,scanner);
        arregloDeZonas[3] = new Pildora(false,25,scanner);
        arregloDeZonas[4] = new Muralla(false, 50);
        arregloDeZonas[5] = new Pieza(false,100);
        arregloDeZonas[6] = new Enemigo(false,45,8,10,scanner);
        arregloDeZonas[7] = new Pieza(false,35);
        arregloDeZonas[8] = new Pildora(false,15,scanner);
        arregloDeZonas[9] = new Enemigo(false,75,15,20,scanner);
        arregloDeZonas[10] = new Muralla(false,150);

        Juego Game = new Juego();
        Game.setPosicion(5);

        Cyan P_Cyan = new Cyan(10);
        Amarillo P_Amarillo = new Amarillo(10);
        Magenta P_Magenta = new Magenta(10);

        int turno = 1;
        int cantidadPiezas =0;
        boolean bandera = false;
        int derecha,izquierda;
        String situacion1,situacion2;
        String movAnterior = "nada";
        
        System.out.println("Mal Aterrizaje");
        System.out.println("Has caido en un planeta extraño");
        System.out.println("Tienes que recuperar las piezas de la nave para poder regresar a casa");
        System.out.println("Unas criatudas llamadas Pikinim del planata te ayudaran con esta tarea");
        System.out.println("Tienes que ser rapido el oxigeno no durara más de 30 horas\n");
        while((turno<=30)&&(cantidadPiezas<3)){
            System.out.println("===============================================================");
            System.out.println("Turno "+ turno + " (Cyan - "+P_Cyan.getCantidad()+", Magenta - "+P_Magenta.getCantidad()+", Amarillo - "+P_Amarillo.getCantidad()+") Cantidad de piezas: "+cantidadPiezas+"/3");
            Class<?> clase = arregloDeZonas[Game.getPoicion()].getClass();
            System.out.println("Zona actal: "+clase.getName());
            System.out.println("Opciones: ");

            derecha = ((Game.getPoicion()+1)>=n)? 0:Game.getPoicion()+1;
            izquierda = ((Game.getPoicion()-1)<0)? (n-1):Game.getPoicion()-1;
            
            Class<?> claseD = arregloDeZonas[derecha].getClass();
            Class<?> claseI = arregloDeZonas[izquierda].getClass();
            Class<?> claseActual = arregloDeZonas[Game.getPoicion()].getClass();

            if((claseActual.getName() == "Muralla") &&(movAnterior == "izquierda")&&(!arregloDeZonas[Game.getPoicion()].getCompletada())){
                situacion1 = (arregloDeZonas[derecha].getCompletada())? "Completada":"No completada";
                System.out.print("1. Ir a derecha "+claseD.getName()+" ("+situacion1+") 2. No puedes ir hacia la izquierda 3. Quedarse aquí 4. Información\n");
            }
            else if((claseActual.getName() == "Muralla") &&(movAnterior == "derecha")&&(!arregloDeZonas[Game.getPoicion()].getCompletada())){
                situacion2 = (arregloDeZonas[izquierda].getCompletada())? "Completada":"No completada";
                System.out.print("1. No puedes ir a la derecha 2. Ir a la izquierda "+claseI.getName()+" ("+situacion2+") 3. Quedarse aquí 4. Información\n");
            }
            else{
                situacion1 = (arregloDeZonas[derecha].getCompletada())? "Completada":"No completada";
                situacion2 = (arregloDeZonas[izquierda].getCompletada())? "Completada":"No completada";
                System.out.print("1. Ir a derecha "+claseD.getName()+" ("+situacion1+") 2. Ir a la izquierda "+claseI.getName()+" ("+situacion2+") 3. Quedarse aquí 4. Información\n");
            }

            int movimiento = scanner.nextInt();

            if (movimiento == 1){
                if ((claseActual.getName()== "Muralla")&&(!arregloDeZonas[Game.getPoicion()].getCompletada())&&(movAnterior == "derecha")){
                    System.out.println("===============================================================");
                    System.out.println("Muralla no derribada");
                }
                else{
                    Game.moverse(derecha);
                    movAnterior = "derecha";
                    System.out.println("Te moviste hacia la derecha");
                    System.out.println("===============================================================\n");

                    if (claseD.getName()== "Pieza"){
                        bandera = arregloDeZonas[Game.getPoicion()].completada;
                        arregloDeZonas[Game.getPoicion()].interactuar(P_Cyan, P_Magenta, P_Amarillo);
                        if ((arregloDeZonas[Game.getPoicion()].completada) && (!bandera)){
                            cantidadPiezas = cantidadPiezas +1;
                            System.out.println("Recogiste 1 pieza\n");
                        }
                    } 
                    else{
                        arregloDeZonas[Game.getPoicion()].interactuar(P_Cyan, P_Magenta, P_Amarillo);
                    }
                    turno = turno +1;
                }
            }
            else if (movimiento == 2){
                if ((claseActual.getName()== "Muralla")&&(!arregloDeZonas[Game.getPoicion()].getCompletada())&&(movAnterior == "izquierda")){
                    System.out.println("===============================================================");
                    System.out.println("Muralla no derribada");
                }
                else{ 
                    Game.moverse(izquierda);
                    movAnterior = "izquierda";
                    System.out.println("Te moviste hacia la izquierda");
                    System.out.println("===============================================================\n");

                    if (claseI.getName()== "Pieza"){
                        bandera = arregloDeZonas[Game.getPoicion()].completada;
                        arregloDeZonas[Game.getPoicion()].interactuar(P_Cyan, P_Magenta, P_Amarillo);
                        if ((arregloDeZonas[Game.getPoicion()].completada) && (!bandera)){
                            cantidadPiezas = cantidadPiezas +1;
                            System.out.println("Recogiste 1 pieza\n");
                        }
                    } 
                    else{
                        arregloDeZonas[Game.getPoicion()].interactuar(P_Cyan, P_Magenta, P_Amarillo);
                    }
                    turno = turno +1;
                }
            }
            else if (movimiento == 3){
                System.out.println("Te quedaste en el sitio");
                System.out.println("===============================================================\n");
                arregloDeZonas[Game.getPoicion()].interactuar(P_Cyan, P_Magenta, P_Amarillo);
                turno = turno +1;
            }
            else if (movimiento ==4){
                System.out.println("Pikinim Cyan tienes: "+P_Cyan.getCantidad()+" cada uno carga: "+P_Cyan.getCapacidad()+" y cada uno tiene una fuerza de:"+P_Cyan.getAtaque());
                System.out.println("Pikinim Magenta tienes: "+P_Magenta.getCantidad()+" cada uno carga: "+P_Magenta.getCapacidad()+" y cada uno tiene una fuerza de:"+P_Magenta.getAtaque());
                System.out.println("Pikinim Amarillo tienes: "+P_Amarillo.getCantidad()+" cada uno carga: "+P_Amarillo.getCapacidad()+" y cada uno tiene una fuerza de:"+P_Amarillo.getAtaque()+"\n");
            }

            if ((P_Cyan.getCantidad()==0)&&(P_Magenta.getCantidad()==0)&&(P_Amarillo.getCantidad()==0)){
                System.out.println("Todos los Pikimin calleron en combate");
                System.out.println("El enemigo se acercan a ti y te derriba de un golpe");
                System.out.println("Moribundo ves la masacre ocurrida");
                System.out.println("Te lamentas de las deciciones que tomaste mientras el enemigo se acerca .....");
                System.out.println("==============================Fin==============================");
                break;
            }
        }
        scanner.close();
        if (cantidadPiezas == 3){
            System.out.println("Te has salvado");
            System.out.println("Gracias a esas criaturas pudiste reparar la nave");
            System.out.println("Ahora puedes volver a casa a jugar Lol");
            System.out.println("==============================Fin==============================");
        }
        else if(turno>30){
            System.out.println("Te empieza a faltar el oxigeno");
            System.out.println("Los Pikinim que te acompañaron durante el viaje se acercan preocupados intentando ayudarte");
            System.out.println("Lamentablemente no pueden hacer nada");
            System.out.println("Cierras los ojos .......");
            System.out.println("==============================Fin==============================");
        }
    }
}
