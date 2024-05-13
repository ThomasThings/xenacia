package xenacia.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
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
            shallowHydrex, deepHydrex,
            lushGrass, wetLushGrass, lushGrassWall,
            silicateSandFloor, wetSilicateSand,
            lushDirt, lushDirtWall, lushMud, deepLushMud, lushMuddyWall,
            bankstone, bankstoneWall,
            oreAlamex, oreTorren;

    public static void load(){
        lendesiteFloor = new Floor("lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("5a6877");
            attributes.set(XenAttribute.stone, 0.5f);
        }};
        deepLendesiteFloor = new Floor("deep-lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("4d5c6c");
            attributes.set(XenAttribute.stone, 0.5f);
        }};
        slashedLendesiteFloor = new Floor("slashed-lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("6c7b8b");
            attributes.set(XenAttribute.stone, 0.5f);
        }};
        deepSlashedLendesiteFloor = new Floor("deep-slashed-lendesite-floor"){{
            variants = 4;
            mapColor = Color.valueOf("5e6d7d");
            attributes.set(XenAttribute.stone, 0.5f);
        }};
        lendesiteWall = new StaticWall("lendesite-wall"){{
            variants = 3;
            mapColor = Color.valueOf("778797");
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
            attributes.set(XenAttribute.stone, 0.4f);
        }};
        deepKryesenFloor = new Floor("deep-kryesen-floor"){{
            variants = 4;
            mapColor = Color.valueOf("6474a8");
            attributes.set(XenAttribute.stone, 0.4f);
        }};
        kryesenWall = new StaticWall("kryesen-wall"){{
            variants = 2;
            mapColor = Color.valueOf("a0b6e3");
        }};
        kryesenBoulder = new Prop("kryesen-boulder"){{
            variants = 2;
            kryesenFloor.asFloor().decoration = this;
            deepKryesenFloor.asFloor().decoration = this;
        }};

        shallowHydrex = new Floor("shallow-hydrex"){{
            speedMultiplier = 0.5f;
            variants = 2;
            status = StatusEffects.wet;
            statusDuration = 90f;
            liquidDrop = XenLiquids.hydrex;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
            mapColor = Color.valueOf("597fb8");
        }};
        deepHydrex = new Floor("deep-hydrex"){{
            speedMultiplier = 0.2f;
            variants = 2;
            liquidDrop = XenLiquids.hydrex;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = StatusEffects.wet;
            statusDuration = 120f;
            drownTime = 200f;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
            mapColor = Color.valueOf("4965a2");
        }};

        lushGrass = new Floor("lush-grass"){{
            variants = 5;
            mapColor = Color.valueOf("63a774");
        }};
        wetLushGrass = new Floor("wet-lush-grass"){{
            variants = 5;
            isLiquid = true;
            shallow = true;
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = XenLiquids.hydrex;
            liquidMultiplier = 0.5f;
            albedo = 0.9f;
            supportsOverlay = true;
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("5e909c");
        }};
        lushGrassWall = new StaticWall("lush-grass-wall"){{
            variants = 3;
            mapColor = Color.valueOf("73c688");
        }};

        silicateSandFloor = new Floor("silicate-sand-floor"){{
            variants = 4;
            mapColor = Color.valueOf("dab798");
            itemDrop = XenItems.silicateSand;
        }};
        wetSilicateSand = new Floor("wet-silicate-sand"){{
            variants = 4;
            isLiquid = true;
            shallow = true;
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            albedo = 0.9f;
            liquidDrop = XenLiquids.hydrex;
            liquidMultiplier = 0.5f;
            supportsOverlay = true;
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("8e96aa");
        }};

        lushDirt = new Floor("lush-dirt"){{
            variants = 4;
            mapColor = Color.valueOf("764a3c");
        }};
        lushDirtWall = new StaticWall("lush-dirt-wall"){{
            variants = 3;
            mapColor = Color.valueOf("976752");
        }};
        lushMud = new Floor("lush-mud"){{
            speedMultiplier = 0.6f;
            variants = 4;
            status = StatusEffects.muddy;
            statusDuration = 30f;
            attributes.set(Attribute.water, 1f);
            liquidDrop = XenLiquids.hydrex;
            liquidMultiplier = 0.3f;
            cacheLayer = CacheLayer.mud;
            walkSound = Sounds.mud;
            walkSoundVolume = 0.08f;
            walkSoundPitchMin = 0.4f;
            walkSoundPitchMax = 0.5f;
            mapColor = Color.valueOf("462924");
        }};
        deepLushMud = new Floor("deep-lush-mud"){{
            isLiquid = true;
            shallow = true;
            variants = 4;
            speedMultiplier = 0.4f;
            statusDuration = 50f;
            liquidDrop = XenLiquids.hydrex;
            liquidMultiplier = 0.4f;
            albedo = 0.9f;
            supportsOverlay = true;
            cacheLayer = CacheLayer.water;
            mapColor = Color.valueOf("473e50");
        }};
        lushMuddyWall = new StaticWall("lush-muddy-wall"){{
            variants = 2;
            mapColor = Color.valueOf("5d3b2e");
        }};

        bankstone = new Floor("bankstone"){{
            variants = 4;
            mapColor = Color.valueOf("a4a8b6");
        }};
        bankstoneWall = new StaticWall("bankstone-wall"){{
            variants = 3;
            mapColor = Color.valueOf("c7ccd7");
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
    }
}
