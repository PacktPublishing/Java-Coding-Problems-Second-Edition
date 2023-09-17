package modern.challenge;

import java.lang.StringTemplate.Processor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneProcessor implements Processor<String, IllegalArgumentException> {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");

    @Override
    public String process(StringTemplate stringTemplate) throws IllegalArgumentException {
         
        List<Object> newValues = new ArrayList<>();
        List<Object> values = stringTemplate.values();
        List<String> fragments = stringTemplate.fragments();
        for (int i = 0; i < values.size(); i++) {

            if (fragments.get(i).contains("<phone>") 
                    && !PHONE_PATTERN.matcher((CharSequence) values.get(i)).matches()) {
                newValues.add("098-788-0000");
            } else {
                newValues.add(values.get(i));
            }
        }

        return StringTemplate.interpolate(fragments, newValues);
    }
}
