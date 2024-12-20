package xenacia.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
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
            requirements(Category.turret, buildVisibility.hidden, with(XenItems.alamex, 1));
            drawer = new DrawTurret(){{
                basePrefix = "xen-";
            }};
            outlineColor = Color.valueOf("353344");
            size = 1;
            ammo(
                    XenItems.alamex,  new BasicBulletType(){{
                        killShooter = true;
                        lifetime = 0f;
                        fragBullets = 5;
                        fragBullet = new ArtilleryBulletType(3f, 0){{
                            width = 4f;
                            height = 4f;
                            shrinkY = 1f;
                            lifetime = 45f;
                            backColor = Color.valueOf("71d299");
                            frontColor = Color.white;
                            collidesTeam = true;
                            healAmount = 15;
                            splashDamageRadius = 1500;
                        }};
                    }}
            );
            shootType = new BasicBulletType(){{
                    killShooter = true;
                    lifetime = 0f;
                    fragBullets = 5;
                    fragBullet = new ArtilleryBulletType(3f, 0) {{
                        width = 4f;
                        height = 4f;
                        shrinkY = 1f;
                        lifetime = 45f;
                        backColor = Color.valueOf("71d299");
                        frontColor = Color.white;
                        collidesTeam = true;
                        healAmount = 15;
                        splashDamageRadius = 1500;
                    }};
                }};
            range = 115;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 450;
            inaccuracy = 5.5f;
            rotateSpeed = 8f;
        }};
    }
}
