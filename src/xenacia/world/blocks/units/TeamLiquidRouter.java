package xenacia.world.blocks.units;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.gen.Building;
import mindustry.type.Liquid;
import mindustry.world.blocks.liquid.LiquidRouter;

public class TeamLiquidRouter extends LiquidRouter{
    public float liquidPadding = 0f;

    public TeamLiquidRouter(String name){
        super(name);
        solid = true;
        noUpdateDisabled = true;
        canOverdrive = false;
        floating = true;
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{bottomRegion, teamRegion, region};
    }

    public class TeamLiquidRouterBuild extends LiquidRouterBuild{
        @Override
        public void updateTile(){
            if(liquids.currentAmount() > 0.01f){
                dumpLiquid(liquids.current());
            }
        }

        @Override
        public void draw(){
            Draw.rect(bottomRegion, x, y);

            if(liquids.currentAmount() > 0.001f){
                drawTiledFrames(size, x, y, liquidPadding, liquids.current(), liquids.currentAmount() / liquidCapacity);
            }

            Draw.rect(region, x, y);

            if(teamRegion.found()){
                if(teamRegions[team.id] == teamRegion) Draw.color(team.color);
                Draw.rect(teamRegions[team.id], x, y);
                Draw.color();
            }
        }

        @Override
        public boolean acceptLiquid(Building source, Liquid liquid){
            return (liquids.current() == liquid || liquids.currentAmount() < 0.2f);
        }
    }
}
