package xenacia.content;

import arc.graphics.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;
import mindustry.content.*;

public class XenEnvironmentTiles{
    public static Block
            //magmatic
            magmaFloor, magmaRock, magmaticCrack, volcanicRock, volcanicRockWall,
            //scorched
            scorchedSoil, scorchedSoilWall, scorchedSand, scorchedSandWall,
            //marsh
            deepMarsh, wetMarsh, marsh, marshWall,
            //misc env
            ash, ashWall, pumice, pumiceWall, meteor, meteorWall,
            //lunar
            lunarRegolith, lunarRegolithWall, lunarCraters, lunarCratersWall,
            //ores
            oreIron, oreAluminum, orePeat, oreLithium, oreAmethyst, orePolonium, oreNeodymium, oreCobalt;
    public static void load(){
        //volcanic
        magmaFloor = new Floor("magma-floor"){{
            speedMultiplier = 0.2f;
            liquidDrop = XenLiquids.magma;
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
            liquidDrop = XenLiquids.magma;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;

            emitLight = true;
            lightRadius = 55f;
            lightColor = Color.orange.cpy().a(0.35f);
        }};
        magmaticCrack = new Floor("magmatic-crack"){{
            liquidDrop = XenLiquids.magma;
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
        scorchedSoil = new Floor("scorched-soil"){{
             mapColor = Color.valueOf("292725");
        }};
        scorchedSoilWall = new StaticWall("scorched-soil-wall");
        scorchedSand = new Floor("scorched-sand"){{
            mapColor = Color.valueOf("2A2826");
        }};
        scorchedSandWall = new StaticWall("scorched-sand-wall");
        //marsh env
        wetMarsh = new Floor("wet-marsh"){{
            speedMultiplier = 0.85f;
            variants = 3;
            status = StatusEffects.wet;
            statusDuration = 90f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        deepMarsh = new Floor("deep-marsh"){{
            speedMultiplier = 0.5f;
            variants = 3;
            status = StatusEffects.wet;
            statusDuration = 90f;
            drownTime = 200f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        marsh = new Floor("marsh"){{
            itemDrop = XenItems.peat;
            playerUnmineable = true;
            attributes.set(Attribute.water, 0.5f);
        }};
        marshWall = new StaticWall("marsh-wall"){{
            itemDrop = XenItems.peat;
            playerUnmineable = true;
        }};
        //misc
        ash = new Floor("ash"){{
             mapColor = Color.valueOf("6D7478");
        }};
        ashWall = new StaticWall("ash-wall");
        pumice = new Floor("pumice"){{
             mapColor = Color.valueOf("50565A");
        }};
        pumiceWall = new StaticWall("pumice-wall");
        meteor = new Floor("meteor"){{
            itemDrop = XenItems.meteorFragment;
            playerUnmineable = true;
        }};
        meteorWall = new StaticWall("meteor-wall"){{
            itemDrop = XenItems.meteorFragment;
            playerUnmineable = true;
        }};
        //lunar
        lunarRegolith = new Floor("lunar-regolith-floor"){{
            mapColor = Color.valueOf("B7CBD0");
            itemDrop = XenItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarRegolithWall = new StaticWall("lunar-regolith-wall"){{
            itemDrop = XenItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarCraters = new Floor("lunar-craters"){{
            mapColor = Color.valueOf("B1C4C9");
            itemDrop = XenItems.lunarRegolith;
            playerUnmineable = true;
        }};
        lunarCratersWall = new StaticWall("lunar-craters-wall"){{
            itemDrop = XenItems.lunarRegolith;
            playerUnmineable = true;
        }};
        //ores
        oreIron = new OreBlock(XenItems.iron);
        oreAluminum = new OreBlock(XenItems.aluminum);
        orePeat = new OreBlock(XenItems.peat);
        oreLithium = new OreBlock(XenItems.lithium);
        oreAmethyst = new OreBlock(XenItems.amethyst);
        orePolonium = new OreBlock(XenItems.polonium);
        oreNeodymium = new OreBlock(XenItems.neodymium);
        oreCobalt = new OreBlock(XenItems.cobalt);
    }
}
