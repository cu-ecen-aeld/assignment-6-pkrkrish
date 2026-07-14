DESCRIPTION = "AESD Assignment 6 - aesdsocket server"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/cu-ecen-aeld/assignments-3-and-later-pkrkrish.git;protocol=ssh;branch=main"
SRCREV = "84896484b1d6ac74cdc90d79ac012a223dd1d846"

PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git/server"

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "aesdsocket-start-stop.sh"
INITSCRIPT_PARAMS:${PN} = "defaults 99"

FILES:${PN} += "${bindir}/aesdsocket \
                ${sysconfdir}/init.d/aesdsocket-start-stop.sh \
               "

TARGET_LDFLAGS += "-pthread -lrt"

do_configure() {
    :
}

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}/init.d

    install -m 755 ${S}/aesdsocket ${D}${bindir}/aesdsocket
    install -m 755 ${S}/aesdsocket-start-stop.sh ${D}${sysconfdir}/init.d/aesdsocket-start-stop.sh
}