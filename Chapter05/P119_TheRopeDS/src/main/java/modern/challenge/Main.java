package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Rope.Node I = new Rope.Node("I");
        Rope.Node am = new Rope.Node("am");
        Rope.Node a = new Rope.Node("a");
        Rope.Node very = new Rope.Node("very");
        Rope.Node cool = new Rope.Node("cool");
        Rope.Node rope = new Rope.Node("rope");

        Rope.Node Iam = Rope.concat(I, am);
        Rope.Node avery = Rope.concat(a, very);
        Rope.Node coolrope = Rope.concat(cool, rope);
        Rope.Node Iamavery = Rope.concat(Iam, avery);
        Rope.Node Iamaverycoolrope = Rope.concat(Iamavery, coolrope);

        // print the rope as a string
        System.out.println("Print the rope as a string:");
        System.out.println("------------------------------------------------\n");
        System.out.println(Iamaverycoolrope.buildStr());
        System.out.println();

        // print the rope as a tree
        System.out.println("Print the rope as a tree:");
        System.out.println("------------------------------------------------\n");
        System.out.println(Iamaverycoolrope); // call toString()
        System.out.println();

        // get character at index 5
        System.out.println("Get character at index 5:");
        System.out.println("------------------------------------------------\n");
        char fivech = Rope.indexAt(Iamaverycoolrope, 5);
        System.out.println("Character at position 5: " + fivech);
        System.out.println();

        // insert a new node       
        System.out.println("Insert a node:");
        System.out.println("------------------------------------------------\n");
        Rope.Node Iamasuperverycoolrope = Rope.insert(Iamaverycoolrope, 8, "super");
        System.out.println(Iamasuperverycoolrope.buildStr());
        System.out.println();
        System.out.println(Iamasuperverycoolrope);
        System.out.println();

        // delete a node
        System.out.println("Delete a node:");
        System.out.println("------------------------------------------------\n");
        Iamaverycoolrope = Rope.delete(Iamasuperverycoolrope, 8, 13);
        System.out.println(Iamaverycoolrope.buildStr());
        System.out.println(Iamaverycoolrope);
        System.out.println();

        // split the rope in two ropes
        System.out.println("Split the rope in two ropes:");
        System.out.println("------------------------------------------------\n");
        List<Rope.Node> ropes = Rope.split(Iamaverycoolrope, 8);
        System.out.println(ropes.get(0).buildStr());
        System.out.println(ropes.get(1).buildStr());
        System.out.println();
        System.out.println(ropes.get(0));
        System.out.println();
        System.out.println(ropes.get(1));
    }
}