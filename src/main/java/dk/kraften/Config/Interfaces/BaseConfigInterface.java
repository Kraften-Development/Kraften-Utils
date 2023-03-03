package dev.bimulu.bande.Config.Interfaces;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public interface BaseConfigInterface {

    String getPath();

    File getFile();

    FileConfiguration getConfiguration();

    void createFile() throws IOException;

    void change(String key, Object value);
}
