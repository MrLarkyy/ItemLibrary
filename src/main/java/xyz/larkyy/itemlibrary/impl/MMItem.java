package xyz.larkyy.itemlibrary.impl;

import io.lumine.mythic.api.MythicProvider;
import io.lumine.mythic.bukkit.adapters.BukkitItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import xyz.larkyy.itemlibrary.CustomItem;

import java.util.List;
import java.util.Map;

public class MMItem extends CustomItem {

    private final String identifier;

    public MMItem(String identifier, String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        super(name, description, amount, modeldata,enchantments,flags);
        this.identifier = identifier;
    }

    @Override
    public ItemStack getUnmodifiedItem() {
        return ((BukkitItemStack) MythicProvider.get().getItemManager().getItem(identifier).get().generateItemStack(1)).build();
    }
}
