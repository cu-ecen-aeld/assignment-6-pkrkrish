#!/bin/bash

source poky/oe-init-build-env build

# Append correctly formatted, comma-separated hostfwd rules
export QB_SLIRP_OPT="-netdev user,id=net0,hostfwd=tcp::10022-:22,hostfwd=tcp::9000-:9000"
export OE_QEMU_NO_SSH=1
runqemu qemuarm64 slirp nographic