package prime.world.blocks.units;

import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.entities.units.*;
import mindustry.world.blocks.units.UnitFactory;

public class BaseTeamUnitFactory extends UnitFactory{
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, teamRegion, outRegion, topRegion};
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        Draw.rect(region, plan.drawx(), plan.drawy());
        Draw.rect(teamRegion, plan.drawx(), plan.drawy());
        Draw.rect(outRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
        Draw.rect(topRegion, plan.drawx(), plan.drawy());
    }

    public BaseTeamUnitFactory(String name){
        super(name);
    }
}
