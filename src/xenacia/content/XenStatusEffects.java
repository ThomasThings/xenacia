package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.type.StatusEffect;

public class XenStatusEffects{
    public static StatusEffect doubleclock, quadclock, superclock, hyperclock;

    public static void load(){

        doubleclock = new StatusEffect("doubleclock"){{
            color = Color.valueOf("c4c1ee");
            healthMultiplier = 2f;
            speedMultiplier = 2f;
            damageMultiplier = 2f;
            reloadMultiplier = 2f;
            effect = Fx.overclocked;
        }};
        quadclock = new StatusEffect("quadclock"){{
            color = Color.valueOf("e3897a");
            healthMultiplier = 4f;
            speedMultiplier = 4f;
            damageMultiplier = 4f;
            reloadMultiplier = 4f;
            effect = Fx.overclocked;
        }};
        superclock = new StatusEffect("superclock"){{
            color = Color.valueOf("836eab");
            healthMultiplier = 8f;
            speedMultiplier = 8f;
            damageMultiplier = 8f;
            reloadMultiplier = 8f;
            effect = Fx.overclocked;
        }};
        hyperclock = new StatusEffect("hyperclock"){{
            color = Color.valueOf("71d299");
            healthMultiplier = 15f;
            speedMultiplier = 15f;
            damageMultiplier = 15f;
            reloadMultiplier = 15f;
            effect = Fx.overclocked;
        }};
    }
}