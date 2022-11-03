package prime;

import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.type.*;
import prime.content.*;

public class PrimeMod extends Mod{

    @Override
    public void loadContent(){
        PSItems.load();
        PSLiquids.load();
    }

}
