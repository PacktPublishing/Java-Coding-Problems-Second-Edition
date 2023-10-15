package com.melon.co;

public sealed interface Melon {}

non-sealed interface Pumpkin extends Melon {}

final class Gac implements Melon {}
final class Cantaloupe implements Melon {}
final class Hami implements Melon {}