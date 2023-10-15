package com.refinery.fuel;

public sealed interface GaseousFuel extends Fuel permits NaturalGas, Propane {}
