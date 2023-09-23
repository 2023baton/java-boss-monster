package bossmonster.domain.creatures;

public abstract class Creature {
    private int hp;

    public void decreaseHp(int amount) {
        hp -= amount;
    }
}