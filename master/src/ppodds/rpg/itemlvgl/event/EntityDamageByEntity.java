package ppodds.rpg.itemlvgl.event;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ppodds.rpg.itemlvgl.ItemLvGL;

public class EntityDamageByEntity implements Listener
{
	private ItemLvGL lvl;
	
	public EntityDamageByEntity (ItemLvGL lvl)
	{
		this.lvl = lvl;
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
	{
		if (e.getDamager() instanceof Player)
		{
			Player p = (Player) e.getDamager();
			String DisplayName = p.getItemInHand().getItemMeta().getDisplayName();
			File f = new File(lvl.getDataFolder() + File.separator + DisplayName + ".yml");
			if (f.exists())
			{
				YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
				int number = (int) y.get("level");
				if (p.getLevel() < number)
				{
					e.setCancelled(true);
				}
			}
		}
	}
}
