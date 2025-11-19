package model;

public class Stats {
    private int hp;
    private int atq;
    private int spd;
    private int def;

    public Stats(int hp, int atq, int def, int spd){
        this.hp = hp;
        this.atq = atq;
        this.def = def;
        this.spd = spd;
    }

    public int getHp(){
        return this.hp;
    }
    public int getDef(){
        return this.def;
    }
    public int getAtq(){
        return this.atq;
    }
    public int getSpd(){
        return this.spd;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setDef(int def){
        this.def = def;
    }
    public void setAtq(int atq){
        this.atq = atq;
    }
    public void setSpd(int spd){
        this.spd = spd;
    }
}
