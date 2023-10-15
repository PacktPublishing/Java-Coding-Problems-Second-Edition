package com.refinery.fuel;

public sealed interface NaturalGas extends GaseousFuel permits Hydrogen, Methane {}
