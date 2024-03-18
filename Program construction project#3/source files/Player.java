import java.util.*;
public class Player {

    private String name;
    private String user_name;
    private int user_ID ;
    private int player_value=500;
    private int coins = 500;
    private int XP_level = 10;
    private static int self_object_count=1;
    private Home_ground home_ground = null;
    private static ArrayList<String> user_name_collection = new ArrayList<String>();

    private Archers Archer = null;
    private Knights Knight = null;
    private Mages  Mage = null;
    private Healers Healer = null;
    private Mythical_Creatures Mythical_Creature = null;

    private int Archer_count = 0;
    private int Knight_count = 0;
    private int Mage_count = 0;
    private int Healer_count = 0;
    private int Mythical_Creature_count = 0;

    public  ArrayList<Army> Army_collection = new ArrayList<Army>();
    public ArrayList<Army> change_army_collection(Player p){
        ArrayList<Army> Army_collection = new ArrayList<Army>();
        if(p.Archer_count == 1){
            Army_collection.add(p.Archer);
        }
        if(p.Knight_count == 1){
            Army_collection.add(p.Knight);
        }
        if(Mage_count == 1){
            Army_collection.add(p.Mage);
        }
        if(Healer_count == 1){
            Army_collection.add(p.Healer);
        }
        if(Mythical_Creature_count == 1){
            Army_collection.add(p.Mythical_Creature);
        }
        return Army_collection;
    }

    public  ArrayList<Integer> speeds_of_characters = new ArrayList<Integer>();
    public void current_speeds_of_characters(Player p){
        ArrayList<Integer> speeds_of_characters = new ArrayList<Integer>();
        if(p.Archer_count == 1){
            speeds_of_characters.add(p.Archer.get_speed());
        }
        if(p.Knight_count == 1){
            speeds_of_characters.add(p.Knight.get_speed());
        }
        if(Mage_count == 1){
            speeds_of_characters.add(p.Mage.get_speed());
        }
        if(Healer_count == 1){
            speeds_of_characters.add(p.Healer.get_speed());
        }
        if(Mythical_Creature_count == 1){
            speeds_of_characters.add(p.Mythical_Creature.get_speed());
        }
        p.speeds_of_characters = speeds_of_characters;

    }

    public  ArrayList<Integer> defence_of_characters = new ArrayList<Integer>();
    public void current_defence_of_characters(Player p){
        ArrayList<Integer> defence_of_characters = new ArrayList<Integer>();
        if(p.Archer_count == 1){
            defence_of_characters.add(p.Archer.get_defence());
        }
        if(p.Knight_count == 1){
            defence_of_characters.add(p.Knight.get_defence());
        }
        if(Mage_count == 1){
            defence_of_characters.add(p.Mage.get_defence());
        }
        if(Healer_count == 1){
            defence_of_characters.add(p.Healer.get_defence());
        }
        if(Mythical_Creature_count == 1){
            defence_of_characters.add(p.Mythical_Creature.get_defence());
        }
        p.defence_of_characters = defence_of_characters;

    }
    public  ArrayList<Integer> health_of_characters = new ArrayList<Integer>();
    public void current_health_of_characters(Player p){
        ArrayList<Integer> health_of_characters = new ArrayList<Integer>();
        if(p.Archer_count == 1){
            health_of_characters.add(p.Archer.get_health());
        }
        if(p.Knight_count == 1){
            health_of_characters.add(p.Knight.get_health());
        }
        if(Mage_count == 1){
            health_of_characters.add(p.Mage.get_health());
        }
        if(Healer_count == 1){
            health_of_characters.add(p.Healer.get_health());
        }
        if(Mythical_Creature_count == 1){
            health_of_characters.add(p.Mythical_Creature.get_health());
        }
        p.health_of_characters = health_of_characters;

    }




/****************************----end of attributes declaration----************************/



    public Player(String name, String user_name) {
        if(user_name_collection.contains(user_name)){
            throw new IllegalArgumentException("This user name already taken");
        }
        else {
            this.name = name;
            this.user_name = user_name;
            this.user_ID = self_object_count;
            self_object_count++;
            user_name_collection.add(user_name);
        }
    }                  // Player class constructor with error throws

    public String get_player_name(){
        return this.name;
    }               // get player name
    public void set_player_name(String name){
        this.name = name;
    }      // set new name to player

    public String get_player_user_name(){
        return this.user_name;
    }     //get player user name
    public int get_user_ID(){
        return this.user_ID;
    }                   //get user ID

    public int get_player_value(){return this.player_value;}
    public void set_player_value(int k){this.player_value = k;}

    public int get_coins(){
        return this.coins;
    }
    public void set_coins(int k){this.coins = k;}

    public int get_xp_level(){return this.XP_level;}
    public void set_xp_level(int k){this.XP_level =k;}

    public Archers get_archer(){return this.Archer;}
    public void set_archer(Archers k){this.Archer = k;}

    public Knights get_knight(){return this.Knight;}
    public void set_knight(Knights k){this.Knight = k;}

    public Mages get_mage(){return this.Mage;}
    public void set_mage(Mages k){this.Mage = k;}

    public Healers get_healer(){return this.Healer;}
    public void set_healer(Healers k){this.Healer = k;}

    public Mythical_Creatures get_mythical_creature(){return this.Mythical_Creature;}
    public void set_mythical_creature(Mythical_Creatures k){this.Mythical_Creature = k;}

    public void Increase_coins(int percentage){
        this.coins += this.coins*percentage/100;
    }
    public void deduct_coins(int percentage){
        if(this.coins > this.coins*percentage/100){
            this.coins -= this.coins*percentage/100;
        }
        else {
            this.coins = 0;
        }
    }

    public void buy_Archer(String Archer_name) throws Exception{
        Archers A = new Archers(null,0,0,0,0,0);
        switch (Archer_name){
            case "Shooter":
                A = new Archers("Shooter",80,11,4,6,9);
                break;
            case "Ranger":
                A = new Archers("Ranger",115,14,5,8,10);
                break;
            case "Sunfire":
                A = new Archers(" Sunfire",160,15,5,7,14) ;
                break;
            case "Zing":
                A = new Archers("Zing",200,1,9,11,14);
                break;
            case "Saggitarius":
                A = new Archers("Saggitarius",230,18,7,12,17);
                break;
            //default:
            //    throw new Exception("Please enter a valid Archer name......");
        }
        if (this.coins < A.get_price()){
            throw new Exception("You Don't have enough coins to buy this....");
        }
        else if(this.Archer_count < 1){
            this.Archer =A;
            this.coins -= A.get_price();
            this.Archer_count++;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new RuntimeException(".....");
        }
    }
    public void buy_Knight(String Knight_name) throws Exception{
        Knights A = new Knights(null,0,0,0,0,0);
        switch (Knight_name){
            case "Squire":
                A = new Knights("Squire",85,8,9,7,8);
                break;
            case "Cavalier":
                A =  new Knights("Cavalier",110,10,12,7,10);
                break;
            case "Templar":
                A =  new Knights("Templar",155,14,1,12,12);
                break;
            case "Zoro":
                A =  new Knights("Zoro",180,17,1,13,14);
                break;
            case "Swiftblade":
                A =new Knights("Swiftblade",250,18,20,17,13);
                break;
            default:
                throw new Exception("Please enter a valid Knight name.......");
        }
        if (this.coins < A.get_price()){
            throw new Exception("You Don't have enough coins to buy this....");
        }
        else if(this.Knight_count < 1){
            this.Knight = A;
            this.coins -= A.get_price();
            this.Knight_count++;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new RuntimeException(".......");
        }
    }
    public void buy_Mage(String Mage_name) throws Exception{
        Mages A = new Mages(null,0,0,0,0,0);
        switch (Mage_name){
            case "Warlock":
                A = new Mages("Warlock",100,12,7,10,12);
                break;
            case "Illusionist":
                A = new Mages("Illusionist",120,13,8,12,14);
                break;
            case "Enchante":
                A = new Mages("Enchante",10,1,10,13,1);
                break;
            case "Conjurer":
                A = new Mages("Conjurer",195,18,15,14,12);
                break;
            case "Eldritch":
                A = new Mages("Eldritch",270,19,17,18,14);
                break;
            default:
                throw new Exception("Please enter a valid Mege name");
        }
        if (this.coins < A.get_price()){
            throw new Exception("You Don't have enough coins to buy this....");
        }
        else if(this.Mage_count < 1){
            this.Mage = A;
            this.coins-= A.get_price();
            this.Mage_count++;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new RuntimeException("...........");
        }
    }
    public void buy_Healer(String Healer_name) throws Exception{
        Healers A = new Healers(null,0,0,0,0,0);
        switch (Healer_name){
            case "Soother":
                A = new Healers("Soother",95,10,8,9,6);
                break;
            case "Medic":
                A = new Healers("Medic",125,12,9,10,7);
                break;
            case "Alchemist":
                A = new Healers("Alchemist",150,13,13,13,13);
                break;
            case "Saint":
                A = new Healers("Saint",200,16,14,17,9);
                break;
            case "Lightbringer":
                A = new Healers("Lightbringer",260,17,15,19,12);
                break;
            default:
                throw new Exception("Please enter a valid Archer name");
        }
        if (this.coins<A.get_price()){
            throw new Exception("You Don't have enough coins to buy this....");
        }
        else if(this.Healer_count < 1){
            this.Healer = A;
            this.coins -= A.get_price();
            this.Healer_count++;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new RuntimeException(".........");
        }
    }
    public void buy_Mythical_creature(String Mythical_Creature_name) throws Exception{
       Mythical_Creatures A = new Mythical_Creatures(null,0,0,0,0,0);
       switch (Mythical_Creature_name){
           case "Dragon":
               A = new Mythical_Creatures("Dragon",120,12,14,15,8);
               break;
           case "Basilisk":
               A = new Mythical_Creatures("Basilisk",15,15,11,10,12);
               break;
           case "Hydra":
               A = new Mythical_Creatures("Hydra",205,12,16,15,11);
               break;
           case "Phoenix":
               A = new Mythical_Creatures("Phoenix",275,17,13,17,19);
               break;
           case "Pegasus":
               A = new Mythical_Creatures("Pegasus",340,14,18,20,20);
               break;
           default:
               throw new Exception("Please enter a valid Mythical creature name");
       }
       if (this.coins<A.get_price()){
           throw new Exception("You Don't have enough coins to buy this....");
       }
        else if(this.Mythical_Creature_count < 1){
            this.Mythical_Creature = A;
            this.coins -= A.get_price();
            this.Mythical_Creature_count++;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new RuntimeException("..........");
        }
    }

    public void sell_Archer(Archers A) throws Exception{
        if(this.Archer != null){
            this.coins+= A.get_price()*0.9;
            this.Archer =null;
            this.Archer_count--;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new Exception("You don't have Archer");
        }
    }
    public void sell_Knight(Knights A) throws Exception{
        if(this.Knight != null){
            this.coins+= A.get_price()*0.9;
            this.Knight =null;
            this.Knight_count--;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new Exception("You don't have Knight");
        }
    }
    public void sell_Mage(Mages A) throws Exception{
        if(this.Mage != null){
            this.coins+= A.get_price()*0.9;
            this.Mage =null;
            this.Mage_count--;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new Exception("You don't have Mage");
        }
    }
    public void sell_Healer(Healers A) throws Exception{
        if(this.Healer != null){
            this.coins+= A.get_price()*0.9;
            this.Healer =null;
            this.Healer_count--;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new Exception("You don't have Healer");
        }
    }
    public void sell_Mythical_Creature(Mythical_Creatures A) throws Exception{
        if(this.Mythical_Creature != null){
            this.coins+= A.get_price()*0.9;
            this.Mythical_Creature =null;
            this.Mythical_Creature_count--;
            this.Army_collection = change_army_collection(this);
        }
        else{
            throw new Exception("You don't have Mythical_Creature");
        }
    }

    public Army highest_speed_character() {
        current_speeds_of_characters(this);
        int max_speed = 0;
        ArrayList<Army> same_speed_army = new ArrayList<Army>();
        Army max_speed_character = new Army(null,0,0,0,0,0) ;
        for(Army i:this.Army_collection){
            if(i.get_speed()>max_speed){
                max_speed = i.get_speed();
                max_speed_character = i;
            }
        }
        for(Army i:this.Army_collection){
            if(i.get_speed()==max_speed){
                same_speed_army.add(i);
            }
        }
        if(same_speed_army.size()==1){
          return max_speed_character;}
        else {
            for(Army i:same_speed_army){
                if(i instanceof Archers){return i;}
            }
            for(Army i:same_speed_army){
                if(i instanceof Knights){return i;}
            }
            for(Army i:same_speed_army){
                if(i instanceof Mythical_Creatures){return i;}
            }
            for(Army i:same_speed_army){
                if(i instanceof Mages){return i;}
            }
            for(Army i:same_speed_army){
                if(i instanceof Healers){return i;}
            }
        }
        return null;
    }
    public Army lowest_defence_character() {
        current_defence_of_characters(this);
        int low_defence = 1000;
        ArrayList<Army> same_defence_army = new ArrayList<Army>();
        Army low_defence_character = new Army(null,0,0,0,0,0) ;
        for(Army i:this.Army_collection){
            if(i.get_defence()<low_defence){
                low_defence = i.get_defence();
                low_defence_character = i;
            }
        }
        for(Army i:this.Army_collection){
            if(i.get_speed()==low_defence){
                same_defence_army.add(i);
            }
        }
        if(same_defence_army.size()==1){
            return low_defence_character;}
        else {
            for(Army i:same_defence_army){
                if(i instanceof Healers){return i;}
            }
            for(Army i:same_defence_army){
                if(i instanceof Mythical_Creatures){return i;}
            }
            for(Army i:same_defence_army){
                if(i instanceof Archers){return i;}
            }
            for(Army i:same_defence_army){
                if(i instanceof Knights){return i;}
            }
            for(Army i:same_defence_army){
                if(i instanceof Mages){return i;}
            }
        }
        return low_defence_character;

    }
    public Army lowest_health_character() {
        current_health_of_characters(this);
        int low_health = 1000;
        Army low_health_character = new Army(null,0,0,0,0,0) ;
        for(Army i:this.Army_collection){
            if(i.get_health()<low_health){
                low_health = i.get_health();
                low_health_character = i;
            }
        }
        return low_health_character;
    }

    public void removeArmy(Army A){
        if(Army_collection.contains(A)){
            Army_collection.remove(A);
        }
    }
    public void select_home_ground(int n){                        //1.hillcrest  2.marshland  3.desert  4.arcane
        switch (n){
            case 1:
                this.home_ground = new Hillcrest(this);
            case 2:
                this.home_ground = new Marshland(this);
            case 3:
                this.home_ground = new Desert(this );
            case 4:
                this.home_ground = new Arcane(this);
        }
    }
    public void show_status(){
        System.out.println("The player name: " + this.name);
        System.out.println("Xp level       : " + this.XP_level);
        System.out.print("Characters are : ");
        for(Army i: this.Army_collection){
            System.out.println(i.get_name());
            System.out.println("                 ");
        }
    }




}