package fr.skyrethtm.sivanium;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinageCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) 
	{
		if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(alias.equalsIgnoreCase("minage"))
            {  
                if(Bukkit.getWorld("Minage") != null)
	            {
                     player.sendMessage("teleportation...");
	                 player.teleport(Bukkit.getWorld("Minage").getSpawnLocation());
	            }
	            else
	            {
	                 player.performCommand("m create");
	            }
            }
        }
		return false;
	}
}
