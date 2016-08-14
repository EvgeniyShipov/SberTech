package ru.sbt.hw7;

import java.net.MalformedURLException;
import java.net.URL;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url = new URL(pluginRootDirectory + "/" + pluginName + "/");
        PluginClassLoader loader = new PluginClassLoader(new URL[]{url});
        Plugin plugin = (Plugin) loader.loadClass(pluginClassName).newInstance();
        return plugin;
    }
}


