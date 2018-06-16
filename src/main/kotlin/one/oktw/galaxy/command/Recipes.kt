package one.oktw.galaxy.command

import net.minecraft.item.ItemStack
import one.oktw.galaxy.economy.StarDustCalcHelper.Companion.getDustCount
import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.data.type.HandTypes
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.text.Text

class Recipes : CommandBase {
    override val spec: CommandSpec
        get() = CommandSpec.builder()
            .permission("oktw.command.recipes")
            .executor(this)
            .arguments()
            .build()


    override fun execute(src: CommandSource, args: CommandContext): CommandResult {
        if (src !is Player) return CommandResult.empty()

        val item = src.getItemInHand(HandTypes.MAIN_HAND)

        if (!item.isPresent) return CommandResult.empty()

        src.sendMessage(Text.of(getDustCount(item.get() as ItemStack)))

        return CommandResult.success()
    }
}
