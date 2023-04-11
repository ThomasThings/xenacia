package xenacia.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.type.ItemStack.*;

public class XenCores{
    public static Block
            coreCradle, coreDerive, coreInception, coreBreakpoint;
    public static void load() {
        coreCradle = new CoreBlock("core-cradle"){{
            requirements(Category.effect, with(XenItems.iron, 800, XenItems.aluminum, 500));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = XenUnitTypes.period;
            health = 5000;
            armor = 5f;
            itemCapacity = 1000;
            size = 2;
            thrusterLength = 34/4f;

            unitCapModifier = 6;
        }};
        coreDerive = new CoreBlock("core-derive"){{
            requirements(Category.effect, with(XenItems.iron, 1000, XenItems.aluminum, 1000, Items.graphite, 1000));

            unitType = XenUnitTypes.moment;
            health = 22000;
            armor = 5f;
            itemCapacity = 5000;
            size = 3;
            thrusterLength = 34/4f;

            unitCapModifier = 14;
        }};
        coreInception = new CoreBlock("core-inception"){{
            requirements(Category.effect, with(XenItems.iron, 3000, XenItems.aluminum, 3000, Items.graphite, 3000, Items.silicon, 2000, Items.titanium, 1500));

            unitType = XenUnitTypes.dawn;
            health = 46000;
            armor = 10f;
            itemCapacity = 10000;
            size = 4;
            thrusterLength = 34/4f;

            unitCapModifier = 24;
        }};
        coreBreakpoint = new CoreBlock("core-breakpoint"){{
            requirements(Category.effect, with(XenItems.iron, 9000, XenItems.aluminum, 9000, Items.titanium, 7000, Items.graphite, 5000, Items.silicon, 5000,  XenItems.polonium, 3000));

            unitType = XenUnitTypes.dusk;
            health = 68000;
            armor = 15f;
            itemCapacity = 20000;
            size = 5;
            thrusterLength = 34/4f;

            unitCapModifier = 32;
        }};
    }
}
