package com.bankfinder;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

public class BankFinderWorldMapPoint extends WorldMapPoint
{
    public BankFinderWorldMapPoint(WorldPoint worldPoint, BufferedImage image)
    {
        super(worldPoint, null);

        BufferedImage iconBackground = ImageUtil.loadImageResource(getClass(), "/util/clue_arrow.png");
        //questWorldImage = new BufferedImage(iconBackground.getWidth(), iconBackground.getHeight(), BufferedImage.TYPE_INT_ARGB);

    }

}
