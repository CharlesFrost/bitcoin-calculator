
package online.patologia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kurs {

    @SerializedName("time")
    @Expose
    private online.patologia.Time time;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    @SerializedName("chartName")
    @Expose
    private String chartName;
    @SerializedName("bpi")
    @Expose
    private online.patologia.Bpi bpi;

    public online.patologia.Time getTime() {
        return time;
    }

    public void setTime(online.patologia.Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public online.patologia.Bpi getBpi() {
        return bpi;
    }

    public void setBpi(online.patologia.Bpi bpi) {
        this.bpi = bpi;
    }

}
