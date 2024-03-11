package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

public class XenEnvironmentTiles{
    public static Block
            lushGrass,
    public static void load(){
        lushGrass = new Floor("lush-grass"){{
            variants = 4;
            mapColor = Color.valueOf("7bc077");
        }};
    }
}
