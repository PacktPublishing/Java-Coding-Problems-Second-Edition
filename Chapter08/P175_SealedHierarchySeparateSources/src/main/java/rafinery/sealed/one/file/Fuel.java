package rafinery.sealed.one.file;

public sealed interface Fuel permits SolidFuel, LiquidFuel, GaseousFuel {}

sealed interface SolidFuel extends Fuel permits Coke, Charcoal {}
sealed interface LiquidFuel extends Fuel permits Petroleum {}
sealed interface GaseousFuel extends Fuel permits NaturalGas, Propane {}

final class Coke implements SolidFuel {}
final class Charcoal implements SolidFuel {}

sealed class Petroleum implements LiquidFuel permits Diesel, Gasoline, Ethanol {}
final class Diesel extends Petroleum {}
final class Gasoline extends Petroleum {}
final class Ethanol extends Petroleum {}

final class Propane implements GaseousFuel {}

sealed interface NaturalGas extends GaseousFuel permits Hydrogen, Methane {}

final class Hydrogen implements NaturalGas {}
sealed class Methane implements NaturalGas permits Chloromethane, Dichloromethane {}

final class Chloromethane extends Methane {}
sealed class Dichloromethane extends Methane permits Trichloromethane {}

final class Trichloromethane extends Dichloromethane {}