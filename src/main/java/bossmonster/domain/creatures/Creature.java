package bossmonster.domain.creatures;

public abstract class Creature {
    protected int hp;

    public void decreaseHp(int amount) {
        hp -= amount;
    }
}