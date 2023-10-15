package com.refinery.fuel;

public sealed class Methane implements NaturalGas permits Chloromethane, Dichloromethane {}