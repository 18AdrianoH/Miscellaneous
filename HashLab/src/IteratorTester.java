import java.util.*;
public class IteratorTester {
    private static final boolean DEBUG = true;
    public static void main(String args[]) {
        Set<Integer> real = new HashSet<Integer>();
        MyHashSet<Integer> fake = new MyHashSet<Integer>();

        Iterator realIt;
        Iterator fakeIt;

        for (int i = 0; i < 1000; i++) {
            int value = random(100);

            real.add(value);
            fake.add(value);
            
            debug("Real: " + real);
            debug("Fake: " + fake);

            realIt = real.iterator();
            fakeIt = fake.iterator();

            int n = random(2); // doesn't test remove yet
            if (n == 0) { //hasNext() only
            	if(realIt.hasNext() != fakeIt.hasNext())
            	{
            		System.out.println("real has next is " + realIt.hasNext());
            		System.out.println("fake has next is " + fakeIt.hasNext());
            		throw new RuntimeException("has next does not match");
            	}
            	
                try {
                    while (realIt.hasNext()) {
                        realIt.next();
                        fakeIt.next();
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException("There's something wrong with "
                        + "hasNext(). FIX IT.");
                }
            }
            
            
            
            else if (n == 1) { //next() and hasNext()
            	if(realIt.hasNext() != fakeIt.hasNext())
            	{
            		System.out.println("real has next is " + realIt.hasNext());
            		System.out.println("fake has next is " + fakeIt.hasNext());
            		throw new RuntimeException("has next does not match");
            	}
            	
                Set<Integer> realSet = new HashSet<Integer>();
                while (realIt.hasNext())
                    realSet.add((Integer)realIt.next());
                Set<Integer> fakeSet = new HashSet<Integer>();
                while (fakeIt.hasNext())
                    fakeSet.add((Integer)fakeIt.next());
                    
                    debug("" + realSet);
                    debug("" + fakeSet);

                if (!realSet.equals(fakeSet))
                    throw new RuntimeException("next() returns the wrong "
                        + "set of numbers");
            }
            else if (n == 2) { //remove() and hasNext()
                while (realIt.hasNext()) {
                	//check hasNext
                	if(realIt.hasNext() != fakeIt.hasNext())
                	{
                		System.out.println("real has next is " + realIt.hasNext());
                		System.out.println("fake has next is " + fakeIt.hasNext());
                		throw new RuntimeException("has next does not match");
                	}
                    realIt.next();
                    fakeIt.next();

                    int remove = random(2);
                    if (remove == 0) {
                        realIt.remove();
                        fakeIt.remove();
                    }
                }
            }

            int realSize = real.size();
            int fakeSize = fake.size();
            if (realSize != fakeSize)
                throw new RuntimeException("Size should be " + realSize
                    + " but returned " + fakeSize);

            debug("");
        }
        System.out.println("Congratulations! Your tester works.");
    }

    private static void debug(String s) {
        if (DEBUG)
            System.out.println(s);
    }

    private static int random(int n) {
        return (int)(n * Math.random());
    }
}