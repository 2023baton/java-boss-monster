package bossmonster.domain.creatures;

public final class Player extends Creature {
    private static final int HP_MP_SUM = 200;
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private final String name;

    public Player(int totalHp, int totalMp, String name) {
        super(totalHp);
        this.totalMp = totalMp;
        this.name = name;
        validateStatSum(totalHp, totalMp);
        validateNameLength(name);
        mp = totalMp;
    }

    public int getTotalMp() {
        return totalMp;
    }

    public String getName() {
        return name;
    }

    public int getMp() {
        return mp;
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
