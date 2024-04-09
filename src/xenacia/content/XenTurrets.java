package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.with;

public class XenTurrets{
    public static Block
            bolt, beam;

    public static void load(){
        bolt = new PowerTurret("bolt"){{
            requirements(Category.turret, with(XenItems.alamex, 30, XenItems.torren, 5));
            size = 1;
            health = 300;

            reload = 40f;
            shootCone = 8f;
            rotateSpeed = 6.5f;
            targetAir = true;
            range =  100f;

            shootType = new LaserBoltBulletType(){{
                damage = 15;
                speed = 3f;
                lifetime = 50f;
                collidesTeam = false;
                backColor = Color.valueOf("c6cef0");
                frontColor = Color.white;
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
            size = 2;
            health = 900;

            reload = 120f;
            shootCone = 3f;
            rotateSpeed = 6.5f;
            targetAir = true;
            range =  100f;

            shootType = new LaserBulletType(){{
                damage = 150;
                buildingDamageMultiplier = 0.75f;
                collidesAir = true;

                hitSize = 4;
                lifetime = 20f;
                drawSize = 400f;
                width = 20;
                length = 155f;
                shootY = 17f;

                pierceCap = 4;

                hitEffect = Fx.hitLancer;
                shootEffect = Fx.lancerLaserShoot;
                smokeEffect = Fx.none;

                colors = new Color[]{Color.valueOf("c6cef0").cpy().a(0.4f), Color.valueOf("c6cef0"), Color.white};
            }};

            shootEffect = Fx.none;
            heatColor = Color.red;
            recoil = 0.8f;
            shootSound = Sounds.laserbeam;

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
    }
}
