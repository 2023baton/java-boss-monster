package bossmonster.domain.attack;

import java.util.Arrays;

public enum AttackType {
    BOSS(0, getRandomDamage(), 0),
    MAGIC(2, 20, 30),
    NORMAL(1, 10, -10);

    private static final int BOSS_MAX_DAMAGE = 20;
    private static final int BOSS_MIN_DAMAGE = 0;

    private static int getRandomDamage() {
        return new AttackRandomNumberGenerator().generate(BOSS_MIN_DAMAGE, BOSS_MAX_DAMAGE);
    }

    private final int typeNumber;
    private final int damage;
    private final int mpCost;

    AttackType(int typeNumber, int damage, int mpCost) {
        this.typeNumber = typeNumber;
        this.damage = damage;
        this.mpCost = mpCost;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpCost() {
        return mpCost;
    }

    public static AttackEntity createAttackEntity(AttackType attackType) {
        return new AttackEntity(attackType.getDamage(), attackType.getMpCost());
    }

    public static AttackType getAttackTypeByNumber(int typeNumber) {
        return Arrays.stream(AttackType.values())
                .filter(value -> value.getTypeNumber() == typeNumber)
                .findAny()
                .orElse(AttackType.BOSS);
    }
}
