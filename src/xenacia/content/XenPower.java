package xenacia.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawWarmupRegion;

import static mindustry.type.ItemStack.with;

public class XenPower{
    public static Block
            networkLinker, bioBurner;

    public static void load(){
        networkLinker = new PowerNode("network-linker"){{
            requirements(Category.power, with(XenItems.aluminum, 15, XenItems.iron, 10, Items.graphite, 5));
            size = 2;
            maxNodes = 20;
            laserRange = 20f;
        }};
        bioBurner = new ConsumeGenerator("combustion-generator"){{
            requirements(Category.power, with(XenItems.iron, 25));
            powerProduction = 1f;
            itemDuration = 90f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;

            consumeItem(XenItems.biomass);

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }};
    }
}
