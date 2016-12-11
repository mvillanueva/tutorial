package com.uv.project.tutorial;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.uv.project.biometrics.BiometricUtilities;

public class BiometricRecordTest {
	public static final String VALID_FINGER_PRINT_THUMB="F1234GJRIRJG1838THUMB";
	
	public static final int INVALID_QUALITY=1;
	public static final int VALID_QUALITY=5;
			
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
	
	@Test
	public void haveFingerPrintsGoodQualityShouldFailWithOneInvalidQualityFingerprints(){
		BiometricRecord biometricRecord=new BiometricRecord();
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB, 
				BiometricUtilities.FINGER_TYPE.THUMB,
				INVALID_QUALITY);
		biometricRecord.addFingerPrint(finger);
		assertFalse(biometricRecord.haveFingerPrintsGoodQuality());
	}
	
	@Test
	public void haveFingerPrintsGoodQualityShouldFailWithAtLeastOneInvalidQualityFingerprints(){
		BiometricRecord biometricRecord=new BiometricRecord();
		FingerPrint finger1=new FingerPrint(
				VALID_FINGER_PRINT_THUMB, 
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY);
		FingerPrint finger2=new FingerPrint(
				VALID_FINGER_PRINT_THUMB, 
				BiometricUtilities.FINGER_TYPE.THUMB,
				INVALID_QUALITY);
		biometricRecord.addFingerPrint(finger1);
		biometricRecord.addFingerPrint(finger2);
		assertFalse(biometricRecord.haveFingerPrintsGoodQuality());
	}
	
	@Test
	public void haveFingerPrintsGoodQualityShouldFailWithValidQualityFingerprints(){
		BiometricRecord biometricRecord=new BiometricRecord();
		FingerPrint finger=new FingerPrint(
				VALID_FINGER_PRINT_THUMB, 
				BiometricUtilities.FINGER_TYPE.THUMB,
				VALID_QUALITY);
		biometricRecord.addFingerPrint(finger);
		assertTrue(biometricRecord.haveFingerPrintsGoodQuality());
	}
	

}
