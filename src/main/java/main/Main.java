package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	 public static ItemStack is;
	 public static ArrayList<Material> mList = new ArrayList<Material>();
	 public static Inventory mainMenu = Bukkit.createInventory(null, 54, "customNature Main Menu");
	 public static Inventory addremoveMenu = Bukkit.createInventory(null, 54, "Pallette editing");
	 public static Random rnd = new Random();
	 static ItemStack editPallette = new ItemStack(Material.STAINED_GLASS, 1);
	 //static ItemStack showPallette = new ItemStack(Material.STAINED_GLASS, 1);
	 static ItemStack exit=new ItemStack(Material.BARRIER, 1);
	 static ItemStack rangeView = new ItemStack(Material.STAINED_GLASS, 1);
	 static ItemStack airView = new ItemStack(Material.STAINED_GLASS, 1);
	 static ItemStack separator = new ItemStack(Material.STAINED_GLASS_PANE, 1);
	 static ItemStack plus1Radius = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack plus5Radius = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack plus10Radius = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack plus1air = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack plus5air = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack plus10air = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack minus1Radius = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack minus5Radius = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack minus10Radius = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack minus1air = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack minus5air = new ItemStack(Material.TIPPED_ARROW);
	 static ItemStack minus10air = new ItemStack(Material.TIPPED_ARROW);
	 //-----------------
	 static ItemStack sunflower = new ItemStack(Material.DOUBLE_PLANT, 1);
	 static ItemStack lilac = new ItemStack(Material.DOUBLE_PLANT, 1);
	 static ItemStack tallfern = new ItemStack(Material.DOUBLE_PLANT, 1);
	 static ItemStack tallgrass = new ItemStack(Material.DOUBLE_PLANT, 1);
	 static ItemStack rose = new ItemStack(Material.DOUBLE_PLANT, 1);
	 static ItemStack peony = new ItemStack(Material.DOUBLE_PLANT, 1);
	 static ItemStack dandelion = new ItemStack(Material.YELLOW_FLOWER, 1);
	 static ItemStack poppy = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack orchid = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack allium = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack bluet = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack redtulip = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack orangetulip = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack whitetulip = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack pinktulip = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack daisy = new ItemStack(Material.RED_ROSE, 1);
	 static ItemStack grass = new ItemStack(Material.LONG_GRASS, 1);
	 static ItemStack shrub = new ItemStack(Material.LONG_GRASS, 1);
	 static ItemStack fern = new ItemStack(Material.LONG_GRASS, 1);
	 public static int rng = 0;
	 public static int air = 0;
	 public static enum Flowers {SUNFLOWER, LILAC, TALLGRASS, TALLFERN, ROSE, PEONY, DANDELION, POPPY, ORCHID, ALLIUM, BLUET, REDTULIP, ORANGETULIP, WHITETULIP, PINKTULIP, DAISY, GRASS, FERN, SHRUB};
	 public static ArrayList<Flowers> pallette = new ArrayList<Flowers>();
	 static{		 
		 ItemMeta im = editPallette.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "Show/Edit your pallette");
		 editPallette.setItemMeta(im);
		 //im = showPallette.getItemMeta();
		 //im.setDisplayName(ChatColor.RED + "Show items in your pallette");
		 //showPallette.setItemMeta(im);
		 editPallette.setDurability((short) 5);
		 //showPallette.setDurability((short) 14);
		 im=exit.getItemMeta();
		 im.setDisplayName("Exit");
		 exit.setItemMeta(im);
		 rangeView.setDurability((short) 4);
		 airView.setDurability((short) 11);
		 separator.setDurability((short) 15);
		 im = minus1Radius.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "-1 Block");
		 minus1Radius.setItemMeta(im);
		 im = minus5Radius.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "-5 Blocks");
		 minus5Radius.setItemMeta(im);
		 im = minus10Radius.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "-10 Blocks");
		 minus10Radius.setItemMeta(im);
		 im = plus1Radius.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "+1 Block");
		 plus1Radius.setItemMeta(im);
		 im = plus5Radius.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "+5 Blocks");
		 plus5Radius.setItemMeta(im);
		 im = plus10Radius.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "+10 Blocks");
		 plus10Radius.setItemMeta(im);
		 im = minus1air.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "-1%");
		 minus1air.setItemMeta(im);
		 im = minus5air.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "-5%");
		 minus5air.setItemMeta(im);
		 im = minus10air.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "-10%");
		 minus10air.setItemMeta(im);
		 im = plus1air.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "+1%");
		 plus1air.setItemMeta(im);
		 im = plus5air.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "+5%");
		 plus5air.setItemMeta(im);
		 im = plus10air.getItemMeta();
		 im.setDisplayName(ChatColor.GREEN + "+10%");
		 plus10air.setItemMeta(im);
		 updateData();
		 mainMenu.setItem(0, editPallette);
		 //mainMenu.setItem(8, showPallette);
		 mainMenu.setItem(10, minus1Radius);
		 mainMenu.setItem(11, separator);
		 mainMenu.setItem(12, plus1Radius);
		 mainMenu.setItem(19, minus5Radius);
		 mainMenu.setItem(20, separator);
		 mainMenu.setItem(21, plus5Radius);
		 mainMenu.setItem(28, minus10Radius);
		 mainMenu.setItem(29, separator);
		 mainMenu.setItem(30, plus10Radius);
		 mainMenu.setItem(38, separator);
		 mainMenu.setItem(47, separator);
		 mainMenu.setItem(14, minus1air);
		 mainMenu.setItem(15, separator);
		 mainMenu.setItem(16, plus1air);
		 mainMenu.setItem(23, minus5air);
		 mainMenu.setItem(24, separator);
		 mainMenu.setItem(25, plus5air);
		 mainMenu.setItem(32, minus10air);
		 mainMenu.setItem(33, separator);
		 mainMenu.setItem(34, plus10air);
		 mainMenu.setItem(42, separator);
		 mainMenu.setItem(51, separator);
		 mainMenu.setItem(53, exit);
		 //---------------------
		 updateSecondaryData();
	 }
	 
	 public static void updateSecondaryData(){
		 addremoveMenu.clear();
		 sunflower.setDurability((short) 0);
		 lilac.setDurability((short) 1);
		 tallfern.setDurability((short) 3);
		 rose.setDurability((short) 4);
		 peony.setDurability((short) 5);
		 orchid.setDurability((short) 1);
		 allium.setDurability((short) 2);
		 tallgrass.setDurability((short) 2);
		 bluet.setDurability((short) 3);
		 redtulip.setDurability((short) 4);
		 orangetulip.setDurability((short) 5);
		 whitetulip.setDurability((short) 6);
		 pinktulip.setDurability((short) 7);
		 daisy.setDurability((short) 8);
		 grass.setDurability((short) 1);
		 fern.setDurability((short) 2);
		 addremoveMenu.setItem(0, sunflower);
		 addremoveMenu.setItem(1, lilac);
		 addremoveMenu.setItem(2, tallfern);
		 addremoveMenu.setItem(3, rose);
		 addremoveMenu.setItem(19, peony);
		 addremoveMenu.setItem(20, dandelion);
		 addremoveMenu.setItem(21, poppy);
		 addremoveMenu.setItem(27, orchid);
		 addremoveMenu.setItem(28, allium);
		 addremoveMenu.setItem(9, bluet);
		 addremoveMenu.setItem(10, redtulip);
		 addremoveMenu.setItem(11, orangetulip);
		 addremoveMenu.setItem(12, whitetulip);
		 addremoveMenu.setItem(29, pinktulip);
		 addremoveMenu.setItem(30, daisy);
		 addremoveMenu.setItem(36, tallgrass);
		 addremoveMenu.setItem(37, shrub);
		 addremoveMenu.setItem(38, grass);
		 addremoveMenu.setItem(18, fern);
		 addremoveMenu.setItem(4, separator);
		 addremoveMenu.setItem(13, separator);
		 addremoveMenu.setItem(22, separator);
		 addremoveMenu.setItem(31, separator);
		 addremoveMenu.setItem(40, separator);
		 addremoveMenu.setItem(49, separator);
		 int i=5;
		 int j=0;
		 for (Flowers f: pallette){
			 if (i==9){
				 i=5;
				 j++;
			 }
			 switch (f){
			 case SUNFLOWER:
				 addremoveMenu.setItem(i+j*9, sunflower);break;
			 case LILAC:
				 addremoveMenu.setItem(i+j*9, lilac);break;
			 case TALLGRASS:
				 addremoveMenu.setItem(i+j*9, tallgrass);break;
			 case TALLFERN:
				 addremoveMenu.setItem(i+j*9, tallfern);break;
			 case ROSE:
				 addremoveMenu.setItem(i+j*9, rose);break;
			 case PEONY:
				 addremoveMenu.setItem(i+j*9, peony);break;
			 case DANDELION:
				 addremoveMenu.setItem(i+j*9, dandelion);break;
			 case POPPY:
				 addremoveMenu.setItem(i+j*9, poppy);break;
			 case ORCHID:
				 addremoveMenu.setItem(i+j*9, orchid);break;
			 case ALLIUM:
				 addremoveMenu.setItem(i+j*9, allium);break;
			 case BLUET:
				 addremoveMenu.setItem(i+j*9, bluet);break;
			 case REDTULIP:
				 addremoveMenu.setItem(i+j*9, redtulip);break;
			 case ORANGETULIP:
				 addremoveMenu.setItem(i+j*9, orangetulip);break;
			 case WHITETULIP:
				 addremoveMenu.setItem(i+j*9, whitetulip);break;
			 case PINKTULIP:
				 addremoveMenu.setItem(i+j*9, pinktulip);break;
			 case DAISY:
				 addremoveMenu.setItem(i+j*9, daisy);break;
			 case GRASS:
				 addremoveMenu.setItem(i+j*9, grass);break;
			 case FERN:
				 addremoveMenu.setItem(i+j*9, fern);break;
			 case SHRUB:
				 addremoveMenu.setItem(i+j*9, shrub);break;
			 }
			 i++;
		 }
	 }
	 
	 public static void updateData(){
		 ItemMeta im = rangeView.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "Radius: ");
		 ArrayList<String> Lore = new ArrayList<String>();
		 Lore.add("Range: " + rng);
		 im.setLore(Lore);
		 rangeView.setItemMeta(im);
		 im = airView.getItemMeta();
		 im.setDisplayName(ChatColor.DARK_RED + "Air Percentage: ");
		 Lore = new ArrayList<String>();
		 Lore.add(air+"%");
		 im.setLore(Lore);
		 airView.setItemMeta(im);
		 mainMenu.setItem(2, rangeView);
		 mainMenu.setItem(6, airView);
	 }
	 
	 public void onEnable(){
	    	File f = getDataFolder();
			if (!f.exists()){
				f.mkdir();
			}
			mList.add(Material.YELLOW_FLOWER);
			getServer().getPluginManager().registerEvents(new ActionListener(), this);
			is = new ItemStack(Material.BONE);
			is.setAmount(1);
			is.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.DARK_PURPLE + "CustomNature Sniper");
			is.setItemMeta(im);
	 }
	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (cmd.getName().equalsIgnoreCase("cnat")) {
				Player pl =((Player) sender);
				pl.getInventory().addItem(is);
				getLogger().info("Done");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("cncustom")) {
				Player pl = (Player) sender;
				pl.openInventory(mainMenu);
			}
			return true;
	 }
	 public void onDisable(){
			HandlerList.unregisterAll();
	}
}
