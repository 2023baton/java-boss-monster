package bossmonster.domain.creatures;

public abstract class Creature {
    protected final int totalHp;
    protected int hp;

    public Creature(int totalHp) {
        this.totalHp = totalHp;
        hp = totalHp;
    }

    public void decreaseHp(int amount) {
        hp -= amount;
    }
}