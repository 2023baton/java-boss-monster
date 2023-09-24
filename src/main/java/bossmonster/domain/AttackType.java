package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {
    NORMAL(1),
    MAGIC(2);

    private final int typeNumber;

    AttackType(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public static AttackType createAttackTypeByNumber(int number) {
        return Arrays.stream(values())
                .filter(value -> value.getTypeNumber() == number)
                .findAny()
                .orElse(null);
    }
}
