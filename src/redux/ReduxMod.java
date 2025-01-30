package redux;

import mindustry.mod.*;
import redux.content.*;

public class ReduxMod extends Mod{

    @Override

    public void loadContent(){
        ReduxItems.load();
        ReduxEnvironmentTiles.load();
    }

}
