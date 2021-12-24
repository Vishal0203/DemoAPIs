package com.codealong.demoapis.services;

import com.codealong.demoapis.domains.Color;
import com.codealong.demoapis.repositories.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    public List<Color> saveAll(List<Color> colorList) {
        return colorRepository.saveAll(colorList);
    }

    public Color addColor(Color color) {
        return colorRepository.save(color);
    }

    public Color getColorByHexCode(String hexCode) {
        return colorRepository.findColorByHex(hexCode);
    }

    public Color getColorByRgbCode(String rgbCode) {
        return colorRepository.findColorByRgb(rgbCode);
    }
}
