package com.company;

public class myStringBufferUsing {
    private StringBuffer stringBuffer;

    myStringBufferUsing(StringBuffer stringBuffer)
    {
        this.stringBuffer = stringBuffer;
    }
    public void addNewContact(String contact){
        stringBuffer.append(contact).append("\n");
    }

    public void repairContacts(){
        for (int i = 0; i < stringBuffer.length() ; i++) {
            if (stringBuffer.charAt(i) == '\n'){
                if(stringBuffer.charAt(i-1) == '@'){
                    stringBuffer.insert(i , "mail.ru.");
                }
            }
        }
    }

    public void insertCountToBegin(){
        int count = 0;
        for (int i = 0; i < stringBuffer.length() ; i++) {
            if(stringBuffer.charAt(i) == '\n') ++count;
        }
        stringBuffer.insert(0 , "Количество контактов = " + count+ "\n");
    }

    public StringBuffer getStringBuffer(){
        return this.stringBuffer;
    }
}
