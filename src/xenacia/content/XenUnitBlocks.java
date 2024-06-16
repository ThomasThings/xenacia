package xenacia.content;

import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class XenUnitBlocks{
    public static Block
            assistantUnitFactory, offensiveUnitFactory,
            payloadMover;

    public static void load(){
        assistantUnitFactory = new UnitFactory("assistant-unit-factory"){{
            requirements(Category.units, with(XenItems.alamex, 50, XenItems.torren, 60, XenItems.vrensteel, 80));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.awren, 60f * 25, with(XenItems.vrensteel, 30, XenItems.alamex, 20))
            );
            size = 2;
            consumePower(0.5f);
        }};
        offensiveUnitFactory = new UnitFactory("offensive-unit-factory"){{
            requirements(Category.units, with(XenItems.alamex, 50, XenItems.vrensteel, 80));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.serpence, 60f * 25, with(XenItems.vrensteel, 25, XenItems.alamex, 25))
            );
            size = 2;
            consumePower(0.5f);
        }};
        payloadMover = new PayloadConveyor("payload-mover"){{
            requirements(Category.units, with(XenItems.alamex, 10, XenItems.torren, 5));
            moveTime = 60f;
            health = 450;
            underBullets = true;
            size = 2;
        }};
    }
}
