package com.buuz135.industrialforegoingsouls.block;

import com.buuz135.industrial.block.IndustrialBlock;
import com.buuz135.industrial.module.ModuleResourceProduction;
import com.buuz135.industrialforegoingsouls.block.tile.SoulLaserBaseBlockEntity;
import com.buuz135.industrialforegoingsouls.config.ConfigSoulLaserBase;
import com.hrznstudio.titanium.block_network.INetworkDirectionalConnection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class SoulLaserBaseBlock extends IndustrialBlock<SoulLaserBaseBlockEntity>{
    public SoulLaserBaseBlock() {
        super("soul_laser_base", BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoulLaserBaseBlockEntity.class, ModuleResourceProduction.TAB_RESOURCE);
    }

    @Override
    public BlockEntityType.BlockEntitySupplier<SoulLaserBaseBlockEntity> getTileEntityFactory() {
        return SoulLaserBaseBlockEntity::new;
    }

    @Override
    public void registerRecipe(Consumer<FinishedRecipe> consumer) {
        //TODO
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        var tile = level.getBlockEntity(pos);
        if (tile instanceof SoulLaserBaseBlockEntity laser) {
            return (int) Math.floor(15 * (laser.getSoulAmount() / (double) ConfigSoulLaserBase.SOUL_STORAGE_AMOUNT));
        }
        return 0;
    }
}
