package xenacia.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.meta.Attribute;

public class XenEnvironmentTiles{
    public static Block
            lushGrass, lushGrassWall, lushDirt, lushDirtWall, lushMud;

    public static void load(){
        //lush grass
        lushGrass = new Floor("lush-grass"){{
            variants = 4;
            mapColor = Color.valueOf("7bc077");
        }};
        lushGrassWall = new StaticWall("lush-grass-wall"){{
            variants = 3;
            mapColor = Color.valueOf("5ba164");
        }};
        lushDirt = new Floor("lush-dirt"){{
            variants = 4;
            mapColor = Color.valueOf("7bc077");
        }};
        lushDirtWall = new StaticWall("lush-dirt-wall"){{
            variants = 3;
            mapColor = Color.valueOf("5ba164");
        }};
        lushMud = new Floor("lush-mud"){{
            speedMultiplier = 0.6f;
            variants = 3;
            status = StatusEffects.muddy;
            statusDuration = 30f;
            attributes.set(Attribute.water, 1f);
            cacheLayer = CacheLayer.mud;
            walkSound = Sounds.mud;
            walkSoundVolume = 0.08f;
            walkSoundPitchMin = 0.4f;
            walkSoundPitchMax = 0.5f;
        }};
    }
}
