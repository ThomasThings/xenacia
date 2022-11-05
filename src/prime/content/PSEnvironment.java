package prime.content;

import arc.graphics.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;
import mindustry.content.*;

public class PSEnvironment{
    public static Block
            magmaFloor, magmaRock, magmaticCrack, lunarRegolith, lunarCraters, lunarRegolithWall, lunarCratersWall;

    public static void load(){
        //Liquids and Liquid Floors
        magmaFloor = new Floor("magma-floor"){{
            speedMultiplier = 0.2f;
            variants = 3;
            liquidDrop = PSLiquids.magma;
            liquidMultiplier = 1f;
            isLiquid = true;
            status = StatusEffects.melting;
            statusDuration = 300f;
            drownTime = 300f;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.heat, 2f);

            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.orange.cpy().a(0.5f);
        }};
        magmaRock = new Floor("magma-rock"){{
            speedMultiplier = 0.8f;
            variants = 3;
            liquidDrop = PSLiquids.magma;
            liquidMultiplier = 0.7f;
            status = StatusEffects.melting;
            statusDuration = 180f;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.heat, 1.5f);

            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.orange.cpy().a(0.35f);
        }};
        magmaticCrack = new Floor("magmatic-crack"){{
            variants = 3;
            liquidDrop = PSLiquids.magma;
            liquidMultiplier = 0.4f;
            status = StatusEffects.burning;
            statusDuration = 120f;
            attributes.set(Attribute.heat, 0.8f);

            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.orange.cpy().a(0.2f);
        }};
        //Floors
        lunarRegolith = new Floor("lunar-regolith-floor"){{
            variants = 3;
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarCraters = new Floor("lunar-craters"){{
            variants = 3;
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};
        //Walls
        lunarRegolithWall = new Floor("lunar-regolith-wall"){{
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarCratersWall = new Floor("lunar-craters-wall"){{
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};

    }
}