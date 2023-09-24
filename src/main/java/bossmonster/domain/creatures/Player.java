package bossmonster.domain.creatures;

import bossmonster.domain.AttackType;

public final class Player extends Creature {
    private static final int HP_MP_SUM = 200;
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private int totalMp;
    private final String name;
    private int mp;
    private AttackType attackType;

    public int getTotalMp() {
        return totalMp;
    }

    public String getName() {
        return name;
    }

    public int getMp() {
        return mp;
    }

    public Player(int totalHp, int totalMp, String name) {
        super(totalHp);
        this.totalMp = totalMp;
        this.name = name;
        validateStatSum(totalHp, totalMp);
        validateNameLength(name);
        mp = totalMp;
    }

    public void addMpAs(int amount) {
        mp += amount;
        if (mp >= totalHp) mp = totalMp;
        if (mp <= 0) mp = 0;
    }

    public void setAttackType(int attackNumber) {
        this.attackType = AttackType.createAttackTypeByNumber(attackNumber);
    }

    private void validateNameLength(String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하로 입력해야 합니다.");
        }
    }

    private void validateStatSum(int hp, int mp) {
        if (hp + mp != HP_MP_SUM) {
            throw new IllegalArgumentException("Hp와 MP의 합은 200이어야 합니다.");
        }
    }
}
