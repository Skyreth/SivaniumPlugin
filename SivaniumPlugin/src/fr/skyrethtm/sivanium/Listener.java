package fr.skyrethtm.sivanium;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class Listener implements org.bukkit.event.Listener
{
	static SkyUtils utils = new SkyUtils();
	//                     articles:     achat, vente, nom, id, meta
	private Article potato = new Article(2.0, 1.0, "potato", 392, (short) 0);
	private Article grape = new Article(8.0, 4.0, "grape", 5541, (short) 0);
	private Article winter = new Article(8.0, 4.0, "winter squash", 5537, (short) 0);
	private Article pumpkin = new Article(1.0, 0.5, "pumpkin", 86, (short) 0);
	private Article melon = new Article(1.0, 0.5, "melon", 360, (short) 0);
	private Article wheat = new Article(0.7, 0.4, "wheat", 296, (short) 0);
	private Article seed = new Article(0.4, 0.2, "seeds", 295, (short) 0);
	private Article carrote = new Article(2.0, 1.0, "Carrot", 391, (short) 0);
	private Article petrol = new Article(1000.0,  500.0, "Petrol", 6525, (short) 0);
	private Article casque1 = new Article(500.0, 0, "", 4256, (short) 0);
	private Article casque2 = new Article(500.0, 0, "", 4262, (short) 0);
	private Article casque3 = new Article(500.0, 0, "", 4272, (short) 0);
	private Article casque4 = new Article(500.0, 0, "", 4265, (short) 0);
	private Article casque5 = new Article(750.0, 0, "", 4268, (short) 0);
	private Article casque6 = new Article(700.0, 0, "", 4271, (short) 0);
	private Article vest6 = new Article(2500, 0, "", 4275, (short) 0);
	private Article gazdetector = new Article(500.0, 0, "Detecteur de Gaz", 4740, (short) 0);
	private Article chair = new Article(10.0, 0, "Chaise", 649, (short) 0);
	private Article weaponsrack = new Article(10.0, 0, "Presentoir Armes", 647, (short) 0);
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) 
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        
        if(inventory.getTitle().equals("§4Shop Categories"))
        {
        	if(clicked.getType() == Material.DIAMOND_HOE)
        	{
        		Inventory inv = Bukkit.createInventory(null, 54, "§aAgricultures"); 
        		
        		ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
        		ItemMeta name = air.getItemMeta();
    	    	name.setDisplayName("§f§kBonjo");
    	    	air.setItemMeta(name);
        		
        		utils.setItemToBuy(inv, 10, potato);
        		utils.setItemToBuy(inv, 11, carrote);
        		utils.setItemToBuy(inv, 12, seed);
        		utils.setItemToBuy(inv, 13, wheat);
        		utils.setItemToBuy(inv, 14, melon);
        		utils.setItemToBuy(inv, 15, pumpkin);
        		utils.setItemToBuy(inv, 16, grape);
        		utils.setItemToBuy(inv, 19, winter);
        		utils.setBackButton(inv);
        		utils.setBorder(inv, air, 54);
        		
        		player.openInventory(inv);
        	}
        	if(clicked.getType().getId() == 649)
        	{
        		Inventory inv = Bukkit.createInventory(null, 54, "§5Decorations"); 
        		
        		ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
        		ItemMeta name = air.getItemMeta();
    	    	name.setDisplayName("§f§kBonjo");
    	    	air.setItemMeta(name);
        		
        		utils.setItemToBuy(inv, 10, chair);
        		utils.setItemToBuy(inv, 11, weaponsrack);
        		utils.setBackButton(inv);
        		utils.setBorder(inv, air, 54);
        		
        		player.openInventory(inv);
        	}
        	if(clicked.getTypeId() == 4623)
        	{
        		Inventory inv = Bukkit.createInventory(null, 54, "§8Combat"); 
        		
        		ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        		ItemMeta name = air.getItemMeta();
    	    	name.setDisplayName("§f§kBonjo");
    	    	air.setItemMeta(name);
    	    	
    	    	utils.setItemToBuy(inv, 10, petrol);

        		utils.setBackButton(inv);
        		utils.setBorder(inv, air, 54);
        		
        		player.openInventory(inv);
        	}
        	if(clicked.getTypeId() == 4940)
        	{
        		Inventory inv = Bukkit.createInventory(null, 54, "§3Defense"); 
        		
        		ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
        		ItemMeta name = air.getItemMeta();
    	    	name.setDisplayName("§f§kBonjo");
    	    	air.setItemMeta(name);

    	    	utils.setItemToBuy(inv, 10, casque1);
        		utils.setItemToBuy(inv, 11, casque2);
        		utils.setItemToBuy(inv, 12, casque3);
        		utils.setItemToBuy(inv, 13, casque4);
        		utils.setItemToBuy(inv, 14, casque5);
        		utils.setItemToBuy(inv, 15, casque6);
        		utils.setItemToBuy(inv, 16, gazdetector);
        		utils.setItemToBuy(inv, 24, vest6);
    	    	
        		utils.setBackButton(inv);
        		utils.setBorder(inv, air, 54);
        		
        		player.openInventory(inv);
        	}
        	event.setCancelled(true);
        }
        if(inventory.getTitle().equals("§aAgricultures"))
        {
        	if(clicked.getTypeId() == grape.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", grape, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", grape, player);
        		}
        	}
        	if(clicked.getTypeId() == potato.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", potato, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", potato, player);
        		}
        	}
        	if(clicked.getTypeId() == winter.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", winter, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", winter, player);
        		}
        	}
        	if(clicked.getTypeId() == pumpkin.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", pumpkin, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", pumpkin, player);
        		}
        	}
        	if(clicked.getTypeId() == wheat.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", wheat, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", wheat, player);
        		}
        	}
        	if(clicked.getTypeId() == seed.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", seed, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", seed, player);
        		}
        	}
        	if(clicked.getTypeId() == carrote.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", carrote, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", carrote, player);
        		}
        	}
        	if(clicked.getTypeId() == melon.getId())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", melon, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", melon, player);
        		}
        	}
        	if(clicked.getTypeId() == 160 && clicked.hasItemMeta() && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§l§4BACK"))
            {
            	event.setCancelled(true);
            	player.getOpenInventory().close();
            	player.performCommand("shop");
            }
        	event.setCancelled(true);
        }
        if(inventory.getTitle().contains("vente"))
        {
        	int amount = event.getCurrentItem().getAmount();
        	
        	if(clicked.getTypeId() == potato.getId())
        	{
        		utils.sell(player, amount, potato);
        	}
        	if(clicked.getTypeId() == carrote.getId())
        	{
        		utils.sell(player, amount, carrote);
        	}
        	if(clicked.getTypeId() == grape.getId())
        	{
        		utils.sell(player, amount, grape);
        	}
        	if(clicked.getTypeId() == winter.getId())
        	{
        		utils.sell(player, amount, winter);
        	}
        	if(clicked.getTypeId() == wheat.getId())
        	{
        		utils.sell(player, amount, wheat);
        	}
        	if(clicked.getTypeId() == seed.getId())
        	{
        		utils.sell(player, amount, seed);
        	}
        	if(clicked.getTypeId() == melon.getId())
        	{
        		utils.sell(player, amount, melon);
        	}
        	if(clicked.getTypeId() == pumpkin.getId())
        	{
        		utils.sell(player, amount, pumpkin);
        	}
        	if(clicked.getTypeId() == petrol.getId())
        	{
        		utils.sell(player, amount, petrol);
        	}
        	if(clicked.hasItemMeta() && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§l§4BACK"))
            {
            	event.setCancelled(true);
            	player.getOpenInventory().close();
            	player.performCommand("shop");
            }
        	event.setCancelled(true);
        }
        if(inventory.getTitle().contains("achat"))
        {
        	int amount = event.getCurrentItem().getAmount();
        	
        	if(clicked.getTypeId() == carrote.getId())
        	{
        		utils.Buy(player, amount, carrote);
        	}
        	if(clicked.getTypeId() == petrol.getId())
        	{
        		utils.Buy(player, amount, petrol);
        	}
        	if(clicked.getTypeId() == wheat.getId())
        	{
        		utils.Buy(player, amount, wheat);
        	}
        	if(clicked.getTypeId() == seed.getId())
        	{
        		utils.Buy(player, amount, seed);
        	}
        	if(clicked.getTypeId() == potato.getId())
        	{
        		utils.Buy(player, amount, potato);
        	}
        	if(clicked.getTypeId() == grape.getId())
        	{
        		utils.Buy(player, amount, grape);
        	}
        	if(clicked.getTypeId() == winter.getId())
        	{
        		utils.Buy(player, amount, winter);
        	}
        	if(clicked.getTypeId() == melon.getId())
        	{
        		utils.Buy(player, amount, melon);
        	}
        	if(clicked.getTypeId() == pumpkin.getId())
        	{
        		utils.Buy(player, amount, pumpkin);
        	}
        	if(clicked.hasItemMeta() && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§l§4BACK"))
            {
            	player.getOpenInventory().close();
            	player.performCommand("shop");
            }
        	event.setCancelled(true);
        }
        if(inventory.getTitle().equals("§3Defense"))
        {
        	if(clicked.getTypeId() == casque1.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, casque1);
        		}
        	}
        	if(clicked.getTypeId() == casque2.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, casque2);
        		}
        	}
        	if(clicked.getTypeId() == casque3.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, casque3);
        		}
        	}
        	if(clicked.getTypeId() == casque4.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, casque4);
        		}
        	}
        	if(clicked.getTypeId() == casque5.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, casque5);
        		}
        	}
        	if(clicked.getTypeId() == casque6.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, casque6);
        		}
        	}
        	if(clicked.getTypeId() == gazdetector.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, gazdetector);
        		}
        	}
        	if(clicked.getTypeId() == vest6.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, vest6);
        		}
        	}
        	if(clicked.getTypeId() == 160 && clicked.hasItemMeta() && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§l§4BACK"))
            {
            	player.getOpenInventory().close();
            	player.performCommand("shop");
            }
        	event.setCancelled(true);
        }
        if(inventory.getTitle().equals("§8Combat"))
        {
        	if(clicked.getTypeId() == petrol.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.createGUI("achat", petrol, player);
        		}
        		else if(event.isRightClick())
        		{
        			utils.createGUI("vente", petrol, player);
        		}
        	}
        	if(clicked.getTypeId() == 160 && clicked.hasItemMeta() && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§l§4BACK"))
            {
            	player.getOpenInventory().close();
            	player.performCommand("shop");
            }
        	event.setCancelled(true);
        }
        if(inventory.getTitle().equals("§5Decorations"))
        {
        	if(clicked.getTypeId() == weaponsrack.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, weaponsrack);
        		}
        	}
        	if(clicked.getTypeId() == chair.getId() || event.isRightClick())
        	{
        		if(event.isLeftClick())
        		{
        			utils.Buy(player, 1, chair);
        		}
        	}
        	if(clicked.getTypeId() == 160 && clicked.hasItemMeta() && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§l§4BACK"))
            {
            	player.getOpenInventory().close();
            	player.performCommand("shop");
            }
        	event.setCancelled(true);
        }
    }
	
	@EventHandler
    public void onHit(EntityDamageEvent event)
	{
        if (event.getEntity() instanceof Player && event.getEntity().getWorld().getName().equalsIgnoreCase("Minage"))
        {
            event.setCancelled(true);
        }
    }
	
	@EventHandler
    public void SpawnEvent(CreatureSpawnEvent event)
	{
        if(event.getLocation().getWorld().getName().contentEquals("Minage"))
        {
            event.setCancelled(true);
        }
        if(!event.getLocation().getWorld().getName().contentEquals("Minage"))
        {
        	if(event.getEntityType() == EntityType.WITHER)
        	{
        		event.setCancelled(true);
        	}
        	if(event.getEntityType() == EntityType.ENDER_DRAGON)
        	{
        		event.setCancelled(true);
        	}
        }
    }
	
	@EventHandler
    public void FoodEvent(FoodLevelChangeEvent event)
	{
        if(event.getEntity().getLocation().getWorld().getName().contentEquals("Minage") && event.getEntityType() == EntityType.PLAYER)
        {
        	Player player = (Player) event.getEntity();
        	player.setFoodLevel(20);
            event.setCancelled(true);
        }
    }
	
	@EventHandler
    public void PlaceEvent(BlockPlaceEvent event)
	{
        if(event.getBlock().getType() == Material.TNT)
        {
            event.getBlock().getLocation().getWorld().spawnEntity(event.getBlock().getLocation().add(0, 0.5, 0), EntityType.PRIMED_TNT);
            event.getBlock().setType(Material.AIR);
        }
    }
	
	@EventHandler
    public void RightClickEvent(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) 
		{
	        if(event.getPlayer().getItemInHand().getTypeId() == 6526)
	        {
	        	Random r = new Random();
				int low = 4;
				int high = 120;
				int result = r.nextInt(high-low) + low;
	        	utils.removeItems(player.getInventory(), Material.getMaterial(52), 1);
	        	player.getInventory().addItem(new ItemStack(Material.getMaterial(52), 1, (short) result));
	        	player.updateInventory();
	        }
		}
    }
}
