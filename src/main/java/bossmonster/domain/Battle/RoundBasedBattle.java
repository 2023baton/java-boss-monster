package bossmonster.domain.Battle;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RoundBasedBattle extends Battle {
    private static final int PLAYER_PRIORITY = 0;
    private static final int BOSS_PRIORITY = 1;
    private final TreeMap<List<Creature>, Integer> orderMap = new TreeMap<>();

    public RoundBasedBattle(List<Creature> creatures) {
        super(creatures);
        setAttackOrder();
    }

    @Override
    public void run() {
    }

    private void setAttackOrder() {
        List<Creature> player = getPlayer();
        List<Creature> boss = getBoss();

        orderMap.put(player, PLAYER_PRIORITY);
        orderMap.put(boss, BOSS_PRIORITY);
    }

    private List<Creature> getPlayer() {
        return creatures.stream()
                .filter(creature -> isPlayer((Player) creature))
                .collect(Collectors.toList());
    }

    private boolean isPlayer(Player creature) {
        return (creature != null);
    }

    private List<Creature> getBoss() {
        return creatures.stream()
                .filter(creature -> isBoss((Boss) creature))
                .collect(Collectors.toList());
    }

    private boolean isBoss(Boss creature) {
        return (creature != null);
    }
}
