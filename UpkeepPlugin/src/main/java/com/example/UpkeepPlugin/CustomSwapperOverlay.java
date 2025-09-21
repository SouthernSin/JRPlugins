package com.example.UpkeepPlugin;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

import javax.inject.Inject;
import java.awt.*;

public class CustomSwapperOverlay extends Overlay {

    private final Client client;
    private final MyNewPlugin plugin;
    private final CustomSwapperConfig config;
    private final ModelOutlineRenderer modelOutlineRenderer;

    @Inject
    private CustomSwapperOverlay(Client client, MyNewPlugin plugin, CustomSwapperConfig config, ModelOutlineRenderer modelOutlineRenderer) {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        this.modelOutlineRenderer = modelOutlineRenderer;
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.DYNAMIC);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.targetOverlay() || plugin.getLockedTarget() == null) {
            return null;
        }

        Player target = plugin.getLockedTarget();
        if (target != null) {
            modelOutlineRenderer.drawOutline(target, config.overlayWidth(), config.overlayColor(), 1);
        }

        return null;
    }
}
