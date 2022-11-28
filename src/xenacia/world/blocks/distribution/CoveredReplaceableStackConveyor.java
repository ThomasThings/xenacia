/*package xenacia.world.blocks.distribution;

import arc.Core;
import arc.func.Boolf;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.input.Placement;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.distribution.Conveyor.*;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class CoveredReplaceableStackConveyor extends Block implements Autotiler{
    public TextureRegion bottomRegion, stackRegion, topRegion;


    public float baseEfficiency = 0f;
    public float speed = 0f;
    public boolean outputRouter = true;


    public @Nullable Block junctionReplacement, bridgeReplacement;

    @Override
    public void load() {
        super.load();
        for (int i = 0; i < 5; i++) {
            bottomRegion[i] = Core.atlas.find("@-bottom" + "-" + i);
        }

        stackRegion = Core.atlas.find("@-stack");

        for (int i = 0; i < 5; i++) {
            topRegion[i] = Core.atlas.find("@-top" + "-" + i);
        }

    }

    public CoveredReplaceableStackConveyor(String name){
        super(name);

        group = BlockGroup.transportation;
        update = true;
        solid = false;
        hasItems = true;
        conveyorPlacement = true;
        unloadable = false;
        itemCapacity = 10;
        noUpdateDisabled = true;
        underBullets = true;
        rotate = true;
        noSideBlend = true;
        priority = TargetPriority.transport;
        envEnabled = Env.space | Env.terrestrial | Env.underwater;

        ambientSound = Sounds.conveyor;
        ambientSoundVolume = 0.004f;
    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.itemsMoved, Mathf.round(itemCapacity * speed * 60), StatUnit.itemsSecond);
    }

    @Override
    public void init(){
        super.init();

        if(junctionReplacement == null) junctionReplacement = Blocks.junction;
        if(bridgeReplacement == null || !(bridgeReplacement instanceof ItemBridge)) bridgeReplacement = Blocks.itemBridge;
    }
    @Override
    public Block getReplacement(BuildPlan req, Seq<BuildPlan> plans){
        if(junctionReplacement == null) return this;

        Boolf<Point2> cont = p -> plans.contains(o -> o.x == req.x + p.x && o.y == req.y + p.y && (req.block instanceof ReplaceableStackConveyor || req.block instanceof Junction));
        return cont.get(Geometry.d4(req.rotation)) &&
                cont.get(Geometry.d4(req.rotation - 2)) &&
                req.tile() != null &&
                req.tile().block() instanceof ReplaceableStackConveyor &&
                Mathf.mod(req.tile().build.rotation - req.rotation, 2) == 1 ? junctionReplacement : this;
    }
    @Override
    public void handlePlacementLine(Seq<BuildPlan> plans){
        if(bridgeReplacement == null) return;

        Placement.calculateBridges(plans, (ItemBridge)bridgeReplacement);
    }

    public class CoveredReplaceableStackConveyorBuild extends Building{

    }
} */