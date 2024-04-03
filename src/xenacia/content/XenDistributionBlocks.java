package xenacia.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.Router;

import static mindustry.type.ItemStack.with;

public class XenDistributionBlocks{
    public static Block
            itemTunnel, itemTunnelRouter, itemTunnelJunction;

    public static void load(){
        itemTunnel = new Duct("item-tunnel"){{
            requirements(Category.distribution, with(XenItems.alamex, 1));
            health = 70;
            speed = 8f;
        }};
        itemTunnelRouter = new Router("item-tunnel-router"){{
            requirements(Category.distribution, with(XenItems.alamex, 5));
            health = 80;
        }};
        itemTunnelJunction = new Junction("item-tunnel-junction"){{
            requirements(Category.distribution, with(XenItems.alamex, 3));
            speed = 30;
            capacity = 5;
            health = 80;
        }};
    }
}
