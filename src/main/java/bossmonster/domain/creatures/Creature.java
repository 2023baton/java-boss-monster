package bossmonster.domain.creatures;

import bossmonster.domain.attack.AttackEntity;

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

    protected void decreaseHp(int amount) {
        if (hp <= 0) {
            dead = true;
            return;
        }
        hp -= amount;
    }

    protected void decreaseMpAs(int amount) {
        System.out.println("mp = " + mp);
        mp -= amount;
        System.out.println("totalMp = " + totalMp);
        if (mp >= totalHp) mp = totalMp;
        if (mp <= 0) mp = 0;
    }

    public void attack(AttackEntity attackEntity, Creature target) {
        validatePossibleAttack(attackEntity);
        decreaseMpAs(attackEntity.getMpCost());
        target.decreaseHp(attackEntity.getDamage());
    }

    private void validatePossibleAttack(AttackEntity attackEntity) {
        if (mp - attackEntity.getMpCost() < 0) {
            throw new IllegalArgumentException("mp가 부족해서 해당 공격을 사용할 수 없습니다.");
        }
    }
}