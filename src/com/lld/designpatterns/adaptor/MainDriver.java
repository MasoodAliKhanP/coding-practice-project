package com.lld.designpatterns.adaptor;

public class MainDriver {
	public static void main(String[] args) {
		A_WeightingMachine weighingMachine = new A_BabyWeightingMachine();
		B_WeightingMachineAdaptor adaptor = new B_WeightingMachineAdaptorImpl(weighingMachine);
		System.out.println("weigh in kgs: " + adaptor.getWeightInKgs());
	}
}
