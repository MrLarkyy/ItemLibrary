package xyz.larkyy.itemlibrary;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import xyz.larkyy.itemlibrary.factories.HDBFactory;
import xyz.larkyy.itemlibrary.factories.IAFactory;
import xyz.larkyy.itemlibrary.factories.MMFactory;
import xyz.larkyy.itemlibrary.factories.OraxenFactory;
import xyz.larkyy.itemlibrary.impl.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItemHandler {

    private final Map<String,ItemFactory> itemRegisters;

    public CustomItemHandler() {
        itemRegisters = new HashMap<>();
        itemRegisters.put("itemsadder", new IAFactory());
        itemRegisters.put("oraxen", new OraxenFactory());
        itemRegisters.put("hdb", new HDBFactory());
        itemRegisters.put("mythicitem", new MMFactory());
    }

    public void addItemFactory(String id, ItemFactory factory) {
        itemRegisters.put(id,factory);
    }

    public CustomItem getCustomItem(String namespace, String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        String[] strs = namespace.split(":");
        String provider = strs[0].toLowerCase();

        ItemFactory factory = itemRegisters.get(provider);
        if (strs.length == 1 || factory == null) {
            return new VanillaItem(Material.valueOf(strs[0].toUpperCase()),name,description,amount,modeldata,enchantments,flags);
        }
        String identifier = namespace.substring(provider.length()+1);

        return factory.create(identifier,name,description,amount,modeldata,enchantments,flags);
    }
}
