package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nRemoving incidental white spaces (1):");
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
            }     
            """;
        System.out.println(json1);

        System.out.println("\nRemoving incidental white spaces (2):");
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
                                    }     
                       """;
        System.out.println(json2);

        System.out.println("\nRemoving incidental white spaces (3):");
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

        System.out.println("\nRemoving incidental white spaces (4):");
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
    }
}
