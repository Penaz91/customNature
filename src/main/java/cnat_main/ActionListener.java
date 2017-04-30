package cnat_main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cnat_main.Main.Flowers;

public final class ActionListener implements Listener{
	@EventHandler
	public void onClick(PlayerInteractEvent event){
		if (event.hasItem()){
			if (event.getItem().equals(Main.is)){
				event.setCancelled(true);
				//Bukkit.getServer().getLogger().info("Clicked!");
				Player pl =event.getPlayer();
				Location loc = event.getClickedBlock().getLocation();
				for (int x = loc.getBlockX()-Main.rng; x <= loc.getBlockX()+Main.rng; x++){
					for (int z = loc.getBlockZ()-Main.rng; z <= loc.getBlockZ()+Main.rng; z++){
						Location l = new Location(pl.getWorld(), x, pl.getWorld().getHighestBlockYAt(x, z), z);
						if (l.getBlock().getType().equals(Material.AIR)){
							//block placing logic
							if (Main.rnd.nextInt(101) > Main.air){
								//place
								int x1 = Main.rnd.nextInt(Main.pallette.size());
								//Bukkit.getServer().getLogger().info(Main.pallette.toString());
								//Bukkit.getServer().getLogger().info("Number chosen: " +x1);
								Main.Flowers blk = Main.pallette.get(x1);
								//Bukkit.getServer().getLogger().info("Enum chosen: " +blk.toString());
								switch (blk){
									 case SUNFLOWER:
										 l.getBlock().setType(Material.DOUBLE_PLANT);
										 l.getBlock().setData((byte) 0);
										 break;
									 case LILAC:
										 l.getBlock().setType(Material.DOUBLE_PLANT);
										 l.getBlock().setData((byte) 1);
										 break;
									 case TALLGRASS:
										 l.getBlock().setType(Material.DOUBLE_PLANT);
										 l.getBlock().setData((byte) 2);
										 break;
									 case TALLFERN:
										 l.getBlock().setType(Material.DOUBLE_PLANT);
										 l.getBlock().setData((byte) 3);
										 break;
									 case ROSE:
										 l.getBlock().setType(Material.DOUBLE_PLANT);
										 l.getBlock().setData((byte) 4);
										 break;
									 case PEONY:
										 l.getBlock().setType(Material.DOUBLE_PLANT);
										 l.getBlock().setData((byte) 5);
										 break;
									 case DANDELION:
										 l.getBlock().setType(Material.YELLOW_FLOWER);
										 break;
									 case POPPY:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 0);
										 break;
									 case ORCHID:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 1);
										 break;
									 case ALLIUM:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 2);
										 break;
									 case BLUET:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 3);
										 break;
									 case REDTULIP:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 4);
										 break;
									 case ORANGETULIP:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 5);
										 break;
									 case WHITETULIP:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 6);
										 break;
									 case PINKTULIP:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 7);
										 break;
									 case DAISY:
										 l.getBlock().setType(Material.RED_ROSE);
										 l.getBlock().setData((byte) 8);
										 break;
									 case GRASS:
										 l.getBlock().setType(Material.LONG_GRASS);
										 l.getBlock().setData((byte) 1);
										 break;
									 case FERN:
										 l.getBlock().setType(Material.LONG_GRASS);
										 l.getBlock().setData((byte) 2);
										 break;
									 case SHRUB:
										 l.getBlock().setType(Material.LONG_GRASS);
										 l.getBlock().setData((byte) 0);
										 break;
								}
								if (l.getBlock().getType().equals(Material.DOUBLE_PLANT)){
									l.setY(l.getBlockY() + 1);
									l.getBlock().setType(Material.DOUBLE_PLANT, false);
									l.getBlock().setData((byte) 8, false);
								}
							}
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();
		if (inventory.getName().equals(Main.mainMenu.getName())) {
			event.setCancelled(true);
			if (clicked.equals(Main.editPallette)) {
				player.closeInventory();
				player.openInventory(Main.addremoveMenu);
			}
			if (clicked.equals(Main.exit)){
				player.closeInventory();
			}
			if (clicked.equals(Main.minus10air)){
				Main.air = Math.max(0, Main.air - 10);
				Main.updateData();
			}
			if (clicked.equals(Main.minus5air)){
				Main.air = Math.max(0, Main.air - 5);
				Main.updateData();
			}
			if (clicked.equals(Main.minus1air)){
				Main.air = Math.max(0, Main.air - 1);
				Main.updateData();
			}
			if (clicked.equals(Main.plus1air)){
				Main.air = Math.min(100, Main.air + 1);
				Main.updateData();
			}
			if (clicked.equals(Main.plus5air)){
				Main.air = Math.min(100, Main.air + 5);
				Main.updateData();
			}
			if (clicked.equals(Main.plus10air)){
				Main.air = Math.min(100, Main.air + 10);
				Main.updateData();
			}
			if (clicked.equals(Main.minus5Radius)){
				Main.rng = Math.max(0, Main.rng - 5);
				Main.updateData();
			}
			if (clicked.equals(Main.minus10Radius)){
				Main.rng = Math.max(0, Main.rng - 10);
				Main.updateData();
			}
			if (clicked.equals(Main.minus1Radius)){
				Main.rng = Math.max(0, Main.rng - 1);
				Main.updateData();
			}
			if (clicked.equals(Main.plus1Radius)){
				Main.rng = Math.min(100, Main.rng + 1);
				Main.updateData();
			}
			if (clicked.equals(Main.plus5Radius)){
				Main.rng = Math.min(100, Main.rng + 5);
				Main.updateData();
			}
			if (clicked.equals(Main.plus10Radius)){
				Main.rng = Math.min(100, Main.rng + 10);
				Main.updateData();
			}
		}
		if (inventory.getName().equals(Main.addremoveMenu.getName())) {
			if (event.getClick().isLeftClick()){
				event.setCancelled(true);
				if (clicked.equals(Main.sunflower)){
					Main.pallette.add(Flowers.SUNFLOWER);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.lilac)){
					Main.pallette.add(Flowers.LILAC);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.tallfern)){
					Main.pallette.add(Flowers.TALLFERN);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.rose)){
					Main.pallette.add(Flowers.ROSE);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.bluet)){
					Main.pallette.add(Flowers.BLUET);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.redtulip)){
					Main.pallette.add(Flowers.REDTULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.orangetulip)){
					Main.pallette.add(Flowers.ORANGETULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.whitetulip)){
					Main.pallette.add(Flowers.WHITETULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.fern)){
					Main.pallette.add(Flowers.FERN);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.peony)){
					Main.pallette.add(Flowers.PEONY);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.dandelion)){
					Main.pallette.add(Flowers.DANDELION);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.poppy)){
					Main.pallette.add(Flowers.POPPY);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.orchid)){
					Main.pallette.add(Flowers.ORCHID);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.allium)){
					Main.pallette.add(Flowers.ALLIUM);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.pinktulip)){
					Main.pallette.add(Flowers.PINKTULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.daisy)){
					Main.pallette.add(Flowers.DAISY);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.tallgrass)){
					Main.pallette.add(Flowers.TALLGRASS);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.grass)){
					Main.pallette.add(Flowers.GRASS);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.shrub)){
					Main.pallette.add(Flowers.SHRUB);
					Main.updateSecondaryData();
				}
			}
			if (event.getClick().isRightClick()){
				event.setCancelled(true);
				if (clicked.equals(Main.sunflower)){
					Main.pallette.remove(Flowers.SUNFLOWER);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.lilac)){
					Main.pallette.remove(Flowers.LILAC);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.tallfern)){
					Main.pallette.remove(Flowers.TALLFERN);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.rose)){
					Main.pallette.remove(Flowers.ROSE);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.bluet)){
					Main.pallette.remove(Flowers.BLUET);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.redtulip)){
					Main.pallette.remove(Flowers.REDTULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.orangetulip)){
					Main.pallette.remove(Flowers.ORANGETULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.whitetulip)){
					Main.pallette.remove(Flowers.WHITETULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.fern)){
					Main.pallette.remove(Flowers.FERN);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.peony)){
					Main.pallette.remove(Flowers.PEONY);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.dandelion)){
					Main.pallette.remove(Flowers.DANDELION);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.poppy)){
					Main.pallette.remove(Flowers.POPPY);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.orchid)){
					Main.pallette.remove(Flowers.ORCHID);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.allium)){
					Main.pallette.remove(Flowers.ALLIUM);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.pinktulip)){
					Main.pallette.remove(Flowers.PINKTULIP);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.daisy)){
					Main.pallette.remove(Flowers.DAISY);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.tallgrass)){
					Main.pallette.remove(Flowers.TALLGRASS);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.grass)){
					Main.pallette.remove(Flowers.GRASS);
					Main.updateSecondaryData();
				}
				if (clicked.equals(Main.shrub)){
					Main.pallette.remove(Flowers.SHRUB);
					Main.updateSecondaryData();
				}
			}
		}
	}
}
