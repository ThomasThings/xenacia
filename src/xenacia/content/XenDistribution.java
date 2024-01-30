package xenacia.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import xenacia.world.blocks.distribution.Rail;

import static mindustry.type.ItemStack.with;

public class XenDistribution{
    public static Block
            rail, poweredRail, bulkRail, armoredRail,
            railRouter, bulkRailRouter, railJunction, railBridge;

    public static void load(){
        rail = new Rail("rail"){{
            requirements(Category.distribution, with(XenItems.iron, 1, XenItems.aluminum, 1));
            health = 80;
            speed = 2.5f / 60f;
            itemCapacity = 5;

            researchCost = with(XenItems.iron, 20, XenItems.aluminum, 20);
        }};
        poweredRail = new StackConveyor("powered-rail"){{
            requirements(Category.distribution, with(XenItems.iron, 2,XenItems.xenSilicon, 2));
            health = 100;
            speed = 5f / 60f;
            itemCapacity = 10;

            outputRouter = false;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;

            baseEfficiency = 1f;
            consumePower(1f / 60f);

            researchCost = with(XenItems.iron, 200,XenItems.xenSilicon, 200);
        }};
        bulkRail = new StackConveyor("bulk-rail"){{
            requirements(Category.distribution, with(XenItems.iron, 3,XenItems.xenTitanium, 2,XenItems.xenSilicon, 2));
            health = 100;
            speed = 5f / 60f;
            itemCapacity = 20;

            outputRouter = false;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;

            baseEfficiency = 1f;
            consumePower(1.5f / 60f);

            researchCost = with(XenItems.iron, 250,XenItems.xenTitanium, 250,XenItems.xenSilicon, 250);
        }};
        armoredRail = new Duct("armored-rail"){{
            requirements(Category.distribution, with(XenItems.iron, 2, XenItems.cobalt, 2,XenItems.xenSilicon, 2));
            health = 180;
            speed = 5f;
            researchCost = with(XenItems.iron, 250,XenItems.xenTitanium, 250,XenItems.xenSilicon, 250);
        }};
        railRouter = new StackRouter("rail-router"){{
            requirements(Category.distribution, with(XenItems.iron, 2, XenItems.aluminum, 2));
            health = 80;
            speed = 5f;

            hasPower = true;
            consumesPower = false;
            conductivePower = true;

            underBullets = true;
            solid = false;
            researchCost = with(XenItems.iron, 20, XenItems.aluminum, 20);
        }};
        bulkRailRouter = new StackRouter("bulk-rail-router"){{
            requirements(Category.distribution, with(XenItems.iron, 4,XenItems.xenTitanium, 4,XenItems.xenSilicon, 2));
            health = 100;
            speed = 5f;

            hasPower = true;
            consumesPower = true;
            conductivePower = true;

            baseEfficiency = 1f;
            consumePower(1.5f / 60f);

            underBullets = true;
            solid = false;
            researchCost = with(XenItems.iron, 250,XenItems.xenTitanium, 250,XenItems.xenSilicon, 250);
        }};
        railJunction = new Junction("rail-junction"){{
            requirements(Category.distribution, with(XenItems.iron, 2, XenItems.aluminum, 2));
            speed = 50;
            capacity = 10;
            health = 80;

            hasPower = true;
            consumesPower = false;
            conductivePower = true;

            researchCost = with(XenItems.iron, 100, XenItems.aluminum, 100);
        }};
        railBridge = new DuctBridge("rail-bridge"){{
            requirements(Category.distribution, with(XenItems.iron, 5, XenItems.aluminum, 15));
            health = 100;
            speed = 5f;
            range = 6;

            hasPower = true;
            consumesPower = false;
            conductivePower = true;

            researchCost = with(XenItems.iron, 150, XenItems.aluminum, 200);
        }};
    }
}
