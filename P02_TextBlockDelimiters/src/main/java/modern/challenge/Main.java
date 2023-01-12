package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("The common usage of text block delimiters:\n");
        String sql1 = """
                      UPDATE "public"."office"
                      SET ("address_first", "address_second", "phone") =
                        (SELECT "public"."employee"."first_name",
                                "public"."employee"."last_name", ?
                         FROM "public"."employee"
                         WHERE "public"."employee"."job_title" = ?""";

        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql1);
        System.out.println("-- AFTER TEXT BLOCK --");
        
        System.out.println("\nKeep the opening delimiter and the content on the "
                + "same line is not accepted (does not compile)\n");
        /* 
        String not_compile = """UPDATE "public"."office"
                      SET ("address_first", "address_second", "phone") =
                        (SELECT "public"."employee"."first_name",
                                "public"."employee"."last_name", ?
                         FROM "public"."employee"
                         WHERE "public"."employee"."job_title" = ?""";
        */

        System.out.println("\nShift-left the content has no effect:\n");
        String sql2 = """
          UPDATE "public"."office"
          SET ("address_first", "address_second", "phone") =
            (SELECT "public"."employee"."first_name",
                    "public"."employee"."last_name", ?
             FROM "public"."employee"
             WHERE "public"."employee"."job_title" = ?""";
        
        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql2);
        System.out.println("-- AFTER TEXT BLOCK --");        
        
        System.out.println("\nShift-right the opening/closing delimiter has no effect:\n");
        String sql3 =                                           """
          UPDATE "public"."office"
          SET ("address_first", "address_second", "phone") =
            (SELECT "public"."employee"."first_name",
                    "public"."employee"."last_name", ?
             FROM "public"."employee"
             WHERE "public"."employee"."job_title" = ?          """;
        
        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql3);
        System.out.println("-- AFTER TEXT BLOCK --");
                
        System.out.println("\nMoving the closing delimiter on its own line (1):\n");
        String sql4 = """                      
                      UPDATE "public"."office"
                      SET ("address_first", "address_second", "phone") =
                        (SELECT "public"."employee"."first_name",
                                "public"."employee"."last_name", ?
                         FROM "public"."employee"
                         WHERE "public"."employee"."job_title" = ?
                      """;

        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql4);
        System.out.println("-- AFTER TEXT BLOCK --");
        
        System.out.println("\nMoving the closing delimiter on its own line (2):\n");
        String sql5 = """                      
          UPDATE "public"."office"
          SET ("address_first", "address_second", "phone") =
            (SELECT "public"."employee"."first_name",
                    "public"."employee"."last_name", ?
             FROM "public"."employee"
             WHERE "public"."employee"."job_title" = ?
          """;

        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql5);
        System.out.println("-- AFTER TEXT BLOCK --");
        
        System.out.println("\nMoving on its own line and shift-left the closing delimiter:\n");
        String sql6 = """                      
                      UPDATE "public"."office"
                      SET ("address_first", "address_second", "phone") =
                        (SELECT "public"."employee"."first_name",
                                "public"."employee"."last_name", ?
                         FROM "public"."employee"
                         WHERE "public"."employee"."job_title" = ?
        """;

        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql6);
        System.out.println("-- AFTER TEXT BLOCK --");
        
        System.out.println("\nMoving on its own line and shift-right the closing delimiter:\n");
        String sql7 = """                      
                      UPDATE "public"."office"
                      SET ("address_first", "address_second", "phone") =
                        (SELECT "public"."employee"."first_name",
                                "public"."employee"."last_name", ?
                         FROM "public"."employee"
                         WHERE "public"."employee"."job_title" = ?
                                          """;

        System.out.println("-- BEFORE TEXT BLOCK --");
        System.out.println(sql7);
        System.out.println("-- AFTER TEXT BLOCK --");
    }
}