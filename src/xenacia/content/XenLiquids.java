package xenacia.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class XenLiquids{
    public static Liquid
    hydrex;
    public static void load(){
        hydrex = new Liquid("hydrex", Color.valueOf("597fb8")){{
            heatCapacity = 0.45f;
            effect = StatusEffects.wet;
            boilPoint = 0.5f;
            gasColor = Color.grays(0.9f);
            alwaysUnlocked = true;
        }};
    }
}
