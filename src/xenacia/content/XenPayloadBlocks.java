package xenacia.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.payloads.*;

import static mindustry.type.ItemStack.*;

public class XenPayloadBlocks{
    public static Block
            smallPayloadConveyor, largePayloadConveyor,
            smallPayloadRouter, largePayloadRouter,
            smallPayloadConstructor, largePayloadConstructor,
            smallPayloadLoader, largePayloadLoader,
            smallPayloadLaunchTower, largePayloadLaunchTower,
            smallPayloadUnloader, largePayloadUnloader,
            smallPayloadDeconstructor, largePayloadDeconstructor;

    public static void load() {
        smallPayloadConveyor = new PayloadConveyor("small-payload-conveyor"){{
            requirements(Category.units, with(XenItems.iron, 10,XenItems.graphite, 10,XenItems.silicon, 5));
            health = 900;
            size = 3;
            payloadLimit = 3f;
            canOverdrive = true;
            moveTime = 30f;
        }};
        largePayloadConveyor = new PayloadConveyor("large-payload-conveyor"){{
            requirements(Category.units, with(XenItems.neodymium, 40,XenItems.graphite, 30,XenItems.silicon, 30));
            health = 2500;
            size = 5;
            payloadLimit = 5.5f;
            canOverdrive = true;
            moveTime = 60f;
        }};

        smallPayloadRouter = new PayloadRouter("small-payload-router"){{
            requirements(Category.units, with(XenItems.iron, 15,XenItems.graphite, 10,XenItems.silicon, 10));
            health = 900;
            size = 3;
            payloadLimit = 3f;
            canOverdrive = true;
            moveTime = 30f;
        }};
        largePayloadRouter = new PayloadRouter("large-payload-router"){{
            requirements(Category.units, with(XenItems.neodymium, 50,XenItems.graphite, 30,XenItems.silicon, 40));
            health = 2500;
            size = 5;
            payloadLimit = 5.5f;
            canOverdrive = true;
            moveTime = 60f;
        }};

        smallPayloadConstructor = new Constructor("small-payload-constructor"){{
            requirements(Category.units, with(XenItems.iron, 100,XenItems.graphite, 100));
            health = 900;
            size = 3;
            hasPower = true;
            buildSpeed = 0.7f;
            consumePower(2f);
        }};
        largePayloadConstructor = new Constructor("large-payload-constructor"){{
            requirements(Category.units, with(XenItems.cobalt, 250, XenItems.iron, 200,XenItems.silicon, 150));
            health = 2500;
            size = 7;
            minBlockSize = 2;
            maxBlockSize = 5;
            hasPower = true;
            buildSpeed = 1f;
            consumePower(3f);
        }};

        smallPayloadLoader = new PayloadLoader("small-payload-loader"){{
            requirements(Category.units, with(XenItems.aluminum, 100,XenItems.graphite, 80,XenItems.silicon, 80));
            health = 900;
            size = 3;
            hasPower = true;
            consumePower(2f);
        }};
        largePayloadLoader = new PayloadLoader("large-payload-loader"){{
            requirements(Category.units, with(XenItems.cobalt, 150, XenItems.aluminum, 100,XenItems.graphite, 200,XenItems.silicon, 200));
            health = 2500;
            size = 7;
            maxBlockSize = 6;
            hasPower = true;
            consumePower(3f);
        }};

        smallPayloadLaunchTower = new PayloadMassDriver("small-payload-launch-tower"){{
            requirements(Category.units, with(XenItems.iron, 80, XenItems.aluminum, 80,XenItems.silicon, 80));
            health = 900;
            size = 3;
            reload = 150f;
            chargeTime = 60f;
            range = 640f;
            maxPayloadSize = 2.5f;
            consumePower(2f);
            outlineIcon = false;
        }};
        largePayloadLaunchTower = new PayloadMassDriver("large-payload-launch-tower"){{
            requirements(Category.units, with(XenItems.iron, 500, XenItems.aluminum, 550,XenItems.silicon, 450, XenItems.cobalt, 250));
            health = 4900;
            size = 7;
            reload = 240f;
            chargeTime = 120f;
            range = 960f;
            maxPayloadSize = 6.5f;
            consumePower(5f);
            outlineIcon = false;
        }};

        smallPayloadUnloader = new PayloadUnloader("small-payload-unloader"){{
            requirements(Category.units, with(XenItems.aluminum, 100,XenItems.graphite, 80,XenItems.silicon, 80));
            health = 900;
            size = 3;
            hasPower = true;
            consumePower(2f);
        }};
        largePayloadUnloader = new PayloadUnloader("large-payload-unloader"){{
            requirements(Category.units, with(XenItems.cobalt, 150, XenItems.aluminum, 100,XenItems.graphite, 200,XenItems.silicon, 200));
            health = 2500;
            size = 7;
            maxBlockSize = 6;
            hasPower = true;
            consumePower(3f);
        }};

        smallPayloadDeconstructor = new PayloadDeconstructor("small-payload-deconstructor"){{
            requirements(Category.units, with(XenItems.aluminum, 100,XenItems.graphite, 1000));
            health = 900;
            size = 3;
            itemCapacity = 200;
            consumePower(2f);
            deconstructSpeed = 1.5f;
        }};
        largePayloadDeconstructor = new PayloadDeconstructor("large-payload-deconstructor"){{
            requirements(Category.units, with(XenItems.cobalt, 250, XenItems.aluminum, 200,XenItems.silicon, 150));
            health = 2500;
            size = 7;
            maxPayloadSize = 6;
            itemCapacity = 300;
            consumePower(3f);
            deconstructSpeed = 2.5f;
        }};
    }
}
