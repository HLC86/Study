package com.my.example;

import java.util.ArrayList;
import java.util.HashSet;

class  A implements  Runnable{

	public void run() {
		// TODO Auto-generated method stub
		
	}

}

class  B extends  A{}

public  class FileDel <T extends Runnable> {

   static ArrayList<? extends Runnable> al = new ArrayList<Runnable>();
    static ArrayList al2  = new ArrayList();

   // public  Class<? extends Runnable> getClassA(){return Runnable.class.newInstance();}
    public  Class<? super T> getRunable() {return Runnable.class;}

    public static void main(String[] args){
        //sun.misc.IOUtils.toString(inputStream, "UTF-8")
    	//HashSet<E>
    }
}
