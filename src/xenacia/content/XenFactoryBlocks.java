package xenacia.content;

import mindustry.content.Fx;
import mindustry.entities.effect.RadialEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class XenFactoryBlocks{
    public static Block
            vrensteelCompressor;

    public static void load(){
        vrensteelCompressor = new GenericCrafter("vrensteel-compressor"){{
            requirements(Category.crafting, with(XenItems.alamex, 40, XenItems.torren, 35));

            craftEffect = new RadialEffect(){{
                effect = Fx.disperseTrail;
                amount = 8;
                rotationSpacing = 90f;
                lengthOffset = -5f;
                rotationOffset = 45f;
                baseRotation = 90f;
            }};

            outputItem = new ItemStack(XenItems.vrensteel, 2);
            craftTime = 120f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawRegion("-hammer")
            );
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(XenItems.veilla, 3));
            consumePower(45f / 60f);
        }};
    }
}
