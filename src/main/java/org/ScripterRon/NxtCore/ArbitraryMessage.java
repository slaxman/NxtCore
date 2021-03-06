/*
 * Copyright 2014 Ronald Hoffman.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ScripterRon.NxtCore;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Attachment for TransactionType.Messaging.ARBITRARY_MESSAGE
 */
public class ArbitraryMessage extends AbstractAttachment {

    /** Version */
    private final int version;

    /** Message */
    private byte[] message;

    /** Text message */
    private boolean textMessage;

    /**
     * Create an Arbitrary Message attachment
     *
     * @param       message                 Message (max 1000 bytes)
     */
    public ArbitraryMessage(byte[] message) {
        if (message == null)
            throw new IllegalArgumentException("No message specified");
        if (message.length > 1000)
            throw new IllegalArgumentException("Maximum message length is 1000 bytes");
        this.version = 1;
        this.message = message;
        this.textMessage = false;
    }

    /**
     * Create an Arbitrary Message attachment
     *
     * @param       message                         Message (max 1000 bytes)
     */
    public ArbitraryMessage(String message) {
        if (message == null)
            throw new IllegalArgumentException("No message specified");
        if (message.length() > 1000)
            throw new IllegalArgumentException("Maximum message length is 1000 bytes");
        try {
            this.message = message.getBytes("UTF-8");
            this.textMessage = true;
        } catch (UnsupportedEncodingException exc) {
            this.message = new byte[0];
            this.textMessage = false;
        }
        this.version = 1;
    }

    /**
     * Create an Arbitrary Message attachment from the JSON response
     *
     * @param       response                        JSON response
     * @throws      NumberFormatException           Invalid numeric string
     * @throws      NxtException                    Invalid response
     */
    public ArbitraryMessage(PeerResponse response) throws NumberFormatException, NxtException {
        version = response.getByte("version.Message");
        if (response.getBoolean("messageIsText")) {
            try {
                message = response.getString("message").getBytes("UTF-8");
                textMessage = true;
            } catch (UnsupportedEncodingException exc) {
                message = new byte[0];
                textMessage = false;
            }
        } else {
            message = response.getHexString("message");
            if (message == null)
                message = new byte[0];
            textMessage = false;
        }
    }

    /**
     * Return the transaction flags
     *
     * @return                              Transaction flags
     */
    @Override
    public int getFlags() {
        return (version>0 ? Transaction.TX_MESSAGE : 0);
    }

    /**
     * Return the attachment byte stream
     *
     * @return                              Byte stream
     */
    @Override
    public byte[] getBytes() {
        byte[] bytes = new byte[(version>0?1:0)+4+message.length];
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        if (version > 0)
            buf.put((byte)version);
        buf.putInt(message.length | (textMessage ? 0x80000000 : 0));
        buf.put(message);
        return bytes;
    }

    /**
     * Return the attachment version
     *
     * @return                              Version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Return the message
     *
     * @return                              Message
     */
    public byte[] getMessage() {
        return message;
    }

    /**
     * Check if this is a text message
     *
     * @return                              TRUE if this is a text message
     */
    public boolean isTextMessage() {
        return textMessage;
    }
}
