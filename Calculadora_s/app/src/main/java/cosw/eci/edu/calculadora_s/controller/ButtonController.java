package cosw.eci.edu.calculadora_s.controller;

import android.widget.Button;
import android.widget.EditText;

import cosw.eci.edu.calculadora_s.Calculadora;
import cosw.eci.edu.calculadora_s.service.ButtonService;
import cosw.eci.edu.calculadora_s.serviceImpl.ButtonServiceImpl;

/**
 * Created by sergio on 15/03/18.
 */

//@RestController
public class ButtonController {


    //@Autowired
    private static ButtonService buttonService;
    private static ScreenController screencontroller;
    private EditText pantalla;

    public ButtonController(EditText pantalla){
        this.pantalla=pantalla;
        buttonService = new ButtonServiceImpl();
        screencontroller = new ScreenController(pantalla);
    }

    public static void drawOnScreen(Button button){
        // 0:ninguna operacion pendiente, -1: generando primer parametro, -2: generando segundo parametro

        if(Calculadora.getOperation()<0){
            assigOperation(button);
        }
        else{
            switch(Calculadora.getOperation()) {
                case 1:
                    divide(button);
                    break;
                case 2:
                    multiply(button);
                    break;
                case 3:
                    subtract(button);
                    break;
                case 4:
                    decimal_fun(button);
                    break;
                case 5:
                    sum_fun(button);
                    break;
                case 6:
                    ac_sum(button);
                    break;
                case 7:
                    ac_sub(button);
                    break;
                case 8:
                    sin_fun(button);
                    break;
                case 9:
                    cos_fun(button);
                    break;
                case 10:
                    tan_fun(button);
                    break;
                case 11:
                    memory_r(button);
                    break;
                case 12:
                    total_fun(button); // FUNCION DE IGUAL
                    break;
                case 13:
                    clear_fun();
                    break;
                default:
                    System.err.println("ButtonController - drawOnScreen: case else{ " +Calculadora.getOperation()+" }");
                    break;
            }

        }


    }

    public static void divide(Button button){
        System.out.println("== info: DIVIDE()");
        Calculadora.setNextOperation(1); // siguiente operacion, esta
        if(Calculadora.getOperation()==-1){
            screencontroller.clearScreen();
            Calculadora.setOperation(-2); // a generar segundo parametro
        }
        else {
            if (Calculadora.getEntrada1() == 0.0 && Calculadora.getEntrada2() == 0.0) {
                screencontroller.drawOnScreen("Undefined"); buttonService.clear_vars();
            } else if (Calculadora.getEntrada2() == 0.0) {
                screencontroller.drawOnScreen("Infinity"); buttonService.clear_vars();
            } else {
                screencontroller.drawOnScreen(String.valueOf(buttonService.divide()));
            }
            Calculadora.setOperation(-1);

        }
    }

    public static void multiply(Button button){
        System.out.println("== info: MULTIPLICA()");
        Calculadora.setNextOperation(2); // siguiente operacion, esta
        if(Calculadora.getOperation()==-1){
            screencontroller.clearScreen();
            Calculadora.setOperation(-2); // a generar segundo parametro
        }
        else {
            screencontroller.drawOnScreen(String.valueOf(buttonService.multiply()));

            Calculadora.setOperation(-1);
        }
    }

    public static void subtract(Button button){
        System.out.println("== info: RESTA()");
        Calculadora.setNextOperation(3); // siguiente operacion, esta
        if(Calculadora.getOperation()==-1){
            screencontroller.clearScreen();
            Calculadora.setOperation(-2); // a generar segundo parametro
        }
        else {
            screencontroller.drawOnScreen(String.valueOf(buttonService.subtract()));

            Calculadora.setOperation(-1);
        }
    }

    public static void decimal_fun(Button button){
        System.out.println("== info: DECIMAL()");
        Calculadora.setNextOperation(4); // siguiente operacion, esta
        if(Calculadora.getOperation()==-1){
            screencontroller.clearScreen();
            Calculadora.setOperation(-2); // a generar segundo parametro
        }
        else {
            screencontroller.drawOnScreen(String.valueOf(buttonService.decimal_fun()));

            Calculadora.setOperation(-1);
        }
    }

    public static void sum_fun(Button button){
        System.out.println("== info: SUMA()");
        Calculadora.setNextOperation(5); // siguiente operacion, esta
        if(Calculadora.getOperation()==-1){
            screencontroller.clearScreen();
            Calculadora.setOperation(-2); // a generar segundo parametro
        }
        else {
            screencontroller.drawOnScreen(String.valueOf(buttonService.sum_fun()));

            Calculadora.setOperation(-1);
        }
    }

    public static void ac_sum(Button button) {
        System.out.println("== info: AC+()");
        Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
        Calculadora.setAc_memory(buttonService.ac_sum());
        buttonService.clear_vars();
    }

    public static void ac_sub(Button button){
        System.out.println("== info: AC-()");
        Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
        Calculadora.setAc_memory(buttonService.ac_sub());
        buttonService.clear_vars();
    }

    public static void sin_fun(Button button){
        System.out.println("== info: SIN()");
        Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
        screencontroller.drawOnScreen(String.valueOf(buttonService.sin_fun()));
        buttonService.clear_vars();
    }

    public static void cos_fun(Button button){
        System.out.println("== info: COS()");
        Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
        screencontroller.drawOnScreen(String.valueOf(buttonService.cos_fun()));
        buttonService.clear_vars();
    }

    public static void tan_fun(Button button){
        System.out.println("== info: TAN()");
        Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
        screencontroller.drawOnScreen(String.valueOf(buttonService.tan_fun()));
        buttonService.clear_vars();
    }

    public static void memory_r(Button button){
        System.out.println("== info: AC Read");
        screencontroller.drawOnScreen(String.valueOf(buttonService.memory_r()));
        buttonService.clear_vars();
    }

    public static void total_fun(Button button){
        Calculadora.setOperation(Calculadora.getNextOperation()); // la operacion es la siguiente operacion
        Calculadora.setNextOperation(0); // ninguna operacion
        drawOnScreen(button);
    }

    public static void clear_fun() { // no borra la memoria *memory_r*
        buttonService.clear_vars();
        screencontroller.clearScreen();
        System.out.println("=== info: CLEAR_FUN()");
    }

    public static boolean assigOperation(Button button){
        if(Calculadora.getOperation()==0){
            Calculadora.setOperation(-1);
            drawOnScreen(button);
            return true;
        }
        else if(Calculadora.getOperation()==-1){
            String inputText = buttonService.getText(button);
            String textScreen = screencontroller.getTextView();

            try {
                Calculadora.setEntrada1(Double.parseDouble(inputText+textScreen));
                screencontroller.drawOnScreen(textScreen+inputText);
            }catch (Exception e){
                Calculadora.setEntrada1(Double.parseDouble(inputText));
                screencontroller.drawOnScreen(inputText);
                System.err.println("Exception  setEntrada1 "+e);
            }
        }
        else if(Calculadora.getOperation()==-2){
            String inputText = buttonService.getText(button);
            String textScreen = screencontroller.getTextView();

            try {
                Calculadora.setEntrada2(Double.parseDouble(inputText+textScreen));
                screencontroller.drawOnScreen(textScreen+inputText);
            }catch (Exception e){
                Calculadora.setEntrada2(Double.parseDouble(inputText));
                screencontroller.drawOnScreen(inputText);
                System.err.println("Exception  setEntrada2" +e);
            }
        }
        else{
            System.err.println("ButtonController - assigOperation: case else{ --- }");
        }
        return true;
    }


}

