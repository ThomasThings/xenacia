package redux.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class ReduxLiquids{
    public static Liquid water;

    public static void load(){

        water = new Liquid("azure", Color.valueOf("486acd")){{
            viscosity = 0.35f;
            flammability = 0f;
            explosiveness = 0f;
            heatCapacity = 0.7f;
            effect = StatusEffects.wet;
        }};
    }
}