package xenacia.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class XenItems{
    public static Item
    alamex, torren, veilla, vrensteel;
    public static void load(){

        alamex = new Item("alamex", Color.valueOf("bfbfcf")){{
            hardness = 1;
            cost = 0.5f;
        }};
        torren = new Item("torren", Color.valueOf("7d7da3")){{
            hardness = 2;
            cost = 0.6f;
        }};
        veilla = new Item("veilla", Color.valueOf("edf1fd")){{
            hardness = 1;
            cost = 0.2f;
            explosiveness = 0.5f;
        }};
        vrensteel = new Item("vrensteel", Color.valueOf("546569")){{
            cost = 1;
        }};
    }
}
