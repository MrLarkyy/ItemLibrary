package xyz.larkyy.itemlibrary.impl;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import xyz.larkyy.itemlibrary.CustomItem;

import java.util.List;
import java.util.Map;

public class VanillaItem extends CustomItem {

    private final Material material;

    public VanillaItem(Material material, String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        super(name, description,amount,modeldata,enchantments,flags);
        this.material = material;
    }

    @Override
    public ItemStack getUnmodifiedItem() {
        return new ItemStack(material);
    }
}
