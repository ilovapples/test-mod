package com.apples.opitems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.apples.opitems.items.*;
import com.apples.opitems.enchantments.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class OPItems implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("opitems");

	// create
	public final KnockbackStick KNOCKBACK_STICK = new KnockbackStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.RARE));

	public static final BetterKnockbackStick BETTER_KNOCKBACK_STICK = new BetterKnockbackStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.EPIC));

	
	// Fire Stick items: Fire Stick, Raw Blaze Core, Refined Blaze Core
	public static final FireStick FIRE_STICK = new FireStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.EPIC)
			.fireproof());
	
	/*
	Refined Blaze Core:
		Used to craft the Fire Stick, among other things.
		Does nothing by itself.
	*/
	public static final RefinedBlazeCore REFINED_BLAZE_CORE = new RefinedBlazeCore(new FabricItemSettings()
			.rarity(Rarity.EPIC)
			.fireproof());
	// residue left over after refining raw blaze cores
	public static final BlazeCoreResidue BLAZE_CORE_RESIDUE = new BlazeCoreResidue(new FabricItemSettings()
			.rarity(Rarity.UNCOMMON)
			.fireproof());
	/*
	Raw Blaze Core:
		Dropped from Blazes with a 1.25% chance.
		Combine with Netherite Scrap in Smithing Table to get Refined Blaze Core
	*/
	public static final RawBlazeCore RAW_BLAZE_CORE = new RawBlazeCore(new FabricItemSettings()
			.rarity(Rarity.RARE)
			.fireproof()
			.recipeRemainder(BLAZE_CORE_RESIDUE));

	public static final Item YEET_BALL = new Item(new FabricItemSettings()
			.maxCount(1));
	// placeholders for crafting (it looks better like this I promise)
	public final BetterKnockbackStick PLACEHOLDER_BETTER = new BetterKnockbackStick(new FabricItemSettings()
			.rarity(Rarity.EPIC));

	public final KnockbackStick PLACEHOLDER_NORMAL = new KnockbackStick(new FabricItemSettings()
			.rarity(Rarity.RARE));

	public final FireStick PLACEHOLDER_FIRE = new FireStick(new FabricItemSettings()
			.rarity(Rarity.EPIC));


	public static PoisonTipped POISON_TIPPED = new PoisonTipped();
	public static FrostTipped FROST_TIPPED = new FrostTipped();
	public static WitherTipped WITHER_TIPPED = new WitherTipped();
	public static WeaknessTipped WEAKNESS_TIPPED = new WeaknessTipped();
	public static InvisHit INVIS_HIT = new InvisHit();
	public static OPEnch OP_ENCH = new OPEnch();

	ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("opitems", "op_items_group"))
    	.displayName(Text.literal("OP Items Group"))
    	.icon(() -> new ItemStack(BETTER_KNOCKBACK_STICK))
    	.entries((enabledFeatures, entries, operatorEnabled) -> {
        	entries.add(KNOCKBACK_STICK);
			entries.add(BETTER_KNOCKBACK_STICK);
			entries.add(FIRE_STICK);
			entries.add(RAW_BLAZE_CORE);
			entries.add(REFINED_BLAZE_CORE);
    	})
    	.build();

	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("ilovapples' OP Items Mod has been successfully initialized!");
		Registry.register(Registries.ITEM, new Identifier("opitems", "knockback_stick"), KNOCKBACK_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "better_knockback_stick"), BETTER_KNOCKBACK_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "fire_stick"), FIRE_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "raw_blaze_core"), RAW_BLAZE_CORE); 
		Registry.register(Registries.ITEM, new Identifier("opitems", "refined_blaze_core"), REFINED_BLAZE_CORE); 
		Registry.register(Registries.ITEM, new Identifier("opitems", "blaze_core_residue"), BLAZE_CORE_RESIDUE);
		Registry.register(Registries.ITEM, new Identifier("opitems", "yeet_ball"), YEET_BALL);

		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_better"), PLACEHOLDER_BETTER);
		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_normal"), PLACEHOLDER_NORMAL);
		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_fire"), PLACEHOLDER_FIRE);

		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "poison_tipped"), POISON_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "frost_tipped"), FROST_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "wither_tipped"), WITHER_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "weakness_tipped"), WEAKNESS_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "invis_hit"), INVIS_HIT);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "op_ench"), OP_ENCH);

		FuelRegistry.INSTANCE.add(BLAZE_CORE_RESIDUE, 10000);
	}
}
