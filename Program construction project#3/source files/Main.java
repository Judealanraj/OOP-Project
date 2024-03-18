import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void attack(Player p1,Player p2){
        Army A = p1.highest_speed_character();
        Army B = p2.lowest_defence_character();

        if (A instanceof Healers){
            Army C =p1.lowest_health_character();
            C.set_health(C.get_health() + (int)0.1*A.get_attack());
            System.out.println("["+A.get_name()+"]    attacking    ["+C.get_name()+"]");
            System.out.println("["+C.get_name()+"] health: ["+C.get_health()+"]");
            System.out.println("["+A.get_name()+"] health: ["+A.get_health()+"]");
        }
        else{
            B.set_health(B.get_health() - (int)(0.5*A.get_attack() - 0.1*B.get_defence()));
            System.out.println("["+A.get_name()+"]    attacking    ["+B.get_name()+"]");
            System.out.println("["+B.get_name()+"] health: ["+B.get_health()+"]");
            System.out.println("["+A.get_name()+"] health: ["+A.get_health()+"]");
            if(B.get_health()<0){
                p2.removeArmy(B);
                System.out.println("["+B.get_name()+"] died! ");
            }
        }
    }
    public static void match(Player p1, Player p2, String home_ground){
        switch (home_ground){
            case "Marshland":
                new Marshland(p1);
            case "Desert":
                new Desert(p1);
            case "Arcane":
                new Arcane(p1);
            case "Hillcrest":
                new Hillcrest(p1);
        }
        System.out.println("["+p1.get_player_name()+"]    vs    ["+p2.get_player_name()+"]");
        for(int i=1;i<21;i++){
            Army A = p1.highest_speed_character();
            Army B = p2.lowest_defence_character();
            if(A.get_name() == null || B.get_name() == null){
                System.out.println("match finished");
                break;
            }
            else if(i%2==1){
                System.out.println("Turn"+i+":["+p1.get_player_name()+"]");
                attack(p1,p2);
            }
            else if(i%2==0){
                System.out.println("Turn"+i+":["+p2.get_player_name()+"]");
                attack(p2,p1);
            }
            System.out.println("-------------------------------------\n");
        }
        if(p1.Army_collection.size()==0){
            System.out.println(p2.get_player_name()+" won!");
        }
        else if(p2.Army_collection.size()==0){
            System.out.println(p2.get_player_name()+" won!");
        }
        else {
            System.out.println("match draw");
        }
        System.out.println(p1.get_player_name()+" XP: ["+p1.get_xp_level()+"] gold coins: "+p1.get_coins());
        System.out.println(p2.get_player_name()+" XP: ["+p2.get_xp_level()+"] gold coins: "+p2.get_coins());



    }
    public static void start_playing_two_players() {
        Scanner input = new Scanner(System.in);
        int selector=0,selector2=0;
        System.out.println("define players with desire attributes          ");
        /*if(selector == 1){
            String name,username,army,homeground;
            int xp,coins;
            System.out.println("define first player");
            System.out.println("enter name: ");
            name = input.nextLine();
            System.out.println("enter user name: ");
            username = input.nextLine();
            System.out.println("enter XP level");
            xp = input.nextInt();
            input.nextLine();
            System.out.println("enter coin");
            coins = input.nextInt();
            input.nextLine();
            System.out.println("enter home ground");
            homeground=input.nextLine();
            Player player1 = new Player(name,username);

            System.out.println("define second player");
            System.out.println("enter name: ");
            name = input.nextLine();
            System.out.println("enter user name: ");
            username = input.nextLine();
            System.out.println("enter XP level");
            xp = input.nextInt();
            input.nextLine();
            System.out.println("enter coin");
            coins = input.nextInt();
            input.nextLine();
            System.out.println("enter home ground");
            homeground=input.nextLine();
            Player player2 = new Player(name,username);
        }*/

            Player player1 = new Player("","000");
            Player player2 = new Player("","999");
            String name;
            System.out.println("enter first player name:");
            name= input.nextLine();
            boolean Valid_input = false;
            while (!Valid_input)
                try{
                    System.out.println("enter  user name");
                    String user_name = input.nextLine();
                    Player PL = new Player(name,user_name);
                    player1 = PL;
                    Valid_input = true;
                }
                catch (IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }

            System.out.println("enter the next player name:");
            name= input.nextLine();
            Valid_input = false;
            while (!Valid_input)
                try{System.out.println("enter  user name");
                    String user_name = input.nextLine();
                    Player PL = new Player(name,user_name);
                    player2 = PL;
                    Valid_input = true;
                } catch (IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
            System.out.println("**************************************************************");
            while(selector!=26) {
                System.out.println("select army for player "+player1.get_player_name());
                System.out.println("Archer           Knight            Mages                 Healer          Mythical creature\n" +
                                    " 1.shoother       6.squire          11.warlock             16.soother       21.dragon\n" +
                                    " 2.ranger         7.cavalier        12.illusionist         17.medic         22.basilisk\n" +
                                    " 3.sunfire        8.templar         13.enchanter           18.alchemist     23.hydra\n" +
                                    " 4.zing           9.zoro            14.conjurer            19.saint         24.phoenix\n" +
                                    " 5.saggitarius    10.swiftblade     15.eldritch            20.lightbringer  25.pegasus\n" +
                                    " \n 26.exit this           ");
                selector = input.nextInt();
                input.nextLine();
                try{
                    switch (selector){
                    case 1:player1.buy_Archer("Shooter");
                    case 2:player1.buy_Archer("Sunfire");
                    case 3:player1.buy_Archer("Ranger");
                    case 4:player1.buy_Archer("Zing");
                    case 5:player1.buy_Archer("Saggitarius");
                    case 6:player1.buy_Knight("Squire");
                    case 7:player1.buy_Knight("Cavalier");
                    case 8:player1.buy_Knight("Templar");
                    case 9:player1.buy_Knight("Zoro");
                    case 10:player1.buy_Knight("Swiftblade");
                    case 11:player1.buy_Healer("Warlock");
                    case 12:player1.buy_Healer("Illusionist");
                    case 13:player1.buy_Healer("Enchanter");
                    case 14:player1.buy_Healer("Conjurer");
                    case 15:player1.buy_Healer("Eldritch");
                    case 16:player1.buy_Healer("Soother");
                    case 17:player1.buy_Healer("Medic");
                    case 18:player1.buy_Healer("Alchemist");
                    case 19:player1.buy_Healer("Saint ");
                    case 20:player1.buy_Healer("Lightbringer");
                    case 21:player1.buy_Mythical_creature("Dragon");
                    case 22:player1.buy_Mythical_creature("Basilisk");
                    case 23:player1.buy_Mythical_creature("Hydra");
                    case 24:player1.buy_Mythical_creature("Phoenix");
                    case 25:player1.buy_Mythical_creature("Pegasus");}}
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println("select armour or artefact  for your army player "+player1.get_player_name()+"\nfor which army you want armour");
            while(selector!=6) {
                selector2 =0;
                System.out.println("1.Archer           2.Knight            3.Mages                 4.Healer          5.Mythical creature    \n6.exit this" );
                try{selector = input.nextInt();
                    input.nextLine();
                    switch (selector) {
                        case 1:
                            System.out.println("select armour or artefact");
                            while (selector2 != 7) {
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try {
                                    switch (selector2) {
                                        case 1:
                                            player1.get_archer().buy_Armour_or_artefact(player1, "Chainmail");
                                        case 2:
                                            player1.get_archer().buy_Armour_or_artefact(player1, "Regalia");
                                        case 3:
                                            player1.get_archer().buy_Armour_or_artefact(player1, " Fleece");
                                        case 4:
                                            player1.get_archer().buy_Armour_or_artefact(player1, "Excalibur");
                                        case 5:
                                            player1.get_archer().buy_Armour_or_artefact(player1, "Amulet");
                                        case 6:
                                            player1.get_archer().buy_Armour_or_artefact(player1, " Crystal");

                                    }
                                } catch (Exception e) {
                                    System.out.println( e.getMessage());
                                }
                            }


                        case 2:
                            System.out.println("select armour or artefact");
                            while (selector2 != 7) {
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try {
                                    switch (selector2) {
                                        case 1:
                                            player1.get_knight().buy_Armour_or_artefact(player1, "Chainmail");
                                        case 2:
                                            player1.get_knight().buy_Armour_or_artefact(player1, "Regalia");
                                        case 3:
                                            player1.get_knight().buy_Armour_or_artefact(player1, " Fleece");
                                        case 4:
                                            player1.get_knight().buy_Armour_or_artefact(player1, "Excalibur");
                                        case 5:
                                            player1.get_knight().buy_Armour_or_artefact(player1, "Amulet");
                                        case 6:
                                            player1.get_knight().buy_Armour_or_artefact(player1, " Crystal");

                                    }
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                        case 3:
                            System.out.println("select armour or artefact");
                            while(selector2!=7){
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try{
                                    switch (selector2){
                                        case 1:
                                            player1.get_healer().buy_Armour_or_artefact(player1,"Chainmail");
                                        case 2:
                                            player1.get_healer().buy_Armour_or_artefact(player1,"Regalia");
                                        case 3:
                                            player1.get_healer().buy_Armour_or_artefact(player1," Fleece");
                                        case 4:
                                            player1.get_healer().buy_Armour_or_artefact(player1,"Excalibur");
                                        case 5:
                                            player1.get_healer().buy_Armour_or_artefact(player1,"Amulet");
                                        case 6:
                                            player1.get_healer().buy_Armour_or_artefact(player1," Crystal");

                                    }}
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                        case 4:
                            System.out.println("select armour or artefact");
                            while(selector2!=7){
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try{

                                    switch (selector2){
                                        case 1:
                                            player1.get_mage().buy_Armour_or_artefact(player1,"Chainmail");
                                        case 2:
                                            player1.get_mage().buy_Armour_or_artefact(player1,"Regalia");
                                        case 3:
                                            player1.get_mage().buy_Armour_or_artefact(player1," Fleece");
                                        case 4:
                                            player1.get_mage().buy_Armour_or_artefact(player1,"Excalibur");
                                        case 5:
                                            player1.get_mage().buy_Armour_or_artefact(player1,"Amulet");
                                        case 6:
                                            player1.get_mage().buy_Armour_or_artefact(player1," Crystal");

                                    }}
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                        case 5:
                            System.out.println("select armour or artefact");
                            while(selector2!=7){
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try{
                                    switch (selector2){
                                        case 1:
                                            player1.get_mythical_creature().buy_Armour_or_artefact(player1,"Chainmail");
                                        case 2:
                                            player1.get_mythical_creature().buy_Armour_or_artefact(player1,"Regalia");
                                        case 3:
                                            player1.get_mythical_creature().buy_Armour_or_artefact(player1," Fleece");
                                        case 4:
                                            player1.get_mythical_creature().buy_Armour_or_artefact(player1,"Excalibur");
                                        case 5:
                                            player1.get_mythical_creature().buy_Armour_or_artefact(player1,"Amulet");
                                        case 6:
                                            player1.get_mythical_creature().buy_Armour_or_artefact(player1," Crystal");

                                    }}
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                    }}
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }

            selector=0;selector2=0;
            while(selector!=26) {
                System.out.println("select army for player "+player1.get_player_name());
                System.out.println("Archer           Knight            Mages                 Healer          Mythical creature\n" +
                        " 1.shoother       6.squire          11.warlock             16.soother       21.dragon\n" +
                        " 2.ranger         7.cavalier        12.illusionist         17.medic         22.basilisk\n" +
                        " 3.sunfire        8.templar         13.enchanter           18.alchemist     23.hydra\n" +
                        " 4.zing           9.zoro            14.conjurer            19.saint         24.phoenix\n" +
                        " 5.saggitarius    10.swiftblade     15.eldritch            20.lightbringer  25.pegasus\n" +
                        " \n 26.exit this           ");
                selector = input.nextInt();
                input.nextLine();
                try{
                    switch (selector){
                        case 1:player1.buy_Archer("Shooter");
                        case 2:player1.buy_Archer("Sunfire");
                        case 3:player1.buy_Archer("Ranger");
                        case 4:player1.buy_Archer("Zing");
                        case 5:player1.buy_Archer("Saggitarius");
                        case 6:player1.buy_Knight("Squire");
                        case 7:player1.buy_Knight("Cavalier");
                        case 8:player1.buy_Knight("Templar");
                        case 9:player1.buy_Knight("Zoro");
                        case 10:player1.buy_Knight("Swiftblade");
                        case 11:player1.buy_Healer("Warlock");
                        case 12:player1.buy_Healer("Illusionist");
                        case 13:player1.buy_Healer("Enchanter");
                        case 14:player1.buy_Healer("Conjurer");
                        case 15:player1.buy_Healer("Eldritch");
                        case 16:player1.buy_Healer("Soother");
                        case 17:player1.buy_Healer("Medic");
                        case 18:player1.buy_Healer("Alchemist");
                        case 19:player1.buy_Healer("Saint ");
                        case 20:player1.buy_Healer("Lightbringer");
                        case 21:player1.buy_Mythical_creature("Dragon");
                        case 22:player1.buy_Mythical_creature("Basilisk");
                        case 23:player1.buy_Mythical_creature("Hydra");
                        case 24:player1.buy_Mythical_creature("Phoenix");
                        case 25:player1.buy_Mythical_creature("Pegasus");}}
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println("select armour or artefact  for your army player "+player2.get_player_name()+"\nfor which army you want armour");
            while(selector!=6) {
                selector2 =0;
                System.out.println("1.Archer           2.Knight            3.Mages                 4.Healer          5.Mythical creature    \n6.exit this" );
                try{selector = input.nextInt();
                    input.nextLine();
                    switch (selector) {
                        case 1:
                            System.out.println("select armour or artefact");
                            while (selector2 != 7) {
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try {
                                    switch (selector2) {
                                        case 1:
                                            player2.get_archer().buy_Armour_or_artefact(player2, "Chainmail");
                                        case 2:
                                            player2.get_archer().buy_Armour_or_artefact(player2, "Regalia");
                                        case 3:
                                            player2.get_archer().buy_Armour_or_artefact(player2, " Fleece");
                                        case 4:
                                            player2.get_archer().buy_Armour_or_artefact(player2, "Excalibur");
                                        case 5:
                                            player2.get_archer().buy_Armour_or_artefact(player2, "Amulet");
                                        case 6:
                                            player2.get_archer().buy_Armour_or_artefact(player2, " Crystal");

                                    }
                                } catch (Exception e) {
                                    System.out.println( e.getMessage());
                                }
                            }


                        case 2:
                            System.out.println("select armour or artefact");
                            while (selector2 != 7) {
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try {
                                    switch (selector2) {
                                        case 1:
                                            player2.get_knight().buy_Armour_or_artefact(player2, "Chainmail");
                                        case 2:
                                            player2.get_knight().buy_Armour_or_artefact(player2, "Regalia");
                                        case 3:
                                            player2.get_knight().buy_Armour_or_artefact(player2, " Fleece");
                                        case 4:
                                            player2.get_knight().buy_Armour_or_artefact(player2, "Excalibur");
                                        case 5:
                                            player2.get_knight().buy_Armour_or_artefact(player2, "Amulet");
                                        case 6:
                                            player2.get_knight().buy_Armour_or_artefact(player2, " Crystal");

                                    }
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                        case 3:
                            System.out.println("select armour or artefact");
                            while(selector2!=7){
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try{
                                    switch (selector2){
                                        case 1:
                                            player2.get_healer().buy_Armour_or_artefact(player2,"Chainmail");
                                        case 2:
                                            player2.get_healer().buy_Armour_or_artefact(player2,"Regalia");
                                        case 3:
                                            player2.get_healer().buy_Armour_or_artefact(player2," Fleece");
                                        case 4:
                                            player2.get_healer().buy_Armour_or_artefact(player2,"Excalibur");
                                        case 5:
                                            player2.get_healer().buy_Armour_or_artefact(player2,"Amulet");
                                        case 6:
                                            player2.get_healer().buy_Armour_or_artefact(player2," Crystal");

                                    }}
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                        case 4:
                            System.out.println("select armour or artefact");
                            while(selector2!=7){
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try{

                                    switch (selector2){
                                        case 1:
                                            player2.get_mage().buy_Armour_or_artefact(player2,"Chainmail");
                                        case 2:
                                            player2.get_mage().buy_Armour_or_artefact(player2,"Regalia");
                                        case 3:
                                            player2.get_mage().buy_Armour_or_artefact(player2," Fleece");
                                        case 4:
                                            player2.get_mage().buy_Armour_or_artefact(player2,"Excalibur");
                                        case 5:
                                            player2.get_mage().buy_Armour_or_artefact(player2,"Amulet");
                                        case 6:
                                            player2.get_mage().buy_Armour_or_artefact(player2," Crystal");

                                    }}
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                        case 5:
                            System.out.println("select armour or artefact");
                            while(selector2!=7){
                                System.out.println("1. Chainmail           2. Regalia            3. Fleece                 " +
                                        "4. Excalibur           5.  Amulet            6.  Crystal" +
                                        "\n7.exit this");
                                selector2 = input.nextInt();
                                input.nextLine();
                                try{
                                    switch (selector2){
                                        case 1:
                                            player2.get_mythical_creature().buy_Armour_or_artefact(player2,"Chainmail");
                                        case 2:
                                            player2.get_mythical_creature().buy_Armour_or_artefact(player2,"Regalia");
                                        case 3:
                                            player2.get_mythical_creature().buy_Armour_or_artefact(player2," Fleece");
                                        case 4:
                                            player2.get_mythical_creature().buy_Armour_or_artefact(player2,"Excalibur");
                                        case 5:
                                            player2.get_mythical_creature().buy_Armour_or_artefact(player2,"Amulet");
                                        case 6:
                                            player2.get_mythical_creature().buy_Armour_or_artefact(player2," Crystal");

                                    }}
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                    }}
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
            match(player1,player2,"Marshland");

    }




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int selector3;
        System.out.println("1.start playing two players        2.run default players given in PDF");
        selector3 = input.nextInt();
        System.out.println("**************************************************************\n");

        if(selector3==1){
            start_playing_two_players();}
        else if(selector3==2){
            Player p1 = new Player(" GeraltofRivia"," whitewolf");
            Player p2 = new Player("jude","jude");
            try{
                p1.set_archer(new Archers("Ranger",115,14,5,8,10));
                p1.Army_collection.add(p1.get_archer());
                p1.get_archer().buy_Armour_or_artefact(p1,"Chainmail");
                p1.set_knight(new Knights("Squire",85,8,9,7,8));
                p1.Army_collection.add(p1.get_knight());
                p1.set_mage( new Mages("Warlock",100,12,7,10,12));
                p1.Army_collection.add(p1.get_mage());
                p1.set_healer( new Healers("Medic",125,12,9,10,7));
                p1.Army_collection.add(p1.get_healer());
                p1.get_healer().buy_Armour_or_artefact(p1," Amulet");
                p1.set_mythical_creature(new Mythical_Creatures("Dragon",120,12,14,15,8));
                p1.Army_collection.add(p1.get_mythical_creature());
                p2.buy_Archer("Sunfire");
                p2.buy_Knight("Zoro");
                p2.buy_Healer("Soother");
                match(p1,p2,"Marshland");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }}

