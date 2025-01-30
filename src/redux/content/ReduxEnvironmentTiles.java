package redux.content;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;

public class ReduxEnvironmentTiles{
    public static Block
            testFloor, testWall;
    public static void load(){

        testFloor = new Floor("test-floor"){{
            mapColor = Color.valueOf("3e3243");
        }};
        testWall = new StaticWall("test-wall"){{
            mapColor = Color.valueOf("3e3243");
        }};
    }
}
