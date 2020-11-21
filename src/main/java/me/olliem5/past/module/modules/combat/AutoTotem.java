package me.olliem5.past.module.modules.combat;

import me.olliem5.past.module.Category;
import me.olliem5.past.module.Module;
import me.olliem5.past.util.colour.ColourUtil;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AutoTotem extends Module {
    public AutoTotem() {
        super("AutoTotem", "Automatically puts a totem in your offhand", Category.COMBAT);
    }

    public int totems;

    @Override
    public void onUpdate() {
        if (nullCheck()) {
            return;
        }

        totems = mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.TOTEM_OF_UNDYING).mapToInt(ItemStack::getCount).sum();

        if (mc.player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND).getItem() == Items.TOTEM_OF_UNDYING) {
            return;
        }

        final int slot = this.getItemSlot();

        if (slot != -1) {
            mc.playerController.windowClick(mc.player.inventoryContainer.windowId, slot, 0, ClickType.PICKUP, mc.player);
            mc.playerController.windowClick(mc.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, mc.player);
            mc.playerController.windowClick(mc.player.inventoryContainer.windowId, slot, 0, ClickType.PICKUP, mc.player);
            mc.playerController.updateController();
        }
    }

    private int getItemSlot() {
        for (int i = 0; i < 36; i++) {
            final Item item = mc.player.inventory.getStackInSlot(i).getItem();
            if (item == Items.TOTEM_OF_UNDYING) {
                if (i < 9) {
                    i += 36;
                }
                return i;
            }
        }
        return -1;
    }

    private int getTotemCount() {
        Item item = mc.player.getHeldItemOffhand().getItem();
        if (item == Items.TOTEM_OF_UNDYING) {
            return totems + 1;
        } else {
            return totems;
        }
    }

    public String getArraylistInfo() {
        return ColourUtil.gray + " " + getTotemCount();
    }
}
