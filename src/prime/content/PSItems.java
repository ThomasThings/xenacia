package prime.content;

import arc.graphics.*;
import mindustry.type.*;

public class PSItems{
    public static Item
            aluminum;

    public static void load(){
        aluminum = new Item("aluminum", Color.valueOf("d0d0e0")){{
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            charge = 0f;

            hardness = 3;
            cost = 1f;
        }};
    }
}