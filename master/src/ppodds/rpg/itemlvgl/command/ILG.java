package ppodds.rpg.itemlvgl.command;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import ppodds.rpg.itemlvgl.ItemLvGL;

public class ILG implements CommandExecutor
{
	private ItemLvGL lvl;
	
	public ILG (ItemLvGL lvl)
	{
		this.lvl = lvl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (lable.equalsIgnoreCase("ILG") && sender instanceof Player && sender.hasPermission("ILG.admin.ALL"))
		{
			Player p = (Player) sender;
			if (args.length == 0 || args.length > 2)
			{
				p.sendMessage(ChatColor.RED + "ノ猭: /ILG <set/remove> <单计 removeぃノ>");
			}
			else
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("remove"))
				{
					try
					{
						String DisplayName = p.getItemInHand().getItemMeta().getDisplayName();
						File data = new File(lvl.getDataFolder() + File.separator + DisplayName + ".yml");
						data.delete();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			else
			{
				if (args[0].equalsIgnoreCase("set"))
				{
					try
					{
						int number = Integer.parseInt(args[1]);
						String DisplayName = p.getItemInHand().getItemMeta().getDisplayName();
						File data = new File(lvl.getDataFolder() + File.separator + DisplayName + ".yml");
						data.createNewFile();
						YamlConfiguration y = YamlConfiguration.loadConfiguration(data);
						y.set("level", number);
						y.save(data);
					}
					catch (Exception e)
					{
						p.sendMessage(ChatColor.RED + "单计ゲ斗璶琌俱计ぃもㄏノ");
					}
				}
			}
		}
		return false;
	}
	
}
