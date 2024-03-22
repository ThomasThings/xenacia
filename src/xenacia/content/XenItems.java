package xenacia.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class XenItems{
    public static Item
    silicateSand;
    public static void load(){

        silicateSand = new Item("silicate-sand", Color.valueOf("e8caab")){{
            lowPriority = true;
            buildable = false;
            alwaysUnlocked = true;
        }};
    }
}
