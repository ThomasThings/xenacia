package xenacia.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class XenItems{
    public static Item
    alamex, torren, silicateSand, carbonFuel, silicium;
    public static void load(){

        alamex = new Item("alamex", Color.valueOf("bfbfcf")){{
            hardness = 1;
            cost = 0.5f;
        }};
        torren = new Item("torren", Color.valueOf("7d7da3")){{
            hardness = 2;
            cost = 0.6f;
        }};
        silicateSand = new Item("silicate-sand", Color.valueOf("e8caab")){{
            lowPriority = true;
            buildable = false;
            alwaysUnlocked = true;
        }};
        carbonFuel = new Item("carbon-fuel", Color.valueOf("1e1d1d")){{
            flammability = 0.6f;
            buildable = false;
        }};
        silicium = new Item("silicium", Color.valueOf("4b5554")){{
            cost = 1;
        }};
    }
}
