package one.oktw.galaxy.block

import one.oktw.galaxy.data.DataBlockType
import one.oktw.galaxy.data.DataItemType
import one.oktw.galaxy.item.enums.ItemType.BLOCK
import one.oktw.galaxy.item.type.Item
import org.spongepowered.api.data.key.Keys.ITEM_DURABILITY
import org.spongepowered.api.data.key.Keys.UNBREAKABLE
import org.spongepowered.api.item.ItemTypes.WOODEN_SWORD
import org.spongepowered.api.item.inventory.ItemStack

data class FakeBlockItem(private val block: FakeBlocks) : Item {
    override val itemType = BLOCK

    override fun createItemStack(): ItemStack = ItemStack.builder()
        .itemType(WOODEN_SWORD)
        .itemData(DataItemType(BLOCK))
        .itemData(DataBlockType(block))
        .add(UNBREAKABLE, true)
        .add(ITEM_DURABILITY, block.id)
        .build()

    override fun displayedItems() = listOfNotNull(createItemStack().createSnapshot())

    override fun test(itemStack: ItemStack): Boolean {
        return itemStack[DataItemType.key].orElse(null) == BLOCK && itemStack[ITEM_DURABILITY].orElse(null) == block.id
    }
}
