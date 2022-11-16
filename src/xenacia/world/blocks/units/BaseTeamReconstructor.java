package xenacia.world.blocks.units;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Eachable;
import mindustry.entities.units.BuildPlan;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.world.blocks.units.Reconstructor;

public class BaseTeamReconstructor extends Reconstructor{
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, teamRegion, inRegion, outRegion, topRegion};
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        Draw.rect(region, plan.drawx(), plan.drawy());
        Draw.rect(teamRegion, plan.drawx(), plan.drawy());
        Draw.rect(inRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
        Draw.rect(outRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
        Draw.rect(topRegion, plan.drawx(), plan.drawy());
    }

    public BaseTeamReconstructor(String name){
        super(name);
    }
    public class BaseTeamReconstructorBuild extends ReconstructorBuild {
        @Override

        public void draw(){
            Draw.rect(region, x, y);

            Draw.z(Layer.blockOver - 0.2f);

            if(teamRegion.found()){
                if(teamRegions[team.id] == teamRegion) Draw.color(team.color);
                Draw.rect(teamRegions[team.id], x, y);
                Draw.color();
            }

            Draw.z(Layer.blockOver - 0.1f);

            Draw.rect(inRegion, x, y, rotdeg());
            Draw.rect(outRegion, x, y, rotdeg());

            if(constructing() && hasArrived()){
                Draw.draw(Layer.blockOver, () -> {
                    Draw.alpha(1f - progress/ constructTime);
                    Draw.rect(payload.unit.type.fullIcon, x, y, payload.rotation() - 90);
                    Draw.reset();
                    Drawf.construct(this, upgrade(payload.unit.type), payload.rotation() - 90f, progress / constructTime, speedScl, time);
                });
            }else{
                Draw.z(Layer.blockOver);

                drawPayload();
            }

            Draw.z(Layer.blockOver);

            payRotation = rotdeg();
            drawPayload();

            Draw.z(Layer.blockOver + 0.1f);

            Draw.rect(topRegion, x, y);
        }
    }
}
