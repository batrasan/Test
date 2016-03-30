package com.mypack;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Sample extends AbstractMap<String, String> {
	
	
	public static void main(String arr[]){		
		HashMap<String, String> hm= new HashMap<String, String>();		
		hm.put("key1", "value1");		
		Set<Map.Entry<String, String>> s= hm.entrySet();
		Iterator<Entry<String, String>> itr= s.iterator();
		while(itr.hasNext()){
			Map.Entry<String, String> es= (Entry<String, String>) itr.next();
			System.out.println("key is"+es.getKey());			
			Sample sp= new Sample();
			sp.put("key1","value1");
			System.out.println("reached here");				
		}
		
	}

	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return super.put(key, value);			
	}
	
	@Override
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
