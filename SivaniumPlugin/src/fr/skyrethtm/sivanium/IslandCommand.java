package fr.skyrethtm.sivanium;

import java.io.File;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("unused")
public class IslandCommand implements CommandExecutor
{
	private static IslandCommand instance;
	
	@SuppressWarnings("unused")
	private static World world;
	private Main main;
	
	public IslandCommand(Main plugin) 
	{
		this.main = plugin;
	}
   
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(alias.equalsIgnoreCase("m"))
            {
                if (args.length <= 0|| args == null)
                {
                    player.sendMessage("§f[§aSivanium World§f]: §4Syntaxe erroner !");
                    player.sendMessage("§f[§aSivanium World§f]: §4Veuillez effectuez /m [create, reset] !");
                }
                else
                {
                    if(args[0].equalsIgnoreCase("create"))
                    {  
                    	 if(Bukkit.getWorld("Minage") != null)
	                        {
                    		    player.sendMessage("teleportation...");
	                            player.teleport(Bukkit.getWorld("Minage").getSpawnLocation());
	                        }
	                        else
	                        {
	                        	player.sendMessage("§f[§aSivanium World§f]: §4Le Monde Minage n existe pas !");
	                            player.sendMessage("§f[§aSivanium World§f]: §2Monde Minage en cour de creation...");
	                            WorldCreator wc = new WorldCreator("Minage");
	                            wc.createWorld();
	                            player.sendMessage("§f[§aSivanium World§f]: §2Monde Minage cree !");
	                            player.sendMessage("teleportation...");
	                            player.teleport(Bukkit.getWorld("Minage").getSpawnLocation());
	                        }
                    }
                    if(args[0].equalsIgnoreCase("reset") && player.isOp() == true)
                    {  
                    	World delete = Bukkit.getWorld("Minage");
                    	File deleteFolder = delete.getWorldFolder();
                    	deleteWorld(deleteFolder);
                    	player.sendMessage("&4Minage supprimer");
                    	WorldCreator wc = new WorldCreator("Minage");
                        wc.createWorld();
                        player.sendMessage("§f[§aSivanium World§f]: §2Monde Minage reset !");
                    }
                    else
                    {
                    	player.sendMessage("§4Vous ne possedez pas la permission !");
                    }
                }
            }
        }
        return false;
    }
    
    public void unloadWorld(World world)
    {
        world = Bukkit.getWorld("Minage");
        if(!world.equals(null)) 
        {
            Bukkit.getServer().unloadWorld(world, true);
        }
    }
   
    public boolean deleteWorld(File path)
    {
          if(path.exists())
          {
              File files[] = path.listFiles();
              for(int i=0; i<files.length; i++)
              {
                  if(files[i].isDirectory())
                  {
                      deleteWorld(files[i]);
                  } else {
                      files[i].delete();
                  }
              }
          }
          return(path.delete());
    }
    
   
    public static IslandCommand getInstance()
    {
        return instance;
    }
}
