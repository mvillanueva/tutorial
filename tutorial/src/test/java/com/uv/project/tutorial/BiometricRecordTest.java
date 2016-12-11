package com.uv.project.tutorial;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.uv.project.biometrics.BiometricUtilities;

public class BiometricRecordTest {
	public static final String VALID_FINGER_PRINT_THUMB="F1234GJRIRJG1838THUMB";
	public static final String INVALID_FINGER_PRINT_THUMB="V5678TTTUTUT45THUMB";
	
	public static final String VALID_FINGER_PRINT_INDEX="F1234GJRIRJG1838INDEX";
	public static final String INVALID_FINGER_PRINT_INDEX="V5678TTTUTUT45INDEX";
	
	public static final int VALID_QUALITY=1;
			
	@Test
	public void addFingerPrintShouldSucceed(){
		BiometricRecord biometricRecord=new BiometricRecord();
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB, 
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY);
		
		biometricRecord.addFingerPrint(finger);
		assertEquals(biometricRecord.getNumFingerPrints(), 1);
	}
	
	@Test
	public void removeFingerPrintShouldSucceed(){
		BiometricRecord biometricRecord=new BiometricRecord();
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB, 
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY);
		
		biometricRecord.addFingerPrint(finger);
		assertEquals(biometricRecord.getNumFingerPrints(), 1);
		
		biometricRecord.removedFingerPrint(finger);
		assertEquals(biometricRecord.getNumFingerPrints(), 0);
	}

}
