package org.example.day10.box;

public class ColorBox <T, C> extends Box<T>{
    private C color;

    public ColorBox(T content, C color) {
        super(content);
        this.color = color;
    }

    public C getColor() {
        return color;
    }

    public void setColor(C color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorBox{" +
                "color= " + color +
                '}';
    }

    public static void main(String[] args) {
        ColorBox<String, String> colorBox  =new ColorBox<>("pen", "red");
        System.out.println(colorBox);
    }
}
