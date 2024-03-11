package xenacia.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.type.StatusEffect;

import static arc.math.Angles.randLenVectors;
import static mindustry.content.StatusEffects.*;

public class XenStatusEffects{
    public static StatusEffect magmaCoated;
    public static StatusEffect volatileEffect;
    /*public static StatusEffect none;
    public static StatusEffect burning;
    public static StatusEffect freezing;
    public static StatusEffect unmoving;
    public static StatusEffect slow;
    public static StatusEffect fast;
    public static StatusEffect wet;
    public static StatusEffect muddy;
    public static StatusEffect melting;
    public static StatusEffect sapped;
    public static StatusEffect tarred;
    public static StatusEffect overdrive;
    public static StatusEffect overclock;
    public static StatusEffect shielded;
    public static StatusEffect shocked;
    public static StatusEffect blasted;
    public static StatusEffect corroded;
    public static StatusEffect boss;
    public static StatusEffect sporeSlowed;
    public static StatusEffect disarmed;
    public static StatusEffect electrified;
    public static StatusEffect invincible;
    public static StatusEffect dynamic; */

    public static void load(){

        magmaCoated = new StatusEffect("magma-coated"){{
            color = Color.valueOf("db7448");
            speedMultiplier = 0.7f;
            healthMultiplier = 0.75f;
            damage = 0.7f;
            effect = Fx.melting;

            init(() -> {
                opposite(wet, freezing);
                affinity(tarred, (unit, result, time) -> {
                    unit.damagePierce(8f);
                    Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(magmaCoated, Math.min(time + result.time, 200f));
                });
            });
        }};

        volatileEffect = new StatusEffect("volatile"){{
            color = Color.valueOf("ffa166");
            effect = new Effect(42f, e -> {
                color = Color.valueOf("ffa166");

                randLenVectors(e.id, 2, 1f + e.fin() * 2f, (x, y) -> {
                    Fill.square(e.x + x, e.y + y, e.fout());
                });
            });

            init(() -> {
                opposite(wet);
                affinity(melting, (unit, result, time) -> result.set(melting, result.time + time));
                affinity(burning, (unit, result, time) -> result.set(burning, result.time + time));
                affinity(electrified, (unit, result, time) -> result.set(electrified, result.time + time));
                affinity(magmaCoated, (unit, result, time) -> {
                    unit.damagePierce(8f);
                    Fx.unitDespawn.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(none, Math.min(time + result.time, 200f));
                });
            });
        }};

        /*none = new StatusEffect("none");

        burning = new StatusEffect("burning"){{
            color = Color.valueOf("ffc455");
            damage = 0.167f;
            effect = Fx.burning;
            transitionDamage = 8f;

            init(() -> {
                opposite(wet, freezing);
                affinity(tarred, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                    Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(burning, Math.min(time + result.time, 300f));
                });
            });
        }};

        freezing = new StatusEffect("freezing"){{
            color = Color.valueOf("6ecdec");
            speedMultiplier = 0.6f;
            healthMultiplier = 0.8f;
            effect = Fx.freezing;
            transitionDamage = 18f;

            init(() -> {
                opposite(melting, burning);

                affinity(blasted, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                    if(unit.team == state.rules.waveTeam){
                        Events.fire(Trigger.blastFreeze);
                    }
                });
            });
        }};

        unmoving = new StatusEffect("unmoving"){{
            color = Pal.gray;
            speedMultiplier = 0f;
        }};

        slow = new StatusEffect("slow"){{
            color = Pal.lightishGray;
            speedMultiplier = 0.4f;

            init(() -> opposite(fast));
        }};

        fast = new StatusEffect("fast"){{
            color = Pal.boostTo;
            speedMultiplier = 1.6f;

            init(() -> opposite(slow));
        }};

        wet = new StatusEffect("wet"){{
            color = Color.royal;
            speedMultiplier = 0.94f;
            effect = Fx.wet;
            effectChance = 0.09f;
            transitionDamage = 14;

            init(() -> {
                affinity(shocked, (unit, result, time) -> {
                    unit.damage(transitionDamage);

                    if(unit.team == state.rules.waveTeam){
                        Events.fire(Trigger.shock);
                    }
                });
                opposite(burning, melting);
            });
        }};

        muddy = new StatusEffect("muddy"){{
            color = Color.valueOf("46382a");
            speedMultiplier = 0.94f;
            effect = Fx.muddy;
            effectChance = 0.09f;
            show = false;
        }};

        melting = new StatusEffect("melting"){{
            color = Color.valueOf("ffa166");
            speedMultiplier = 0.8f;
            healthMultiplier = 0.8f;
            damage = 0.3f;
            effect = Fx.melting;

            init(() -> {
                opposite(wet, freezing);
                affinity(tarred, (unit, result, time) -> {
                    unit.damagePierce(8f);
                    Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(melting, Math.min(time + result.time, 200f));
                });
            });
        }};

        sapped = new StatusEffect("sapped"){{
            color = Pal.sap;
            speedMultiplier = 0.7f;
            healthMultiplier = 0.8f;
            effect = Fx.sapped;
            effectChance = 0.1f;
        }};

        electrified = new StatusEffect("electrified"){{
            color = Pal.heal;
            speedMultiplier = 0.7f;
            reloadMultiplier = 0.6f;
            effect = Fx.electrified;
            effectChance = 0.1f;
        }};

        sporeSlowed = new StatusEffect("spore-slowed"){{
            color = Pal.spore;
            speedMultiplier = 0.8f;
            effect = Fx.sapped;
            effectChance = 0.04f;
        }};

        tarred = new StatusEffect("tarred"){{
            color = Color.valueOf("313131");
            speedMultiplier = 0.6f;
            effect = Fx.oily;

            init(() -> {
                affinity(melting, (unit, result, time) -> result.set(melting, result.time + time));
                affinity(burning, (unit, result, time) -> result.set(burning, result.time + time));
            });
        }};

        overdrive = new StatusEffect("overdrive"){{
            color = Pal.accent;
            healthMultiplier = 0.95f;
            speedMultiplier = 1.15f;
            damageMultiplier = 1.4f;
            damage = -0.01f;
            effect = Fx.overdriven;
            permanent = true;
        }};

        overclock = new StatusEffect("overclock"){{
            color = Pal.accent;
            speedMultiplier = 1.15f;
            damageMultiplier = 1.15f;
            reloadMultiplier = 1.25f;
            effectChance = 0.07f;
            effect = Fx.overclocked;
        }};

        shielded = new StatusEffect("shielded"){{
            color = Pal.accent;
            healthMultiplier = 3f;
        }};

        boss = new StatusEffect("boss"){{
            color = Team.crux.color;
            permanent = true;
            damageMultiplier = 1.3f;
            healthMultiplier = 1.5f;
        }};

        shocked = new StatusEffect("shocked"){{
            color = Pal.lancerLaser;
            reactive = true;
        }};

        blasted = new StatusEffect("blasted"){{
            color = Color.valueOf("ff795e");
            reactive = true;
        }};

        corroded = new StatusEffect("corroded"){{
            color = Pal.plastanium;
            damage = 0.1f;
        }};

        disarmed = new StatusEffect("disarmed"){{
            color = Color.valueOf("e9ead3");
            disarm = true;
        }};

        invincible = new StatusEffect("invincible"){{
            healthMultiplier = Float.POSITIVE_INFINITY;
        }}; */
    }
}