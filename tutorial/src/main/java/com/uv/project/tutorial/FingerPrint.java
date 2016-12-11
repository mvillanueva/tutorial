package com.uv.project.tutorial;

import com.uv.project.biometrics.BiometricUtilities;
import com.uv.project.biometrics.BiometricUtilities.FINGER_TYPE;

public class FingerPrint {
	private static final String FINGER_PREFIX_CONDITION= "F1234";
	
	private String content;
	private FINGER_TYPE type;
	private int quality;
	
	public FingerPrint(String content, FINGER_TYPE type, int quality){
		this.content=content;
		this.type=type;
		this.quality=quality;
	}
	
	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public boolean isAFinger(){
		if(content.startsWith(FINGER_PREFIX_CONDITION)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean hasTheCorrectType(){
		if(BiometricUtilities.getType(content).compareTo(type)==0){
			return true;
		}
		else {
			return false;
		}		
	}

}
