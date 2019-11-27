package com.company;

public class Doll {
    private String producer;
    private int price , startAge , endAge;

    Doll(){
        this.producer ="";
        this.price = 0;
        this.startAge = 0;
        this.endAge = 0;
    }

    Doll(String producer , int price , int startAge , int endAge) throws Exception {
        if(producer.equals("")) throw new Exception("Имя производителя не может быть пустой строкой");
        this.producer = producer;
        if(price <= 0) throw new Exception("Цена не может быть нулевой или отрицательной");
        this.price = price;
        if(startAge >= endAge) throw new Exception("Конечный возраст не может быть меньше или равен начальному");
        this.startAge = startAge;
        this.endAge = endAge;
    }

    public String getProducer() {
        return producer;
    }

    public int getPrice() {
        return price;
    }

    public int getStartAge() {
        return startAge;
    }

    public int getEndAge() {
        return endAge;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public void setEndAge(int endAge) {
        this.endAge = endAge;
    }

    public Object[] getByRange(int s , int e) throws Exception {
        if(e < s) throw new Exception("Конец не может быть меньше начала");
        if(this.startAge == s && this.endAge == e)
        {
            return new Object[]{this.producer , this.price};
        }
        return null;
    }

    boolean isSameAge(Doll d1 , Doll d2)
    {
        return d1.getStartAge() == d2.getStartAge() && d1.getEndAge() == d2.getEndAge();
    }


    @Override
    public String toString() {
        return "."+producer+"."+price+"."+startAge+"."+endAge+"."+"\n";
    }


}
