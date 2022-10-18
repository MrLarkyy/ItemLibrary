package xyz.larkyy.itemlibrary.factories;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import xyz.larkyy.itemlibrary.CustomItem;
import xyz.larkyy.itemlibrary.ItemFactory;
import xyz.larkyy.itemlibrary.impl.MMItem;

import java.util.List;
import java.util.Map;

public class MMFactory implements ItemFactory {
    @Override
    public CustomItem create(String identifier, String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        return new MMItem(identifier,name,description,amount,modeldata,enchantments,flags);
    }
}
