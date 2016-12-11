package com.uv.project.tutorial;

public class FingerPrint {
	private String content;
	private int type;
	private int quality;
	
	public FingerPrint(String content, int type, int quality){
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
		if(content.startsWith("F1234")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void hasTheCorrectType(){
//		if(BiometricUtilities.getType(content)==this.type)
//			return true;
//		else {
//			return false;
//		}
		
	}

}
