package unal.poo.practica;

import becker.robots.* ;
import static unal.poo.practica.Robot3.estudiante ;

public class Robot3 {
    
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
        objetos = new City("Field3.txt") ;
        objetos.showThingCounts(true);
        
        estudiante = new Robot (objetos, 1, 0, Direction.EAST, 0) ;
        
        for ( int j = 5 ; j > 0 ; j-- ){
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
    }
}
