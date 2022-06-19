package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Player.Player;
import sk.stuba.fei.uim.oop.boards.Ducks;
import sk.stuba.fei.uim.oop.boards.Water;
import sk.stuba.fei.uim.oop.card_actioncards.*;
import sk.stuba.fei.uim.oop.card_actioncards.Aim;
import sk.stuba.fei.uim.oop.card_actioncards.Shoot;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private final Player[] players;
    private int currentPlayer;
    private int roundCounter;

    public ArrayList<Card> DucksWater = new ArrayList<>();
    public ArrayList<Card> pond = new ArrayList<>();
    protected ArrayList<String> field = new ArrayList<>();
    protected ArrayList<Card> auctiondeck = new ArrayList<>();
    protected ArrayList<Card> discarddeck = new ArrayList<>();


    public Game() {
        System.out.println("Welcome to Duck Hunt!");
        int numberPlayers = ZKlavesnice.readInt("Enter the number of players between 2 - 6 ");
        while (numberPlayers < 2 || numberPlayers > 6){
            numberPlayers = ZKlavesnice.readInt("Wrong number. Enter the number of players between 2 - 6 ");
        }
            this.players = new Player[numberPlayers];
            for (int i = 0; i < numberPlayers; i++) {
                this.players[i] = new Player(i+1);
                System.out.println("PLAYER NUMBER: " + (i+1));
            }


            this.startGame();



    }

    public void PlayerDucks() {
        for (int i=0; i<getNumberActivePlayers(); i++){
            for (int j=0; j<5;j++){
                Ducks ducks = new Ducks(i);
                ducks.playernumber(i);
                DucksWater.add(ducks);
            }
        }
        Water water = new Water();
        for (int i=0; i<5; i++)
            DucksWater.add(water);
    }

    public void ShuffleDucksWater(){
        Collections.shuffle(DucksWater);
    }

    public void ShuffleauctionDeck(){
        Collections.shuffle(auctiondeck);
    }

    public void Shufflepond(){
        Collections.shuffle(pond);
    }


    public void auctiondeck(){

        for (int i=0; i<10; i++){
            Aim aim = new Aim(0);
            auctiondeck.add(aim); //aim
        }
        for (int i=0; i<12; i++){
            Shoot shoot = new Shoot(0);
            auctiondeck.add(shoot); //shoot
        }
        for (int i=0; i<2; i++){
            WildBill wildBill = new WildBill(0);
            auctiondeck.add(wildBill); //Wild Bill
        }



        for (int i=0; i<6; i++){
            DuckMarch duckMarch = new DuckMarch(0);
            auctiondeck.add(duckMarch); //Duck March
        }
        for (int i=0; i<2; i++){
            Scatter scatter = new Scatter(0);
            auctiondeck.add(scatter); //Scatter
        }


        TurboDuck turboDuck = new TurboDuck(0); ///OPRAVIT
        auctiondeck.add(turboDuck); //Turbo Duck

        DuckDance duckDance = new DuckDance(0);
        auctiondeck.add(duckDance); //Duck Dance


        ShuffleauctionDeck();

    }

    public void Gethand(){
        getNumberActivePlayers();
        Player activePlayer = this.players[this.currentPlayer];
        for (int j = 0; j < 3; j++) {


            activePlayer.addcard(auctiondeck.get(0));

            auctiondeck.get(0).setplayernumber(activePlayer.getPlayer_number());
            auctiondeck.remove(0);


        }
    }

    public void discard_action(){
        if (auctiondeck.isEmpty()){
            auctiondeck=discarddeck;
        }
    }


    public boolean countshoot(){
        int countshoot = 0;
        for (int i = 0; i<6; i++){
            if (field.get(i).equals("not aimed at")){
                countshoot = countshoot + 1;
            }
        }
        if (countshoot==6){
            return false;
        }
        return true;
    }

    public boolean countaim(){
        int countaim = 0;
        for (int i = 0; i<6; i++){
            if (field.get(i).equals("aimed at")){
                countaim = countaim + 1;
            }
        }
        if (countaim==6){
            return false;
        }
        return true;
    }

    public int showHand(){
        Player activePlayer = this.players[this.currentPlayer];
        int counting = 0;



        for(int i=0; i<3; i++) {
            if (!countshoot() && activePlayer.returncard(i).equals("Shoot")){
                System.out.println("Card name: " + (i + 1) + ". " + ConsoleColors.RED_BOLD + activePlayer.returncard(i) + ConsoleColors.RESET);
                counting = counting + 1;
            }
            else if (!countaim() && activePlayer.returncard(i).equals("Shoot")){
                System.out.println("Card name: " + (i + 1) + ". " + ConsoleColors.RED_BOLD + activePlayer.returncard(i) + ConsoleColors.RESET);
                counting = counting + 1;
            }
            else {
                System.out.println("Card name: " + (i + 1) + ". " + activePlayer.returncard(i));
            }
        }
        return counting;
    }

    public boolean isplayable(int cardnumber){
        Player activePlayer = this.players[this.currentPlayer];
        Card card = activePlayer.hand.get(cardnumber);
        if (!countshoot() && card.cardname().equals("Shoot")){
            return false;
        }
        else if (!countaim() && card.cardname().equals("Aim")){
            return false;
        }
        else{
            return true;
        }
    }

    public void cardusage(int cardnumber) {
        Player activePlayer = this.players[this.currentPlayer];
        Card card = activePlayer.hand.get(cardnumber);


            switch (card.cardname()) {
                case "Aim":
                    Aim aim = new Aim(activePlayer.getPlayer_number());
                    int Tilenumberaim = ZKlavesnice.readInt("Choose which tile to aim at. ");
                    while (Tilenumberaim < 1 || Tilenumberaim > 6) {
                        Tilenumberaim = ZKlavesnice.readInt("WRONG NUMBER, CHOOSE ANOTHER ONE.");
                    }
                    aim.wheretoaim(Tilenumberaim - 1, field);
                    break;
                case "Shoot":

                    int Tiletoshoot = ZKlavesnice.readInt("Choose which tile to shoot at. ") - 1;
                    while (Tiletoshoot < 0 || Tiletoshoot >5) {
                        Tiletoshoot = ZKlavesnice.readInt("WRONG NUMBER, CHOOSE ANOTHER ONE.")-1;
                    }
                    Player Shootplayer = this.players[pond.get(Tiletoshoot).PN() - 1];

                    Shoot shoot = new Shoot(activePlayer.getPlayer_number());
                    shoot.shootingducks(Tiletoshoot, pond, DucksWater, Shootplayer, field);



                    break;
                case "WildBill":
                    int hit = ZKlavesnice.readInt("Shoot Duck without aiming!") - 1;
                    while (hit < 0 || hit >5) {
                        hit = ZKlavesnice.readInt("WRONG NUMBER, CHOOSE ANOTHER ONE.")-1;
                    }
                    Player Hitplayer = this.players[pond.get(hit).PN() - 1];
                    WildBill wildBill = new WildBill(activePlayer.getPlayer_number());
                    wildBill.billyshooting(hit, pond, DucksWater, Hitplayer, field, auctiondeck);

                    break;
                case "DuckDance":

                    DuckDance duckdance = new DuckDance(activePlayer.getPlayer_number());
                    duckdance.dancing(pond, DucksWater);


                    ShuffleDucksWater();
                    initializePond();

                    break;
                case "DuckMarch":

                    DuckMarch duckmarch = new DuckMarch(activePlayer.getPlayer_number());
                    duckmarch.marching(pond, DucksWater);


                    break;
                case "Scatter":
                    Shufflepond();
                    break;
                case "TurboDuck":
                    TurboDuck Tduck = new TurboDuck(activePlayer.getPlayer_number());
                    int Tileturboduck = ZKlavesnice.readInt("Choose a duck to move upfront. ") - 1;
                    while (Tileturboduck < 0 || Tileturboduck >5) {
                        Tileturboduck = ZKlavesnice.readInt("WRONG NUMBER, CHOOSE ANOTHER ONE.")-1;
                    }
                    Tduck.useturbo(Tileturboduck, pond);

                    break;
            }
        }


public void throwcard(){
    Player activePlayer = this.players[this.currentPlayer];
    int throwcard = ZKlavesnice.readInt("CAN'T PLAY ANY CARD, CHOOSE WHICH ONE TO THROW AWAY: ");
    activePlayer.hand.remove(throwcard);
    activePlayer.hand.add(auctiondeck.get(0));
    auctiondeck.remove(0);
}



    public void playcard() {
        Player activePlayer = this.players[this.currentPlayer];


        int playednumberofcard = ZKlavesnice.readInt("Select a number of card you wish to play. ");
        if (playednumberofcard< 3 && playednumberofcard > 0){
        while (!isplayable(playednumberofcard - 1)) {
            playednumberofcard = ZKlavesnice.readInt(ConsoleColors.RED_BOLD + "UNPLAYABLE, CHOOSE ANOTHER CARD " + ConsoleColors.RESET);
        }
    }
            while (playednumberofcard != 1 || playednumberofcard != 2 || playednumberofcard != 3) {
                if (playednumberofcard == 1) {

                    activePlayer.hand.get(0);
                    System.out.println("YOU PLAYED CARD NUMBER 1");

                    cardusage(0);

                    discarddeck.add(activePlayer.hand.get(0));
                    activePlayer.hand.get(0).playernumber(0);
                    activePlayer.hand.remove(0);

                    auctiondeck.get(0).setplayernumber(activePlayer.getPlayer_number());
                    activePlayer.hand.add(0, auctiondeck.get(0));
                    auctiondeck.remove(0);

                    break;
                } else if (playednumberofcard == 2) {
                    activePlayer.hand.get(1);
                    System.out.println("YOU PLAYED CARD NUMBER 2");

                    cardusage(1);

                    discarddeck.add(activePlayer.hand.get(1));
                    activePlayer.hand.get(1).playernumber(0);
                    activePlayer.hand.remove(1);

                    auctiondeck.get(0).setplayernumber(activePlayer.getPlayer_number());
                    activePlayer.hand.add(1, auctiondeck.get(0));
                    auctiondeck.remove(0);

                    break;
                } else if (playednumberofcard == 3) {
                    activePlayer.hand.get(2);
                    System.out.println("YOU PLAYED CARD NUMBER 3");

                    cardusage(2);

                    discarddeck.add(activePlayer.hand.get(2));
                    activePlayer.hand.get(2).playernumber(0);
                    activePlayer.hand.remove(2);

                    auctiondeck.get(0).setplayernumber(activePlayer.getPlayer_number());
                    activePlayer.hand.add(2, auctiondeck.get(0));
                    auctiondeck.remove(0);

                    break;

                } else {
                    System.out.println("WRONG NUMBER");
                    playednumberofcard = ZKlavesnice.readInt("Select a number of card you wish to play. ");
                }
            }
        }

    private void initializePond() {
        for (int i=0; i<6; i++){
            pond.add(DucksWater.get(0));
            DucksWater.remove(0);
        }
    }
    private void initializeBoard() {

        for (int i=0; i<6; i++){
            field.add(i, "not aimed at");
        }
        for (int i=0; i<6; i++){
            pond.add(DucksWater.get(0));
            DucksWater.remove(0);
        }


    }

    public void showpond(){
        for (int i=0; i<6; i++){
            if(pond.get(i).cardname().equals("Duck")){
                System.out.println((i+1) + ". Tile: " + field.get(i) + "/ Pond: " + pond.get(i).cardname() + " "
                        + pond.get(i).PN());
            }
            else{
                System.out.println((i+1) + ". Tile: " + field.get(i) + "/ Pond: Water");
            }

        }
    }



    private void startGame() {
        System.out.println("--- GAME STARTED ---");


        PlayerDucks();
        ShuffleDucksWater();
        auctiondeck();
        initializeBoard();

        discard_action();

        for (this.currentPlayer = 0; this.currentPlayer < getNumberActivePlayers(); this.currentPlayer++) {
            Gethand();
        }


            for (this.currentPlayer = 0; getNumberActivePlayers() > 1; this.incrementCounter()) {
                if (this.currentPlayer == 0) {
                    System.out.println("--- ROUND " + (this.roundCounter / this.players.length + 1) + " STARTS ---");
                }


                Player activePlayer = this.players[this.currentPlayer];
                if (!activePlayer.isActive()) {
                    continue;
                }



                System.out.println("");

                System.out.println("POND:");
                showpond();
                System.out.println("");
                System.out.println("--- PLAYER " + activePlayer.getPlayer_number() + " STARTS TURN ---");
                System.out.println("");
                System.out.println("Player " + activePlayer.getPlayer_number() + " hand:");

                System.out.println("Player lifes/ducks left: " + activePlayer.getLifes());



                if (showHand() == 3) {
                    throwcard();
                } else {
                    playcard();
                }


                System.out.println("");



                checklife();

                endTurn(activePlayer);
            }
            System.out.println("--- GAME FINISHED ---");
            System.out.println("And the WINNER is " + getWinner().getPlayer_number());
        }


    public void checklife(){
        Player activePlayer = this.players[this.currentPlayer];
        if (activePlayer.returnlifes()==0){
            activePlayer.loselife();
        }
    }


    private void incrementCounter() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.length;
        this.roundCounter++;
    }


    private int getNumberActivePlayers() {
        int count = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].isActive()) {
                count++;
            }
        }
        return count;
    }

    private Player getWinner() {
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].isActive()) {
                return this.players[i];
            }
        }
        return null;
    }

    private void endTurn(Player activePlayer) {
        System.out.println("--- PLAYER " + activePlayer.getPlayer_number() + " ENDS TURN ---\n");
        ZKlavesnice.readString("Press Enter To Continue");
    }

}



