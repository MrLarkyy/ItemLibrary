package xyz.larkyy.itemlibrary;

import java.util.List;

public interface ItemFactory {

    CustomItem create(String identifier, String name, List<String> description, int amount, int modeldata);

}
