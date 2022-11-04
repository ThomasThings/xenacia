package prime.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class PSWalls{
    public static Block
            ironWall, ironWallLarge, bulkIronWall, bulkIronWallLarge, bulkIronWallHuge, graphiteWall, graphiteWallLarge,
            bulkGraphiteWall, bulkGraphiteWallLarge, bulkGraphiteWallHuge;

    public static void load(){
        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(PSItems.iron, 6));
            health = 400;
            size = 1;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        ironWallLarge = new Wall("iron-wall-large"){{
            requirements(Category.defense, with(PSItems.iron, 6 * 4));
            health = 400 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkIronWall = new Wall("bulk-iron-wall"){{
            requirements(Category.defense, with(PSItems.iron, 9 * 4));
            health = 400 * 2 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkIronWallLarge = new Wall("bulk-iron-wall-large"){{
            requirements(Category.defense, with(PSItems.iron, 9 * 9));
            health = 400 * 2 * 9;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkIronWallHuge = new Wall("bulk-iron-wall-huge"){{
            requirements(Category.defense, with(PSItems.iron, 9 * 16));
            health = 400 * 2 * 16;
            size = 4;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        graphiteWall = new Wall("graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 4, PSItems.aluminum, 4));
            health = 450;
            size = 1;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        graphiteWallLarge = new Wall("graphite-wall-large"){{
            requirements(Category.defense, with(Items.graphite, 4 * 4, PSItems.aluminum, 4 * 4));
            health = 450 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkGraphiteWall = new Wall("bulk-graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 6 * 4, PSItems.aluminum, 6 * 4));
            health = 450 * 2 * 4;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkGraphiteWallLarge = new Wall("bulk-graphite-wall-large"){{
            requirements(Category.defense, with(Items.graphite, 6 * 9, PSItems.aluminum, 6 * 9));
            health = 450 * 2 * 9;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        bulkGraphiteWallHuge = new Wall("bulk-graphite-wall-huge"){{
            requirements(Category.defense, with(Items.graphite, 6 * 16, PSItems.aluminum, 6 * 16));
            health = 450 * 2 * 16;
            size = 4;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
    }
}