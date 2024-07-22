package xenacia.content;

import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class XenUnitBlocks{
    public static Block
            offensiveUnitFactory, assistantUnitFactory, defensiveUnitFactory,
            payloadMover;

    public static void load(){
        offensiveUnitFactory = new UnitFactory("offensive-unit-factory"){{
            requirements(Category.units, with(XenItems.alamex, 50, XenItems.vrensteel, 80));
            health = 650;
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.serpence, 60f * 20, with(XenItems.vrensteel, 25, XenItems.alamex, 25))
            );
            size = 2;
            consumePower(0.5f);
            squareSprite = false;
        }};
        assistantUnitFactory = new UnitFactory("assistant-unit-factory"){{
            requirements(Category.units, with(XenItems.alamex, 50, XenItems.torren, 60, XenItems.vrensteel, 80));
            health = 650;
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.awren, 60f * 25, with(XenItems.vrensteel, 30, XenItems.alamex, 20))
            );
            size = 2;
            consumePower(0.5f);
            squareSprite = false;
        }};
        defensiveUnitFactory = new UnitFactory("defensive-unit-factory"){{
            requirements(Category.units, with(XenItems.alamex, 76, XenItems.torren, 50, XenItems.vrensteel, 90));
            health = 650;
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.barrier, 60f * 30, with(XenItems.vrensteel, 35, XenItems.alamex, 40))
            );
            size = 2;
            consumePower(0.5f);
            squareSprite = false;
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
