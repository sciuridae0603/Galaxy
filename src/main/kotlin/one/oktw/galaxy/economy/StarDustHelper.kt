package one.oktw.galaxy.economy

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.CraftingManager
import net.minecraft.item.crafting.FurnaceRecipes
import one.oktw.galaxy.Main

open class StarDustCalcHelper {
    companion object {
        private val itemToDust: HashMap<String, Double> = HashMap()
        private val unSetKeyList: HashMap<String, String> = HashMap()

        init {
            //基本物品定義星塵數量
            itemToDust.put("tile.netherquartz", 512.0)
            itemToDust.put("tile.obsidian", 64.0)
            itemToDust.put("tile.oreCoal", 128.0)
            itemToDust.put("tile.oreDiamond", 8192.0)
            itemToDust.put("tile.oreEmerald", 16384.0)
            itemToDust.put("tile.oreGold", 2048.0)
            itemToDust.put("tile.oreIron", 256.0)
            itemToDust.put("tile.oreLapis", 864.0)
            itemToDust.put("tile.oreRedstone", 64.0)
            itemToDust.put("item.coal", 128.0)
            itemToDust.put("item.diamond", 8192.0)
            itemToDust.put("item.ironNugget", 28.0)
            itemToDust.put("item.emerald", 16384.0)
            itemToDust.put("item.flint", 4.0)
            itemToDust.put("item.yellowDust", 384.0)
            itemToDust.put("item.redstone", 64.0)
            itemToDust.put("tile.gravel", 4.0)
            itemToDust.put("item.goldNugget", 227.0)
            itemToDust.put("item.apple", 128.0)
            itemToDust.put("item.beefRaw", 64.0)
            itemToDust.put("item.carrots", 64.0)
            itemToDust.put("item.chickenRaw", 64.0)
            itemToDust.put("item.egg", 32.0)
            itemToDust.put("item.fish", 64.0)
            itemToDust.put("item.melon", 16.0)
            itemToDust.put("item.milk", 784.0)
            itemToDust.put("item.muttonRaw", 64.0)
            itemToDust.put("item.porkchopRaw", 64.0)
            itemToDust.put("item.potato", 64.0)
            itemToDust.put("item.potatoPoisonous", 64.0)
            itemToDust.put("tile.mushroom", 32.0)
            itemToDust.put("tile.pumpkin", 144.0)
            itemToDust.put("tile.sapling", 32.0)
            itemToDust.put("item.beetroot", 64.0)
            itemToDust.put("item.beetroot_seeds", 16.0)
            itemToDust.put("item.chorusFruit", 192.0)
            itemToDust.put("tile.cactus", 8.0)
            itemToDust.put("tile.chorusFlower", 96.0)
            itemToDust.put("tile.chorusPlant", 64.0)
            itemToDust.put("item.netherStalkSeeds", 24.0)
            itemToDust.put("item.netherStar", 139264.0)
            itemToDust.put("item.wheat", 24.0)
            itemToDust.put("tile.leaves", 1.0)
            itemToDust.put("tile.log", 32.0)
            itemToDust.put("tile.flower1", 16.0)
            itemToDust.put("tile.flower2", 16.0)
            itemToDust.put("item.seeds", 16.0)
            itemToDust.put("item.reeds", 32.0)
            itemToDust.put("tile.waterlily", 16.0)
            itemToDust.put("tile.deadbush", 1.0)
            itemToDust.put("tile.stonebrick", 1.0)
            itemToDust.put("tile.clay", 64.0)
            itemToDust.put("tile.sand", 1.0)
            itemToDust.put("tile.grass", 1.0)
            itemToDust.put("tile.grassPath", 1.0)
            itemToDust.put("tile.ice", 1.0)
            itemToDust.put("tile.icePacked", 4.0)
            itemToDust.put("tile.whiteStone", 1.0)
            itemToDust.put("tile.hellrock", 1.0)
            itemToDust.put("tile.hellsand", 49.0)
            itemToDust.put("tile.sponge", 128.0)
            itemToDust.put("tile.vine", 8.0)
            itemToDust.put("tile.mycel", 2.0)
            itemToDust.put("tile.concrete", 8.0)
            itemToDust.put("item.dyePowder", 16.0)
            itemToDust.put("item.bucketLava", 832.0)
            itemToDust.put("item.bucketWater", 768.0)
            itemToDust.put("item.clay", 16.0)
            itemToDust.put("item.dragon_breath", 1024.0)
            itemToDust.put("item.map", 256.0)
            itemToDust.put("item.expBottle", 512.0)
            itemToDust.put("item.record", 2048.0)
            itemToDust.put("item.fireworks", 512.0)
            itemToDust.put("item.fireworksCharge", 256.0)
            itemToDust.put("item.nameTag", 192.0)
            itemToDust.put("item.potion", 512.0)
            itemToDust.put("item.horsearmordiamond", 2048.0)
            itemToDust.put("item.horsearmorgold", 16384.0)
            itemToDust.put("item.horsearmormetal", 65536.0)
            itemToDust.put("item.knowledgeBook", 160.0)
            itemToDust.put("item.lingering_potion", 512.0)
            itemToDust.put("item.snowball", 1.0)
            itemToDust.put("item.writtenBook", 160.0)
            itemToDust.put("item.saddle", 192.0)
            itemToDust.put("item.prismarineCrystals", 512.0)
            itemToDust.put("item.prismarineShard", 256.0)
            itemToDust.put("item.totem", 1024.0)
            itemToDust.put("item.tipped_arrow", 14.0)
            itemToDust.put("item.splash_potion", 512.0)
            itemToDust.put("item.bone", 144.0)
            itemToDust.put("item.blazeRod", 1536.0)
            itemToDust.put("tile.dirt", 1.0)
            itemToDust.put("item.rabbitFoot", 128.0)
            itemToDust.put("item.rabbitHide", 16.0)
            itemToDust.put("item.rabbitRaw", 64.0)
            itemToDust.put("tile.web", 12.0)
            itemToDust.put("item.feather", 48.0)
            itemToDust.put("item.enderPearl", 1024.0)
            itemToDust.put("item.ghastTear", 4096.0)
            itemToDust.put("item.spiderEye", 128.0)
            itemToDust.put("item.string", 12.0)
            itemToDust.put("item.sulphur", 192.0)
            itemToDust.put("item.slimeball", 32.0)
            itemToDust.put("tile.dragonEgg", 204800.0)
            itemToDust.put("item.skull", 4096.0)
            itemToDust.put("item.bootsChain", 2048.0)
            itemToDust.put("item.helmetChain", 2048.0)
            itemToDust.put("item.chestplateChain", 2048.0)
            itemToDust.put("item.leggingsChain", 2048.0)
            itemToDust.put("item.elytra", 16384.0)
            itemToDust.put("item.shulkerShell", 2048.0)
            itemToDust.put("tile.shulkerBoxBlack", 10240.0)
            itemToDust.put("tile.shulkerBoxBlue", 10240.0)
            itemToDust.put("tile.shulkerBoxBrown", 10240.0)
            itemToDust.put("tile.shulkerBoxCyan", 10240.0)
            itemToDust.put("tile.shulkerBoxGray", 10240.0)
            itemToDust.put("tile.shulkerBoxGreen", 10240.0)
            itemToDust.put("tile.shulkerBoxLightBlue", 10240.0)
            itemToDust.put("tile.shulkerBoxLime", 10240.0)
            itemToDust.put("tile.shulkerBoxMagenta", 10240.0)
            itemToDust.put("tile.shulkerBoxOrange", 10240.0)
            itemToDust.put("tile.shulkerBoxPink", 10240.0)
            itemToDust.put("tile.shulkerBoxRed", 10240.0)
            itemToDust.put("tile.shulkerBoxSilver", 10240.0)
            itemToDust.put("tile.shulkerBoxWhite", 10240.0)
            itemToDust.put("tile.shulkerBoxYellow", 10240.0)
        }

        private fun getRecipe(item: ItemStack): Pair<Array<ItemStack>, Int> {
            var itemRecipe = emptyArray<ItemStack>()

            CraftingManager.REGISTRY.iterator().forEach { recipe ->
                if (item.isItemEqualIgnoreDurability(recipe.recipeOutput)) {
                    recipe.ingredients.forEach { item ->
                        if (item.matchingStacks.count() != 0) {
                            itemRecipe += item.matchingStacks.first()
                        }
                    }
                    return itemRecipe to recipe.recipeOutput.count
                }
            }
            FurnaceRecipes.instance().smeltingList.forEach { recipe ->
                if (item.isItemEqualIgnoreDurability(recipe.value)) {
                    itemRecipe += recipe.key
                    return itemRecipe to 1
                }
            }
            return itemRecipe to 1
        }

        fun getDustCount(item: ItemStack): Double {
            val (itemRecipe, outputQuantity) = getRecipe(item)
            var dustCount = 0.0
            val itemID = item.unlocalizedName.split(".")[0] + "." + item.unlocalizedName.split(".")[1]

            if (itemRecipe.count() == 0) {
                if (!itemToDust.containsKey(itemID)) {
                    if (!unSetKeyList.contains(itemID)) {
                        unSetKeyList.put(itemID, item.displayName)
                    }
                    Main.main.logger.warn("Can't found item star dust quantity , use default value -> 1  Item : $itemID")
                }
                return itemToDust[itemID] ?: 0.0
            }

            itemRecipe.forEach { i ->
                val id = i.unlocalizedName.split(".")[0] + "." + i.unlocalizedName.split(".")[1]
                dustCount += if (itemToDust.containsKey(id)) {
                    itemToDust[id] ?: 0.0
                } else {
                    (getDustCount(i) * (1.0 / outputQuantity))
                }
            }
            return (dustCount * item.count)
        }

        fun getUnSetKey(): HashMap<String, String> {
            Item.REGISTRY.iterator().forEach { i ->
                getDustCount(ItemStack(i))
            }
            return (unSetKeyList)
        }
    }
}
