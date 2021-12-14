package com.codealong.demoapis.repositories;

import com.codealong.demoapis.domains.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, String> {
    Color findColorByHex(String hexCode);
    Color findColorByRgb(String rgbCode);
}
