package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {
    NORMAL(1, 10, -10),
    MAGIC(2, 20, 30);

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

    public static AttackType TypeOfNumber(int number) {
        return Arrays.stream(values())
                .filter(value -> value.getTypeNumber() == number)
                .findAny()
                .orElse(null);
    }
}
