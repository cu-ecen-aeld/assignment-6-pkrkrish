#!/bin/bash
source poky/oe-init-build-env build
runqemu qemux86-64 nographic slirp
