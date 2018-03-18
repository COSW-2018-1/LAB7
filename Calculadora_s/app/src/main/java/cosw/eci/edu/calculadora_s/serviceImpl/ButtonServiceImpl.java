package cosw.eci.edu.calculadora_s.serviceImpl;

import android.widget.Button;

import cosw.eci.edu.calculadora_s.Calculadora;
import cosw.eci.edu.calculadora_s.service.ButtonService;

/**
 * Created by sergio on 15/03/18.
 */

//@Service
public class ButtonServiceImpl implements ButtonService {

    public ButtonServiceImpl(){

    }


    @Override
    public String getText(Button button) {
        return button.getText().toString();
    }

    @Override
    public int getNumber(Button button) {

        return Integer.parseInt(getText(button));
    }

    @Override
    public double divide() {
        Double num1 = Calculadora.getEntrada1();
        Double num2 = Calculadora.getEntrada2();

        return num1/num2;
    }

    @Override
    public double multiply() {
        Double num1 = Calculadora.getEntrada1();
        Double num2 = Calculadora.getEntrada2();

        return num1*num2;
    }

    @Override
    public double subtract() {
        Double num1 = Calculadora.getEntrada1();
        Double num2 = Calculadora.getEntrada2();

        return num1-num2;
    }

    @Override
    public double decimal_fun() {
        Double num1 = Calculadora.getEntrada1();
        Double num2 = Calculadora.getEntrada2();
        Double decimalNumber;

        String intN1 = String.valueOf(num1.intValue());
        String  intN2 = String.valueOf(num2.intValue());

        decimalNumber = Double.parseDouble(intN1+"."+intN2);

        System.out.println(intN1);
        System.out.println(intN2);
        System.out.println(decimalNumber);
        return decimalNumber;
    }

    @Override
    public double sum_fun(){
    Double num1 = Calculadora.getEntrada1();
    Double num2 = Calculadora.getEntrada2();

        return num1+num2;
    }

    @Override
    public double ac_sum() {
        return 0;
    }

    @Override
    public double ac_sub() {
        return 0;
    }

    @Override
    public double sin_fun() {
        return 0;
    }

    @Override
    public double cos_fun() {
        return 0;
    }

    @Override
    public double tan_fun() {
        return 0;
    }

    @Override
    public double pow_fun() {
        return 0;
    }

    @Override
    public void clear_fun() {
        Calculadora.setOperation(-1);//generando primer parametro
        Calculadora.setEntrada1(0.0);
        Calculadora.setEntrada2(0.0);
        Calculadora.setNextOperation(0);// ninguna operacion siguiente
    }


}
