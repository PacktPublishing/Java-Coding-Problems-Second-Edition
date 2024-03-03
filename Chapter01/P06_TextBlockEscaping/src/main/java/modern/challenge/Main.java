package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("\n Escaping \" explicitly can be done "
                + "but is not necessary (DON'T DO THIS!):");
        String txt11 = """
                       She told me 
                               \"I have no idea what's going on\"
                       """;
        System.out.println(txt11);
        System.out.println();
        
        System.out.println("\n Escaping \" is done out of the box:");
        String txt12 = """
                       She told me 
                               "I have no idea what's going on"
                       """;
        System.out.println(txt12);
        System.out.println();
        
        System.out.println("\n Escaping \"\" explicitly can be done "
                + "but is not necessary (DON'T DO THIS!):");
        String txt21 = """
                       She told me 
                               \"\"I have no idea what's going on\"\" 
                       """;
        System.out.println(txt21);
        System.out.println();
        
        System.out.println("\n Escaping \"\" is done out of the box:");
        String txt22 = """
                       She told me 
                               ""I have no idea what's going on"" 
                       """;
        System.out.println(txt22);
        System.out.println();
        
        System.out.println("\n Escaping \"\"\" can be done as following:");
        String txt1 = """
                      She told me 
                              \"""I have no idea what's going on\""" 
                       """;
        System.out.println(txt1);
        System.out.println();

        System.out.println("\n Escaping \\n can be done explicitly "
                + "but is not necessary (DON'T DO THIS UNLESS YOU REALLY NEED IT!):");
        String sql1 = """
                     SELECT "public"."employee"."first_name",\n
                            "public"."employee"."last_name", ?\n
                     FROM "public"."employee"\n
                     WHERE "public"."employee"."job_title" = ?
                     """;
        System.out.println(sql1);
        System.out.println();
        
        System.out.println("\n Escaping \\n is done out of the box:");
        String sql2 = """
                     SELECT "public"."employee"."first_name", 
                            "public"."employee"."last_name", ?
                     FROM "public"."employee"
                     WHERE "public"."employee"."job_title" = ?
                     """;
        System.out.println(sql2);
        System.out.println();
        
        System.out.println("\n Using \\b, \\t, \\r, \\n, \\f can be done as usual "
                + "(however, think twice if you really need to use escape sequences):");
        
        String txt2 = """
                        \b\bShe told me\n
                      \t""I have no idea what's going on"" 
                      """;
        System.out.println(txt2);
        System.out.println();
        
        String txt3 = """
                      She told me
                      
                              ""I have no idea what's going on"" 
                      """;
        System.out.println(txt3);
        System.out.println();
        
        System.out.println("\n Embedding \\\" (or any other escape sequence) can be done as usual:");
        String sql3 = """
                     SELECT \\"public\\".\\"employee\\".\\"first_name\\", \\"public\\".\\"employee\\".\\"last_name\\", ?
                     FROM \\"public\\".\\"employee\\"
                     WHERE \\"public\\".\\"employee\\".\\"job_title\\" = ?
                     """;
        System.out.println(sql3);        
    }
}