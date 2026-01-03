# Recipe for aesd-assignments
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Use HTTPS for stability
SRC_URI = "git://github.com/cu-ecen-aeld/assignment-6-pkrkrish.git;protocol=https;branch=master"

# Hardcode the SRCREV. Replace the hash below with the one from your 'git ls-remote' command
SRCREV = "2d6998498659b0410eaf4747d7fcdb6b09fef33b"

# Hardcode PV to 1.0. Removing ${SRCPV} prevents the ExpansionError
PV = "1.0"

S = "${WORKDIR}/git/server"

FILES:${PN} += "${bindir}/aesdsocket"
TARGET_LDFLAGS += "-pthread -lrt"

do_configure () {
    :
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/

    # If you have the init script from assignment 5/6:
    install -d ${D}${sysconfdir}/init.d
    # install -m 0755 ${S}/S99aesdsocket ${D}${sysconfdir}/init.d/
}
