package deque;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Timing test
 * add and remove operation of LinkedListDeque.java must take "constant time",
 * i.e. execution time should not depend on the size of the deque.
 *
 * get operation of LinkedListDeque.java should take time proportional to
 * the number of items
 *
 * reference: CS61B prof hug
 */
public class TimingTest {
    private static void printTimingTable(int[] Ns, double[] times, int[] opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.length; i += 1) {
            int N = Ns[i];
            double time = times[i];
            int opCount = opCounts[i];
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
     }

     public static void main(String[] args) {
        System.out.println("---------Timing LinkedListDeque.java addFirst method-------");
        timeLinkedListDequeAddFirst();

         System.out.println("---------Timing LinkedListDeque.java addLast method-------");
         timeLinkedListDequeAddLast();

         System.out.println("---------Timing LinkedListDeque.java removeFirst method-------");
         timeLinkedListDequeRemoveFirst();

         System.out.println("---------Timing LinkedListDeque.java removeLast method-------");
         timeLinkedListDequeRemoveLast();

         System.out.println("---------Timing LinkedListDeque.java get method-------");
         timeLinkedListDequeGet();

         System.out.println("---------Timing LinkedListDeque.java getRecursive method-------");
         timeLinkedListDequeGetRecursive();
     }

     public static void timeLinkedListDequeAddFirst() {
         int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 1000000};
         int[] opCounts = new int[Ns.length];
         double[] times = new double[Ns.length];

         for (int i = 0; i < Ns.length; i++) {
             opCounts[i] = Ns[i];
             LinkedListDeque<String> lld = new LinkedListDeque<>();
             Stopwatch sw = new Stopwatch();
             for (int j = 0; j < Ns[i]; j++) {
                 lld.addFirst("a");
             }
             times[i] = sw.elapsedTime();
         }
         printTimingTable(Ns, times, opCounts);
     }

    public static void timeLinkedListDequeAddLast() {
        int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 1000000};
        int[] opCounts = new int[Ns.length];
        double[] times = new double[Ns.length];

        for (int i = 0; i < Ns.length; i++) {
            opCounts[i] = Ns[i];
            LinkedListDeque<String> lld = new LinkedListDeque<>();
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < Ns[i]; j++) {
                lld.addLast("a");
            }
            times[i] = sw.elapsedTime();
        }
        printTimingTable(Ns, times, opCounts);
    }



    public static void timeLinkedListDequeRemoveFirst() {
        int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 1000000};
        int[] opCounts = new int[Ns.length];
        double[] times = new double[Ns.length];

        for (int i = 0; i < Ns.length; i++) {
            // Construction of varied size Deque
            LinkedListDeque<String> lld = new LinkedListDeque<>();
            for (int j = 0; j < Ns[i]; j++) {
                lld.addLast("a");
            }

            opCounts[i] = Ns[i];
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < opCounts[i]; j++) {
                lld.removeFirst();
            }
            times[i] = sw.elapsedTime();
        }
        printTimingTable(Ns, times, opCounts);
    }


    public static void timeLinkedListDequeRemoveLast() {
        int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 1000000};
        int[] opCounts = new int[Ns.length];
        double[] times = new double[Ns.length];

        for (int i = 0; i < Ns.length; i++) {
            // Construction of varied size Deque
            LinkedListDeque<String> lld = new LinkedListDeque<>();
            for (int j = 0; j < Ns[i]; j++) {
                lld.addLast("a");
            }

            opCounts[i] = Ns[i];
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < opCounts[i]; j++) {
                lld.removeLast();
            }
            times[i] = sw.elapsedTime();
        }
        printTimingTable(Ns, times, opCounts);
    }

    public static void timeLinkedListDequeGet() {
        int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 1000000};
        int[] opCounts = new int[Ns.length];
        double[] times = new double[Ns.length];

        for (int i = 0; i < Ns.length; i++) {
            // Construction of varied size Deque
            LinkedListDeque<String> lld = new LinkedListDeque<>();
            for (int j = 0; j < Ns[i]; j++) {
                lld.addLast("a");
            }

            opCounts[i] = 1000;
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < opCounts[i]; j++) {
                lld.get(Ns[i]/2);
                // lld.get(1000);
            }
            times[i] = sw.elapsedTime();
        }
        printTimingTable(Ns, times, opCounts);
    }

    public static void timeLinkedListDequeGetRecursive() {
        int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 1000000};
        int[] opCounts = new int[Ns.length];
        double[] times = new double[Ns.length];

        for (int i = 0; i < Ns.length; i++) {
            // Construction of varied size Deque
            LinkedListDeque<String> lld = new LinkedListDeque<>();
            for (int j = 0; j < Ns[i]; j++) {
                lld.addLast("a");
            }

            opCounts[i] = 1000;
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < opCounts[i]; j++) {
                // lld.getRecursive(Ns[i]/2); StackOverflowError
                lld.getRecursive(1000);
            }
            times[i] = sw.elapsedTime();
        }
        printTimingTable(Ns, times, opCounts);
    }

}
