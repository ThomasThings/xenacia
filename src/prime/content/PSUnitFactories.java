package prime.content;

import arc.struct.Seq;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.meta.BuildVisibility;
import prime.world.blocks.units.BaseTeamReconstructor;
import prime.world.blocks.units.BaseTeamUnitFactory;

import static mindustry.type.ItemStack.*;

public class PSUnitFactories{
    public static Block
            miteFactory,
            unitSeedConstructor,
            assaultTranstructor, supportTranstructor, specialistTranstructor;

    public static void load() {
        //mite
        miteFactory = new BaseTeamUnitFactory("mite-factory"){{
            requirements(Category.units, BuildVisibility.sandboxOnly, with(PSItems.iron, 50, Items.silicon, 40));
            plans = Seq.with(
                    new UnitPlan(PSUnitTypes.assaultMite, 60f * 8, with(Items.silicon, 5, PSItems.iron, 3)),
                    new UnitPlan(PSUnitTypes.boltMite, 60f * 8, with(Items.silicon, 5, PSItems.iron, 2, PSItems.aluminum, 2)),
                    new UnitPlan(PSUnitTypes.sapMite, 60f * 8, with(Items.silicon, 5, PSItems.aluminum, 3)),
                    new UnitPlan(PSUnitTypes.coreMite, 60f * 8, with(Items.silicon, 5, PSItems.aluminum, 3))
            );
            size = 2;
            consumePower(0.8f);
        }};
        unitSeedConstructor = new BaseTeamUnitFactory("unit-seed-constructor"){{
            requirements(Category.units, with( PSItems.aluminum, 100, Items.silicon, 80, PSItems.iron, 80));
            plans = Seq.with(
                    new UnitPlan(PSUnitTypes.mech, 60f * 15, with(Items.silicon, 10, PSItems.iron, 15, PSItems.aluminum, 5)),
                    new UnitPlan(PSUnitTypes.aircraft, 60f * 15, with(Items.silicon, 10, PSItems.iron, 5, PSItems.aluminum, 10)),
                    new UnitPlan(PSUnitTypes.polyped, 60f * 15, with(Items.silicon, 15, PSItems.iron, 10, PSItems.aluminum, 5)),
                    new UnitPlan(PSUnitTypes.ship, 60f * 15, with(Items.silicon, 10, PSItems.aluminum, 15)),
                    new UnitPlan(PSUnitTypes.tank, 60f * 15, with(Items.silicon, 10, PSItems.iron, 15, PSItems.aluminum, 10))
            );
            size = 3;
            consumePower(1.2f);
        }};
        assaultTranstructor = new BaseTeamReconstructor("assault-transtructor"){{
            requirements(Category.units, with(PSItems.iron, 150, PSItems.aluminum, 130, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, PSItems.iron, 35, PSItems.aluminum, 20));

            constructTime = 60f * 10f;

            upgrades.addAll(
            );
        }};
        supportTranstructor = new BaseTeamReconstructor("support-transtructor"){{
            requirements(Category.units, with(PSItems.iron, 180, PSItems.aluminum, 100, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, PSItems.iron, 25, PSItems.aluminum, 35));

            constructTime = 60f * 10f;

            upgrades.addAll(
            );
        }};
        specialistTranstructor = new BaseTeamReconstructor("specialist-transtructor"){{
            requirements(Category.units, with(PSItems.aluminum, 150, PSItems.iron, 130, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, PSItems.iron, 30, PSItems.aluminum, 25));

            constructTime = 60f * 10f;

            upgrades.addAll(
            );
        }};
    }
}