package unal.poo.practica;

import becker.robots.* ;
import static unal.poo.practica.Robot4.estudiante ;

public class Robot4 {
    public static City objetos ;
    public static Robot estudiante ;
    
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
        objetos = new City("Field4.txt") ;
        objetos.showThingCounts(true);
        
        estudiante = new Robot(objetos,0, 1, Direction.SOUTH,0);
            movePick(4) ;
            estudiante.turnLeft() ;
            move(1) ;
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
                    move(1) ;
                    estudiante.turnLeft();
                    movePut(4) ;
                }
            }
    }
}
