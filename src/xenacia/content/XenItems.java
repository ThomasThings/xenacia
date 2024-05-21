package xenacia.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class XenItems{
    public static Item
    alamex, torren, veilla, silicateSand, biomass, carbonFuel, silicium;
    public static void load(){

        alamex = new Item("alamex", Color.valueOf("bfbfcf")){{
            hardness = 1;
            cost = 0.5f;
        }};
        torren = new Item("torren", Color.valueOf("7d7da3")){{
            hardness = 2;
            cost = 0.6f;
        }};
        veilla = new Item("veilla", Color.valueOf("c4c1ee")){{
            hardness = 1;
            cost = 0.2f;
            explosiveness = 0.5f;
        }};
        silicateSand = new Item("silicate-sand", Color.valueOf("e8caab")){{
            lowPriority = true;
            buildable = false;
            alwaysUnlocked = true;
        }};
        biomass = new Item("biomass", Color.valueOf("3c7d53")){{
            hidden = true;
            flammability = 1.2f;
            buildable = false;
        }};
        carbonFuel = new Item("carbon-fuel", Color.valueOf("1e1d1d")){{
            hidden = true;
            flammability = 0.6f;
            buildable = false;
        }};
        silicium = new Item("silicium", Color.valueOf("4b5554")){{
            cost = 1;
        }};
    }
}
