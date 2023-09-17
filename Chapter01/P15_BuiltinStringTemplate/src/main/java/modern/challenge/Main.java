package modern.challenge;

import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;
import java.time.LocalDate;
import static java.util.FormatProcessor.FMT;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LocalDate fiscalDate = LocalDate.now();
        double value = 4552.2367;
        String employeeCode = "RN4555";

        String jsonText = "{\"sale\": {\n"
                + "    \"id\": 1,\n"
                + "    \"details\": {\n"
                + "        \"fiscal_year\": %d,\n".formatted(fiscalDate.getYear())
                + "        \"employee_nr\": \"%s\",\n".formatted(employeeCode)
                + "        \"value\": %.2f \n".formatted(value)
                + "    }\n"
                + "}";

        String jsonBlock = """
                         {"sale": {
                             "id": 1,
                             "details": {
                                 "fiscal_year": %d,
                                 "employee_nr": "%s",
                                 "value": %.2f 
                             }
                         }
                         """.formatted(fiscalDate.getYear(), employeeCode, value);

        String jsonTextStr = "{\"sale\": {\n"
                + "    \"id\": 1,\n"
                + "    \"details\": {\n"
                + STR."        \"fiscal_year\": \{fiscalDate.getYear()},\n"
                + STR."        \"employee_nr\": \"\{employeeCode}\",\n"
                + STR.
        "        \"value\": \{value} \n"
                + "    }\n"
                +"}";
                
        String jsonBlockStr = STR."""
                         {"sale": {
                             "id": 1,
                             "details": {
                                 "fiscal_year": \{fiscalDate.getYear()},
                                 "employee_nr": "\{employeeCode}",
                                 "value": \{value} 
                             }
                         }
                         """;
                         
        String jsonBlockFmt = FMT."""
                         {"sale": {
                             "id": 1,
                             "details": {
                                 "fiscal_year": \{fiscalDate.getYear()},
                                 "employee_nr": "\{employeeCode}",
                                 "value": %.2f\{value} 
                             }
                         }
                         """;                         
                
                         
        LocalDate fiscalDate1 = LocalDate.of(2023, 2, 4);                         
        LocalDate fiscalDate2 = LocalDate.of(2024, 3, 12);
        double value1 = 343.23;
        double value2 = 1244.33;
            
        StringTemplate templateRaw = RAW."""                                                      
                             "employee_nr": "\{employeeCode}",
                             """;             
                             
        String jsonBlockRaw = STR.""" 
                         {"sale": {
                             "id": 1,
                             "details": {                                
                                "fiscal_year": \{fiscalDate1.getYear()},
                                \{templateRaw.interpolate()}\
                                "value": \{value1}     
                             }
                         },
                         {"sale": {
                             "id": 2,
                              "details": {
                                 "fiscal_year": \{fiscalDate2.getYear()},
                                 \{templateRaw.interpolate()}\
                                 "value": \{value2}    
                              }
                         }           
                         """;                                                                          
                         
        System.out.println("Simple JSON and formatted():");
        System.out.println(jsonText);
        System.out.println("\nJSON text-block and formatted():");
        System.out.println(jsonBlock);
        System.out.println("Simple JSON and STR:");
        System.out.println(jsonTextStr);
        System.out.println("\nJSON text-block and STR:");
        System.out.println(jsonBlockStr);
        System.out.println("\nJSON text-block and FMT:");
        System.out.println(jsonBlockFmt);
        System.out.println("\nJSON text-block and RAW :");
        System.out.println(jsonBlockRaw);
        
        String employeeCodeString = templateRaw.interpolate();
        System.out.println("\nEmployee code :");
        System.out.println(employeeCodeString);
        
        List<String> trFragments = templateRaw.fragments();
        System.out.println("Fragments:\n" + trFragments);                
        
        List<Object> trValues = templateRaw.values();
        System.out.println("Values:\n" + trValues);                
    }
}