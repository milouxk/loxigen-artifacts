# Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
# Copyright (c) 2011, 2012 Open Networking Foundation
# Copyright (c) 2012, 2013 Big Switch Networks, Inc.
# See the file LICENSE.pyloxi which should have been included in the source distribution
# Automatically generated by LOXI from template util.py
# Do not modify

import struct
import loxi
import const
import common
import action
import instruction
import oxm
import meter_band

def pretty_mac(mac):
    return ':'.join(["%02x" % x for x in mac])

def pretty_ipv4(v):
    return "%d.%d.%d.%d" % ((v >> 24) & 0xFF, (v >> 16) & 0xFF, (v >> 8) & 0xFF, v & 0xFF)

def pretty_flags(v, flag_names):
    set_flags = []
    for flag_name in flag_names:
        flag_value = getattr(const, flag_name)
        if v & flag_value == flag_value:
            set_flags.append(flag_name)
        elif v & flag_value:
            set_flags.append('%s&%#x' % (flag_name, v & flag_value))
        v &= ~flag_value
    if v:
        set_flags.append("%#x" % v)
    return '|'.join(set_flags) or '0'


def pretty_port(v):
    named_ports = [(k,v2) for (k,v2) in const.__dict__.iteritems() if k.startswith('OFPP_')]
    for (k, v2) in named_ports:
        if v == v2:
            return k
    return v

def pack_port_no(value):
    return struct.pack("!L", value)

def unpack_port_no(reader):
    return reader.read("!L")[0]

def pack_fm_cmd(value):
    return struct.pack("!B", value)

def unpack_fm_cmd(reader):
    return reader.read("!B")[0]

def init_wc_bmap():
    return 0

def pack_wc_bmap(value):
    return struct.pack("!Q", value)

def unpack_wc_bmap(reader):
    return reader.read("!Q")[0]

def init_match_bmap():
    return 0

def pack_match_bmap(value):
    return struct.pack("!Q", value)

def unpack_match_bmap(reader):
    return reader.read("!Q")[0]

MASK64 = (1 << 64) - 1

def pack_bitmap_128(value):
    x = 0l
    for y in value:
        x |= 1 << y
    return struct.pack("!QQ", (x >> 64) & MASK64, x & MASK64)

def unpack_bitmap_128(reader):
    hi, lo = reader.read("!QQ")
    x = (hi << 64) | lo
    i = 0
    value = set()
    while x != 0:
        if x & 1 == 1:
            value.add(i)
        i += 1
        x >>= 1
    return value

def unpack_list_hello_elem(reader):
    def deserializer(reader):
        typ, length, = reader.peek('!HH')
        reader = reader.slice(length)
        try:
            return common.hello_elem.unpack(reader)
        except loxi.ProtocolError:
            return None
    return [x for x in loxi.generic_util.unpack_list(reader, deserializer) if x != None]
