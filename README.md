# 미션 - 보스 몬스터 잡기

---

## 🚀 기능 요구사항

### 도메인 요구사항

Creature(Abstract)

- [x] totalHp를 가진다.
- [x] totalMp를 가진다.
- [x] mp를 가진다.
- [x] Hp를 가진다.
    - [x] 체력이 0이 되면 dead 상태가 된다.
- [x] DecreaseHp 함수를 가진다.
- [x] bool dead를 가진다.

  Enum AttackType
- [x] 공격 종류, 데미지, 공격 번호를 가진다.
- [x] Normal Attack (물리 공격), 데미지 10, 마나 소모량 -10
- [x] Magical Attack(마법 공격), 데미지 20, 마나 소모량 30

AttackEntity

- [x] 매개변수로 Attacker, Attacked, AttackType을 가진다.
-

-[x] AttackBuilder 클래스를 통해 생성한다.
    - [x] 매개변수로 데미지, AttackType, mpCost를 가진다.
        - [x] 데미지는 필수, AttackType, mpCost는 선택 매개변수
            - [x] AttackType = Normal, mpCost = 0 을 기본값으로 한다.

Player - Entity 자식

- [x] 생성될 때 (name, HP,MP)를 입력으로 가져야한다.
    - [x] HP + MP = 200여야 한다.
- [x] name을 가진다.
    - [x] 5글자 이하의 이름을 가져야한다.

Boss - Entity 자식

- [x] 생성될 때 (HP)를 생성자로 받는다.
    - [x] HP는 100 ~ 300 사이여야 한다.
- [x] attack()을 0 ~ 20의 랜덤 데미지를 주도록 구현한다.

- [ ] RoundBattle(추상클래스)

- [x] List<AttackEntity>을 의존받는다.
- [x] BattleRound 를 가진다.
- [x] isGameEnd를 가진다.
- [x] attack을 가진다.
- [x] nextRound() 다음 라운드 전투 시작하는 추상 메서드

- [ ]BattlePriority(인터페이스) : 공격 우선순위를 선정하는 방식을 가지고있다.

- setAttackQueueOrder로 순서를 정하는 함수를 가짐

PlayerPriorityBattle : 추상클래스와 인터페이스 구현체

- [ ] nextRound()
    - [ ] 플레이어가 먼저 공격한다.
    - [ ] 보스는 체력이 0이 된다면 공격할 수 없다.
    - [ ] Round+1
    - [ ]

BattleRule(인터페이스) : 레이드 방식을 가지고 있는 인터페이스

- [ ] 

### 컨트롤러

- [ ] FrontController : 해당 컨트롤러가 다른 컨트롤러를 매핑해줌

- [ ] StartController : GameStartOutputView와 GameStartInputView를 호출

- [ ] BattleController : BattleInputView와 BattleOutputView를 호출

- [ ] ResultController : ResultInputView와 ResultOutputView를 호출

### 입력 요구사항

- [ ] 보스 몬스터의 HP를 입력받는다.
- [ ] 플레이어의 이름을 입력받는다.
    - [ ] 5글자 이하로 입력받는다.


- [ ] 플레이어의 HP와 MP를 입력받는다.
    - [ ] 숫자와 , 이외에 아무것도 들어오면 안된다.
    - [ ] 공백이 들어오면 trim 한다.
    - [ ] ,를 기점으로 구분한다.


- [ ] 물리 공격, 마법 공격을 선택한다.
    - [ ] 1 또는 2 이외에 다른 것이 들어오면 예외를 발생시킨다.
    - [ ] 띄어쓰기는 무시하도록 만든다

### 출력 요구사항

- [x] ProgressOutputView : 보스와 플레이어의 체력, 보스의 모습을 그리는 뷰
    - [x] 보스의 체력/최대 체력을 출력한다.
        - [x] Boss 클래스가 아니라면 예외 발생
    - [x] 플레이어의 이름, 체력/최대 체력, mp/최대 mp를 출력한다.
        - [x] Player 클래스가 아니라면 예외 발생
- [ ] WinResultOutputView : 플레이어가 이겼을 때 결과를 그리는 뷰
- [ ] LoseResultOutputView : 플레이어가 졌을 때 결과를 그리는 뷰
- [ ] BattleOutputView : 전투 중을 그리는 뷰
- [ ] TextOutputView : 텍스트를 출력하는

<div>

    보스 몬스터의 HP를 입력해주세요.
    100

    플레이어의 이름을 입력해주세요
    dori
    
    플레이어의 HP와 MP를 입력해주세요.(,로 구분)
    100,100
    
    보스 레이드를 시작합니다!
    ============================
    BOSS HP [100/100]
    ____________________________
    ^-^
    / 0 0 \
    (   "   )
    \  -  /
    - ^ -
    ____________________________
    
    dori HP [100/100] MP [100/100]
    ============================

</div>

- [ ] 게임 진행 중

<div>

    어떤 공격을 하시겠습니까?
    1. 물리 공격
    2. 마법 공격
    2
    
    마법 공격을 했습니다. (입힌 데미지: 20)
    보스가 공격 했습니다. (입힌 데미지: 0)

    ============================
    BOSS HP [60/100]
    ____________________________
        ^-^
      / x x \
     (   "\  )
      \  ^  /
       - ^ -
    ____________________________

    dori HP [85/100] MP [40/100]
    ============================

</div>

- [ ] 게임 끝난 결과 - 성공시

<div>

    dori 님이 6번의 전투 끝에 보스 몬스터를 잡았습니다.

</div>

- [ ] 게임 끝난 결과 - 실패 시

<div>

    ============================
    BOSS HP [290/300]
    ____________________________
       ^-^
     / ^ ^ \
    (   "   )
     \  3  /
      - ^ -
    ____________________________
    
    dori HP [0/10] MP [190/190]
    ============================
    
    dori의 HP가 0이 되었습니다.
    보스 레이드에 실패했습니다.

</div>

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.


- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다. (예외 메시지는 예외 상황에 맞도록 자유롭게 정한다.)

## 🎱 프로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth 2까지만 허용
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있습니다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 노력합니다.

