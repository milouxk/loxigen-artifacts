// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template unit_test.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver13;

import org.projectfloodlight.openflow.protocol.*;
import org.projectfloodlight.openflow.protocol.action.*;
import org.projectfloodlight.openflow.protocol.actionid.*;
import org.projectfloodlight.openflow.protocol.errormsg.*;
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
import org.projectfloodlight.openflow.protocol.instructionid.*;
import org.projectfloodlight.openflow.protocol.match.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import com.google.common.collect.ImmutableList;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.hamcrest.CoreMatchers;



public class OFBsnGentableBucketStatsReplyVer13Test {
    OFFactory factory;

    final static byte[] BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED =
        new byte[] { 0x4, 0x13, 0x0, 0x38, 0x12, 0x34, 0x56, 0x78, (byte) 0xff, (byte) 0xff, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x5c, 0x16, (byte) 0xc7, 0x0, 0x0, 0x0, 0x5, (byte) 0x88, 0x77, 0x66, 0x55, 0x44, 0x33, 0x22, 0x11, (byte) 0xff, (byte) 0xee, (byte) 0xdd, (byte) 0xcc, (byte) 0xbb, (byte) 0xaa, (byte) 0x99, (byte) 0x88, 0x12, 0x34, 0x23, 0x45, 0x34, 0x56, 0x45, 0x67, 0x56, 0x78, 0x67, (byte) 0x89, 0x78, (byte) 0x9a, (byte) 0x89, (byte) 0xab };

    @Before
    public void setup() {
        factory = OFFactoryVer13.INSTANCE;
    }

    @Test
    public void testWrite() {
        OFBsnGentableBucketStatsReply.Builder builder = factory.buildBsnGentableBucketStatsReply();
        builder.setXid(0x12345678)
    .setEntries(
        ImmutableList.<OFBsnGentableBucketStatsEntry>of(
            factory.bsnGentableBucketStatsEntry(OFChecksum128.of(0x8877665544332211L, 0xFFEEDDCCBBAA9988L)),
            factory.bsnGentableBucketStatsEntry(OFChecksum128.of(0x1234234534564567L, 0x56786789789A89ABL))
        )
    );
        OFBsnGentableBucketStatsReply bsnGentableBucketStatsReply = builder.build();
        ChannelBuffer bb = ChannelBuffers.dynamicBuffer();
        bsnGentableBucketStatsReply.writeTo(bb);
        byte[] written = new byte[bb.readableBytes()];
        bb.readBytes(written);

        assertThat(written, CoreMatchers.equalTo(BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED));
    }

    @Test
    public void testRead() throws Exception {
        OFBsnGentableBucketStatsReply.Builder builder = factory.buildBsnGentableBucketStatsReply();
        builder.setXid(0x12345678)
    .setEntries(
        ImmutableList.<OFBsnGentableBucketStatsEntry>of(
            factory.bsnGentableBucketStatsEntry(OFChecksum128.of(0x8877665544332211L, 0xFFEEDDCCBBAA9988L)),
            factory.bsnGentableBucketStatsEntry(OFChecksum128.of(0x1234234534564567L, 0x56786789789A89ABL))
        )
    );
        OFBsnGentableBucketStatsReply bsnGentableBucketStatsReplyBuilt = builder.build();

        ChannelBuffer input = ChannelBuffers.copiedBuffer(BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED);

        // FIXME should invoke the overall reader once implemented
        OFBsnGentableBucketStatsReply bsnGentableBucketStatsReplyRead = OFBsnGentableBucketStatsReplyVer13.READER.readFrom(input);
        assertEquals(BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED.length, input.readerIndex());

        assertEquals(bsnGentableBucketStatsReplyBuilt, bsnGentableBucketStatsReplyRead);
   }

   @Test
   public void testReadWrite() throws Exception {
       ChannelBuffer input = ChannelBuffers.copiedBuffer(BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED);

       // FIXME should invoke the overall reader once implemented
       OFBsnGentableBucketStatsReply bsnGentableBucketStatsReply = OFBsnGentableBucketStatsReplyVer13.READER.readFrom(input);
       assertEquals(BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED.length, input.readerIndex());

       // write message again
       ChannelBuffer bb = ChannelBuffers.dynamicBuffer();
       bsnGentableBucketStatsReply.writeTo(bb);
       byte[] written = new byte[bb.readableBytes()];
       bb.readBytes(written);

       assertThat(written, CoreMatchers.equalTo(BSN_GENTABLE_BUCKET_STATS_REPLY_SERIALIZED));
   }

}
