package xenacia.content;

import arc.graphics.Color;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.liquid.*;
import mindustry.content.*;
import mindustry.world.blocks.storage.StorageBlock;
import xenacia.world.blocks.fluids.TeamLiquidRouter;

import static mindustry.type.ItemStack.*;

public class XenStorage{
    public static Block
            smallVault, largeVault, bulkVault, resourcePayloadTransportVault;
    public static void load(){
        smallVault = new StorageBlock("small-vault"){{
            requirements(Category.effect, with(XenItems.iron, 100, Items.graphite, 50));
            health = 480;
            size = 2;
            itemCapacity = 500;

            researchCostMultiplier = 1f;
        }};
        largeVault = new StorageBlock("large-vault"){{
            requirements(Category.effect, with(XenItems.iron, 300, Items.titanium, 250));
            health = 1080;
            size = 3;
            itemCapacity = 1500;

            researchCostMultiplier = 1f;
        }};
        bulkVault = new StorageBlock("large-vault"){{
            requirements(Category.effect, with(XenItems.iron, 300, Items.titanium, 250));
            health = 1080;
            size = 3;
            itemCapacity = 1500;

            researchCostMultiplier = 1f;
        }};
}
