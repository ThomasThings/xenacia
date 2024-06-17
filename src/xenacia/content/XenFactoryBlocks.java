package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.effect.RadialEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;

import static mindustry.type.ItemStack.with;

public class XenFactoryBlocks{
    public static Block
            vrensteelCompressor;

    public static void load(){
        vrensteelCompressor = new GenericCrafter("vrensteel-compressor"){{
            requirements(Category.crafting, with(XenItems.alamex, 40, XenItems.torren, 35));

            craftEffect = new RadialEffect(){{
                effect = Fx.blockCrash;
                amount = 4;
                rotationSpacing = 90f;
                lengthOffset = 5f;
                rotationOffset = 45f;
            }};

            outputItem = new ItemStack(XenItems.vrensteel, 1);
            craftTime = 120f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("c6cef0")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(XenItems.veilla, 3));
            consumePower(45f / 60f);
        }};
    }
}
