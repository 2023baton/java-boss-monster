package bossmonster.domain;

public abstract class Creature {
    private int hp;

    public abstract void decreaseHp(int amount);

    public abstract void die();
}
