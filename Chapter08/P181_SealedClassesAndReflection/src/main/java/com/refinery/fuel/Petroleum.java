package com.refinery.fuel;

public sealed class Petroleum implements LiquidFuel permits Diesel, Gasoline, Ethanol {}