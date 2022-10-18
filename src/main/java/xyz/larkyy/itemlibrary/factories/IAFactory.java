package xyz.larkyy.itemlibrary.factories;

import xyz.larkyy.itemlibrary.CustomItem;
import xyz.larkyy.itemlibrary.ItemFactory;
import xyz.larkyy.itemlibrary.impl.IAItem;

import java.util.List;

public class IAFactory implements ItemFactory {
    @Override
    public CustomItem create(String identifier, String name, List<String> description, int amount, int modeldata) {
        return new IAItem(identifier,name,description,amount,modeldata);
    }
}
