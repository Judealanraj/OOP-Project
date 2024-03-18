public class Army {
    private String name;
    private int price;
    private int attack;
    private int defence;
    private int health;
    private int speed;


    public Army(String name,int price,int attack,int defence, int health,int speed){
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }
    public int get_price(){return this.price;}
    public String get_name(){return this.name;}
    public int get_attack(){return this.attack;}
    public void set_attack(int k){this.attack = k;}
    public int get_defence(){return this.defence;}
    public void set_defence(int k){this.defence = k;}
    public int get_health(){return this.health;}
    public void set_health(int k){this.health = k;}
    public int get_speed(){return this.speed;}
    public void set_speed(int k){this.speed = k;}

}

