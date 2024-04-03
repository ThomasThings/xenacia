package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
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
            siliciumRefiner;

    public static void load(){
        siliciumRefiner = new GenericCrafter("silicium-refiner"){{
            requirements(Category.crafting, with(XenItems.alamex, 40, XenItems.torren, 35));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(XenItems.silicium, 2);
            craftTime = 120f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("c6cef0")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(XenItems.silicateSand, 3));
            consumePower(0.50f);
        }};
    }
}
