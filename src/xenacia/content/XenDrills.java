package xenacia.content;

import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class XenDrills{
    public static Block
            basicDrill, stoneCrusher, beamDrill;

    public static void load(){
        basicDrill = new Drill("basic-drill"){{
            requirements(Category.production, with(XenItems.alamex, 15));
            tier = 2;
            drillTime = 300;
            size = 2;

            consumeLiquid(XenLiquids.hydrex, 0.05f).boost();
        }};
        stoneCrusher = new AttributeCrafter("stone-crusher"){{
            requirements(Category.production, with(XenItems.alamex, 35, XenItems.torren, 20));
            outputItem = new ItemStack(XenItems.silicateSand, 3);
            craftTime = 120;
            size = 2;
            hasPower = true;
            hasItems = true;

            craftEffect = Fx.none;

            legacyReadWarmup = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom-spinner"){{
                        rotateSpeed = 1;
                        spinSprite = true;
                    }},
                    new DrawRegion("-bottom-spinner"){{
                        rotateSpeed = 2;
                        spinSprite = true;
                    }},
                    new DrawRegion("-top-spinner"){{
                        rotation = 45;
                        rotateSpeed = -4;
                        spinSprite = true;
                    }},
                    new DrawDefault()
            );
            maxBoost = 2f;

            consumePower(80f / 60f);
        }};
        beamDrill = new BeamDrill("beam-drill"){{
            requirements(Category.production, with(XenItems.alamex, 65, XenItems.silicium, 35));
            consumePower(0.20f);

            drillTime = 150f;
            tier = 3;
            size = 2;
            range = 4;
        }};
    }
}
