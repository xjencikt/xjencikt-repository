package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;

public class Scatter extends  Card {

    public Scatter(int player_number){
        super(player_number,true,"Scatter");

    }
    @Override
    public void activate(Player player) {
        System.out.println("Scatter! The positions are randomly swapped.  ");
    }
}
