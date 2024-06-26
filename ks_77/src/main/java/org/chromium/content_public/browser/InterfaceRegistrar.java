package org.chromium.content_public.browser;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.services.service_manager.InterfaceRegistry;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/InterfaceRegistrar.class */
public interface InterfaceRegistrar<ParamType> {
    void registerInterfaces(InterfaceRegistry interfaceRegistry, ParamType paramtype);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/InterfaceRegistrar$Registry.class */
    public static class Registry<ParamType> {
        private static Registry<Context> sContextRegistry;
        private static Registry<WebContents> sWebContentsRegistry;
        private static Registry<RenderFrameHost> sRenderFrameHostRegistry;
        private List<InterfaceRegistrar<ParamType>> mRegistrars = new ArrayList();

        public static void applyContextRegistrars(InterfaceRegistry interfaceRegistry) {
            if (sContextRegistry == null) {
                return;
            }
            sContextRegistry.applyRegistrars(interfaceRegistry, ContextUtils.getApplicationContext());
        }

        public static void applyWebContentsRegistrars(InterfaceRegistry interfaceRegistry, WebContents webContents) {
            if (sWebContentsRegistry == null) {
                return;
            }
            sWebContentsRegistry.applyRegistrars(interfaceRegistry, webContents);
        }

        public static void applyRenderFrameHostRegistrars(InterfaceRegistry interfaceRegistry, RenderFrameHost renderFrameHost) {
            if (sRenderFrameHostRegistry == null) {
                return;
            }
            sRenderFrameHostRegistry.applyRegistrars(interfaceRegistry, renderFrameHost);
        }

        public static void addContextRegistrar(InterfaceRegistrar<Context> registrar) {
            if (sContextRegistry == null) {
                sContextRegistry = new Registry<>();
            }
            sContextRegistry.addRegistrar(registrar);
        }

        public static void addWebContentsRegistrar(InterfaceRegistrar<WebContents> registrar) {
            if (sWebContentsRegistry == null) {
                sWebContentsRegistry = new Registry<>();
            }
            sWebContentsRegistry.addRegistrar(registrar);
        }

        public static void addRenderFrameHostRegistrar(InterfaceRegistrar<RenderFrameHost> registrar) {
            if (sRenderFrameHostRegistry == null) {
                sRenderFrameHostRegistry = new Registry<>();
            }
            sRenderFrameHostRegistry.addRegistrar(registrar);
        }

        private Registry() {
        }

        private void addRegistrar(InterfaceRegistrar<ParamType> registrar) {
            this.mRegistrars.add(registrar);
        }

        private void applyRegistrars(InterfaceRegistry interfaceRegistry, ParamType param) {
            for (InterfaceRegistrar<ParamType> registrar : this.mRegistrars) {
                registrar.registerInterfaces(interfaceRegistry, param);
            }
        }
    }
}
