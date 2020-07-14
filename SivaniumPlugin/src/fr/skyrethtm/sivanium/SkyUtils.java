package fr.skyrethtm.sivanium;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class SkyUtils 
{
	private static SkyUtils instance;
	
	public void clearInventory(Player player)
    {
        player.getInventory().clear();
        player.getInventory().setBoots(new ItemStack(Material.AIR));
        player.getInventory().setLeggings(new ItemStack(Material.AIR));
        player.getInventory().setChestplate(new ItemStack(Material.AIR));
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
        player.updateInventory();
    }
	
	public boolean isCustomItem(Material material, ItemStack item, String name)
   	{
    	ItemMeta meta = item.getItemMeta();
    	
    	if(item.getType() == material && item.hasItemMeta() && meta.getDisplayName().equals(name))
    	{
    		return true;
    	}
		return false;
   	}
	
	public void addCustomItem(Inventory inv, int SlotId, int id, String string, String name, int amount)
	{
		ItemStack stack = new ItemStack(id, amount);
			
		ItemMeta meta = stack.getItemMeta();
		if(meta.hasLore() == true)
		meta.getLore().clear();
		
		meta.setLore(Arrays.asList(string));
		meta.setDisplayName(name);
		stack.setItemMeta(meta);
		inv.setItem(SlotId, stack);
	}
	
	public void setItemToBuy(Inventory inv, int slotid, Article art)
	{
		ItemStack stack = new ItemStack(art.getId());
		ItemMeta meta = stack.getItemMeta();
		meta.setLore(Arrays.asList("Achat: "+art.getBuyPrice()+"$", "Vente: "+art.getSellPrice()+"$"));
		stack.setItemMeta(meta);
		inv.setItem(slotid, stack);
	}
	
	public void fullInventory(Inventory inv, short meta)
	{
		for(int i=0;i<inv.getSize();i++)
    	{
    		if(inv.getItem(i) == null)
    		{
    			ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE, 1, meta);
    	    	ItemMeta name = air.getItemMeta();
    	    	name.setDisplayName("§f§kBonjo");
    	    	air.setItemMeta(name);
    				
    			inv.setItem(i, air);
    		}
    	}
	}
	
	public boolean Buy(Player player, int quantity, Article art)
	{
		int Id = art.getId();
		double amount = art.getBuyPrice();
		short meta = (short) art.getMeta();
		if(Main.getEconomy().hasAccount(player.getName()) && this.hasAvaliableSlot(player))
		{
			if(Main.getEconomy().getBalance(player.getName()) > quantity*amount)
			{
				Main.getEconomy().withdrawPlayer(player.getName(), quantity*amount);
				player.getInventory().addItem(new ItemStack(Id, quantity, meta));
				player.sendMessage("§f[§l§1Sivanium Shop§f]:§r§2Vous avez achetez §8"+quantity+" "+art.getArticleName()+" §2pour "+amount*quantity+"$");
			}
			else
			{
				player.sendMessage("§f[§l§1Sivanium Shop§f]:§r§4Vous ne possedez pas les fonds necessaires !");
			}
		}
		else
		{
			player.sendMessage("§f[§l§1Sivanium Shop§f]:§r§4Erreur votre inventaire est plein !");
		}
		return false;
	}
	
	public boolean sell(Player player, int quantity, Article art)
	{
		int Id = art.getId();
		double amount = art.getSellPrice();
		if(player.getInventory().contains(Material.getMaterial(Id), quantity))
		{
			if(Main.getEconomy().hasAccount(player.getName()))
			{
				Main.getEconomy().depositPlayer(player.getName(), amount*quantity);
				this.removeItems(player.getInventory(), Material.getMaterial(Id), quantity);
				player.sendMessage("§f[§l§1Sivanium Shop§f]§r§2Vous avez vendu §8"+quantity+" "+art.getArticleName()+" §2pour "+amount*quantity+"$");
				player.updateInventory();
			}
			else
			{
				player.sendMessage("§f[§l§1Sivanium Shop§f]:§r§4Erreur vous ne possedez pas les fonds necessaires !");
			}
		}
		else
		{
			player.sendMessage("§f[§l§1Sivanium Shop§f]:§r§4Erreur vous ne possedez pas les items !");
		}
		return false;
	}
	
	public void createGUI(String type, Article art, Player player)
	{
		int Id = art.getId();
		Inventory inv = Bukkit.createInventory(null, 27, "§8"+type+" "+art.getArticleName());
		this.addCustomItem(inv, 11, Material.getMaterial(Id).getId(), type+" x1", "x1", 1);
		this.addCustomItem(inv, 13, Material.getMaterial(Id).getId(), type+" x10", "x10", 10);
		this.addCustomItem(inv, 15, Material.getMaterial(Id).getId(), type+" x64", "x64", 64);
		this.fullInventory(inv, (short) 11);
		this.setBackButton(inv);
		
		player.openInventory(inv);
	}
	
	public void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }
	
	public boolean hasAvaliableSlot(Player player)
	{
		Inventory inv = player.getInventory();
		Boolean check=false;
		
		for (ItemStack item: inv.getContents()) 
		{
			if(item == null) 
			{
				check = true;
				break;
			}
		}
		return check;
	}
	
	public static SkyUtils getInstance() 
	{ 
		return instance; 
	}
	
	public void setBorder(Inventory inv, ItemStack border, int size)
	{
		for(int i=0;i<9;i++)
		{
    		if(inv.getItem(i) == null)
	    	{
    			inv.setItem(i, border);
    		}
		}
		
		for(int i=(size-9);i<size;i++)
		{
    		if(inv.getItem(i) == null)
	    	{
    			inv.setItem(i, border);
    		}
		}
		
		for(int i=9;i<size-9;i+=9)
		{
    		if(inv.getItem(i) == null)
	    	{
    			inv.setItem(i, border);
    			if(inv.getItem(i+8) == null)
    	    	{
    				inv.setItem(i+8, border);
    	    	}
    		}
		}
	}
	
	public void setBackButton(Inventory inv)
	{
		int size = inv.getSize();
		
		if(size == 54)
		{
			ItemStack back = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta name1 = back.getItemMeta();
			name1.setDisplayName("§l§4BACK");
			back.setItemMeta(name1);
			inv.setItem(45, back);
		}
		else
		{
			ItemStack back = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta name1 = back.getItemMeta();
			name1.setDisplayName("§l§4BACK");
			back.setItemMeta(name1);
			inv.setItem(18, back);
		}
	}
}
