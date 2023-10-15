package com.rafinery.fuel.type;

import com.refinery.fuel.Fuel;
import com.refinery.gaseousfuel.NaturalGas;
import com.refinery.gaseousfuel.Propane;

public sealed interface GaseousFuel extends Fuel permits NaturalGas, Propane {}
