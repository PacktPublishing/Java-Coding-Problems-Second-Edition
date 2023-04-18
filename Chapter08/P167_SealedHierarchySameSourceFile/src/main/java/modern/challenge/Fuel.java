package modern.challenge;

public sealed interface Fuel {}

sealed interface SolidFuel extends Fuel {}
sealed interface LiquidFuel extends Fuel {}
non-sealed interface GaseousFuel extends Fuel {}

final class Coke implements SolidFuel {}
final class Charcoal implements SolidFuel {}

sealed class Petroleum implements LiquidFuel {}
final class Diesel extends Petroleum {}
final class Gasoline extends Petroleum {}
non-sealed class Ethanol extends Petroleum {}

final class Propane implements GaseousFuel {}

sealed interface NaturalGas extends GaseousFuel {}

final class Hydrogen implements NaturalGas {}
non-sealed class Methane implements NaturalGas {}

final class Chloromethane extends Methane {}
sealed class Dichloromethane extends Methane {}

final class Trichloromethane extends Dichloromethane {}