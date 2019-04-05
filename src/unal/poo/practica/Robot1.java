package unal.poo.practica;

import becker.robots.*;
import static unal.poo.practica.Robot1.estudiante ;

public class Robot1 {
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
    
    public static void main( String[] args ){
        objetos = new City("Field1.txt") ;
        objetos.showThingCounts(true) ;
        
        estudiante = new Robot (objetos, 0, 2, Direction.WEST, 0) ;
        
        turn180() ;
        estudiante.move();
        for ( int n = 0 ; n < 4 ; n++ ){
            turnRight() ;
            for( int i = 0 ; i < 3 ; i++ ) estudiante.move();
        }
        for (int i = 0 ; i < 2 ; i++) estudiante.turnLeft();
        estudiante.move() ;
    }
}
