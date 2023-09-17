package modern.challenge;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        int x = Integer.MIN_VALUE;
        
        int resultFloor = Math.floorDiv(x, -1);
        System.out.println("Result via floorDiv(): " + resultFloor);
        
        int resultCeil = Math.ceilDiv(x, -1);
        System.out.println("Result via ceilDiv(): " + resultCeil);
        
        // throw ArtihmeticException
        int resultFloorExact = Math.floorDivExact(x, -1);
        System.out.println("Result via floorDivExact(): " + resultFloorExact);
        
        // throw ArithmeticException
        BinaryOperator<Integer> operatorf = Math::floorDivExact;
        int floorExactBo = operatorf.apply(x, -1);
        System.out.println("Result via BinaryOperator: " + floorExactBo);
        
        // throw ArtihmeticException
        int resultCeilExact = Math.ceilDivExact(x, -1);
        System.out.println("Result via ceilDivExact(): " + resultCeilExact);
        
        // throw ArtihmeticException
        BinaryOperator<Integer> operatorc = Math::ceilDivExact;
        int ceilExactBo = operatorc.apply(x, -1);
        System.out.println("Result via BinaryOperator: " + ceilExactBo);        
    }
}