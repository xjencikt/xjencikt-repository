package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;

import java.util.ArrayList;

public class DuckDance extends Card{

    ArrayList<Card> pond;
    ArrayList<Card> DucksWater;

    public ArrayList<Card> dancing (ArrayList<Card> pond, ArrayList<Card> DucksWater) {
        this.pond=pond;
        this.DucksWater=DucksWater;

        for (int i=0; i<6; i++){
            DucksWater.add(pond.get(0));
            pond.remove(0);
        }
        return pond;


    }

    public DuckDance(int player_number) {
        super(player_number, true, "DuckDance");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Duck dance! All cards from the pond are put back into the deck, swapped with new ones.  ");
    }
}
