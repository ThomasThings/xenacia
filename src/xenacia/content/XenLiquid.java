package xenacia.content;

import arc.graphics.*;
import mindustry.type.*;

public class XenLiquids{
    public static Liquid azure;

    public static void load(){

        azure = new Liquid("azure", Color.valueOf("554b7a")){{
            viscosity = 0.35f;
            flammability = 0.4f;
            explosiveness = 0.2f;
            heatCapacity = 0.7f;
            barColor = Color.valueOf("554b7a");
            effect = XenStatusEffects.doubleclock;
        }};
    }
}