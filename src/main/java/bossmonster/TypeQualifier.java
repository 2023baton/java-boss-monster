package bossmonster;

import bossmonster.domain.creatures.Creature;

public class TypeQualifier {
    public static boolean checkCreatureType(Class<? extends Creature> checkType, Creature checked) {
        try {
            Class<? extends Creature> subclass = checked.getClass().asSubclass(checkType);
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }
}
