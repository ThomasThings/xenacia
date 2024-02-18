package xenacia.content;

import arc.graphics.Color;
import arc.struct.ObjectSet;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class XenLiquids{
    public static Liquid
            magma, liquidNitrogen, volatlite, steam;

    public static void load(){
        magma = new Liquid("magma", Color.valueOf("db7448")){{
            gasColor = Color.valueOf("db7448");
            barColor = Color.valueOf("db7448");
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
            capPuddles = true;
            vaporEffect = Fx.vapor;
            hidden = false;
            canStayOn = new ObjectSet<>();
        }};
        liquidNitrogen = new Liquid("liquid-nitrogen", Color.valueOf("e4d6f6")){{
            gas = false;
            gasColor = Color.valueOf("db7448");
            barColor = Color.valueOf("db7448");
            lightColor = Color.valueOf("db7448");
            flammability = 0;
            temperature = 0.5f;
            heatCapacity = 0.8f;
            viscosity = 1f;
            explosiveness = 1;
            blockReactive = true;
            coolant = false;
            moveThroughBlocks = false;
            incinerable = true;
            effect = StatusEffects.none;
            particleEffect = Fx.none;
            particleSpacing = 60f;
            boilPoint = 2f;
            capPuddles = true;
            vaporEffect = Fx.vapor;
            hidden = false;
            canStayOn = new ObjectSet<>();
        }};
        volatlite = new Liquid("volatlite", Color.valueOf("7480c3")){{
            gas = false;
            gasColor = Color.valueOf("db7448");
            barColor = Color.valueOf("db7448");
            lightColor = Color.valueOf("db7448");
            flammability = 0;
            temperature = 0.5f;
            heatCapacity = 0.8f;
            viscosity = 1f;
            explosiveness = 1;
            blockReactive = true;
            coolant = false;
            moveThroughBlocks = false;
            incinerable = true;
            effect = StatusEffects.none;
            particleEffect = Fx.none;
            particleSpacing = 60f;
            boilPoint = 2f;
            capPuddles = true;
            vaporEffect = Fx.vapor;
            hidden = false;
            canStayOn = new ObjectSet<>();
        }};
        steam = new Liquid("steam", Color.valueOf("e9f8f9")){{
            gas = false;
            gasColor = Color.valueOf("db7448");
            barColor = Color.valueOf("db7448");
            lightColor = Color.valueOf("db7448");
            flammability = 0;
            temperature = 0.5f;
            heatCapacity = 0.8f;
            viscosity = 1f;
            explosiveness = 1;
            blockReactive = true;
            coolant = false;
            moveThroughBlocks = false;
            incinerable = true;
            effect = StatusEffects.none;
            particleEffect = Fx.none;
            particleSpacing = 60f;
            boilPoint = 2f;
            capPuddles = true;
            vaporEffect = Fx.vapor;
            hidden = false;
            canStayOn = new ObjectSet<>();
        }};
    }
}
