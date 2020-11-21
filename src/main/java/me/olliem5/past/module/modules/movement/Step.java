package me.olliem5.past.module.modules.movement;

import me.olliem5.past.Past;
import me.olliem5.past.module.Category;
import me.olliem5.past.module.Module;
import me.olliem5.past.settings.Setting;
import me.olliem5.past.util.colour.ColourUtil;

public class Step extends Module {
    public Step() {
        super("Step", "Allows you to step up blocks", Category.MOVEMENT);
    }

    Setting height;

    @Override
    public void setup() {
        Past.settingsManager.registerSetting(height = new Setting("Height", "StepHeight", 1, 1, 10, this));
    }

    public void onUpdate() {
        if (nullCheck()) return;

        if (mc.player.onGround && !mc.player.isInWater() && !mc.player.isInLava() && !mc.player.isOnLadder()) {
            if (mc.player.collidedHorizontally) {
                mc.player.stepHeight = height.getValueInt();
                mc.player.jump();
            }
        }
    }

    @Override
    public void onDisable() {
        mc.player.stepHeight = 0.5f;
    }

    public String getArraylistInfo() {
        return ColourUtil.gray + " " + height.getValueInt();
    }
}
