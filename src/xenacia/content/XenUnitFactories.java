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
            unitHullConstructor,
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
        unitHullConstructor = new BaseTeamUnitFactory("unit-hull-constructor"){{
            requirements(Category.units, with( XenItems.aluminum, 100, Items.silicon, 80, XenItems.iron, 80));
            plans = Seq.with(
                    new UnitPlan(XenUnitTypes.mechacraftHull, 60f * 15, with(Items.silicon, 15, XenItems.iron, 15, XenItems.aluminum, 5)),
                    new UnitPlan(XenUnitTypes.aircraftHull, 60f * 15, with(Items.silicon, 15, XenItems.iron, 5, XenItems.aluminum, 10)),
                    new UnitPlan(XenUnitTypes.polycraftHull, 60f * 15, with(Items.silicon, 20, XenItems.iron, 10, XenItems.aluminum, 5)),
                    new UnitPlan(XenUnitTypes.watercraftHull, 60f * 15, with(Items.silicon, 20, XenItems.aluminum, 15)),
                    new UnitPlan(XenUnitTypes.treadcraftHull, 60f * 15, with(Items.silicon, 25, XenItems.iron, 15, XenItems.aluminum, 10))
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
                    new UnitType[]{XenUnitTypes.mechacraftHull, XenUnitTypes.gale},
                    new UnitType[]{XenUnitTypes.aircraftHull, XenUnitTypes.anax},
                    new UnitType[]{XenUnitTypes.polycraftHull, XenUnitTypes.explore},
                    new UnitType[]{XenUnitTypes.watercraftHull, XenUnitTypes.shif},
                    new UnitType[]{XenUnitTypes.treadcraftHull, XenUnitTypes.tack}
            );
        }};
        supportTranstructor = new BaseTeamReconstructor("support-transtructor"){{
            requirements(Category.units, with(XenItems.iron, 180, XenItems.aluminum, 100, Items.silicon, 100));

            size = 3;
            consumePower(3f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 25, XenItems.aluminum, 35));

            constructTime = 60f * 10f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.mechacraftHull, XenUnitTypes.elementary},
                    new UnitType[]{XenUnitTypes.aircraftHull, XenUnitTypes.lug},
                    new UnitType[]{XenUnitTypes.polycraftHull, XenUnitTypes.tick},
                    new UnitType[]{XenUnitTypes.watercraftHull, XenUnitTypes.natuon},
                    new UnitType[]{XenUnitTypes.treadcraftHull, XenUnitTypes.aid}
            );
        }};
        specialistTranstructor = new BaseTeamReconstructor("specialist-transtructor"){{
            requirements(Category.units, with(XenItems.aluminum, 150, XenItems.iron, 120, Items.silicon, 80, XenItems.lithium, 60));

            size = 3;
            consumePower(4f);
            consumeItems(with(Items.silicon, 30, XenItems.iron, 30, XenItems.aluminum, 25));

            constructTime = 60f * 10f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.mechacraftHull, XenUnitTypes.erode},
                    new UnitType[]{XenUnitTypes.aircraftHull, XenUnitTypes.ryher},
                    new UnitType[]{XenUnitTypes.polycraftHull, XenUnitTypes.spritz},
                    new UnitType[]{XenUnitTypes.watercraftHull, XenUnitTypes.kyre},
                    new UnitType[]{XenUnitTypes.treadcraftHull, XenUnitTypes.tie}
            );
        }};

        assaultReconstructor = new BaseTeamReconstructor("assault-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 750, XenItems.aluminum, 600, Items.graphite, 350, Items.silicon, 650, Items.titanium, 400));

            size = 5;
            consumePower(8.5f);
            consumeItems(with(Items.silicon, 350, XenItems.iron, 350, XenItems.aluminum, 250, Items.graphite, 250));

            constructTime = 60f * 25f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.anax, XenUnitTypes.odonata},
                    new UnitType[]{XenUnitTypes.shif, XenUnitTypes.kreeg}
            );
        }};
        supportReconstructor = new BaseTeamReconstructor("support-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 750, XenItems.aluminum, 550, Items.graphite, 400, Items.silicon, 650, Items.titanium, 450));

            size = 5;
            consumePower(9f);
            consumeItems(with(Items.silicon, 350, XenItems.iron, 300, XenItems.aluminum, 300, Items.graphite, 250));

            constructTime = 60f * 25f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.lug, XenUnitTypes.haul},
                    new UnitType[]{XenUnitTypes.natuon, XenUnitTypes.enavo}
            );
        }};
        specialistReconstructor = new BaseTeamReconstructor("specialist-reconstructor"){{
            requirements(Category.units, with(XenItems.iron, 650, XenItems.aluminum, 500, Items.graphite, 300, Items.silicon, 550, Items.titanium, 400, XenItems.lithium, 300));

            size = 5;
            consumePower(10f);
            consumeItems(with(Items.silicon, 400, XenItems.iron, 300, XenItems.aluminum, 250, Items.graphite, 300));

            constructTime = 60f * 25f;

            upgrades.addAll(
                    new UnitType[]{XenUnitTypes.ryher, XenUnitTypes.evelate},
                    new UnitType[]{XenUnitTypes.kyre, XenUnitTypes.yriek}
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