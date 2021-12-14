package com.codealong.demoapis.controllers;

import com.codealong.demoapis.domains.Color;
import com.codealong.demoapis.services.ColorService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/colors")
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/hex/{hexCode}")
    public Color getByHexCode(@PathVariable String hexCode) {
        return colorService.getColorByHexCode(hexCode);
    }

    @GetMapping("/rgb/{rgbCode}")
    public Color getByRgbCode(@PathVariable String rgbCode) {
        return colorService.getColorByRgbCode(rgbCode);
    }
}
