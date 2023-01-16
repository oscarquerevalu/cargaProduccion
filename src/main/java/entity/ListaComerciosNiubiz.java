package entity;

import java.util.ArrayList;

public class ListaComerciosNiubiz {
    ArrayList<ComerciosNiubiz> commerces;

    public ListaComerciosNiubiz(ArrayList<ComerciosNiubiz> commerces) {
        this.commerces = commerces;
    }

    public ListaComerciosNiubiz() {}

    public ArrayList<ComerciosNiubiz> getCommerces() {
        return this.commerces;
    }

    public void setCommerces(ArrayList<ComerciosNiubiz> commerces) {
        this.commerces = commerces;
    }
}
