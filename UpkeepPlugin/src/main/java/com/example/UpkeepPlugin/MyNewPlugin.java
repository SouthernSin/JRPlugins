package com.example.UpkeepPlugin;

import com.google.common.base.Splitter;
import com.google.inject.Provides;
import com.piggyplugins.PiggyUtils.API.*;
import com.example.EthanApiPlugin.Collections.Equipment;
import com.example.Packets.MousePackets;
import com.example.Packets.PlayerPackets;
import com.example.Packets.WidgetPackets;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.*;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@PluginDescriptor(
        name = "Custom Swapper (EthanApi)",
        description = "<html>Custom hotkey swaps (20), parses command strings and executes actions." +
                "<br><br><b>Setup Instructions:</b>" +
                "<ul>" +
                "<li>Enter commands in the swap fields (e.g., 'item:Dragon dagger:wield').</li>" +
                "<li>Use one command per line.</li>" +
                "<li>Supported commands: item, remove, prayer, castontarget, lasttarget, enable, wait.</li>" +
                "</ul></html>",
        tags = {"custom", "swapper", "ethan", "piggy"}
)
public class MyNewPlugin extends Plugin {
    private static final Logger log = LoggerFactory.getLogger(MyNewPlugin.class);
    private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n').omitEmptyStrings().trimResults();

    private final Client client;
    private final KeyManager keyManager;
    private final CustomSwapperConfig config;
    private final ClientThread clientThread;
    private final OverlayManager overlayManager;
    private final CustomSwapperOverlay overlay;

    private ExecutorService executor;

    @Getter
    @Setter
    private Player currentTarget = null;
    private boolean targetLocked = false;
    @Getter
    private Player lockedTarget = null;

    @Inject
    private MyNewPlugin(Client client, KeyManager keyManager, CustomSwapperConfig config, ClientThread clientThread, OverlayManager overlayManager, CustomSwapperOverlay overlay) {
        this.client = client;
        this.keyManager = keyManager;
        this.config = config;
        this.clientThread = clientThread;
        this.overlayManager = overlayManager;
        this.overlay = overlay;
    }

    public void clearTarget() {
        this.currentTarget = null;
    }

    @Provides
    CustomSwapperConfig getConfig(ConfigManager manager) {
        return manager.getConfig(CustomSwapperConfig.class);
    }

    private final KeyListener hotkeyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            checkAndExecute(config.hotkey1(), config.swap1(), e);
            checkAndExecute(config.hotkey2(), config.swap2(), e);
            checkAndExecute(config.hotkey3(), config.swap3(), e);
            checkAndExecute(config.hotkey4(), config.swap4(), e);
            checkAndExecute(config.hotkey5(), config.swap5(), e);
            checkAndExecute(config.hotkey6(), config.swap6(), e);
            checkAndExecute(config.hotkey7(), config.swap7(), e);
            checkAndExecute(config.hotkey8(), config.swap8(), e);
            checkAndExecute(config.hotkey9(), config.swap9(), e);
            checkAndExecute(config.hotkey10(), config.swap10(), e);
            checkAndExecute(config.hotkey11(), config.swap11(), e);
            checkAndExecute(config.hotkey12(), config.swap12(), e);
            checkAndExecute(config.hotkey13(), config.swap13(), e);
            checkAndExecute(config.hotkey14(), config.swap14(), e);
            checkAndExecute(config.hotkey15(), config.swap15(), e);
            checkAndExecute(config.hotkey16(), config.swap16(), e);
            checkAndExecute(config.hotkey17(), config.swap17(), e);
            checkAndExecute(config.hotkey18(), config.swap18(), e);
            checkAndExecute(config.hotkey19(), config.swap19(), e);
            checkAndExecute(config.hotkey20(), config.swap20(), e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    @Override
    protected void startUp() {
        executor = Executors.newSingleThreadExecutor();
        keyManager.registerKeyListener(hotkeyListener);
        overlayManager.add(overlay);
        log.info("Custom Swapper started!");
    }

    @Override
    protected void shutDown() {
        keyManager.unregisterKeyListener(hotkeyListener);
        overlayManager.remove(overlay);
        if (executor != null) {
            executor.shutdownNow();
        }
        log.info("Custom Swapper stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged ev) {
        if (ev.getGameState() != GameState.LOGGED_IN) {
            clearTarget();
        }
    }

    @Subscribe
    public void onCommandExecuted(CommandExecuted event) {
        if (!"copycs".equalsIgnoreCase(event.getCommand())) {
            return;
        }

        final ItemContainer e = client.getItemContainer(InventoryID.EQUIPMENT);
        if (e == null) {
            log.error("CopyCS: Can't find equipment container.");
            return;
        }

        final StringBuilder sb = new StringBuilder();
        for (Item item : e.getItems()) {
            if (item == null || item.getId() <= 0) continue;
            sb.append("item:").append(item.getId()).append(":equip\n");
        }

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                new java.awt.datatransfer.StringSelection(sb.toString()), null);
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {
        MenuAction type = event.getMenuAction();
        if (type == MenuAction.PLAYER_FIRST_OPTION || type == MenuAction.PLAYER_SECOND_OPTION ||
                type == MenuAction.PLAYER_THIRD_OPTION || type == MenuAction.PLAYER_FOURTH_OPTION ||
                type == MenuAction.PLAYER_FIFTH_OPTION || type == MenuAction.PLAYER_SIXTH_OPTION ||
                type == MenuAction.PLAYER_SEVENTH_OPTION || type == MenuAction.PLAYER_EIGHTH_OPTION) {

            int playerIndex = event.getMenuEntry().getIdentifier();
            List<Player> players = client.getPlayers();
            if (playerIndex >= 0 && playerIndex < players.size()) {
                Player clicked = players.get(playerIndex);
                if (clicked != null) {
                    if (targetLocked && clicked == lockedTarget) {
                        targetLocked = false;
                        lockedTarget = null;
                        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Target unlocked", null);
                    } else {
                        targetLocked = true;
                        lockedTarget = clicked;
                        setCurrentTarget(clicked);
                        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Locked target: " + clicked.getName(), null);
                    }
                    log.debug("Target status - Locked: {} Player: {}", targetLocked, clicked.getName());
                }
            }
        }
    }

    private void checkAndExecute(Keybind keybind, String commands, KeyEvent e) {
        if (keybind == null || commands == null || commands.isEmpty() || !keybind.matches(e)) {
            return;
        }

        executor.submit(() ->
        {
            decode(commands);
            try {
                Thread.sleep(100); // Debounce
            } catch (InterruptedException ignored) {
            }
        });
    }

    private Optional<Prayer> stringToPrayer(String name) {
        String prayerName = name.toUpperCase().replace(" ", "_");
        return java.util.Arrays.stream(Prayer.values()).filter(p -> p.name().equals(prayerName)).findFirst();
    }

    private void decode(String script) {
        if (script == null || script.trim().isEmpty()) return;
        final Iterable<String> lines = NEWLINE_SPLITTER.split(script.replace(",", "\n"));

        for (String raw : lines) {
            String line = raw.trim();
            if (line.isEmpty() || line.startsWith("//")) continue;

            try {
                int firstColon = line.indexOf(':');
                if (firstColon == -1) {
                    dispatchError("Invalid syntax: " + line);
                    continue;
                }

                String type = line.substring(0, firstColon).trim().toLowerCase();
                String rest = line.substring(firstColon + 1);

                String target;
                String action = "";

                int lastColon = rest.lastIndexOf(':');
                if (lastColon > 0 && lastColon < rest.length() - 1) {
                    target = rest.substring(0, lastColon).trim();
                    action = rest.substring(lastColon + 1).trim();
                } else {
                    target = rest.trim();
                }

                if (target.isEmpty()) {
                    dispatchError("Missing target: " + line);
                    continue;
                }

                switch (type) {
                    case "item":
                        if (action.isEmpty()) {
                            dispatchError("Missing action for item: " + target);
                            continue;
                        }
                        log.debug("Executing item command: '{}' with arg: '{}'", target, action);
                        InventoryUtil.useItemNoCase(target, action);
                        break;

                    case "remove":
                        log.debug("Executing remove command for item: {}", target);
                        Equipment.search().nameContainsNoCase(target).first().ifPresent(item -> {
                            MousePackets.queueClickPacket();
                            WidgetPackets.queueWidgetAction(item, "Remove");
                        });
                        break;

                    case "prayer":
                        log.debug("Executing prayer command: {} {}", target, action);
                        final String finalAction = action;
                        stringToPrayer(target).ifPresent(prayer -> {
                            boolean isActive = client.getVarbitValue(prayer.getVarbit()) == 1;
                            if (finalAction.equalsIgnoreCase("on") && !isActive) {
                                PrayerUtil.togglePrayer(prayer);
                            } else if (finalAction.equalsIgnoreCase("off") && isActive) {
                                PrayerUtil.togglePrayer(prayer);
                            } else if (finalAction.isEmpty()) {
                                PrayerUtil.togglePrayer(prayer);
                            }
                        });
                        break;

                    case "castontarget":
                        log.debug("Executing cast spell: {}", target);
                        if (lockedTarget != null) {
                            clientThread.invoke(() -> {
                                Widget spellWidget = SpellUtil.getSpellWidget(client, target);
                                if (spellWidget != null) {
                                    MousePackets.queueClickPacket();
                                    PlayerPackets.queueWidgetOnPlayer(lockedTarget, spellWidget);
                                }
                            });
                        }
                        break;

                    case "lasttarget":
                        log.debug("Executing last target action: {}", target);
                        if (lockedTarget != null) {
                            PlayerPackets.queuePlayerAction(lockedTarget, target);
                        }
                        break;

                    case "enable":
                        log.debug("Executing enable special attack");
                        Widget specOrb = client.getWidget(160, 36);
                        if (specOrb != null) {
                            MousePackets.queueClickPacket();
                            WidgetPackets.queueWidgetAction(specOrb, "Use");
                        }
                        break;

                    case "wait":
                        try {
                            String[] delays = target.split("-");
                            int minDelay = Integer.parseInt(delays[0]);
                            int maxDelay = delays.length > 1 ? Integer.parseInt(delays[1]) : minDelay;
                            log.debug("Executing wait command: {}ms to {}ms", minDelay, maxDelay);
                            Thread.sleep(MathUtil.random(minDelay, maxDelay));
                        } catch (Exception ex) {
                            dispatchError("Invalid wait format. Use wait:min-max or wait:fixed");
                        }
                        break;

                    default:
                        log.debug("Unknown command received: {}", type);
                        dispatchError("Unknown command: " + type);
                        break;
                }
            } catch (Exception ex) {
                dispatchError("Error executing command: " + line);
                log.error("Error executing command", ex);
            }
        }
    }

    private void dispatchError(String error) {
        String str = "<col=ff00ff>Custom Swapper</col> error: " + error;
        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str, null);
    }

    public void processAttackTimerCommand(String command) {
        String[] parts = command.split(" ");
        for (String part : parts) {
            if (part.startsWith("waitforattacktimer:")) {
                // Logic for waiting for attack timer would go here, if available in the APIs
            } else if (part.startsWith("equipt:")) {
                String itemName = part.split(":")[1];
                InventoryUtil.useItemNoCase(itemName, "Wield", "Wear");
            } else if (part.equals("lasttarget:attack")) {
                if (lockedTarget != null) {
                    PlayerPackets.queuePlayerAction(lockedTarget, "Attack");
                }
            }
        }
    }
}
