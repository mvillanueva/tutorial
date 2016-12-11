package com.uv.project.tutorial;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import com.uv.project.biometrics.BiometricUtilities;

public class FingerPrintTest {
	public static final String VALID_FINGER_PRINT_THUMB="F1234GJRIRJG1838THUMB";
	public static final String INVALID_FINGER_PRINT_THUMB="V5678TTTUTUT45THUMB";
	
	public static final int VALID_QUALITY=5;
	
	@Test
	public void isAFingerShouldSucceedWithValidFinger(){
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB,
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY
				);
		assertTrue(finger.isAFinger());
		
	}
	
	
	@Test
	public void isAFingerShouldFailWithInValidFinger(){
		FingerPrint finger=new FingerPrint(
				INVALID_FINGER_PRINT_THUMB,
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY
				);
		assertFalse(finger.isAFinger());
		
	}
	
	
	@Test
	public void hasTheCorrectTypeShouldSuceedWithCorrespondingType(){
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB,
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY
				);
		assertTrue(finger.hasTheCorrectType());
	}
	
	@Test
	public void hasTheCorrectTypeShouldFailWithCorrespondingType(){
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB,
				BiometricUtilities.FINGER_TYPE.INDEX,
				VALID_QUALITY
				);
		assertFalse(finger.hasTheCorrectType());
	}

}
