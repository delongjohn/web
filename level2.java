public class level{
    public static void main(String[] args) {
        people a = new people(2, "jack ma", 30);
        a.hello();
        if (a.make_money(1000000)) a.hello();
        dog b = new dog(4, "旺财", 200);
        b.hello();
        b.make_money(a);
    }
}

abstract class animal{
    private int legs;
    public void setLegs(int n){
        this.legs = n;
    }
    public int getLegs(){
        return this.legs;
    }

    private String name;
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return this.name;
    }

    protected int money;
    abstract setMoney();
    public int getMoney(){
        return this.money;
    }

    abstract hello();
    abstract make_money();
}

class people extends animal{
    boolean is_rich;
    public void hello(){
        String t = is_rich ? "rich" : "poor";
        System.out.println("I am " + t);
        System.out.println("my name is " + this.getName());
    }
    public boolean make_money(int n){
        if (this.getName().equals("jack ma")) {
            this.setMoney(n);
            return true;
        }
        else {
            this.setMoney(0);
            return false;
        }
    }
    public void setMoney(int n){
        this.money = n;
        if (n > 10000) this.is_rich = true;
    }
    people(int leg, String name, int m){
        setLegs(leg);
        setName(name);
        setMoney(m);
    }
}

class dog extends animal{
    boolean is_die = false;
    public void hello(){
        System.out.println("汪汪汪汪");
    }
    public void make_money(people who){
        who.make_money(100);
        System.out.println("你的狗被卖掉,你得到100元");
        this.is_die = true;
    }
    public void setMoney(){
        this.money = 0;
    }
    dog(int leg, String n, int m){
        setLegs(leg);
        setMoney();
        setName(n);
    }
}

class fly extends animal{
    public void hello(){
        System.out.println("飞来飞去");
    }
    public void make_money(){}
    public void setMoney(){}
}