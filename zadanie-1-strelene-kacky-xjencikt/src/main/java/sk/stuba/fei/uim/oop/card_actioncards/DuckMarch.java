package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;

import java.util.ArrayList;

public class DuckMarch extends Card{

    ArrayList<Card> pond;
    ArrayList<Card> DucksWater;

    public ArrayList<Card> marching (ArrayList<Card> pond, ArrayList<Card> DucksWater) {
        this.pond=pond;
        this.DucksWater=DucksWater;

        DucksWater.add(pond.get(0));
        pond.remove(0);
        pond.add(DucksWater.get(0));
        DucksWater.remove(0);
        return pond;
    }

    public DuckMarch(int player_number) {
        super(player_number, true, "DuckMarch");
    }


    @Override
    public void activate(Player player) {
        System.out.println("Duck March! All cards are moved 1 up.  ");
    }
}
