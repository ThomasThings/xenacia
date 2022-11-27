package xenacia.content;

import arc.graphics.Color;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.liquid.*;
import mindustry.content.*;
import xenacia.world.blocks.fluids.TeamLiquidRouter;

import static mindustry.type.ItemStack.*;

public class XenFluidBlocks{
    public static Block
            fluidPipe, armoredFluidPipe, fluidRouter, fluidJunction, bridgePipe,
            smallFluidTank, largeFluidTank, bulkFluidTank,
            fluidPayloadTransportTank;

    public static void load(){
        fluidPipe = new Conduit("fluid-pipe"){{
            requirements(Category.liquid, with(XenItems.aluminum, 1, Items.graphite, 1));
            health = 80;
            botColor = Color.valueOf("2d282e");

            researchCost = with(XenItems.aluminum, 80, Items.graphite, 80);
        }};
        armoredFluidPipe = new Conduit("armored-fluid-pipe"){{
            requirements(Category.liquid, with(XenItems.cobalt, 2, XenItems.aluminum, 3, Items.graphite, 2));
            health = 200;
            leaks = false;
            botColor = Color.valueOf("2d282e");

            researchCost = with(XenItems.cobalt, 200, XenItems.aluminum, 150, Items.graphite, 150);
        }};
        fluidRouter = new LiquidRouter("fluid-router"){{
            requirements(Category.liquid, with(XenItems.aluminum, 2, Items.graphite, 3));
            health = 80;
            liquidCapacity = 20f;
            liquidPadding = 1.5f;
            underBullets = true;
            squareSprite = false;
            solid = false;

            researchCost = with(XenItems.aluminum, 100, Items.graphite, 100);
        }};
        fluidJunction = new LiquidJunction("fluid-junction"){{
            requirements(Category.liquid, with(XenItems.aluminum, 2, Items.graphite, 3));
            health = 80;
            solid = false;

            ((Conduit)fluidPipe).junctionReplacement = this;
            ((Conduit)armoredFluidPipe).junctionReplacement = this;

            researchCost = with(XenItems.aluminum, 100, Items.graphite, 100);
        }};
        bridgePipe = new DirectionLiquidBridge("bridge-pipe"){{
            requirements(Category.liquid, with(XenItems.aluminum, 5, Items.graphite, 5));
            health = 80;
            range = 6;
            hasPower = false;
            underBullets = true;
            squareSprite = false;

            ((Conduit)fluidPipe).rotBridgeReplacement = this;
            ((Conduit)armoredFluidPipe).rotBridgeReplacement = this;

            researchCost = with(XenItems.aluminum, 150, Items.graphite, 150);
        }};
        smallFluidTank = new LiquidRouter("small-fluid-tank"){{
            requirements(Category.liquid, with(XenItems.iron, 80, XenItems.aluminum, 30));
            health = 480;
            size = 2;
            liquidCapacity = 500f;
            liquidPadding = 2f;
            underBullets = false;
            squareSprite = false;
            solid = true;

            researchCostMultiplier = 1f;
        }};
        largeFluidTank = new LiquidRouter("large-fluid-tank"){{
            requirements(Category.liquid, with(XenItems.iron, 200, Items.titanium, 100, XenItems.aluminum, 100));
            health = 1080;
            size = 3;
            liquidCapacity = 2000f;
            liquidPadding = 2f;
            underBullets = false;
            squareSprite = false;
            solid = true;

            researchCostMultiplier = 1f;
        }};
        bulkFluidTank = new TeamLiquidRouter("bulk-fluid-tank"){{
            requirements(Category.liquid, with(XenItems.aluminum, 400, Items.graphite, 400, XenItems.cobalt, 500));
            health = 3000;
            size = 5;
            liquidCapacity = 10000f;
            liquidPadding = 3.5f;
            underBullets = false;
            squareSprite = false;
            solid = true;

            researchCostMultiplier = 1f;
        }};
        fluidPayloadTransportTank = new TeamLiquidRouter("fluid-payload-transport-tank"){{
            requirements(Category.liquid, with(XenItems.aluminum, 1000, Items.graphite, 800, XenItems.cobalt, 800, XenItems.volcrite, 1000));
            health = 6400;
            size = 7;
            liquidCapacity = 30000f;
            liquidPadding = 8f;
            underBullets = false;
            squareSprite = false;
            solid = true;

            researchCostMultiplier = 1.5f;
        }};
    }
}
