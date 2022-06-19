package sk.stuba.fei.uim.oop.card_actioncards;

import sk.stuba.fei.uim.oop.Player.Player;

public abstract class Card {

    int player_number;
    boolean action_card;
    String card_name;
    boolean playable;

    public Card(int player_number, boolean action_card, String card_name){
        this.player_number = player_number;
        this.action_card = action_card;
        this.card_name = card_name;
        this.playable = true;
    }

    public abstract void activate(Player player);

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }



    public int lifedown(Player player){
        return player.returnlifes();
    }

    public Card givecard(Card card){
        return card;
    }

    public String cardname(){
        return card_name;
    }
    public int playernumber(int player_number){
        return player_number;
    }

    public int PN(){
        return player_number+1;
    }


    public int setplayernumber(int number){
        this.player_number = number;
        return player_number;
    }
}
