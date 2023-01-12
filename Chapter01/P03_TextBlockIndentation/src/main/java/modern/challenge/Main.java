package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nThe opening and closing delimiters are aligned:");
        String json1 = """
                       {
                         "widget": {
                           "debug": "on",
                           "window": {
                              "title": "Sample Widget 1",
                              "name": "back_window"
                           },
                           "image": {
                             "src": "images\\sw.png"
                           },
                           "text": {
                             "data": "Click Me",
                             "size": 39
                           }
                         }
                       }""";
        System.out.println(json1);

        System.out.println("\nThe closing delimiter is at the end of the content and "
                + "shifted-right with the content:");
        String json2 = """
                                {
                                  "widget": {
                                    "debug": "on",
                                    "window": {
                                       "title": "Sample Widget 1",
                                       "name": "back_window"
                                    },
                                    "image": {
                                      "src": "images\\sw.png"
                                    },
                                    "text": {
                                      "data": "Click Me",
                                      "size": 39
                                    }
                                  }
                                }""";
        System.out.println(json2);

        System.out.println("\nAdding more meaningful (or essential) white spaces"
                + " by shifting-right the content:");
        String json3 = """
                               {
                                 "widget": {
                                   "debug": "on",
                                   "window": {
                                      "title": "Sample Widget 1",
                                      "name": "back_window"
                                   },
                                   "image": {
                                     "src": "images\\sw.png"
                                   },
                                   "text": {
                                     "data": "Click Me",
                                     "size": 39
                                   }
                                 }
                               }
                       """;
        System.out.println(json3);

        System.out.println("\nAdding more meaningful (or essential) white spaces"
                + " by shifting-left the closing delimiter:");
        String json4 = """
                       {
                         "widget": {
                           "debug": "on",
                           "window": {
                              "title": "Sample Widget 1",
                              "name": "back_window"
                           },
                           "image": {
                             "src": "images\\sw.png"
                           },
                           "text": {
                             "data": "Click Me",
                             "size": 39
                           }
                         }
                       }     
               """;
        System.out.println(json4);

        System.out.println("\nAdding more meaningful (or essential) white spaces"
                + " by adjusting the content's lines:");
        String json5 = """
                       {
                           "widget": {
                                         "debug": "on",
                                         "window": {
                                                       "title": "Sample Widget 1",
                                                       "name": "back_window"
                                         },
                                         "image":  {
                                                       "src": "images\\sw.png"
                                         },
                                         "text":   {
                                                       "data": "Click Me",
                                                       "size": 39
                                         }
                           }
                       }""";

        System.out.println(json5);

        System.out.println("\nAdding essential white spaces via String#indent():");
        String json6 = """
                       {
                         "widget": {
                           "debug": "on",
                           "window": {
                              "title": "Sample Widget 1",
                              "name": "back_window"
                           },
                           "image": {
                             "src": "images\\sw.png"
                           },
                           "text": {
                             "data": "Click Me",
                             "size": 39
                           }
                         }
                       }""".indent(8);
        System.out.println(json6);        
        
        System.out.println("\nIndent a block of text having lines "
                + "placed at the same level of indentation (using JDK 14, \\, escape sequence):");
        String poem1 = """
                       I would want to establish strength; root-like,
                       anchored in the hopes of solidity.
                       
                       Forsake the contamination of instability.
                       Prove I’m the poet of each line of prose.\
                 """;
        System.out.println(poem1);
        
        System.out.println("\nIndent a block of text having lines "
                + "placed at the same level of indentation (before JDK 11):");
        String poem2 = """
                       I would want to establish strength; root-like,
                       anchored in the hopes of solidity.
                       
                       Forsake the contamination of instability.
                       Prove I’m the poet of each line of prose.
                 """.replaceFirst("\\s++$", "");
        System.out.println(poem2);
        
        System.out.println("\nIndent a block of text having lines "
                + "placed at the same level of indentation (starting with JDK 11):");
        String poem3 = """
                       I would want to establish strength; root-like,
                       anchored in the hopes of solidity.
                       
                       Forsake the contamination of instability.
                       Prove I’m the poet of each line of prose.
                 """.stripTrailing();
        System.out.println(poem3);
        
        System.out.println("\nIndent a block of text having lines "
                + "placed at the same level of indentation (starting with JDK 12):");
        String poem4 = """
                       I would want to establish strength; root-like,
                       anchored in the hopes of solidity.
                       
                       Forsake the contamination of instability.
                       Prove I’m the poet of each line of prose."""
                .indent(6)
                .stripTrailing();
        System.out.println(poem4);
    }
}