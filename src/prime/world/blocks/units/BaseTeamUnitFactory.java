package prime.world.blocks.units;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Eachable;
import mindustry.entities.units.BuildPlan;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.units.UnitFactory.UnitFactoryBuild;

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
    public class BaseTeamUnitFactoryBuild extends UnitFactoryBuild{
        @Override

        public void draw(){
            Draw.rect(region, x, y);
            Draw.rect(teamRegion, x, y);
            Draw.rect(outRegion, x, y, rotdeg());
            Draw.rect(topRegion, x, y);
        }
    }
}
