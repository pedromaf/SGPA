package model.sistema;

import java.util.Calendar;

public class Data {

    private int dia = 0;
    private int mes = 0;
    private int ano = 0;

    public Data() {

        Calendar calendario = Calendar.getInstance();

        this.dia = calendario.get(Calendar.DAY_OF_MONTH);
        this.mes = calendario.get(Calendar.MONTH);
        this.ano = calendario.get(Calendar.YEAR);
    }

    public String toString() {

        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
