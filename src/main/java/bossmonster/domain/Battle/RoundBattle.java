package bossmonster.domain.Battle;

import bossmonster.domain.attack.AttackEntity;
import bossmonster.domain.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public abstract class RoundBattle implements BattlePriority {
    protected final List<Creature> creatures;
    protected boolean isGameEnd = false;
    protected int round = 0;
    protected final List<AttackEntity> attackEntities = new ArrayList<>();


    public RoundBattle(List<Creature> creatures) {
        this.creatures = creatures;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public abstract void nextRound();
}
