package util;

import java.util.HashMap;
import java.util.Map;

public class UrlHandler {

    private final String division;
    private final String action;
    private final String parameter;

    private final Map<String, String> parameterMap = new HashMap<String, String>();

    public UrlHandler(String url) {
        String[] split = url.split("/");   //혹시 잘
        if(split[0] == null || split[1] == null){
            throw new IllegalArgumentException("Invalid URL");
        }else{
            // /sfsdfsdf/dsffsdffs?name=wqewqeqw
            String[] split1 = split[2].split("\\?");
            division = split[1];
            action = split1[0];
            parameter = split1[1];
        }
        if(checkHasParameter()){
            parseParameters(parameter);
        }
    }

    public boolean checkHasParameter(){
        return !parameter.isEmpty() && !parameter.isBlank();
    }


    public void parseParameters(String parameters) {
        String[] split = parameters.split("&");
        if(split.length > 1) {
            for (String s : split) {
                String[] valueSet = s.split("=");
                if (valueSet.length == 2) {
                    parameterMap.put(valueSet[0], valueSet[1]);
                }else{
                    parameterMap.put(valueSet[0], "");
                }
            }
        }
    }

    public String getDivision() {
        return division;
    }

    public String getAction() {
        return action;
    }

    public String getParameter() {
        return parameter;
    }

    public Map<String, String> getParameterMap() {
        return parameterMap;
    }
}
