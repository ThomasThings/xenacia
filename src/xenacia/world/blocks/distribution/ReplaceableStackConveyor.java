package xenacia.world.blocks.distribution;

import arc.func.Boolf;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.struct.Seq;
import arc.util.Nullable;
import mindustry.content.Blocks;
import mindustry.entities.TargetPriority;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Sounds;
import mindustry.input.Placement;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.StackConveyor;

import mindustry.world.meta.BlockGroup;

public class ReplaceableStackConveyor extends StackConveyor {

    public @Nullable Block junctionReplacement, bridgeReplacement;

    public ReplaceableStackConveyor(String name){
        super(name);

        rotate = true;
        update = true;
        group = BlockGroup.transportation;
        hasItems = true;
        itemCapacity = 10;
        conveyorPlacement = true;
        underBullets = true;
        priority = TargetPriority.transport;

        ambientSound = Sounds.conveyor;
        ambientSoundVolume = 0.004f;
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
    public class ReplaceableStackConveyorBuild extends StackConveyorBuild {
    }
}
