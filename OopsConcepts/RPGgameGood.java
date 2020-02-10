import java.io.*;
import java.util.*;
class HeroGood {
    private String name;
    private int health;
    private int attack;
    private int defense;
    HeroGood(String name,int health,int attack,int defense){
        this.name=name;
        this.health=health;
        this.attack=attack;
        this.defense=defense;
    }
    public void attack(Enemy enemy){
        enemy.defend();
    }
    public void showHealth(){
        System.out.println("The present health  of hero is "+health);
    }
        
}
abstract class Enemy{
    protected int health;
    protected int attack;
    protected int defense;
    protected boolean isClever;
    Enemy(int health,int attack,int defense,boolean isClever){
        this.health=health;
        this.attack=attack;
        this.defense=defense;
        this.isClever=isClever;
    }
    public abstract void defend();
}
class NormalEnemyGood extends Enemy{
    NormalEnemyGood(int health,int attack,int defense,boolean isClever)
    {
        super(health,attack,defense,isClever);
    }
    public void defend()
    {
        this.health-=10;
    }
    public void showHealth(){
        System.out.println("The present health of normal enemy is "+this.health);
    }
}
class StrongEnemyGood extends Enemy{
    StrongEnemyGood(int health,int attack,int defense,boolean isClever)
    {
        super(health,attack,defense,isClever);
    }
    public void defend()
    {
        this.health-=5;
    }
    public void showHealth(){
        System.out.println("The present health of strong enemy is "+this.health);
    }
}
public class RPGgameGood{
    void main(){
        HeroGood spiderman=new HeroGood("Spiderman",100,80,60);
        NormalEnemyGood normalEnemy=new NormalEnemyGood(100,50,30,false);
        StrongEnemyGood strongEnemy=new StrongEnemyGood(200,100,80,true);
        normalEnemy.showHealth();
        strongEnemy.showHealth();
        spiderman.attack(normalEnemy);
        spiderman.attack(strongEnemy);
        spiderman.attack(normalEnemy);
        spiderman.attack(strongEnemy);
        normalEnemy.showHealth();
        strongEnemy.showHealth();
    }
}


