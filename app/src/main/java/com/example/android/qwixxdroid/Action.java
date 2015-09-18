package com.example.android.qwixxdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benjamin on 13.07.2015.
 */
public class Action {
    private MyButton button;
    private boolean fail;
    private boolean rowLock;
    private List<MyButton> deactivatedButtons = new ArrayList<MyButton>();


    public MyButton getButton() {
        return button;
    }

    public void setButton(MyButton button) {
        this.button = button;
    }

    public boolean isFail() {
        return fail;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    public boolean isRowLock() {
        return rowLock;
    }

    public void setRowLock(boolean rowLock) {
        this.rowLock = rowLock;
    }

    public List<MyButton> getDeactivatedButtons() {
        return deactivatedButtons;
    }

    public void setDeactivatedButtons(List<MyButton> deactivatedButtons) {
        this.deactivatedButtons = deactivatedButtons;
    }
}
