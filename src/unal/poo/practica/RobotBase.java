//estudiante.move ();
//estudiante.turnLeft();
//estudiante.countThingsInBackpack();
//boolean puedeTomar = estudiante.canPickThing();
//estudiante.putThing();
//estudiante.frontIsClear();
//creacionFuncion(4);
//estudiante.pickThing();
package unal.poo.practica;

import becker.robots.*;
import static unal.poo.practica.RobotBase.estudiante;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        public static void turnRight(){
            for(int i = 0 ; i < 3 ; i++) estudiante.turnLeft() ;
            return ;
        }
        
        public static void movePick(int n){
            for ( int i = 0 ; i < n ; i++ ){
                estudiante.move() ;
                while (estudiante.canPickThing()) estudiante.pickThing() ; 
            }
            return ;
        }
        public static void movePut(int n){
            for ( int i = 0 ; i < n ; i++ ){
                if (estudiante.countThingsInBackpack() > 0 ) estudiante.putThing() ;
                estudiante.move() ;
            }
            return ;
        }
        public static void move(int n){
            for ( int i = 0 ; i < n ; i++ ){
                estudiante.move() ;
            }
            return ;
        }
        
        public static void turn180(){
            for ( int i = 0 ; i < 2 ; i++ ) estudiante.turnLeft() ;
            return ;
        }
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,0, 1, Direction.SOUTH,0);
            movePick(4) ;
            estudiante.turnLeft() ;
            int[] histo = {3, 4, 1, 2} ;
            for ( int  i = 0 ; i < 4 ; i++ ){
                movePut(histo[i]) ;
                turn180() ;
                move(histo[i]) ;
                if( i < 3 ){
                    turnRight() ;
                    estudiante.move() ;
                    turnRight() ;
                }
                else{
                    estudiante.turnLeft();
                    move(4) ;
                }
            }
            
                /*for ( int j = 5 ; j > 0 ; j-- ){
                    for ( int n = 0 ; n < j ; n++ ){
                        estudiante.move() ;
                        if(estudiante.canPickThing())estudiante.pickThing();
                    }
                    turnRight() ;
                    for ( int n = 0 ; n < j ; n++ ){
                        estudiante.move() ;
                        if(estudiante.canPickThing())estudiante.pickThing();
                    }
                    turnRight() ;
                }
            */
            /*turnRight() ;
            for ( int i = 0 ; i < 2 ; i++ ){
            estudiante.move() ;
            estudiante.turnLeft();
            }
            estudiante.move() ;
            estudiante.pickThing();
            for ( int i = 0 ; i < 2 ; i++ ) estudiante.turnLeft();
            for(int i = 0 ; i < 3 ; i++ ){
                estudiante.move();
                turnRight() ;
            }*/
            /*for (int i = 0 ; i < 2 ; i++) estudiante.turnLeft();
            estudiante.move();
            for ( int n = 0 ; n < 4 ; n++ ){
            turnRight() ;
            for( int i = 0 ; i < 3 ; i++ ) estudiante.move();
            }
            for (int i = 0 ; i < 2 ; i++) estudiante.turnLeft();
            estudiante.move() ;*/
        }
}

