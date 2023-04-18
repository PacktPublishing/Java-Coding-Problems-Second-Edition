package com.refinery.gaseousfuel;

import com.rafinery.fuel.type.GaseousFuel;

public sealed interface NaturalGas extends GaseousFuel permits Hydrogen, Methane {}
