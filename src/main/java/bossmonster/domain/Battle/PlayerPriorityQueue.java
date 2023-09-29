package bossmonster.domain.Battle;

import bossmonster.TypeQualifier;
import bossmonster.domain.attack.AttackEntity;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class PlayerPriorityQueue extends BattleQueue {
    public PlayerPriorityQueue(List<AttackEntity> attackEntities) {
        super(attackEntities);
    }

    @Override
    public void nextRound() {
        System.out.println("PlayerPriorityQueue.nextRound");
        Queue<AttackEntity> attackQueue = setAttackQueueOrder();
        attackEntities.clear();
        round++;
        while (!attackQueue.isEmpty()) {
            AttackEntity entity = attackQueue.poll();
            entity.attack();
        }
    }

    protected Queue<AttackEntity> setAttackQueueOrder() {
        List<AttackEntity> players = getPlayerAttackEntities();
        players.addAll(getBossAttackEntities());
        return new LinkedList<>();
    }

    private List<AttackEntity> getPlayerAttackEntities() {
        return attackEntities.stream()
                .filter(entity -> TypeQualifier.checkCreatureType(Player.class, entity.getAttacker()))
                .collect(Collectors.toList());
    }

    private List<AttackEntity> getBossAttackEntities() {
        return attackEntities.stream()
                .filter(entity -> TypeQualifier.checkCreatureType(Boss.class, entity.getAttacker()))
                .collect(Collectors.toList());
    }

}
