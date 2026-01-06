LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignments-3-and-later-pkrkrish.git;protocol=ssh;branch=main"
SRCREV = "9fc616de78a29703dee27d81afa4c56b4e26862d"

PV = "1.0"
S = "${WORKDIR}/git/server"

# 1. Inherit the class that handles System V init scripts
inherit update-rc.d

# 2. Configure the startup script name and package
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "aesdsocket-start-stop"

FILES:${PN} += "${bindir}/aesdsocket"
# 3. Add the init script path to the files list
FILES:${PN} += "${sysconfdir}/init.d/aesdsocket-start-stop"

TARGET_LDFLAGS += "-pthread -lrt"

do_configure () {
    :
}

do_compile () {
    oe_runmake
}

do_install () {
    # Install the binary
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/

    # 4. Install the init script (matches your GitHub filename)
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/aesdsocket-start-stop
}
