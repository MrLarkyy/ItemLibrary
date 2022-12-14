package xyz.larkyy.itemlibrary.factories;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import xyz.larkyy.itemlibrary.CustomItem;
import xyz.larkyy.itemlibrary.ItemFactory;
import xyz.larkyy.itemlibrary.impl.MMOItem;

import java.util.List;
import java.util.Map;

public class MMOFactory implements ItemFactory {
    @Override
    public CustomItem create(String identifier, String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        String[] strs = identifier.split(":");
        return new MMOItem(strs[0],strs[1],name,description,amount,modeldata,enchantments,flags);
    }
}
