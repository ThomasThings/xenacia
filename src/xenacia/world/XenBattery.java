package xenacia.world;

import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.struct.EnumSet;
import arc.struct.Seq;
import arc.util.Eachable;
import arc.util.Nullable;
import mindustry.annotations.Annotations.*;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Building;
import mindustry.world.blocks.power.PowerDistributor;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.BlockStatus;
import mindustry.world.meta.Env;

public class XenBattery extends PowerDistributor {
    public @Nullable DrawBlock drawer;

    public Color emptyLightColor = Color.valueOf("747a9d");
    public Color fullLightColor = Color.valueOf("c6cef0");

    @Deprecated
    public @Load("@-top") TextureRegion topRegion;

    public XenBattery(String name){
        super(name);
        outputsPower = true;
        consumesPower = true;
        canOverdrive = false;
        flags = EnumSet.of(BlockFlag.battery);
        //TODO could be supported everywhere...
        envEnabled |= Env.space;
        destructible = true;
        //batteries don't need to update
        update = false;
    }

    @Override
    public void init(){
        super.init();

        checkDrawDefault();
    }

    void checkDrawDefault(){
        if(drawer == null){
            drawer = new DrawMulti(new DrawDefault(), new DrawPower(){{
                emptyLightColor = XenBattery.this.emptyLightColor;
                fullLightColor = XenBattery.this.fullLightColor;
            }}, new DrawRegion("-top"));
        }
    }

    @Override
    public void load(){
        checkDrawDefault();

        super.load();
        drawer.load(this);
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        drawer.drawPlan(this, plan, list);
    }

    @Override
    public TextureRegion[] icons(){
        return drawer.finalIcons(this);
    }

    @Override
    public void getRegionsToOutline(Seq<TextureRegion> out){
        drawer.getRegionsToOutline(this, out);
    }

    public class XenBatteryBuild extends Building{
        @Override
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public void drawLight(){
            super.drawLight();
            drawer.drawLight(this);
        }

        @Override
        public float warmup(){
            return power.status;
        }

        @Override
        public void overwrote(Seq<Building> previous){
            for(Building other : previous){
                if(other.power != null && other.block.consPower != null && other.block.consPower.buffered){
                    float amount = other.block.consPower.capacity * other.power.status;
                    power.status = Mathf.clamp(power.status + amount / consPower.capacity);
                }
            }
        }

        @Override
        public BlockStatus status(){
            if(Mathf.equal(power.status, 0f, 0.001f)) return BlockStatus.noInput;
            if(Mathf.equal(power.status, 1f, 0.001f)) return BlockStatus.active;
            return BlockStatus.noOutput;
        }
    }
}