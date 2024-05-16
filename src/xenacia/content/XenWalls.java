package xenacia.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static mindustry.type.ItemStack.with;

public class XenWalls{
    public static Block
            torrenWall, torrenWallLarge, brightCheckerWall, darkCheckerWall ;

    public static void load(){

        int wallHealthMultiplier = 4;

        torrenWall = new Wall("torren-wall"){{
            requirements(Category.defense, with(XenItems.torren, 6));
            health = 125 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
        }};
        torrenWallLarge = new Wall("torren-wall-large"){{
            requirements(Category.defense, ItemStack.mult(torrenWall.requirements, 4));
            health = 125 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
        }};
        brightCheckerWall = new Wall("bright-checker-wall"){{
            requirements(Category.defense, with(XenItems.alamex, 1));
            health = 5 * wallHealthMultiplier;
        }};
        darkCheckerWall = new Wall("dark-checker-wall"){{
            requirements(Category.defense, with(XenItems.alamex, 1));
            health = 5 * wallHealthMultiplier;
        }};
    }
}
