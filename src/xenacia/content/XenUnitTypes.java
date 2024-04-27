package xenacia.content;

import arc.graphics.Color;
import arc.math.geom.Rect;
import arc.struct.Seq;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.gen.LegsUnit;
import mindustry.gen.Sounds;
import mindustry.gen.TankUnit;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.weapons.PointDefenseWeapon;

public class XenUnitTypes{
    public static UnitType
    radix,
    awren,
    barrier,
    soer,
    avison;

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
            health = 300f;
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
            controller = u -> new GroundAI();
            defaultCommand = UnitCommand.mineCommand;
            health = 450f;
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
            mineItems = Seq.with(XenItems.alamex, XenItems.torren);

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
        awren = new UnitType("mryre") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("40435a");
            controller = u -> new GroundAI();
            defaultCommand = UnitCommand.mineCommand;
            health = 1000f;
            armor = 5f;
            hitSize = 19f;
            speed = 0.8f;
            rotateSpeed = 3f;
            omniMovement = false;
            rotateMoveFirst = true;

            mineWalls = true;
            mineFloor = true;
            mineSpeed = 10f;
            mineTier = 4;
            mineRange = 40f;
            mineItems = Seq.with(XenItems.alamex, XenItems.torren);

            itemCapacity = 200;
            isEnemy = false;

            treadFrames = 8;
            treadRects = new Rect[]{
                    new Rect(
                            13 - 45,
                            3 - 47f,
                            14,
                            24
                    ),
                    new Rect(
                            13 - 45,
                            57 - 47f,
                            14,
                            24
                    )
            };

            weapons.add(new PointDefenseWeapon("xenacia-mryer-point-defense"){{
                x = 5.5f + 0.125f;
                y = -2.5f;
                mirror = true;
                reload = 5f;
                targetInterval = 10f;
                targetSwitchInterval = 10f;
                bullet = new BulletType(){{
                   shootEffect = Fx.sparkShoot;
                   hitEffect=Fx.pointHit;
                   maxRange = 100f;
                   damage = 15;
                }};
            }});
        }};

        soer = new UnitType("soer") {{
            constructor = UnitEntity::create;
            outlines = false;
            health = 250f;
            armor = 1f;
            hitSize = 12f;
            speed = 2f;
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

            engineSize = 1.9f;
            engineOffset = 5.75f;

            parts.add(
                    new RegionPart("-side"){{
                         x = 3 + 0.125f;
                         y = 2;
                         moveRot = -45;
                         moveX = 0.5f;
                         progress = PartProgress.warmup;
                         mirror = true;
                         layerOffset = -0.01f;
                    }}
            );
            parts.add(
                    new RegionPart("-side-outline-part"){{
                         x = 3 + 0.125f;
                         y = 2;
                         moveRot = -45;
                         moveX = 0.5f;
                         progress = PartProgress.warmup;
                         mirror = true;
                         layerOffset = -0.02f;
                    }}
            );
            parts.add(
                    new RegionPart("-outline-part"){{
                        x = 0;
                        y = 0;
                        mirror = false;
                        layerOffset = -0.03f;
                    }}
            );

            weapons.add(new Weapon("soer-launcher") {{
                x = 3f;
                y = 1.5f;
                top = false;
                layerOffset = 0f;
                rotate = false;
                reload = 30f;
                inaccuracy = 0f;
                velocityRnd = 0f;
                shootSound = Sounds.missile;
                shootY = 0f;

                bullet = new MissileBulletType(){{
                    damage = 25;
                    speed = 4.5f;
                    width = height = 4;
                    shrinkY = 0.3f;
                    velocityRnd = 0.05f;
                    frontColor = Color.white;
                    backColor = trailColor = hitColor = Color.valueOf("c6cef0");
                    trailChance = 0.8f;
                    lifetime = 45f;
                    homingPower = 0.03f;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
        }};

        avison = new UnitType("avison") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("40435a");
            health = 550f;
            armor = 2f;
            hitSize = 14f;
            speed = 1f;
            rotateSpeed = 5f;

            itemCapacity = 10;

            legContinuousMove = false;
            legCount = 4;
            legGroupSize = 1;
            legLength = 16f;
            legExtension = -3;
            legForwardScl = 0.6f;
            legMoveSpace = 1.4f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;

            weapons.add(new Weapon("avison-launcher") {{
                x = 0f;
                y = 2.5f;
                top = false;
                layerOffset = 0f;
                rotate = false;
                reload = 40f;
                inaccuracy = 0f;
                velocityRnd = 0f;
                shootSound = Sounds.shootBig;
                shootY = 0f;

                bullet = new MissileBulletType() {{
                    damage = 35;
                    speed = 5.5f;
                    width = height = 12;
                    shrinkY = 0.3f;
                    backSprite = "large-bomb-back";
                    sprite = "mine-bullet";
                    velocityRnd = 0.05f;
                    shootEffect = Fx.shootBig2;
                    smokeEffect = Fx.shootSmokeDisperse;
                    frontColor = Color.white;
                    backColor = trailColor = hitColor = Color.valueOf("c6cef0");
                    trailChance = 0.64f;
                    lifetime = 35f;
                    rotationOffset = 90f;
                    trailRotation = true;
                    trailEffect = Fx.disperseTrail;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
        }};
    }
}
