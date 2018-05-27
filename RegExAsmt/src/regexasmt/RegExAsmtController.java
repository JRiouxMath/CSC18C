package regexasmt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegExAsmtController {

    @FXML
    private TextField ReplText;

    @FXML
    private TextArea AltText;
    
    @FXML
    private TextField RegExText;
    
    @FXML
    private TextArea OrigText;

    @FXML
    void ReplButn(ActionEvent event) {
        
        AltText.setText(ReplaceString(RegExText.getText(), OrigText.getText(), ReplText.getText()));
    }
    
    private String ReplaceString (String regex, String origText, String replText)
    {
        Pattern regExPatt = Pattern.compile(regex);       
        Matcher regExMatch = regExPatt.matcher(origText);
        
        if (regExMatch.find())
        {
            return origText.replaceAll(regex, replText) + "\nReplacement made: "
                    + regExPatt;  
        }//end if find
        
        return origText + "\nNo replacement made";
    }// end Method ReplaceString

}
