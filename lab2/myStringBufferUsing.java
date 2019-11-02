package com.company;

public class myStringBufferUsing {

    public static void addNewContact(StringBuffer stringBuffer, String contact){
        stringBuffer.append(contact).append("\n");
    }

    public static void repairContacts(StringBuffer stringBuffer){
        for (int i = 0; i < stringBuffer.length() ; i++) {
            if (stringBuffer.charAt(i) == '\n'){
                if(stringBuffer.charAt(i-1) == '@'){
                    stringBuffer.insert(i , "mail.ru.");
                }
            }
        }
    }

    public static void insertCountToBegin(StringBuffer stringBuffer){
        int count = 0;
        for (int i = 0; i < stringBuffer.length() ; i++) {
            if(stringBuffer.charAt(i) == '\n') ++count;
        }
        stringBuffer.insert(0 , "Количество контактов = " + count+ "\n");
    }
}
