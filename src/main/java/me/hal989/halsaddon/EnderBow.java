package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SlimefunBow;
import me.mrCookieSlime.Slimefun.Objects.handlers.BowShootHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public class EnderBow extends SlimefunBow {
    public EnderBow(SlimefunItemStack item, ItemStack[] recipe) {
        super(item, recipe);
    }
    @Override
    public BowShootHandler onShoot() {
        return (e, n) -> {
            Projectile firedArrow = (Projectile) e.getDamager();
            Player p = (Player) firedArrow.getShooter();
            Location enemyPos = n.getLocation().clone();
            Location playerPos = p.getLocation().clone();
        n.teleport(playerPos);
        p.teleport(enemyPos);
        n.getWorld().playSound(n.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        };
    }
}
