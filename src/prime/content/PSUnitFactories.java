package prime.content;

import arc.graphics.g2d.Draw;
import arc.struct.Seq;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class PSUnitFactories{
    public static Block
            miteFactory;

    public static void load() {
        //mite
        miteFactory = new UnitFactory("mite-factory"){{
            requirements(Category.units, with(PSItems.iron, 50, Items.silicon, 40));
            plans = Seq.with(
                    new UnitPlan(PSUnitTypes.assaultMite, 60f * 8, with(Items.silicon, 5, PSItems.iron, 3)),
                    new UnitPlan(PSUnitTypes.boltMite, 60f * 8, with(Items.silicon, 5, PSItems.iron, 2, PSItems.aluminum, 2)),
                    new UnitPlan(PSUnitTypes.sapMite, 60f * 8, with(Items.silicon, 5, PSItems.aluminum, 3)),
                    new UnitPlan(PSUnitTypes.coreMite, 60f * 8, with(Items.silicon, 5, PSItems.aluminum, 3));
            );
            size = 2;
            consumePower(0.8f);
        }};
    }
}