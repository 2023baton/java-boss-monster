package bossmonster.domain;

public final class Attack {
    private final int damage;
    private final AttackType attackType;
    private final int mpCost;

    private Attack(int damage, AttackType attackType, int mpCost) {
        this.damage = damage;
        this.attackType = attackType;
        this.mpCost = mpCost;
    }
    
    public static class AttackBuilder {
        private final int damage;
        private int mpCost = 0;
        private AttackType attackType = AttackType.NORMAL;

        public AttackBuilder(int damage) {
            this.damage = damage;
        }

        public AttackBuilder buildAttackType(AttackType attackType) {
            this.attackType = attackType;
            return this;
        }

        public AttackBuilder buildMpCost(int mpCost) {
            this.mpCost = mpCost;
            return this;
        }

        public Attack build() {
            return new Attack(damage, attackType, mpCost);
        }
    }
}
