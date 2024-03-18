public class Arcane extends Home_ground{
    public Arcane(Player p){
        this.name = "Arcane";
        for(Army i: p.Army_collection){
            if(i.get_name() == "Saggitarius" || i.get_name() == "Illusionist" || i.get_name() == "Eldritch" || i.get_name() == "Saint" || i.get_name() == "Pegasus"){
                i.set_attack(i.get_attack()+2);
            }
            if(i.get_name() == "Shooter" || i.get_name() == "Ranger" || i.get_name() == "Cavalier" || i.get_name() == "Zoro" || i.get_name() == "Conjurer" || i.get_name() == "Medic"||
                    i.get_name() == "Squire" || i.get_name() == "Swiftblade" || i.get_name() == "Warlock" || i.get_name() == "Alchemist" || i.get_name() == "Basilisk" || i.get_name() == "Hydra"){
                i.set_speed(i.get_speed()-1);
                i.set_defence(i.get_defence()-1);
            }

        }
    }
}
