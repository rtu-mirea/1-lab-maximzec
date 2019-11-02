package com.company;

public class myStringUsing {
    public static String[] surnameToLowCase(String[] strings){
        String[] _strings = new String[strings.length];
        for (int i = 0; i < strings.length ; i++) {
            int index = strings[i].indexOf(',');
            _strings[i] = strings[i].substring(0,index - 1).toLowerCase() + ',' + strings[i].substring(index+1);
        }
        return _strings;
    }

    public static String[] getSurnameByChar(String[] strings , char a){
        int charCount = 0;
        for (int i = 0; i < strings.length; i++) if(strings[i].charAt(0) == a) charCount++;
        String[] _strings = new String[charCount];
        for (int i = 0; i < strings.length ; i++) {
            if(strings[i].charAt(0) == a ) {
                int index = strings[i].indexOf(' ');
                _strings[charCount-1] = strings[i].substring(0 , index);
                --charCount;
            }
        }
        return _strings;
    }

    public static String getContactsByEmail(String[] strings , String email){
        String[] _strings = new String[strings.length];
        String result = "";
        for (int i = 0; i < strings.length ; ++i) {
            _strings[i] = strings[i].substring(strings[i].indexOf(',')+1);
        }
        for (int i = 0; i < _strings.length ; ++i){
            int eIndex = _strings[i].indexOf('@');
            int dIndex = _strings[i].indexOf('.');
            if(_strings[i].substring(eIndex+1 , dIndex).equals(email)){
                result = result.concat(strings[i] + " ");
            }
        }
        return result;
    }

    public static int getComCount(String[] strings){
        String[] _strings = new String[strings.length];
        int result = 0;
        for (int i = 0; i < strings.length ; ++i) {
            _strings[i] = strings[i].substring(strings[i].indexOf(',')+1);
        }

        for (int i = 0; i < _strings.length ; i++) {
            int eIndex = _strings[i].indexOf('.');
            int endIndex = _strings[i].length() - 1;
            if(_strings[i].substring(eIndex+1 , endIndex).equals("com")) ++result;
        }
        return result;
    }
}
