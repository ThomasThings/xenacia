package xenacia.content;

import arc.graphics.Color;
import arc.math.Interp;
import arc.math.Mathf;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.part.RegionPart;
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
            size = 2;
            requirements(Category.turret, with(XenItems.iron, 80, XenItems.aluminum, 120, Items.graphite, 80));
            ammo(
                    Items.graphite,  new BasicBulletType(0f, 1){{
                        shootEffect = Fx.shootBig;
                        smokeEffect = Fx.none;
                        ammoMultiplier = 1f;

                        spawnUnit = new MissileUnitType("clinger-missile"){{
                            outlineColor = Color.valueOf("292729");
                            targetAir = true;
                            speed = 4.3f;
                            maxRange = 6f;
                            lifetime = 100f;
                            engineColor = trailColor = Color.valueOf("feb380");
                            engineLayer = Layer.effect;
                            health = 45;
                            loopSoundVolume = 0.1f;

                            weapons.add(new Weapon(){{
                                shootCone = 360f;
                                mirror = false;
                                reload = 1f;
                                shootOnDeath = true;
                                bullet = new ExplosionBulletType(250f, 20f){{
                                    shootEffect = Fx.massiveExplosion;
                                    collidesAir = false;
                                }};
                            }});
                        }};
                    }}
            );
            reload = 180f;
            range = 440;
            shootCone = 1f;
            ammoUseEffect = Fx.none;
            health = 800;
            inaccuracy = 0f;
            rotateSpeed = 2f;
            coolant = consumeCoolant(0.2f);

            drawer = new DrawTurret("xenacia-"){{
                parts.add(
                        new RegionPart("-blade"){{
                            progress = PartProgress.warmup;
                            moves.add(new PartMove(PartProgress.recoil, 0f, 1f, -7.5f));
                            moveRot = -22f;
                            moveX = 0f;
                            moveY = -5f;
                            mirror = true;
                            }},
                        new RegionPart("-missile"){{
                            progress = PartProgress.reload.curve(Interp.pow2In);

                            colorTo = new Color(1f, 1f, 1f, 0f);
                            color = Color.white;
                            mixColorTo = Pal.accent;
                            mixColor = new Color(1f, 1f, 1f, 0f);
                            outline = false;
                            under = true;

                            layerOffset = -0.01f;

                            moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -2f, 0f));
                        }},
                        new RegionPart("-mid"){{
                            progress = PartProgress.warmup;
                            moves.add(new PartMove(PartProgress.recoil, 0f, -1f, 0));
                            mirror = false;
                            under = false;
                            moveY = -4f;
                        }},
                        new RegionPart("-mid"){{
                            progress = PartProgress.warmup;
                            moves.add(new PartMove(PartProgress.recoil, 0f, -1f, 0));
                            mirror = false;
                            under = false;
                           moveY = -6f;
                        }}
                );
            }};

            limitRange();
        }};
    }
}