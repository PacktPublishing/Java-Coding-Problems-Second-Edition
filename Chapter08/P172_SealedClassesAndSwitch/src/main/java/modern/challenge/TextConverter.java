package modern.challenge;

public sealed abstract class TextConverter permits Utf8, Utf16, Utf32 {}
