package xenacia.content;

import arc.struct.Seq;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.meta.BuildVisibility;
import xenacia.world.blocks.units.BaseTeamReconstructor;
import xenacia.world.blocks.units.BaseTeamUnitFactory;

import static mindustry.type.ItemStack.*;

public class XenUnitFactories{
    public static Block
            miteFactory,
            unitSeedConstructor,
            assaultTranstructor, supportTranstructor, specialistTranstructor;

    public static void load() {
        //mite
        miteFactory = new BaseTeamUnitFactory("mite-factory"){{
            requirements(Category.units, BuildVisibility.sandboxOnly, with(XenItems.iron, 50, Items.silicon, 40));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.assaultMite, 60f * 8, with(Items.silicon, 5, XenItems.iron, 3)),
                    new UnitPlan(XenUnitTypes.boltMite, 60f * 8, with(Items.silicon, 5, XenItems.iron, 2, XenItems.aluminum, 2)),
                    new UnitPlan(XenUnitTypes.sapMite, 60f * 8, with(Items.silicon, 5, XenItems.aluminum, 3)),
                    new UnitPlan(XenUnitTypes.coreMite, 60f * 8, with(Items.silicon, 5, XenItems.aluminum, 3))
            );
            size = 2;
            consumePower(0.8f);
        }};
        unitSeedConstructor = new BaseTeamUnitFactory("unit-seed-constructor"){{
            requirements(Category.units, with( XenItems.aluminum, 100, Items.silicon, 80, XenItems.iron, 80));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.mech, 60f * 15, with(Items.silicon, 10, XenItems.iron, 15, XenItems.aluminum, 5)),
                    new UnitPlan(XenUnitTypes.aircraft, 60f * 15, with(Items.silicon, 10, XenItems.iron, 5, XenItems.aluminum, 10)),
                    new UnitPlan(XenUnitTypes.polyped, 60f * 15, with(Items.silicon, 15, XenItems.iron, 10, XenItems.aluminum, 5)),
                    new UnitPlan(XenUnitTypes.ship, 60f * 15, with(Items.silicon, 10, XenItems.aluminum, 15)),
                    new UnitPlan(XenUnitTypes.tank, 60f * 15, with(Items.silicon, 10, XenItems.iron, 15, XenItems.aluminum, 10))
            );
            size = 3;
            consumePower(1.2f);
        }};
        assaultTranstructor = new BaseTeamReconstructor("assault-transtructor"){{
            requirements(Category.units, with(XenItems.iron, 150, XenItems.aluminum, 130, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 35, XenItems.aluminum, 20));

            constructTime = 60f * 10f;

            upgrades.addAll(
            );
        }};
        supportTranstructor = new BaseTeamReconstructor("support-transtructor"){{
            requirements(Category.units, with(XenItems.iron, 180, XenItems.aluminum, 100, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 25, XenItems.aluminum, 35));

            constructTime = 60f * 10f;

            upgrades.addAll(
            );
        }};
        specialistTranstructor = new BaseTeamReconstructor("specialist-transtructor"){{
            requirements(Category.units, with(XenItems.aluminum, 150, XenItems.iron, 130, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 30, XenItems.aluminum, 25));

            constructTime = 60f * 10f;

            upgrades.addAll(
            );
        }};
    }
}