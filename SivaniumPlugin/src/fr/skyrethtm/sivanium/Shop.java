package fr.skyrethtm.sivanium;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class Shop implements CommandExecutor 
{
	static SkyUtils utils = new SkyUtils();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)  
	{
		if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(alias.equalsIgnoreCase("shop"))
            {  
	            Inventory inv = Bukkit.createInventory(null, 27, "§4Shop Categories"); 
	            	
	            utils.addCustomItem(inv, 11, 293, "Shop Agriculture", "§aAgricultures", 0);
	            utils.addCustomItem(inv, 13, 4940, "Shop Defense", "§3Defense", 0);
	            utils.addCustomItem(inv, 15, 4623, "Shop Combat", "§8Combat", 0);
	            utils.addCustomItem(inv, 26, 649, "Shop Decoratif", "§5Decorations", 0);
	            utils.fullInventory(inv, (short) 1);
	            	
	            player.openInventory(inv);
            }
        }
		return false;
	}

}
