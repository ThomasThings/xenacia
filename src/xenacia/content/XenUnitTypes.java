package xenacia.content;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.MinerAI;
import mindustry.gen.TankUnit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

public class XenUnitTypes{
    public static UnitType
    radix,
    awren;

    //payload capacity is ((X*8)^2), X is desired side length of payload capacity square
    //unit size = (X x 8), X being the side of

    //tread x = [ (number of pixels between the left side of the tread and the left edge of the @-treads sprite) - (half of sprite width) ]
    //tread y = [ (number of pixels between the tread and top of @-treads sprite) - (half of sprite height) ]
    //tread width = ( @-treads#-# sprite width )
    //tread height = ( @-treads#-# sprite height )

    public static void load(){

        radix = new UnitType("radix") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("40435a");
            controller = u -> new BuilderAI(true, 500);
            coreUnitDock = true;
            health = 250f;
            armor = 1f;
            hitSize = 6f;
            speed = 3f;
            rotateSpeed = 15f;
            flying = true;
            lowAltitude = true;
            accel = 0.2f;
            drag = 0.1f;

            targetPriority = -2;

            mineWalls = true;
            mineFloor = true;
            mineSpeed = 6f;
            mineTier = 1;
            buildSpeed = 0.2f;
            buildBeamOffset = 4f;

            itemCapacity = 20;
            isEnemy = false;

            engineSize = 1.8f;
            engineOffset = 4.75f;
        }};

        awren = new UnitType("awren") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("40435a");
            controller = u -> new MinerAI();
            defaultCommand = UnitCommand.mineCommand;
            health = 350f;
            armor = 2f;
            hitSize = 10f;
            speed = 0.8f;
            rotateSpeed = 3.5f;
            omniMovement = false;
            rotateMoveFirst = true;

            mineWalls = true;
            mineFloor = true;
            mineSpeed = 6f;
            mineTier = 2;
            mineRange = 40f;

            itemCapacity = 50;
            isEnemy = false;

            treadFrames = 8;
            treadRects = new Rect[]{
                    new Rect(
                            9 - 25,
                            3 - 25f,
                            11,
                            16
                    ),
                    new Rect(
                            9 - 25,
                            31 - 25f,
                            11,
                            16
                    )
            };
        }};
    }
}
