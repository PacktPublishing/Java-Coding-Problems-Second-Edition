package com.refinery.fuel;

public sealed interface Fuel permits SolidFuel, LiquidFuel, GaseousFuel {}