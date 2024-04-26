package xenacia.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class XenCores{
    public static Block
            coreContrive;

    public static void load(){
        coreContrive = new CoreBlock("core-contrive"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(XenItems.alamex, 1200, XenItems.torren, 500));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = XenUnitTypes.radix;
            health = 2500;
            itemCapacity = 5000;
            size = 3;

            unitCapModifier = 6;
            squareSprite = false;
        }};
    }
}
