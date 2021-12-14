package com.codealong.demoapis.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Color {

    @Id
    private String hex;
    private String name;
    private String rgb;

    public Color() {
    }

    public Color(String hex, String name, String rgb) {
        this.hex = hex;
        this.name = name;
        this.rgb = rgb;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "Color{" +
                "hex='" + hex + '\'' +
                ", name='" + name + '\'' +
                ", rgb='" + rgb + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(hex, color.hex) && Objects.equals(name, color.name) && Objects.equals(rgb, color.rgb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hex, name, rgb);
    }
}
