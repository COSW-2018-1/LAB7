package cosw.eci.edu.calculadora_s.controller;

import android.widget.EditText;

import cosw.eci.edu.calculadora_s.service.ScreenService;
import cosw.eci.edu.calculadora_s.serviceImpl.ScreenServiceImpl;

/**
 * Created by sergio on 15/03/18.
 */

//@RestController
public class ScreenController {

    //@Autowired
    private ScreenService screenService;
    private EditText pantalla;

    public ScreenController(EditText pantalla){
        this.pantalla=pantalla;
        this.screenService= new ScreenServiceImpl(pantalla);
    }

    public String getTextView(){
        return screenService.getTextScreen();
    }

    public void drawOnScreen(String text){
        screenService.setTextScreen(text);

    }

    public void clearScreen(){
        screenService.clearScreen();

    }

}
