package com.ctli.it.library;
import java.net.URL;

import com.ctli.it.xml.IntDataContainer;
import com.ctli.it.xml.XMLDataParser;

import net.thucydides.core.steps.ScenarioSteps;


@SuppressWarnings("serial")
public abstract class Steps extends ScenarioSteps {

	protected static Environment currentEnvironment;
	protected static IntDataContainer data;
	protected static IntDataContainer envData;
	protected static IntDataContainer commonData;
	private static STAFController controller;
	public static boolean isInitialized = false;
	
	public static void initialize() {
		if (!isInitialized) {
			System.out.println("initialzed");
			initEnv();
			initData("data.xml");
		}
	}
	
	private static void initEnv() {
		controller = STAFController.getInstance();
		
       System.out.println("get instace");
		if (!controller.isInitialized()) {
			System.out.println("not get ");
			throw new IllegalStateException("STAF Controller is not initialized. Please contact Framework Administrator.");
		}
		currentEnvironment = controller.getEnvironment();
	}
	
	private  static void initData(String xmlName) {
		System.out.println(Thread.currentThread()+"Ankit");
		URL url = Thread.currentThread().getContextClassLoader().getResource(xmlName);
		//System.out.println(url.);
		//URL url = Thread.currentThread().getClass().getResource(xmlName);
		System.out.println(url.toString()+"url");
		data = new XMLDataParser().parseXML(xmlName);
		envData = data.getContainer("Environments").getContainer(currentEnvironment.getKey());
		System.out.println(envData);
		commonData = data.getContainer("CommonData");
		System.out.println(commonData);
		isInitialized = true;
	}
}
