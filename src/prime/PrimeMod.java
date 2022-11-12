package prime;

import mindustry.mod.*;
import prime.content.*;
import prime.world.blocks.units.BaseTeamUnitFactory;

public class PrimeMod extends Mod{

    @Override
    public void loadContent(){
        PSItems.load();
        PSLiquids.load();
        PSWalls.load();
        PSEnvironment.load();
        PSUnitTypes.load();
        BaseTeamUnitFactory.load();
        PSUnitFactories.load();
    }

}
