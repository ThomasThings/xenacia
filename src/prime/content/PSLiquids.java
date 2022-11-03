package prime.content;

import arc.graphics.*;
import mindustry.type.*;

public class PSLiquids{
    public static Liquid
            steam, magma, voltike;

    public static void load(){
        steam = new Liquid("steam", Color.valueOf("e9f8f9")){{
            gas = true;
            barColor = Color.valueOf("84e4ea");
        }};
        magma = new Liquid("magma", Color.valueOf("df6936")){{
            temperature = 3f;
            viscosity = 0.8f;
            incinerable = false;
            gasColor = Color.valueOf("ffcb89");
        }};
        voltike = new Liquid("voltike", Color.valueOf("c4cbf9")){{
           temperature = 0.6f;
           flammability = 2f;
           explosiveness = 3f;
           viscosity = 0.3f;
        }};
    }
}
