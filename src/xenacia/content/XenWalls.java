package xenacia.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static mindustry.type.ItemStack.with;

public class XenWalls{
    public static Block
            torrenWall, torrenWallLarge, alamexWall, alamexWallLarge;

    public static void load(){

        int wallHealthMultiplier = 4;

        alamexWall = new Wall("alamex-wall"){{
            requirements(Category.defense, with(XenItems.alamex, 6));
            health = 125 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
        }};
        alamexWallLarge = new Wall("alamex-wall-large"){{
            requirements(Category.defense, ItemStack.mult(alamexWall.requirements, 4));
            health = 125 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
        }};
        torrenWall = new Wall("torren-wall"){{
            requirements(Category.defense, with(XenItems.torren, 6));
            health = 200 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
        }};
        torrenWallLarge = new Wall("torren-wall-large"){{
            requirements(Category.defense, ItemStack.mult(torrenWall.requirements, 4));
            health = 200 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
        }};
    }
}
