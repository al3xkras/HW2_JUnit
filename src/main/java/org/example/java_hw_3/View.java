package org.example.java_hw_3;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class View {
    public Model model;

    public static final String MESSAGE_INPUT_NUMBER_GREATER =
            "Input number is greater than secret number";
    public static final String MESSAGE_INPUT_NUMBER_LESS =
            "Input number is less than secret number";
    public static final String MESSAGE_INPUT_NUMBER_EQUALS =
            "Input number is equal to unknown number!";
    public static final String MESSAGE_INPUT_NUMBER_NOT_IN_RANGE =
            "Input number (%d) is not in range from %d to %d.";
    public static final String MESSAGE_GREET =
            "More or Less game: input number and try to guess secret number.\n";
    public static final String MESSAGE_REQUEST_NUMBER =
            "Input number in range from %d to %d: ";
    public static final String MESSAGE_GAME_OVER =
            "\nStatistics:\n  Moves made: %d\n  Time spent: %ds\n\nGame Over!";

    public View(Model model){
        this.model = model;
    }

    public String getMessage(int number){

        if (number>model.maxRandValue || number<model.minRandValue){
            return String.format(View.MESSAGE_INPUT_NUMBER_NOT_IN_RANGE,
                    number,model.minRandValue,model.maxRandValue);
        }

        if (number== model.secretNumber){
            return View.MESSAGE_INPUT_NUMBER_EQUALS;
        }

        if (number>model.secretNumber){
            return View.MESSAGE_INPUT_NUMBER_GREATER;
        } else {
            return View.MESSAGE_INPUT_NUMBER_LESS;
        }
    }

    public void printMessage(int inputNumber){
        String message = getMessage(inputNumber);

        System.out.println(message);
    }

    public void greet(){
        System.out.println(View.MESSAGE_GREET);
    }

    public void requestNumber(){
        String message = String.format(View.MESSAGE_REQUEST_NUMBER,
                model.minRandValue,model.maxRandValue);
        System.out.println(message);
    }

    public void printGameOver(int movesMade,int timeSpentSeconds){
        System.out.printf(View.MESSAGE_GAME_OVER,movesMade,timeSpentSeconds);
    }




}
