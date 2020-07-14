package fr.skyrethtm.sivanium;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin
{
	private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
	private static Main instance;
	private static Plugin plugin;
    FileConfiguration config = getConfig();

	@Override
    public void onEnable() 
    {
		getServer().getPluginManager().registerEvents(new Listener(), this);
		System.out.println("Events enregistrer");
		 if (!setupEconomy() ) {
	            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
	            getServer().getPluginManager().disablePlugin(this);
	            return;
	        }
	        setupPermissions();
	        setupChat();
	        
        getCommand("m").setExecutor(new IslandCommand(this));
        getCommand("minage").setExecutor(new MinageCommand());
        getCommand("shop").setExecutor(new Shop());
        plugin = this;
    }
	
	@Override
	public void onDisable() 
	{
		log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
		System.out.println("[Sivanium Plugin]: disable !");
	}
	
	public static Main getInstance() 
	{ 
		return instance; 
	}
	
	public static Plugin getPlugin() 
	{
	    return plugin;
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    
    public static Economy getEconomy() {
        return econ;
    }
    
    public static Permission getPermissions() {
        return perms;
    }
    
    public static Chat getChat() {
        return chat;
    }
}
