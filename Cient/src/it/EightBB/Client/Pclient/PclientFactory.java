package it.EightBB.Client.Pclient;

import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Pclient.Button.BookedStructures;
import it.EightBB.Client.Pclient.Button.GoBackC;
import it.EightBB.Client.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Pclient.Button.Prenota;
import it.EightBB.Client.Pclient.Form.ModifyProfile;
import it.EightBB.Client.Pclient.Form.PaymentPage;
import it.EightBB.Client.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Pclient.Form.RicercaLuogo;
import it.EightBB.Client.Pclient.TextArea.PrivateClient;
import it.EightBB.Client.Powner.Button.GoBackO;
/**
 * classe factory di AbstractFactory che viene utilizzato per creare le componenti del cliente.
 * {@param PclientFactory} parametro di implementazione della classe factory
 */
public class PclientFactory implements AbstractFactory {
    /**
     *
     * @param type parametro per il bottone
     * @return creazione della classe richiesta
     */
    @Override
    public Form makeForm(String type) {
        return switch(type) {
            case "Prenot" -> new PrenotationOne();
            case "Search" -> new RicercaLuogo();
            case "Mod" -> new ModifyProfile();
            case "Payment" -> new PaymentPage();
            default -> null;
        };
    }

    /**
     *
     * @param type parametro per il bottone
     * @return creazione della classe richiesta
     */
    @Override
    public Button makeButton(String type) {
        return switch(type) {
            case "Mod" -> new ModifyProfileC();
            case "Prenota" -> new Prenota();
            case "Booked" -> new BookedStructures();
            case "ModBack" -> new GoBackC();
            default -> null;
        };
    }

    /**
     *
     * @param type parametro per il bottone
     * @return creazione della classe richiesta
     */
    @Override
    public TextGroup makeText(String type) {
        return  switch (type){
            case "Private" -> new PrivateClient();
            default -> null;
        };
    }


}
