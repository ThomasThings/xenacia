package xenacia.content;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.geom.Rect;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.SuicideAI;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.abilities.EnergyFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.HoverPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.world.meta.BlockFlag;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;


public class XenUnitTypes {
    public static UnitType
    //region key
    //core units
    periodDrone, period, moment, dusk, dawn,
    //seeds
    mechacraftHull, aircraftHull, polycraftHull, watercraftHull, treadcraftHull, hovercraftHull, arthocraftHull,
    //terrestrial assault
    gale, squall, draft,
    anax, odonata,
    explore, seeker,
    shif, kreeg,
    tack, nail,
    //terrestrial support
    elementary,
    lug, haul, envoy,
    tick,
    natuon, enavo, eurgiSentry, eurgiSentryCarrierMissile, eurgi,
    aid, guard,
    //terrestrial specialist
    erode,
    ryher, evelate,
    spritz,
    kyre, yriek,
    tie, link,
    //mites and parasites
    coreMite, coreParasite, navalCoreMite,
    assaultMite, assaultParasite, navalAssaultMite,
    supportMite, supportParasite, navalSupportMite,
    specialistMite, specialistParasite, navalSpecialistMite;

    //endregion

    //region equation-key

    //payload capacity is ((X*8)^2), X is desired side length of payload capacity square
    //unit size = (X x 8), X being the side of

    //tread x = [ (number of pixels between the left side of the tread and the left edge of the @-treads sprite) - (half of sprite width) ]
    //tread y = [ (number of pixels between the tread and top of @-treads sprite) - (half of sprite height) ]
    //tread width = ( @-treads#-# sprite width )
    //tread height = ( @-treads#-# sprite height )

    //endregion

    public static void load() {
        //region core units

        float coreFleeRange = 500f;
        periodDrone = new UnitType("period-drone") {{
            hidden = true;
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("231b25");
            controller = u -> new BuilderAI(true, coreFleeRange);
            defaultCommand = UnitCommand.rebuildCommand;
            allowedInPayloads = false;
            logicControllable = false;
            playerControllable = false;
            health = 100f;
            armor = 0f;
            hitSize = 4f;
            speed = 1.6f;
            rotateSpeed = 5f;
            flying = true;
            lowAltitude = true;
            accel = 0.09f;
            drag = 0.08f;

            targetPriority = -2;

            buildSpeed = 0.2f;

            itemCapacity = 0;
            isEnemy = false;

            engineSize = 1.8f;
            engineOffset = 4f;

            hidden = true;

            weapons.add(new Weapon(){{
                x = 0f;
                y = 3f;
                rotate = false;
                mirror = false;
                reload = 20f;
                inaccuracy = 10f;
                bullet = new LaserBoltBulletType(5f, 2) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 30f;

                    collidesTeam = true;
                    healPercent = 0.25f;

                    buildingDamageMultiplier = 0f;

                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});
        }};
        period = new UnitType("period") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("231b25");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 400f;
            armor = 2f;
            hitSize = 10f;
            speed = 3f;
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
            buildSpeed = 0.2f;
            buildBeamOffset = 4f;

            payloadCapacity = 64f;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            itemCapacity = 40;
            isEnemy = false;

            engineSize = 2.5f;
            engineOffset = 6.2f;

            weapons.add(new Weapon(){{
                x = 0f;
                y = 0.5f;
                rotate = false;
                mirror = false;
                reload = 30f;
                inaccuracy = 0f;
                bullet = new LaserBoltBulletType(3f, 20) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 60f;

                    collidesTeam = true;
                    healAmount = 30;

                    buildingDamageMultiplier = 0.1f;

                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});

            //abilities.add(new UnitSpawnAbility(XenUnitTypes.periodDrone, 300f, 0f, -2f));
        }};

        moment = new UnitType("moment") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("231b25");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 800f;
            armor = 4f;
            hitSize = 12f;
            speed = 3.5f;
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

            setEnginesMirror(
                    new UnitEngine(7.25f, 4f, 2.2f, 45f),
                    new UnitEngine(7.25f, -6.75f, 2.2f, 315f)
            );
            engineOffset = 9f;
            engineSize = 2.2f;

            weapons.add(new Weapon(){{
                x = 0f;
                y = 3f;
                rotate = false;
                mirror = false;
                reload = 45f;
                shoot.shots = 2;
                shoot.shotDelay = 5f;
                inaccuracy = 0f;
                bullet = new LaserBoltBulletType(3f, 18) {{
                    width = 1.5f;
                    height = 5f;
                    lifetime = 60f;

                    collidesTeam = true;
                    healAmount = 100;

                    buildingDamageMultiplier = 0.1f;

                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
                shootSound = Sounds.lasershoot;
                ejectEffect = Fx.none;
            }});
        }};

        dawn = new UnitType("dawn") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("231b25");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 1200f;
            armor = 6f;
            hitSize = 12f;
            speed = 4f;
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
            outlineColor = Color.valueOf("231b25");
            controller = u -> new BuilderAI(true, coreFleeRange);
            coreUnitDock = true;
            health = 1200f;
            armor = 6f;
            hitSize = 20f;
            speed = 4.5f;
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

        //region hulls

        mechacraftHull = new UnitType("mechacraft-hull") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("3b2e35");
            mechLegColor = Color.valueOf("3b2e35");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.5f;
            rotateSpeed = 5f;

            itemCapacity = 5;
            isEnemy = false;

            mechFrontSway = 0.1f;
            mechSideSway = 0.1f;
        }};
        aircraftHull = new UnitType("aircraft-hull") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("3b2e35");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 2f;
            rotateSpeed = 4.5f;
            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;

            itemCapacity = 5;
            isEnemy = false;

            engineSize = 2.2f;
            engineOffset = 5.5f;
        }};
        polycraftHull = new UnitType("polycraft-hull") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("3b2e35");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.7f;
            rotateSpeed = 5f;

            itemCapacity = 5;
            isEnemy = false;

            legContinuousMove = false;
            legCount = 4;
            legGroupSize = 1;
            legLength = 18f;
            rippleScale = 0.1f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
        }};
        watercraftHull = new UnitType("watercraft-hull") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("3b2e35");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.7f;
            rotateSpeed = 3f;

            itemCapacity = 5;
            isEnemy = false;

            trailLength = 15;
            waveTrailX = 4f;
            waveTrailY = -6f;
            trailScl = 1.2f;
        }};
        treadcraftHull = new UnitType("treadcraft-hull") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("3b2e35");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.8f;
            rotateSpeed = 3f;
            omniMovement = false;

            itemCapacity = 5;
            isEnemy = false;

            treadFrames = 8;
            treadRects = new Rect[]{
                new Rect(
                    7 - 30,
                    6 - 30.5f,
                    13,
                    48
                )
            };
        }};
        hovercraftHull = new UnitType("hovercraft-hull") {{
            constructor = UnitEntity::create;
            outlineColor = Color.valueOf("3b2e35");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 1.5f;
            rotateSpeed = 4f;
            hovering = true;
            shadowElevation = 0.05f;
            useEngineElevation = false;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;
            omniMovement = false;

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
                color = Color.valueOf("e3a76a");
            }});
            parts.add(new HoverPart(){{
                x = 0f;
                y = -4.5f;
                mirror = false;
                radius = 3.75f;
                phase = 90f;
                stroke = 1.5f;
                layerOffset = -0.001f;
                color = Color.valueOf("e3a76a");
            }});
        }};
        arthocraftHull = new UnitType("arthocraft-hull") {{
            constructor = CrawlUnit::create;
            outlineColor = Color.valueOf("3b2e35");
            drawCell = false;
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
            segmentScl = 1.5f;
            segmentPhase = 2.5f;
            segmentMag = 0.5f;
        }};

        //endregion

        //region terrestrial assault

        gale = new UnitType("gale") {{
            constructor = MechUnit::create;
            outlines = false;
            mechLegColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.6f;
            rotateSpeed = 5f;

            itemCapacity = 0;

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
        squall = new UnitType("squall") {{
            constructor = MechUnit::create;
            outlines = false;
            mechLegColor = Color.valueOf("231b25");
            health = 3800f;
            armor = 8f;
            hitSize = 22f;
            speed = 0.6f;
            rotateSpeed = 4f;

            itemCapacity = 0;

            mechFrontSway = 0.3f;
            mechSideSway = 0.6f;

            weapons.add(new Weapon("xenacia-squall-missiles") {{
                x = 10.25f;
                y = 0f;
                top = false;
                layerOffset = -0.0001f;
                rotate = false;
                reload = 30f;
                inaccuracy = 2f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
                shootY = 8f;
                shootX = -1f;
                shoot.shots = 5;

                bullet = new MissileBulletType(2.8f, 35) {{
                    width = 8.5f;
                    height = 8.5f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 30f;
                    splashDamageRadius = 20f;
                    splashDamage = 15f;
                    lifetime = 75f;
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
        draft = new UnitType("draft") {{
            constructor = MechUnit::create;
            outlines = false;
            mechLegColor = Color.valueOf("231b25");
            health = 9600f;
            armor = 15f;
            hitSize = 28f;
            speed = 0.6f;
            rotateSpeed = 4f;

            itemCapacity = 0;

            mechFrontSway = 0.3f;
            mechSideSway = 0.6f;

            weapons.add(new Weapon("xenacia-draft-missiles") {{
                x = 14.5f;
                y = -0.25f;
                top = false;
                layerOffset = -0.0001f;
                rotate = false;
                reload = 45f;
                inaccuracy = 2.5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
                shootY = 8.5f;
                shoot.shots = 10;

                bullet = new MissileBulletType(3.5f, 120) {{
                    width = 8.5f;
                    height = 8.5f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 30f;
                    splashDamageRadius = 20f;
                    splashDamage = 15f;
                    lifetime = 75f;
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
            outlineColor = Color.valueOf("231b25");
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
            outlineColor = Color.valueOf("231b25");
            health = 3200f;
            armor = 8f;
            hitSize = 18f;
            speed = 1.5f;
            rotateSpeed = 4f;
            flying = true;
            lowAltitude = false;
            accel = 0.09f;
            drag = 0.04f;

            itemCapacity = 75;

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
                }};
            }});
        }};

        explore = new UnitType("explore") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 550f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 5f;

            itemCapacity = 0;

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
        seeker = new UnitType("seeker") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 2900f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 3f;

            itemCapacity = 0;

            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 42.5f;
            rippleScale = 0.2f;
            stepShake = 0f;
            hovering = true;

            weapons.add(new Weapon("xenacia-seeker-cannon") {{
                x = 0f;
                y = -7.5f;
                mirror = false;
                rotate = true;
                rotateSpeed = 4f;
                reload = 120f;
                inaccuracy = 0f;
                shootSound = Sounds.artillery;

                shootY = 11.5f;
                bullet = new ArtilleryBulletType(2.8f, 50, "shell") {{
                    hitEffect = Fx.blastExplosion;
                    knockback = 0.5f;
                    lifetime = 150f;
                    width = height = 10f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 40f;
                    splashDamage = 180f;
                    trailColor = Color.valueOf("d06b53");
                    backColor = Color.valueOf("d06b53");
                    frontColor = Color.valueOf("ffa665");
                }};
            }});
        }};

        shif = new UnitType("shif") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 600f;
            armor = 0f;
            hitSize = 14f;
            speed = 0.9f;
            rotateSpeed = 4f;

            itemCapacity = 0;

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
            outlineColor = Color.valueOf("231b25");
            health = 3400f;
            armor = 5f;
            hitSize = 32f;
            speed = 0.9f;
            rotateSpeed = 2f;

            itemCapacity = 0;

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
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 4f;
            omniMovement = false;

            itemCapacity = 0;

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
        nail = new UnitType("nail") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 3400f;
            armor = 8f;
            hitSize = 31f;
            speed = 0.65f;
            rotateSpeed = 1f;
            omniMovement = false;

            itemCapacity = 0;

            treadFrames = 16;
            treadPullOffset = 1;
            treadRects = new Rect[]{
                    new Rect(
                            39 + 80,
                            60 + 80,
                            24,
                            24
                    ),
                    new Rect(
                            16 + 80,
                            15 + 80,
                            16,
                            24
                    ),
                    new Rect(
                            22 + 80,
                            44 - 80,
                            32,
                            20
                    )
            };

            weapons.add(new Weapon("xenacia-nail-beam"){{
                x = 0f;
                y = 0f;
                layerOffset = 0.1f;
                top = true;
                mirror = false;
                rotate = true;
                rotateSpeed = 2f;
                reload = 120f;
                recoil = 2f;
                shootSound = Sounds.laser;

                bullet = new LaserBulletType(){{
                    damage = 250f;
                    sideAngle = 75f;
                    sideWidth = 0.7f;
                    sideLength = 25f;
                    length = 85f;
                    width = 30f;
                    colors = new Color[]{Color.valueOf("ffa665").cpy().a(0.4f), Color.valueOf("ffa665"), Color.white};
                }};

                parts.addAll(
                        new RegionPart("-jaw"){{
                            x = 0f;
                            y = 0f;
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            outline = true;
                            moveX = 1.25f;
                            moveRot = 0f;
                            moves.add(new PartMove(PartProgress.recoil, 0.5f, -1f, -12f));
                        }});
            }});
        }};

        //endregion

        //region terrestrial support

        elementary = new UnitType("elementary") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("231b25");
            mechLegColor = Color.valueOf("231b25");
            health = 600f;
            armor = 0f;
            hitSize = 8f;
            speed = 0.7f;
            rotateSpeed = 3.5f;

            buildSpeed = 0.5f;

            itemCapacity = 5;

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
            outlineColor = Color.valueOf("231b25");
            defaultCommand = UnitCommand.rebuildCommand;

            health = 450f;
            armor = 0f;
            hitSize = 12f;

            speed = 1.4f;
            rotateSpeed = 8f;

            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;
            engineSize = 2.5f;
            engineOffset = 6.75f;

            mineTier = 2;
            mineSpeed = 2f;
            itemCapacity = 45;
            payloadCapacity = 144;

            buildSpeed = 0.8f;

            abilities.add(new RepairFieldAbility(5f, 120, 55f));
        }};
        haul = new UnitType("haul") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("231b25");
            defaultCommand = UnitCommand.rebuildCommand;

            health = 1800f;
            armor = 6f;
            hitSize = 30f;

            speed = 1f;
            rotateSpeed = 4f;

            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;

            setEnginesMirror(
                    new UnitEngine(5f, -12f, 3f, 270f),
                    new UnitEngine(14f, -1f, 3f, 0f)
            );
            engineSize = 0f;
            engineOffset = 7.5f;

            mineTier = 3;
            mineSpeed = 2f;
            itemCapacity = 100;
            payloadCapacity = 576;

            buildSpeed = 1f;

            abilities.add(new RepairFieldAbility(10f, 120, 80f));
        }};
        envoy = new UnitType("envoy") {{
            constructor = PayloadUnit::create;
            outlineColor = Color.valueOf("231b25");
            defaultCommand = UnitCommand.rebuildCommand;

            health = 5900f;
            armor = 9f;
            hitSize = 40f;

            speed = 1f;
            rotateSpeed = 3.2f;

            flying = true;
            lowAltitude = true;
            accel = 0.1f;
            drag = 0.05f;

            setEnginesMirror(
                    new UnitEngine(15.75f, -19f, 3f, 315f),
                    new UnitEngine(20.5f, -13f, 2.5f, 315f),
                    new UnitEngine(20.5f, 1.25f, 2.2f, 315f)
            );
            engineSize = 4.5f;
            engineOffset = 22f;

            mineTier = 4;
            mineSpeed = 2f;
            itemCapacity = 230;
            payloadCapacity = 1024;

            buildSpeed = 0.8f;

            abilities.add(new RepairFieldAbility(12f, 120, 80f));
        }};

        tick = new UnitType("tick") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
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
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 14f;
            speed = 0.7f;
            rotateSpeed = 3f;

            itemCapacity = 15;

            trailLength = 25;
            waveTrailX = 3f;
            waveTrailY = -1f;
            trailScl = 1f;

            buildSpeed = 0.5f;

            faceTarget = false;
            rotateToBuilding = false;
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
                    hitColor = Pal.heal;
                    hitEffect = despawnEffect = new MultiEffect(
                            new Effect(60f, e -> {
                                color(Pal.heal);
                                stroke(e.fin() * 0.8f);
                                Lines.circle(e.x, e.y, 0f + e.fout() * 5f);
                            }).startDelay(-20),
                            new Effect(45f, e -> {
                                color(Pal.heal);
                                stroke(e.fin() * 0.8f);
                                Lines.circle(e.x, e.y, 0f + e.fout() * 10f);
                            }).startDelay(-20),
                            new Effect(30f, e -> {
                                color(Pal.heal);
                                stroke(e.fin() * 0.8f);
                                Lines.circle(e.x, e.y, 0f + e.fout() * 15f);
                            }).startDelay(-20),
                            Fx.hitBulletColor
                    );
                }};

            }});

            abilities.add(new RepairFieldAbility(15f, 120, 100f));
        }};
        enavo = new UnitType("enavo") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 2100f;
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
            rotateToBuilding = false;
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
                        homingRange = 100;
                        homingPower = 0.5f;

                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("98ffa9");

                        lifetime = 45f;
                        hitSound = Sounds.plasmaboom;
                        splashDamage = 20f;
                        splashDamageRadius = 10f;
                    }};
                }};

            }});
            weapons.add(new Weapon("xenacia-enavo-missiles"){{
                x = 7.75f;
                y = -6.875f;
                mirror = true;

                shootCone = 25f;
                reload = 30f;
                shootY = 3.25f;
                rotate = true;
                rotateSpeed = 2.5f;
                shoot.shots = 3;
                inaccuracy = 5;

                shootSound = Sounds.missile;

                bullet = new MissileBulletType(5f, 30){{
                    homingPower = 0.08f;
                    weaveMag = 4;
                    weaveScale = 4;
                    lifetime = 50f;
                    velocityRnd = 0.5f;
                    shootEffect = Fx.shootHeal;
                    smokeEffect = Fx.hitLaser;
                    hitEffect = despawnEffect = Fx.hitLaser;
                    frontColor = Color.white;
                    hitSound = Sounds.none;

                    healAmount = 75f;
                    collidesTeam = true;
                    backColor = trailColor = Color.valueOf("98ffa9");
                }};

            }});

            abilities.add(new RepairFieldAbility(20f, 240, 120f));
        }};
        eurgi = new UnitType("eurgi") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 6600f;
            armor = 12f;
            hitSize = 50f;
            speed = 0.7f;
            rotateSpeed = 0.8f;

            itemCapacity = 110;

            trailLength = 40;
            waveTrailX = 11.25f;
            waveTrailY = -12f;
            trailScl = 1.5f;

            buildSpeed = 0.5f;

            faceTarget = false;
            rotateToBuilding = false;
            weapons.add(new Weapon("xenacia-eurgi-small-tractor-beam"){{
                x = 12f;
                y = 5.5f;
                mirror = true;
                alternate = false;
                playerControllable = false;

                shootY = 3.25f;
                rotate = true;
                rotateSpeed = 4f;
                recoil = 0;

                shootSound = Sounds.tractorbeam;

                continuous = true;
                alwaysContinuous = true;
                parentizeEffects = true;

                bullet = new PointLaserBulletType(){{
                    damage = 3f;
                    buildingDamageMultiplier = 0.1f;
                    knockback = -4f;
                    healAmount = 4f;
                    range = 0;
                    maxRange = 80f;
                    sprite = "xenacia-heal-point-laser-small";

                    color = Color.valueOf("ffffff");
                    trailColor = Color.valueOf("98ffa9");
                    hitColor = Color.valueOf("98ffa9");
                    hitEffect = Fx.pointHit;
                }};
            }});
            weapons.add(new Weapon("xenacia-eurgi-tractor-beam"){{
                x = 15.75f;
                y = -10.875f;
                mirror = true;
                alternate = false;
                playerControllable = false;

                shootY = 5f;
                rotate = true;
                rotateSpeed = 2f;
                recoil = 0;

                shootSound = Sounds.tractorbeam;

                continuous = true;
                alwaysContinuous = true;
                parentizeEffects = true;

                bullet = new PointLaserBulletType(){{
                    damage = 6f;
                    buildingDamageMultiplier = 0.1f;
                    knockback = -1.5f;
                    healAmount = 2.5f;
                    maxRange = 180f;
                    range = 0;
                    sprite = "xenacia-heal-point-laser";

                    color = Color.valueOf("ffffff");
                    trailColor = Color.valueOf("98ffa9");
                    hitColor = Color.valueOf("98ffa9");
                    hitEffect = Fx.pointHit;
                }};
            }});
            weapons.add(new Weapon("eurgi-sentry-carrier-missile-weapon"){{
                shootSound = Sounds.missileSmall;
                x = 0f;
                y = 25f;
                rotate = false;
                reload = 900f;

                bullet = new BulletType(){{
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke2;
                    keepVelocity = false;
                    collidesAir = false;
                    shootCone = 180;

                    spawnUnit = eurgiSentryCarrierMissile = new MissileUnitType("eurgi-sentry-carrier-missile"){{
                        targetAir = false;
                        speed = 3f;
                        maxRange = 6f;
                        lifetime = 60f * 1.4f;
                        outlineColor = Color.valueOf("231b25");
                        engineColor = trailColor = Color.valueOf("98ffa9");
                        engineLayer = Layer.effect;
                        health = 150;
                        loopSoundVolume = 0.1f;

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(110f, 25f){{
                                shootEffect = Fx.massiveExplosion;
                                collidesAir = false;
                            }};
                        }});
                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(0f, 0f){{
                                spawnUnit = eurgiSentry = new UnitType("eurgi-sentry") {{
                                    constructor = UnitEntity::create;
                                    outlineColor = Color.valueOf("231b25");
                                    hidden = true;
                                    health = 300f;
                                    armor = 1f;
                                    hitSize = 8f;
                                    speed = 0f;
                                    rotateSpeed = 0f;
                                    hovering = true;
                                    shadowElevation = 0.05f;
                                    useEngineElevation = false;
                                    lowAltitude = true;

                                    itemCapacity = 0;

                                    engineSize = 0f;
                                    engineOffset = 0f;

                                    weapons.add(new Weapon("xenacia-eurgi-sentry-tractor-beam"){{
                                        x = 0f;
                                        y = 0f;
                                        mirror = true;
                                        alternate = false;

                                        shootY = 3.25f;
                                        rotate = true;
                                        rotateSpeed = 4f;
                                        recoil = 0;

                                        shootSound = Sounds.tractorbeam;

                                        continuous = true;
                                        alwaysContinuous = true;
                                        parentizeEffects = true;

                                        bullet = new PointLaserBulletType(){{
                                            damage = 3f;
                                            buildingDamageMultiplier = 0.1f;
                                            knockback = -2f;
                                            healAmount = 4f;
                                            maxRange = 80f;
                                            sprite = "xenacia-heal-point-laser-small";

                                            color = Color.valueOf("ffffff");
                                            trailColor = Color.valueOf("98ffa9");
                                            hitColor = Color.valueOf("98ffa9");
                                            hitEffect = Fx.pointHit;
                                        }};
                                    }});

                                    parts.add(new HoverPart(){{
                                        x = 0f;
                                        y = 0f;
                                        mirror = false;
                                        radius = 8f;
                                        phase = 90f;
                                        stroke = 1.5f;
                                        layerOffset = -0.001f;
                                        color = Color.valueOf("98ffa9");
                                    }});
                                }};
                            }};
                        }});
                    }};
                }};
            }});
        }};
        eurgiSentry.playerControllable = false;
        eurgiSentry.logicControllable = false;
        eurgi.playerControllable = true;
        eurgi.logicControllable = true;
        eurgi.aiController = enavo.aiController;

        aid = new UnitType("aid") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 600f;
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

            weapons.add(new Weapon("xenacia-aid-missiles"){{
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
        guard = new UnitType("guard") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 3200f;
            armor = 5f;
            hitSize = 24f;
            speed = 0.7f;
            rotateSpeed = 1f;
            omniMovement = false;

            itemCapacity = 10;

            treadFrames = 16;
            treadPullOffset = 1;
            treadRects = new Rect[]{
                    new Rect(
                            15 - 80,
                            15 - 80,
                            37,
                            126
                    )
            };

            faceTarget = false;

            weapons.add(new Weapon("xenacia-guard-missiles"){{
                top = true;
                rotate = true;
                rotateSpeed = 2f;
                x = 0f;
                y = -2.5f;
                mirror = false;
                inaccuracy = 8f;
                reload = 20f;
                shootSound = Sounds.missile;
                recoil = 0.8f;

                shoot = new ShootBarrel(){{
                    barrels = new float[]{
                            4.75f, 4f, 0f,
                            0f, 6f, 0f,
                            -4.75f, 4f, 0f,
                    };
                    shots = 6;
                    shotDelay = 0.5f;
                }};

                bullet = new MissileBulletType(5f, 5) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 35f;
                    splashDamageRadius = 8f;
                    splashDamage = 15f;
                    lifetime = 45f;
                    weaveScale = 2f;
                    weaveMag = 4f;

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
            outlineColor = Color.valueOf("231b25");
            mechLegColor = Color.valueOf("231b25");
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
            outlineColor = Color.valueOf("231b25");

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
                    damage = 10;
                    sapStrength = 0.8f;
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
            outlineColor = Color.valueOf("231b25");

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
                    new UnitEngine(52 / 4f, 25 / 4f, 2.5f, 45f),
                    new UnitEngine(48 / 4f, -44 / 4f, 2.5f, 315f),
                    new UnitEngine(0, -44 / 4f, 2.5f, 90f)
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
                    damage = 15;
                    sapStrength = 0.8f;
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
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.6f;
            rotateSpeed = 4.5f;

            itemCapacity = 0;

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
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 12f;
            speed = 0.8f;
            rotateSpeed = 2.5f;

            itemCapacity = 0;

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
            outlineColor = Color.valueOf("231b25");
            health = 2100f;
            armor = 6.5f;
            hitSize = 12f;
            speed = 0.7f;
            rotateSpeed = 2f;

            itemCapacity = 0;

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
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 13f;
            speed = 0.8f;
            rotateSpeed = 3f;
            omniMovement = false;

            itemCapacity = 0;

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

            weapons.add(new Weapon("ltie-flare"){{
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
        link = new UnitType("link") {{
            constructor = TankUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 1500f;
            armor = 6f;
            hitSize = 24f;
            speed = 0.6f;
            rotateSpeed = 1f;
            omniMovement = false;

            itemCapacity = 0;

            treadFrames = 16;
            treadRects = new Rect[]{
                    new Rect(
                            -32f,
                            -35f,
                            27,
                            128
                    )
            };

            faceTarget = true;

            weapons.add(new Weapon("link-flare"){{
                x = 0f;
                y = 4f;
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
                    damage = 15f;
                    buildingDamageMultiplier = 1.5f;

                    pierce = true;
                    pierceBuilding = false;
                    pierceCap = 5;

                    status = StatusEffects.burning;
                    statusDuration = 180f;

                    length = 75f;
                    width = 10f;

                    colors = new Color[]{
                            Pal.sapBulletBack.cpy().a(0.2f),
                            Pal.sapBulletBack.cpy().a(0.4f),
                            Pal.sapBullet.cpy().a(0.4f),
                            Pal.sapBullet.cpy().a(0.7f),
                            Color.white
                    };

                    flareColor = Pal.sapBullet;
                    flareLength = 35f;
                    flareWidth = 4f;
                    flareRotSpeed = -2f;
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
            outlineColor = Color.valueOf("231b25");
            health = 110f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.8f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            aiController = SuicideAI::new;

            legForwardScl = 5f;
            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 7.5f;
            legExtension = 1f;
            legBaseOffset = 1f;
            legStraightness = 0.3f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            allowLegStep = false;

            legMoveSpace = 0.8f;
            hovering = false;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

            range = 20f;

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
        coreParasite = new UnitType("core-parasite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 16f;
            speed = 0.6f;
            rotateSpeed = 4f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legCount = 6;
            legGroupSize = 2;
            legLength = 14f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 4f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;
            stepShake = 0;

            legMoveSpace = 1f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

            abilities.add(new UnitSpawnAbility(coreMite, 60 * 5, 0f, 5.75f));
        }};
        navalCoreMite = new UnitType("naval-core-mite") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 100f;
            armor = 0f;
            hitSize = 8f;
            speed = 1f;
            rotateSpeed = 8f;
            drag = 0.11f;

            trailLength = 15;
            waveTrailX = 1.5f;
            waveTrailY = -1f;
            trailScl = 1f;

            useUnitCap = false;
            itemCapacity = 0;

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
            outlineColor = Color.valueOf("231b25");
            health = 100f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.8f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legForwardScl = 5f;
            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 7.5f;
            legExtension = 1f;
            legBaseOffset = 1f;
            legStraightness = 0.3f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            allowLegStep = false;

            legMoveSpace = 0.8f;
            hovering = false;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

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
        assaultParasite = new UnitType("assault-parasite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 16f;
            speed = 0.6f;
            rotateSpeed = 4f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legCount = 6;
            legGroupSize = 2;
            legLength = 14f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 4f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;
            stepShake = 0;

            legMoveSpace = 1f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

            abilities.add(new UnitSpawnAbility(assaultMite, 60 * 5, 0f, -4.5f));
        }};
        navalAssaultMite = new UnitType("naval-assault-mite") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 100f;
            armor = 0f;
            hitSize = 8f;
            speed = 1f;
            rotateSpeed = 8f;
            drag = 0.11f;

            trailLength = 15;
            waveTrailX = 1.5f;
            waveTrailY = -1f;
            trailScl = 1f;

            useUnitCap = false;
            itemCapacity = 0;

            weapons.add(new Weapon("xenacia-naval-assault-mite-weapon") {{
                x = 0f;
                y = -3f;
                rotate = true;
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

        supportMite = new UnitType("support-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 100f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.8f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legForwardScl = 5f;
            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 7.5f;
            legExtension = 1f;
            legBaseOffset = 1f;
            legStraightness = 0.3f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            allowLegStep = false;

            legMoveSpace = 0.8f;
            hovering = false;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

            weapons.add(new Weapon("support-mite-weapon") {{
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
        supportParasite = new UnitType("support-parasite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 16f;
            speed = 0.6f;
            rotateSpeed = 4f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legCount = 6;
            legGroupSize = 2;
            legLength = 14f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 4f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;
            stepShake = 0;

            legMoveSpace = 1f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

            abilities.add(new UnitSpawnAbility(supportMite, 60 * 5, 0f, 3f));
        }};
        navalSupportMite = new UnitType("naval-support-mite") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 100f;
            armor = 0f;
            hitSize = 8f;
            speed = 1f;
            rotateSpeed = 8f;
            drag = 0.11f;

            trailLength = 15;
            waveTrailX = 1.5f;
            waveTrailY = -1f;
            trailScl = 1f;

            useUnitCap = false;
            itemCapacity = 0;

            weapons.add(new Weapon("xenacia-naval-support-mite-weapon") {{
                x = 0f;
                y = -2.5f;
                rotate = true;
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

        specialistMite = new UnitType("specialist-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 85f;
            armor = 0f;
            hitSize = 6f;
            speed = 0.8f;
            rotateSpeed = 8f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legForwardScl = 5f;
            legContinuousMove = true;
            legCount = 4;
            legGroupSize = 1;
            legLength = 7.5f;
            legExtension = 1f;
            legBaseOffset = 1f;
            legStraightness = 0.3f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            allowLegStep = false;

            legMoveSpace = 0.8f;
            hovering = false;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

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
        specialistParasite = new UnitType("specialist-parasite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("231b25");
            health = 650f;
            armor = 0f;
            hitSize = 16f;
            speed = 0.6f;
            rotateSpeed = 4f;
            drag = 0.11f;

            useUnitCap = false;
            itemCapacity = 0;

            legCount = 6;
            legGroupSize = 2;
            legLength = 14f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 4f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;
            stepShake = 0;

            legMoveSpace = 1f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            drownTimeMultiplier = 0.5f;

            abilities.add(new UnitSpawnAbility(specialistMite, 60 * 5, 0f, -3f));
        }};
        navalSpecialistMite = new UnitType("naval-specialist-mite") {{
            constructor = UnitWaterMove::create;
            outlineColor = Color.valueOf("231b25");
            health = 100f;
            armor = 0f;
            hitSize = 8f;
            speed = 1f;
            rotateSpeed = 8f;
            drag = 0.11f;

            trailLength = 15;
            waveTrailX = 1.5f;
            waveTrailY = -1f;
            trailScl = 1f;

            useUnitCap = false;
            itemCapacity = 0;

            weapons.add(new Weapon("xenacia-naval-specialist-mite-weapon") {{
                x = 0f;
                y = -2.25f;
                rotate = true;
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