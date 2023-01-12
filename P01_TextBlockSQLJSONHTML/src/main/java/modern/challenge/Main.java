package modern.challenge;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Before JDK 8
        
        // using the '+' operator
        System.out.println("Multiline SQL/JSON/HTML before text blocks "
                + "(using concatenation via the '+' operator):");
        String sql1
                = "UPDATE \"public\".\"office\"\n"
                + "SET (\"address_first\", \"address_second\", \"phone\") =\n"
                + "  (SELECT \"public\".\"employee\".\"first_name\",\n"
                + "          \"public\".\"employee\".\"last_name\", ?\n"
                + "   FROM \"public\".\"employee\"\n"
                + "   WHERE \"public\".\"employee\".\"job_title\" = ?";

        String json1
                = "{\n"
                + "  \"widget\": {\n"
                + "    \"debug\": \"on\",\n"
                + "    \"window\": {\n"
                + "      \"title\": \"Sample Widget 1\",\n"
                + "      \"name\": \"back_window\"\n"
                + "    },\n"
                + "    \"image\": {\n"
                + "      \"src\": \"images\\sw.png\"\n"
                + "    },\n"
                + "    \"text\": {\n"
                + "      \"data\": \"Click Me\",\n"
                + "      \"size\": 39\n"
                + "    }\n"
                + "  }\n"
                + "}";

        String html1
                = "<table>\n"
                + "  <tr>\n"
                + "    <th colspan=\"2\">Name</th>\n"
                + "    <th>Age</th>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>John</td>\n"
                + "    <td>Smith</td>\n"
                + "    <td>22</td>\n"
                + "  </tr>\n"
                + "<table>";

        System.out.println(sql1);
        System.out.println();
        System.out.println(json1);
        System.out.println();
        System.out.println(html1);

        // using StringBuilder
        System.out.println("\n Multiline SQL/JSON/HTML before text blocks (using StringBuilder):");
        StringBuilder sql2 = new StringBuilder();
        sql2.append("UPDATE \"public\".\"office\"\n")
                .append("SET (\"address_first\", \"address_second\", \"phone\") =\n")
                .append("  (SELECT \"public\".\"employee\".\"first_name\",\n")
                .append("          \"public\".\"employee\".\"last_name\", ?\n")
                .append("   FROM \"public\".\"employee\"\n")
                .append("   WHERE \"public\".\"employee\".\"job_title\" = ?;");

        StringBuilder json2 = new StringBuilder();
        json2.append("{\n")
                .append("  \"widget\": {\n")
                .append("    \"debug\": \"on\",\n")
                .append("    \"window\": {\n")
                .append("      \"title\": \"Sample Widget 1\",\n")
                .append("      \"name\": \"back_window\"\n")
                .append("    },\n")
                .append("    \"image\": {\n")
                .append("      \"src\": \"images\\sw.png\"\n")
                .append("    },\n")
                .append("    \"text\": {\n")
                .append("      \"data\": \"Click Me\",\n")
                .append("      \"size\": 39\n")
                .append("    }\n")
                .append("  }\n")
                .append("}");

        StringBuilder html2 = new StringBuilder();
        html2.append("<table>\n")
                .append("  <tr>\n")
                .append("    <th colspan=\"2\">Name</th>\n")
                .append("    <th>Age</th>\n")
                .append("  </tr>\n")
                .append("  <tr>\n")
                .append("    <td>John</td>\n")
                .append("    <td>Smith</td>\n")
                .append("    <td>22</td>\n")
                .append("  </tr>\n")
                .append("<table>");

        System.out.println(sql2);
        System.out.println();
        System.out.println(json2);
        System.out.println();
        System.out.println(html2);

        // using String#concat()
        System.out.println("\n Multiline SQL/JSON/HTML before text blocks (using String#concat()):");
        String sql3 = "UPDATE \"public\".\"office\"\n"
                .concat("SET (\"address_first\", \"address_second\", \"phone\") =\n")
                .concat("  (SELECT \"public\".\"employee\".\"first_name\",\n")
                .concat("          \"public\".\"employee\".\"last_name\", ?\n")
                .concat("   FROM \"public\".\"employee\"\n")
                .concat("   WHERE \"public\".\"employee\".\"job_title\" = ?;");

        String json3 = "{\n"
                .concat("  \"widget\": {\n")
                .concat("    \"debug\": \"on\",\n")
                .concat("    \"window\": {\n")
                .concat("      \"title\": \"Sample Widget 1\",\n")
                .concat("      \"name\": \"back_window\"\n")
                .concat("    },\n")
                .concat("    \"image\": {\n")
                .concat("      \"src\": \"images\\sw.png\"\n")
                .concat("    },\n")
                .concat("    \"text\": {\n")
                .concat("      \"data\": \"Click Me\",\n")
                .concat("      \"size\": 39\n")
                .concat("    }\n")
                .concat("  }\n")
                .concat("}");

        String html3 = "<table>\n"
                .concat("  <tr>\n")
                .concat("    <th colspan=\"2\">Name</th>\n")
                .concat("    <th>Age</th>\n")
                .concat("  </tr>\n")
                .concat("  <tr>\n")
                .concat("    <td>John</td>\n")
                .concat("    <td>Smith</td>\n")
                .concat("    <td>22</td>\n")
                .concat("  </tr>\n")
                .concat("<table>");

        System.out.println(sql3);
        System.out.println();
        System.out.println(json3);
        System.out.println();
        System.out.println(html3);

        // using String#format()
        System.out.println("\n Multiline SQL/JSON/HTML before text blocks (using String#format()):");
        String sql4 = String.format("%s%s%s%s%s%s",
                "UPDATE \"public\".\"office\"\n",
                "SET (\"address_first\", \"address_second\", \"phone\") =\n",
                "  (SELECT \"public\".\"employee\".\"first_name\",\n",
                "          \"public\".\"employee\".\"last_name\", ?\n",
                "   FROM \"public\".\"employee\"\n",
                "   WHERE \"public\".\"employee\".\"job_title\" = ?;");

        String json4 = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                "{\n",
                "  \"widget\": {\n",
                "    \"debug\": \"on\",\n",
                "    \"window\": {\n",
                "      \"title\": \"Sample Widget 1\",\n",
                "      \"name\": \"back_window\"\n",
                "    },\n",
                "    \"image\": {\n",
                "      \"src\": \"images\\sw.png\"\n",
                "    },\n",
                "    \"text\": {\n",
                "      \"data\": \"Click Me\",\n",
                "      \"size\": 39\n",
                "    }\n",
                "  }\n",
                "}");

        String html4 = String.format("%s%s%s%s%s%s%s%s%s%s%s",
                "<table>\n",
                "  <tr>\n",
                "    <th colspan=\"2\">Name</th>\n",
                "    <th>Age</th>\n",
                "  </tr>\n",
                "  <tr>\n",
                "    <td>John</td>\n",
                "    <td>Smith</td>\n",
                "    <td>22</td>\n",
                "  </tr>\n",
                "<table>");

        System.out.println(sql4);
        System.out.println();
        System.out.println(json4);
        System.out.println();
        System.out.println(html4);

        // Starting with JDK 8
        
        // using String#join()
        System.out.println("\n Multiline SQL/JSON/HTML before text blocks (using String#join()):");
        String sql5 = String.join("\n",
                "UPDATE \"public\".\"office\"",
                "SET (\"address_first\", \"address_second\", \"phone\") =",
                "  (SELECT \"public\".\"employee\".\"first_name\",",
                "          \"public\".\"employee\".\"last_name\", ?",
                "   FROM \"public\".\"employee\"",
                "   WHERE \"public\".\"employee\".\"job_title\" = ?;");

        String json5 = String.join("\n",
                "{",
                "  \"widget\": {",
                "    \"debug\": \"on\",",
                "    \"window\": {",
                "      \"title\": \"Sample Widget 1\",",
                "      \"name\": \"back_window\"",
                "    },",
                "    \"image\": {",
                "      \"src\": \"images\\sw.png\"",
                "    },",
                "    \"text\": {",
                "      \"data\": \"Click Me\",",
                "      \"size\": 39",
                "    }",
                "  }",
                "}");

        String html5 = String.join("\n",
                "<table>",
                "  <tr>",
                "    <th colspan=\"2\">Name</th>",
                "    <th>Age</th>",
                "  </tr>",
                "  <tr>",
                "    <td>John</td>",
                "    <td>Smith</td>",
                "    <td>22</td>",
                "  </tr>",
                "<table>");

        System.out.println(sql5);
        System.out.println();
        System.out.println(json5);
        System.out.println();
        System.out.println(html5);

        // using StringJoiner
        System.out.println("\n Multiline SQL/JSON/HTML before text blocks (using StringJoiner):");
        StringJoiner sql6 = new StringJoiner("\n");
        sql6.add("UPDATE \"public\".\"office\"")
                .add("SET (\"address_first\", \"address_second\", \"phone\") =")
                .add("  (SELECT \"public\".\"employee\".\"first_name\",")
                .add("          \"public\".\"employee\".\"last_name\", ?")
                .add("   FROM \"public\".\"employee\"")
                .add("   WHERE \"public\".\"employee\".\"job_title\" = ?;");

        StringJoiner json6 = new StringJoiner("\n");
        json6.add("{")
                .add("  \"widget\": {")
                .add("    \"debug\": \"on\",")
                .add("    \"window\": {")
                .add("      \"title\": \"Sample Widget 1\",")
                .add("      \"name\": \"back_window\"")
                .add("    },")
                .add("    \"image\": {")
                .add("      \"src\": \"images\\sw.png\"")
                .add("    },")
                .add("    \"text\": {")
                .add("      \"data\": \"Click Me\",")
                .add("      \"size\": 39")
                .add("    }")
                .add("  }")
                .add("}");

        StringJoiner html6 = new StringJoiner("\n");
        html6.add("<table>")
                .add("  <tr>")
                .add("    <th colspan=\"2\">Name</th>")
                .add("    <th>Age</th>")
                .add("  </tr>")
                .add("  <tr>")
                .add("    <td>John</td>")
                .add("    <td>Smith</td>")
                .add("    <td>22</td>")
                .add("  </tr>")
                .add("<table>");

        System.out.println(sql6);
        System.out.println();
        System.out.println(json6);
        System.out.println();
        System.out.println(html6);

        // using Collectors#joining()
        System.out.println("\n Multiline SQL/JSON/HTML before text blocks (using Collectors#joining()):");
        String sql7 = Stream.of(
                "UPDATE \"public\".\"office\"",
                "SET (\"address_first\", \"address_second\", \"phone\") =",
                "  (SELECT \"public\".\"employee\".\"first_name\",",
                "          \"public\".\"employee\".\"last_name\", ?",
                "   FROM \"public\".\"employee\"",
                "   WHERE \"public\".\"employee\".\"job_title\" = ?;")
                .collect(Collectors.joining(String.valueOf("\n")));

        String json7 = Stream.of(
                "{",
                "  \"widget\": {",
                "    \"debug\": \"on\",",
                "    \"window\": {",
                "      \"title\": \"Sample Widget 1\",",
                "      \"name\": \"back_window\"",
                "    },",
                "    \"image\": {",
                "      \"src\": \"images\\sw.png\"",
                "    },",
                "    \"text\": {",
                "      \"data\": \"Click Me\",",
                "      \"size\": 39",
                "    }",
                "  }",
                "}")
                .collect(Collectors.joining(String.valueOf("\n")));

        String html7 = Stream.of(
                "<table>",
                "  <tr>",
                "    <th colspan=\"2\">Name</th>",
                "    <th>Age</th>",
                "  </tr>",
                "  <tr>",
                "    <td>John</td>",
                "    <td>Smith</td>",
                "    <td>22</td>",
                "  </tr>",
                "<table>")
                .collect(Collectors.joining(String.valueOf("\n")));

        System.out.println(sql7);
        System.out.println();
        System.out.println(json7);
        System.out.println();
        System.out.println(html7);

        // Starting with JDK 13/15
        
        // using text blocks
        System.out.println("\n Multiline SQL/JSON/HTML using text blocks:");
        String sql8 = """
                      UPDATE "public"."office"
                      SET ("address_first", "address_second", "phone") =
                        (SELECT "public"."employee"."first_name",
                                "public"."employee"."last_name", ?
                         FROM "public"."employee"
                         WHERE "public"."employee"."job_title" = ?""";

        String json8 = """
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

        String html8 = """
                       <table>
                         <tr>
                           <th colspan="2">Name</th>
                           <th>Age</th>
                         </tr>
                         <tr>
                           <td>John</td>
                           <td>Smith</td>
                           <td>22</td>
                         </tr>
                       <table>""";

        System.out.println(sql8);
        System.out.println();
        System.out.println(json8);
        System.out.println();
        System.out.println(html8);                       
    }
}