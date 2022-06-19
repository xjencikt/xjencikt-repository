package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Aim extends Card{


    int number_position;
    ArrayList<String> field;

    public Aim(int player_number) {
        super(player_number, true, "Aim");
    }

    public ArrayList<String> wheretoaim (int number_position, ArrayList<String> field){
        this.number_position = number_position;
        this.field = field;


        while (true) {
            if (field.get(number_position).equals("not aimed at")) {
                field.remove(number_position);
                field.add(number_position,"aimed at");
                return field;
            } else {

                int fieldnumber = ZKlavesnice.readInt("Already aimed at! choose new location to aim at! ");
                number_position = fieldnumber;
            }
        }
    }

    @Override
    public void activate(Player player) {

        System.out.println("You aimed at the tile! ");
    }
}
