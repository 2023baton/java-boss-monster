package bossmonster.domain.Battle;

import bossmonster.domain.attack.AttackEntity;

import java.util.List;
import java.util.Queue;

public abstract class BattleQueue implements RoundBattle {
    protected final List<AttackEntity> attackEntities;

    protected boolean isGameEnd = false;

    protected int round = 0;

    public BattleQueue(List<AttackEntity> attackEntities) {
        this.attackEntities = attackEntities;
    }

    protected abstract Queue<AttackEntity> setAttackQueueOrder();
}
