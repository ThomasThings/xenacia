package xenacia;

import mindustry.mod.*;
import xenacia.content.*;

public class XenaciaMod extends Mod{

    @Override

    public void loadContent(){
        XenItems.load();
        XenLiquids.load();
        XenWalls.load();
        XenEnvironmentTiles.load();
        XenUnitTypes.load();
        XenUnitFactories.load();
        XenPayloadBlocks.load();
        XenFluidBlocks.load();
        XenDrills.load();
        XenDistribution.load();
        XenCores.load();
        XenStorage.load();
        XenTurrets.load();
    }

}
