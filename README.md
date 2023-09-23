# 미션 - 보스 몬스터 잡기 

---

## 🚀 기능 요구사항

### 도메인 요구사항
Entity(Abstract)

  - [ ] Hp를 가진다.
  - [ ] DecreaseHp 함수를 가진다.
  - [ ] Die 함수를 가진다.

Enum AttackType
- [ ] Normal Attack (물리 공격)
- [ ] Magical Attack(마법 공격)


Attackable(Interface)
-[ ] attack()을 가진다.
-[ ] attack(AttackType을 가짐)





Player - Entity 자식
  - [ ] 생성될 때 (name, HP,MP)를 입력으로 가져야한다.
    - [ ] HP + MP = 200여야 한다.
  - [ ] name을 가진다.
  - [ ] MP를 가진다.
  - [ ] attackable 구현체를 가진다.
    - [ ] 공격을 할때 물리공격과 마법 공격으로 나뉜다.
    - [ ] 1번은 물리 공격
        - [ ] 물리 공격을 하면 MP 10 회복
            - [ ] 최대 MP 초과해서는 회복되지 않는다.
        - [ ] 데미지 10
    - [ ] 2번은 마법 공격
        - [ ] 마법 공격을 하면 MP 30 감소
        - [ ] 데미지 20


Boss - Entity 자식
  - [ ] 생성될 때 (HP)를 생성자로 받는다.
    - [ ] HP는 100 ~ 300  사이여야 한다. 
  - [ ] attack()을 0 ~ 20의 랜덤 데미지를 주도록 구현한다.
  - [ ] Attackable 인터페이스를 구현한다.
    - [ ] attack()을 0 ~ 20의 랜덤 데미지를 주도록 구현한다.


BattleResult
- [ ] Player와 Boss를 의존성 주입 받는다.
- [ ] BattleCount 를 가진다.
- [ ] isPlayerWin을 가진다.

### 서비스 레이어
Battle Service(Inferface)
- [ ] 생성자 주입을 통해 배틀 방식 중 하나를 입력받는다.
- [ ] next() 다음 배틀을 가진다.


PlayerFirstBattleService(BattleService 구현체)
- [ ] next()를 플레이어가 선 공격하도록 구현한다.

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
- [ ] 게임 시작 전 
<div>

    보스 몬스터의 HP를 입력해주세요.
    100

    플레이어의 이름을 입력해주세요
    dori
    
    플레이어의 HP와 MP를 입력해주세요.(,로 구분)
    100,100
    
    보스 레이드를 시작합니다!
</div>

- [ ] 게임 진행 중 
<div>

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

