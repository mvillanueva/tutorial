package com.uv.project.tutorial;

import java.util.ArrayList;
import java.util.List;

public class BiometricRecord {
	private static final int MINIMUM_QUALITY=2;
		
	private List<FingerPrint> listFingerPrint;
	
	public BiometricRecord(){
		listFingerPrint=new ArrayList<FingerPrint>();
	}
	
	public void addFingerPrint(FingerPrint newFinger){
		this.listFingerPrint.add(newFinger);
	}
	
	public void removedFingerPrint(FingerPrint newFinger){
		this.listFingerPrint.remove(newFinger);
	}
	
	public int getNumFingerPrints(){
		return this.listFingerPrint.size();
	}
	
	public boolean haveFingerPrintsGoodQuality(){
		for(FingerPrint finger:this.listFingerPrint){
			if(finger.getQuality()<MINIMUM_QUALITY)
				return false;
		}
		return true;		
	}
}
