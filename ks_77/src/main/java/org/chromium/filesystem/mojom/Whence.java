package org.chromium.filesystem.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Whence.class */
public final class Whence {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int FROM_BEGIN = 0;
    public static final int FROM_CURRENT = 1;
    public static final int FROM_END = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private Whence() {
    }
}
