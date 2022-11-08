package prime;

import mindustry.mod.*;
import prime.content.*;

public class PrimeMod extends Mod{

    @Override
    public void loadContent(){
        PSItems.load();
        PSLiquids.load();
        PSWalls.load();
        PSEnvironment.load();
        PSUnitTypes.load();
    }

}
