package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawWarmupRegion;

import static mindustry.type.ItemStack.with;

public class XenPowerBlocks{
    public static Block
            smallLinkNode, linkNode, linkBattery, largeLinkBattery, smallBioBurner, bioBurner, solarCollecter;

    public static void load(){
        smallLinkNode = new PowerNode("small-link-node"){{
            requirements(Category.power, with(XenItems.alamex, 5));
            maxNodes = 5;
            laserRange = 10;
            laserColor1 = Color.valueOf("ffffff");
            laserColor2 = Color.valueOf("c6cef0");
        }};
        linkNode = new PowerNode("link-node"){{
            requirements(Category.power, with(XenItems.alamex, 25, XenItems.silicium, 10));
            size = 2;
            maxNodes = 20;
            laserRange = 25;
            laserColor1 = Color.valueOf("ffffff");
            laserColor2 = Color.valueOf("c6cef0");
        }};
        linkBattery = new Battery("link-battery"){{
            requirements(Category.power, with(XenItems.alamex, 25, XenItems.torren, 10));
            size = 2;
            consumePowerBuffered(10000f);
            baseExplosiveness = 5f;
            emptyLightColor = Color.valueOf("747a9d");
            fullLightColor = Color.valueOf("c6cef0");
        }};
        largeLinkBattery = new Battery("large-link-battery"){{
            requirements(Category.power, with(XenItems.alamex, 35, XenItems.torren, 40, XenItems.silicium, 30));
            size = 3;
            consumePowerBuffered(80000f);
            baseExplosiveness = 8f;
            emptyLightColor = Color.valueOf("747a9d");
            fullLightColor = Color.valueOf("c6cef0");
        }};
        smallBioBurner = new ConsumeGenerator("small-bio-burner"){{
            requirements(Category.power, with(XenItems.alamex, 15));
            powerProduction = 5f;
            itemDuration = 60f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;

            consumeItem(XenItems.carbonFuel);

            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawFlame(Color.valueOf("c6cef0"))
            );
        }};
        bioBurner = new ConsumeGenerator("bio-burner"){{
            requirements(Category.power, with(XenItems.alamex, 35, XenItems.torren, 20, XenItems.silicium, 20));
            size = 2;
            powerProduction = 10f;
            itemDuration = 120f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.05f;
            generateEffect = Fx.generatespark;

            consumeItem(XenItems.carbonFuel, 2);

            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawFlame(Color.valueOf("c6cef0"))
            );
        }};
        solarCollecter = new SolarGenerator("solar-collector"){{
            requirements(Category.power, with(XenItems.alamex, 35, XenItems.silicium, 55));
            size = 2;
            powerProduction = 1.5f;
        }};
    }
}
