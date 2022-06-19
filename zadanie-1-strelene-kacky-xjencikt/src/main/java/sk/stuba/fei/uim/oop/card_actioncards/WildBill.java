package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;


import java.util.ArrayList;

public class WildBill extends  Card{

    ArrayList<Card> pond;
    ArrayList<Card> DucksWater;
    ArrayList<Card> auctiondeck;
    Player Hitplayer;
    int hit;
    ArrayList<String> field;

    public ArrayList<Card> billyshooting (int hit, ArrayList<Card> pond,
                                          ArrayList<Card> DucksWater, Player Hitplayer,
                                          ArrayList<String> field, ArrayList<Card> auctiondeck){
        this.hit=hit;
        this.pond = pond;
        this.DucksWater = DucksWater;
        this.Hitplayer= Hitplayer;
        this.field = field;
        this.auctiondeck = auctiondeck;

        Card Aim = new Aim(player_number);

        Hitplayer.removeLifes();
        if (field.get(hit).equals("aimed at")){
            field.remove(hit);
            field.add(hit,"not aimed at");
            auctiondeck.add(Aim);
        }
        pond.remove(hit);
        pond.add(hit,DucksWater.get(0));
        DucksWater.remove(0);
        return pond;
    }

    public WildBill(int player_number) {
        super(player_number, true, "WildBill");
    }


    @Override
    public void activate(Player player) {
        System.out.println("YEEHAH! You aimed and shot at the tile! ");
    }
}
