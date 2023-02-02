package xenacia.content;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.SuicideAI;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.EnergyFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.part.HoverPart;
import mindustry.entities.part.RegionPart;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.gen.*;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.world.meta.BlockFlag;

//payloadCapacity = ((X * 8) ^ 2), X being the side of the payload in blocks

public class XenUnitTypes {
    public static UnitType
    //region key
    //core units
    period, moment, dusk, dawn,
    //seeds
    mechacraft, aircraft, polycraft, watercraft, treadcraft, hovercraft, arthocraft,
    //terrestrial assault
    gale,
    anax, odonata,
    explore,
    shif, kreeg,
    tack,
    //terrestrial support
    elementary,
    lug, haul,
    tick,
    natuon, enavo,
    assist,
    //terrestrial specialist
    erode,
    ryher, evelate,
    spritz,
    kyre, yriek,
    tie,
    //mites and parasites
    coreMite,
    assaultMite,
    boltMite,
    sapMite;

    //endregion

    public static void load() {
        //region core units

        float coreFleeRange = 500f;
        period = new UnitType("period") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 400f;
            armor = 2f;
            hitSize = 10f;
            speed = 5f;
            rotateSpeed = 5f;
            flying = true;
            lowAltitude = true;
            accel = 0.09f;
            drag = 0.08f;

            targetPriority = -2;

            mineWalls = false;
            mineFloor = true;
            mineHardnessScaling = false;
            mineSpeed = 4f;
            mineTier = 2;
            buildSpeed = 1f;

            payloadCapacity = 64f;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            itemCapacity = 40;
            isEnemy = false;

            engineSize = 2.8f;
            engineOffset = 5.6f;

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 15f;
                x = 0f;
                y = 3.5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.6f;
                repairSpeed = 0.8f;
                fractionRepairSpeed = 0.6f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;

                targetUnits = true;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Color.valueOf("ffd37f");
                healColor = Color.valueOf("ffd37f");

                bullet = new BulletType(){{
                    maxRange = 48f;
                }};
            }});
        }};
        moment = new UnitType("moment") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 800f;
            armor = 4f;
            hitSize = 12f;
            speed = 5f;
            rotateSpeed = 5f;
            flying = true;
            lowAltitude = true;
            accel = 0.09f;
            drag = 0.08f;

            targetPriority = -2;

            mineWalls = false;
            mineFloor = true;
            mineHardnessScaling = false;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 1.5f;

            payloadCapacity = 144f;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            itemCapacity = 60;

            engineSize = 3f;
            engineOffset = 6.5f;

            weapons.add(new Weapon(){{
                x = 0f;
                y = 3;
                rotate = false;
                mirror = false;
                reload = 60f;
                velocityRnd = 0.6f;
                shoot.shots = 5;
                inaccuracy = 5f;
                bullet = new LaserBoltBulletType(3.5f, 10) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 30f;

                    collidesTeam = true;
                    healPercent = 1f;

                    buildingDamageMultiplier = 0.8f;

                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});
        }};
        dawn = new UnitType("dawn") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 1200f;
            armor = 6f;
            hitSize = 12f;
            speed = 5.5f;
            rotateSpeed = 5f;
            flying = true;
            lowAltitude = true;
            accel = 0.09f;
            drag = 0.08f;

            targetPriority = -2;

            mineWalls = false;
            mineFloor = true;
            mineHardnessScaling = false;
            mineSpeed = 6f;
            mineTier = 2;
            buildSpeed = 4f;

            payloadCapacity = 256f;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            itemCapacity = 100;

            setEnginesMirror(
                    new UnitEngine(3.5f, -6.8f, 2.5f, 0f)
            );

            weapons.add(new Weapon(){{
                x = 0f;
                y = 7;
                rotate = false;
                mirror = false;
                reload = 60f;
                velocityRnd = 0.7f;
                shoot.shots = 6;
                inaccuracy = 5f;
                bullet = new LaserBoltBulletType(3.5f, 10) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 30f;

                    collidesTeam = true;
                    healPercent = 0.8f;

                    buildingDamageMultiplier = 0.8f;

                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});
            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 15f;
                x = 0f;
                y = 7f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.6f;
                repairSpeed = 0.7f;
                fractionRepairSpeed = 0.8f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;

                controllable = false;
                autoTarget = true;
                targetInterval = 20f;
                targetSwitchInterval = 35f;

                targetUnits = true;
                targetBuildings = true;
                laserColor = Color.valueOf("ffd37f");
                healColor = Color.valueOf("ffd37f");

                bullet = new BulletType(){{
                    maxRange = 48f;
                }};
            }});
        }};
        dusk = new UnitType("dusk") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 1200f;
            armor = 6f;
            hitSize = 20f;
            speed = 5.5f;
            rotateSpeed = 5f;
            flying = true;
            lowAltitude = true;
            accel = 0.09f;
            drag = 0.08f;

            targetPriority = -2;

            mineWalls = false;
            mineFloor = true;
            mineHardnessScaling = false;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 4f;

            payloadCapacity = 256f;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            itemCapacity = 100;

            setEnginesMirror(
                    new UnitEngine(9.75f, 7.50f, 2.5f, 45f),
                    new UnitEngine(9.5f, -9.25f, 3f, 315f)
            );

            weapons.add(new Weapon("xenacia-dusk-bolt-shotgun"){{
                x = 5f;
                y = -2.25f;
                top = true;
                rotate = false;
                mirror = true;
                reload = 15f;
                shoot.shots = 11;
                inaccuracy = 15f;
                velocityRnd = 0.2f;
                bullet = new LaserBoltBulletType(3.5f, 5) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 40f;

                    collidesTeam = true;
                    healPercent = 0.35f;

                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});
        }};

        //endregion

        //region seeds

        mechacraft = new UnitType("mechacraft") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("3d2f37");
            mechLegColor = Color.valueOf("3d2f37");
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
            outlineColor = Color.valueOf("3d2f37");
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
        polycraft = new UnitType("polycraft") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("3d2f37");
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
        watercraft = new UnitType("watercraft") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("3d2f37");
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
        treadcraft = new UnitType("treadcraft") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("3d2f37");
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
        hovercraft = new UnitType("hovercraft") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("3d2f37");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 1.5f;
            rotateSpeed = 5f;
            hovering = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;

            itemCapacity = 5;
            isEnemy = false;

            engineSize = 1.5f;
            engineOffset = 1.5f;

            parts.add(new HoverPart(){{
                x = 0f;
                y = 5f;
                mirror = false;
                radius = 2.75f;
                phase = 90f;
                stroke = 1.5f;
                layerOffset = -0.001f;
                color = Color.valueOf("dcc6c6");
            }});
            parts.add(new HoverPart(){{
                x = 0f;
                y = -4.5f;
                mirror = false;
                radius = 3.75f;
                phase = 90f;
                stroke = 1.5f;
                layerOffset = -0.001f;
                color = Color.valueOf("dcc6c6");
            }});
        }};
        arthocraft = new UnitType("arthocraft") {{
            constructor = CrawlUnit::create;
            outlineColor = Color.valueOf("3d2f37");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            drownTimeMultiplier = 1.2f;
            omniMovement = false;
            speed = 1.2f;
            rotateSpeed = 3f;

            itemCapacity = 0;
            isEnemy = false;

            drawBody = false;
            segments = 3;
            segmentScl = 3f;
            segmentPhase = 5f;
            segmentMag = 0.5f;
        }};

        //endregion

        //region terrestrial assault

        gale = new UnitType("gale") {{
            constructor = MechUnit::create;
            outlines = false;
            mechLegColor = Color.valueOf("2b262d");
            health = 650f;
            armor = 0f;
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
            outlineColor = Color.valueOf("2b262d");
            health = 600f;
            armor = 0f;
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
        odonata = new UnitType("odonata") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("2b262d");
            health = 2300f;
            armor = 5f;
            hitSize = 18f;
            speed = 1.5f;
            rotateSpeed = 4f;
            flying = true;
            lowAltitude = false;
            accel = 0.09f;
            drag = 0.04f;

            itemCapacity = 50;

            engineSize = 4f;
            engineOffset = 8f;

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
                inaccuracy = 180f;
                ignoreRotation = true;
                shootSound = Sounds.none;
                shoot.shots = 5;
                bullet = new BombBulletType(120f, 24f) {{
                    width = 12f;
                    height = 12f;
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;

                    status = StatusEffects.blasted;
                    statusDuration = 60f;

                    fragVelocityMin = 0.4f;

                    fragBullets = 3;
                    fragLifeMin = 0f;
                    fragRandomSpread = 30f;

                    fragBullet = new BasicBulletType(2, 15){{
                        width = 6f;
                        height = 6f;
                        lifetime = 45f;

                        backColor = Color.valueOf("d06b53");
                        frontColor = Color.valueOf("ffa665");
                    }};
                }};
            }});
        }};

        explore = new UnitType("explore") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("2b262d");
            health = 550f;
            armor = 0f;
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
            outlineColor = Color.valueOf("2b262d");
            health = 600f;
            armor = 0f;
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
        kreeg = new UnitType("kreeg") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("2b262d");
            health = 2400f;
            armor = 5f;
            hitSize = 32f;
            speed = 0.9f;
            rotateSpeed = 2f;

            itemCapacity = 10;

            trailLength = 50;
            waveTrailX = 9f;
            waveTrailY = -14f;
            trailScl = 1.4f;

            weapons.add(new Weapon("xenacia-kreeg-missiles") {{
                top = true;
                x = 0f;
                y = 1.75f;
                mirror = false;
                rotate = true;
                reload = 60f;
                rotateSpeed = 1.5f;
                inaccuracy = 15f;
                velocityRnd = 0.2f;
                shootSound = Sounds.explosion;
                recoil = 1f;

                shake = 1;
                shoot.shots = 10;

                bullet = new MissileBulletType(3.2f, 80) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 30f;
                    keepVelocity = false;
                    splashDamage = 40f;
                    splashDamageRadius = 24f;
                    lifetime = 90f;
                    trailColor = Color.valueOf("d06b53");
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 4f;
                    weaveMag = 4f;
                    weaveRandom = true;
                }};
            }});
        }};

        tack = new UnitType("tack") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("2b262d");
            health = 650f;
            armor = 0f;
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

        //endregion

        //region terrestrial support

        elementary = new UnitType("elementary") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("2b262d");
            mechLegColor = Color.valueOf("2b262d");
            health = 600f;
            armor = 0f;
            hitSize = 8f;
            speed = 0.7f;
            rotateSpeed = 3.5f;

            buildSpeed = 0.5f;

            itemCapacity = 10;

            mechFrontSway = 0.2f;
            mechSideSway = 0.5f;

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
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");
            defaultCommand = UnitCommand.rebuildCommand;

            health = 650f;
            armor = 0f;
            hitSize = 12f;

            speed = 2f;
            rotateSpeed = 10f;

            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;
            engineSize = 3f;
            engineOffset = 5.5f;

            mineTier = 2;
            mineSpeed = 2f;
            itemCapacity = 45;
            payloadCapacity = 144;

            buildSpeed = 0.8f;

            abilities.add(new RepairFieldAbility(5f, 45, 55f));
        }};
        haul = new UnitType("haul") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");
            defaultCommand = UnitCommand.rebuildCommand;

            health = 2600f;
            armor = 7f;
            hitSize = 25f;

            speed = 1f;
            rotateSpeed = 10f;

            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;

            setEnginesMirror(
                    new UnitEngine(3f, -8f, 3f, 22.5f)
            );

            mineTier = 2;
            mineSpeed = 2f;
            itemCapacity = 45;
            payloadCapacity = 576;

            buildSpeed = 0.8f;

            abilities.add(new RepairFieldAbility(12f, 120, 80f));
        }};

        tick = new UnitType("tick") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("2b262d");
            defaultCommand = UnitCommand.repairCommand;
            health = 750f;
            armor = 0f;
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
            hovering = true;

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
            outlineColor = Color.valueOf("2b262d");
            health = 650f;
            armor = 0f;
            hitSize = 14f;
            speed = 0.7f;
            rotateSpeed = 3f;

            itemCapacity = 10;

            trailLength = 25;
            waveTrailX = 3f;
            waveTrailY = -1f;
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
                shootY = -6.5f;
                ignoreRotation = true;
                minShootVelocity = 0.01f;

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

            abilities.add(new RepairFieldAbility(15f, 120, 100f));
        }};
        enavo = new UnitType("enavo") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("2b262d");
            health = 2800f;
            armor = 7f;
            hitSize = 30f;
            speed = 0.6f;
            rotateSpeed = 2.5f;

            itemCapacity = 40;

            trailLength = 40;
            waveTrailX = 11.25f;
            waveTrailY = -12f;
            trailScl = 1.5f;

            buildSpeed = 0.5f;

            faceTarget = false;
            weapons.add(new Weapon("enavo-mine"){{
                top = false;
                x = 0f;
                y = -8f;
                mirror = false;

                shootCone = 180f;
                reload = 75f;
                shootY = -6.5f;
                ignoreRotation = true;
                minShootVelocity = 0.01f;

                shootSound = Sounds.mineDeploy;

                bullet = new BasicBulletType(){{
                    damage = 100f;
                    splashDamage = 180f;
                    splashDamageRadius = 24f;
                    healPercent = 10f;
                    lifetime = 900f;
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
                    height = 16;
                    width = 16;
                    shrinkX = 0.5f;
                    shrinkY = 0.5f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("98ffa9");
                    mixColorTo = Color.valueOf("ffffff");

                    fragBullets = 6;
                    fragLifeMin = 0f;
                    fragRandomSpread = 360f;

                    fragBullet = new BasicBulletType(3f, 20){{
                        width = 10f;
                        height = 10f;

                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("98ffa9");

                        lifetime = 45f;
                        hitSound = Sounds.plasmaboom;
                        splashDamage = 20f;
                        splashDamageRadius = 10f;
                    }};
                }};

            }});

            abilities.add(new RepairFieldAbility(15f, 120, 120f));
        }};

        assist = new UnitType("assist") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("2b262d");
            health = 550f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 3f;
            omniMovement = false;

            itemCapacity = 10;

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
                y = -1f;
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

        //endregion

        //region terrestrial specialist

        erode = new UnitType("erode") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("2b262d");
            mechLegColor = Color.valueOf("2b262d");
            health = 550f;
            armor = 0f;
            hitSize = 8f;
            speed = 0.7f;
            rotateSpeed = 3.5f;

            itemCapacity = 10;

            mechFrontSway = 0.3f;
            mechSideSway = 0.4f;

            weapons.add(new Weapon("xenacia-erode-sapper") {{
                top = false;
                x = 3.5f;
                y = 0f;
                rotate = false;
                mirror = true;
                reload = 15f;
                shootX = -0.5f;

                bullet = new SapBulletType() {{
                    damage = 5;
                    sapStrength = 2.5f;
                    length = 45f;
                    width = 0.4f;
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

        ryher = new UnitType("ryher") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");

            health = 550f;
            armor = 0f;
            hitSize = 12f;

            speed = 2f;
            rotateSpeed = 5f;

            flying = true;
            lowAltitude = false;
            accel = 0.1f;
            drag = 0.05f;
            engineSize = 0f;
            setEnginesMirror(
                    new UnitEngine(20 / 4f, 17 / 4f, 1.8f, 45f),
                    new UnitEngine(20 / 4f, -17 / 4f, 1.8f, 315f)
            );

            itemCapacity = 20;
            payloadCapacity = 64;

            weapons.add(new Weapon("ryher-weapon") {{
                top = false;
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 10f;

                bullet = new SapBulletType() {{
                    damage = 5;
                    sapStrength = 1.5f;
                    length = 50f;
                    width = 0.4f;
                    lifetime = 25f;
                    knockback = -0.2f;

                    shootEffect = Fx.none;
                    despawnEffect = Fx.none;
                    hitColor = color = Color.valueOf("bf92f9");
                }};
                shootSound = Sounds.sap;
                ejectEffect = Fx.none;
            }});
        }};
        evelate = new UnitType("evelate") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("2b262d");

            health = 1900f;
            armor = 6f;
            hitSize = 12f;

            speed = 2f;
            rotateSpeed = 5f;

            flying = true;
            lowAltitude = false;
            accel = 0.1f;
            drag = 0.05f;
            engineSize = 0f;
            setEnginesMirror(
                    new UnitEngine(44 / 4f, 17 / 4f, 2.5f, 45f),
                    new UnitEngine(44 / 4f, -40 / 4f, 2.5f, 315f),
                    new UnitEngine(0, -44 / 4f, 2.5f, 0f)
            );

            itemCapacity = 60;
            payloadCapacity = 576;

            weapons.add(new Weapon("evelate-weapon") {{
                top = false;
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 5f;

                bullet = new SapBulletType() {{
                    damage = 10;
                    sapStrength = 1f;
                    length = 80f;
                    width = 0.7f;
                    lifetime = 25f;
                    knockback = -0.3f;

                    shootEffect = Fx.none;
                    despawnEffect = Fx.none;
                    hitColor = color = Color.valueOf("bf92f9");
                }};
                shootSound = Sounds.sap;
                ejectEffect = Fx.none;
            }});
        }};

        spritz = new UnitType("spritz") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("2b262d");
            health = 650f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.6f;
            rotateSpeed = 4.5f;

            itemCapacity = 10;

            legContinuousMove = false;
            legCount = 4;
            legGroupSize = 1;
            legLength = 11f;
            rippleScale = 0.2f;
            stepShake = 0f;
            hovering = true;

            weapons.add(new Weapon("spritz-sprayer"){{
                top = false;
                x = 0f;
                y = 5.5f;
                reload = 5f;
                inaccuracy = 5f;
                ejectEffect = Fx.none;
                recoil = 1f;
                shootSound = Sounds.spray;

                bullet = new LiquidBulletType(Liquids.oil){{
                    damage = 0.5f;
                    puddleSize = 4f;
                    orbSize = 2f;
                    speed = 2f;
                    drag = 0.011f;
                    knockback = 0.1f;
                    shootEffect = Fx.none;
                    lifetime = 65f;
                    collidesAir = false;
                    statusDuration = 300f;
                    layer = Layer.bullet - 2f;
                }};
            }});
        }};

        kyre = new UnitType("kyre") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("2b262d");
            health = 650f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 2.5f;

            itemCapacity = 10;

            trailLength = 25;
            waveTrailX = 5f;
            waveTrailY = -1f;
            trailScl = 1f;

            faceTarget = false;
            weapons.add(new Weapon("xenacia-kyre-cannon") {{
                x = 0f;
                y = -2.25f;
                mirror = false;
                rotate = true;
                rotateSpeed = 3f;
                reload = 90f;
                inaccuracy = 0f;
                shootSound = Sounds.artillery;

                bullet = new ArtilleryBulletType(2.8f, 20) {{
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.5f;
                    lifetime = 60f;
                    width = height = 10f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 16f;
                    splashDamage = 50f;
                    trailColor = Pal.sapBulletBack;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;

                    lightning = 2;
                    lightningLength = 7;
                    lightningDamage = 10;
                    lightningColor = Pal.sapBullet;

                    status = StatusEffects.sapped;
                    statusDuration = 180;
                }};
            }});
        }};
        yriek = new UnitType("yriek") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("2b262d");
            health = 2100f;
            armor = 6.5f;
            hitSize = 12f;
            speed = 0.7f;
            rotateSpeed = 2f;

            itemCapacity = 20;

            trailLength = 40;
            waveTrailX = 10.5f;
            waveTrailY = -17f;
            trailScl = 2f;

            faceTarget = false;
            weapons.add(new Weapon("xenacia-yriek-small-cannon") {{
                x = 0f;
                y = 11f;
                mirror = false;
                rotate = true;
                rotateSpeed = 4f;
                reload = 60f;
                inaccuracy = 0f;
                shootSound = Sounds.artillery;

                bullet = new ArtilleryBulletType(2.8f, 30) {{
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.5f;
                    lifetime = 80f;
                    width = height = 10f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 16f;
                    splashDamage = 50f;
                    trailColor = Pal.sapBulletBack;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;

                    lightning = 2;
                    lightningLength = 7;
                    lightningDamage = 10;
                    lightningColor = Pal.sapBullet;

                    status = StatusEffects.sapped;
                    statusDuration = 180;
                }};
            }});
            weapons.add(new Weapon("xenacia-yriek-big-cannon") {{
                x = 0f;
                y = -7f;
                mirror = false;
                rotate = true;
                rotateSpeed = 3f;
                reload = 180f;
                inaccuracy = 0f;
                shootSound = Sounds.artillery;
                shoot.firstShotDelay = 30f;

                bullet = new ArtilleryBulletType(3f, 60) {{
                    hitEffect = Fx.sapExplosion;
                    knockback = 01f;
                    lifetime = 120f;
                    width = height = 20f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 24f;
                    splashDamage = 120f;
                    trailColor = Pal.sapBulletBack;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;

                    lightning = 3;
                    lightningLength = 9;
                    lightningDamage = 15;
                    lightningColor = Pal.sapBullet;

                    status = StatusEffects.sapped;
                    statusDuration = 240;
                }};
            }});
        }};

        tie = new UnitType("tie") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("2b262d");
            health = 650f;
            armor = 0f;
            hitSize = 13f;
            speed = 0.8f;
            rotateSpeed = 3f;
            omniMovement = false;

            itemCapacity = 15;

            treadFrames = 12;
            treadRects = new Rect[]{
                    new Rect(
                            4 - 35f,
                            9 - 35f,
                            16,
                            51
                    )
            };

            faceTarget = true;

            weapons.add(new Weapon("link-flare"){{
                x = 0f;
                y = 0.25f;
                mirror = false;
                rotate = false;
                parentizeEffects = true;
                continuous = true;
                alwaysContinuous = true;

                shootCone = 135f;
                shootSound = Sounds.techloop;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 5;

                bullet = new ContinuousFlameBulletType(){{
                    damage = 7f;
                    buildingDamageMultiplier = 1.5f;

                    pierce = true;
                    pierceBuilding = false;
                    pierceCap = 3;

                    status = StatusEffects.burning;
                    statusDuration = 120f;

                    length = 35f;
                    width = 5f;

                    colors = new Color[]{
                            Pal.sapBulletBack.cpy().a(0.2f),
                            Pal.sapBulletBack.cpy().a(0.4f),
                            Pal.sapBullet.cpy().a(0.4f),
                            Pal.sapBullet.cpy().a(0.7f),
                            Color.white
                    };

                    flareColor = Pal.sapBullet;
                    flareLength = 8f;
                    flareRotSpeed = -3.5f;
                    hitColor = Pal.sapBullet;

                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                }};
            }});
        }};

        //endregion

        //region mites

        coreMite = new UnitType("core-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("2b262d");
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

            range = 40f;

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

                    rangeOverride = 12f;
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
            outlineColor = Color.valueOf("2b262d");
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
            outlineColor = Color.valueOf("2b262d");
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
            outlineColor = Color.valueOf("2b262d");
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

        //endregion
    }
}