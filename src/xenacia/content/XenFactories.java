package xenacia.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.*;

public class XenFactories{
    public static Block
            biomassCompressor, carbonPress, carbonKiloPress;

    public static void load(){
        //peat, coal, graphite
        biomassCompressor = new GenericCrafter("biomass-compressor"){{
            requirements(Category.crafting, with(XenItems.iron, 40, XenItems.aluminum, 20));
            size = 2;
            rotate = false;
            solid = true;
            envEnabled = Env.any;

            hasPower = true;
            hasItems = true;
            itemCapacity = 10;
            hasLiquids = true;
            liquidCapacity = 24f;

            consumeItem(XenItems.biomass, 2);
            consumePower(0.5f);

            craftTime = 60f;

            outputsLiquid = true;
            outputLiquid = new LiquidStack(Liquids.water, 6f / 60f);
            outputItem = new ItemStack(XenItems.coal, 1);

            craftEffect = Fx.pulverizeMedium;
        }};
        carbonPress = new GenericCrafter("carbon-press"){{
            requirements(Category.crafting, with(XenItems.iron, 40, XenItems.aluminum, 20));
            size = 2;
            rotate = false;
            solid = true;
            envEnabled = Env.any;

            hasPower = true;
            hasItems = true;
            itemCapacity = 20;

            consumeItem(XenItems.coal, 5);
            consumePower(0.5f);

            craftTime = 60f;

            outputItem = new ItemStack(XenItems.graphite, 3);

            craftEffect = Fx.pulverizeMedium;
        }};
        carbonKiloPress = new GenericCrafter("carbon-kilo-press"){{
            requirements(Category.crafting, with(XenItems.iron, 160, XenItems.graphite, 100, XenItems.silicon, 80));
            size = 3;
            rotate = false;
            solid = true;
            envEnabled = Env.any;

            hasPower = true;
            hasItems = true;
            itemCapacity = 60;

            consumeItem(XenItems.coal, 10);
            consumePower(0.5f);

            craftTime = 75f;

            outputItem = new ItemStack(XenItems.graphite, 8);

            craftEffect = Fx.pulverizeMedium;
        }};
    }
}
