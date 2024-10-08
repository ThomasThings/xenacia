package xenacia.content;

import arc.graphics.Color;
import arc.math.geom.Rect;
import arc.struct.Seq;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.weapons.PointDefenseWeapon;

public class XenUnitTypes{
    public static UnitType
    radix, refine,
    avison,
    serpence,
    awren, mryre,
    barrier, blockaid,
    daul, beaure;

    //payload capacity is ((X*8)^2), X is desired side length of payload capacity square
    //unit size = (X x 8), X being the side of

    //tread x = [ (number of pixels between the left side of the tread and the left edge of the @-treads sprite) - (half of sprite width) ]
    //tread y = [ (number of pixels between the tread and top of @-treads sprite) - (half of sprite height) ]
    //tread width = ( @-treads#-# sprite width )
    //tread height = ( @-treads#-# sprite height )

    public static void load() {

        radix = new UnitType("radix") {{
            constructor = UnitEntity::create;
            controller = u -> new BuilderAI(true, 500);
            outlines = false;
            coreUnitDock = true;
            health = 400f;
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
            engineOffset = 4.25f;
        }};
        refine = new UnitType("refine") {{
            constructor = UnitEntity::create;
            controller = u -> new BuilderAI(true, 700);
            outlines = false;
            coreUnitDock = true;
            health = 600f;
            armor = 1f;
            hitSize = 6f;
            speed = 3.5f;
            rotateSpeed = 15f;
            flying = true;
            lowAltitude = true;
            accel = 0.2f;
            drag = 0.1f;

            targetPriority = -2;

            mineWalls = true;
            mineFloor = true;
            mineSpeed = 10f;
            mineTier = 2;
            buildSpeed = 0.4f;
            buildBeamOffset = 5f;

            itemCapacity = 20;
            isEnemy = false;

            engineSize = 2f;
            engineOffset = 5.75f;
        }};

        avison = new UnitType("avison") {{
            constructor = LegsUnit::create;
            mechLegColor = Color.valueOf("40435a");
            outlines = false;
            health = 1200f;
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
                    damage = 30;
                    speed = 5.5f;
                    width = height = 12;
                    shrinkY = 0.3f;
                    backSprite = "large-bomb-back";
                    sprite = "mine-bullet";
                    velocityRnd = 0.05f;
                    shootEffect = Fx.shootBig2;
                    smokeEffect = Fx.shootSmokeDisperse;
                    frontColor = Color.white;
                    backColor = trailColor = hitColor = Color.valueOf("fce198");
                    trailChance = 0.64f;
                    lifetime = 35f;
                    homingPower = 0.01f;
                    homingRange = 150f;
                    rotationOffset = 90f;
                    trailRotation = true;
                    trailEffect = Fx.disperseTrail;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
        }};

        serpence = new UnitType("serpence") {{
            constructor = MechUnit::create;
            outlines = false;
            speed = 0.55f;
            hitSize = 10f;
            health = 750;
            weapons.add(new Weapon("xenacia-serpence-weapon") {{
                reload = 20f;
                x = 4.625f;
                y = 0.375f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.5f, 18) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 40f;
                    shrinkY = 0f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("fce198");
                }};
            }});
        }};

        awren = new UnitType("awren") {{
            constructor = TankUnit::create;
            outlines = false;
            controller = u -> new GroundAI();
            defaultCommand = UnitCommand.mineCommand;
            health = 1000f;
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
        mryre = new UnitType("mryre") {{
            constructor = TankUnit::create;
            outlines = false;

            controller = u -> new GroundAI();
            defaultCommand = UnitCommand.mineCommand;
            health = 3050f;
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
                            67 - 47f,
                            14,
                            24
                    )
            };

            weapons.add(new PointDefenseWeapon("xenacia-mryre-point-defense") {{
                x = 5.5f + 0.125f;
                y = -2.5f;
                mirror = true;
                reload = 5f;
                targetInterval = 10f;
                targetSwitchInterval = 10f;
                bullet = new BulletType() {{
                    shootEffect = Fx.sparkShoot;
                    hitEffect = Fx.pointHit;
                    maxRange = 100f;
                    damage = 25;
                }};
            }});
        }};

        barrier = new UnitType("barrier") {{
            constructor = MechUnit::create;
            outlines = false;
            speed = 0.6f;
            rotateSpeed = 1.5f;
            hitSize = 10f;
            health = 1200;

            abilities.add(new ShieldArcAbility() {{
                region = "xenacia-barrier-shield";
                radius = 25f;
                angle = 115f;
                regen = 0.5f;
                cooldown = 60f * 8f;
                max = 1500f;
                y = -8f;
                width = 6f;
                whenShooting = false;
            }});
        }};
        blockaid = new UnitType("blockaid") {{
            constructor = MechUnit::create;
            outlines = false;
            speed = 1f;
            rotateSpeed = 2f;
            hitSize = 19f;
            health = 5200;

            abilities.add(new ShieldArcAbility() {{
                region = "xenacia-blockaid-shield";
                radius = 45f;
                angle = 95f;
                regen = 0.5f;
                cooldown = 60f * 8f;
                max = 4000f;
                y = -8f;
                width = 8f;
                whenShooting = false;
            }});
            abilities.add(new ShieldArcAbility() {{
                region = "xenacia-blockaid-shield";
                radius = 45f;
                angleOffset = 180f;
                angle = 95f;
                regen = 0.5f;
                cooldown = 60f * 8f;
                max = 4000f;
                y = 8f;
                width = 8f;
                whenShooting = false;
            }});

            weapons.add(new Weapon("xenacia-blockaid-weapon") {{
                top = true;
                y = -5.25f + 0.125f;
                x = 4.5f - 0.125f;
                reload = 45f;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.missile;
                velocityRnd = 0.5f;
                inaccuracy = 15f;
                alternate = true;
                shoot.shots = 3;
                shoot.shotDelay = 6f;

                bullet = new MissileBulletType() {{
                    damage = 30;
                    speed = 5.5f;
                    width = height = 12;
                    shrinkY = 0.3f;
                    backSprite = "large-bomb-back";
                    sprite = "mine-bullet";
                    velocityRnd = 0.05f;
                    shootEffect = Fx.shootBig2;
                    smokeEffect = Fx.shootSmokeDisperse;
                    frontColor = Color.white;
                    backColor = trailColor = hitColor = Color.valueOf("bedcf8");
                    trailChance = 0.64f;
                    lifetime = 35f;
                    homingPower = 0.03f;
                    homingRange = 150f;
                    rotationOffset = 90f;
                    trailRotation = true;
                    trailEffect = Fx.disperseTrail;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
            weapons.add(new PointDefenseWeapon("xenacia-blockaid-point-defense") {{
                x = 8f + 0.125f;
                y = -2.75f;
                mirror = true;
                reload = 5f;
                targetInterval = 10f;
                targetSwitchInterval = 10f;
                bullet = new BulletType() {{
                    shootEffect = Fx.sparkShoot;
                    hitEffect = Fx.pointHit;
                    maxRange = 100f;
                    damage = 20;
                }};
            }});
        }};

        daul = new UnitType("daul") {{
            constructor = LegsUnit::create;
            mechLegColor = Color.valueOf("40435a");
            outlines = false;
            health = 800f;
            armor = 2f;
            hitSize = 8f;
            speed = 0.75f;
            rotateSpeed = 5f;

            itemCapacity = 10;

            legContinuousMove = false;
            legCount = 6;
            legGroupSize = 2;
            legLength = 11f;
            legExtension = -3;
            legForwardScl = 0.6f;
            legMoveSpace = 1.4f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;

            weapons.add(new Weapon("daul-weapon") {{
                reload = 15f;
                x = 0f;
                y = 3.5f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2f, 10) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 90f;
                    shrinkY = 0f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("b8a9b1");
                }};
            }});
        }};
    }
}
