public class Healers extends Army{
    public Armour armour = null;
    public Artefacts artefact =null;
    public int Armour_count = 0;
    public int Artefacts_count = 0;
    public Healers(String name, int price, int attack, int defence, int health, int speed) {
        super(name, price, attack, defence, health, speed);
    }
    public void buy_Armour_or_artefact(Player p,String Armour_name) throws Exception{
        Armour A = new Armour(null,0,0,0,0,0);
        Artefacts B = new Artefacts(null,0,0,0,0,0);
        switch (Armour_name){
            case "Chainmail":
                A = new Armour("Chainmail",70,0,1,0,-1);
                break;
            case "Regalia":
                A = new Armour("Regalia",105,0,1,0,0);
                break;
            case "Fleece":
                A= new Armour("Fleece",150,0,2,1,-1);
                break;
            case "Excalibur":
                B = new Artefacts("Excalibur",150,2,0,0,0);
                break;
            case "Amulet":
                B = new Artefacts("Amulet",200,1,-1,1,1);
                break;
            case "Crystal":
                B= new Artefacts("Crystal",210,2,1,-1,-1);
                break;
            //default:
            //throw new Exception("Please enter a valid Armour name......");
        }
        if (p.get_coins() < A.price || p.get_coins() < B.price){
            throw new Exception("You Don't have enough coins to buy this....");
        }
        else if(this.Armour_count < 1 && A.name!=null){
            this.armour =A;
            p.set_coins(p.get_coins()- A.price);
            this.Armour_count++;
            p.set_player_value(p.get_player_value()+(int)0.2*A.price);
        }
        else if(this.Artefacts_count < 1 && B.name!=null){
            this.artefact =B;
            p.set_coins(p.get_coins()- B.price);
            this.Artefacts_count++;
            p.set_player_value(p.get_player_value()+(int)0.2*B.price);
        }
        else if(A.name!=null) {
            p.set_coins(p.get_coins()- A.price+this.armour.price);
            p.set_player_value(p.get_player_value()+(int)0.2*A.price);
            this.armour = A;
        }
        else if(B.name!=null) {
            p.set_coins(p.get_coins()- B.price+this.artefact.price);
            p.set_player_value(p.get_player_value()+(int)0.2*B.price);
            this.artefact = B;
        }
    }
}
