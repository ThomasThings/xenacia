package xenacia.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class XenItems{
    public static Item
            aluminum, iron, stone, biomass, cobalt, metallicOxides, lithium, neodymium, chronatintilium, alterite,
            ferricCompound, torrentAlloy, myaclide, gammasteel, braienasine, crystalineTherius, imparixFiber, spectraglass;

    public static final Seq<Item> xenaciaItems = new Seq<>(), xenaciaOnlyItems = new Seq<>();

    public static void load(){
        aluminum = new Item("aluminum", Color.valueOf("bfbfcf")){{
            hardness = 1;
            cost = 0.5f;

            alwaysUnlocked = true;
        }};
        iron = new Item("iron", Color.valueOf("a98b83")){{
            hardness = 1;
            cost = 0.8f;
        }};
        stone = new Item("stone", Color.valueOf("666e77")){{
            lowPriority = true;

            buildable = false;
        }};
        biomass = new Item("biomass", Color.valueOf("283425")){{
            flammability = 1.4f;

            lowPriority = true;

            buildable = false;
        }};
        cobalt = new Item("cobalt", Color.valueOf("515185")){{
            hardness = 4;
            cost = 1.1f;

            healthScaling = 0.4f;
        }};
        metallicOxides = new Item("metallic-oxides", Color.valueOf("856c5f")){{
            flammability = 0.15f;

            cost = 0.6f;

            healthScaling = -0.2f;
        }};
        lithium = new Item("lithium", Color.valueOf("9baa9d")){{
            explosiveness = 0.25f;
            flammability = 0.75f;
            charge = 0.5f;

            hardness = 3;
            cost = 0.8f;

            healthScaling = 0f;
        }};
        neodymium = new Item("neodymium", Color.valueOf("2c2e34")){{
            charge = 0.2f;

            hardness = 4;

            healthScaling = 0f;
        }};
        chronatintilium = new Item("chronatintilium", Color.valueOf("a8c7d0")){{
            explosiveness = 1f;
            radioactivity = 0.95f;
            charge = 0.85f;

            cost = 1.2f;

            healthScaling = 0.2f;
        }};
        alterite = new Item("alternite", Color.valueOf("8f999b")){{
            charge = 0.2f;

            cost = 1.3f;

            healthScaling = 0.2f;
        }};
        ferricCompound = new Item("ferric-compound", Color.valueOf("45484e")){{
            explosiveness = 0.05f;
            charge = 0.15f;

            healthScaling = 0f;
        }};
        torrentAlloy = new Item("torrent-alloy", Color.valueOf("a1665a")){{
            radioactivity = 0.7f;
            charge = 0.35f;

            cost = 1.5f;

            healthScaling = 0.6f;
        }};
        myaclide = new Item("myaclide", Color.valueOf("588677")){{
            radioactivity = 0.6f;
            charge = 0.4f;

            cost = 1.2f;

            healthScaling = 0.8f;
        }};
        gammasteel = new Item("gammasteel", Color.valueOf("4f7497")){{
            radioactivity = 0.3f;
            charge = 1.5f;

            cost = 2.2f;

            healthScaling = 2f;
        }};
        braienasine = new Item("braienasine", Color.valueOf("788ac0")){{
            explosiveness = 0.85f;
            charge = 0.2f;

            cost = 1.3f;

            healthScaling = 1f;
        }};
        crystalineTherius = new Item("crystaline-therius", Color.valueOf("c4c1ee")){{
            explosiveness = 0.25f;
            radioactivity = 0.3f;
            charge = 0.4f;

            cost = 1.5f;

            healthScaling = 1.5f;
        }};
        imparixFiber = new Item("imparic-fiber", Color.valueOf("cf9666")){{
            explosiveness = 0.1f;
            flammability = 0.85f;
            radioactivity = 0.5f;
            charge = 0.2f;

            cost = 1.6f;

            healthScaling = 1.5f;
        }};
        spectraglass = new Item("spectraglass", Color.valueOf("d4d4f4")){{
            radioactivity = 0.1f;
            charge = 0.15f;

            cost = 1.6f;

            healthScaling = 1.8f;
        }};


        xenaciaItems.addAll(aluminum, iron, sand, stone, biomass, coal, graphite,
                silicon, titanium, beryllium, cobalt, tungsten, metallicOxides,
                lithium, neodymium, chronatintilium, alterite, ferricCompound,
                carbide, torrentAlloy, myaclide, gammasteel, braienasine,
                crystalineTherius, imparixFiber, spectraglass);

        xenaciaOnlyItems.addAll(xenaciaItems).removeAll(serpuloItems);
        xenaciaOnlyItems.removeAll(erekirItems);
    }
}