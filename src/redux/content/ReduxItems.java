package redux.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class ReduxItems{
    public static Item
    copper;
    public static void load(){

        copper = new Item("copper", Color.valueOf("74a492")){{
            hardness = 1;
            cost = 0.5f;
        }};
    }
}
