package me.alpha432.oyvey.mixin;

import me.alpha432.oyvey.OyVey;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

public class QuantumLoader
        implements IFMLLoadingPlugin {

    public QuantumLoader() {
        OyVey.LOGGER.info("\n\nLoading mixins by Alpha432");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.autism.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
        OyVey.LOGGER.info(MixinEnvironment.getDefaultEnvironment().getObfuscationContext());
    }

    public String[] getASMTransformerClass() {
        return new String[0];
    }

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
        data.get("runtimeDeobfuscationEnabled");
    }

    public String getAccessTransformerClass() {
        return null;
    }
}

