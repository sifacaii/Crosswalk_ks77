package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/VideoDecodeAcceleratorCapabilities.class */
public final class VideoDecodeAcceleratorCapabilities extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public VideoDecodeAcceleratorSupportedProfile[] supportedProfiles;
    public int flags;

    private VideoDecodeAcceleratorCapabilities(int version) {
        super(24, version);
    }

    public VideoDecodeAcceleratorCapabilities() {
        this(0);
    }

    public static VideoDecodeAcceleratorCapabilities deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoDecodeAcceleratorCapabilities deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecodeAcceleratorCapabilities decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoDecodeAcceleratorCapabilities result = new VideoDecodeAcceleratorCapabilities(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.supportedProfiles = new VideoDecodeAcceleratorSupportedProfile[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.supportedProfiles[i1] = VideoDecodeAcceleratorSupportedProfile.decode(decoder2);
            }
            result.flags = decoder0.readInt(16);
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
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        if (this.supportedProfiles == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.supportedProfiles.length, 8, -1);
            for (int i0 = 0; i0 < this.supportedProfiles.length; i0++) {
                encoder1.encode((Struct) this.supportedProfiles[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.flags, 16);
    }
}
