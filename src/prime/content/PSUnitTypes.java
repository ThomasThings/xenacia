package prime.content;

import arc.graphics.Color;
import mindustry.type.*;
import mindustry.gen.*;

public class PSUnitTypes {
    public static UnitType
            assaultMite;


    public static void load() {
        assaultMite = new UnitType("assault-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 80f;
            armor = 0f;
            speed = 1f;
            drag = 0.11f;

            useUnitCap = false;

            legForwardScl = 5f;
            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 6f;
            legExtension = 1f;
            legBaseOffset = 0f;
            legStraightness = 0.5f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
        }};
    }
}