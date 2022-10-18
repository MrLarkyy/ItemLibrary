package xyz.larkyy.itemlibrary.impl;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import xyz.larkyy.itemlibrary.CustomItem;

import java.util.List;
import java.util.Map;

public class HDBItem extends CustomItem {

    private final String identifier;

    public HDBItem(String identifier, String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        super(name, description, amount, modeldata,enchantments,flags);
        this.identifier = identifier;
    }

    @Override
    public ItemStack getUnmodifiedItem() {
        return new HeadDatabaseAPI().getItemHead(identifier);
    }
}
