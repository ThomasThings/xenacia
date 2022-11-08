package prime.content;

import mindustry.type.*;
import mindustry.gen.*;

public class PSUnitTypes{
    public static UnitType
    assaultMite;


    public static void load(){
        assaultMite = new UnitType("assault-mite") {{
            constructor = LegsUnit::create;
            health = 100f;
            armor = 0f;
            speed = 1f;

            legCount = 4;
            legGroupSize = 1;
            legLength = 8f;
            legExtension = 1.5f;
            legBaseOffset = 0.5f;
            legStraightness = 0.5f;
    }};
}