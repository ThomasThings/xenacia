package prime.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.gen.*;

public class PSUnitTypes {
    public static UnitType
            //mites
            assaultMite, boltMite, sapMite, coreMite,
            //seeds
            mech, aircraft, polyped, ship, tank;

    public static void load() {
        //mites
        assaultMite = new UnitType("assault-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 80f;
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

            weapons.add(new Weapon("assault-mite-weapon"){{
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 30f;
                bullet = new BasicBulletType(3.5f, 9){{
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
            health = 80f;
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

            weapons.add(new Weapon("bolt-mite-weapon"){{
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 30f;
                bullet = new LaserBoltBulletType(3.5f, 9){{
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
            health = 65f;
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

            weapons.add(new Weapon("sap-mite-weapon"){{
                x = 0f;
                y = 0f;
                rotate = false;
                mirror = false;
                reload = 15f;
                bullet = new SapBulletType(){{
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
        coreMite = new UnitType("core-mite") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("242125");
            health = 100f;
            armor = 0f;
            hitSize = 6f;
            speed = 1f;
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
            legBaseOffset = 0.5f;
            legStraightness = 0.5f;
            rippleScale = 0.1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            allowLegStep = false;

            weapons.add(new Weapon(){{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType(){{
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
        //seeds
        mech = new UnitType("mech") {{
            constructor = MechUnit::create;
            outlineColor = Color.valueOf("242125");
            mechLegColor = Color.valueOf("242125");
            health = 250f;
            armor = 0f;
            hitSize = 10f;
            speed = 0.8f;
            rotateSpeed = 5f;

            itemCapacity = 5;
            isEnemy = false;

            mechFrontSway = 0.2f;
            mechSideSway = 0.3f;
        }};

    }
}