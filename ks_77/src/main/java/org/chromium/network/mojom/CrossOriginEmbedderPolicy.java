package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CrossOriginEmbedderPolicy.class */
public final class CrossOriginEmbedderPolicy {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NONE = 0;
    public static final int REQUIRE_CORP = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CrossOriginEmbedderPolicy() {
    }
}
