package net.nunnerycode.bukkit.libraries.ivory.math;

public class IvoryRandom {

    private static final long A = 25214903917L;
    private static final long C = 11L;
    private long previous = 0;

    public IvoryRandom() {
        this(System.currentTimeMillis());
    }

    public IvoryRandom(long seed) {
        previous = seed;
    }

    public double nextDouble() {
        long significand = 0;
        double divisor = 1;

        while (true) {
            int leadingZeros = Long.numberOfLeadingZeros(significand);
            int usefulBits = 64 - leadingZeros;
            int pendingBits = 53 - usefulBits;
            if (pendingBits == 0) {
                break;
            }

            int bits = Math.min(pendingBits, 30);
            significand = (significand << bits) + next(bits);
            divisor = divisor / (1 << bits);
        }

        return significand * divisor;
    }

    public int next(int amount) {
        long r = A * previous + C;
        previous = r;
        return (int) r;
    }

    public long nextLong(long amount) {
        long r = A * previous + C;
        previous = r;
        return r;
    }

}
