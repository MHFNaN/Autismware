package me.alpha432.oyvey;

import me.alpha432.oyvey.features.modules.misc.RPC;
import me.alpha432.oyvey.manager.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = "AutismWare", name = "Autism", version = "1.1.1")
public class OyVey {
    public static final String MODID = "Autismware";
    public static final String MODNAME = "AutismWare";
    public static final String MODVER = "1.1.1";
    public static final Logger LOGGER = LogManager.getLogger("Autismware");
    public static TotemPopManager totemPopManager;
    public static TimerManager timerManager;
    public static CommandManager commandManager;
    public static FriendManager friendManager;
    public static ModuleManager moduleManager;
    public static PacketManager packetManager;
    public static ColorManager colorManager;
    public static HoleManager holeManager;
    public static InventoryManager inventoryManager;
    public static PotionManager potionManager;
    public static RotationManager rotationManager;
    public static PositionManager positionManager;
    public static SpeedManager speedManager;
    public static ReloadManager reloadManager;
    public static FileManager fileManager;
    public static ConfigManager configManager;
    public static ServerManager serverManager;
    public static EventManager eventManager;
    public static TextManager textManager;
    @Mod.Instance
    public static OyVey INSTANCE;
    private static boolean unloaded;

    static {
        unloaded = false;
    }

    public static void load() {
        LOGGER.info("\n\nLoading Autism");
        unloaded = false;
        if (reloadManager != null) {
            reloadManager.unload();
            reloadManager = null;
        }
        totemPopManager = new TotemPopManager();
        timerManager = new TimerManager();
        textManager = new TextManager();
        commandManager = new CommandManager();
        friendManager = new FriendManager();
        moduleManager = new ModuleManager();
        rotationManager = new RotationManager();
        packetManager = new PacketManager();
        eventManager = new EventManager();
        speedManager = new SpeedManager();
        potionManager = new PotionManager();
        inventoryManager = new InventoryManager();
        serverManager = new ServerManager();
        fileManager = new FileManager();
        colorManager = new ColorManager();
        positionManager = new PositionManager();
        configManager = new ConfigManager();
        holeManager = new HoleManager();
        LOGGER.info("Managers loaded.");
        moduleManager.init();
        LOGGER.info("Modules loaded.");
        configManager.init();
        eventManager.init();
        LOGGER.info("EventManager loaded.");
        textManager.init(true);
        moduleManager.onLoad();
        if (moduleManager.getModuleByClass(RPC.class).isEnabled()) {
            DiscordPresence.start();
        }
        LOGGER.info("AutismWare unloaded enjoy the last 30 mins left on your computer!\n");
    }

    public static void unload(boolean unload) {
        LOGGER.info("\n\nUnloaded AutismWare");
        if (unload) {
            reloadManager = new ReloadManager();
            reloadManager.init(commandManager != null ? commandManager.getPrefix() : ".");
        }
        OyVey.onUnload();
        timerManager = null;
        eventManager = null;
        friendManager = null;
        speedManager = null;
        holeManager = null;
        positionManager = null;
        rotationManager = null;
        configManager = null;
        commandManager = null;
        colorManager = null;
        serverManager = null;
        fileManager = null;
        potionManager = null;
        inventoryManager = null;
        moduleManager = null;
        textManager = null;
        LOGGER.info("AutismWare\n");
    }

    public static void reload() {
        OyVey.unload(false);
        OyVey.load();
    }

    public static void onUnload() {
        if (!unloaded) {
            eventManager.onUnload();
            moduleManager.onUnload();
            configManager.saveConfig(OyVey.configManager.config.replaceFirst("Autismcompiled/", ""));
            moduleManager.onUnloadPost();
            unloaded = true;
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("You drank gorilla glue as a child I can tell -Weaponizeautism");
        LOGGER.info("Amrit1 is a fucking skid");
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle("Autismware v" + MODVER);

        OyVey.load();
    }

}
