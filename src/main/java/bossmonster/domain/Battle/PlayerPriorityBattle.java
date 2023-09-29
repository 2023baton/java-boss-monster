package bossmonster.domain.Battle;

import bossmonster.TypeQualifier;
import bossmonster.domain.attack.AttackEntity;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class PlayerPriorityBattle extends RoundBattle {
    public PlayerPriorityBattle(List<Creature> creatures) {
        super(creatures);
    }

    @Override
    public void nextRound() {
        Queue<AttackEntity> attackQueue = setAttackQueueOrder(attackEntities);

    }

    @Override
    public Queue<AttackEntity> setAttackQueueOrder(List<AttackEntity> attackEntities) {
        List<AttackEntity> players = getPlayerAttackEntities(attackEntities);
        players.addAll(getBossAttackEntities(attackEntities));
        return new LinkedList<>();
    }

    private List<AttackEntity> getPlayerAttackEntities(List<AttackEntity> attackEntities) {
        return attackEntities.stream()
                .filter(entity -> TypeQualifier.checkCreatureType((Player) entity.getAttacker()))
                .collect(Collectors.toList());
    }

    private List<AttackEntity> getBossAttackEntities(List<AttackEntity> attackEntities) {
        return attackEntities.stream()
                .filter(entity -> TypeQualifier.checkCreatureType((Boss) entity.getAttacker()))
                .collect(Collectors.toList());
    }

}
