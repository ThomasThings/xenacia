package xenacia.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class XenItems{
    public static Item
            aluminum, iron,
            biomass, xenCoal, xenGraphite,
            stone, xenSand, xenSilicon, lithium,
            xenBeryllium, xenTitanium, cobalt,
            amethyst, meteorFragment, polonium, neodymium,
            xenTungsten, xenCarbide, volcrite, torrentAlloy;

    public static final Seq<Item> xenaciaItems = new Seq<>();

    public static void load(){
        aluminum = new Item("aluminum", Color.valueOf("bfbfcf")){{
            hardness = 2;
            cost = 0.5f;
            healthScaling = 0.1f;
        }};
        iron = new Item("iron", Color.valueOf("a98b83")){{
            hardness = 2;
            cost = 0.5f;
            healthScaling = 0.1f;
        }};
        biomass = new Item("biomass", Color.valueOf("283425")){{
            flammability = 1.5f;

            hardness = 1;
            lowPriority = true;
            buildable = false;
        }};
        /*xenCoal = new Item("xen-coal", Color.valueOf("2a2a2a")){{
            explosiveness = 0.2f;
            flammability = 1.2f;

            hardness = 1;
            buildable = false;
        }};*/
        /*xenGraphite = new Item("xen-graphite", Color.valueOf("8193b9")){{
            hardness = 3;
            cost = 0.8f;
            healthScaling = 0.2f;
        }};*/
        stone = new Item("stone", Color.valueOf("666e77")){{
            hardness = 2;
            lowPriority = true;
            buildable = false;
        }};
        /*xenSand = new Item("xen-sand", Color.valueOf("f7cba4")){{
            hardness = 1;
            lowPriority = true;
            buildable = false;
        }};*/
        /*xenSilicon = new Item("xen-silicon", Color.valueOf("48485d")){{
            cost = 0.5f;
            healthScaling = 0.15f;
        }};*/
        lithium = new Item("lithium", Color.valueOf("9baa9d")){{
            explosiveness = 0.7f;
            flammability = 0.6f;
            charge = 0.4f;

            hardness = 2;
            cost = 0.8f;
        }};
        /*xenBeryllium = new Item("xen-beryllium", Color.valueOf("3f8b64")){{
            hardness = 3;
            cost = 1f;
            healthScaling = 0.3f;
        }};*/
        /*xenTitanium = new Item("xen-titanium", Color.valueOf("8d9ae0")){{
            hardness = 3;
            cost = 1f;
            healthScaling = 0.5f;
        }};*/
        cobalt = new Item("cobalt", Color.valueOf("3b3b69")){{
            hardness = 4;
            cost = 1.2f;
            healthScaling = 0.8f;
        }};
        amethyst = new Item("amethyst", Color.valueOf("713383")){{
            hardness = 2;
            buildable = false;
        }};
        meteorFragment = new Item("meteor-fragment", Color.valueOf("323940")){{
            explosiveness = 0.05f;
            radioactivity = 0.2f;
            charge = 0.05f;

            hardness = 3;
            buildable = false;
        }};
        polonium = new Item("polonium", Color.valueOf("a8c7d0")){{
            explosiveness = 0.2f;
            radioactivity = 1f;

            hardness = 5;
            cost = 1.5f;
            healthScaling = 0.8f;
        }};
        neodymium = new Item("neodymium", Color.valueOf("424548")){{
            hardness = 4;
            cost = 1f;
        }};
        /*xenTungsten = new Item("xen-tungsten", Color.valueOf("534171")){{
            hardness = 5;
            cost = 1.5f;
            healthScaling = 1.2f;
        }};*/
        /*xenCarbide = new Item("xen-carbide", Color.valueOf("534171")){{
            hardness = 1;
            cost = 1.5f;
            healthScaling = 1.6f;
        }};*/
        volcrite = new Item("volcrite", Color.valueOf("483529")){{
            hardness = 1;
            cost = 1.5f;
            hidden = true;
            healthScaling = 2f;
        }};
        torrentAlloy = new Item("torrent-alloy", Color.valueOf("90524d")){{
            explosiveness = 0.2f;
            radioactivity = 0.4f;
            charge = 0.8f;

            hardness = 1;
            cost = 2f;
            healthScaling = 2.5f;
        }};


        xenaciaItems.addAll();
    }
}