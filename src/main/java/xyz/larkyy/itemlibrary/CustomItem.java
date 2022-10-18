package xyz.larkyy.itemlibrary;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.larkyy.colorutils.Colors;
import xyz.larkyy.itemlibrary.impl.*;

import java.util.List;

public abstract class CustomItem {

    private static CustomItemHandler customItemHandler;

    private final String name;
    private final List<String> description;
    private final int amount;
    private final int modeldata;

    public CustomItem(String name, List<String> description, int amount, int modeldata) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.modeldata = modeldata;
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

        is.setItemMeta(im);
        is.setAmount(amount);
        return is;
    }

    public abstract ItemStack getUnmodifiedItem();

    public static CustomItem create(String namespace, String name, List<String> description,int amount, int modeldata) {
        if (customItemHandler == null) {
            customItemHandler = new CustomItemHandler();
        }

        return customItemHandler.getCustomItem(namespace,name,description,amount,modeldata);
    }

    public static CustomItemHandler getCustomItemHandler() {
        if (customItemHandler == null) {
            customItemHandler = new CustomItemHandler();
        }
        return customItemHandler;
    }
}
