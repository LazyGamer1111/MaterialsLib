package io.github.LazyGamer1111.materiallib.dataGen.worldgen;

import io.github.LazyGamer1111.materiallib.Material;
import io.github.LazyGamer1111.materiallib.Materiallib;
import io.github.LazyGamer1111.materiallib.materialRegistry;
import io.github.LazyGamer1111.materiallib.types.blockTypes.OreBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.ArrayList;
import java.util.List;

public class ModConfiguredFeatures {
    public static final List<RegistryKey<ConfiguredFeature<?, ?>>> keys = new ArrayList<>();
    private static boolean bootstrapRun = false;

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<String> names = new ArrayList<>();
        List<Integer> veinSizes = new ArrayList<>();
        List<List<OreFeatureConfig.Target>> Ores = new ArrayList<>();
        for(Material material : materialRegistry.getMaterials()) {
            List<OreFeatureConfig.Target> targets = new ArrayList<>();
            for(OreBlock oreBlock : material.getOres()) {
                if (oreBlock.blockType == OreBlock.BlockTypes.STONE) targets.add(OreFeatureConfig.createTarget(stoneReplacables, oreBlock.getDefaultState()));
                else if(oreBlock.blockType == OreBlock.BlockTypes.DEEPSLATE) targets.add(OreFeatureConfig.createTarget(deepslateReplacables, oreBlock.getDefaultState()));
            }
            Ores.add(targets);
            names.add(material.name);
            veinSizes.add(material.veinSize);
        }

        int loopNum = 0;
        for(List<OreFeatureConfig.Target> materialOres : Ores){
            RegistryKey<ConfiguredFeature<?, ?>> key = registerKey(names.get(loopNum));
            keys.add(key);
            register(context, key, Feature.ORE, new OreFeatureConfig(materialOres, veinSizes.get(loopNum)));
            loopNum++;
        }

        bootstrapRun = true;
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Materiallib.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public boolean isBootstrapRun() {
        return bootstrapRun;
    }
}
