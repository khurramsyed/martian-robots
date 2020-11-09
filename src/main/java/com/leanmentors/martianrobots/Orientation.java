package com.leanmentors.martianrobots;

public enum Orientation {

    N('N'),
    E('E'),
    S('S'),
    W('W');

    private Character orientation;

    Orientation(Character orientation) {
        this.orientation = orientation;
    }

    private Orientation getById(int id){
        return values()[id];
    }

    private int currentOrientationIndex(){
        Orientation[] values = values();
       for (int i =0 ;i< values.length; i++){
           if(values[i].orientation == orientation){
               return i;
           }
       }
       return -1;
    }

    public Orientation rotateLeft(){
        if(orientation=='N') return W;
        return values()[currentOrientationIndex()-1];
    }

    public Orientation rotateRight(){
        if(orientation=='W') return N;
        return values()[currentOrientationIndex()+1];
    }




}
