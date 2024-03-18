import java.util.ArrayList;

public class Hillcrest extends Home_ground{
    public Hillcrest(Player p){
        this.name = "Hillcrest";
        for(Army i: p.Army_collection){
            if(i.get_name() == "Shooter" || i.get_name() == "Ranger" || i.get_name() == "Cavalier" || i.get_name() == "Zoro" || i.get_name() == "Conjurer" || i.get_name() == "Medic"){
                i.set_attack(i.get_attack()+1);
                i.set_defence(i.get_defence()+1);
            }
            else if(i.get_name() == "Squire" || i.get_name() == "Swiftblade" || i.get_name() == "Warlock" || i.get_name() == "Alchemist" || i.get_name() == "Basilisk" || i.get_name() == "Hydra" ||
                    i.get_name() == "Sunfire" || i.get_name() == "Zing" || i.get_name() == "Templar" || i.get_name() == "Soother" || i.get_name() == "Dragon" || i.get_name() == "Lightbringer" || i.get_name() == "Phoenix" ){
                i.set_speed(i.get_speed()-1);
            }
        }
    }


}
