package com.lld.designpatterns.adaptor;

public class B_WeightingMachineAdaptorImpl implements B_WeightingMachineAdaptor{

	A_WeightingMachine weightingMachine;
	
	public B_WeightingMachineAdaptorImpl(A_WeightingMachine weightingMachine) {
		this.weightingMachine = weightingMachine;
	}
	
	@Override
	public double getWeightInKgs() {
		double babyWeightInPounds = weightingMachine.getWeightInPounds();
		return babyWeightInPounds * 0.45;
	}

}
