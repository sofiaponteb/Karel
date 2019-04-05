package unal.poo.practica;

import becker.robots.* ;
import static unal.poo.practica.Robot2.estudiante ;

public class Robot2 {
    
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
        objetos = new City ("Field2.txt") ;
        objetos.showThingCounts(true) ;
        
        estudiante = new Robot(objetos, 1, 2, Direction.SOUTH, 0) ;
        
        turnRight() ;
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
        }
    }
    
}
