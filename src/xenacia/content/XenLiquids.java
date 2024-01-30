package xenacia.content;

import arc.graphics.*;
import mindustry.type.*;

public class XenLiquids{
    public static Liquid
            xenWater, steam, xenOil, xenOxygen, xenHydrogen, liquidNitrogen, magma, volatlite;

    public static void load(){
        xenWater = new Liquid("xen-fluid-water", Color.valueOf("486acd")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        steam = new Liquid("fluid-steam", Color.valueOf("e9f8f9")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        xenOil = new Liquid("xen-fluid-oil", Color.valueOf("313131")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        xenOxygen = new Liquid("xenfluid-oxygen", Color.valueOf("ffbdd4")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        xenHydrogen = new Liquid("xen-fluid-hydrogen", Color.valueOf("d1e4ff")){{
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
