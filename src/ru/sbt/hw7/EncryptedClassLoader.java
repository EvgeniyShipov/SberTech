package ru.sbt.hw7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class EncryptedClassLoader extends ClassLoader {

    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] byteArray = Files.readAllBytes(Paths.get(dir + "/" + name + ".class"));
            for (int i = 0; i < byteArray.length; i++) {
                byteArray[i] = (byte) (byteArray[i] + key.getBytes().length);
            }
            return defineClass(name, byteArray, 0, byteArray.length);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
