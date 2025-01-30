package xenacia.content;

import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidRouter;

import static mindustry.type.ItemStack.with;

public class XenFluidBlocks{
    public static Block
            passflowConduit, passflowConduitRouter, passflowTank;

    public static void load(){
        passflowConduit = new Conduit("passflow-conduit"){{
            requirements(Category.liquid, with(XenItems.alamex, 1, XenItems.lenora, 1));
            health = 50;
            botColor = Color.valueOf("2d282e");

            researchCost = with(XenItems.alamex, 15, XenItems.lenora, 25);
        }};
        passflowConduitRouter = new LiquidRouter("passflow-conduit-router"){{
            requirements(Category.liquid, with(XenItems.alamex, 3, XenItems.lenora, 1));
            health = 70;

            researchCost = with(XenItems.alamex, 20, XenItems.lenora, 35);
        }};
        passflowTank = new LiquidRouter("small-fluid-tank"){{
            requirements(Category.liquid, with(XenItems.alamex, 100, XenItems.lenora, 40));
            health = 400;
            size = 2;
            liquidCapacity = 500f;
            liquidPadding = 2f;
            underBullets = false;
            squareSprite = false;
            solid = true;

            researchCostMultiplier = 1f;
        }};
    }
}
