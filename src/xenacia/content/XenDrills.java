package xenacia.content;

import mindustry.entities.effect.MultiEffect;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.production.BurstDrill;
import mindustry.world.blocks.production.Drill;
import xenacia.world.blocks.production.TurbineDrill;
import xenacia.world.blocks.production.VaultDrill;

import static mindustry.type.ItemStack.*;

public class XenDrills{
    public static Block
            drill, hydraulicDrill, bulkDrill, precisionDrill, turbineDrill, vaultDrill, detonationDrill, titanicDrill;
    public static void load() {
        drill = new Drill("drill"){{
            requirements(Category.production, with(XenItems.iron, 25));
            health = 200;
            drillTime = 400;
            size = 2;
            tier = 2;
            updateEffect = Fx.pulverizeSmall;
        }};
        hydraulicDrill = new Drill("hydraulic-drill"){{
            requirements(Category.production, with(XenItems.iron, 15, XenItems.aluminum, 10, Items.graphite, 15));
            health = 250;
            drillTime = 300;
            size = 2;
            tier = 3;
            updateEffect = Fx.pulverizeSmall;

            rotateSpeed = -2.5f;

            consumeLiquid(Liquids.water, 0.08f);
        }};
        bulkDrill = new Drill("bulk-drill"){{
            requirements(Category.production, with(Items.titanium, 80, XenItems.iron, 50, Items.graphite, 25, Items.silicon, 30));
            health = 550;
            drillTime = 250;
            size = 3;
            hasPower = true;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;

            rotateSpeed = 4f;

            consumePower(0.80f);
        }};
        precisionDrill = new Drill("precision-drill"){{
            requirements(Category.production, with(Items.titanium, 5, XenItems.iron, 10, Items.silicon, 10));
            health = 100;
            drillTime = 400;
            size = 1;
            hasPower = true;
            tier = 4;
            drillEffect = Fx.mineSmall;

            rotateSpeed = 6f;

            consumePower(0.30f);
        }};
        turbineDrill = new TurbineDrill("turbine-drill"){{
            requirements(Category.production, with(XenItems.iron, 80, Items.graphite, 40, Items.silicon, 60));
            health = 550;
            drillTime = 250;
            size = 3;
            hasPower = true;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.drillSteam;
            updateEffectChance = 1;
            drillEffectChance = 1;

            rotateSpeed = 2f;

            powerProduction = 5.5f;
            consumeLiquid(XenLiquids.steam, 0.15f);
        }};
        vaultDrill = new VaultDrill("vault-drill"){{
            requirements(Category.production, with(XenItems.iron, 50, Items.titanium, 100, Items.graphite, 40));
            health = 550;
            drillTime = 200;
            size = 3;
            hasPower = true;
            tier = 4;
            itemCapacity = 800;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;

            rotateSpeed = -3f;

            consumePower(1f);
        }};
        detonationDrill = new Drill("detonation-drill"){{
            requirements(Category.production, with(XenItems.cobalt, 250, Items.titanium, 200, XenItems.aluminum, 100, Items.graphite, 80));
            health = 1100;
            drillTime = 200;
            size = 5;
            hasPower = true;
            tier = 5;
            updateEffect = new MultiEffect(Fx.pulverizeMedium, Fx.pulverizeMedium, Fx.pulverizeSmall);
            drillEffect = new MultiEffect(Fx.mineBig, Fx.mineBig);

            consumePower(2f);
            consumeLiquid(XenLiquids.voltike, 0.2f);
        }};
        titanicDrill = new BurstDrill("titanic-drill"){{
            requirements(Category.production, with(XenItems.volcrite, 350, XenItems.cobalt, 200, Items.titanium, 200, Items.silicon, 200));
            drillTime = 100;
            size = 7;
            hasPower = true;
            tier = 8;

            drillEffect = new MultiEffect(
                    Fx.mineImpact,
                    Fx.drillSteam,
                    Fx.dynamicSpikes.wrap(XenLiquids.magma.color, 30f),
                    Fx.mineImpactWave.wrap(XenLiquids.magma.color, 45f),
                    Fx.mineImpactWave.wrap(XenLiquids.magma.color, -45f)
            );
            shake = 4f;
            itemCapacity = 100;
            arrowOffset = 2f;
            arrowSpacing = 5f;
            arrows = 2;

            rotateSpeed = 6f;

            consumePower(6f);
            consumeLiquids(LiquidStack.with(XenLiquids.voltike, 4f / 60f));
        }};
    }
}
