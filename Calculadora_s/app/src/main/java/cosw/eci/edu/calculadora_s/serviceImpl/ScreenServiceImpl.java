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
        String newText="";
        String textOld=text;
        if(text.length()>10){
            for(char c: textOld.toCharArray()){
                newText+=c;
                if(newText.length()>10){
                    break;
                }
            }
            System.err.println("ScreenController: length size of text > 10");
            textOld=newText;
        }
        pantalla.setText(textOld);
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
