package org.chromium.shape_detection.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectorOptions.class */
public final class BarcodeDetectorOptions extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int[] formats;

    private BarcodeDetectorOptions(int version) {
        super(16, version);
    }

    public BarcodeDetectorOptions() {
        this(0);
    }

    public static BarcodeDetectorOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BarcodeDetectorOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BarcodeDetectorOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BarcodeDetectorOptions result = new BarcodeDetectorOptions(elementsOrVersion);
            result.formats = decoder0.readInts(8, 0, -1);
            for (int i0 = 0; i0 < result.formats.length; i0++) {
                BarcodeFormat.validate(result.formats[i0]);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.formats, 8, 0, -1);
    }
}
