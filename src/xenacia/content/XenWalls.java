package xenacia.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class XenWalls{
    public static Block
            ironWall, ironWallLarge, bulkIronWall, bulkIronWallLarge, bulkIronWallHuge,
            graphiteWall, graphiteWallLarge, bulkGraphiteWall, bulkGraphiteWallLarge, bulkGraphiteWallHuge,
            bulkTitaniumWall, bulkTitaniumWallLarge, bulkTitaniumWallHuge,
            cobaltWall, cobaltWallLarge, bulkCobaltWall, bulkCobaltWallLarge, bulkCobaltWallHuge;

    public static void load(){
        //iron
        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(XenItems.iron, 6));
            health = 400;
            size = 1;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        ironWallLarge = new Wall("iron-wall-large"){{
            requirements(Category.defense, with(XenItems.iron, 6 * 4));
            health = 400 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkIronWall = new Wall("bulk-iron-wall"){{
            requirements(Category.defense, with(XenItems.iron, 8 * 4, XenItems.aluminum, 4 * 4));
            health = 400 * 2 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkIronWallLarge = new Wall("bulk-iron-wall-large"){{
            requirements(Category.defense, with(XenItems.iron, 8 * 9, XenItems.aluminum, 4 * 9));
            health = 400 * 2 * 9;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkIronWallHuge = new Wall("bulk-iron-wall-huge"){{
            requirements(Category.defense, with(XenItems.iron, 8 * 16, XenItems.aluminum, 4 * 16));
            health = 400 * 2 * 16;
            size = 4;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        //graphite
        graphiteWall = new Wall("graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 4, XenItems.aluminum, 2));
            health = 450;
            size = 1;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        graphiteWallLarge = new Wall("graphite-wall-large"){{
            requirements(Category.defense, with(Items.graphite, 4 * 4, XenItems.aluminum, 2 * 4));
            health = 450 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkGraphiteWall = new Wall("bulk-graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 6 * 4, XenItems.iron, 6 * 4));
            health = 450 * 2 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkGraphiteWallLarge = new Wall("bulk-graphite-wall-large"){{
            requirements(Category.defense, with(Items.graphite, 6 * 9, XenItems.iron, 6 * 9));
            health = 450 * 2 * 9;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkGraphiteWallHuge = new Wall("bulk-graphite-wall-huge"){{
            requirements(Category.defense, with(Items.graphite, 6 * 16, XenItems.iron, 6 * 16));
            health = 450 * 2 * 16;
            size = 4;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        //titanium
        bulkTitaniumWall = new Wall("bulk-titanium-wall"){{
            requirements(Category.defense, with(Items.titanium, 8 * 4, Items.graphite, 4 * 4));
            health = 600 * 2 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkTitaniumWallLarge = new Wall("bulk-titanium-wall-large"){{
            requirements(Category.defense, with(Items.titanium, 8 * 9, Items.graphite, 4 * 9));
            health = 600 * 2 * 9;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkTitaniumWallHuge = new Wall("bulk-titanium-wall-huge"){{
            requirements(Category.defense, with(Items.titanium, 8 * 16, Items.graphite, 4 * 16));
            health = 600 * 2 * 16;
            size = 4;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        //cobalt
        cobaltWall = new Wall("cobalt-wall"){{
            requirements(Category.defense, with(XenItems.cobalt, 6));
            health = 1000;
            size = 1;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        cobaltWallLarge = new Wall("cobalt-wall-large"){{
            requirements(Category.defense, with(XenItems.cobalt, 6 * 4));
            health = 1000 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkCobaltWall = new Wall("bulk-cobalt-wall"){{
            requirements(Category.defense, with(XenItems.cobalt, 8 * 4, Items.titanium, 4 * 4));
            health = 1000 * 2 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkCobaltWallLarge = new Wall("bulk-cobalt-wall-large"){{
            requirements(Category.defense, with(XenItems.cobalt, 8 * 9, Items.titanium, 4 * 9));
            health = 1000 * 2 * 9;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkCobaltWallHuge = new Wall("bulk-cobalt-wall-huge"){{
            requirements(Category.defense, with(XenItems.cobalt, 8 * 16, Items.titanium, 4 * 16));
            health = 1000 * 2 * 16;
            size = 4;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
    }
}