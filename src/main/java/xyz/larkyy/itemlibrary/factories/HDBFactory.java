package xyz.larkyy.itemlibrary.factories;

import xyz.larkyy.itemlibrary.CustomItem;
import xyz.larkyy.itemlibrary.ItemFactory;
import xyz.larkyy.itemlibrary.impl.HDBItem;

import java.util.List;

public class HDBFactory implements ItemFactory {
    @Override
    public CustomItem create(String identifier, String name, List<String> description, int amount, int modeldata) {
        return new HDBItem(identifier,name,description,amount,modeldata);
    }
}
