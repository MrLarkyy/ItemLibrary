package xyz.larkyy.itemlibrary.impl;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.inventory.ItemStack;
import xyz.larkyy.itemlibrary.CustomItem;

import java.util.List;

public class HDBItem extends CustomItem {

    private final String identifier;

    public HDBItem(String identifier, String name, List<String> description, int amount, int modeldata) {
        super(name, description, amount, modeldata);
        this.identifier = identifier;
    }

    @Override
    public ItemStack getUnmodifiedItem() {
        return new HeadDatabaseAPI().getItemHead(identifier);
    }
}
