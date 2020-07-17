package io.github.yeonho1.log;

import io.github.yeonho1.BlockLogPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogManager {
    private File file;
    private File logFolder;
    public ArrayList<String> logs;
    private SimpleDateFormat format;
    public LogManager(BlockLogPlugin plugin) {
        logFolder = new File(plugin.getDataFolder(), "log");
        format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String strf = format.format(new Date());
        file = new File(logFolder, strf + ".log");
        logs = new ArrayList<>();
    }

    public void addLog(String log) {
        String strf = format.format(new Date());
        logs.add("[" + strf + "] " + log + "\n");
    }

    public void save() {
        file.getParentFile().mkdirs();
        try {
            FileWriter fw = new FileWriter(file, true);
            for (int i = 0; i < logs.size(); i++) {
                fw.write(logs.get(i));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
