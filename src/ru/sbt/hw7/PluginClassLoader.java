package ru.sbt.hw7;


import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.contains("ru.sbt.hw7.Plugin")) {
            return super.loadClass(name);
        } else return findClass(name);
    }
}
