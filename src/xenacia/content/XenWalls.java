package xenacia.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class XenWalls{
    public static Block
            ironWall, ironWallLarge, bulkIronWall, bulkIronWallLarge, bulkIronWallHuge,
            graphiteWall, graphiteWallLarge, bulkGraphiteWall, bulkGraphiteWallLarge, bulkGraphiteWallHuge,
            titaniumAlloyWall, titaniumAlloyWallLarge, bulkTitaniumAlloyWall, bulkTitaniumAlloyWallLarge, bulkTitaniumAlloyWallHuge,
            cobaltWall, cobaltWallLarge, bulkCobaltWall, bulkCobaltWallLarge, bulkCobaltWallHuge;

    public static void load(){
        //iron
        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(XenItems.iron, 6));
            health = 400;
            armor = 2;
            size = 1;
            researchCost = with(XenItems.iron, 100);
        }};
        ironWallLarge = new Wall("iron-wall-large"){{
            requirements(Category.defense, with(XenItems.iron, 6 * 4));
            health = 400 * 4;
            armor = 2;
            size = 2;
            researchCost = with(XenItems.iron, 800);
        }};
        bulkIronWall = new Wall("bulk-iron-wall"){{
            requirements(Category.defense, with(XenItems.iron, 10 * 4, XenItems.aluminum, 4 * 4));
            health = 400 * 2 * 4;
            armor = 6;
            size = 2;
            researchCost = with(XenItems.iron, 1200, XenItems.aluminum, 800);
        }};
        bulkIronWallLarge = new Wall("bulk-iron-wall-large"){{
            requirements(Category.defense, with(XenItems.iron, 10 * 9, XenItems.aluminum, 4 * 9));
            health = 400 * 2 * 9;
            armor = 6;
            size = 3;
            researchCost = with(XenItems.iron, 2000, XenItems.aluminum, 1000);
        }};
        bulkIronWallHuge = new Wall("bulk-iron-wall-huge"){{
            requirements(Category.defense, with(XenItems.iron, 10 * 16, XenItems.aluminum, 4 * 16));
            health = 400 * 2 * 16;
            armor = 6;
            size = 4;
            researchCost = with(XenItems.iron, 2000, XenItems.aluminum, 1000);
        }};
        //graphite
        graphiteWall = new Wall("graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 6, XenItems.aluminum, 2));
            health = 550;
            armor = 2;
            size = 1;
            researchCost = with(Items.graphite, 600, XenItems.aluminum, 300);
        }};
        graphiteWallLarge = new Wall("graphite-wall-large"){{
            requirements(Category.defense, with(Items.graphite, 6 * 4, XenItems.aluminum, 2 * 4));
            health = 550 * 4;
            armor = 2;
            size = 2;
            researchCost = with(Items.graphite, 1500, XenItems.aluminum, 800);
        }};
        bulkGraphiteWall = new Wall("bulk-graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 10 * 4, XenItems.iron, 4 * 4));
            health = 550 * 2 * 4;
            armor = 6;
            size = 2;
            researchCost = with(Items.graphite, 2000, XenItems.iron, 1000);
        }};
        bulkGraphiteWallLarge = new Wall("bulk-graphite-wall-large"){{
            requirements(Category.defense, with(Items.graphite, 10 * 9, XenItems.iron, 4 * 9));
            health = 550 * 2 * 9;
            armor = 6;
            size = 3;
            researchCost = with(Items.graphite, 2500, XenItems.iron, 1500);
        }};
        bulkGraphiteWallHuge = new Wall("bulk-graphite-wall-huge"){{
            requirements(Category.defense, with(Items.graphite, 10 * 16, XenItems.iron, 4 * 16));
            health = 550 * 2 * 16;
            armor = 6;
            size = 4;
            researchCost = with(Items.graphite, 3000, XenItems.iron, 2000);
        }};
        //titanium alloy
        titaniumAlloyWall = new Wall("titanium-alloy-wall"){{
            requirements(Category.defense, with(Items.titanium, 6,Items.graphite, 2, XenItems.iron, 4));
            health = 1050;
            armor = 4;
            size = 1;
            researchCost = with(Items.titanium, 600,Items.graphite, 300, XenItems.iron, 300);
        }};
        titaniumAlloyWallLarge = new Wall("titanium-alloy-wall-large"){{
            requirements(Category.defense, with(Items.titanium, 6 * 4,Items.graphite, 2 * 4, XenItems.iron, 4 * 4));
            health = 1050 * 4;
            armor = 4;
            size = 2;
            researchCost = with(Items.titanium, 1500,Items.graphite, 800, XenItems.iron, 800);
        }};
        bulkTitaniumAlloyWall = new Wall("bulk-titanium-alloy-wall"){{
            requirements(Category.defense, with(Items.titanium, 10 * 4,Items.graphite, 4 * 4, XenItems.iron, 6 * 4));
            health = 1050 * 2 * 4;
            armor = 10;
            size = 2;
            researchCost = with(Items.titanium, 2000,Items.graphite, 1000, XenItems.iron, 1000);
        }};
        bulkTitaniumAlloyWallLarge = new Wall("bulk-titanium-alloy-wall-large"){{
            requirements(Category.defense, with(Items.titanium, 10 * 9,Items.graphite, 4 * 9, XenItems.iron, 6 * 9));
            health = 1050 * 2 * 4;
            armor = 10;
            size = 3;
            researchCost = with(Items.titanium, 2500,Items.graphite, 1500, XenItems.iron, 1500);
        }};
        bulkTitaniumAlloyWallHuge = new Wall("bulk-titanium-alloy-wall-huge"){{
            requirements(Category.defense, with(Items.titanium, 10 * 16,Items.graphite, 4 * 16, XenItems.iron, 6 * 16));
            health = 1050 * 2 * 4;
            armor = 10;
            size = 4;
            researchCost = with(Items.titanium, 3000,Items.graphite, 2000, XenItems.iron, 2000);
        }};
        //cobalt
        cobaltWall = new Wall("cobalt-wall"){{
            requirements(Category.defense, with(XenItems.cobalt, 8));
            health = 1300;
            armor = 4;
            size = 1;
            researchCost = with(XenItems.cobalt, 1000);
        }};
        cobaltWallLarge = new Wall("cobalt-wall-large"){{
            requirements(Category.defense, with(XenItems.cobalt, 8 * 4));
            health = 1300 * 4;
            armor = 4;
            size = 2;
            researchCost = with(XenItems.cobalt, 2000);
        }};
        bulkCobaltWall = new Wall("bulk-cobalt-wall"){{
            requirements(Category.defense, with(XenItems.cobalt, 14 * 4,Items.titanium, 10 * 4));
            health = 1300 * 2 * 4;
            armor = 12;
            size = 2;
            researchCost = with(XenItems.cobalt, 5000,Items.titanium, 2000);
        }};
        bulkCobaltWallLarge = new Wall("bulk-cobalt-wall-large"){{
            requirements(Category.defense, with(XenItems.cobalt, 14 * 9,Items.titanium, 10 * 9));
            health = 1300 * 2 * 9;
            armor = 12;
            size = 3;
            researchCost = with(XenItems.cobalt, 10000,Items.titanium, 4000);
        }};
        bulkCobaltWallHuge = new Wall("bulk-cobalt-wall-huge"){{
            requirements(Category.defense, with(XenItems.cobalt, 14 * 16,Items.titanium, 10 * 16));
            health = 1300 * 2 * 16;
            armor = 12;
            size = 4;
            researchCost = with(XenItems.cobalt, 15000,Items.titanium, 8000);
        }};
    }
}
