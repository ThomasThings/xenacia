package xenacia.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.storage.StorageBlock;

import static mindustry.type.ItemStack.*;

public class XenStorage{
    public static Block
            smallVault, largeVault, bulkVault, resourcePayloadTransportVault;
    public static void load() {
        smallVault = new StorageBlock("small-vault") {{
            requirements(Category.effect, with(XenItems.iron, 100, Items.graphite, 50));
            health = 560;
            size = 2;
            itemCapacity = 500;

            researchCostMultiplier = 1f;
        }};
        largeVault = new StorageBlock("large-vault") {{
            requirements(Category.effect, with(XenItems.iron, 300, Items.titanium, 250));
            health = 1260;
            size = 3;
            itemCapacity = 1500;

            researchCostMultiplier = 1f;
        }};
        bulkVault = new StorageBlock("bulk-vault") {{
            requirements(Category.effect, with(XenItems.iron, 500, Items.titanium, 350, XenItems.cobalt, 500));
            health = 3500;
            size = 5;
            itemCapacity = 5000;

            researchCostMultiplier = 1f;
        }};
        resourcePayloadTransportVault = new StorageBlock("resource-payload-transport-vault") {{
            requirements(Category.effect, with(XenItems.iron, 800, XenItems.cobalt, 1000, XenItems.volcrite, 1000));
            health = 7000;
            size = 7;
            itemCapacity = 30000;
            coreMerge = false;

            researchCostMultiplier = 1f;
        }};
    }
}
