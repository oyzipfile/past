package me.olliem5.past;

import me.olliem5.past.cape.CapesManager;
import me.olliem5.past.command.CommandManager;
import me.olliem5.past.event.ForgeEvents;
import me.olliem5.past.font.CustomFontRenderer;
import me.olliem5.past.friends.FriendsManager;
import me.olliem5.past.gui.click.clickone.ClickGUIOne;
import me.olliem5.past.gui.click.clicktwo.ClickGUITwo;
import me.olliem5.past.gui.editor.component.HudComponentManager;
import me.olliem5.past.gui.editor.screen.HudEditor;
import me.olliem5.past.module.ModuleManager;
import me.olliem5.past.settings.SettingsManager;
import me.olliem5.past.util.config.ConfigUtil;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;

import java.awt.*;

@Mod(
        name = Past.name,
        modid = Past.modid,
        version = Past.version
)

public class Past {
    public static final String name = "Past Utility Mod";
    public static final String modid = "past";
    public static final String version = "1.4";
    public static final String author = "olliem5";
    public static final String github = "https://github.com/olliem5/past";
    public static final String appid = "754509326902886411";
    public static String prefix = "@";
    public static String nameversion = name + " " + version;

    public static EventBus EVENT_BUS;
    public static ForgeEvents forgeEvents;
    public static SettingsManager settingsManager;
    public static ModuleManager moduleManager;
    public static CommandManager commandManager;
    public static FriendsManager friendsManager;
    public static CustomFontRenderer customFontRenderer;
    public static CapesManager capesManager;
    public static HudComponentManager hudComponentManager;
    public static ClickGUIOne clickGUIOne;
    public static ClickGUITwo clickGUITwo;
    public static HudEditor hudEditor;
    public static ConfigUtil configUtil;

    @Mod.EventHandler
    public void pastPreInitialize(FMLPreInitializationEvent event) {
        Display.setTitle(nameversion);
    }

    //Initializing the client
    @Mod.EventHandler
    public void pastInitialize(FMLInitializationEvent event) {
        System.out.println("[" + nameversion + "]" + " " + "Starting client initialization!");

        EVENT_BUS = new EventManager();
        System.out.println("[" + nameversion + "]" + " " + "Alpine Events Initialized!");

        forgeEvents = new ForgeEvents();
        System.out.println("[" + nameversion + "]" + " " + "Forge Events Initialized!");

        settingsManager = new SettingsManager();
        System.out.println("[" + nameversion + "]" + " " + "Settings Initialized!");

        moduleManager = new ModuleManager();
        System.out.println("[" + nameversion + "]" + " " + "Modules Initialized!");

        commandManager = new CommandManager();
        System.out.println("[" + nameversion + "]" + " " + "Commands Initialized!");

        friendsManager = new FriendsManager();
        System.out.println("[" + nameversion + "]" + " " + "Friends Initialized!");

        customFontRenderer = new CustomFontRenderer(new Font("Arial", 0, 18), true, false);
        System.out.println("[" + nameversion + "]" + " " + "Custom Font Renderer Initialized! (Author 086)");

        capesManager = new CapesManager();
        System.out.println("[" + nameversion + "]" + " " + "Capes Initialized!");

        hudComponentManager = new HudComponentManager();
        System.out.println("[" + nameversion + "]" + " " + "HUD Components Initialized!");

        clickGUIOne = new ClickGUIOne();
        System.out.println("[" + nameversion + "]" + " " + "ClickGUI One Initialized!");

        clickGUITwo = new ClickGUITwo();
        System.out.println("[" + nameversion + "]" + " " + "ClickGUI Two Initialized!");

        hudEditor = new HudEditor();
        System.out.println("[" + nameversion + "]" + " " + "HUDEditor Initialized!");

        configUtil = new ConfigUtil();
        System.out.println("[" + nameversion + "]" + " " + "Config Initialized!");

        CommandManager.init();
        MinecraftForge.EVENT_BUS.register(new CommandManager());
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());

        System.out.println("[" + nameversion + "]" + " " + "Client has finished initializing!");
    }
}