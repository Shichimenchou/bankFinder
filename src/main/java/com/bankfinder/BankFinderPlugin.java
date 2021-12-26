package com.bankfinder;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "Bank Finder"
)

public class BankFinderPlugin extends Plugin
{
	/*private int getClientPlane(Client client)
	{
		return client.getPlane();
	}*/

	@Inject
	private Client client;

	@Inject
	private BankFinderConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", config.greeting(), null);
		}
	}

	@Provides
	BankFinderConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankFinderConfig.class);
	}

	//WorldPoint wp = new WorldPoint(0,0, client.getPlane());
	WorldPoint wp = new WorldPoint(10000,10000,0);
	BufferedImage iconBackground = ImageUtil.loadImageResource(getClass(), "/util/clue_arrow.png");

	BankFinderWorldMapPoint bankPoint = new BankFinderWorldMapPoint(wp, iconBackground);
}
