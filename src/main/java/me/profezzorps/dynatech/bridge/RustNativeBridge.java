package me.profezzorps.dynatech.bridge;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Optional Java 21 Project Panama bridge.
 *
 * <p>The FFM API is preview-only on Java 21. Keeping its types out of this
 * class' signature prevents DynaTech from becoming unloadable on servers that
 * intentionally do not start the JVM with {@code --enable-preview}.</p>
 */
public final class RustNativeBridge {
    private static final Logger LOGGER = Logger.getLogger("DynaTech-RustBridge");
    private static boolean isNativeLoaded = false;
    private static MethodHandle solveEnergyTickMH;

    public static void initialize(Path nativeLibPath) {
        try {
            System.load(nativeLibPath.toAbsolutePath().toString());
            Class<?> symbolLookupClass = Class.forName("java.lang.foreign.SymbolLookup");
            Class<?> linkerClass = Class.forName("java.lang.foreign.Linker");
            Class<?> memorySegmentClass = Class.forName("java.lang.foreign.MemorySegment");
            Class<?> memoryLayoutClass = Class.forName("java.lang.foreign.MemoryLayout");
            Class<?> functionDescriptorClass = Class.forName("java.lang.foreign.FunctionDescriptor");
            Class<?> linkerOptionClass = Class.forName("java.lang.foreign.Linker$Option");

            Object lookup = symbolLookupClass.getMethod("loaderLookup").invoke(null);
            Object linker = linkerClass.getMethod("nativeLinker").invoke(null);
            Object found = lookup.getClass().getMethod("find", String.class)
                .invoke(lookup, "slimefun_solve_energy_tick");
            Object symbol = ((Optional<?>) found).orElse(null);
            if (symbol != null) {
                Object javaLong = Class.forName("java.lang.foreign.ValueLayout")
                    .getField("JAVA_LONG").get(null);
                Object emptyLayouts = Array.newInstance(memoryLayoutClass, 0);
                Object descriptor = functionDescriptorClass
                    .getMethod("of", memoryLayoutClass, emptyLayouts.getClass())
                    .invoke(null, javaLong, emptyLayouts);
                Object emptyOptions = Array.newInstance(linkerOptionClass, 0);
                solveEnergyTickMH = (MethodHandle) linkerClass
                    .getMethod("downcallHandle", memorySegmentClass, functionDescriptorClass, emptyOptions.getClass())
                    .invoke(linker, symbol, descriptor, emptyOptions);
                isNativeLoaded = true;
                LOGGER.info("[INFO] [DynaTech] Rust FFM bridge bound successfully.");
            }
        } catch (Throwable t) {
            LOGGER.fine("[INFO] [DynaTech] Optional Rust bridge unavailable: " + t.getMessage());
        }
    }

    public static long solveEnergyTick() {
        if (isNativeLoaded && solveEnergyTickMH != null) {
            try {
                return (long) solveEnergyTickMH.invokeExact();
            } catch (Throwable ignored) {}
        }
        return 0;
    }

    public static boolean isNativeLoaded() {
        return isNativeLoaded;
    }
}
