package com.common_creation.applet.helloworld;

import javacard.framework.*;
import uicc.toolkit.*;

public class HelloWorld extends Applet implements ToolkitInterface, ToolkitConstants {
    private static final byte DCS_8_BIT_DATA = 0x04; //ETSI TS 102223 Clause 8.15.0
    private ToolkitRegistry toolkitRegistry;
    private byte menuId;
    private final byte[] menuText = new byte[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};

    public static void install(byte[] bArray, short bOffset, byte bLength) throws ISOException {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.register();

        helloWorld.toolkitRegistry = ToolkitRegistrySystem.getEntry();
        helloWorld.menuId = helloWorld.toolkitRegistry.initMenuEntry(helloWorld.menuText, (short) 0, (short) helloWorld.menuText.length, (byte) 0, false, (byte) 0, (short) 0);
    }

    private HelloWorld() {

    }

    public Shareable getShareableInterfaceObject(AID clientAID, byte parameter) {
        if (clientAID == null) {
            return this;
        }
        return null;
    }

    @Override
    public void process(APDU apdu) throws ISOException {

    }

    @Override
    public void processToolkit(short event) throws ToolkitException {
        if (event == EVENT_MENU_SELECTION) {
            EnvelopeHandler eh = EnvelopeHandlerSystem.getTheHandler();
            byte selectedId = eh.getItemIdentifier();

            if (selectedId == menuId) {
                this.showHelloWorld();
            }
        }
    }

    private void showHelloWorld() {
        ProactiveHandler ph = ProactiveHandlerSystem.getTheHandler();
        ph.initDisplayText((byte) 0x81, DCS_8_BIT_DATA, menuText, (short) 0, (short) menuText.length);
        ph.send();
    }
}
