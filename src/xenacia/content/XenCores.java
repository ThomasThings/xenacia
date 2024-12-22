package xenacia.content;

import arc.graphics.Color;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.EmpBulletType;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class XenCores{
    public static Block
            coreDevise, coreContrive,
            coreDoctrine, coreOccult,
            healBombTest;

    public static void load(){
        coreDevise = new CoreBlock("core-devise"){{
            requirements(Category.effect, with(XenItems.alamex, 850));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = XenUnitTypes.radix;
            health = 1250;
            itemCapacity = 1500;
            size = 2;

            unitCapModifier = 4;
            squareSprite = false;
        }};
        coreContrive = new CoreBlock("core-contrive"){{
            requirements(Category.effect, with(XenItems.alamex, 1200, XenItems.torren, 500));
            alwaysUnlocked = true;

            isFirstTier = false;
            unitType = XenUnitTypes.refine;
            health = 2500;
            itemCapacity = 5000;
            size = 3;

            unitCapModifier = 8;
            squareSprite = false;
        }};
        coreDoctrine = new CoreBlock("core-doctrine"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(XenItems.alamex, 550, XenItems.lenora, 350));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = XenUnitTypes.radix;
            health = 1400;
            itemCapacity = 1500;
            size = 2;

            unitCapModifier = 6;
            squareSprite = false;
        }};
        coreOccult = new CoreBlock("core-occult"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(XenItems.alamex, 1000, XenItems.torren, 400, XenItems.lenora, 600));
            alwaysUnlocked = true;

            isFirstTier = false;
            unitType = XenUnitTypes.radix;
            health = 3000;
            itemCapacity = 4000;
            size = 3;

            unitCapModifier = 12;
            squareSprite = false;
        }};
        healBombTest = new PowerTurret("test"){{
            requirements(Category.effect, with(XenItems.alamex, 35, XenItems.veilla, 25));
            drawer = new DrawTurret(){{
                basePrefix = "xen-";
                hasShadow = false;
            }};
            outlineColor = Color.valueOf("353344");
            size = 2;
            shootType = new BasicBulletType(){{
                killShooter = true;
                lifetime = 0f;
                fragBullets = 1;
                fragBullet = new EmpBulletType() {{
                    speed = 0;
                    width = 8f;
                    height = 8f;
                    shrinkY = 1f;
                    shrinkX = 1f;
                    sprite = "circle-bullet";
                    lifetime = 15f;
                    backColor = Color.valueOf("71d299");
                    frontColor = Color.white;
                    collidesTeam = true;
                    healAmount = 120;
                    splashDamage = 60;
                    splashDamageRadius = 64;
                    fragBullets = 1;
                    fragBullet = new BasicBulletType() {{
                        speed = 0;
                        width = 8f;
                        height = 8f;
                        shrinkY = 1f;
                        shrinkX = 1f;
                        sprite = "circle-bullet";
                        lifetime = 15f;
                        backColor = Color.valueOf("71d299");
                        frontColor = Color.white;
                        collidesTeam = true;
                        healAmount = 70;
                        splashDamage = 60;
                        splashDamageRadius = 48;
                        fragBullets = 1;
                        fragBullet = new EmpBulletType() {{
                            speed = 0;
                            width = 8f;
                            height = 8f;
                            shrinkY = 1f;
                            shrinkX = 1f;
                            sprite = "circle-bullet";
                            lifetime = 15f;
                            backColor = Color.valueOf("71d299");
                            frontColor = Color.white;
                            collidesTeam = true;
                            healAmount = 50;
                            splashDamage = 60;
                            splashDamageRadius = 32;
                        }};
                    }};
                }};
            }};
            shoot.firstShotDelay = 45;
            alwaysShooting = true;
            range = 115;
            shootCone = 180f;
            rotateSpeed = 0f;
        }};
    }
}
