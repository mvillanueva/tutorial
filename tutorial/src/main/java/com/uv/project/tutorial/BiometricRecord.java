package com.uv.project.tutorial;

import java.util.List;

public class BiometricRecord {
	public final int THUMB=0;
	public final int INDEX=1;
	public final int MIDDLE=2;
	public final int RING=3;
	public final int PINKIE=4;
		
	private List<FingerPrint> listFingerPrint;
	private int num;
	
	public BiometricRecord(){}
	
	public void addFingerPrint(FingerPrint newFinger){
		this.listFingerPrint.add(newFinger);
		num=this.listFingerPrint.size();
	}
	
	public void removedFingerPrint(FingerPrint newFinger){
		this.listFingerPrint.remove(newFinger);
		num=this.listFingerPrint.size();
	}
	
	public int getNumFingerPrints(){
		return num;
	}
	
	public boolean haveFingerPrintsGoodQuality(){
		for(FingerPrint f:this.listFingerPrint){
			if(f.getQuality()<2)
				return false;
		}
		return true;		
	}
}
