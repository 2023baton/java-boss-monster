package bossmonster.domain.attack;

public final class AttackEntity {
    private final int damage;
    private final int mpCost;

    public int getDamage() {
        return damage;
    }

    public int getMpCost() {
        return mpCost;
    }

    AttackEntity(int damage, int mpCost) {
        this.damage = damage;
        this.mpCost = mpCost;
    }

    public static AttackEntity createAttack(AttackType attackType) {
        return AttackType.createAttackEntity(attackType);
    }
}
