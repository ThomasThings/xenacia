package xenacia;

import mindustry.mod.*;
import xenacia.content.*;

public class XenaciaMod extends Mod{

    @Override

    public void loadContent(){
        XenItems.load();
        XenLiquids.load();
        XenEnvironmentTiles.load();
        XenUnitTypes.load();
        XenCores.load();
        XenUnitBlocks.load();
        XenPowerBlocks.load();
        XenFactoryBlocks.load();
    }

}
