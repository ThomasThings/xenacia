package xenacia.content;

import arc.graphics.Color;
import arc.struct.ObjectSet;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class XenLiquids{
    public static Liquid
            magma, liquidNitrogen, vurtux, steam;

    public static void load(){
        magma = new Liquid("magma", Color.valueOf("db7448")){{
            lightColor = Color.valueOf("db7448");

            flammability = 0;
            temperature = 0.5f;
            heatCapacity = 0.8f;
            viscosity = 1f;
            explosiveness = 0;

            blockReactive = true;
            coolant = false;
            moveThroughBlocks = false;
            incinerable = true;
            effect = XenStatusEffects.magmaCoated;
            particleEffect = Fx.fuelburn;
            particleSpacing = 60f;
        }};
        liquidNitrogen = new Liquid("liquid-nitrogen", Color.valueOf("e4d6f6")){{
            lightColor = Color.valueOf("e4d6f6");

            temperature = -2f;
            heatCapacity = 1.5f;
            viscosity = 0.1f;

            coolant = true;
            moveThroughBlocks = false;
            incinerable = true;
            effect = StatusEffects.freezing;
            boilPoint = 0.1f;
        }};
        vurtux = new Liquid("vurtux", Color.valueOf("7480c3")){{
            lightColor = Color.valueOf("db7448");

            flammability = 0;
            temperature = 0.5f;
            explosiveness = 1;

            blockReactive = true;
            coolant = false;
            incinerable = false;
            effect = XenStatusEffects.volatileEffect;
            boilPoint = 1.5f;
            vaporEffect = Fx.vapor;
            hidden = false;
            canStayOn = new ObjectSet<>();
        }};
        steam = new Liquid("steam", Color.valueOf("e9f8f9")){{
            gas = true;
            lightColor = Color.valueOf("db7448");
            temperature = 0.5f;
            heatCapacity = 0.8f;
            viscosity = 1f;
            explosiveness = 0.3f;
            coolant = false;
            incinerable = true;
            effect = StatusEffects.none;
            capPuddles = true;
            vaporEffect = Fx.vapor;
        }};
    }
}
