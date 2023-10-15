package com.refinery.liquidfuel;

import com.rafinery.fuel.type.LiquidFuel;

public sealed class Petroleum implements LiquidFuel permits Diesel, Gasoline, Ethanol {}