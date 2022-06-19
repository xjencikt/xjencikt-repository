package sk.stuba.fei.uim.oop.boards;

import sk.stuba.fei.uim.oop.Player.Player;
import sk.stuba.fei.uim.oop.card_actioncards.Card;

public class Ducks extends Card {


    int player_number;


    public Ducks(int player_number) {
        super(player_number,false,"Duck");
        this.player_number = player_number;
    }

    ;

    @Override
    public void activate(Player player) {

    }
}
