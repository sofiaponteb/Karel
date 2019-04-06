package unal.poo.practica;

import becker.robots.* ;
import static unal.poo.practica.Robot5.estudiante ;

public class Robot5 {
    
    public static City objetos ;
    public static Robot estudiante ;
    public static int x = 9, y = 1 ;
    
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
    
    public static void find(){
        //boolean flag = false ;
        for ( int i = 0 ; i < 5 ; i++ ){
            for ( int j = 9 ; j > 4 ; j-- ){
                System.out.println(estudiante.canPickThing() + "\n");
                if (estudiante.canPickThing() == true ){
                    while (estudiante.canPickThing())estudiante.pickThing() ;
                    x = estudiante.getAvenue() ;
                    y = estudiante.getStreet() ;
                    estudiante.turnLeft() ;
                    move(x-1) ;
                    estudiante.turnLeft();
                    move(10-y) ;
                    //turn180() ;
                    //turn180() ;
                    return ;
                }
                if( j > 5 ) estudiante.move() ;
            }
            turn180() ;
            move(4) ;
            if(i < 4){
                estudiante.turnLeft();
                estudiante.move() ;
                estudiante.turnLeft() ;
            }
            else{
                x = 0 ;
                y = 0 ;
                turnRight() ;
                move(4) ;
                estudiante.turnLeft() ;
                estudiante.move() ;
                estudiante.turnLeft() ;
                move(7) ;
                estudiante.turnLeft() ;
                move(3) ;
            }
        }
    }
    
    public static void Go(){
        estudiante.turnLeft() ;
        move(6) ;
        estudiante.turnLeft() ;
        move(4) ;
        move(9-y) ;
        turnRight() ;
        move(x-1) ;
        int c = estudiante.countThingsInBackpack() ;
        for ( int i = 0 ; i < c ; i++ ) estudiante.putThing();
        turn180() ;
        move(x-1) ;
        estudiante.turnLeft() ;
        move(9-y) ;
        move(4) ;
        turnRight() ;
        move(6) ;
        turnRight() ;
        move(1) ;
    }
    
    public static void main(String[] arg){
        objetos = new City("Field5.txt") ;
        objetos.showThingCounts(true);
        
        estudiante = new Robot(objetos, 10, 1, Direction.NORTH, 0) ;
        
        estudiante.move() ;
        while ( x != 0 && y != 0 ){
            find() ;
            System.out.println("SALIO\n");
            if(x == 0 || y == 0){
                return ;
            }
            Go() ;
        }
        
    }
    
}
