package unal.poo.practica;

import becker.robots.* ;
import static unal.poo.practica.Robot5.estudiante ;

public class Robot5 {
    
    public static City objetos ;
    public static Robot estudiante ;
    public int x, y ;
    
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
    
    /*public static int find(){
        for ( int i = 0 ; i < 4  ; i++ ){
            for ( int j = 9 ; j > 4 ; j-- ){
                if (estudiante.canPickThing() == true ){
                    estudiante.pickThing() ;
                    //return (int avenue(), int street()) ;
                }
                else if(estudiante.frontIsClear() == true){
                   estudiante.move() ;
                }
                else{
                    turn180() ;
                    move(4) ;
                }
            }
        }
    }*/
    
    public static void main(String[] arg){
        objetos = new City("Field5.txt") ;
        objetos.showThingCounts(true);
        
        estudiante = new Robot(objetos, 10, 1, Direction.NORTH, 0) ;
        estudiante.move() ;
        //find() ;
    }
    
}
