package bossmonster;

import bossmonster.domain.creatures.Creature;

public class TypeQualifier {
    public static <T extends Creature> boolean checkCreatureType(T checkType) {
        return (checkType != null);
    }
}
