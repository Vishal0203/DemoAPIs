package com.codealong.demoapis.bootstrap;

import com.codealong.demoapis.domains.Color;
import com.codealong.demoapis.services.ColorService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {
    private final ColorService colorService;
    private final Gson gson = new Gson();

    public BootstrapData(ColorService colorService) {
        this.colorService = colorService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("loading colors to database..");
        List<Color> colorList = readJson();
        colorService.saveAll(colorList);
        System.out.printf("Colors loaded : %d%n", colorList.size());
    }

    private List<Color> readJson() throws IOException {
        List<Color> colorList = new ArrayList<>();
        Resource resource = new ClassPathResource("json/colors.json");
        InputStream stream = resource.getInputStream();
        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

        for (JsonElement color : jsonArray) {
            JsonObject colorObject = color.getAsJsonObject();
            String name = colorObject.get("name").getAsString();
            String hex = colorObject.get("hex").getAsString();
            List<String> rgbArray = new ArrayList<>();

            for (JsonElement val : colorObject.get("rgb").getAsJsonArray()) {
                rgbArray.add(val.getAsString());
            }

            String rgb = StringUtils.join(rgbArray);
            colorList.add(new Color(hex, name, rgb));
        }

        return colorList;
    }
}
