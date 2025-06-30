package com.oops.example.laptop;

public class RAM {

    private String size;
    private int gen;

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return  "RAM [" + " size: " + getSize()+" gen: "+getGen()+"] " ;
    }
}
