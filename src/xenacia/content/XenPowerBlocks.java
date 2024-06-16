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
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class XenPowerBlocks{
    public static Block
            smallLinkNode, linkNode, linkBattery, largeLinkBattery, veillaIgniter, solarCollecter;

    public static void load(){
        smallLinkNode = new PowerNode("small-link-node"){{
            requirements(Category.power, with(XenItems.alamex, 5));
            maxNodes = 5;
            laserRange = 10;
            laserColor1 = Color.valueOf("ffffff");
            laserColor2 = Color.valueOf("c6cef0");
        }};
        linkNode = new PowerNode("link-node"){{
            requirements(Category.power, with(XenItems.alamex, 25, XenItems.vrensteel, 10));
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
            requirements(Category.power, with(XenItems.alamex, 35, XenItems.torren, 40, XenItems.vrensteel, 30));
            size = 3;
            consumePowerBuffered(80000f);
            baseExplosiveness = 8f;

            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawPower("-power"){{
                        emptyLightColor = Color.valueOf("747a9d");
                        fullLightColor = Color.valueOf("c6cef0");
                    }},
                    new DrawRegion("-top")
            );
        }};
        veillaIgniter = new ConsumeGenerator("veilla-igniter"){{
            requirements(Category.power, with(XenItems.alamex, 85));
            size = 2;
            powerProduction = (70f / 60f);
            itemDuration = 80f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;

            consumeItem(XenItems.veilla);

            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawFlame(Color.valueOf("c6cef0"))
            );
        }};
        solarCollecter = new SolarGenerator("solar-collector"){{
            requirements(Category.power, with(XenItems.alamex, 35, XenItems.vrensteel, 55));
            size = 2;
            powerProduction = (55f / 60f);
        }};
    }
}
