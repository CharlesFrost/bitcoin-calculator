
package online.patologia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KursEuro {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("rates")
    @Expose
    private online.patologia.Rates rates;
    @SerializedName("date")
    @Expose
    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public online.patologia.Rates getRates() {
        return rates;
    }

    public void setRates(online.patologia.Rates rates) {
        this.rates = rates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
