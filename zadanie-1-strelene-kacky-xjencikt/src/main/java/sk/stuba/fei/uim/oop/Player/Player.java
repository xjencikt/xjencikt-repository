package sk.stuba.fei.uim.oop.Player;

import sk.stuba.fei.uim.oop.card_actioncards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int player_number;
    int lifes;
    private boolean active;
    public List<Card> hand;
    private List<Card> playerducks;


    public Player(int player_number) {
        this.player_number = player_number;
        this.lifes = 5;
        this.hand = new ArrayList<>();
        this.active = true;
    }

    public int getPlayer_number() { // get player number
        return player_number;
    }

    public int getLifes() { // return lifes
        return lifes;
    }

    public void setLifes(int lifes) { //set player lifes to 5
        this.lifes = lifes;
    }

    public int returnlifes(){
        return this.lifes;
    }



    public boolean isActive() { //active player
        return active;
    }

    public void setActive(boolean active) { //set player active
        this.active = active;
    }

    public void loselife(){
        this.active = false;
        System.out.println("YOU LOST");
    }

    public int removeLifes() { //remove 1 duck/life from life count
        this.lifes -= 1;
        return lifes;
    }

    public void addcard(Card card) { //add cards to hand
        this.hand.add(card);
    }


    public String returncard(int i){
        return hand.get(i).cardname();
    }

    private void removecard(Card card) {// remove card from hand
        this.hand.remove(card);
    }
}
