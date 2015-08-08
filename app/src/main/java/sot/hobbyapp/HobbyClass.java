package sot.hobbyapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 8/08/15.
 */
public class HobbyClass {
    private String name;
    private HobbyObject[] items;

    public List<HobbyObject> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<HobbyObject> subCategories) {
        this.subCategories = subCategories;
    }

    private List<HobbyObject> subCategories = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
