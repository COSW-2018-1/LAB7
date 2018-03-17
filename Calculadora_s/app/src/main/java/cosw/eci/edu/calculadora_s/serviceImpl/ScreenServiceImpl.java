package cosw.eci.edu.calculadora_s.serviceImpl;

import android.widget.EditText;

import cosw.eci.edu.calculadora_s.service.ScreenService;

/**
 * Created by sergio on 15/03/18.
 */

//@Service
public class ScreenServiceImpl implements ScreenService {

    private EditText pantalla;

    public ScreenServiceImpl(EditText pantalla){
        this.pantalla = pantalla;
    }

    @Override
    public void setTextScreen(String text) {
        pantalla.setText(text);
    }

    @Override
    public String getTextScreen() {
        return pantalla.getText().toString();
    }

    @Override
    public void clearScreen() {
        pantalla.setText("");
    }
}
