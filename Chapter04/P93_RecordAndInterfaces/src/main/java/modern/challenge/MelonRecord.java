package modern.challenge;

public record MelonRecord(String type, float weight) implements PestInspector {

    @Override
    public void exterminatePest() {
        
        if (detectPest()) {
            System.out.println("All pests have been exterminated");
        } else {
            System.out.println("This melon is clean, no pests have been found");
        }
    }
}
