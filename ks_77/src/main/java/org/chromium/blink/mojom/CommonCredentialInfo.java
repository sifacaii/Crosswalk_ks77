package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CommonCredentialInfo.class */
public final class CommonCredentialInfo extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String id;
    public byte[] rawId;
    public byte[] clientDataJson;

    private CommonCredentialInfo(int version) {
        super(32, version);
    }

    public CommonCredentialInfo() {
        this(0);
    }

    public static CommonCredentialInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CommonCredentialInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CommonCredentialInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CommonCredentialInfo result = new CommonCredentialInfo(elementsOrVersion);
            result.id = decoder0.readString(8, false);
            result.rawId = decoder0.readBytes(16, 0, -1);
            result.clientDataJson = decoder0.readBytes(24, 0, -1);
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
        encoder0.encode(this.id, 8, false);
        encoder0.encode(this.rawId, 16, 0, -1);
        encoder0.encode(this.clientDataJson, 24, 0, -1);
    }
}
