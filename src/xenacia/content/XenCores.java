package xenacia.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class XenCores{
    public static Block
            coreDevise, coreContrive,
            coreDoctrine, coreOccult;

    public static void load(){
        coreDevise = new CoreBlock("core-devise"){{
            requirements(Category.effect, with(XenItems.alamex, 850));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = XenUnitTypes.radix;
            health = 1250;
            itemCapacity = 1500;
            size = 2;

            unitCapModifier = 4;
            squareSprite = false;
        }};
        coreContrive = new CoreBlock("core-contrive"){{
            requirements(Category.effect, with(XenItems.alamex, 1200, XenItems.torren, 500));
            alwaysUnlocked = true;

            isFirstTier = false;
            unitType = XenUnitTypes.refine;
            health = 2500;
            itemCapacity = 5000;
            size = 3;

            unitCapModifier = 8;
            squareSprite = false;
        }};
        coreDoctrine = new CoreBlock("core-doctrine"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(XenItems.alamex, 550, XenItems.lenora, 350));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = XenUnitTypes.radix;
            health = 1400;
            itemCapacity = 1500;
            size = 2;

            unitCapModifier = 6;
            squareSprite = false;
        }};
        coreOccult = new CoreBlock("core-occult"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(XenItems.alamex, 1000, XenItems.torren, 400, XenItems.lenora, 600));
            alwaysUnlocked = true;

            isFirstTier = false;
            unitType = XenUnitTypes.radix;
            health = 3000;
            itemCapacity = 4000;
            size = 3;

            unitCapModifier = 12;
            squareSprite = false;
        }};
    }
}
