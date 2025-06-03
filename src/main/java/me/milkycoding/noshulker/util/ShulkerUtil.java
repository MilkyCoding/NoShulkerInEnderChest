package me.milkycoding.noshulker.util;

import org.bukkit.Material;

public class ShulkerUtil {

    /**
     * Проверяет, является ли материал шалкером
     * @param material материал для проверки
     * @return true если материал является шалкером
     */
    public static boolean isShulkerBox(Material material) {
        return material.name().contains("SHULKER_BOX");
    }

}
