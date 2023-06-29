package modern.challenge;

import java.text.MessageFormat;

public class Main {

    public static void main(String[] args) {

        // Ordinary string concatenation
        System.out.println("\n Using ordinary string concatenation (+):\n");

        String fn = "Jo";
        String ln = "Kym";

        String str1 = "<user><firstName>" + fn + "</firstName><lastName>" + ln + "</lastName></user>";
        System.out.println("String literal:\n" + str1);

        String xml1 = """
                     <user>
                        <firstName>\
                     """
                + fn
                + """
                     </firstName>
                        <lastName>\
                     """
                + ln
                + """
                     </lastName>
                     </user>
                     """;

        System.out.println();
        System.out.println("Text block:\n" + xml1);

        String xml2 = """
                     <user>
                        <firstName>
                     """
                + fn.indent(4)
                + """
                        </firstName>
                        <lastName>
                     """
                + ln.indent(4)
                + """
                        </lastName>
                     </user>
                     """;

        System.out.println();
        System.out.println("Text block:\n" + xml2);

        // StringBuilder(Buffer)
        System.out.println("\n Using StringBuilder(Buffer):\n");

        StringBuilder sbStr = new StringBuilder();

        sbStr.append("<user><firstName>")
                .append(fn)
                .append("</firstName><lastName>")
                .append(ln)
                .append("</lastName></user>");
        System.out.println("String literal:\n" + sbStr.toString());

        StringBuilder sbXml1 = new StringBuilder();

        sbXml1.append("""
                     <user>
                        <firstName>""")
                .append(fn)
                .append("""
                        </firstName>
                           <lastName>""")
                .append(ln)
                .append("""
                     </lastName>
                     </user>""");
        
        System.out.println();
        System.out.println("Text block:\n" + sbXml1.toString());
        
        StringBuilder sbXml2 = new StringBuilder();

        sbXml2.append("""
                     <user>
                        <firstName>
                      """)
                .append(fn.indent(4))
                .append("""
                        </firstName>
                        <lastName>
                     """)
                .append(ln.indent(4))
                .append("""
                        </lastName>
                     </user>
                     """);
        
        System.out.println();
        System.out.println("Text block:\n" + sbXml2.toString());

        // Java 1.4, MessageFormat.format()
        System.out.println("\n Using Java 1.4, MessageFormat.format():\n");

        String str2 = MessageFormat.format("<user><firstName>{0}</firstName><lastName>{1}</lastName></user>", fn, ln);
        System.out.println("String literal:\n" + str2);

        String xml3 = MessageFormat.format("""
                                    <user>
                                        <firstName>{0}</firstName>
                                        <lastName>{1}</lastName>
                                    </user>
                                    """, fn, ln);

        System.out.println();
        System.out.println("Text block:\n" + xml3);

        String xml4 = MessageFormat.format("""
                                    <user>
                                        <firstName>
                                         {0}
                                        </firstName>
                                        <lastName>
                                         {1}
                                        </lastName>
                                    </user>
                                    """, fn, ln);

        System.out.println();
        System.out.println("Text block:\n" + xml4);

        // Java 5, String.format()
        System.out.println("\n Using Java 5, String.format():\n");

        String str3 = String.format("<user><firstName>%s</firstName><lastName>%s</lastName></user>", fn, ln);
        System.out.println("String literal:\n" + str3);

        String xml5 = String.format("""
                                    <user>
                                        <firstName>%s</firstName>
                                        <lastName>%s</lastName>
                                    </user>
                                    """, fn, ln);

        System.out.println();
        System.out.println("Text block:\n" + xml5);

        String xml6 = String.format("""
                                    <user>
                                        <firstName>
                                         %s
                                        </firstName>
                                        <lastName>
                                         %s
                                        </lastName>
                                    </user>
                                    """, fn, ln);

        System.out.println();
        System.out.println("Text block:\n" + xml6);

        // Java 15, String.formatted()
        System.out.println("\n Using Java 15, String.formatted() - instance version of String.format():\n");

        String str4 = "<user><firstName>%s</firstName><lastName>%s</lastName></user>".formatted(fn, ln);
        System.out.println("String literal:\n" + str4);

        String xml7 = """
                      <user>
                          <firstName>%s</firstName>
                          <lastName>%s</lastName>
                      </user>
                      """.formatted(fn, ln);

        System.out.println();
        System.out.println("Text block:\n" + xml7);

        String xml8 = """
                      <user>
                          <firstName>
                           %s
                          </firstName>
                          <lastName>
                           %s
                          </lastName>
                      </user>
                      """.formatted(fn, ln);

        System.out.println();
        System.out.println("Text block:\n" + xml8);
    }
}