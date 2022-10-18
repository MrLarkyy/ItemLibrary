package xyz.larkyy.itemlibrary;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.larkyy.colorutils.Colors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CustomItem {

    private static CustomItemHandler customItemHandler;

    private final String name;
    private final List<String> description;
    private final int amount;
    private final int modeldata;
    private final Map<Enchantment,Integer> enchantments;
    private final List<ItemFlag> flags;

    public CustomItem(String name, List<String> description, int amount, int modeldata, Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.modeldata = modeldata;
        this.enchantments = enchantments;
        this.flags = flags;
    }

    public void giveItem(Player player) {
        giveItem(player,amount);
    }

    public void giveItem(Player player, int amount) {
        ItemStack is = getItem();
        is.setAmount(amount);

        player.getInventory().addItem(is);
    }

    public ItemStack getItem() {
        ItemStack is = getUnmodifiedItem();
        ItemMeta im = is.getItemMeta();

        if (im == null) {
            return is;
        }

        if (name != null) {
            im.setDisplayName(Colors.format(name));
        }

        if (description != null) {
            im.setLore(Colors.format(description));
        }

        if (modeldata > 0) {
            im.setCustomModelData(modeldata);
        }

        flags.forEach(im::addItemFlags);


        if (is.getType() == Material.ENCHANTED_BOOK) {
            EnchantmentStorageMeta esm = (EnchantmentStorageMeta) im;
            enchantments.forEach((enchantment, integer) -> {
                esm.addStoredEnchant(enchantment,integer,true);
            });
            is.setItemMeta(esm);
        } else {
            is.setItemMeta(im);
            is.addUnsafeEnchantments(enchantments);
        }

        is.setAmount(amount);
        return is;
    }

    public abstract ItemStack getUnmodifiedItem();

    public static CustomItem create(String namespace, String name, List<String> description,int amount, int modeldata,Map<Enchantment,Integer> enchantments, List<ItemFlag> flags) {
        if (customItemHandler == null) {
            customItemHandler = new CustomItemHandler();
        }

        return customItemHandler.getCustomItem(namespace,name,description,amount,modeldata,enchantments,flags);
    }

    public static CustomItem loadFromYaml(FileConfiguration cfg, String path) {
        if (!cfg.contains(path)) {
            return null;
        }

        List<String> lore = null;
        if (cfg.contains(path+".lore")) {
            lore = cfg.getStringList(path+".lore");
        }

        Map<Enchantment,Integer> enchantments = new HashMap<>();
        if (cfg.contains(path+".enchants")) {
            for (String str : cfg.getStringList(path+".enchants")) {
                String[] strs = str.split(":");
                if (strs.length < 2) {
                    continue;
                }
                Enchantment enchantment = getEnchantmentByString(strs[0]);
                int level = Integer.parseInt(strs[1]);
                enchantments.put(enchantment,level);
            }
        }

        List<ItemFlag> flags = new ArrayList<>();
        if (cfg.contains(path+".flags")) {
            for (String flag : cfg.getStringList(path+".flags")) {
                ItemFlag itemFlag = ItemFlag.valueOf(flag.toUpperCase());
                flags.add(itemFlag);
            }
        }

        return CustomItem.create(
                cfg.getString(path+".material","STONE"),
                cfg.getString(path+".display-name"),
                lore,
                cfg.getInt(path+".amount",1),
                cfg.getInt(path+".model-data"),
                enchantments,
                flags
        );
    }

    private static Enchantment getEnchantmentByString(String ench) {
        return Enchantment.getByKey(NamespacedKey.minecraft(ench.toLowerCase()));
    }

    public static CustomItemHandler getCustomItemHandler() {
        if (customItemHandler == null) {
            customItemHandler = new CustomItemHandler();
        }
        return customItemHandler;
    }
}
