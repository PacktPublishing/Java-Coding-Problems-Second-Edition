package com.rafinery.fuel.type;

import com.refinery.fuel.Fuel;
import com.refinery.liquidfuel.Petroleum;

public sealed interface LiquidFuel extends Fuel permits Petroleum {}
