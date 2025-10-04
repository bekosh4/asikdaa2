package metrics;

import java.util.concurrent.atomic.AtomicLong;

public final class PerformanceTracker {
    private static final ThreadLocal<PerformanceTracker> TL = ThreadLocal.withInitial(PerformanceTracker::new);
    public static PerformanceTracker current() { return TL.get(); }
    public static void reset() { TL.set(new PerformanceTracker()); }

    public final AtomicLong comparisons = new AtomicLong();
    public final AtomicLong swaps = new AtomicLong();
    public final AtomicLong moves = new AtomicLong();
    public final AtomicLong arrayAccesses = new AtomicLong();
    public final AtomicLong allocations = new AtomicLong();
    public final AtomicLong recursionDepth = new AtomicLong();
    public final AtomicLong maxDepth = new AtomicLong();

    public void compare() { comparisons.incrementAndGet(); }
    public void swap() { swaps.incrementAndGet(); moves.addAndGet(3); }
    public void move(long k) { moves.addAndGet(k); }
    public void access(long k) { arrayAccesses.addAndGet(k); }
    public void alloc(long k) { allocations.addAndGet(k); }

    public void enterFrame(long d) {
        recursionDepth.set(d);
        maxDepth.set(Math.max(maxDepth.get(), d));
    }

    public String toCsvRow(String algo, int n, long ms, String dist) {
        return String.join(",", algo, dist, Integer.toString(n), Long.toString(ms),
                Long.toString(comparisons.get()), Long.toString(swaps.get()),
                Long.toString(moves.get()), Long.toString(arrayAccesses.get()),
                Long.toString(allocations.get()), Long.toString(maxDepth.get()));
    }

    public static String csvHeader() {
        return "algo,input_dist,n,time_ms,comparisons,swaps,moves,array_accesses,allocations,depth";
    }
}
