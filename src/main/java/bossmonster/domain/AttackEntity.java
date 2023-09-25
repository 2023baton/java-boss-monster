package bossmonster.domain;

public final class AttackEntity {
    public int getDamage() {
        return damage;
    }

    public int getMpCost() {
        return mpCost;
    }

    private final int damage;
    private final int mpCost;


    private AttackEntity(int damage, int mpCost) {
        this.damage = damage;
        this.mpCost = mpCost;
    }

    public final static class AttackEntityBuilder {
        private final int damage;
        private final int mpCost;

        public AttackEntityBuilder(int damage) {
            this.damage = damage;
            this.mpCost = 0;
        }

        public AttackEntityBuilder(AttackType attackType) {
            this.damage = attackType.getDamage();
            this.mpCost = attackType.getMpCost();
        }

        public AttackEntity build() {
            return new AttackEntity(damage, mpCost);
        }
    }
}
