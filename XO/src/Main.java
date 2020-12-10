import ru.xo.view.MainView;

public class Main {

    public static void main(String [] args){
        System.out.println("App has been started");
        MainView mainView = new MainView("XO Game");
        mainView.setVisible(true);
    }


}


