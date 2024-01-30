package xenacia.content;

import arc.graphics.*;
import mindustry.type.*;

public class XenLiquids{
    public static Liquid
            water, steam, oil, oxygen, hydrogen, liquidNitrogen, magma, volatlite;

    public static void load(){
        water = new Liquid("fluid-water", Color.valueOf("486acd")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        steam = new Liquid("fluid-steam", Color.valueOf("e9f8f9")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        oil = new Liquid("fluid-oil", Color.valueOf("313131")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        oxygen = new Liquid("fluid-oxygen", Color.valueOf("ffbdd4")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        hydrogen = new Liquid("fluid-hydrogen", Color.valueOf("d1e4ff")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        liquidNitrogen = new Liquid("fluid-liquid-nitrogen", Color.valueOf("e4d6f6")){{
            temperature = 0.6f;
            flammability = 2f;
            explosiveness = 3f;
            viscosity = 0.3f;
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
           viscosity = 0.3f;
        }};
    }
}
