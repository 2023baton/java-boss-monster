package bossmonster.domain.creatures;

import bossmonster.domain.attack.AttackEntity;
import bossmonster.domain.attack.AttackType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {
    @Test
    @DisplayName("hp와 mp의 합이 200을 초과하면 예외가 발생한다.")
    void 스탯합_200_초과() {
        assertThrows(IllegalArgumentException.class,
                () -> new Player(100, 200, "TEST1"));
    }

    @Test
    @DisplayName("hp와 mp이 200합이 미만이면 예외가 발생한다.")
    void 스탯합_200_미만() {
        assertThrows(IllegalArgumentException.class,
                () -> new Player(100, 99, "TEST2"));
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
        assertThrows(IllegalArgumentException.class,
                () -> new Player(60, 140, "여섯글자이름"));
    }

    @Test
    @DisplayName("최대 MP 100을 초과해서 회복되지 않는다.")
    void Mp_초과시_그대로() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        //player.addMpAs(10);
        //then
        assertThat(player.getMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("최대 MP 100을 초과해서 회복되지 않는다.")
    void Mp_정상적으로_감소() {
        //given
        Player player = new Player(100, 100, "test1");
        AttackEntity attackEntity = AttackEntity.createAttack(AttackType.NORMAL);
        //when
        player.attack(attackEntity, player);
        //then
        assertThat(player.getMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("마나가 없을 때 사용하려고 하면 예외가 발생한다.")
    void Mp_부적절_예외_발생() {
        //given
        Player player = new Player(200, 0, "test1");
        //when
        AttackEntity attackEntity = AttackEntity.createAttack(AttackType.MAGIC);
        //then
        assertThrows(IllegalArgumentException.class, () -> player.attack(attackEntity, player));
    }

    @Test
    @DisplayName("마법을 사용했다가 다시 물리공격을 사용하면 결과적으로 20만 사용됐어야한다.")
    void Mp_회복_정상() {
        //given
        Player player = new Player(100, 100, "test1");
        //when
        AttackEntity attackEntity = AttackEntity.createAttack(AttackType.MAGIC);
        player.attack(attackEntity, player);
        attackEntity = AttackEntity.createAttack(AttackType.NORMAL);
        player.attack(attackEntity, player);
        //then
        assertThat(player.getMp()).isEqualTo(80);
    }


}