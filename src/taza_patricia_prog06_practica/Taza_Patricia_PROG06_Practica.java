/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taza_patricia_prog06_practica;

import java.util.Random;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author madrid
 */
public class Taza_Patricia_PROG06_Practica {

    /**
     * @param args the command line arguments
     */
    
    /**
     * En esta función vamos a generar la operación matemática que será la pregunta 
     * para cada jugador 
     */
    public static String generadorOperacion (){
        int nEnteros = (int) (Math.random()* 4 + 4 ); //solo se usa una vez
        String expresion = "", signo;
        //este va fuera del bucle para poder controlar que no haya problemas a la hora de colocar los numeros y signos
        int nValores = (int) (Math.random()* 12 + 2 );
//        System.out.print(nValores); -> prueba para ver si funciona el math.random
        expresion = expresion + Integer.toString(nValores);
        
         for(int i = 0;  i < nEnteros; i++){
            int signoR = (int) (Math.random()* 3 + 1);
            switch(signoR){
                case 1:
                    signo = " + ";
//                    System.out.print(signo);
                    expresion = expresion + signo;
                    break;
                case 2:
                    signo = " - ";
//                    System.out.print(signo);
                    expresion = expresion + signo;
                    break;
                case 3:
                    signo = " * ";
//                    System.out.print(signo);
                    expresion = expresion + signo;
                    break;
                default:
                    i--;
                    break;
            } //fin caso switch
            nValores = (int) (Math.random()* 12 + 2 );
//            System.out.print(nValores);
            expresion = expresion + Integer.toString(nValores); //gaurdanos la expresion en un String 
            //y este será lo que se envie a la pantalla de cada jugador
            
        }   return expresion;
    } 
    
    /**
     * Esta función recoge la función anterior y realiza la operacion matematica
     * gracias a ello podemos comparar el resultado con lo que introduce el jugador/a
     * y escribir el resultado su falla
     */
    public static int evaluarExpresion (String expresion) {
        int valor = 0;
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            Object result = engine.eval(expresion);
            valor = Integer.decode(result.toString());
            
        } catch (Exception e) {
            e.getMessage();
        }
        return valor;
    }
    //FUNCION PRINCIPAL
    
    public static void main(String[] args) {
        
    //Empezamos pidiendo datos 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Este programa simulará un juego de diferentes preguntas"
        + " matemáticas, donde tú decides el número de concursantes con sus "
        + "respectivos nombres, además de elegir la longitud de las rondas.");
        System.out.println("¿Cuantos jugadores serán?");
        int nJugadores = sc.nextInt();
        sc.nextLine(); //<- el nextInt hace que el nextLine haga skip al primer bucle,
        //al parecer el nextint daba error e impedia que el bucle funcionase correctamente
        
        String[][] concursantes = new String[nJugadores][2];
        for(int cero = 0; cero < concursantes.length; cero++){
            concursantes[cero][1] = "0";
        }
        for(int i = 0; i < concursantes.length; i++){
        System.out.println("Dame el nombre del jugador " + (i + 1));
        concursantes[i][0]= sc.nextLine();
        } //fin recogida nombres
        
        System.out.println("¿Cuantas rondas? Tiene que ser entre 3, 5, 10 o 20");
        int nRondas = sc.nextInt();
        
        while(nRondas != 3 && nRondas != 5 && nRondas != 10 && nRondas != 20){
            System.out.println("Número de rondas inválido. Introduce otro número por favor");
            nRondas = sc.nextInt();
        }
        System.out.println("¡Perfecto! Ahora empezamos la ronda");
    //FIN RECOGIDA DE DATOS 
        
    //FUNCION - aletoriedad nombres
      int listSize = concursantes.length;

        // intenté seguir ahí el diagrama de flujo, pero no lograba sacar nada con ello, asi que solo 
        //encontré la manera de lograr esto usando si o si la clase random
        //con 3 nombres a veces termina con las mismas posiciones, mejor probar con 4 o más jugadores
        
        //Nota: solo me ha ocurrido 2 veces en las pruebas, pero a veces imprime en pantalla la lista randomizada y termina el programa
        //para eso mejor reiniciar el juego, es un caso muy raro pero como me ha ocurrido mejor anotarlo
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            //seleccionamos un nombre del array
            String currentElement = concursantes[i][0];
            //generamos un random para saber su nueva posicion
            int randomIndex = i + random.nextInt(listSize - i);
            //reemplazar el nombre nuevo y asi con todos
            concursantes[i][0] = concursantes[randomIndex][0];
            concursantes[randomIndex][0] = currentElement;
        }
//    transcurso rondas
        for(int i = 0; i < nRondas; i++){ //un buxle para controlar las rondas
            System.out.println("Comienza la ronda " + (i +1) + "!");

            for(int j = 0; j < nJugadores; j++){ //y otro para controlar los jugadores
                int puntuacion = 1;
                System.out.println("Pregunta para " + concursantes[j][0]);
                System.out.println("La operación es : " + generadorOperacion()); //llamada a la funcion generadorOperacion
                int resultado = evaluarExpresion(generadorOperacion());
                System.out.println(resultado);
                int respuesta = sc.nextInt();
                if(respuesta == resultado){
                    System.out.println("Es correcto!");
                    //Para sumar los puntos pasamos el string a int para poder sumarlos, y luego el resultado de la suma volver a pasarlo a string
                    concursantes[j][1] = Integer.toString(Integer.parseInt(concursantes[j][1]) + puntuacion); 
                } else {
                    System.out.println("¡Incorrecto! La respuesta era " + resultado);  //llamada a evaluarOperacion
                }   
            } //fin preguntas, fin a una unidad de Ronda
            System.out.println("Fin de la ronda!");
            System.out.println("Ahora se mostrarán los resultados hasta ahora!");
            
            for(int r = 0; r < concursantes.length; r++){ //bucle para mostrar todos los concursantes con sus respectivos nombres y puntos
                System.out.println("Jugador/a: " + concursantes[r][0] + " con " + concursantes[r][1] + " puntos." );
            }
            
        }//FIN PARTIDA
        System.out.println("Fin de la partida!");
            
        String[][] ganador = new String [1][2]; 
        for (int x = 0; x < (concursantes.length -1); x++) { //compara todos los puntos y guardamos el ganador en un nuevo String ganador
			if (Integer.parseInt(concursantes[x][1]) >= Integer.parseInt(concursantes[x+1][1])) {
                            ganador[0][0] = concursantes[x][0];
                            ganador[0][1] = concursantes[x][1];              
                        } else {
                            ganador[0][0] = concursantes[x+1][0];
                            ganador[0][1] = concursantes[x+1][1];
                        }
        }
            System.out.println("El ganador/a es: " + ganador[0][0] + " con " + ganador[0][1] + " puntos." );
            
    }
}