package xenacia.content;

import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class XenUnitBlocks{
    public static Block
            assistantConstructor;

    public static void load(){
        assistantConstructor = new UnitFactory("asistant-constructor"){{
            requirements(Category.units, with(XenItems.alamex, 50, XenItems.silicium, 80));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.awren, 60f * 25, with(XenItems.silicium, 25, XenItems.alamex, 20))
            );
            size = 2;
            consumePower(0.5f);
        }};
    }
}
