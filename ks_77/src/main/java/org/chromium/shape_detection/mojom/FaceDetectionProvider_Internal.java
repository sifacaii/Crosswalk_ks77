package org.chromium.shape_detection.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.shape_detection.mojom.FaceDetectionProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetectionProvider_Internal.class */
class FaceDetectionProvider_Internal {
    public static final Interface.Manager<FaceDetectionProvider, FaceDetectionProvider.Proxy> MANAGER = new Interface.Manager<FaceDetectionProvider, FaceDetectionProvider.Proxy>() { // from class: org.chromium.shape_detection.mojom.FaceDetectionProvider_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "shape_detection.mojom.FaceDetectionProvider";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public FaceDetectionProvider.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, FaceDetectionProvider impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public FaceDetectionProvider[] buildArray(int size) {
            return new FaceDetectionProvider[size];
        }
    };
    private static final int CREATE_FACE_DETECTION_ORDINAL = 0;

    FaceDetectionProvider_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetectionProvider_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements FaceDetectionProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.shape_detection.mojom.FaceDetectionProvider
        public void createFaceDetection(InterfaceRequest<FaceDetection> request, FaceDetectorOptions options) {
            FaceDetectionProviderCreateFaceDetectionParams _message = new FaceDetectionProviderCreateFaceDetectionParams();
            _message.request = request;
            _message.options = options;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetectionProvider_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<FaceDetectionProvider> {
        Stub(Core core, FaceDetectionProvider impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FaceDetectionProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        FaceDetectionProviderCreateFaceDetectionParams data = FaceDetectionProviderCreateFaceDetectionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createFaceDetection(data.request, data.options);
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), FaceDetectionProvider_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.class */
    static final class FaceDetectionProviderCreateFaceDetectionParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<FaceDetection> request;
        public FaceDetectorOptions options;

        private FaceDetectionProviderCreateFaceDetectionParams(int version) {
            super(24, version);
        }

        public FaceDetectionProviderCreateFaceDetectionParams() {
            this(0);
        }

        public static FaceDetectionProviderCreateFaceDetectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FaceDetectionProviderCreateFaceDetectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FaceDetectionProviderCreateFaceDetectionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                FaceDetectionProviderCreateFaceDetectionParams result = new FaceDetectionProviderCreateFaceDetectionParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.options = FaceDetectorOptions.decode(decoder1);
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
            encoder0.encode((InterfaceRequest) this.request, 8, false);
            encoder0.encode((Struct) this.options, 16, false);
        }
    }
}
