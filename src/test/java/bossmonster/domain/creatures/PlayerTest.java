package bossmonster.domain.creatures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {
    @Test
    @DisplayName("hp와 mp의 합이 200을 초과하면 예외가 발생한다.")
    void 스탯합_200_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Player(100, 200, "TEST1"));
    }

    @Test
    @DisplayName("hp와 mp이 200합이 미만이면 예외가 발생한다.")
    void 스탯합_200_미만() {
        assertThrows(IllegalArgumentException.class, () -> new Player(100, 99, "TEST2"));
    }

    @Test
    @DisplayName("예외가 발생하지 않으면 통과한다.")
    void 스탯합_200_정상() {
        new Player(60, 140, "TES");
    }


    @Test
    @DisplayName("5글자를 입력하면 통과한다.")
    void 다섯글자_이름_통과() {
        new Player(60, 140, "5글자이름");
    }

    @Test
    @DisplayName("6글자를 입력하면 예외가 발생한다.")
    void 다섯글자_이름_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Player(60, 140, "여섯글자이름"));
    }

    @Test
    @DisplayName("최대 MP 100을 초과해서 회복되지 않는다.")
    void Mp_초과시_그대로() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        player.addMpAs(10);
        //then
        assertThat(player.getMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("최대 MP 100을 초과해서 회복되지 않는다.")
    void Mp_정상적으로_감소() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        player.addMpAs(-20);
        //then
        assertThat(player.getMp()).isEqualTo(80);
    }

    @Test
    @DisplayName("최소 MP 0을 이하로 떨어지지 않는다.")
    void Mp_0미만으로_감소X() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        player.addMpAs(-110);
        //then
        assertThat(player.getMp()).isEqualTo(0);
    }

    @Test
    @DisplayName("최대 MP 초과해서 회복 하지 않는다.")
    void Mp_최대_초과_회복X() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        player.addMpAs(-20);
        player.addMpAs(30);
        //then
        assertThat(player.getMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("AttackType을 1번으로 등록하면 Normal이 호출된다.")
    void PlayerTest() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        player.setAttackType(1);
        //then
    }


}