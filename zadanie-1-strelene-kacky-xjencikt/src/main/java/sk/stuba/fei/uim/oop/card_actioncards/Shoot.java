package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Shoot extends Card{

    int tiletoshoot;
    ArrayList<Card> pond;
    ArrayList<Card> DucksWater;
    Player Shootplayer;
    ArrayList<String> field;

    public Shoot(int player_number) {
        super(player_number, true, "Shoot");
    }

    public ArrayList<Card> shootingducks (int tiletoshoot, ArrayList<Card> pond,
                                          ArrayList<Card> DucksWater, Player Hitplayer, ArrayList<String> field) {
        this.tiletoshoot = tiletoshoot;
        this.pond = pond;
        this.DucksWater = DucksWater;
        this.Shootplayer = Hitplayer;
        this.field = field;


        Shootplayer.removeLifes();
        while (true) {
            if (field.get(tiletoshoot).equals("aimed at")) {
                field.remove(tiletoshoot);
                field.add(tiletoshoot, "not aimed at");
                pond.remove(tiletoshoot);
                pond.add(tiletoshoot, DucksWater.get(0));
                DucksWater.remove(0);
                return pond;
            } else {
                tiletoshoot = ZKlavesnice.readInt("Choose tile thats already aimed at! ") - 1;
            }
        }
    }

    @Override
    public void activate(Player player) {
        System.out.println("You shot at the tile. ");
    }
}
