package bossmonster.domain.attack;

import bossmonster.domain.creatures.Creature;

public final class AttackEntity {
    private final int damage;
    private final int mpCost;
    private final Creature attacker;
    private final Creature attacked;


    public int getDamage() {
        return damage;
    }

    public int getMpCost() {
        return mpCost;
    }

    AttackEntity(Creature attacker, Creature attacked, int damage, int mpCost) {
        this.damage = damage;
        this.mpCost = mpCost;
        this.attacker = attacker;
        this.attacked = attacked;
    }

    public static AttackEntity createAttack(Creature attacker, Creature attacked, AttackType attackType) {
        return new AttackEntity(attacker, attacked, attackType.getDamage(), attackType.getMpCost());
    }

    public Creature getAttacker() {
        return attacker;
    }

    public Creature getAttacked() {
        return attacked;
    }

    public void attack() {
        if (attacker.getHp() <= 0 || attacked.getHp() <= 0) return;
        this.attacker.decreaseMpAs(this.mpCost);
        this.attacked.damaged(this.damage);
    }
}
