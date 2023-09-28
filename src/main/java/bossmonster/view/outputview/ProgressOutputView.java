package bossmonster.view.outputview;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;
import bossmonster.view.OutputView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class ProgressOutputView implements OutputView {
    private BufferedWriter bw;

    @Override
    public void show(Map<String, Object> model) {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write("============================\n");
            bw.write("============================\n");
            bw.flush();
            bw.close();
        } catch (IOException ignored) {
        }
    }

    private void printBossStat(Map<String, Object> model) throws IOException {
        if (model.get("boss") instanceof Creature) {
            throw new IllegalArgumentException("[Error] 예외 발생");
        }
        Boss boss = (Boss) model.get("boss");
        bw.write("BOSS HP [" + boss.getHp() + "/" + boss.getTotalHp() + "]\n");
    }

    private void printPlayerState(Map<String, Object> model) throws IOException {
        if (model.get("player") instanceof Player) {
            throw new IllegalArgumentException("[Error] 예외 발생");
        }
        Player player = (Player) model.get("player");
        bw.write(player.getName() + " HP [" + player.getHp() + "/" + player.getTotalHp() + "]\n");
    }

    private void printBossSprite(BossSprite bossSprite) throws IOException {
        bw.write("____________________________\n");
        bw.write(bossSprite.getSprite() + "\n");
        bw.write("____________________________\n");
    }
}
