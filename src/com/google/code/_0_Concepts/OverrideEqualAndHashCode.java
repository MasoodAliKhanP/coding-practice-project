package com.google.code._0_Concepts;

import java.util.HashMap;
import java.util.Map;

class Geek {

	String name;
	int id;

	Geek(String name, int id) {

		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		Geek geek = (Geek) obj;
		return (geek.name.equals(this.name) && geek.id == this.id);
	}

	@Override
	public int hashCode() {
		return this.id;
	}

}

public class OverrideEqualAndHashCode {
	public static void main(String[] args) {
		Geek g1 = new Geek("aditya", 1);
        Geek g2 = new Geek("aditya", 1);
          
        Map<Geek, String> map = new HashMap<Geek, String>();
        map.put(g1, "CSE");
        map.put(g2, "IT"); //overrides the cse value
          
        for(Geek geek : map.keySet())
        {
            System.out.println(map.get(geek).toString());
        }
  
        map.forEach((k,v) -> {
        	System.out.println("key: " + v);
        });
        System.out.println(map.get(new Geek("aditya", 1))); 
        System.out.println(map.get(g1));//IT everywhere
    
	}
}
