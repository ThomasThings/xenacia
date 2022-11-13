package prime.content;

import arc.graphics.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;
import mindustry.content.*;

public class PSEnvironment{
    public static Block
            magmaFloor, magmaRock, magmaticCrack, volcanicRock, volcanicRockWall,
            scorchedSoil, scorchedSoilWall, scorchedSand, scorchedSandWall,
            wetMarsh, marsh, marshWall,
            ash, ashWall, pumice, pumiceWall, meteor, meteorWall,
            lunarRegolith, lunarRegolithWall, lunarCraters, lunarCratersWall;
    public static void load(){
        //volcanic
        magmaFloor = new Floor("magma-floor"){{
            speedMultiplier = 0.2f;
            liquidDrop = PSLiquids.magma;
            liquidMultiplier = 1f;
            isLiquid = true;
            status = StatusEffects.melting;
            statusDuration = 300f;
            drownTime = 300f;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.heat, 2f);

            emitLight = true;
            lightRadius = 80f;
            lightColor = Color.orange.cpy().a(0.5f);
        }};
        magmaRock = new Floor("magma-rock"){{
            speedMultiplier = 0.9f;
            variants = 3;
            status = StatusEffects.melting;
            statusDuration = 120f;
            liquidDrop = PSLiquids.magma;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;

            emitLight = true;
            lightRadius = 55f;
            lightColor = Color.orange.cpy().a(0.35f);
        }};
        magmaticCrack = new Floor("magmatic-crack"){{
            liquidDrop = PSLiquids.magma;
            liquidMultiplier = 0.4f;
            status = StatusEffects.burning;
            statusDuration = 120f;
            attributes.set(Attribute.heat, 0.8f);

            emitLight = true;
            lightRadius = 25f;
            lightColor = Color.orange.cpy().a(0.2f);
        }};
        volcanicRock = new Floor("volcanic-rock");
        volcanicRockWall = new StaticWall("volcanic-rock-wall");
        //scorched
        scorchedSoil = new Floor("scorched-soil");
        scorchedSoilWall = new StaticWall("scorched-soil-wall");
        scorchedSand = new Floor("scorched-sand");
        scorchedSandWall = new StaticWall("scorched-sand-wall");
        //marsh
        wetMarsh = new Floor("wet-marsh"){{
            speedMultiplier = 0.85f;
            variants = 1;
            status = StatusEffects.wet;
            statusDuration = 90f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        marsh = new Floor("marsh"){{
            itemDrop = PSItems.peat;
            playerUnmineable = true;
            attributes.set(Attribute.water, 0.5f);
        }};
        marshWall = new StaticWall("marsh-wall"){{
            itemDrop = PSItems.peat;
            playerUnmineable = true;
        }};
        //misc
        ash = new Floor("ash");
        ashWall = new StaticWall("ash-wall");
        pumice = new Floor("pumice");
        pumiceWall = new StaticWall("pumice-wall");
        meteor = new Floor("meteor"){{
            itemDrop = PSItems.meteorFragment;
            playerUnmineable = true;
        }};
        meteorWall = new StaticWall("meteor-wall"){{
            itemDrop = PSItems.meteorFragment;
            playerUnmineable = true;
        }};
        //lunar
        lunarRegolith = new Floor("lunar-regolith-floor"){{
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarRegolithWall = new StaticWall("lunar-regolith-wall"){{
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarCraters = new Floor("lunar-craters"){{
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarCratersWall = new StaticWall("lunar-craters-wall"){{
            itemDrop = PSItems.lunarRegolith;
            playerUnmineable = true;
        }};

    }
}