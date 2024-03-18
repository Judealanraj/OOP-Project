public class Desert extends Home_ground{
    public Desert(Player p){
        this.name = "Desert";
        for(Army i: p.Army_collection){
            if(i.get_name() == "Squire" || i.get_name() == "Swiftblade" || i.get_name() == "Warlock" || i.get_name() == "Alchemist" || i.get_name() == "Basilisk" || i.get_name() == "Hydra"){
                i.set_health(i.get_health()-1);
            }
            if(i.get_name() == "Sunfire" || i.get_name() == "Zing" || i.get_name() == "Templar" || i.get_name() == "Soother" || i.get_name() == "Dragon" || i.get_name() == "Lightbringer" || i.get_name() == "Phoenix" ){
                i.set_attack(i.get_attack()+1);
            }
        }
    }
}
