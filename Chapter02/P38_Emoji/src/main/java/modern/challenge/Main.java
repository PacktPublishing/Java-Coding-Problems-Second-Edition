package modern.challenge;

import java.util.List;

public class Main {

    public static final String STR_NO_EMOJI = "?I love you so much!";
    public static final String STR_WITH_EMOJI = "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {

        System.out.println(Charsets.containsEmojiV1(STR_NO_EMOJI));
        System.out.println(Charsets.containsEmojiV1(STR_WITH_EMOJI));
        
        System.out.println(Charsets.containsEmojiV2(STR_NO_EMOJI));
        System.out.println(Charsets.containsEmojiV2(STR_WITH_EMOJI));
        
        List<String> allEmoji = Charsets.getAllEmoji();
        System.out.println("There are " + allEmoji.size() + " emoji \n");
        System.out.println(allEmoji);
    }
}