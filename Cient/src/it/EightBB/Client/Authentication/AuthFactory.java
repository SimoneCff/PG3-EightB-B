package it.EightBB.Client.Authentication;
import it.EightBB.Client.AbstractFactory;
import it.EightBB.Client.SwingBB.Form;

public class AuthFactory implements AbstractFactory {
    private AuthFactory Instance;
    private static Form ft = null;

    @Override
    public AuthFactory getInstance() {
        if (Instance==null){
            Instance = new AuthFactory();
        }
        return Instance;
    }

    @Override
    public Form makeFrame(String Type) {
        if (Type.equals("Login")){
            ft = new Login();
        }
        return ft;
    }

}
