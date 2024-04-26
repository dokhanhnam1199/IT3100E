public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Using String with + operator
        long startTime = System.currentTimeMillis();
        String testString = "";
        for (int i = 0; i < 10000; i++) {
            testString += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for String concatenation: " + (endTime - startTime) + "ms");

        // Using StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer testBuffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            testBuffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for StringBuffer: " + (endTime - startTime) + "ms");

        // Using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder testBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            testBuilder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for StringBuilder: " + (endTime - startTime) + "ms");
    }
}