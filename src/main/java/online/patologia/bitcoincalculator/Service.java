package online.patologia.bitcoincalculator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import online.patologia.Kurs;
import online.patologia.KursEuro;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    public Double getBtc() throws IOException {
        final URL urlBtcInEur = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
        InputStreamReader reader = new InputStreamReader(urlBtcInEur.openStream());
        Kurs kurs = new Gson().fromJson(reader,Kurs.class);
        String toFormat = kurs.getBpi().getEUR().getRate();
        toFormat = toFormat.replace(",","");
        return Double.parseDouble(toFormat);

        }

        public Double getEur() throws IOException{
            final URL url = new URL("https://api.exchangeratesapi.io/latest");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            KursEuro kurs = new Gson().fromJson(reader,KursEuro.class);
            return kurs.getRates().getPLN();
        }

        public String calculate(String type, String amount) throws IOException{
        String result;
        String newAmount=amount;
        newAmount = newAmount.replace(" ","");

            if (amount.contains(",") && amount.contains(".")) {
             newAmount = newAmount.replace(",","");
            }
            if (amount.contains(",")) {
             newAmount = newAmount.replace(",",".");
            }
            if (!newAmount.matches("^(?!0*(\\.0+)?$)(\\d+|\\d*\\.\\d+)$")) {
                return "Niepoprawna liczba";
            }



            if (type.equals("fromBTCtoPLN")) {
                Double d = (getEur()*getBtc())*Double.parseDouble(newAmount);
                DecimalFormat f = new DecimalFormat("##.00");
            result = newAmount + " BTC to " + f.format(d)  + " PLN";
        } else {
                result = newAmount + " PLN to " + Double.parseDouble(newAmount)/(getEur()*getBtc()) + " BTC";
            }
            return result;
        }
}
