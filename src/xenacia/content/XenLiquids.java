package xenacia.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class XenLiquids{
    public static Liquid
            steam, liquidNitrogen, magma, volatlite;

    public static void load(){
        steam = new Liquid("fluid-steam", Color.valueOf("e9f8f9")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        liquidNitrogen = new Liquid("fluid-liquid-nitrogen", Color.valueOf("e4d6f6")){{
            temperature = 0f;
            viscosity = 0.2f;
        }};
        magma = new Liquid("fluid-magma", Color.valueOf("db7448")){{
            temperature = 3f;
            viscosity = 0.8f;
            incinerable = false;
            gasColor = Color.valueOf("ffcb89");
        }};
        volatlite = new Liquid("fluid-volatlite", Color.valueOf("7480c3")){{
           temperature = 0.6f;
           flammability = 2f;
           explosiveness = 3f;
           viscosity = 0.2f;
        }};
    }
}
