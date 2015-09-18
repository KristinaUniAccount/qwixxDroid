package com.example.android.qwixxdroid;

/**
 * Created by Benjamin on 13.07.2015.
 */
public class MyButton {
    private int id;
    private boolean pressed;
    private boolean pressable;
    private int numberInRow;
    private int color;
    private int row;
    private int background;
    private int backgroundCrossed;

    MyButton(){

    }

    MyButton(int id, int numberInRow, int color, int row){
        setId(id);
        setPressable(true);
        setPressed(false);
        setNumberInRow(numberInRow);
        setColor(color);
        setRow(row);
        switch (color){
            case MyColor.RED:
                setBackground(R.drawable.red_button);
                setBackgroundCrossed(R.drawable.red_button_crossed);
                break;
            case MyColor.YELLOW:
                setBackground(R.drawable.yellow_button);
                setBackgroundCrossed(R.drawable.yellow_button_crossed);
                break;
            case MyColor.GREEN:
                setBackground(R.drawable.green_button);
                setBackgroundCrossed(R.drawable.green_button_crossed);
                break;
            case MyColor.BLUE:
                setBackground(R.drawable.blue_button);
                setBackgroundCrossed(R.drawable.blue_button_crossed);
                break;
            default:
                break;
        }
    }

    public int getNumberInRow() {
        return this.numberInRow;
    }

    public int getId() {
        return this.id;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    public void setNumberInRow(int numberInRow) {
        this.numberInRow = numberInRow;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public void setPressable(boolean pressable) {
        this.pressable = pressable;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getBackgroundCrossed() {
        return backgroundCrossed;
    }

    public void setBackgroundCrossed(int backgroundCrossed) {
        this.backgroundCrossed = backgroundCrossed;
    }
}
