package com.rafinery.fuel.type;

import com.refinery.fuel.Fuel;
import com.refinery.solidfuel.Charcoal;
import com.refinery.solidfuel.Coke;

public sealed interface SolidFuel extends Fuel permits Coke, Charcoal {}