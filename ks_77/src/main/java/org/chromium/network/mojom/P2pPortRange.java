package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pPortRange.class */
public final class P2pPortRange extends Struct {
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    private P2pPortRange(int version) {
        super(8, version);
    }

    public P2pPortRange() {
        this(0);
    }

    public static P2pPortRange deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static P2pPortRange deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static P2pPortRange decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            P2pPortRange result = new P2pPortRange(elementsOrVersion);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
}