package com.bankfinder;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface BankFinderConfig extends Config
{
	@ConfigItem(
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The test Bank Finder plugin is working successfully! It does nothing"
	)
	default String greeting()
	{
		return "Hello";
	}
}
