/*
 *       _   _____            _      _   _          _
 *      | | |  __ \          | |    | \ | |        | |
 *      | | | |__) |   __ _  | | __ |  \| |   ___  | |_
 *  _   | | |  _  /   / _` | | |/ / | . ` |  / _ \ | __|
 * | |__| | | | \ \  | (_| | |   <  | |\  | |  __/ | |_
 *  \____/  |_|  \_\  \__,_| |_|\_\ |_| \_|  \___|  \__|
 *
 * the MIT License (MIT)
 *
 * Copyright (c) 2016-2019 Trent Summerlin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * the above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.whirvis.jraknet.protocol.login;

import com.whirvis.jraknet.Packet;
import com.whirvis.jraknet.RakNetPacket;
import com.whirvis.jraknet.protocol.MessageIdentifier;

/**
 * An {@link com.whirvis.jraknet.protocol.MessageIdentifier#ID_CONNECTION_BANNED
 * ID_CONNECTION_BANNED} packet. This is sent by the server during client login
 * if the client has been banned from connecting to the server.
 * 
 * @author Trent Summerlin
 * @since JRakNet v1.0.0
 * @see com.whirvis.jraknet.protocol.MessageIdentifier#ID_CONNECTION_BANNED
 *      ID_CONNECTION_BANNED
 */
public class ConnectionBanned extends RakNetPacket {

	/**
	 * The server's globally unique identifier.
	 */
	public long serverGuid;

	/**
	 * Creates an
	 * {@link com.whirvis.jraknet.protocol.MessageIdentifier#ID_CONNECTION_BANNED
	 * ID_CONNECTION_BANNED} packet to be encoded.
	 * 
	 * @see #encode()
	 */
	public ConnectionBanned() {
		super(MessageIdentifier.ID_CONNECTION_BANNED);
	}

	/**
	 * Creates an
	 * {@link com.whirvis.jraknet.protocol.MessageIdentifier#ID_CONNECTION_BANNED
	 * ID_CONNECTION_BANNED} packet to be decoded.
	 * 
	 * @param packet
	 *            the original packet whose data will be read from in the
	 *            {@link #decode()} method.
	 * @see #decode()
	 */
	public ConnectionBanned(Packet packet) {
		super(packet);
	}

	@Override
	public void encode() {
		this.writeLong(serverGuid);
	}

	@Override
	public void decode() {
		this.serverGuid = this.readLong();
	}

}
