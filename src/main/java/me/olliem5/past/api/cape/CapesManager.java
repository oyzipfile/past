package me.olliem5.past.api.cape;

import me.olliem5.past.Past;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CapesManager {
    public List<UUID> uuidList = new ArrayList<>();

    public CapesManager() {
        try {
            URL pastCapesGitHub = new URL("https://raw.githubusercontent.com/olliem5/past-resources/main/past-capes.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pastCapesGitHub.openStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                uuidList.add(UUID.fromString(line));
            }
        } catch (Exception e) {
            Past.log("Cape reading from URL failed! Do you an internet connection?");
        }
    }

    public boolean hasCape(UUID uuid) {
        return uuidList.contains(uuid);
    }
}
