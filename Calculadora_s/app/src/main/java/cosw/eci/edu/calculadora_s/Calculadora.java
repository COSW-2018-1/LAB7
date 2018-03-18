package cosw.eci.edu.calculadora_s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cosw.eci.edu.calculadora_s.controller.ButtonController;
import cosw.eci.edu.calculadora_s.controller.ScreenController;

/**
 * Created by Sergio Perez: https://github.com/dark07perez
 * Date: 15/03/18.
 */
public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private ButtonController buttonController;
    private ScreenController screenController;

    public EditText pantalla;
    private Button sum, sub, div, mult, decimal, acsum, acsub;
    private Button sin, cos, tan, offFun, memory_r, total, clearFun;
    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private static double entrada1, entrada2; // datos de entrada, valores de resultado
    private static int operation, nextOperation; // second_fill: 33 en espera de parametros. nextOperation: siguiente operacion
    private static double ac_memory; // memoria


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        findByIdElementsView();
        setActionClickElementsView();

        operation=-1; // 0:ninguna operacion pendiente, -1: generando primer parametro, -2: generando segundo parametro
        nextOperation=0; // siguiente operacion: 0: ninguna operacion
        ac_memory = 0; // Memory

        buttonController = new ButtonController(pantalla);
        screenController = new ScreenController(pantalla);
    }


    // evento onClick
    @Override
    public void onClick(View view) {
      // entrada = Double.parseDouble(pantalla.getText().toString());

        switch (view.getId()) {
            case R.id.btn_7:
                buttonController.drawOnScreen(seven);
                break;
            case R.id.btn_8:
                buttonController.drawOnScreen(eight);
                break;
            case R.id.btn_9:
                buttonController.drawOnScreen(nine);
                break;
            case R.id.btn_4:
                buttonController.drawOnScreen(four);
                break;
            case R.id.btn_5:
                buttonController.drawOnScreen(five);
                break;
            case R.id.btn_6:
                buttonController.drawOnScreen(six);
                break;
            case R.id.btn_1:
                buttonController.drawOnScreen(one);
                break;
            case R.id.btn_2:
                buttonController.drawOnScreen(two);
                break;
            case R.id.btn_3:
                buttonController.drawOnScreen(three);
                break;
            case R.id.btn_0:
                //System.out.println("dramonscreen Claculadora: ");
                buttonController.drawOnScreen(zero);
                break;
            case R.id.btn_divide:
                ButtonController.divide(div);
                break;
            case R.id.btn_multiply:
                ButtonController.multiply(mult);
                break;
            case R.id.btn_subtract:
                ButtonController.subtract(sub);
                break;
            case R.id.btn_decimal:
                ButtonController.decimal_fun(decimal);
                break;
            case R.id.btn_sum:
                ButtonController.sum_fun(sum);
                break;
            case R.id.btn_ac_sum:
                ButtonController.ac_sum(acsum);
                break;
            case R.id.btn_ac_sub:
                ButtonController.ac_sub(acsub);
                break;
            case R.id.btn_sin:
                ButtonController.sin_fun(sin);
                break;
            case R.id.btn_cos:
                ButtonController.cos_fun(cos);
                break;
            case R.id.btn_tan:
                ButtonController.tan_fun(tan);
                break;
            case R.id.btn_off:
                off_fun();
                break;
            case R.id.btn_memory_r:
                ButtonController.memory_r(memory_r);
                break;
            case R.id.btn_total:
                ButtonController.total_fun(total); // FUNCION DE IGUAL
                break;
            case R.id.btn_clear:
                ButtonController.clear_fun();
                break;
            default:
                System.out.println("DEFAULT EN ONCLICK");
                break;
        }


    }

    private void findByIdElementsView(){

        pantalla = findViewById(R.id.text_result);
        sum = findViewById(R.id.btn_sum);
        sub = findViewById(R.id.btn_subtract);
        div = findViewById(R.id.btn_divide);
        mult = findViewById(R.id.btn_multiply);
        decimal = findViewById(R.id.btn_decimal);
        acsum = findViewById(R.id.btn_ac_sum);
        acsub = findViewById(R.id.btn_ac_sub);
        sin = findViewById(R.id.btn_sin);
        cos = findViewById(R.id.btn_cos);
        tan = findViewById(R.id.btn_tan);
        offFun = findViewById(R.id.btn_off);
        memory_r = findViewById(R.id.btn_memory_r);
        total = findViewById(R.id.btn_total);
        clearFun = findViewById(R.id.btn_clear);

        one = findViewById(R.id.btn_1);
        two = findViewById(R.id.btn_2);
        three = findViewById(R.id.btn_3);
        four = findViewById(R.id.btn_4);
        five = findViewById(R.id.btn_5);
        six = findViewById(R.id.btn_6);
        seven = findViewById(R.id.btn_7);
        eight = findViewById(R.id.btn_8);
        nine = findViewById(R.id.btn_9);
        zero = findViewById(R.id.btn_0);
    }

    public void setActionClickElementsView(){

        sum.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);
        decimal.setOnClickListener(this);
        acsum.setOnClickListener(this);
        acsub.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        offFun.setOnClickListener(this);
        memory_r.setOnClickListener(this);
        total.setOnClickListener(this);
        clearFun.setOnClickListener(this);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
    }

    public static double getEntrada1() {
        return entrada1;
    }

    public static void setEntrada1(double entrada) { Calculadora.entrada1 = entrada; }

    public static double getEntrada2() { return entrada2; }

    public static void setEntrada2(double entrada) { Calculadora.entrada2 = entrada;}

    public static int getOperation() {
        return operation;
    }

    public static void setOperation(int operation) {
        Calculadora.operation = operation;
    }

    public static int getNextOperation() { return nextOperation; }

    public static void setNextOperation(int nextOperation) { Calculadora.nextOperation = nextOperation; }

    public static double getAc_memory() { return ac_memory; }

    public static void setAc_memory(double ac_memory) { Calculadora.ac_memory = ac_memory; }

    private void off_fun(){
        finish();
    }

}