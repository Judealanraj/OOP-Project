public class Marshland extends Home_ground{
    public Marshland(Player p){
        this.name = "Marshland";
        for(Army i: p.Army_collection){
            if(i.get_name() == "Squire" || i.get_name() == "Swiftblade" || i.get_name() == "Warlock" || i.get_name() == "Alchemist" || i.get_name() == "Basilisk" || i.get_name() == "Hydra" ){
                i.set_defence(i.get_defence()+2);
            }
            if(i.get_name() == "Sunfire" || i.get_name() == "Zing" || i.get_name() == "Templar" || i.get_name() == "Soother" || i.get_name() == "Dragon" || i.get_name() == "Lightbringer" || i.get_name() == "Phoenix" ){
                i.set_attack(i.get_attack()-1);
            }
            if(i.get_name() == "Saggitarius" || i.get_name() == "Illusionist" || i.get_name() == "Eldritch" || i.get_name() == "Saint" || i.get_name() == "Pegasus" ){
                i.set_speed(i.get_speed()-1);
            }
        }
    }
}
