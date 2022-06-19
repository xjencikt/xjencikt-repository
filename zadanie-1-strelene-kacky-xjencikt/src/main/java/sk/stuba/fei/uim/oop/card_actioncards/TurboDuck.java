package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class TurboDuck extends Card{

    int move;
    ArrayList<Card> pond;
    Card safe;


    public TurboDuck(int player_number) {
        super(player_number, true, "TurboDuck");
    }

    public ArrayList<Card> useturbo (int move, ArrayList<Card> pond) {

        this.move=move;
        this.pond=pond;

        while (true) {
            if (this.pond.get(move).cardname().equals("Water")) {
                move = ZKlavesnice.readInt(" Select duck, not water!") - 1;
            } else {

                safe = pond.get(move);
                for (int i = move; i > 0; i--) {
                    pond.remove(i);
                    pond.add(i, pond.get(i - 1));
                }
                pond.remove(0);
                pond.add(0, safe);
                return pond;
            }
        }
    }

    @Override
    public void activate(Player player) {
        System.out.println("Turbo Duck! 1 duck is moved to the first tile and the ducks that were overtaken 1 space backwards.");
    }
}
