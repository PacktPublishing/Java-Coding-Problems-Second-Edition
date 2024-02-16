package modern.challenge;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");

    public static void main(String[] args) throws IOException {

        StringTemplate.Processor<JsonNode, IllegalArgumentException> pp
                = (StringTemplate st) -> {

                    var values = st.values().stream()
                            .map(value -> {
                                if (!PHONE_PATTERN.matcher((CharSequence) value).matches()) {
                                    return "Invalid phone number";
                                }

                                return value;
                            }).toList();

                    ObjectMapper mapper = new ObjectMapper();

                    try {
                        return mapper.readTree(StringTemplate.interpolate(
                                st.fragments(), values));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                };

        String workPhone = "072-825-90095"; // not valid
        String homePhone = "(040)234-9670";

        JsonNode jsonMessage = pp.
        """
           { "contact": {
               "work": "\{workPhone}",
               "home": "\{homePhone}"
               }
           }  
           """;
           
        System.out.println(jsonMessage);
    }
}