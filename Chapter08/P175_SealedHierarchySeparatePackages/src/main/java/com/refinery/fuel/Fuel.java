package com.refinery.fuel;

import com.rafinery.fuel.type.GaseousFuel;
import com.rafinery.fuel.type.LiquidFuel;
import com.rafinery.fuel.type.SolidFuel;

public sealed interface Fuel permits SolidFuel, LiquidFuel, GaseousFuel {}