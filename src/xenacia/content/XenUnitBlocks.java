package xenacia.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.PayloadStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class XenUnitBlocks{
    public static Block
            offensiveUnitFactory, assistantUnitFactory, defensiveUnitFactory,
            testAssembler,
            payloadMover,
            mageConstructor;

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
            requirements(Category.units, with(XenItems.alamex, 75, XenItems.torren, 50, XenItems.vrensteel, 90));
            health = 650;
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.barrier, 60f * 30, with(XenItems.vrensteel, 35, XenItems.alamex, 40))
            );
            size = 2;
            consumePower(0.5f);
            squareSprite = false;
        }};
        testAssembler = new UnitAssembler("test-assembler"){{
            requirements(Category.units, with(Items.carbide, 100, Items.oxide, 200, Items.tungsten, 500, Items.silicon, 800, Items.thorium, 400));
            regionSuffix = "-dark";
            size = 5;
            plans.add(
                    new AssemblerUnitPlan(UnitTypes.quell, 60f * 60f, PayloadStack.list(UnitTypes.elude, 4, Blocks.berylliumWallLarge, 12)),
                    new AssemblerUnitPlan(UnitTypes.disrupt, 60f * 60f * 3f, PayloadStack.list(UnitTypes.avert, 6, Blocks.carbideWallLarge, 20))
            );
            areaSize = 13;

            consumePower(3f);
            consumeLiquid(Liquids.cyanogen, 12f / 60f);
        }};
        payloadMover = new PayloadConveyor("payload-mover"){{
            requirements(Category.units, with(XenItems.alamex, 10, XenItems.torren, 5));
            moveTime = 60f;
            health = 450;
            underBullets = true;
            size = 2;
        }};
        mageConstructor = new UnitFactory("mage-constructor"){{
            requirements(Category.units, with(XenItems.alamex, 125, XenItems.torren, 50, XenItems.lenora, 100, XenItems.vrensteel, 90));
            health = 650;
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.barrier, 60f * 30, with(XenItems.vrensteel, 45, XenItems.alamex, 70, XenItems.lenora, 80))
            );
            size = 3;
            consumePower(1.4f);
            squareSprite = false;
        }};
    }
}
