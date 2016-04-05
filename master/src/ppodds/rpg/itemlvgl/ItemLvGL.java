package ppodds.rpg.itemlvgl;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import ppodds.rpg.itemlvgl.command.ILG;
import ppodds.rpg.itemlvgl.event.EntityDamageByEntity;

public class ItemLvGL extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getCommand("ILG").setExecutor(new ILG(this));
		getServer().getPluginManager().registerEvents(new EntityDamageByEntity(this), this);
		File f = new File(this.getDataFolder().toString());
		if (!f.exists())
		{
			f.mkdirs();
		}
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
