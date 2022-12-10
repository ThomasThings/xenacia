package xenacia.content;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.SuicideAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.EnergyFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.gen.*;
import mindustry.world.meta.BlockFlag;

//payloadCapacity = ((1.5 * 8) ^ 2);

public class XenUnitTypes {
    public static UnitType
    //mites
    coreMite, assaultMite, boltMite, sapMite,
    //seeds
    mech, aircraft, polyped, ship, tank,
    //terrestrial assault
    gale,
    anax,
    explore,
    shif,
    tack,
    //terrestrial support
    elementary,
    lug,
    tick,
    natuon,
    assist,
    //terrestrial specialist
    erode,
    ryher,
    spritz,
    mount,
    link;

    public static void load() {
        //mites
        coreMite = new UnitType("core-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 110f;
            armor = 0f;
            hitSize = 6f;
            speed = 1f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            aiController = SuicideAI::new;

            legForwardScl = 5f;
            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 6f;
            legExtension = 1f;
            legBaseOffset = 0.5f;
            legStraightness = 0.5f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            allowLegStep = false;

            weapons.add(new Weapon() {{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType() {{
                    collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;

                    rangeOverride = 30f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 24f;
                    instantDisappear = true;
                    splashDamage = 100f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                }};
            }});
        }};
        assaultMite = new UnitType("assault-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 100f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.9f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

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
            allowLegStep = false;

            weapons.add(new Weapon("assault-mite-weapon") {{
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 30f;
                bullet = new BasicBulletType(3.5f, 9) {{
                    width = 5f;
                    height = 7f;
                    lifetime = 30f;
                }};
                ejectEffect = Fx.none;
            }});
        }};
        boltMite = new UnitType("bolt-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 100f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.9f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

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
            allowLegStep = false;

            weapons.add(new Weapon("bolt-mite-weapon") {{
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 30f;
                bullet = new LaserBoltBulletType(3.5f, 9) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 30f;

                    collidesTeam = true;
                    healPercent = 0.5f;

                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});
        }};
        sapMite = new UnitType("sap-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 85f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.9f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

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
            allowLegStep = false;

            weapons.add(new Weapon("sap-mite-weapon") {{
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 15f;
                bullet = new SapBulletType() {{
                    damage = 2;
                    sapStrength = 1f;
                    length = 25f;
                    width = 0.5f;
                    lifetime = 25f;
                    knockback = -0.2f;

                    shootEffect = Fx.shootSmall;
                    despawnEffect = Fx.none;
                    hitColor = color = Color.valueOf("bf92f9");
                }};
                shootSound = Sounds.sap;
                ejectEffect = Fx.none;
            }});
        }};
        //seeds
        mech = new UnitType("mech") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("242125");
            mechLegColor = Color.valueOf("242125");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.6f;
            rotateSpeed = 5f;

            itemCapacity = 5;
            isEnemy = false;

            mechFrontSway = 0.2f;
            mechSideSway = 0.3f;
        }};
        aircraft = new UnitType("aircraft") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("242125");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 2f;
            rotateSpeed = 5f;
            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;

            itemCapacity = 5;
            isEnemy = false;

            engineSize = 3f;
            engineOffset = 5.5f;
        }};
        polyped = new UnitType("polyped") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.8f;
            rotateSpeed = 5f;

            itemCapacity = 5;
            isEnemy = false;

            legContinuousMove = false;
            legCount = 3;
            legGroupSize = 1;
            legLength = 9f;
            rippleScale = 0.1f;
        }};
        ship = new UnitType("ship") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("242125");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 1f;
            rotateSpeed = 5f;

            itemCapacity = 5;
            isEnemy = false;

            trailLength = 15;
            waveTrailX = 4.5f;
            waveTrailY = -1f;
            trailScl = 1.2f;
        }};
        tank = new UnitType("tank") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.8f;
            rotateSpeed = 5f;
            omniMovement = false;

            itemCapacity = 5;
            isEnemy = false;

            treadFrames = 8;
            treadRects = new Rect[]{
                new Rect(
                    12,
                    -25,
                    11,
                    48
                )
            };
        }};
        //terrestrial assault
        gale = new UnitType("gale") {{
            constructor = MechUnit::create;
            outlines = false;
            mechLegColor = Color.valueOf("242125");
            health = 650f;
            armor = 1f;
            hitSize = 12f;
            speed = 0.6f;
            rotateSpeed = 5f;

            itemCapacity = 10;

            mechFrontSway = 0.2f;
            mechSideSway = 0.4f;

            weapons.add(new Weapon("xenacia-gale-missiles") {{
                x = 4.375f;
                y = 0f;
                top = false;
                layerOffset = -0.0001f;
                rotate = false;
                reload = 30f;
                inaccuracy = 2.5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
                shootY = 3.5f;

                bullet = new MissileBulletType(2.8f, 25) {{
                    width = 6f;
                    height = 6f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 30f;
                    splashDamageRadius = 20f;
                    splashDamage = 15f;
                    lifetime = 60f;
                    trailColor = Color.valueOf("d06b53");
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 4f;
                    weaveMag = 1f;
                }};
            }});
        }};
        anax = new UnitType("anax") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("242125");
            health = 600f;
            armor = 1f;
            hitSize = 18f;
            speed = 2f;
            rotateSpeed = 4f;
            flying = true;
            lowAltitude = false;
            accel = 0.09f;
            drag = 0.02f;

            itemCapacity = 25;

            engineSize = 3.3f;
            engineOffset = 7.5f;

            circleTarget = true;
            targetFlags = new BlockFlag[]{BlockFlag.battery, null};
            faceTarget = false;

            weapons.add(new Weapon() {{
                minShootVelocity = 0.75f;
                x = 0f;
                y = 0f;
                shootY = 0f;
                reload = 20f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 15f;
                ignoreRotation = true;
                shootSound = Sounds.none;
                bullet = new BombBulletType(65f, 24f) {{
                    width = 10f;
                    height = 10f;
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;

                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                }};
            }});
        }};
        explore = new UnitType("explore") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 550f;
            armor = 1f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 5f;

            itemCapacity = 10;

            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 11f;
            rippleScale = 0.2f;
            stepShake = 0f;
            hovering = true;

            weapons.add(new Weapon("xenacia-explore-cannon") {{
                x = 0f;
                y = -3.25f;
                mirror = false;
                rotate = true;
                rotateSpeed = 4f;
                reload = 60f;
                inaccuracy = 0f;
                velocityRnd = 0.4f;
                shootSound = Sounds.artillery;

                shootY = 4.5f;
                bullet = new ArtilleryBulletType(2.8f, 20, "shell") {{
                    hitEffect = Fx.blastExplosion;
                    knockback = 0.5f;
                    lifetime = 120f;
                    width = height = 10f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 32f;
                    splashDamage = 60f;
                    trailColor = Color.valueOf("d06b53");
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                }};
            }});
        }};
        shif = new UnitType("shif") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("242125");
            health = 600f;
            armor = 1f;
            hitSize = 14f;
            speed = 0.9f;
            rotateSpeed = 4f;

            itemCapacity = 10;

            trailLength = 20;
            waveTrailX = 4f;
            waveTrailY = -1f;
            trailScl = 1.2f;

            weapons.add(new Weapon("xenacia-shif-missiles") {{
                top = true;
                x = 0f;
                y = 1.75f;
                mirror = false;
                rotate = true;
                reload = 15f;
                inaccuracy = 2.5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
                recoil = 1f;

                bullet = new MissileBulletType(2.8f, 35) {{
                    width = 6f;
                    height = 6f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 30f;
                    keepVelocity = false;
                    splashDamageRadius = 20f;
                    splashDamage = 15f;
                    lifetime = 50f;
                    trailColor = Color.valueOf("d06b53");
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 4f;
                    weaveMag = 1f;
                }};
            }});
        }};
        tack = new UnitType("tack") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 650f;
            armor = 1f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 4f;
            omniMovement = false;

            itemCapacity = 10;

            treadFrames = 10;
            treadRects = new Rect[]{
                    new Rect(
                    -29,
                    -28,
                    22,
                    56)
            };

            weapons.add(new Weapon("xenacia-tack-beam"){{
                x = 0f;
                y = -1.75f;
                layerOffset = 0.1f;
                top = true;
                mirror = false;
                rotate = true;
                rotateSpeed = 3.5f;
                reload = 45f;
                recoil = 2f;
                shootSound = Sounds.laser;

                bullet = new LaserBulletType(){{
                    damage = 75f;
                    sideAngle = 65f;
                    sideWidth = 0.5f;
                    sideLength = 15f;
                    length = 44f;
                    colors = new Color[]{Color.valueOf("ffa665").cpy().a(0.4f), Color.valueOf("ffa665"), Color.white};
                }};

                parts.addAll(
                        new RegionPart("-jaw"){{
                            x = 0f;
                            y = 2.5f;
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            outline = true;
                            moveX = 0.75f;
                            moveRot = 0f;
                            moves.add(new PartMove(PartProgress.recoil, 0.5f, 0f, -8f));
                        }});
            }});
        }};
        //terrestrial support
        elementary = new UnitType("elementary") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("242125");
            mechLegColor = Color.valueOf("242125");
            health = 600f;
            armor = 0f;
            hitSize = 8f;
            speed = 0.7f;
            rotateSpeed = 3.5f;

            buildSpeed = 0.5f;

            itemCapacity = 10;

            mechFrontSway = 0f;
            mechSideSway = 0.1f;

            weapons.add(new Weapon("elementary-flare"){{
                x = 0f;
                y = 0.25f;
                mirror = false;
                rotate = false;
                parentizeEffects = true;
                continuous = true;
                alwaysContinuous = true;

                shootSound = Sounds.techloop;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 5;

                bullet = new ContinuousFlameBulletType(){{
                    damage = 5f;
                    buildingDamageMultiplier = 1.5f;

                    pierce = true;
                    pierceBuilding = false;
                    pierceCap = 3;

                    collidesTeam = true;
                    healPercent = 0.25f;

                    status = StatusEffects.burning;
                    statusDuration = 30f;

                    length = 35f;
                    width = 2f;

                    colors = new Color[]{
                            Color.valueOf("c6ffdc").cpy().a(0.15f),
                            Color.valueOf("c6ffdc").cpy().a(0.35f),
                            Color.valueOf("c6ffdc").cpy().a(0.6f),
                            Color.valueOf("c6ffdc").cpy().a(0.8f),
                            Color.white
                    };

                    flareColor = Color.valueOf("c6ffdc");
                    flareLength = 5f;
                    flareRotSpeed = 1.5f;
                    hitColor = Color.valueOf("c6ffdc");

                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                }};
            }});

        }};
        lug = new UnitType("lug") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("242125");
            defaultCommand = UnitCommand.rebuildCommand;

            health = 650f;
            armor = 1f;
            hitSize = 12f;

            speed = 2f;
            rotateSpeed = 10f;

            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;
            engineSize = 3f;
            engineOffset = 5.5f;

            itemCapacity = 15;
            payloadCapacity = 144;

            buildSpeed = 0.8f;

            abilities.add(new RepairFieldAbility(5f, 45, 55f));
        }};
        tick = new UnitType("tick") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            defaultCommand = UnitCommand.repairCommand;
            health = 750f;
            armor = 1f;
            hitSize = 10f;
            speed = 0.6f;
            rotateSpeed = 3f;

            itemCapacity = 10;

            legContinuousMove = false;
            legCount = 4;
            legGroupSize = 1;
            legLength = 11f;
            rippleScale = 0.2f;
            stepShake = 0f;

            buildSpeed = 0.5f;

            abilities.add(new EnergyFieldAbility(6f, 35f, 60f){{
                status = StatusEffects.shocked;
                statusDuration = 60f;
                maxTargets = 5;
                healPercent = 2;

                sectors = 3;
                sectorRad = 0.1f;
                rotateSpeed = -0.8f;
                effectRadius = 4f;
            }});
        }};
        natuon = new UnitType("natuon") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("242125");
            health = 650f;
            armor = 1f;
            hitSize = 16f;
            speed = 0.6f;
            rotateSpeed = 3f;

            itemCapacity = 15;

            trailLength = 15;
            waveTrailX = 3f;
            waveTrailY = -2f;
            trailScl = 1f;

            buildSpeed = 0.5f;

            faceTarget = false;
            weapons.add(new Weapon("natuon-mine"){{
                top = false;
                x = 0f;
                y = 0f;
                mirror = false;

                shootCone = 180f;
                reload = 45f;
                shootY = -5f;
                ignoreRotation = true;

                shootSound = Sounds.mineDeploy;

                bullet = new BasicBulletType(){{
                    damage = 30f;
                    splashDamage = 60f;
                    splashDamageRadius = 16f;
                    healPercent = 10f;
                    lifetime = 1200f;
                    speed = 0f;
                    keepVelocity = false;

                    collidesAir = false;
                    collideFloor = true;
                    collidesTeam = true;

                    hitSound = Sounds.plasmaboom;

                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    sprite = "mine-bullet";
                    layer = 10;
                    height = 10;
                    width = 10;
                    shrinkX = 0.5f;
                    shrinkY = 0.5f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("98ffa9");
                    mixColorTo = Color.valueOf("ffffff");
                }};

            }});
            abilities.add(new RepairFieldAbility(8f, 120, 100f));
        }};
        assist = new UnitType("assist") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 550f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 3f;
            omniMovement = false;

            itemCapacity = 15;

            treadFrames = 12;
            treadRects = new Rect[]{
                new Rect(
                    -28,
                    -25,
                    13,
                    49
                )
            };

            faceTarget = false;

            weapons.add(new Weapon("xenacia-assist-missiles"){{
                top = true;
                rotate = true;
                rotateSpeed = 3f;
                x = 0f;
                y = -1.5f;
                mirror = false;
                inaccuracy = 4f;
                reload = 20f;
                shootY = 1.75f;
                shootSound = Sounds.missile;
                recoil = 0.8f;

                bullet = new MissileBulletType(2.8f, 5) {{
                    width = 6f;
                    height = 6f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 35f;
                    splashDamageRadius = 8f;
                    splashDamage = 15f;
                    lifetime = 45f;
                    weaveScale = 1.5f;
                    weaveMag = 3f;

                    collidesTeam = true;
                    healPercent = 3f;

                    trailColor = Color.valueOf("98ffa9");
                    backColor = Color.valueOf("98ffa9");
                    frontColor = Color.valueOf("ffffff");

                    shootEffect = Fx.shootHeal;
                    smokeEffect = Fx.hitLaser;
                    hitEffect = Fx.hitLaser;
                    hitSound = Sounds.none;
                    despawnEffect = Fx.hitLaser;
                }};
            }});
        }};
    }
}