package rekenmachine;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;



/**
 *
 * @author Ruben leenknegt
 */

public class MainApp extends Application {
    
    TextField calcdisplay;
    ArrayList<Coordinaat> buttonCoordinates = new ArrayList<Coordinaat>();
    
    @Override
    public void start(Stage primaryStage) {
        Pane rootpane = new Pane();
        buttonCoordinates.add(new Coordinaat(0,4));
        buttonCoordinates.add(new Coordinaat(0,3));
        buttonCoordinates.add(new Coordinaat(1,3));
        buttonCoordinates.add(new Coordinaat(2,3));
        buttonCoordinates.add(new Coordinaat(0,2));
        buttonCoordinates.add(new Coordinaat(1,2));
        buttonCoordinates.add(new Coordinaat(2,2));
        buttonCoordinates.add(new Coordinaat(0,1));
        buttonCoordinates.add(new Coordinaat(1,1));
        buttonCoordinates.add(new Coordinaat(2,1));
        
        GridPane grid = new GridPane();
        rootpane.getChildren().add(grid);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setLayoutX(0);
        grid.setLayoutY(60);
        primaryStage.setResizable(false);

        calcdisplay = new TextField();
        rootpane.getChildren().add(calcdisplay);
        calcdisplay.setLayoutX(10);
        calcdisplay.setLayoutY(10);
        calcdisplay.setPrefWidth(220);
        calcdisplay.setPrefHeight(50);
        calcdisplay.setEditable(false);

        
        
        
        final Rekenmachine machine = new Rekenmachine();
        
        for(int i = 0; i < 10; i++){
            final int index = i;
            Button newbutton = new Button(Integer.toString(i));
            
            grid.add(newbutton,buttonCoordinates.get(i).x,buttonCoordinates.get(i).y);
            newbutton.setPrefWidth(50);
            newbutton.setPrefHeight(50);
             
            newbutton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                machine.numberButtonClick(index);
                calcdisplay.setText(Integer.toString(machine.input[machine.inputindex]));
            });
        }
        
        
        
        
        
        
        
        
        
        Button keer = new Button("X");
        grid.add(keer, 3, 2);
        keer.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            machine.multiplybuttonclick();
            calcdisplay.setText(machine.operator);
        });
        
        Button deel = new Button(":");
        grid.add(deel, 3, 1);
        deel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            machine.dividebuttonclick();
            calcdisplay.setText(machine.operator);
        });
        
        Button plus = new Button("+");
        grid.add(plus, 3, 3);
        plus.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            machine.plusbuttonclick();
            calcdisplay.setText(machine.operator);
        });
        
        Button minus = new Button("-");
        grid.add(minus, 3, 4);
        minus.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            machine.subtractbuttonclick();
            calcdisplay.setText(machine.operator);
        });
        
        Button clear = new Button("C");
        grid.add(clear, 1, 4);
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            machine.reset();
            calcdisplay.setText(Integer.toString(machine.resetnumber)); 
        });
        
        Button equals = new Button("=");
        grid.add(equals, 2, 4);
        equals.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            machine.isbuttonclick();
            calcdisplay.setText(Integer.toString(machine.result));
            
            
        });
        
        ArrayList<Button> specialebuttons = new ArrayList<Button>();
        specialebuttons.add(clear);
        specialebuttons.add(keer);
        specialebuttons.add(deel);
        specialebuttons.add(plus);
        specialebuttons.add(equals);
        specialebuttons.add(minus);
        
        for(Button button : specialebuttons){
            button.setPrefWidth(50); 
            button.setPrefHeight(50);
        }      
                                                                                
        Scene scene = new Scene(rootpane, 240, 410);
        primaryStage.setTitle("Reken machine");
        primaryStage.setScene(scene);
        primaryStage.show();
        machine.reset();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
