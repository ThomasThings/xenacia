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
            requirements(Category.effect, with(Items.titanium, 100));
            size = 2;
            itemCapacity = 300;
            health = 480;

            researchCost = with(XenItems.aluminum, 100, Items.graphite, 100);
        }};
    }
}
