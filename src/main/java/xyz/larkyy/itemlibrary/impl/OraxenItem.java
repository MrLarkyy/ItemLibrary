package xyz.larkyy.itemlibrary.impl;

import io.th0rgal.oraxen.items.OraxenItems;
import org.bukkit.inventory.ItemStack;
import xyz.larkyy.itemlibrary.CustomItem;

import java.util.List;

public class OraxenItem extends CustomItem {

    private final String identifier;

    public OraxenItem(String identifier,String name, List<String> description, int amount, int modeldata) {
        super(name, description,amount,modeldata);
        this.identifier = identifier;
    }

    @Override
    public ItemStack getUnmodifiedItem() {
        return OraxenItems.getItemById(identifier).build();
    }
}
