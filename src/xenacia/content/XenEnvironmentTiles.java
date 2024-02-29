package xenacia.content;

import arc.graphics.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;
import mindustry.content.*;

public class XenEnvironmentTiles{
    public static Block
            //bankstone
            bankstoneFloor, bankstoneWall,
            //volcanic
            magmaFloor, magmaRock, magmaCrack, volcanicRock, volcanicBoulder, volcanicRockWall, magmaVent, volcanicVent,
            //scorched soil
            scorchedSoil, scorchedSoilBoulder, scorchedShrub, scorchedSoilWall,
             //scorched sand
            scorchedSand, scorchedSandBoulder, scorchedSandWall,
            //marsh
            deepMarsh, wetMarsh, marsh, marshWall,
            //misc env
            ash, ashWall, pumice, pumiceWall,
            //lunar
            lunarRegolith, lunarRegolithWall, lunarCraters, lunarCratersWall,
            //ores
            oreIron, oreAluminum, orePeat, oreLithium, oreNeodymium, oreCobalt, oreChronatintilium;
    public static void load(){
        //bankstone
        bankstoneFloor = new Floor("bankstone-floor"){{
            variants = 6;
            mapColor = Color.valueOf("b3b8c4");
        }};
        bankstoneWall = new StaticWall("bankstone-wall"){{
            variants = 4;
            mapColor = Color.valueOf("d1d6e0");
        }};
        //volcanic
        magmaFloor = new Floor("magma-floor"){{
            variants = 4;
            mapColor = Color.valueOf("f2a848");
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
            variants = 4;
            mapColor = Color.valueOf("db7448");
            speedMultiplier = 0.9f;
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
        magmaCrack = new Floor("magma-crack"){{
            variants = 4;
            mapColor = Color.valueOf("2b2726");
            liquidDrop = XenLiquids.magma;
            liquidMultiplier = 0.4f;
            status = StatusEffects.burning;
            statusDuration = 120f;
            attributes.set(Attribute.heat, 0.8f);

            emitLight = true;
            lightRadius = 25f;
            lightColor = Color.orange.cpy().a(0.2f);
        }};
        volcanicRock = new Floor("volcanic-rock"){{
            variants = 4;
            mapColor = Color.valueOf("2b2726");
        }};
        volcanicBoulder = new Prop("volcanic-boulder"){{
            variants = 5;
            magmaCrack.asFloor().decoration = volcanicRock.asFloor().decoration = this;
        }};
        magmaVent = new SteamVent("magma-vent"){{
            parent = blendGroup = volcanicRock;
            attributes.set(Attribute.steam, 1f);
            attributes.set(Attribute.heat, 3f);
        }};
        volcanicVent = new SteamVent("volcanic-vent"){{
            parent = blendGroup = volcanicRock;
            attributes.set(Attribute.steam, 1f);
        }};
        volcanicRockWall = new StaticWall("volcanic-rock-wall");

        //scorchedSoil
        scorchedSoil = new Floor("scorched-soil"){{
            variants = 4;
            mapColor = Color.valueOf("453838");
        }};
        scorchedSoilBoulder = new Prop("scorched-soil-boulder"){{
            variants = 3;
            scorchedSoil.asFloor().decoration = this;
        }};
        scorchedShrub = new Prop("scorched-shrub"){{
            variants = 3;
            scorchedSoil.asFloor().decoration = this;
        }};
        scorchedSoilWall = new StaticWall("scorched-soil-wall");

        //scorchedSand
        scorchedSand = new Floor("scorched-sand"){{
            variants = 4;
            mapColor = Color.valueOf("3f3b3b");
        }};
        scorchedSandBoulder = new Prop("scorched-sand-boulder"){{
            variants = 3;
            scorchedSand.asFloor().decoration = this;
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
            itemDrop = XenItems.biomass;
            playerUnmineable = true;
            attributes.set(Attribute.water, 0.5f);
        }};
        marshWall = new StaticWall("marsh-wall"){{
            itemDrop = XenItems.biomass;
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

        //lunar
        lunarRegolith = new Floor("lunar-regolith-floor"){{
            mapColor = Color.valueOf("B7CBD0");
            playerUnmineable = true;
        }};
        lunarRegolithWall = new StaticWall("lunar-regolith-wall"){{
        }};
        lunarCraters = new Floor("lunar-craters"){{
            playerUnmineable = true;
        }};
        lunarCratersWall = new StaticWall("lunar-craters-wall"){{
        }};

        //ores
        oreIron = new OreBlock(XenItems.iron);
        oreAluminum = new OreBlock(XenItems.aluminum);
        orePeat = new OreBlock(XenItems.biomass);
        oreLithium = new OreBlock(XenItems.lithium);
        oreNeodymium = new OreBlock(XenItems.neodymium);
        oreCobalt = new OreBlock(XenItems.cobalt);
        oreChronatintilium = new OreBlock(XenItems.chronatintilium);
    }
}
