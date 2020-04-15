import JMeter.*;

import com.sun.javafx.binding.StringFormatter;
import org.json.*;

public class EditArea extends JMeter {
    public void editHere(){
        /*在这个方法中写JMeter中的BeanShell脚本*/

        String response = prev.getResponseDataAsString();
        JSONObject responseJson = new JSONObject(response);
        JSONObject data = responseJson.getJSONObject("data");
        JSONArray items = data.getJSONArray("item");
        Integer count = items.toList().size();
        boolean success = count > 0 ? true : false;
        Failure = !success;
        FailureMessage = success ? null : "查询出的记录条数与预期不符，应至少有一条";
    }
}
