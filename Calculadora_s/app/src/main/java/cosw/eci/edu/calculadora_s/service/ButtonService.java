package cosw.eci.edu.calculadora_s.service;

import android.widget.Button;

/**
 * Created by sergio on 15/03/18.
 */

public interface ButtonService {

    public String getText(Button button);

    public int getNumber(Button button);

    public double divide();

    public double multiply();

    public double subtract();

    public double decimal_fun();

    public double sum_fun();

    public double ac_sum();

    public double ac_sub();

    public double sin_fun();

    public double cos_fun();

    public double tan_fun();

    public double memory_r();

    public void clear_vars();

}
