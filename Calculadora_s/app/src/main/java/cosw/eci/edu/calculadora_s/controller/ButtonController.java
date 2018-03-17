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

    public void drawOnScreen(Button button){
        //Calculadora.setEntrada1(Calculadora.getEntrada2());
        //Calculadora.setEntrada2(Double.parseDouble(button.getText().toString()));
        //int number = buttonService.getNumber(button);

        //screencontroller.drawOnScreen(String.valueOf(number));

        switch(Calculadora.getOperation()) {
            case -1:
                screencontroller.drawOnScreen(buttonService.getText(button));
                break;
            case 0:
                screencontroller.drawOnScreen(buttonService.getText(button));
                divide();
                break;
            case 1:
                screencontroller.drawOnScreen(buttonService.getText(button));
                multiply();
                break;
            case 2:
                subtract();
                break;
            case 3:
                decimal_fun();
                break;
            case 4:
                sum_fun();
                break;
            case 5:
                ac_sum();
                break;
            case 6:
                ac_sub();
                break;
            case 7:
                sin_fun();
                break;
            case 8:
                cos_fun();
                break;
            case 9:
                tan_fun();
                break;
            case 10:
                pow_fun();
                break;
            case 11:
                total_fun();
                break;
            case 12:
                clear_fun();
                break;
            default:
                System.out.println("DEFAULT EN DRAWSCREEN");
                break;
        }


    }

    public static void divide(){
        if(Calculadora.getOperation()==-1){
            Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
            Calculadora.setOperation(0);
        }
        else{
            Calculadora.setEntrada2(Double.parseDouble(screencontroller.getTextView()));

            if(Calculadora.getEntrada1()==0.0 && Calculadora.getEntrada2()==0.0 ){ screencontroller.drawOnScreen("Undefined"); }
            else if(Calculadora.getEntrada2()==0.0 ){ screencontroller.drawOnScreen("Infinity"); }
            else{ screencontroller.drawOnScreen(String.valueOf(buttonService.divide())); }
            Calculadora.setOperation(-1);
        }
    }

    public static void multiply(){
        if(Calculadora.getOperation()==-1){
            Calculadora.setEntrada1(Double.parseDouble(screencontroller.getTextView()));
            Calculadora.setOperation(1);
        }
        else{
            Calculadora.setEntrada2(Double.parseDouble(screencontroller.getTextView()));

            screencontroller.drawOnScreen(String.valueOf(buttonService.multiply()));
            Calculadora.setOperation(-1);
        }
    }

    public static void subtract(){
        buttonService.subtract();
    }

    public static void decimal_fun(){
        buttonService.decimal_fun();
    }

    public static void sum_fun(){
        buttonService.sum_fun();
    }

    public static void ac_sum() {
        buttonService.ac_sum();
    }

    public static void ac_sub(){
        buttonService.ac_sub();
    }

    public static void sin_fun(){
        buttonService.sin_fun();
    }

    public static void cos_fun(){
        buttonService.cos_fun();
    }

    public static void tan_fun(){
        buttonService.tan_fun();
    }

    public static void pow_fun(){
        buttonService.pow_fun();
    }

    public static void total_fun(){
        buttonService.total_fun();
    }

    public static void clear_fun() {
        buttonService.clear_fun();
        screencontroller.clearScreen();
        System.out.println("==== LIMPIADO <°-°>");
    }
}

