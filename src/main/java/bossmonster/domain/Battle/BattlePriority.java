package bossmonster.domain.Battle;

import bossmonster.domain.attack.AttackEntity;

import java.util.List;
import java.util.Queue;

public interface BattlePriority {
    Queue<AttackEntity> setAttackQueueOrder(List<AttackEntity> attackEntities);
}
