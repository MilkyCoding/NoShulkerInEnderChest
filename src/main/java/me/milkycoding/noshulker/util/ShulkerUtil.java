package me.milkycoding.noshulker.util;

import org.bukkit.Material;

public class ShulkerUtil {

    public static boolean isShulkerBox(Material material) {
        return material.name().contains("SHULKER_BOX");
    }

}
