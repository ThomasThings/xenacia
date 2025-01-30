package xenacia.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;

import static mindustry.type.ItemStack.with;

public class XenDrills{
    public static Block
            basicDrill, beamDrill;

    public static void load(){
        basicDrill = new Drill("basic-drill"){{
            requirements(Category.production, with(XenItems.alamex, 25));
            tier = 2;
            drillTime = 300;
            size = 2;
        }};
        beamDrill = new BeamDrill("beam-drill"){{
            requirements(Category.production, with(XenItems.alamex, 65, XenItems.vrensteel, 35));
            consumePower(0.20f);

            optionalBoostIntensity = 1f;

            drillTime = 150f;
            tier = 3;
            size = 2;
            range = 4;
        }};
    }
}
