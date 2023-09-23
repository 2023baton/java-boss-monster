package bossmonster.domain;

public enum AttackType {
    NORMAL(1, 10),
    MAGIC(2, 20);

    private final int typeNumber;
    private final int damage;

    AttackType(int typeNumber, int damage) {
        this.typeNumber = typeNumber;
        this.damage = damage;
    }
    
    public int getTypeNumber() {
        return typeNumber;
    }

    public int getDamage() {
        return damage;
    }
}
