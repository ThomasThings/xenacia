package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.with;

public class XenTurrets{
    public static Block
            bolt, beam, cast, streak;

    public static void load(){
        bolt = new PowerTurret("bolt"){{
            requirements(Category.turret, with(XenItems.alamex, 30, XenItems.torren, 5));
            outlineColor = Color.valueOf("353344");
            size = 1;
            health = 300;

            reload = 20f;
            shootCone = 8f;
            rotateSpeed = 6.5f;
            targetAir = true;
            range =  100f;

            shootType = new LaserBoltBulletType(){{
                damage = 10;
                speed = 3f;
                lifetime = 40f;
                collidesTeam = false;
                backColor = Color.valueOf("c6cef0");
                frontColor = Color.white;
                shootEffect = smokeEffect = hitEffect = despawnEffect = Fx.hitLaserColor;
            }};

            drawer = new DrawTurret(){{
                basePrefix = "xen-";
            }};

            shootEffect = Fx.none;
            heatColor = Color.red;
            recoil = 0.8f;
            shootSound = Sounds.lasershoot;

            consumePower(2f);
            coolant = consumeCoolant(0.1f);
        }};
        beam = new PowerTurret("beam"){{
            requirements(Category.turret, with(XenItems.alamex, 90, XenItems.torren, 30, XenItems.silicium, 25));
            outlineColor = Color.valueOf("353344");
            size = 2;
            health = 900;

            reload = 120f;
            shootCone = 3f;
            rotateSpeed = 6.5f;
            targetAir = true;
            range =  120f;

            shootType = new LaserBulletType(){{
                damage = 150;
                buildingDamageMultiplier = 0.75f;
                collidesAir = true;

                hitSize = 4;
                lifetime = 20f;
                drawSize = 400f;
                width = 20;
                length = 125f;
                shootY = 2.5f;

                pierceCap = 4;

                hitEffect = Fx.hitLancer;

                colors = new Color[]{Color.valueOf("c6cef0").cpy().a(0.4f), Color.valueOf("c6cef0"), Color.white};
            }};

            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            recoil = 1.2f;
            shootSound = Sounds.laser;

            drawer = new DrawTurret(){{
                basePrefix = "xen-";
                parts.add(new RegionPart("-cylinder"){{
                    progress = PartProgress.recoil;
                    under = false;
                    mirror = true;
                    moveY = -2f;
                }});
            }};

            consumePower(2f);
            coolant = consumeCoolant(0.1f);
        }};
        cast = new ItemTurret("cast"){{
            requirements(Category.turret, with(XenItems.alamex, 55));
            outlineColor = Color.valueOf("353344");
            size = 1;
            ammo(
                    XenItems.alamex,  new BasicBulletType(3f, 5){{
                        width = 6f;
                        height = 7.5f;
                        lifetime = 30f;
                        ammoMultiplier = 5;
                    }}
            );

            recoil = 0.5f;
            shootY = 3f;
            reload = 10f;
            range = 230;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 200;
            inaccuracy = 8f;
            rotateSpeed = 8f;
            coolant = consumeCoolant(0.1f);

            limitRange();
        }};
        streak = new ItemTurret("streak"){{
            requirements(Category.turret, with(XenItems.alamex, 180, XenItems.torren, 125));
            outlineColor = Color.valueOf("353344");
            size = 2;
            ammo(
                    XenItems.alamex,  new BasicBulletType(4.5f, 15){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        ammoMultiplier = 1;
                    }}
            );

            shoot = new ShootAlternate(6f);

            recoils = 2;
            drawer = new DrawTurret(){{
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -2f;
                    }});
                }
            }};

            recoil = 0.5f;
            shootY = 3f;
            reload = 25f;
            range = 230;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 600;
            inaccuracy = 4f;
            rotateSpeed = 8f;
            coolant = consumeCoolant(0.1f);

            limitRange();
        }};
    }
}
