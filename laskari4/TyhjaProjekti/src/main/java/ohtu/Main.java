package ohtu;

import com.google.gson.Gson; 
import java.io.IOException; 
import java.io.InputStream; 
import org.apache.commons.httpclient.HttpClient; 
import org.apache.commons.httpclient.methods.GetMethod; 
import org.apache.commons.io.IOUtils;   
public class Main {
    public static void main(String[] args) throws IOException {
        String studentNr = "12345678";
        if ( args.length>0) {
            studentNr = args[0];
        }           
        String url = "http://ohtustats.herokuapp.com/opiskelija/"+studentNr+".json";
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);
        InputStream stream =  method.getResponseBodyAsStream();
        String bodyText = IOUtils.toString(stream);
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );
        Gson mapper = new Gson();
        int tunteja=0;
        Palautukset palautukset = mapper.fromJson(bodyText, Palautukset.class);
        //System.out.println("oliot:");
        boolean first=true;
        for (Palautus palautus : palautukset.getPalautukset()) {
            if(first){
                System.out.println(palautus.getEtunimi() + " " + palautus.getSukunimi() + " opiskelijanumero " + palautus.getOpiskelijanumero()+ "\n");
                first=false;
            }
            System.out.print("Viikko " + palautus.getViikko()+": ");
            System.out.println( palautus.getTehtavia() + " tehtävää " + palautus.getTehtavat() + "   aikaa kului " + palautus.getTunteja());
            tunteja += palautus.getTunteja();
        }
        System.out.println("\nTunteja yhteensä: " + tunteja);
    }
}