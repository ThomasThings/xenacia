package prime.content;

import arc.struct.Seq;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.content.*;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.*;

public class PSUnitFactories{
    public static Block
            miteFactory, unitSeedConstructor;

    public static void load() {
        //mite
        miteFactory = new UnitFactory("mite-factory"){{
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
        unitSeedConstructor = new UnitFactory("unit-seed-constructor"){{
            requirements(Category.units, with(PSItems.iron, 80, PSItems.aluminum, 100 Items.silicon, 80));
            plans = Seq.with(
                    new UnitPlan(PSUnitTypes.mech, 60f * 15, with(Items.silicon, 10, PSItems.iron, 15)),
                    new UnitPlan(PSUnitTypes.aircraft, 60f * 15, with(Items.silicon, 10, PSItems.iron, 5, PSItems.aluminum, 10)),
                    new UnitPlan(PSUnitTypes.polyped, 60f * 15, with(Items.silicon, 10, PSItems.iron, 10, PSItems.aluminum, 5))
            );
            size = 3;
            consumePower(1.2f);
        }};
    }
}