package xenacia.content;

import arc.graphics.Color;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.content.*;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.*;

public class XenTurrets{
    public static Block
            repeater;

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
        
    }
}