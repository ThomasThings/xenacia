package xenacia.content;

import arc.graphics.*;
import mindustry.type.*;

public class XenItems{
    public static Item
            iron, aluminum, stone, peat, bismuth, lithium, amethyst, polonium, meteorFragment,
            neodymium, cobalt, volcrite, lunarRegolith, lunarAlloy;

    public static void load(){
        iron = new Item("iron", Color.valueOf("9d8e8e")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            alwaysUnlocked = true;
            hardness = 2;
            cost = 1f;
        }};
        aluminum = new Item("aluminum", Color.valueOf("d0d0e0")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            alwaysUnlocked = true;
            hardness = 2;
            cost = 1f;
        }};
        stone = new Item("stone", Color.valueOf("656b72")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            lowPriority = true;
            hardness = 1;
            cost = 1f;
        }};
        peat = new Item("peat", Color.valueOf("283425")){{
            explosiveness = 0.10f;
            flammability = 0.9f;
            radioactivity = 0f;
            charge = 0f;

            buildable = false;
            hardness = 2;
            cost = 1f;
        }};
        bismuth = new Item("bismuth", Color.valueOf("567fd2")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            hardness = 3;
            cost = 2f;
        }};
        lithium = new Item("lithium", Color.valueOf("a3aaa4")){{
            explosiveness = 0f;
            flammability = 0.3f;
            radioactivity = 0f;
            charge = 0.2f;

            hardness = 4;
            cost = 2f;
        }};
        amethyst = new Item("amethyst", Color.valueOf("713383")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            hardness = 3;
            cost = 1f;
        }};
        polonium = new Item("polonium", Color.valueOf("a8c7d0")){{
            explosiveness = 0.3f;
            flammability = 0f;
            radioactivity = 1f;
            charge = 0.2f;

            hardness = 5;
            cost = 1f;
        }};
        meteorFragment = new Item("meteor-fragment", Color.valueOf("27313c")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            hardness = 4;
            buildable = false;
        }};
        neodymium = new Item("neodymium", Color.valueOf("434445")){{
            explosiveness = 0.1f;
            flammability = 0f;
            radioactivity = 0.3f;
            charge = 0f;

            cost = 1;
        }};
        cobalt = new Item("cobalt", Color.valueOf("53539f")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            hardness = 5;
            cost = 2f;
        }};
        volcrite = new Item("volcrite", Color.valueOf("ca972d")){{
            explosiveness = 0.2f;
            flammability = 0f;
            radioactivity = 0.2f;
            charge = 0.7f;

            cost = 2f;
        }};
        lunarRegolith = new Item("lunar-regolith", Color.valueOf("deedf1")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;
            lowPriority = true;
            hardness = 1;
            buildable = false;
        }};
        lunarAlloy = new Item("lunar-alloy", Color.valueOf("88989d")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            cost = 3f;
        }};
    }
}