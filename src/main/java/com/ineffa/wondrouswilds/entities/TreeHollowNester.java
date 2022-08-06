package com.ineffa.wondrouswilds.entities;

import com.ineffa.wondrouswilds.blocks.entity.TreeHollowBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface TreeHollowNester {

    int getNestCapacityWeight();

    int getMinTicksInNest();

    int getMinTicksOutOfNest();

    int getCannotInhabitNestTicks();

    void setCannotInhabitNestTicks(int ticks);

    BlockPos getNestPos();

    void setNestPos(BlockPos pos);

    default void clearNestPos() {
        this.setNestPos(BlockPos.ORIGIN);
    }

    default boolean hasNestPos() {
        return !(this.getNestPos() == null || this.getNestPos() == BlockPos.ORIGIN);
    }

    default boolean hasValidNestPos() {
        return this.hasNestPos() && this.getWorld().getBlockEntity(this.getNestPos()) instanceof TreeHollowBlockEntity;
    }

    default boolean shouldFindNest() {
        return !this.hasValidNestPos();
    }

    boolean shouldReturnToNest();

    boolean defendsNest();

    int getWanderRadiusFromNest();

    World getWorld();
}
