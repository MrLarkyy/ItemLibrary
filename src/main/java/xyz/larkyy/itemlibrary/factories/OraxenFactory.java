package xyz.larkyy.itemlibrary.factories;

import xyz.larkyy.itemlibrary.CustomItem;
import xyz.larkyy.itemlibrary.ItemFactory;
import xyz.larkyy.itemlibrary.impl.OraxenItem;

import java.util.List;

public class OraxenFactory implements ItemFactory {
    @Override
    public CustomItem create(String identifier, String name, List<String> description, int amount, int modeldata) {
        return new OraxenItem(identifier,name,description,amount,modeldata);
    }
}
