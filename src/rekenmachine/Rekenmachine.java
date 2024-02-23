package rekenmachine;

/**
 *
 * @author Ruben Leenkengt
 */

public class Rekenmachine {
    int[] input = new int[2];
    int inputindex = 0;
    String operator = "0";
    int result = 0;
    int resetnumber = 0;
    
    void numberButtonClick(int index){
        input[inputindex] = input[inputindex] * 10 + index;
    }
    
    void isbuttonclick(){
            if(operator == "+"){
                result = input[0] + input[1];
            }else if(operator == "-"){
                result = input[0] - input[1];
            }else if(operator == "X"){
                result = input[0] * input[1];
            }else if(operator == "/"){
                result = input[0] / input[1];
            }
            input[0] = result;
            input[1] = 0;
            inputindex = 0;
        
        
        
    }
    
    public void plusbuttonclick(){
            operator = "+";
            inputindex = 1; 
        
    }
    
    public void subtractbuttonclick(){
            operator = "-";
            inputindex = 1; 
        
    }
    
    public void multiplybuttonclick(){
            operator = "X";
            inputindex = 1;
                
    }
    
   
    public void dividebuttonclick(){
            operator = "/";
            inputindex = 1;    
    }
    
    
    public void reset(){
        input[0] = 0;
        input[1] = 0;
        inputindex = 0;
        operator = "";   
    }
}
