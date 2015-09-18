package com.example.android.qwixxdroid;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ClassicActivity extends Activity {

    private int fails;
    private MyButton[][] buttons = new MyButton[4][12];

    private List<Action> actions = new ArrayList<>();

    private boolean resizable;
    private boolean resized;

    private int firstRowCrossed;
    private int secondRowCrossed;
    private int thirdRowCrossed;
    private int fourthRowCrossed;

    private boolean firstRowClosed;
    private boolean secondRowClosed;
    private boolean thirdRowClosed;
    private boolean fourthRowClosed;

    public void setFails(int fails) {
        this.fails = fails;
    }

    public int getFails() {
        return fails;
    }

    public MyButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(MyButton[][] buttons) {
        this.buttons = buttons;
    }

    public int getFirstRowCrossed() {
        return firstRowCrossed;
    }

    public void setFirstRowCrossed(int firstRowCrossed) {
        this.firstRowCrossed = firstRowCrossed;
    }

    public int getSecondRowCrossed() {
        return secondRowCrossed;
    }

    public void setSecondRowCrossed(int secondRowCrossed) {
        this.secondRowCrossed = secondRowCrossed;
    }

    public int getThirdRowCrossed() {
        return thirdRowCrossed;
    }

    public void setThirdRowCrossed(int thirdRowCrossed) {
        this.thirdRowCrossed = thirdRowCrossed;
    }

    public int getFourthRowCrossed() {
        return fourthRowCrossed;
    }

    public void setFourthRowCrossed(int fourthRowCrossed) {
        this.fourthRowCrossed = fourthRowCrossed;
    }

    public boolean isResized() {
        return resized;
    }

    public void setResized(boolean resized) {
        this.resized = resized;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isFirstRowClosed() {
        return firstRowClosed;
    }

    public void setFirstRowClosed(boolean firstRowClosed) {
        this.firstRowClosed = firstRowClosed;
    }

    public boolean isSecondRowClosed() {
        return secondRowClosed;
    }

    public void setSecondRowClosed(boolean secondRowClosed) {
        this.secondRowClosed = secondRowClosed;
    }

    public boolean isThirdRowClosed() {
        return thirdRowClosed;
    }

    public void setThirdRowClosed(boolean thirdRowClosed) {
        this.thirdRowClosed = thirdRowClosed;
    }

    public boolean isFourthRowClosed() {
        return fourthRowClosed;
    }

    public void setFourthRowClosed(boolean fourthRowClosed) {
        this.fourthRowClosed = fourthRowClosed;
    }

    // Main functions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_classic);

        makePreparations();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Button functions

    public void resetButtonClicked(View view) {

        resetFailBox(R.id.first_fail);
        resetFailBox(R.id.second_fail);
        resetFailBox(R.id.third_fail);
        resetFailBox(R.id.fourth_fail);

        setFails(0);
        setFirstRowCrossed(0);
        setSecondRowCrossed(0);
        setThirdRowCrossed(0);
        setFourthRowCrossed(0);

        setFirstRowClosed(false);
        setSecondRowClosed(false);
        setThirdRowClosed(false);
        setFourthRowClosed(false);

        makeButtons();
        resetColorButtons();
        setActions(new ArrayList<Action>());

        displayScore();

    }

    public void undoButtonClicked(View view) {
        if(actions.size() > 0) {
            int last = actions.size()-1;
            Action lastAction = actions.get(last);
            undoAction(lastAction);
            actions.remove(last);
        }
    }

    public void resizeButtonClicked(View view) {
        if(isResizable()) {
            if (isResized()) {
                resizeLayout(R.id.first_row_layout, 50);
                resizeLayout(R.id.second_row_layout, 50);
                resizeLayout(R.id.third_row_layout, 50);
                resizeLayout(R.id.fourth_row_layout, 50);
                resizeLayout(R.id.fails_layout, 50);
                resizeLayout(R.id.score_layout, 50);
                resizeLayout(R.id.action_buttons_layout, 36);
                setResized(false);
            } else {
                resizeLayout(R.id.first_row_layout, 100);
                resizeLayout(R.id.second_row_layout, 100);
                resizeLayout(R.id.third_row_layout, 100);
                resizeLayout(R.id.fourth_row_layout, 100);
                resizeLayout(R.id.fails_layout, 100);
                resizeLayout(R.id.score_layout, 100);
                resizeLayout(R.id.action_buttons_layout, 72);
                setResized(true);
            }
        }
    }


    // Cross button functions

    public void crossFail(View view) {
        switch (getFails()){
            case 0:
                checkFailBox(R.id.first_fail);
                break;
            case 1:
                checkFailBox(R.id.second_fail);
                break;
            case 2:
                checkFailBox(R.id.third_fail);
                break;
            case 3:
                checkFailBox(R.id.fourth_fail);
                break;
            default:
                break;
        }
        displayScore();
    }

    private void checkFailBox(int id) {
        View failBox = findViewById(id);
        failBox.setBackgroundResource(R.drawable.box_frame_crossed);
        setFails(getFails() + 1);
        Action failAction = new Action();
        failAction.setFail(true);
        MyButton failButton = new MyButton();
        failButton.setId(id);
        failAction.setButton(failButton);
        actions.add(failAction);
    }

    public void undoFail(View view) {
        switch (getFails()){
            case 1:
                resetFailBox(R.id.first_fail);
                break;
            case 2:
                resetFailBox(R.id.second_fail);
                break;
            case 3:
                resetFailBox(R.id.third_fail);
                break;
            case 4:
                resetFailBox(R.id.fourth_fail);
                break;
            default:
                break;
        }
        displayScore();
    }

    private void resetFailBox(int id){
        View failBox = findViewById(id);
        failBox.setBackgroundResource(R.drawable.box_frame);
        setFails(getFails() - 1);
    }

    public void numberButtonClick(View view) {
        MyButton thisButton = findButtonById(view.getId());
        if (thisButton.isPressable()) {
            checkColorButton(view, thisButton);
            displayScore();
        }
    }

    public void checkColorButton(View view, MyButton button){
        int row = button.getRow();

        switch(row){
            case 1:
                if ((button.getId() == R.id.first_lock_button) && ((getFirstRowCrossed() < 6) || !findButtonById(R.id.first_12_button).isPressed())){
                    if(!isFirstRowClosed()){
                        lockRow(button);
                        setFirstRowClosed(true);
                    }
                    return;
                }
                setFirstRowCrossed(getFirstRowCrossed()+1);
                break;
            case 2:
                if ((button.getId() == R.id.second_lock_button) && ((getSecondRowCrossed() < 6) || !findButtonById(R.id.second_12_button).isPressed())){
                    if(!isSecondRowClosed()){
                        lockRow(button);
                        setSecondRowClosed(false);
                    }
                    return;
                }
                setSecondRowCrossed(getSecondRowCrossed()+1);
                break;
            case 3:
                if ((button.getId() == R.id.third_lock_button) && ((getThirdRowCrossed() < 6) || !findButtonById(R.id.third_2_button).isPressed())){
                    if(!isThirdRowClosed()){
                        lockRow(button);
                        setThirdRowClosed(false);
                    }
                    return;
                }
                setThirdRowCrossed(getThirdRowCrossed()+1);
                break;
            case 4:
                if ((button.getId() == R.id.fourth_lock_button) && ((getFourthRowCrossed() < 6) || !findButtonById(R.id.fourth_2_button).isPressed())){
                    if(!isFourthRowClosed()){
                        lockRow(button);
                        setFourthRowClosed(false);
                    }
                    return;
                }
                setFourthRowCrossed(getFourthRowCrossed()+1);
                break;
            default:
                break;
        }
        view.setBackgroundResource(button.getBackgroundCrossed());
        button.setPressed(true);
        button.setPressable(false);
        deactivateButtons(button, false);
    }

    private void lockRow(MyButton button) {
        // gray out complete row
        grayOutRow(button.getRow());

        // deactivate buttons
        button.setPressable(false);
        deactivateButtons(button, true);

    }


    // Button helpers

    public void grayOutRow(int row){
        for(MyButton button : buttons[row-1]){
            View buttonView = findViewById(button.getId());
            if(button.isPressed()){
                buttonView.setBackgroundResource(R.drawable.grayed_button_crossed);
            }
            else{
                buttonView.setBackgroundResource(R.drawable.grayed_button);
            }
        }
    }

    public void undoAction(Action action){
        MyButton pressedButton = action.getButton();
        View view = findViewById(pressedButton.getId());
        int row = pressedButton.getRow();
        int number = pressedButton.getNumberInRow();
        if(action.isFail()){
            undoFail(view);
            return;
        }
        if(action.isRowLock()){
            undoRowLock(action, view, pressedButton);
            return;
        }

            // Change button background
            view.setBackgroundResource(pressedButton.getBackground());

            // Correct score counter
            switch(row) {
                case 1:
                    setFirstRowCrossed(getFirstRowCrossed() - 1);
                    break;
                case 2:
                    setSecondRowCrossed(getSecondRowCrossed() - 1);
                    break;
                case 3:
                    setThirdRowCrossed(getThirdRowCrossed() - 1);
                    break;
                case 4:
                    setFourthRowCrossed(getFourthRowCrossed() - 1);
                    break;
                default:
                    break;
            }

            // Reset pressed button
            resetButton(row, number);

            // Make deactivated buttons pressable
            reactivateButtons(action.getDeactivatedButtons());

            // Show score
            displayScore();

    }

    public void undoRowLock(Action action, View view, MyButton pressedButton){
        // Change button background

        view.setBackgroundResource(pressedButton.getBackground());
        resetButton(pressedButton.getRow(), pressedButton.getNumberInRow());
        reactivateButtons(action.getDeactivatedButtons());
        recolorLockedButtons(pressedButton.getRow());

        switch(pressedButton.getRow()){
            case 1:
                setFirstRowClosed(false);
                break;
            case 2:
                setSecondRowClosed(false);
                break;
            case 3:
                setThirdRowClosed(false);
                break;
            case 4:
                setFourthRowClosed(false);
                break;
            default:
                break;
        }


        displayScore();
    }

    public void resetButton(int row, int number){
        buttons[row-1][number-1].setPressed(false);
        buttons[row-1][number-1].setPressable(true);
    }

    public void reactivateButtons(List<MyButton> deactivatedButtons){
        for(MyButton button : deactivatedButtons){
            int row = button.getRow();
            int number = button.getNumberInRow();
            buttons[row-1][number-1].setPressable(true);
        }
    }

    public void recolorLockedButtons(int row){
        for(MyButton button : buttons[row-1]) {
            View buttonView = findViewById(button.getId());
            if (button.isPressed()) {
                buttonView.setBackgroundResource(button.getBackgroundCrossed());
            } else {
                buttonView.setBackgroundResource(button.getBackground());
            }
        }
    }

    public void resizeLayout(int id, int dpixels){
        LinearLayout layout = (LinearLayout)findViewById(id);
        ViewGroup.LayoutParams params = layout.getLayoutParams();

        float pixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpixels, getResources().getDisplayMetrics());
        params.height = (int)pixel;
        //params.height = 100;
        layout.requestLayout();
    }

    protected void makeButtons() {
        //red buttons
        makeButton(R.id.first_2_button, MyColor.RED, 1, 1);
        makeButton(R.id.first_3_button, MyColor.RED, 2, 1);
        makeButton(R.id.first_4_button, MyColor.RED, 3, 1);
        makeButton(R.id.first_5_button, MyColor.RED, 4, 1);
        makeButton(R.id.first_6_button, MyColor.RED, 5, 1);
        makeButton(R.id.first_7_button, MyColor.RED, 6, 1);
        makeButton(R.id.first_8_button, MyColor.RED, 7, 1);
        makeButton(R.id.first_9_button, MyColor.RED, 8, 1);
        makeButton(R.id.first_10_button, MyColor.RED, 9, 1);
        makeButton(R.id.first_11_button, MyColor.RED, 10, 1);
        makeButton(R.id.first_12_button, MyColor.RED, 11, 1);
        makeButton(R.id.first_lock_button, MyColor.RED, 12, 1);

        //yellow buttons
        makeButton(R.id.second_2_button, MyColor.YELLOW, 1, 2);
        makeButton(R.id.second_3_button, MyColor.YELLOW, 2, 2);
        makeButton(R.id.second_4_button, MyColor.YELLOW, 3, 2);
        makeButton(R.id.second_5_button, MyColor.YELLOW, 4, 2);
        makeButton(R.id.second_6_button, MyColor.YELLOW, 5, 2);
        makeButton(R.id.second_7_button, MyColor.YELLOW, 6, 2);
        makeButton(R.id.second_8_button, MyColor.YELLOW, 7, 2);
        makeButton(R.id.second_9_button, MyColor.YELLOW, 8, 2);
        makeButton(R.id.second_10_button, MyColor.YELLOW, 9, 2);
        makeButton(R.id.second_11_button, MyColor.YELLOW, 10, 2);
        makeButton(R.id.second_12_button, MyColor.YELLOW, 11, 2);
        makeButton(R.id.second_lock_button, MyColor.YELLOW, 12, 2);

        //green buttons
        makeButton(R.id.third_12_button, MyColor.GREEN, 1, 3);
        makeButton(R.id.third_11_button, MyColor.GREEN, 2, 3);
        makeButton(R.id.third_10_button, MyColor.GREEN, 3, 3);
        makeButton(R.id.third_9_button, MyColor.GREEN, 4, 3);
        makeButton(R.id.third_8_button, MyColor.GREEN, 5, 3);
        makeButton(R.id.third_7_button, MyColor.GREEN, 6, 3);
        makeButton(R.id.third_6_button, MyColor.GREEN, 7, 3);
        makeButton(R.id.third_5_button, MyColor.GREEN, 8, 3);
        makeButton(R.id.third_4_button, MyColor.GREEN, 9, 3);
        makeButton(R.id.third_3_button, MyColor.GREEN, 10, 3);
        makeButton(R.id.third_2_button, MyColor.GREEN, 11, 3);
        makeButton(R.id.third_lock_button, MyColor.GREEN, 12, 3);

        //blue buttons
        makeButton(R.id.fourth_12_button, MyColor.BLUE, 1, 4);
        makeButton(R.id.fourth_11_button, MyColor.BLUE, 2, 4);
        makeButton(R.id.fourth_10_button, MyColor.BLUE, 3, 4);
        makeButton(R.id.fourth_9_button, MyColor.BLUE, 4, 4);
        makeButton(R.id.fourth_8_button, MyColor.BLUE, 5, 4);
        makeButton(R.id.fourth_7_button, MyColor.BLUE, 6, 4);
        makeButton(R.id.fourth_6_button, MyColor.BLUE, 7, 4);
        makeButton(R.id.fourth_5_button, MyColor.BLUE, 8, 4);
        makeButton(R.id.fourth_4_button, MyColor.BLUE, 9, 4);
        makeButton(R.id.fourth_3_button, MyColor.BLUE, 10, 4);
        makeButton(R.id.fourth_2_button, MyColor.BLUE, 11, 4);
        makeButton(R.id.fourth_lock_button, MyColor.BLUE, 12, 4);
    }

    public void makeButton(int id, int color, int number, int row){
        buttons[row-1][number-1] = new MyButton(id, number, color, row);
    }

    private MyButton findButtonById(int id){

        MyButton button = new MyButton();
        for (MyButton[] b_array : buttons) {
            for (MyButton b : b_array) {
                if (b.getId() == id) {
                    button = b;
                }
            }

        }
        return button;
    }

    private void resetColorButtons(){
        for (MyButton[] b_array : buttons){
            for (MyButton b : b_array){
                findViewById(b.getId()).setBackgroundResource(b.getBackground());
            }
        }
    }


    private void deactivateButtons(MyButton pressedButton, boolean lock){
        Action action = new Action();
        action.setButton(pressedButton);
        action.setFail(false);
        action.setRowLock(lock);

        List<MyButton> deactivatedButtons = new ArrayList<>();
        int row = pressedButton.getRow();
        int number = pressedButton.getNumberInRow();

        for (int i = number-1; i > 0; i--){
            MyButton button = buttons[row-1][i-1];
            if(button.isPressed()){
                break;
            }
            else{
                button.setPressable(false);
                deactivatedButtons.add(button);
            }
        }

        action.setDeactivatedButtons(deactivatedButtons);

        actions.add(action);
    }

    // Score functions

    private int calculateColorScore(int number){
        if(number==0){
            return 0;
        }
        return number+calculateColorScore(number-1);
    }

    private void displayScore(){
        TextView firstRowScoreView = (TextView) findViewById(R.id.first_row_sum_box);
        int firstRowTotal = calculateColorScore(getFirstRowCrossed());
        firstRowScoreView.setText(String.valueOf(firstRowTotal));
        TextView secondRowScoreView = (TextView) findViewById(R.id.second_row_sum_box);
        int secondRowTotal = calculateColorScore(getSecondRowCrossed());
        secondRowScoreView.setText(String.valueOf(secondRowTotal));
        TextView thirdRowScoreView = (TextView) findViewById(R.id.third_row_sum_box);
        int thirdRowTotal = calculateColorScore(getThirdRowCrossed());
        thirdRowScoreView.setText(String.valueOf(thirdRowTotal));
        TextView fourthRowScoreView = (TextView) findViewById(R.id.fourth_row_sum_box);
        int fourthRowTotal = calculateColorScore(getFourthRowCrossed());
        fourthRowScoreView.setText(String.valueOf(fourthRowTotal));
        TextView failView = (TextView) findViewById(R.id.fail_sum_box);
        int failScore = getFails()*5;
        failView.setText(String.valueOf(failScore));
        TextView totalView = (TextView) findViewById(R.id.total_box);
        int totalScore = firstRowTotal+secondRowTotal+thirdRowTotal+fourthRowTotal-failScore;
        totalView.setText(String.valueOf(totalScore));
    }

    private void makePreparations() {
        setFails(0);
        makeButtons();
        setFirstRowCrossed(0);
        setSecondRowCrossed(0);
        setThirdRowCrossed(0);
        setFourthRowCrossed(0);
        setFirstRowClosed(false);
        setSecondRowClosed(false);
        setThirdRowClosed(false);
        setFourthRowClosed(false);
        setResized(false);
        setResizableTrait();
    }

    private void setResizableTrait() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.x;
        int maxHeight = 600; // max height in dp
        int maxPixelHeight = (int)TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, height,
                getResources().getDisplayMetrics()); // max height in pixels
        if(height < maxPixelHeight){
            setResizable(false);
        }
        else{
            setResizable(true);
        }
    }

}

