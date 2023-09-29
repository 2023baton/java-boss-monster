package bossmonster.domain.creatures;

public abstract class Creature {
    protected final int totalHp;
    protected int totalMp;
    protected int hp;
    protected int mp;
    protected boolean dead = false;

    public int getTotalHp() {
        return totalHp;
    }

    public int getTotalMp() {
        return totalMp;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public Creature(int totalHp) {
        this.totalHp = totalHp;
        this.hp = totalHp;
    }

    public void damaged(int amount) {
        if (hp <= 0) {
            dead = true;
            return;
        }
        hp -= amount;
    }

    public void decreaseMpAs(int mpCost) {
        validatePossibleAttack(mpCost);
        mp -= mpCost;
        if (mp >= totalHp) mp = totalMp;
    }

    private void validatePossibleAttack(int mpCost) {
        if (mp - mpCost < 0) {
            throw new IllegalArgumentException("mp가 부족해서 해당 공격을 사용할 수 없습니다.");
        }
    }
}