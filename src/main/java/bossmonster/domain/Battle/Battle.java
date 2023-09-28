package bossmonster.domain.Battle;

import bossmonster.domain.creatures.Creature;

import java.util.List;

public abstract class Battle implements BattleRule {
    protected final List<Creature> creatures;

    public Battle(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
