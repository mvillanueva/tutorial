package com.uv.project.tutorial;

import static org.testng.AssertJUnit.assertTrue;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uv.project.biometrics.BiometricUtilities;

public class BiometricRecordTest {
	public static final String VALID_FINGER_PRINT_THUMB="F1234GJRIRJG1838THUMB";
	
	public static final int INVALID_QUALITY=1;
	public static final int VALID_QUALITY=5;
	@Mock
	FingerPrint fingerMock;
	
	@BeforeMethod
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	
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
		biometricRecord.addFingerPrint(fingerMock);
		
		Mockito.when(fingerMock.getQuality()).thenReturn(INVALID_QUALITY);
		assertFalse(biometricRecord.haveFingerPrintsGoodQuality());
	}
	
	@Test
	public void haveFingerPrintsGoodQualityShouldFailWithAtLeastOneInvalidQualityFingerprints(){
		BiometricRecord biometricRecord=new BiometricRecord();
		Mockito.when(fingerMock.getQuality()).thenReturn(VALID_QUALITY, INVALID_QUALITY);
		biometricRecord.addFingerPrint(fingerMock);
		biometricRecord.addFingerPrint(fingerMock);
		assertEquals(biometricRecord.getNumFingerPrints(), 2);
		assertFalse(biometricRecord.haveFingerPrintsGoodQuality());
	}
	
	@Test
	public void haveFingerPrintsGoodQualityShouldFailWithValidQualityFingerprints(){
		BiometricRecord biometricRecord=new BiometricRecord();
		biometricRecord.addFingerPrint(fingerMock);
		
		Mockito.when(fingerMock.getQuality()).thenReturn(VALID_QUALITY);
		assertTrue(biometricRecord.haveFingerPrintsGoodQuality());
	}
	

}
