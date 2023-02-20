package xenacia.content;

import arc.graphics.Color;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.unit.MissileUnitType;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.content.*;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.*;

public class XenTurrets{
    public static Block
            repeater, clinger;

    public static void load(){
        repeater = new ItemTurret("repeater"){{
            outlineColor = Color.valueOf("292729");
            drawer = new DrawTurret("xenacia-");
            requirements(Category.turret, with(XenItems.iron, 25, XenItems.aluminum, 15));
            ammo(
                    XenItems.iron,  new BasicBulletType(4f, 15){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                        hitColor = backColor = trailColor = Color.valueOf("9d8e8e");
                        frontColor = Color.valueOf("ffffff");
                        trailWidth = 1f;
                        trailLength = 3;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }},
                    XenItems.aluminum,  new BasicBulletType(4f, 15){{
                        width = 7f;
                        height = 9f;
                        lifetime = 90f;
                        hitColor = backColor = trailColor = Color.valueOf("a8a8bd");
                        frontColor = Color.valueOf("ffffff");
                        trailWidth = 1f;
                        trailLength = 4;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }}
            );

            shoot = new ShootAlternate(3f);

            shootY = 3f;
            reload = 30f;
            range = 110;
            shootCone = 10f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCost = with(XenItems.iron, 100, XenItems.aluminum, 50);

            limitRange();
        }};
        clinger = new ItemTurret("clinger"){{
            outlineColor = Color.valueOf("292729");
            drawer = new DrawTurret("xenacia-");
            size = 2;
            requirements(Category.turret, with(XenItems.iron, 80, XenItems.aluminum, 120, Items.graphite, 80));
            ammo(
                    Items.graphite,  new BasicBulletType(0f, 1){{
                        shootEffect = Fx.shootBig;
                        smokeEffect = Fx.shootSmokeMissile;
                        ammoMultiplier = 1f;

                        spawnUnit = new MissileUnitType("clinger-missile"){{
                            targetAir = false;
                            speed = 4.3f;
                            maxRange = 6f;
                            lifetime = 60f * 1.4f;
                            outlineColor = Pal.darkOutline;
                            engineColor = trailColor = Pal.sapBulletBack;
                            engineLayer = Layer.effect;
                            health = 45;
                            loopSoundVolume = 0.1f;

                            weapons.add(new Weapon(){{
                                shootCone = 360f;
                                mirror = false;
                                reload = 1f;
                                shootOnDeath = true;
                                bullet = new ExplosionBulletType(120f, 18f){{
                                    shootEffect = Fx.massiveExplosion;
                                    collidesAir = false;
                                }};
                            }});
                        }};
                    }}
            );
            reload = 120f;
            range = 440;
            shootCone = 1f;
            ammoUseEffect = Fx.none;
            health = 800;
            inaccuracy = 0f;
            rotateSpeed = 1f;
            coolant = consumeCoolant(0.2f);

            limitRange();
        }};
    }
}