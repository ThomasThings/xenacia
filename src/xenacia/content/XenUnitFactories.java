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
            assaultTranstructor, supportTranstructor, specialistTranstructor,
            assaultReconstructor, supportReconstructor, specialistReconstructor,
            convergentReconstructor;

    public static void load() {
        //mite
        miteFactory = new BaseTeamUnitFactory("mite-factory"){{
            requirements(Category.units, BuildVisibility.sandboxOnly, with(XenItems.iron, 50, Items.silicon, 40));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.coreMite, 60f * 8, with(Items.silicon, 5, XenItems.aluminum, 3)),
                    new UnitPlan(XenUnitTypes.assaultMite, 60f * 8, with(Items.silicon, 5, XenItems.iron, 3)),
                    new UnitPlan(XenUnitTypes.boltMite, 60f * 8, with(Items.silicon, 5, XenItems.iron, 2, XenItems.aluminum, 2)),
                    new UnitPlan(XenUnitTypes.sapMite, 60f * 8, with(Items.silicon, 5, XenItems.aluminum, 3))
            );
            size = 2;
            consumePower(0.8f);
        }};
        unitSeedConstructor = new BaseTeamUnitFactory("unit-seed-constructor"){{
            requirements(Category.units, with( XenItems.aluminum, 100, Items.silicon, 80, XenItems.iron, 80));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.mech, 60f * 15, with(Items.silicon, 15, XenItems.iron, 15, XenItems.aluminum, 5)),
                    new UnitPlan(XenUnitTypes.aircraft, 60f * 15, with(Items.silicon, 15, XenItems.iron, 5, XenItems.aluminum, 10)),
                    new UnitPlan(XenUnitTypes.polyped, 60f * 15, with(Items.silicon, 20, XenItems.iron, 10, XenItems.aluminum, 5)),
                    new UnitPlan(XenUnitTypes.ship, 60f * 15, with(Items.silicon, 20, XenItems.aluminum, 15)),
                    new UnitPlan(XenUnitTypes.tank, 60f * 15, with(Items.silicon, 25, XenItems.iron, 15, XenItems.aluminum, 10))
            );
            size = 3;
            consumePower(1.2f);
        }};

        assaultTranstructor = new BaseTeamReconstructor("assault-transtructor"){{
            requirements(Category.units, with(XenItems.iron, 150, XenItems.aluminum, 130, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 60, XenItems.iron, 55, XenItems.aluminum, 25));

            constructTime = 60f * 10f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.mech, XenUnitTypes.gale},
                    new UnitType[]{XenUnitTypes.aircraft, XenUnitTypes.anax},
                    new UnitType[]{XenUnitTypes.polyped, XenUnitTypes.explore},
                    new UnitType[]{XenUnitTypes.ship, XenUnitTypes.shif},
                    new UnitType[]{XenUnitTypes.tank, XenUnitTypes.tack}
            );
        }};
        supportTranstructor = new BaseTeamReconstructor("support-transtructor"){{
            requirements(Category.units, with(XenItems.iron, 180, XenItems.aluminum, 100, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 25, XenItems.aluminum, 35));

            constructTime = 60f * 10f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.mech, XenUnitTypes.elementary},
                    new UnitType[]{XenUnitTypes.aircraft, XenUnitTypes.lug},
                    new UnitType[]{XenUnitTypes.polyped, XenUnitTypes.tick},
                    new UnitType[]{XenUnitTypes.ship, XenUnitTypes.natuon},
                    new UnitType[]{XenUnitTypes.tank, XenUnitTypes.assist}
            );
        }};
        specialistTranstructor = new BaseTeamReconstructor("specialist-transtructor"){{
            requirements(Category.units, with(XenItems.aluminum, 150, XenItems.iron, 120, Items.silicon, 80, XenItems.lithium, 60));

            size = 3;
            consumePower(4f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 30, XenItems.aluminum, 25));

            constructTime = 60f * 10f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.mech, XenUnitTypes.erode},
                    new UnitType[]{XenUnitTypes.aircraft, XenUnitTypes.ryher},
                    new UnitType[]{XenUnitTypes.polyped, XenUnitTypes.spritz},
                    new UnitType[]{XenUnitTypes.ship, XenUnitTypes.kyre},
                    new UnitType[]{XenUnitTypes.tank, XenUnitTypes.tie}
            );
        }};

        assaultReconstructor = new BaseTeamReconstructor("assault-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 650, XenItems.aluminum, 550, Items.graphite, 350, Items.silicon, 600, Items.titanium, 400));

            size = 5;
            consumePower(5f);
            consumeItems(with(Items.silicon, 150, XenItems.iron, 100, XenItems.aluminum, 90, Items.graphite, 120));

            constructTime = 60f * 25f;

            upgrades.addAll(
            );
        }};
        supportReconstructor = new BaseTeamReconstructor("support-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 650, XenItems.aluminum, 550, Items.graphite, 350, Items.silicon, 600, Items.titanium, 400));

            size = 5;
            consumePower(5f);
            consumeItems(with(Items.silicon, 150, XenItems.iron, 80, XenItems.aluminum, 80, Items.graphite, 150));

            constructTime = 60f * 25f;

            upgrades.addAll(
            );
        }};
        specialistReconstructor = new BaseTeamReconstructor("specialist-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 650, XenItems.aluminum, 500, Items.graphite, 300, Items.silicon, 400, Items.titanium, 400, XenItems.lithium, 300));

            size = 5;
            consumePower(6f);
            consumeItems(with(Items.silicon, 160, XenItems.iron, 90, XenItems.aluminum, 90, Items.graphite, 100));

            constructTime = 60f * 25f;

            upgrades.addAll(
            );
        }};

        convergentReconstructor = new BaseTeamReconstructor("convergent-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 2000, Items.graphite, 1500, Items.silicon, 1000, XenItems.lithium, 800, Items.titanium, 1000, XenItems.cobalt, 800));

            size = 7;
            consumePower(6f);
            consumeItems(with(Items.silicon, 800, XenItems.iron, 600, XenItems.aluminum, 600, Items.graphite, 500, Items.titanium, 250));

            constructTime = 60f * 25f;

            upgrades.addAll(
            );
        }};
    }
}