package com.refinery.fuel;

public sealed interface SolidFuel extends Fuel permits Coke, Charcoal {}