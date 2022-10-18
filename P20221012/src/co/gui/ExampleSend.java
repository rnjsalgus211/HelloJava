package co.gui;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class ExampleSend {
  public static void main(String[] args) {
    String api_key = "NCSDLFR1LW0PGI1U";
    String api_secret = "SOBZYTM9OOJTGF0MO59ML0SXQRE0ZIES";
    Message coolsms = new Message(api_key, api_secret);

    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", "01050283355"); // 수신번호
    params.put("from", "01050283355"); // 발신번호
    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
    params.put("text", "Test Message"); // 문자내용    
    params.put("app_version", "JAVA SDK v1.2"); // application name and version


    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}
