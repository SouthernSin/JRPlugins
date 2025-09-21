package com.example.UpkeepPlugin;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("CustomSwapper")
public interface CustomSwapperConfig extends Config {

    @ConfigSection(
            name = "Overlay Settings",
            description = "Settings for the target overlay",
            position = -2
    )
    String overlaySection = "overlaySection";

    @ConfigItem(
            keyName = "targetOverlay",
            name = "Target Overlay",
            description = "Enable an overlay on your locked target",
            position = 0,
            section = overlaySection
    )
    default boolean targetOverlay() {
        return true;
    }

    @ConfigItem(
            keyName = "overlayWidth",
            name = "Overlay Width",
            description = "The width of the target overlay.",
            position = 1,
            section = overlaySection
    )
    default int overlayWidth() {
        return 2;
    }

    @ConfigItem(
            keyName = "overlayColor",
            name = "Overlay Color",
            description = "The color of the target overlay.",
            position = 2,
            section = overlaySection
    )
    default Color overlayColor() {
        return Color.CYAN;
    }

    @ConfigSection(
            name = "Hotkey Settings",
            description = "Configure hotkeys and swap commands",
            position = 0
    )
    String hotkeySection = "hotkeySection";

    @ConfigItem(
            keyName = "hotkey1",
            name = "Hotkey 1",
            description = "First hotkey to trigger swap commands",
            position = 1,
            section = hotkeySection
    )
    default Keybind hotkey1() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap1",
            name = "Swap 1",
            description = "Commands for Hotkey 1 (e.g., 'item:11802:equip\nprayer:PROTECT_FROM_MELEE:on')",
            position = 2,
            section = hotkeySection
    )
    default String swap1() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey2",
            name = "Hotkey 2",
            description = "Second hotkey to trigger swap commands",
            position = 3,
            section = hotkeySection
    )
    default Keybind hotkey2() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap2",
            name = "Swap 2",
            description = "Commands for Hotkey 2",
            position = 4,
            section = hotkeySection
    )
    default String swap2() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey3",
            name = "Hotkey 3",
            description = "Third hotkey to trigger swap commands",
            position = 5,
            section = hotkeySection
    )
    default Keybind hotkey3() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap3",
            name = "Swap 3",
            description = "Commands for Hotkey 3",
            position = 6,
            section = hotkeySection
    )
    default String swap3() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey4",
            name = "Hotkey 4",
            description = "Fourth hotkey to trigger swap commands",
            position = 7,
            section = hotkeySection
    )
    default Keybind hotkey4() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap4",
            name = "Swap 4",
            description = "Commands for Hotkey 4",
            position = 8,
            section = hotkeySection
    )
    default String swap4() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey5",
            name = "Hotkey 5",
            description = "Fifth hotkey to trigger swap commands",
            position = 9,
            section = hotkeySection
    )
    default Keybind hotkey5() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap5",
            name = "Swap 5",
            description = "Commands for Hotkey 5",
            position = 10,
            section = hotkeySection
    )
    default String swap5() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey6",
            name = "Hotkey 6",
            description = "Sixth hotkey to trigger swap commands",
            position = 11,
            section = hotkeySection
    )
    default Keybind hotkey6() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap6",
            name = "Swap 6",
            description = "Commands for Hotkey 6",
            position = 12,
            section = hotkeySection
    )
    default String swap6() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey7",
            name = "Hotkey 7",
            description = "Seventh hotkey to trigger swap commands",
            position = 13,
            section = hotkeySection
    )
    default Keybind hotkey7() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap7",
            name = "Swap 7",
            description = "Commands for Hotkey 7",
            position = 14,
            section = hotkeySection
    )
    default String swap7() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey8",
            name = "Hotkey 8",
            description = "Eighth hotkey to trigger swap commands",
            position = 15,
            section = hotkeySection
    )
    default Keybind hotkey8() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap8",
            name = "Swap 8",
            description = "Commands for Hotkey 8",
            position = 16,
            section = hotkeySection
    )
    default String swap8() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey9",
            name = "Hotkey 9",
            description = "Ninth hotkey to trigger swap commands",
            position = 17,
            section = hotkeySection
    )
    default Keybind hotkey9() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap9",
            name = "Swap 9",
            description = "Commands for Hotkey 9",
            position = 18,
            section = hotkeySection
    )
    default String swap9() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey10",
            name = "Hotkey 10",
            description = "Tenth hotkey to trigger swap commands",
            position = 19,
            section = hotkeySection
    )
    default Keybind hotkey10() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap10",
            name = "Swap 10",
            description = "Commands for Hotkey 10",
            position = 20,
            section = hotkeySection
    )
    default String swap10() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey11",
            name = "Hotkey 11",
            description = "Eleventh hotkey to trigger swap commands",
            position = 21,
            section = hotkeySection
    )
    default Keybind hotkey11() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap11",
            name = "Swap 11",
            description = "Commands for Hotkey 11",
            position = 22,
            section = hotkeySection
    )
    default String swap11() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey12",
            name = "Hotkey 12",
            description = "Twelfth hotkey to trigger swap commands",
            position = 23,
            section = hotkeySection
    )
    default Keybind hotkey12() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap12",
            name = "Swap 12",
            description = "Commands for Hotkey 12",
            position = 24,
            section = hotkeySection
    )
    default String swap12() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey13",
            name = "Hotkey 13",
            description = "Thirteenth hotkey to trigger swap commands",
            position = 25,
            section = hotkeySection
    )
    default Keybind hotkey13() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap13",
            name = "Swap 13",
            description = "Commands for Hotkey 13",
            position = 26,
            section = hotkeySection
    )
    default String swap13() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey14",
            name = "Hotkey 14",
            description = "Fourteenth hotkey to trigger swap commands",
            position = 27,
            section = hotkeySection
    )
    default Keybind hotkey14() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap14",
            name = "Swap 14",
            description = "Commands for Hotkey 14",
            position = 28,
            section = hotkeySection
    )
    default String swap14() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey15",
            name = "Hotkey 15",
            description = "Fifteenth hotkey to trigger swap commands",
            position = 29,
            section = hotkeySection
    )
    default Keybind hotkey15() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap15",
            name = "Swap 15",
            description = "Commands for Hotkey 15",
            position = 30,
            section = hotkeySection
    )
    default String swap15() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey16",
            name = "Hotkey 16",
            description = "Sixteenth hotkey to trigger swap commands",
            position = 31,
            section = hotkeySection
    )
    default Keybind hotkey16() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap16",
            name = "Swap 16",
            description = "Commands for Hotkey 16",
            position = 32,
            section = hotkeySection
    )
    default String swap16() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey17",
            name = "Hotkey 17",
            description = "Seventeenth hotkey to trigger swap commands",
            position = 33,
            section = hotkeySection
    )
    default Keybind hotkey17() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap17",
            name = "Swap 17",
            description = "Commands for Hotkey 17",
            position = 34,
            section = hotkeySection
    )
    default String swap17() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey18",
            name = "Hotkey 18",
            description = "Eighteenth hotkey to trigger swap commands",
            position = 35,
            section = hotkeySection
    )
    default Keybind hotkey18() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap18",
            name = "Swap 18",
            description = "Commands for Hotkey 18",
            position = 36,
            section = hotkeySection
    )
    default String swap18() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey19",
            name = "Hotkey 19",
            description = "Nineteenth hotkey to trigger swap commands",
            position = 37,
            section = hotkeySection
    )
    default Keybind hotkey19() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap19",
            name = "Swap 19",
            description = "Commands for Hotkey 19",
            position = 38,
            section = hotkeySection
    )
    default String swap19() {
        return "";
    }

    @ConfigItem(
            keyName = "hotkey20",
            name = "Hotkey 20",
            description = "Twentieth hotkey to trigger swap commands",
            position = 39,
            section = hotkeySection
    )
    default Keybind hotkey20() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "swap20",
            name = "Swap 20",
            description = "Commands for Hotkey 20",
            position = 40,
            section = hotkeySection
    )
    default String swap20() {
        return "";
    }
}
