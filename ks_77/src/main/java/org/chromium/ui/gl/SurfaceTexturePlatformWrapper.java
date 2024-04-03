package org.chromium.ui.gl;

import android.graphics.SurfaceTexture;
import android.util.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("gl")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/gl/SurfaceTexturePlatformWrapper.class */
class SurfaceTexturePlatformWrapper {
    private static final String TAG = "SurfaceTexturePlatformWrapper";

    SurfaceTexturePlatformWrapper() {
    }

    @CalledByNative
    private static SurfaceTexture create(int textureId) {
        return new SurfaceTexture(textureId);
    }

    @CalledByNative
    private static void destroy(SurfaceTexture surfaceTexture) {
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
    }

    @CalledByNative
    private static void setFrameAvailableCallback(SurfaceTexture surfaceTexture, long nativeSurfaceTextureListener) {
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTextureListener(nativeSurfaceTextureListener));
    }

    @CalledByNative
    private static void updateTexImage(SurfaceTexture surfaceTexture) {
        try {
            surfaceTexture.updateTexImage();
        } catch (RuntimeException e) {
            Log.e(TAG, "Error calling updateTexImage", e);
        }
    }

    @CalledByNative
    private static void getTransformMatrix(SurfaceTexture surfaceTexture, float[] matrix) {
        surfaceTexture.getTransformMatrix(matrix);
    }

    @CalledByNative
    private static void attachToGLContext(SurfaceTexture surfaceTexture, int texName) {
        surfaceTexture.attachToGLContext(texName);
    }

    @CalledByNative
    private static void detachFromGLContext(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
    }

    @CalledByNative
    private static void release(SurfaceTexture surfaceTexture) {
        surfaceTexture.release();
    }

    @CalledByNative
    private static void setDefaultBufferSize(SurfaceTexture surfaceTexture, int width, int height) {
        surfaceTexture.setDefaultBufferSize(width, height);
    }
}
