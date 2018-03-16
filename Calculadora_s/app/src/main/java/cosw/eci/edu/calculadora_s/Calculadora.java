package cosw.eci.edu.calculadora_s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private EditText pantalla;
    private Button sum, sub, div, mult, decimal, acsum, acsub;
    private Button sin, cos, tan, offFun, pow2, root2, clearFun;
    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private double entrada, salida; // datos de entrada, valores de resultado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

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
        pow2 = findViewById(R.id.btn_pow);
        root2 = findViewById(R.id.btn_root);
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
        pow2.setOnClickListener(this);
        root2.setOnClickListener(this);
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

        System.out.println("despues de crear");
    }



    // evento onClick
    @Override
    public void onClick(View view) {
        System.out.println("ENTRA AL ONLCIK");
       // entrada = Double.parseDouble(pantalla.getText().toString());


        switch (view.getId()) {
            case R.id.btn_7:
                definir_salida(7);
                break;
            case R.id.btn_8:
                definir_salida(8);
                break;
            case R.id.btn_9:
                definir_salida(9);
                break;
            case R.id.btn_4:
                definir_salida(4);
                break;
            case R.id.btn_5:
                definir_salida(5);
                break;
            case R.id.btn_6:
                definir_salida(6);
                break;
            case R.id.btn_1:
                definir_salida(1);
                break;
            case R.id.btn_2:
                definir_salida(2);
                break;
            case R.id.btn_3:
                definir_salida(3);
                break;
            case R.id.btn_0:
                definir_salida(0);
                break;
            case R.id.btn_divide:
                divide();
                break;
            case R.id.btn_multiply:
                multiply();
                break;
            case R.id.btn_subtract:
                subtract();
                break;
            case R.id.btn_decimal:
                decimal_fun();
                break;
            case R.id.btn_sum:
                sum_fun();
                break;
            case R.id.btn_ac_sum:
                ac_sum();
                break;
            case R.id.btn_ac_sub:
                ac_sub();
                break;
            case R.id.btn_sin:
                sin_fun();
                break;
            case R.id.btn_cos:
                cos_fun();
                break;
            case R.id.btn_tan:
                tan_fun();
                break;
            case R.id.btn_off:
                off_fun();
                break;
            case R.id.btn_pow:
                pow_fun();
                break;
            case R.id.btn_root:
                root_fun();
                break;
            case R.id.btn_clear:
                clear_fun();
                break;
            default:
                System.out.println("DEFAULT EN ONCLICK");
                break;
        }
    }

    private void definir_salida(int number){
        pantalla.setText("12345");
    }

    private void divide(){

    }

    private void multiply(){

    }

    private void subtract(){

    }

    private void decimal_fun(){

    }

    private void sum_fun(){

    }

    private void ac_sum() {

    }

    private void ac_sub(){

    }

    private void sin_fun(){

    }

    private void cos_fun(){

    }

    private void tan_fun(){

    }

    private void off_fun(){
        finish();
    }

    private void pow_fun(){

    }

    private void root_fun(){

    }

    private void clear_fun(){

    }


}
