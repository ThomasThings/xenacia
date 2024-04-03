package xenacia.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;

import static mindustry.type.ItemStack.with;

public class XenDrills{
    public static Block
            basicDrill;

    public static void load(){
        basicDrill = new Drill("basic-drill"){{
            requirements(Category.production, with(XenItems.alamex, 15));
            tier = 2;
            drillTime = 300;
            size = 2;

            consumeLiquid(XenLiquids.hydrex, 0.05f).boost();
        }};
    }
}
