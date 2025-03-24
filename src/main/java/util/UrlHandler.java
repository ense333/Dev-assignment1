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
        if(split[1] == null || split[2] == null){
            throw new IllegalArgumentException("Invalid URL");
        }else{
            String[] split1 = split[2].split("\\?");
            division = split[1];
            action = split1[0];
            if(split1.length == 2){
                parameter = split1[1];
            }else{
                parameter = "";
            }
        }
        if(checkHasParameter()){
            try {
                parseParameters(parameter);
            } catch (IllegalArgumentException e) {
                throw e;
            }

        }
    }

    public boolean checkHasParameter(){
        return !parameter.isEmpty() && !parameter.isBlank();
    }


    public void parseParameters(String parameters) {
        String[] split = parameters.split("&");
        if(split.length > 1) {
            for (String s : split) {
                putParameter(s);
            }
        }else {
            putParameter(parameters);
        }
    }

    private void putParameter(String s) {
        String[] valueSet = s.split("=");
        if (valueSet.length == 2) {
            parameterMap.put(valueSet[0], valueSet[1]);
        }else{
            throw new IllegalArgumentException("Invalid parameter");
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
