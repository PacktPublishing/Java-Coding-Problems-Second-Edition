package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n This whole SQL string is just on one line:");
        String sql1 = """
                     SELECT "public"."employee"."first_name" \
                     FROM "public"."employee" \
                     WHERE "public"."employee"."job_title" = ?\
                     """;
        System.out.println("SQL 1: \n" + sql1);
        System.out.println();
        
        String sql2 = """
                      UPDATE "public"."office" \
                      SET ("address_first", "address_second", "phone") = \
                        (SELECT "public"."employee"."first_name", \
                                "public"."employee"."last_name", ? \
                         FROM "public"."employee" \
                         WHERE "public"."employee"."job_title" = ?\
                      """;
        
        // eliminate extra white spaces
        System.out.println("SQL 2:\n" + sql2);
        System.out.println("SQL 2:\n" + sql2.trim().replaceAll(" +", " "));        
        System.out.println();
        
        String poem1 = """
                          An old silent pond...
                       A frog jumps into the pond,
                         splash!! Silence again.
                       """;
        
        System.out.println("POEM 1\n" + poem1);
        System.out.println();
        
        String poem2 = """
                          An old silent pond...\s\s\s
                       A frog jumps into the pond,
                         splash!! Silence again.\s\s
                       """;        
        System.out.println("POEM 2\n" + poem2);
        
        String poem3 = """
                          An old silent pond...  \s
                       A frog jumps into the pond,
                         splash!! Silence again. \s
                       """;        
        System.out.println("POEM 3\n" + poem3);
    }
}