package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureDeviceInfo.class */
public final class VideoCaptureDeviceInfo extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public VideoCaptureDeviceDescriptor descriptor;
    public VideoCaptureFormat[] supportedFormats;

    private VideoCaptureDeviceInfo(int version) {
        super(24, version);
    }

    public VideoCaptureDeviceInfo() {
        this(0);
    }

    public static VideoCaptureDeviceInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoCaptureDeviceInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureDeviceInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoCaptureDeviceInfo result = new VideoCaptureDeviceInfo(elementsOrVersion);
            result.descriptor = VideoCaptureDeviceDescriptor.decode(decoder0.readPointer(8, false));
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.supportedFormats = new VideoCaptureFormat[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.supportedFormats[i1] = VideoCaptureFormat.decode(decoder2);
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
        encoder0.encode((Struct) this.descriptor, 8, false);
        if (this.supportedFormats == null) {
            encoder0.encodeNullPointer(16, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.supportedFormats.length, 16, -1);
        for (int i0 = 0; i0 < this.supportedFormats.length; i0++) {
            encoder1.encode((Struct) this.supportedFormats[i0], 8 + (8 * i0), false);
        }
    }
}
