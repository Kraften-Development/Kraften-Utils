package dev.bimulu.bande.Config;

import dev.bimulu.bande.Config.Exceptions.ErrorFileException;
import dev.bimulu.bande.Config.Interfaces.BaseConfigInterface;
import dev.bimulu.bande.Objects.Utils.ConsoleUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BaseConfig implements BaseConfigInterface {

    private String name;

    private String path;
    private File file;
    private FileConfiguration configuration;

    public BaseConfig(String name, String path) throws ErrorFileException, IOException {
        this.name = name;
        this.path = path;

        this.file = new File(path);
        this.configuration = YamlConfiguration.loadConfiguration(file);

        if (!file.exists() || file == null) {
            createFile();
        } else {
            throw new ErrorFileException();
        }
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public File getFile() {
        if (!file.exists() || file == null) {
            createFile();
        }

        return file;
    }

    @Override
    public FileConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public void createFile() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                ConsoleUtils.print("&aCreated '" + name + "'");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void change(String key, Object value) {
        try {
            configuration.set(key, value);
            configuration.save(file);
        } catch (IOException e) {
            ConsoleUtils.print("&cCould'nt save '" + value + "' to key '" + key + "' to file '" + name + "'");
        }
    }
}
