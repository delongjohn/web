package com.cdl.demo;

public class CSGO {
    public static void main(String args[]){
        System.out.println("{");
        gun sy = new gun("usp", "handGun", 700, 81);
        sy.can_be_use();
        System.out.println("}");
    }
}

class gun {
    private int can_use = 4;
    //查看能否被使用
    public void can_be_use(){
        String status = this.can_use == 0 ? "yes" : "no";
        System.out.println("can_use: " + status);
    }
    //费用
    private int cost;
    public void setCost(int cost){
        if (cost > 0) {
            this.cost = cost;
            System.out.println("cost: " + this.cost);
            can_use--;
        }
    }
    public int getCost(){
        return this.cost;
    }
    //类型
    private String type;
    public void setType(String type){
        boolean is_ok = false;
        String types[] = {"handGun", "SMG", "shotgun", "rifle", "machineGun"};
        for (int i = 0; i < 5; i++){
            if (type.equals(types[i])) is_ok = true;
        }
        if (is_ok) {
            this.type = type;
            can_use--;
            System.out.println("type: " + this.type);
        }else {
            line();
            System.out.println("error in setting type, you can use name of types like:");
            for (int n = 0; n < 5; n++){
                System.out.println(types[n]);
            }
            line();
        }
    }
    public String getType(){
        return this.type;
    }
    //枪名
    private String name;
    public void setName(String name){
        this.name = name;
        can_use--;
        System.out.println("name: " + this.name);
    }
    public String getName(){
        return this.name;
    }
    //伤害
    private int hurt;
    public void setHurt(int hurt){
        if (hurt > 0) {
            this.hurt = hurt;
            can_use--;
            System.out.println("hurt: " + this.hurt);
        }
    }
    public int getHurt(){
        return this.hurt;
    }

    public void line(){
        System.out.println("*************************************");
    }
    gun(String name, String type, int cost, int hurt){
        setName(name);
        setType(type);
        setCost(cost);
        setHurt(hurt);
    }
}

