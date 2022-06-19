package sk.stuba.fei.uim.oop.boards;

import sk.stuba.fei.uim.oop.Player.Player;

public abstract class Tile {

    boolean aimed_at;

    public Tile()
    {
        this.aimed_at = false;
    }

    public abstract void activate(Player player);
}

