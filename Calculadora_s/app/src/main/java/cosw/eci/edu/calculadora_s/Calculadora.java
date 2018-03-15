package cosw.eci.edu.calculadora_s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    private TextView pantalla;
    private Button sum, sub, div, mult, decimal, acsum, acsub, sin, cos, tan, pow2, root2, absFun;
    private Button one, two, three, four, five, six, seven, eight, nine, zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        pantalla = findViewById(R.id.text_result);
        sum = findViewById(R.id.btn_sum);
        sub = findViewById(R.id.btn_subtract);
        div=findViewById(R.id.btn_divide);
        mult = findViewById(R.id.btn_multiply);
        decimal = findViewById(R.id.btn_decimal);
        acsum =findViewById(R.id.btn_ac_sum);
        acsub = findViewById(R.id.btn_ac_sub);
        sin = findViewById(R.id.btn_sin);
        cos = findViewById(R.id.btn_cos);
        tan = findViewById(R.id.btn_tan);
        pow2 = findViewById(R.id.btn_pow);
        root2 = findViewById(R.id.btn_root);
        absFun = findViewById(R.id.btn_abs);

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
}
