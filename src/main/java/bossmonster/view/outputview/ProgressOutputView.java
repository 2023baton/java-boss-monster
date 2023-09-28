package bossmonster.view.outputview;

import bossmonster.domain.creatures.Boss;
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
            printBossStat((Boss) model.get("boss"));
            printBossSprite((BossSprite) model.get("bossSprite"));
            printPlayerState((Player) model.get("player"));
            bw.write("============================\n");
            bw.flush();
            bw.close();
        } catch (IOException ignored) {
        }
    }

    private void printBossStat(Boss boss) throws IOException {
        if (boss == null) {
            throw new IllegalArgumentException("[Error] Boss 예외 발생");
        }
        bw.write("BOSS HP [" + boss.getHp() + "/" + boss.getTotalHp() + "]\n");
    }

    private void printBossSprite(BossSprite bossSprite) throws IOException {
        if (bossSprite == null) {
            throw new IllegalArgumentException("[Error] BossSprite 예외 발생");
        }
        bw.write("____________________________\n");
        bw.write(bossSprite.getSprite());
        bw.write("____________________________\n");
    }

    private void printPlayerState(Player player) throws IOException {
        if (player == null) {
            throw new IllegalArgumentException("[Error] player 예외 발생");
        }
        bw.write(player.getName() + " HP [" + player.getHp() + "/" + player.getTotalHp() + "]\n");
    }
}
