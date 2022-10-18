package xyz.larkyy.itemlibrary.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import xyz.larkyy.itemlibrary.CustomItem;

import java.util.List;

public class VanillaItem extends CustomItem {

    private final Material material;

    public VanillaItem(Material material, String name, List<String> description, int amount, int modeldata) {
        super(name, description,amount,modeldata);
        this.material = material;
    }

    @Override
    public ItemStack getUnmodifiedItem() {
        return new ItemStack(material);
    }
}
