package modern.challenge;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.StringTemplate.Processor;
import java.util.regex.Pattern;

public class PhoneProcessor implements Processor<JsonNode, IllegalArgumentException> {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");

    @Override
    public JsonNode process(StringTemplate stringTemplate) throws IllegalArgumentException {       

        for (Object value : stringTemplate.values()) {

            if (!PHONE_PATTERN.matcher((CharSequence) value).matches()) {
                throw new IllegalArgumentException(
                        "This is not a valid phone number");
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        
        try {
            return mapper.readTree(StringTemplate.interpolate(
                    stringTemplate.fragments(), stringTemplate.values()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
