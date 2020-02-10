import java.io.*;
import java.util.*;
class Hero {
    private String name;
    private int health;
    private int attack;
    private int defense;
    Hero(String name,int health,int attack,int defense){
        this.name=name;
        this.health=health;
        this.attack=attack;
        this.defense=defense;
    }
    public void attack(NormalEnemy enemy){
        enemy.health-=10;
    }
    public void attack(StrongEnemy enemy){
        enemy.health-=5;
    }
    public void showHealth(){
        System.out.println("The present health  of hero is "+health);
    }
        
}
class NormalEnemy{
     int health;
     int attack;
     int defense;
     boolean isClever=false;
    NormalEnemy(int health,int attack,int defense)
    { 
        this.health=health;
        this.attack=attack;
        this.defense=defense;
    }
    public void showHealth(){
        System.out.println("The present health of normal enemy is "+health);
    }
}
class StrongEnemy{
    int health;
    int attack;
    int defense;
    boolean isClever=true;
    StrongEnemy(int health,int attack,int defense)
    {
        this.health=health;
        this.attack=attack;
        this.defense=defense;
    }
    public void showHealth(){
        System.out.println("The present health of strong enemy is "+health);
    }
}
public class RPGgame{
    void main(){
        Hero spiderman=new Hero("Spiderman",100,1000,200);
        NormalEnemy normalEnemy=new NormalEnemy(100,50,30);
        StrongEnemy strongEnemy=new StrongEnemy(200,100,50);
        normalEnemy.showHealth();
        spiderman.attack(normalEnemy);
        normalEnemy.showHealth();
        strongEnemy.showHealth();
        spiderman.attack(strongEnemy);
        strongEnemy.showHealth();
        
    }
}
    
        