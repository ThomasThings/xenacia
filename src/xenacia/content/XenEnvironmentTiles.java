package xenacia.content;

import arc.graphics.Color;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.meta.Attribute;

public class XenEnvironmentTiles{
    public static Block
            lendesiteFloor, deepLendesiteFloor, slashedLendesiteFloor, deepSlashedLendesiteFloor, lendesiteWall, lendesiteBoulder,
            kryesenFloor, deepKryesenFloor, kryesenWall, kryesenBoulder,
            asuralineFloor, deepAsuralineFloor, asuralineWall, asuralineBoulder,
            azureFloor,
            asulariteFloor, deepAsulariteFloor, asulariteWall, asulariteBoulder,
            dolstoneFloor, deepDolstoneFloor, dolstoneWall, dolstoneBoulder,
            veillineFloor, deepVeillineFloor, veillineWall,
            vidriteFloor, deepVidriteFloor, vidriteWall, vidriteBoulder,
            derilectFloor, damagedDerilectFloor, deepDerilectFloor, damagedDeepDerilectFloor, studdedDerilectFloor, platedDerilectFloor,
            markedDerilectFloor, damagedMarkedDerilectFloor, deepMarkedDerilectFloor, damagedDeepMarkedDerilectFloor, studdedMarkedDerilectFloor, platedMarkedDerilectFloor,

            hazardDerilectFloor, damagedHazardDerilectFloor, deepHazardDerilectFloor, damagedDeepHazardDerilectFloor, studdedHazardDerilectFloor, platedHazardDerilectFloor,
            oreAlamex, oreTorren, oreVeilla, veillaDolWall, wallOreAlamex, wallOreTorren;

    public static void load(){
        Attribute.add("stone");

        lendesiteFloor = new Floor("lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
        }};
        deepLendesiteFloor = new Floor("deep-lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
        }};
        slashedLendesiteFloor = new Floor("slashed-lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
        }};
        deepSlashedLendesiteFloor = new Floor("deep-slashed-lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
        }};
        lendesiteWall = new StaticWall("lendesite-wall"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
        }};
        lendesiteBoulder = new Prop("lendesite-boulder"){{
            variants = 5;
            lendesiteFloor.asFloor().decoration = this;
            deepLendesiteFloor.asFloor().decoration = this;
            slashedLendesiteFloor.asFloor().decoration = this;
            deepSlashedLendesiteFloor.asFloor().decoration = this;
        }};

        kryesenFloor = new Floor("kryesen-floor"){{
            variants = 4;
            mapColor = Color.valueOf("788ac0");
        }};
        deepKryesenFloor = new Floor("deep-kryesen-floor"){{
            variants = 4;
            mapColor = Color.valueOf("788ac0");
        }};
        kryesenWall = new StaticWall("kryesen-wall"){{
            variants = 3;
            mapColor = Color.valueOf("788ac0");
        }};
        kryesenBoulder = new Prop("kryesen-boulder"){{
            variants = 2;
            kryesenFloor.asFloor().decoration = this;
            deepKryesenFloor.asFloor().decoration = this;
        }};

        asuralineFloor = new Floor("asuraline-floor"){{
            variants = 4;
            mapColor = Color.valueOf("4e4067");
        }};
        deepAsuralineFloor = new Floor("deep-asuraline-floor"){{
            variants = 4;
            mapColor = Color.valueOf("4e4067");
        }};
        asuralineWall = new StaticWall("asuraline-wall"){{
            variants = 3;
            mapColor = Color.valueOf("4e4067");
        }};
        asuralineBoulder = new Prop("asuraline-boulder"){{
            variants = 2;
            asuralineFloor.asFloor().decoration = this;
            deepAsuralineFloor.asFloor().decoration = this;
        }};

        azureFloor = new Floor("azure-floor"){{
            speedMultiplier = 0.5f;
            variants = 0;
            status = XenStatusEffects.doubleclock;
            statusDuration = 90f;
            liquidDrop = XenLiquids.azure;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};

        asulariteFloor = new Floor("asularite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("3a314b");
        }};
        deepAsulariteFloor = new Floor("deep-asularite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("3a314b");
        }};
        asulariteWall = new StaticWall("asularite-wall"){{
            variants = 3;
            mapColor = Color.valueOf("3a314b");
        }};
        asulariteBoulder = new Prop("asularite-boulder"){{
            variants = 2;
            asulariteFloor.asFloor().decoration = this;
            deepAsulariteFloor.asFloor().decoration = this;
        }};

        dolstoneFloor = new Floor("dolstone-floor"){{
            variants = 4;
            mapColor = Color.valueOf("23282d");
        }};
        deepDolstoneFloor = new Floor("deep-dolstone-floor"){{
            variants = 4;
            mapColor = Color.valueOf("23282d");
        }};
        dolstoneWall = new StaticWall("dolstone-wall"){{
            variants = 3;
            mapColor = Color.valueOf("23282d");
        }};
        dolstoneBoulder = new Prop("dolstone-boulder"){{
            variants = 3;
            dolstoneFloor.asFloor().decoration = this;
            deepDolstoneFloor.asFloor().decoration = this;
        }};

        veillineFloor = new Floor("veilline-floor"){{
            variants = 16;
            mapColor = Color.valueOf("c4c1ee");
        }};
        deepVeillineFloor = new Floor("deep-veilline-floor"){{
            variants = 16;
            mapColor = Color.valueOf("9e8dd8");
        }};
        veillineWall = new StaticWall("veilline-wall"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
        }};

        vidriteFloor = new Floor("vidrite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("b95755");
        }};
        deepVidriteFloor = new Floor("deep-vidrite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("b95755");
        }};
        vidriteWall = new StaticWall("vidrite-wall"){{
            variants = 3;
            mapColor = Color.valueOf("b95755");
        }};
        vidriteBoulder = new Prop("vidrite-boulder"){{
            variants = 2;
            vidriteFloor.asFloor().decoration = this;
            deepVidriteFloor.asFloor().decoration = this;
        }};

        derilectFloor = new Floor("derilect-floor"){{
            mapColor = Color.valueOf("514656");
        }};
        damagedDerilectFloor = new Floor("damaged-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        deepDerilectFloor = new Floor("deep-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        damagedDeepDerilectFloor = new Floor("deep-damaged-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        studdedDerilectFloor = new Floor("studded-derilect-floor"){{
            variants = 1;
            mapColor = Color.valueOf("514656");
        }};
        platedDerilectFloor = new Floor("plated-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};

        markedDerilectFloor = new Floor("marked-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        damagedMarkedDerilectFloor = new Floor("damaged-marked-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        deepMarkedDerilectFloor = new Floor("deep-marked-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        damagedDeepMarkedDerilectFloor = new Floor("deep-damaged-marked-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        studdedMarkedDerilectFloor = new Floor("studded-marked-derilect-floor"){{
            variants = 1;
            mapColor = Color.valueOf("514656");
        }};
        platedMarkedDerilectFloor = new Floor("plated-marked-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};

        hazardDerilectFloor = new Floor("hazard-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        damagedHazardDerilectFloor = new Floor("damaged-hazard-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        deepHazardDerilectFloor = new Floor("deep-hazard-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        damagedDeepHazardDerilectFloor = new Floor("deep-damaged-hazard-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};
        studdedHazardDerilectFloor = new Floor("studded-hazard-derilect-floor"){{
            variants = 1;
            mapColor = Color.valueOf("514656");
        }};
        platedHazardDerilectFloor = new Floor("plated-hazard-derilect-floor"){{
            variants = 3;
            mapColor = Color.valueOf("514656");
        }};

        oreAlamex = new OreBlock("ore-alamex"){{
            itemDrop = XenItems.alamex;
            oreDefault = true;
            variants = 4;
        }};
        oreTorren = new OreBlock("ore-torren"){{
            itemDrop = XenItems.torren;
            oreDefault = true;
            variants = 4;
        }};
        oreVeilla = new OreBlock("ore-veilla"){{
            itemDrop = XenItems.veilla;
            oreDefault = true;
            variants = 4;
        }};
        veillaDolWall = new StaticWall("veilla-dol-wall"){{
            itemDrop = XenItems.veilla;
            variants = 3;
        }};
        wallOreAlamex = new OreBlock("ore-wall-alamex", XenItems.alamex){{
            wallOre = true;
        }};
        wallOreTorren = new OreBlock("ore-wall-torren", XenItems.torren){{
            wallOre = true;
        }};
    }
}
